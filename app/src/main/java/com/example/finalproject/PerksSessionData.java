package com.example.finalproject;

public class PerksSessionData {

    private static Perks registeredPerks;

    public static Perks getRegisteredPerks() {
        return registeredPerks;
    }

    public static void setRegisteredPerks(Perks pks) {
        PerksSessionData.registeredPerks = pks;
    }
}
