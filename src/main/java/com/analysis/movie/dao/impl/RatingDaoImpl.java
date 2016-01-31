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
                        + " where users.userid = :userId");
        query.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Rating> list = query.list();

        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Rating> getRelatedRatings(long userId) {
        // get all movies rated by the user
        Session session = sessionFactory.getCurrentSession();
        Query queryUserRatings = session
                .createQuery("from Rating as rating left outer join fetch rating.users as users left outer join fetch rating.movie"
                        + " where users.userid = :userId");
        queryUserRatings.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Rating> ratingsByUser = queryUserRatings.list();
        // get all the movie ids
        Set<Long> movieIds = new HashSet<>();
        for (Rating r : ratingsByUser) {
            movieIds.add(r.getMovie().getMovieId());
        }

        // get all ratings on these movies
        Query queryMovieRatings = session
                .createQuery("from Rating as rating left outer join fetch rating.movie as movie"
                        + " where movie.movieId in (:movieIds)");
        queryMovieRatings.setParameterList("movieIds", movieIds);
        @SuppressWarnings("unchecked")
        List<Rating> ratingsByMovie = queryMovieRatings.list();
        // get all users who make the ratings
        Set<Long> userIds = new HashSet<>();
        for (Rating r : ratingsByMovie) {
            userIds.add(r.getUsers().getUserid());
        }
        // exclude the user we recommend to
        userIds.remove(userId);

        // get all ratings of related users
        Query queryRelatedUsersRatings = session
                .createQuery("from Rating as rating left outer join fetch rating.users as users left outer join fetch rating.movie as movie"
                        + " where users.userid in (:userIds)");
        queryRelatedUsersRatings.setParameterList("userIds", userIds);
        @SuppressWarnings("unchecked")
        List<Rating> results = queryRelatedUsersRatings.list();

        return results;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Rating> getRatings(List<Long> userIds) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("from Rating as rating left outer join fetch rating.users as users left outer join fetch rating.movie as movie left outer join fetch movie.link"
                        + " where users.userid in (:userIds)");
        query.setParameterList("userIds", userIds);
        @SuppressWarnings("unchecked")
        List<Rating> list = query.list();

        return list;
    }
}
