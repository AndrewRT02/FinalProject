package com.example.finalproject;

public class LoadoutRating {
    int ratingId;
    int loadoutRating;
    int loadoutId;

    public LoadoutRating(){

    }

    public LoadoutRating(int rId, int lR, int lId){
        ratingId = rId;
        loadoutRating = lR;
        loadoutId = lId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getLoadoutRating() {
        return loadoutRating;
    }

    public void setLoadoutRating(int loadoutRating) {
        this.loadoutRating = loadoutRating;
    }

    public int getLoadoutId() {
        return loadoutId;
    }

    public void setLoadoutId(int loadoutId) {
        this.loadoutId = loadoutId;
    }
}
