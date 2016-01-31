package com.analysis.movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.dao.api.SimilarityDao;
import com.analysis.movie.entity.Similarity;
import com.analysis.movie.service.api.SimilarityService;

@Service("similarityService")
public class SimilarityServiceImpl implements SimilarityService {
    @Resource
    private SimilarityDao similarityDao;

    @Override
    public List<Similarity> getSimilarities(long userId) {
        return similarityDao.getSimilarities(userId);
    }

    @Override
    public void insertSimilarities(Set<UserSimilarity> similarities) {
        similarityDao.insertSimilarities(similarities);
    }

    @Override
    public List<Long> getSimilarUserIds(long userId) {
        List<Long> similarUserIds = new ArrayList<>();
        List<Similarity> similarities = similarityDao.getSimilarities(userId);
        for (Similarity s : similarities) {
            similarUserIds.add(s.getUsersBySimilaruserid().getUserid());
        }

        return similarUserIds;
    }
}
