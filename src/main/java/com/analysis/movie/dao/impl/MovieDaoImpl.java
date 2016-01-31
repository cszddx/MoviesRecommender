package com.analysis.movie.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
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

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Movie> getAllMovies() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Movie");
        @SuppressWarnings("unchecked")
        List<Movie> result = query.list();

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Movie getMovie(long movieId) {
        Session session = sessionFactory.getCurrentSession();
        return (Movie) session.get(Movie.class, movieId);
    }
}
