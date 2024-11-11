package com.example.finalproject;

public class Tactical {
    String tacticalName;
    int tacticalId;

    public Tactical(){

    }

    public Tactical(String tN, int tI){
        tacticalName = tN;
        tacticalId = tI;
    }

    public String getTacticalName() {
        return tacticalName;
    }

    public void setTacticalName(String tacticalName) {
        this.tacticalName = tacticalName;
    }

    public int getTacticalId() {
        return tacticalId;
    }

    public void setTacticalId(int tacticalId) {
        this.tacticalId = tacticalId;
    }
}
