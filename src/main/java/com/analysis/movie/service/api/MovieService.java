package com.analysis.movie.service.api;

import java.util.List;

import com.analysis.movie.entity.Movie;

public interface MovieService {
    List<Movie> getMovies();

    Movie getMovie(long movieId);
}
