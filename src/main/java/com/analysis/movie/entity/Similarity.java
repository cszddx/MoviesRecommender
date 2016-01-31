package com.analysis.movie.entity;

import java.io.Serializable;

public class Similarity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long similarityid;
    private Users usersBySimilaruserid;
    private Users usersByUserid;
    private double similaritygrade;

    public Similarity() {
    }

    public Similarity(long similarityid) {
        this.similarityid = similarityid;
    }

    public Similarity(long similarityid, Users usersBySimilaruserid, Users usersByUserid, double similaritygrade) {
        this.similarityid = similarityid;
        this.usersBySimilaruserid = usersBySimilaruserid;
        this.usersByUserid = usersByUserid;
        this.similaritygrade = similaritygrade;
    }

    public long getSimilarityid() {
        return this.similarityid;
    }

    public void setSimilarityid(long similarityid) {
        this.similarityid = similarityid;
    }

    public Users getUsersBySimilaruserid() {
        return this.usersBySimilaruserid;
    }

    public void setUsersBySimilaruserid(Users usersBySimilaruserid) {
        this.usersBySimilaruserid = usersBySimilaruserid;
    }

    public Users getUsersByUserid() {
        return this.usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    public double getSimilaritygrade() {
        return this.similaritygrade;
    }

    public void setSimilaritygrade(double similaritygrade) {
        this.similaritygrade = similaritygrade;
    }

    @Override
    public String toString() {
        return "Similarity [similarityid=" + similarityid + ", usersBySimilaruserid="
                + usersBySimilaruserid.getUserid() + ", usersByUserid=" + usersByUserid.getUserid()
                + ", similaritygrade=" + similaritygrade + "]";
    }
}
