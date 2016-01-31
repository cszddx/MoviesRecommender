package com.analysis.movie.common;

import com.analysis.movie.entity.Movie;

public class RecommendedMovie {
    private static String URL_IMDB = "http://www.imdb.com/title/tt";
    private static String URL_TMD = "https://www.themoviedb.org/movie/";

    private long movieId;
    private String movieName;
    private String imdbId;
    private String tmdbId;
    private double avgRating;
    // watched by how many people
    private double count;

    public RecommendedMovie() {

    }

    public RecommendedMovie(Movie movie) {
        this.movieId = movie.getMovieId();
        this.movieName = movie.getTitle();

        if (movie.getLink() != null) {
            this.imdbId = movie.getLink().getImdbid();
            this.tmdbId = movie.getLink().getTmdbid();
        }
    }

    public RecommendedMovie(long movieId, String movieName, String imdbId, String tmdbId) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    public String getImdbLink() {
        return URL_IMDB + this.imdbId;
    }

    public String getTmdbLink() {
        return URL_TMD + this.tmdbId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return movieName + "\n" + this.getImdbLink() + "\n" + this.getTmdbLink() + "\n\n";
    }
}
