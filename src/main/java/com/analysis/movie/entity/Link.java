package com.analysis.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LINK", schema = "MOVIES")
public class Link implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long movieId;
    private Movie movie;
    private String imdbId;
    private String tmdbId;

    public Link() {
    }

    public Link(Long movieId, Movie movie) {
        this.movieId = movieId;
        this.movie = movie;
    }

    public Link(Long movieId, Movie movie, String imdbId, String tmdbId) {
        this.movieId = movieId;
        this.movie = movie;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    @Id
    @Column(name = "MOVIEID", unique = true, nullable = false)
    public Long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIEID", unique = true, nullable = false, insertable = false, updatable = false)
    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Column(name = "IMDBID")
    public String getImdbId() {
        return this.imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Column(name = "TMDBID")
    public String getTmdbId() {
        return this.tmdbId;
    }

    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }
}