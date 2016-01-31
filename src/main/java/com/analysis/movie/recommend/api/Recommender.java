package com.analysis.movie.recommend.api;

import java.util.List;

import com.analysis.movie.common.RecommendedMovie;

/**
 * A recommender which is used to give movie recommendations to the user specified.
 *
 * @author duxin
 *
 */
public interface Recommender {
    /**
     * By default, recommend 200 movies to the user
     */
    static int RECOMMENDATION_THRESHOLD = 200;

    List<RecommendedMovie> getRecommendations(long userId);
}
