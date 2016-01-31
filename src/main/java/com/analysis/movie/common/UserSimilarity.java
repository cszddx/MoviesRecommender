package com.analysis.movie.common;

public class UserSimilarity implements Comparable<UserSimilarity> {
    private long userId;
    private long similarityUserId;
    private double similarity;

    public UserSimilarity(long userId, long similarityUserId, double similarity) {
        this.userId = userId;
        this.similarityUserId = similarityUserId;
        this.similarity = similarity;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public long getSimilarityUserId() {
        return similarityUserId;
    }

    public void setSimilarityUserId(long similarityUserId) {
        this.similarityUserId = similarityUserId;
    }

    @Override
    public int compareTo(UserSimilarity o) {
        return Double.compare(o.similarity, this.similarity);
    }

    @Override
    public String toString() {
        return "UserSimilarity [userId=" + userId + ", similarityUserId=" + similarityUserId + ", similarity="
                + similarity + "]";
    }

}
