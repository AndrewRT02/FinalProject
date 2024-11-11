package com.example.finalproject;

public class Perks {
    String perk1;
    String perk2;
    String perk3;
    int perkId;

    public Perks(){

    }

    public Perks(String p1, String p2, String p3, int pId){
        perk1 = p1;
        perk2 = p2;
        perk3 = p3;
        perkId = pId;
    }

    public String getPerk1() {
        return perk1;
    }

    public void setPerk1(String perk1) {
        this.perk1 = perk1;
    }

    public String getPerk2() {
        return perk2;
    }

    public void setPerk2(String perk2) {
        this.perk2 = perk2;
    }

    public String getPerk3() {
        return perk3;
    }

    public void setPerk3(String perk3) {
        this.perk3 = perk3;
    }

    public int getPerkId() {
        return perkId;
    }

    public void setPerkId(int perkId) {
        this.perkId = perkId;
    }
}
