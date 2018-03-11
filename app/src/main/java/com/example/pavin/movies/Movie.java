package com.example.pavin.movies;

/**
 * Created by pavin on 11.03.2018.
 */

public class Movie {

    private String name;
    private int rating;
    private int picture;

    public Movie() {
    }

    public Movie(String name, int rating, int picture) {
        this.name = name;
        this.rating = rating;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
