package com.analysis.movie.service.api;

import java.util.Set;

import com.analysis.movie.common.UserSimilarity;

public interface SimilarityService {

    Set<Long> getSimilarUsers(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
