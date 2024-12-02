package com.example.finalproject;

public class SecondarySessionData {

    private static Secondary registeredSecondary;

    public static Secondary getRegisteredSecondary() {
        return registeredSecondary;
    }

    public static void setRegisteredSecondary(Secondary s) {
        SecondarySessionData.registeredSecondary = s;
    }
}
