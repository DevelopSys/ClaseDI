package com.example.t3_listas;
import java.time.LocalDate;
import java.util.Arrays;

public class PeliculaJSON {
    private boolean adult;
    private String backdrop_path;
    private long[] genre_ids;
    private long id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String posterPath;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;

    public PeliculaJSON(boolean adult, String backdrop_path, long[] genre_ids, int id, String original_language,
                        String original_title, String overview, double popularity, String posterPath, String title, boolean video, double vote_average, int voteCount) {
        this.adult = adult;
        this.backdrop_path = "https://image.tmdb.org/t/p/w500/"+backdrop_path;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = voteCount;
    }

    public PeliculaJSON() {
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return "https://image.tmdb.org/t/p/w500/"+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public long[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(long[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(int voteCount) {
        this.vote_count = voteCount;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
