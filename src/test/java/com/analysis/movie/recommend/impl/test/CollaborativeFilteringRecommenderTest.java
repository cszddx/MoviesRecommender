package com.analysis.movie.recommend.impl.test;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.analysis.movie.exception.RecommendationException;
import com.analysis.movie.recommend.impl.CollaborativeFilteringRecommender;
import com.analysis.movie.service.api.UsersService;

public class CollaborativeFilteringRecommenderTest {

    @Test
    public void testGetRecommendationsWithInvalidUserId() {
        UsersService usersService = EasyMock.mock(UsersService.class);

        EasyMock.expect(usersService.getUsersInformation(EasyMock.anyLong())).andReturn(null);
        EasyMock.replay(usersService);

        CollaborativeFilteringRecommender recommender = new CollaborativeFilteringRecommender();
        recommender.setUsersService(usersService);

        try {
            recommender.getRecommendations(5L);
            Assert.assertTrue(false);
        } catch (RecommendationException e) {
            Assert.assertTrue(true);
            EasyMock.verify(usersService);
        }
    }
}
