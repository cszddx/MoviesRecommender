package com.analysis.movie.common;

public enum GenresEnum {
    Action("Action"), Adventure("Adventure"), Animation("Animation"), Childrens("Children's"), Comedy("Comedy"), Crime(
            "Crime"), Documentary("Documentary"), Drama("Drama"), Fantasy("Fantasy"), FilmNoir("Film-Noir"), Horror(
            "Horror"), Musical("Musical"), Mystery("Mystery"), Romance("Romance"), SciFi("Sci-Fi"), Thriller("Thriller"), War(
            "War"), Western("Western"), NoGenreslisted("(no genres listed)");

    private String value;

    private GenresEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
