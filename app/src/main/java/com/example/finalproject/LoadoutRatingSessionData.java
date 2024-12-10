package com.example.finalproject;

public class LoadoutRatingSessionData {

    private static LoadoutRating registeredLoadoutRating;

    public static  LoadoutRating getRegisteredLoadoutRating(){
        return registeredLoadoutRating;
    }

    public static void setRegisteredLoadoutRating(LoadoutRating l){
        registeredLoadoutRating = l;
    }
}
