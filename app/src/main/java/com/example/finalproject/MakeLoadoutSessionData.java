package com.example.finalproject;

public class MakeLoadoutSessionData {

    private static Loadout makeLoadout;

    public static Loadout getLoadoutParts(){
        return makeLoadout;
    }

    public static void setLoadoutParts(Loadout l){
        makeLoadout = l;
    }
}
