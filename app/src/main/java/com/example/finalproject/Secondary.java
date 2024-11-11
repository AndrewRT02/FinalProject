package com.example.finalproject;

public class Secondary {
    String secondaryName;
    int secondaryId;
    String secondaryOptic;
    String secondaryMuzzle;
    String secondaryBarrel;
    String secondaryMagazine;
    String secondaryGrip;
    int avgSecondaryRating;

    public Secondary(){

    }

    public Secondary(String sN, int sI, String sO, String sM, String sB, String sMG, String sG, int avgSR){
        secondaryName = sN;
        secondaryId = sI;
        secondaryOptic = sO;
        secondaryMuzzle = sM;
        secondaryBarrel = sB;
        secondaryMagazine = sMG;
        secondaryGrip = sG;
        avgSecondaryRating = avgSR;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public int getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(int secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getSecondaryOptic() {
        return secondaryOptic;
    }

    public void setSecondaryOptic(String secondaryOptic) {
        this.secondaryOptic = secondaryOptic;
    }

    public String getSecondaryMuzzle() {
        return secondaryMuzzle;
    }

    public void setSecondaryMuzzle(String secondaryMuzzle) {
        this.secondaryMuzzle = secondaryMuzzle;
    }

    public String getSecondaryBarrel() {
        return secondaryBarrel;
    }

    public void setSecondaryBarrel(String secondaryBarrel) {
        this.secondaryBarrel = secondaryBarrel;
    }

    public String getSecondaryMagazine() {
        return secondaryMagazine;
    }

    public void setSecondaryMagazine(String secondaryMagazine) {
        this.secondaryMagazine = secondaryMagazine;
    }

    public String getSecondaryGrip() {
        return secondaryGrip;
    }

    public void setSecondaryGrip(String secondaryGrip) {
        this.secondaryGrip = secondaryGrip;
    }

    public int getAvgSecondaryRating() {
        return avgSecondaryRating;
    }

    public void setAvgSecondaryRating(int avgSecondaryRating) {
        this.avgSecondaryRating = avgSecondaryRating;
    }
}
