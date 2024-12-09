package com.example.finalproject;

public class UserPerks {
    String userP1;
    String userP2;
    String userP3;

    public UserPerks(){

    }

    public UserPerks(String uP1, String uP2, String uP3){
        userP1 = uP1;
        userP2 = uP2;
        userP3 = uP3;
    }

    public String getUserP1() {
        return userP1;
    }

    public void setUserP1(String userP1) {
        this.userP1 = userP1;
    }

    public String getUserP2() {
        return userP2;
    }

    public void setUserP2(String userP2) {
        this.userP2 = userP2;
    }

    public String getUserP3() {
        return userP3;
    }

    public void setUserP3(String userP3) {
        this.userP3 = userP3;
    }
}
