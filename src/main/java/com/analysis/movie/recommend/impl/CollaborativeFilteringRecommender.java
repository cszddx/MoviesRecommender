package com.analysis.movie.recommend.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.common.RecommendedMovie;
import com.analysis.movie.entity.Rating;
import com.analysis.movie.entity.Users;
import com.analysis.movie.exception.RecommendationException;
import com.analysis.movie.recommend.api.Recommender;
import com.analysis.movie.service.api.RatingService;
import com.analysis.movie.service.api.SimilarityService;
import com.analysis.movie.service.api.UsersService;
import com.analysis.movie.util.Utilities;

/**
 * This recommender implementation is based on user rating history. Generally, the movie list is from the people who
 * have similar interest with the user we want to recommend to. The recommendation list will exclude movies haven seen
 * by the user we want to recommend to.
 *
 * @author duxin
 *
 */
@Service("cfRecommender")
public class CollaborativeFilteringRecommender implements Recommender {
    @Resource
    private UsersService usersService;
    @Resource
    private RatingService ratingService;
    @Resource
    SimilarityService similarityService;

    @Override
    public List<RecommendedMovie> getRecommendations(long userId) {
        validate(userId);
        // get all similar users of the specified user
        Set<Long> similarUserIds = similarityService.getSimilarUsers(userId);
        // get all Ratings of these similar users
        List<Rating> ratingsBySimilarUsers = ratingService.getRatings(similarUserIds);
        // exclude the movies already seen by the specified user
        List<Rating> ratingsByUser = ratingService.getRatings(userId);
        ratingsBySimilarUsers.removeAll(ratingsByUser);
        // get movies list from rating records
        List<RecommendedMovie> movies = getRecommendedMovies(ratingsBySimilarUsers);

        return movies;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    public void setSimilarityService(SimilarityService similarityService) {
        this.similarityService = similarityService;
    }

    private List<RecommendedMovie> getRecommendedMovies(List<Rating> ratings) {
        List<RecommendedMovie> movies = new ArrayList<RecommendedMovie>();

        // for every movie, get all the ratings to compute average rating
        Map<Long, List<Double>> movieRating = new HashMap<Long, List<Double>>();
        for (Rating rating : ratings) {
            long movieId = rating.getMovie().getMovieId();
            if (movieRating.containsKey(movieId)) {
                movieRating.get(movieId).add(rating.getRating());
            } else {
                List<Double> marks = new ArrayList<Double>();
                marks.add(rating.getRating());
                movieRating.put(movieId, marks);

                RecommendedMovie movie = new RecommendedMovie(rating.getMovie());
                movies.add(movie);
            }
        }

        for (RecommendedMovie movie : movies) {
            List<Double> marks = movieRating.get(movie.getMovieId());
            movie.setCount(marks.size());
            movie.setAvgRating(Utilities.getDoubleSumValue(marks) / movie.getCount());
        }

        return movies;
    }

    private void validate(long userId) {
        Users user = usersService.getUsersInformation(userId);
        if (user == null) {
            throw new RecommendationException("Invalid user id:" + userId);
        }
    }

}
