package com.analysis.movie.entity;

import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long userid;
    private String email;
    private String username;
    private Set<Tag> tags = new HashSet<>(0);
    private Set<Rating> ratings = new HashSet<>(0);
    private Set<Users> similarUsers = new HashSet<>(0);

    public Users() {
    }

    /** minimal constructor */
    public Users(long userid) {
        this.userid = userid;
    }

    /** full constructor */
    public Users(long userid, String email, String username, Set<Tag> tags, Set<Rating> ratings, Set<Users> similarUsers) {
        this.userid = userid;
        this.email = email;
        this.username = username;
        this.tags = tags;
        this.ratings = ratings;
        this.similarUsers = similarUsers;
    }

    public long getUserid() {
        return this.userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Users> getSimilarUsers() {
        return this.similarUsers;
    }

    public void setSimilarUsers(Set<Users> similarUsers) {
        this.similarUsers = similarUsers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userid ^ (userid >>> 32));
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
        Users other = (Users) obj;
        if (userid != other.userid)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Users [userid=" + userid + ", email=" + email + ", username=" + username + "]";
    }
}