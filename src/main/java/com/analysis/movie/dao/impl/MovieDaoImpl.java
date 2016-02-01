package com.analysis.movie.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.movie.dao.api.MovieDao;
import com.analysis.movie.entity.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Movie getMovie(long movieId) {
        Session session = sessionFactory.getCurrentSession();

        return (Movie) session.get(Movie.class, movieId);
    }
}
