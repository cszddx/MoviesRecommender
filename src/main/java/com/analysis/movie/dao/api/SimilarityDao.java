package com.analysis.movie.dao.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.common.UserSimilarity;

public interface SimilarityDao {
    List<Long> getSimilarUsers(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
