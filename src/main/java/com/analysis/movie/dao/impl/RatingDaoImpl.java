package com.analysis.movie.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.movie.dao.api.RatingDao;
import com.analysis.movie.entity.Rating;

@Repository
public class RatingDaoImpl implements RatingDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Rating> getRatings(long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("from Rating as rating left outer join fetch rating.users as users left outer join fetch rating.movie"
                        + " where users.userId = :userId");
        query.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Rating> result = query.list();

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Rating> getRelatedRatings(long userId) {
        // get all movies rated by the user $userId
        Session session = sessionFactory.getCurrentSession();
        Query queryRatingMovies = session
                .createQuery("select movie.movieId from Rating as rating left outer join rating.users as users left outer join rating.movie as movie"
                        + " where users.userId = :userId");
        queryRatingMovies.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Long> movieIds = queryRatingMovies.list();

        // get all users who also gave ratings on these movies rated by the user $userId
        Query queryRelatedUsers = session
                .createQuery("select distinct users.userId from Rating as rating left outer join rating.movie as movie left outer join rating.users as users"
                        + " where movie.movieId in (:movieIds)");
        queryRelatedUsers.setParameterList("movieIds", movieIds);
        @SuppressWarnings("unchecked")
        List<Long> relatedUserIds = queryRelatedUsers.list();
        // exclude the user we recommend to
        relatedUserIds.remove(userId);

        // get all ratings of related users
        List<Rating> result = getRatings(new HashSet<Long>(relatedUserIds));

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Rating> getRatings(Set<Long> userIds) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("from Rating as rating left outer join fetch rating.users as users left outer join fetch rating.movie as movie left outer join fetch movie.link"
                        + " where users.userId in (:userIds)");
        query.setParameterList("userIds", userIds);
        @SuppressWarnings("unchecked")
        List<Rating> result = query.list();

        return result;
    }
}
