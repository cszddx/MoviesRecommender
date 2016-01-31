package com.analysis.movie.dao.api;

import java.util.List;

import com.analysis.movie.entity.Movie;

public interface MovieDao {
    List<Movie> getAllMovies();

    Movie getMovie(long movieId);
}
