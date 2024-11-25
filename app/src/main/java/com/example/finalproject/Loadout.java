package com.example.finalproject;

public class Loadout {
    String username;
    String loadoutName;
    int loadoutId;
    int primary;
    int secondary;
    int tactical;
    int lethal;
    int perks;
    String melee;
    String fieldUpgrade;

    public Loadout(){

    }

    public  Loadout(String u, String lN, int lI, int p, int s, int t, int leth, int pk, String m, String fU){
        username = u;
        loadoutId = lI;
        loadoutName = lN;
        primary = p;
        secondary = s;
        tactical = t;
        lethal = leth;
        perks = pk;
        melee = m;
        fieldUpgrade = fU;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoadoutId() {
        return loadoutId;
    }

    public void setLoadoutId(int loadoutId) {
        this.loadoutId = loadoutId;
    }

    public String getLoadoutName() {
        return loadoutName;
    }

    public void setLoadoutName(String loadoutName) {
        this.loadoutName = loadoutName;
    }

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primaryId) {
        this.primary = primaryId;
    }

    public int getSecondary() {
        return secondary;
    }

    public void setSecondary(int secondaryId) {
        this.secondary = secondaryId;
    }

    public int getTactical() {
        return tactical;
    }

    public void setTactical(int tacticalId) {
        this.tactical = tacticalId;
    }

    public int getLethal() {
        return lethal;
    }

    public void setLethal(int lethalId) {
        this.lethal = lethalId;
    }

    public int getPerks() {
        return perks;
    }

    public void setPerks(int perksId) {
        this.perks = perksId;
    }

    public String getMelee() {
        return melee;
    }

    public void setMelee(String melee) {
        this.melee = melee;
    }

    public String getFieldUpgrade() {
        return fieldUpgrade;
    }

    public void setFieldUpgrade(String fieldUpgrade) {
        this.fieldUpgrade = fieldUpgrade;
    }

}
