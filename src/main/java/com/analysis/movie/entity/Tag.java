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
@Table(name = "TAG", schema = "MOVIES")
public class Tag implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long tagId;
    private Movie movie;
    private Users users;
    private String tagTxt;
    private Timestamp createDate;

    public Tag() {
    }

    public Tag(Long tagId) {
        this.tagId = tagId;
    }

    public Tag(Long tagId, Movie movie, Users users, String tagTxt, Timestamp createDate) {
        this.tagId = tagId;
        this.movie = movie;
        this.users = users;
        this.tagTxt = tagTxt;
        this.createDate = createDate;
    }

    @Id
    @Column(name = "TAGID", unique = true, nullable = false)
    public Long getTagId() {
        return this.tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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

    @Column(name = "TAGTXT")
    public String getTagTxt() {
        return this.tagTxt;
    }

    public void setTagTxt(String tagTxt) {
        this.tagTxt = tagTxt;
    }

    @Column(name = "CREATEDATE", length = 29)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

}