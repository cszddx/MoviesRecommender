package com.analysis.movie.exception;

public class MovieAnalysisException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MovieAnalysisException() {
        super();
    }

    public MovieAnalysisException(String message) {
        super(message);
    }

    public MovieAnalysisException(String message, Throwable cause) {
        super(message, cause);
    }
}
