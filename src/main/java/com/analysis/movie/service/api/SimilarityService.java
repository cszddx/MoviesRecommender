package com.analysis.movie.service.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.entity.Similarity;

public interface SimilarityService {
    List<Similarity> getSimilarities(long userId);

    List<Long> getSimilarUserIds(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
