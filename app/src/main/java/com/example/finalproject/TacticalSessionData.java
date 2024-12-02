package com.example.finalproject;

public class TacticalSessionData {

    private static Tactical registeredTactical;

    public static Tactical getRegisteredTactical() {
        return registeredTactical;
    }

    public static void setRegisteredTactical(Tactical t) {
        TacticalSessionData.registeredTactical = t;
    }
}
