package com.example.finalproject;

public class PrimarySessionData {

    private static Primary registeredPrimary;

    public static Primary getRegisteredPrimary(){
        return registeredPrimary;
    }

    public static void setRegisteredPrimary(Primary p){
        registeredPrimary = p;
    }
}
