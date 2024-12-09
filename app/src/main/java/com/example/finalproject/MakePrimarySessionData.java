package com.example.finalproject;

public class MakePrimarySessionData {

    private static UserPrimary makePrimary;

    public static UserPrimary getPrimaryParts(){return makePrimary;}

    public static void setPrimaryParts(UserPrimary uP){
        makePrimary = uP;
    }
}
