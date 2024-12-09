package com.example.finalproject;

public class UserLoadout {
    String creator;
    String userLoadoutName;
    int userPrimary;
    int userSecondary;
    int userTactical;
    int userLethal;
    int userPerks;
    String userMelee;
    String userFU;

    public UserLoadout(){

    }

    public UserLoadout(String c, String uLN, int uP, int uS, int uT, int uL, int uPerks, String uM, String uUP){
        creator = c;
        userLoadoutName = uLN;
        userPrimary = uP;
        userSecondary = uS;
        userTactical = uT;
        userLethal = uL;
        userPerks = uPerks;
        userMelee = uM;
        userFU = uUP;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getUserPrimary() {
        return userPrimary;
    }

    public void setUserPrimary(int userPrimary) {
        this.userPrimary = userPrimary;
    }

    public String getUserLoadoutName() {
        return userLoadoutName;
    }

    public void setUserLoadoutName(String userLoadoutName) {
        this.userLoadoutName = userLoadoutName;
    }

    public int getUserSecondary() {
        return userSecondary;
    }

    public void setUserSecondary(int userSecondary) {
        this.userSecondary = userSecondary;
    }

    public int getUserTactical() {
        return userTactical;
    }

    public void setUserTactical(int userTactical) {
        this.userTactical = userTactical;
    }

    public int getUserLethal() {
        return userLethal;
    }

    public void setUserLethal(int userLethal) {
        this.userLethal = userLethal;
    }

    public String getUserMelee() {
        return userMelee;
    }

    public void setUserMelee(String userMelee) {
        this.userMelee = userMelee;
    }

    public int getUserPerks() {
        return userPerks;
    }

    public void setUserPerks(int userPerks) {
        this.userPerks = userPerks;
    }

    public String getUserFU() {
        return userFU;
    }

    public void setUserFU(String userFU) {
        this.userFU = userFU;
    }
}
