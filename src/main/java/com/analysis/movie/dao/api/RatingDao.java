package com.analysis.movie.dao.api;

import java.util.List;

import com.analysis.movie.entity.Rating;

public interface RatingDao {
    List<Rating> getRatings(long userId);

    List<Rating> getRatings(List<Long> userIds);

    List<Rating> getRelatedRatings(long userId);
}
