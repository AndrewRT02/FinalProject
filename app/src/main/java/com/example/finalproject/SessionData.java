package com.example.finalproject;

public class SessionData {

    private static User registeredUser;

    public static User getRegisteredUser(){
        return registeredUser;
    }

    public static void setRegisteredUser(User u){
        registeredUser = u;
    }
}
