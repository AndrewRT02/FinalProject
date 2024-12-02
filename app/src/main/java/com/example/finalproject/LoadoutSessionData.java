package com.example.finalproject;

public class LoadoutSessionData {

    private static Loadout registeredLoadout;

    public static Loadout getRegisteredLoadout(){
        return registeredLoadout;
    }

    public static void setRegisteredLoadout(Loadout l){
        registeredLoadout = l;
    }
}
