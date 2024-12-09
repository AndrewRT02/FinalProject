package com.example.finalproject;

public class MakeSecondarySessionData {

    private static UserSecondary makeSecondary;

    public static UserSecondary getSecondaryParts(){
        return makeSecondary;
    }

    public static void setSecondaryParts(UserSecondary uS){
        makeSecondary = uS;
    }
}
