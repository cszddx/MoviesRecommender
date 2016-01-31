package com.analysis.movie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

import com.analysis.movie.util.Utilities;

public class Movie implements java.io.Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private long movieId;
    private Link link;
    private String title;
    private String genres;

    public Movie() {
    }

    public Movie(long movieId) {
        this.movieId = movieId;
    }

    public Movie(long movieId, Link link, String title, String genres) {
        this.movieId = movieId;
        this.link = link;
        this.title = title;
        this.genres = genres;
    }

    public long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getGenres() {
        return this.genres;
    }

    public void setGenres(String Genres) {
        this.genres = Genres;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Transient
    public Set<String> getGenresSet() {
        Set<String> genresSet = new HashSet<String>();
        if (!Utilities.isNullOrEmpty(this.genres)) {
            String[] aGenres = this.genres.split("|");
            for (String item : aGenres) {
                genresSet.add(item);
            }
        }
        return genresSet;
    }

    @Override
    public String toString() {
        return "Movie [MovieId=" + movieId + ", Title=" + title + ", Genres=" + genres + "]";
    }
}
