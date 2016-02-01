package com.analysis.movie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "MOVIES")
public class Users implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String email;
    private String userName;
    private Set<Tag> tags = new HashSet<Tag>(0);
    private Set<Similarity> similaritiesForUserid = new HashSet<Similarity>(0);
    private Set<Rating> ratings = new HashSet<Rating>(0);
    private Set<Similarity> similaritiesForSimilaruserid = new HashSet<Similarity>(0);

    public Users() {
    }

    public Users(Long userId) {
        this.userId = userId;
    }

    public Users(Long userId, String email, String userName, Set<Tag> tags, Set<Similarity> similaritiesForUserid,
            Set<Rating> ratings, Set<Similarity> similaritiesForSimilaruserid) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.tags = tags;
        this.similaritiesForUserid = similaritiesForUserid;
        this.ratings = ratings;
        this.similaritiesForSimilaruserid = similaritiesForSimilaruserid;
    }

    @Id
    @Column(name = "USERID", unique = true, nullable = false)
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "EMAIL", length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "USERNAME", length = 50)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByUserid")
    public Set<Similarity> getSimilaritiesForUserid() {
        return this.similaritiesForUserid;
    }

    public void setSimilaritiesForUserid(Set<Similarity> similaritiesForUserid) {
        this.similaritiesForUserid = similaritiesForUserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersBySimilaruserid")
    public Set<Similarity> getSimilaritiesForSimilaruserid() {
        return this.similaritiesForSimilaruserid;
    }

    public void setSimilaritiesForSimilaruserid(Set<Similarity> similaritiesForSimilaruserid) {
        this.similaritiesForSimilaruserid = similaritiesForSimilaruserid;
    }

}