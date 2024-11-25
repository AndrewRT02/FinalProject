package com.example.finalproject;

public class Primary {
    String primaryName;
    int primaryId;
    String primaryOptic;
    String primaryMuzzle;
    String primaryBarrel;
    String primaryUnderbarrel;
    String primaryStock;

    public Primary(){

    }

    public Primary(String pN, int pI, String pO, String pM, String pB, String  pUB, String pS){
        primaryName = pN;
        primaryId = pI;
        primaryOptic = pO;
        primaryMuzzle = pM;
        primaryBarrel = pB;
        primaryUnderbarrel = pUB;
        primaryStock = pS;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public int getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(int primaryId) {
        this.primaryId = primaryId;
    }

    public String getPrimaryOptic() {
        return primaryOptic;
    }

    public void setPrimaryOptic(String primaryOptic) {
        this.primaryOptic = primaryOptic;
    }

    public String getPrimaryBarrel() {
        return primaryBarrel;
    }

    public void setPrimaryBarrel(String primaryBarrel) {
        this.primaryBarrel = primaryBarrel;
    }

    public String getPrimaryMuzzle() {
        return primaryMuzzle;
    }

    public void setPrimaryMuzzle(String primaryMuzzle) {
        this.primaryMuzzle = primaryMuzzle;
    }

    public String getPrimaryUnderbarrel() {
        return primaryUnderbarrel;
    }

    public void setPrimaryUnderbarrel(String primaryUnderbarrel) {
        this.primaryUnderbarrel = primaryUnderbarrel;
    }

    public String getPrimaryStock() {
        return primaryStock;
    }

    public void setPrimaryStock(String primaryStock) {
        this.primaryStock = primaryStock;
    }
}
