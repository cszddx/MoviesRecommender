package com.analysis.movie.dao.api;

import java.util.Set;

import com.analysis.movie.common.UserSimilarity;

public interface SimilarityDao {
    Set<Long> getSimilarUsers(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
