package com.analysis.movie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.dao.api.RatingDao;
import com.analysis.movie.entity.Rating;
import com.analysis.movie.service.api.RatingService;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {
    @Resource
    private RatingDao ratingDao;

    @Override
    public List<Rating> getRatings(long userId) {
        List<Rating> ratings = ratingDao.getRatings(userId);

        return ratings;
    }

    @Override
    public List<Rating> getRelatedRatings(long userId) {
        List<Rating> ratings = ratingDao.getRelatedRatings(userId);

        return ratings;
    }

    @Override
    public List<Rating> getRatings(List<Long> userIds) {
        List<Rating> ratings = ratingDao.getRatings(userIds);

        return ratings;
    }
}
