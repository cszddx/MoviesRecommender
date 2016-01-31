package com.analysis.movie.entity;

import java.util.Date;

public class Tag implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long tagid;
    private Movie movie;
    private Users users;
    private String tagtxt;
    private Date createdate;

    public Tag() {
    }

    public Tag(long tagid) {
        this.tagid = tagid;
    }

    public Tag(long tagid, Movie movie, Users users, String tagtxt, Date createdate) {
        this.tagid = tagid;
        this.movie = movie;
        this.users = users;
        this.tagtxt = tagtxt;
        this.createdate = createdate;
    }

    public long getTagid() {
        return this.tagid;
    }

    public void setTagid(long tagid) {
        this.tagid = tagid;
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

    public String getTagtxt() {
        return this.tagtxt;
    }

    public void setTagtxt(String tagtxt) {
        this.tagtxt = tagtxt;
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
        result = prime * result + (int) (tagid ^ (tagid >>> 32));
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
        Tag other = (Tag) obj;
        if (tagid != other.tagid)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tag [tagid=" + tagid + ", movie=" + movie + ", users=" + users + ", tagtxt=" + tagtxt + ", createdate="
                + createdate + "]";
    }
}
