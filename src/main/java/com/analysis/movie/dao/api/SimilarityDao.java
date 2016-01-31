package com.analysis.movie.dao.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.entity.Similarity;

public interface SimilarityDao {
    List<Similarity> getSimilarities(long userId);

    void insertSimilarities(Set<UserSimilarity> similarities);
}
