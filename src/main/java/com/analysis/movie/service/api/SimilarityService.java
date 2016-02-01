package com.analysis.movie.service.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.common.UserSimilarity;

public interface SimilarityService {

    List<Long> getSimilarUsers(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
