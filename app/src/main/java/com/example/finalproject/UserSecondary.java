package com.example.finalproject;

public class UserSecondary {
    String userSecondaryName;
    String userSecondaryOptic;
    String userSecondaryMuzzle;
    String userSecondaryBarrel;
    String userSecondaryMag;
    String userSecondaryGrip;

    public UserSecondary(){

    }

    public UserSecondary(String uSN, String uSO, String uSM, String uSB, String uSMag, String uSG){
        userSecondaryName = uSN;
        userSecondaryOptic = uSO;
        userSecondaryMuzzle = uSM;
        userSecondaryBarrel = uSB;
        userSecondaryMag = uSMag;
        userSecondaryGrip = uSG;
    }

    public String getUserSecondaryName() {
        return userSecondaryName;
    }

    public void setUserSecondaryName(String userSecondaryName) {
        this.userSecondaryName = userSecondaryName;
    }

    public String getUserSecondaryOptic() {
        return userSecondaryOptic;
    }

    public void setUserSecondaryOptic(String userSecondaryOptic) {
        this.userSecondaryOptic = userSecondaryOptic;
    }

    public String getUserSecondaryMuzzle() {
        return userSecondaryMuzzle;
    }

    public void setUserSecondaryMuzzle(String userSecondaryMuzzle) {
        this.userSecondaryMuzzle = userSecondaryMuzzle;
    }

    public String getUserSecondaryBarrel() {
        return userSecondaryBarrel;
    }

    public void setUserSecondaryBarrel(String userSecondaryBarrel) {
        this.userSecondaryBarrel = userSecondaryBarrel;
    }

    public String getUserSecondaryMag() {
        return userSecondaryMag;
    }

    public void setUserSecondaryMag(String userSecondaryMag) {
        this.userSecondaryMag = userSecondaryMag;
    }

    public String getUserSecondaryGrip() {
        return userSecondaryGrip;
    }

    public void setUserSecondaryGrip(String userSecondaryGrip) {
        this.userSecondaryGrip = userSecondaryGrip;
    }
}
