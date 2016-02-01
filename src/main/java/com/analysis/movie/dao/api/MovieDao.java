package com.analysis.movie.dao.api;

import com.analysis.movie.entity.Movie;

public interface MovieDao {
    Movie getMovie(long movieId);
}
