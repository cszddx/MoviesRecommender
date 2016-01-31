package com.analysis.movie.exception;

public class RecommendationException extends MovieAnalysisException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RecommendationException() {
        super();
    }

    public RecommendationException(String message) {
        super(message);
    }

    public RecommendationException(String message, Throwable cause) {
        super(message, cause);
    }
}
