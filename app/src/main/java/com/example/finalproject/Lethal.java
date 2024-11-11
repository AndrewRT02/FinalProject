package com.example.finalproject;

public class Lethal {
    String lethalName;
    int lethalId;

    public Lethal(){

    }

    public Lethal(String lN, int lI){
        lethalName = lN;
        lethalId = lI;
    }

    public String getLethalName() {
        return lethalName;
    }

    public void setLethalName(String lethalName) {
        this.lethalName = lethalName;
    }

    public int getLethalId() {
        return lethalId;
    }

    public void setLethalId(int lethalId) {
        this.lethalId = lethalId;
    }
}
