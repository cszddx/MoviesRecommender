package com.analysis.movie.entity;

import java.util.Date;

public class Rating implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long ratingid;
    private Movie movie;
    private Users users;
    private double rating;
    private Date createdate;

    public Rating() {
    }

    public Rating(long ratingid) {
        this.ratingid = ratingid;
    }

    public Rating(long ratingid, Movie movie, Users users, double rating, Date createdate) {
        this.ratingid = ratingid;
        this.movie = movie;
        this.users = users;
        this.rating = rating;
        this.createdate = createdate;
    }

    public long getRatingid() {
        return this.ratingid;
    }

    public void setRatingid(long ratingid) {
        this.ratingid = ratingid;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ratingid ^ (ratingid >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rating other = (Rating) obj;
        if (ratingid != other.ratingid)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rating [ratingid=" + ratingid + ", movie=" + movie + ", users=" + users + ", rating=" + rating
                + ", createdate=" + createdate + "]";
    }
}
