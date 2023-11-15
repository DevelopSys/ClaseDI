package com.example.t3_listas.model;
import java.time.LocalDate;
import java.util.Arrays;

public class PeliculaJSON {
    private boolean adult;
    private String backdropPath;
    private long[] genreIDS;
    private long id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private String title;
    private boolean video;
    private double voteAverage;
    private long voteCount;

    public PeliculaJSON(boolean adult, String backdropPath, long[] genreIDS, long id, String originalLanguage, String originalTitle, String overview, double popularity, String posterPath, String title, boolean video, double voteAverage, long voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genreIDS = genreIDS;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public PeliculaJSON() {
    }

    public boolean getAdult() { return adult; }
    public void setAdult(boolean value) { this.adult = value; }

    public String getBackdropPath() { return backdropPath; }
    public void setBackdropPath(String value) { this.backdropPath = value; }

    public long[] getGenreIDS() { return genreIDS; }
    public void setGenreIDS(long[] value) { this.genreIDS = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getOriginalLanguage() { return originalLanguage; }
    public void setOriginalLanguage(String value) { this.originalLanguage = value; }

    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String value) { this.originalTitle = value; }

    public String getOverview() { return overview; }
    public void setOverview(String value) { this.overview = value; }

    public double getPopularity() { return popularity; }
    public void setPopularity(double value) { this.popularity = value; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String value) { this.posterPath = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public boolean getVideo() { return video; }
    public void setVideo(boolean value) { this.video = value; }

    public double getVoteAverage() { return voteAverage; }
    public void setVoteAverage(double value) { this.voteAverage = value; }

    public long getVoteCount() { return voteCount; }
    public void setVoteCount(long value) { this.voteCount = value; }

    @Override
    public String toString() {
        return getTitle();
    }
}
