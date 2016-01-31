package com.analysis.movie.similarity.api;

import java.util.Map;

public interface SimilarityComputer {
    /**
     * Get the similarity of 2 users based on ratings to the movies they have seen
     * 
     * @param map1
     *            , stores the movie id and corresponding rating by one user
     * @param map2
     *            , stores the movie id and corresponding rating by another user
     * @return
     */
    double computeSimilarity(Map<Long, Double> map1, Map<Long, Double> map2);
}
