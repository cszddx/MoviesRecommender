package com.analysis.movie.scheduledjob;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.entity.Rating;
import com.analysis.movie.service.api.RatingService;
import com.analysis.movie.service.api.SimilarityService;
import com.analysis.movie.similarity.api.SimilarityComputer;

/**
 * Compute the top-N Neighbors which are most similar to the specified user
 *
 * @author duxin
 *
 */
@Component
@Scope("prototype")
public class ComputeNeighbors implements Callable<Set<UserSimilarity>> {
    @Resource
    private RatingService ratingService;
    @Resource
    private SimilarityService similarityService;

    private final long userId;
    private final int threshold; // specify how many similar neighbors for every user
    private final SimilarityComputer similarityComputer;

    public ComputeNeighbors(long userId, int threshold, SimilarityComputer similarityComputer) {
        this.userId = userId;
        this.threshold = threshold;
        this.similarityComputer = similarityComputer;
    }

    @Override
    public Set<UserSimilarity> call() {
        Map<Long, Double> ratingsMap = this.getRatings();
        Map<Long, Map<Long, Double>> relatedUsersMap = this.getRelatedUsersMap();

        // compute similarity for every related user
        Set<UserSimilarity> userSimilaritySet = new TreeSet<UserSimilarity>();
        for (Entry<Long, Map<Long, Double>> entry : relatedUsersMap.entrySet()) {
            Long similarUserId = entry.getKey();
            double similarity = similarityComputer.computeSimilarity(ratingsMap, entry.getValue());

            userSimilaritySet.add(new UserSimilarity(userId, similarUserId, similarity));
        }

        // get top n similar users
        Set<UserSimilarity> results = new HashSet<UserSimilarity>();
        int i = threshold;
        for (Iterator<UserSimilarity> it = userSimilaritySet.iterator(); it.hasNext();) {
            if (i <= 0) {
                break;
            }
            results.add(it.next());
            --i;
        }

        // update Similarity table with latest result
        this.similarityService.insertSimilarities(results);

        return results;
    }

    private Map<Long, Double> getRatings() {
        List<Rating> ratings = this.ratingService.getRatings(userId);

        Map<Long, Double> ratingMap = new HashMap<Long, Double>();
        for (Rating r : ratings) {
            ratingMap.put(r.getMovie().getMovieId(), r.getRating());
        }

        return ratingMap;
    }

    private Map<Long, Map<Long, Double>> getRelatedUsersMap() {
        Map<Long, Map<Long, Double>> relatedUsersMap = new HashMap<>();

        List<Rating> ratings = this.ratingService.getRelatedRatings(this.userId);
        for (Rating r : ratings) {
            Long userId = r.getUsers().getUserid();
            if (relatedUsersMap.containsKey(userId)) {
                Map<Long, Double> movieMap = relatedUsersMap.get(userId);
                movieMap.put(r.getMovie().getMovieId(), r.getRating());
            } else {
                Map<Long, Double> movieMap = new HashMap<Long, Double>();
                movieMap.put(r.getMovie().getMovieId(), r.getRating());
                relatedUsersMap.put(userId, movieMap);
            }
        }

        return relatedUsersMap;
    }
    //
    // private RatingService getRatingService() {
    // if (ratingService == null) {
    // @SuppressWarnings("resource")
    // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // ratingService = (RatingService) context.getBean("ratingService");
    //
    // }
    //
    // return ratingService;
    // }
    //
    // private SimilarityService getSimilarityService() {
    // if (similarityService == null) {
    // @SuppressWarnings("resource")
    // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // similarityService = (SimilarityService) context.getBean("similarityService");
    //
    // }
    // return similarityService;
    // }
}
