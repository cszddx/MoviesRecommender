package com.analysis.movie.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.dao.api.SimilarityDao;
import com.analysis.movie.service.api.SimilarityService;

@Service("similarityService")
public class SimilarityServiceImpl implements SimilarityService {
    @Resource
    private SimilarityDao similarityDao;

    @Override
    public void insertSimilarities(Set<UserSimilarity> similarities) {
        similarityDao.insertSimilarities(similarities);
    }

    @Override
    public Set<Long> getSimilarUsers(long userId) {
        return similarityDao.getSimilarUsers(userId);
    }
}
