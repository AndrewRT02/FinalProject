package com.example.finalproject;

public class LethalSessionData {

    private static Lethal registeredLethal;

    public static Lethal getRegisteredLethal() {
        return registeredLethal;
    }

    public static void setRegisteredLethal(Lethal l) {
        LethalSessionData.registeredLethal = l;
    }
}
