package com.example.finalproject;

public class MakePerksSessionData {

    private static UserPerks makePerks;

    public static UserPerks getPerksParts(){
        return makePerks;
    }

    public static void setPerksParts(UserPerks uP){
        makePerks = uP;
    }
}
