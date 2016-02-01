package com.analysis.movie.service.api;

import java.util.List;
import java.util.Set;

import com.analysis.movie.entity.Rating;

public interface RatingService {

    /**
     * get all the ratings by specified user id
     *
     * @param userId
     * @return Ratings List
     */
    List<Rating> getRatings(long userId);

    /**
     * Get all the ratings by a user set
     *
     * @param userIds
     * @return
     */
    List<Rating> getRatings(Set<Long> userIds);

    /**
     * Get the Ratings which are related to the specified user.
     *
     * @param userId
     * @return
     */
    List<Rating> getRelatedRatings(long userId);
}
