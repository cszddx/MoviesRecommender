package com.analysis.movie.entity;

public class Link implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long movieid;
    private Movie movie;
    private String imdbid;
    private String tmdbid;

    public Link() {
    }

    public Link(long movieid, Movie movie) {
        this.movieid = movieid;
        this.movie = movie;
    }

    public Link(long movieid, Movie movie, String imdbid, String tmdbid) {
        this.movieid = movieid;
        this.movie = movie;
        this.imdbid = imdbid;
        this.tmdbid = tmdbid;
    }

    public long getMovieid() {
        return this.movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getImdbid() {
        return this.imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getTmdbid() {
        return this.tmdbid;
    }

    public void setTmdbid(String tmdbid) {
        this.tmdbid = tmdbid;
    }
}
