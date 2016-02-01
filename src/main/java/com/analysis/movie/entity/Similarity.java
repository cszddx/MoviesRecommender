package com.analysis.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SIMILARITY", schema = "MOVIES")
public class Similarity implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long similarityId;
    private Users usersBySimilaruserid;
    private Users usersByUserid;
    private Double similarityGrade;

    public Similarity() {
    }

    public Similarity(Long similarityId) {
        this.similarityId = similarityId;
    }

    public Similarity(Long similarityId, Users usersBySimilaruserid, Users usersByUserid, Double similarityGrade) {
        this.similarityId = similarityId;
        this.usersBySimilaruserid = usersBySimilaruserid;
        this.usersByUserid = usersByUserid;
        this.similarityGrade = similarityGrade;
    }

    @Id
    @Column(name = "SIMILARITYID", unique = true, nullable = false)
    public Long getSimilarityId() {
        return this.similarityId;
    }

    public void setSimilarityId(Long similarityId) {
        this.similarityId = similarityId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SIMILARUSERID")
    public Users getUsersBySimilaruserid() {
        return this.usersBySimilaruserid;
    }

    public void setUsersBySimilaruserid(Users usersBySimilaruserid) {
        this.usersBySimilaruserid = usersBySimilaruserid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    public Users getUsersByUserid() {
        return this.usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    @Column(name = "SIMILARITYGRADE", precision = 52, scale = 0)
    public Double getSimilarityGrade() {
        return this.similarityGrade;
    }

    public void setSimilarityGrade(Double similarityGrade) {
        this.similarityGrade = similarityGrade;
    }
}