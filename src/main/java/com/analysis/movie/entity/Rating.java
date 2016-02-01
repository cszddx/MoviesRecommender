package com.analysis.movie.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RATING", schema = "MOVIES")
public class Rating implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long ratingId;
    private Movie movie;
    private Users users;
    private Double rating;
    private Timestamp createDate;

    public Rating() {
    }

    public Rating(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Rating(Long ratingId, Movie movie, Users users, Double rating, Timestamp createDate) {
        this.ratingId = ratingId;
        this.movie = movie;
        this.users = users;
        this.rating = rating;
        this.createDate = createDate;
    }

    @Id
    @Column(name = "RATINGID", unique = true, nullable = false)
    public Long getRatingId() {
        return this.ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIEID")
    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Column(name = "RATING", precision = 2, scale = 1)
    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Column(name = "CREATEDATE", length = 29)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}