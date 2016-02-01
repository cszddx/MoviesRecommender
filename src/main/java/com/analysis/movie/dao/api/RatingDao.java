package com.analysis.movie.dao.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.entity.Rating;

public interface RatingDao {
    List<Rating> getRatings(long userId);

    List<Rating> getRatings(Set<Long> userIds);

    List<Rating> getRelatedRatings(long userId);
}
