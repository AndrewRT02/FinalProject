package com.example.finalproject;

public class UserPrimary {
    String userPrimaryName;
    String userPrimaryOptic;
    String userPrimaryMuzzle;
    String userPrimaryBarrel;
    String userPrimaryUnderbarrel;
    String userPrimaryStock;

    public UserPrimary(){

    }

    public UserPrimary(String uPN, String uPO, String uPM, String uPB, String  uPUB, String uPS){
        userPrimaryName = uPN;
        userPrimaryOptic = uPO;
        userPrimaryMuzzle = uPM;
        userPrimaryBarrel = uPB;
        userPrimaryUnderbarrel = uPUB;
        userPrimaryStock = uPS;
    }

    public String getUserPrimaryName() {
        return userPrimaryName;
    }

    public void setUserPrimaryName(String userPrimaryName) {
        this.userPrimaryName = userPrimaryName;
    }

    public String getUserPrimaryOptic() {
        return userPrimaryOptic;
    }

    public void setUserPrimaryOptic(String userPrimaryOptic) {
        this.userPrimaryOptic = userPrimaryOptic;
    }

    public String getUserPrimaryMuzzle() {
        return userPrimaryMuzzle;
    }

    public void setUserPrimaryMuzzle(String userPrimaryMuzzle) {
        this.userPrimaryMuzzle = userPrimaryMuzzle;
    }

    public String getUserPrimaryBarrel() {
        return userPrimaryBarrel;
    }

    public void setUserPrimaryBarrel(String userPrimaryBarrel) {
        this.userPrimaryBarrel = userPrimaryBarrel;
    }

    public String getUserPrimaryUnderbarrel() {
        return userPrimaryUnderbarrel;
    }

    public void setUserPrimaryUnderbarrel(String userPrimaryUnderbarrel) {
        this.userPrimaryUnderbarrel = userPrimaryUnderbarrel;
    }

    public String getUserPrimaryStock() {
        return userPrimaryStock;
    }

    public void setUserPrimaryStock(String userPrimaryStock) {
        this.userPrimaryStock = userPrimaryStock;
    }
}
