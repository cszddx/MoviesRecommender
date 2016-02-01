package com.analysis.movie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.dao.api.MovieDao;
import com.analysis.movie.entity.Movie;
import com.analysis.movie.service.api.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieDao movieDao;

    @Override
    public Movie getMovie(long movieId) {
        return movieDao.getMovie(movieId);
    }
}
