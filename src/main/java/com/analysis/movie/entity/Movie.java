package com.analysis.movie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE", schema = "MOVIES")
public class Movie implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long movieId;
    private String title;
    private String genres;
    private Set<Rating> ratings = new HashSet<Rating>(0);
    private Link link;
    private Set<Tag> tags = new HashSet<Tag>(0);

    public Movie() {
    }

    public Movie(Long movieId) {
        this.movieId = movieId;
    }

    public Movie(Long movieId, String title, String genres, Set<Rating> ratings, Link link, Set<Tag> tags) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
        this.ratings = ratings;
        this.link = link;
        this.tags = tags;
    }

    @Id
    @Column(name = "MOVIEID", unique = true, nullable = false)
    public Long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "GENRES")
    public String getGenres() {
        return this.genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
    public Set<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

}