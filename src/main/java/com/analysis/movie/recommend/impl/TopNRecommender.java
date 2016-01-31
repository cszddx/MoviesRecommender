package com.analysis.movie.recommend.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.analysis.movie.common.RecommendedMovie;
import com.analysis.movie.recommend.api.Recommender;

/**
 * This Recommender implementation is a decorator which returns the top n items sorted by the Comparator specified.
 *
 * @author duxin
 *
 */
public class TopNRecommender implements Recommender {
    private Recommender recommender;
    private int size;
    private Comparator<RecommendedMovie> comp;

    public TopNRecommender(Recommender recommender, int size, Comparator<RecommendedMovie> comp) {
        this.recommender = recommender;
        this.size = size;
        this.comp = comp;
    }

    @Override
    public List<RecommendedMovie> getRecommendations(long userId) {
        List<RecommendedMovie> movies = recommender.getRecommendations(userId);
        // construct a TreeSet to sort the movies by the comparator specified
        Set<RecommendedMovie> sortedMovies = new TreeSet<RecommendedMovie>(comp);
        sortedMovies.addAll(movies);
        // get top N movies from sorted movie list
        List<RecommendedMovie> topNMovies = getTopNMovies(sortedMovies);

        return topNMovies;
    }

    private List<RecommendedMovie> getTopNMovies(Set<RecommendedMovie> sortedMovies) {
        List<RecommendedMovie> movies = new ArrayList<RecommendedMovie>();
        int count = size;
        for (RecommendedMovie m : sortedMovies) {
            if (count == 0) {
                break;
            }
            movies.add(m);
            --count;
        }

        return movies;
    }
}
