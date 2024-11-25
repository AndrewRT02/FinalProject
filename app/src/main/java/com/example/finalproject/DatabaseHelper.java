package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String database_name = "UserLoadout.db";
    private static final String user_table_name = "User";
    private static final String loadout_table_name = "Loadout";
    private static final String loadoutRating_table_name = "LoadoutRating";
    private static final String primary_table_name = "'Primary'";
    private static final String primaryRating_table_name = "PrimaryRating";
    private static final String secondary_table_name = "Secondary";
    private static final String secondaryRating_table_name = "SecondaryRating";
    private static final String tactical_table_name = "Tactical";
    private static final String lethal_table_name = "Lethal";
    private static final String perks_table_name = "Perks";

    public DatabaseHelper(Context c){
        super(c, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //users table
        db.execSQL("CREATE TABLE " + user_table_name + " (username String primary key not null, fname String, lname String, email String, age integer);");

        //loadout table
        db.execSQL("CREATE TABLE " + loadout_table_name + " (creator String, loadoutName String, loadoutId integer primary key autoincrement not null, primaryGun integer, secondaryGun integer, tactical integer, lethal integer, perks integer, melee String, fieldUpgrade String, foreign key (creator) references " + user_table_name + " (username), foreign key (primaryGun) references " + primary_table_name + " (primaryId), foreign key (secondaryGun) references " + secondary_table_name + " (secondaryId), foreign key (tactical) references " + tactical_table_name + " (tacticalId), foreign key (lethal) references " + lethal_table_name + " (lethalId), foreign key (perks) references " + perks_table_name + " (perksId));");

        //loadout rating table
        db.execSQL("CREATE TABLE " + loadoutRating_table_name + " (ratingId integer primary key not null, loadoutRating integer, loadoutId integer, foreign key (loadoutId) references " + loadout_table_name + "(loadoutId));");

        //primary's table
        db.execSQL("CREATE TABLE " + primary_table_name + " (primaryName String, primaryId integer primary key autoincrement not null, primaryOptic String, primaryMuzzle String, primaryBarrel String, primaryUnderbarrel String, primaryStock String)");

        //primary rating table
        db.execSQL("CREATE TABLE " + primaryRating_table_name + " (ratingId integer primary key not null, primaryRating integer, loadoutId integer, foreign key (loadoutId) references " + loadout_table_name + "(loadoutId));");

        //secondary table
        db.execSQL("CREATE TABLE " + secondary_table_name + " (secondaryName String, secondaryId integer primary key autoincrement not null, secondaryOptic String, secondaryMuzzle String, secondaryBarrel String, secondaryMagazine String, secondaryGrip String)");

        //secondary rating table
        db.execSQL("CREATE TABLE " + secondaryRating_table_name + " (ratingId integer primary key not null, secondaryRating integer, loadoutId integer, foreign key (loadoutId) references " + loadout_table_name + "(loadoutId));");

        //tactical table
        db.execSQL("CREATE TABLE " + tactical_table_name + " (tacticalName String, tacticalId integer primary key autoincrement not null)");

        //lethal table
        db.execSQL("CREATE TABLE " + lethal_table_name + " (lethalName String, lethalId integer primary key autoincrement not null)");

        //perks table
        db.execSQL("CREATE TABLE " + perks_table_name + " (perksId integer primary key autoincrement not null, perk1 String, perk2 String, perk3 String)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + user_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + loadout_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + loadoutRating_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + primary_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + primaryRating_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + secondary_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + secondaryRating_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + tactical_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + lethal_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + perks_table_name + ";");
    }

    public String getUserDbName(){return user_table_name;}
    public String getLoadoutDbName(){return loadout_table_name;}
    public String getPrimaryDbName(){
        return primary_table_name;
    }
    public String getSecondaryDbName(){
        return secondary_table_name;
    }
    public String getTacticalDbName(){
        return tactical_table_name;
    }
    public String getLethalDbName(){
        return lethal_table_name;
    }
    public String getPerksDbName(){
        return perks_table_name;
    }

    public void initAllTables(){
        initUsers();
        initLoadouts();
        initLoadoutRating();
        initPrimaries();
        initPrimaryRatings();
        initSecondaries();
        initSecondaryRatings();
        initTacticals();
        initLethals();
        initPerks();
    }

    private void initUsers(){
        if (countRecordsFromTables(user_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('ZMoore', 'Zackary', 'Moore', 'zmoore@monroeccc.edu', '32');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('PumpkinEater69', 'Peter', 'Griffin', 'pGriffin31@gmail.com', '41');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('xX_c00lguy_Xx', 'Leroy', 'Jenkins', 'leeerrroooyyy@gmail.com', '26');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Punisher', 'Frank', 'Castle', 'fcastle1974@gmail.com', '35');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Ghost', 'Simon', 'Riley', 'ghostsr141@hotmail.com', '33');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Johnny', 'Jack', 'Torrance', 'jTorrance217@gmail.com', '28');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('ONE', 'Yusuke', 'Murata', 'YusMurata@ShonanJ.com', '46');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('SnrBarricade', 'Andrew', 'Taylor', 'ataylor25980@my.monroeccc.edu', '22');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('HipDogster', 'Snupp', 'Doug', 'snupdog@hotmail.com', '54');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('PettyOfficerHalo', 'John', 'Halo', 'halo3@gmail.com', '44');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('DarkAetherKnight', 'Edward', 'Richtofen', 'bo6@wunderwaffle.com', '64');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Bag-o-Lays', 'Gerald', 'Rivea', 'lastofUs@gmail.com', '98');");


            db.close();
        }
    }
    private void initLoadouts(){
        if (countRecordsFromTables(loadout_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Zmoore', 'DeZtroyer Build', 1, 1, 1, 1, 1, 1, 'Baseball Bat', 'Trophy System');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('PumpkinEater69', 'Petah Build', 2, 2, 2, 2, 2, 2, 'Knife', 'Spring Mine');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('xX_c00lguy_Xx', 'WoW', 3, 3, 3, 3, 3, 3, 'Knife', 'Trophy System');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Punisher', 'BackinNam', 4, 4, 4, 4, 4, 4, 'Baseball Bat', 'Sleeper Agent');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Ghost', 'WannaHearAJoke', 5, 5, 5, 5, 5, 5, 'Knife', 'NeuroGas');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Johnny', 'AnotherDrink', 6, 6, 6, 6, 6, 6, 'Baseball Bat', 'Morphine Injector');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('ONE', 'MobPsycho', 7, 7, 7, 7, 7, 7, 'Knife', 'Sleeper Agent');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('SnrBarricade', 'meh', 8, 8, 8, 8, 8, 8, 'Baseball Bat', 'Assault Pack');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('HipDogster', 'M&M', 9, 9, 9, 9, 9, 9, 'Knife', 'Scrambler');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('PettyOfficerHalo', 'Loadout?', 10, 10, 10, 10, 10, 10, 'Knife', 'War Cry');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('DarkAetherKnight', 'DarkAether', 11, 11, 11, 11, 11, 11, 'Baseball Bat', 'Signal Lure');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Bag-o-Lays', 'bag', 12, 12, 12, 12, 12, 12, 'Knife', 'Tactical Insertion');");


            db.close();
        }
    }
    private void initLoadoutRating(){
        if (countRecordsFromTables(loadoutRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (1, '5', 1);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (2, '4', 2);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (3, '5', 3);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (4, '2', 4);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (5, '3', 5);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (6, '2', 6);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (7, '3', 7);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (8, '5', 8);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (9, '4', 9);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (10, '3', 10);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (11, '1', 11);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (12, '3', 12);");

            db.close();
        }
    }
    private void initPrimaries(){
        if (countRecordsFromTables(primary_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('C9', 1, 'K&S Thermal Holo', 'Compensator', 'Long Barrel', 'Vertical Grip', 'No Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('XM4', 2, 'PrismaTech 4', 'Muzzle Brake', 'Gain-Twist Barrel', 'Marksman Foregrip', 'Buffer Weight Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('Model L', 3, 'Merlin Reflex', 'Suppressor', 'Short Barrel', 'Launcher - High Explosive', 'Light Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('PU-21', 4, 'Volzhskiy Reflex', 'Compensator', 'CHF Barrel', 'Precision Foregrip', 'Combat Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('SWAT 5.56', 5, 'Hawker Hybrid', 'Muzzle Brake', 'Long Barrel', 'Precision Barrel', 'Heavy Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('TANTO .22', 6, 'PrismaTech Reflex', 'Compensator', 'Short Barrel', 'Vertical Foregrip', 'Balanced Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('LR 7.62', 7, 'Iron Sights', 'Muzzle Brake', 'Reinforced Barrel', 'Precision Foregrip', 'Buffer Weight Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('AK-74', 8, 'Merlin Reflex', 'Compensator', 'Long Barrel', 'Launcher - Standard', 'Combat Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('KOMPAKT 92', 9, 'Iron Sights', 'Ported Compensator', 'Gain-Twist Barrel', 'Vertical Foregrip', 'Infiltrator Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('GOBLIN MK2', 10, 'R&K Multizoom', 'Suppressor', 'Short Barrel', 'Precision Foregrip', 'Heavy Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('AEK-973', 11, 'PrismaPoint Hybrid', 'Compensator', 'CHF Barrel', 'Launcher - High Explosive', 'No Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('XM4', 12, 'Kepler Microflex', 'Suppressor', 'Short Barrel', 'Lightweight Foregrip', 'Infiltrator Stock')");

            db.close();
        }
    }
    private void initPrimaryRatings(){
        if (countRecordsFromTables(primaryRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (1, '5', 1);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (2, '5', 2);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (3, '3', 3);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (4, '2', 4);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (5, '1', 5);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (6, '5', 6);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (7, '4', 7);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (8, '5', 8);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (9, '4', 9);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (10, '3', 10);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (11, '3', 11);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (12, '4', 12);");

            db.close();
        }
    }
    private void initSecondaries(){
        if (countRecordsFromTables(secondary_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('9mm PM', 1, 'Iron Sight', 'Suppresor', 'Long Barrel', 'Extended Magazine', 'Quickdraw Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GS45', 2, 'Kepler Microflex', 'Compensator', 'CHF Barrel', 'Fast Mag I', 'Assault Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GS45', 3, 'Merlin Mini', 'Suppressor', 'Short Barrel', 'Extended Mag II', 'CQB Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GREKHOVA', 4, 'Accu-Spot Reflex', 'Ported Compensator', 'Reinforced Barrel', 'Fast Mag II', 'CQB Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('STRYDER .22', 5, 'Iron Sights', 'Long Barrel', 'Extended Mag I', 'Commando Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GREKHOVA', 6, 'Otero Micro Dot', 'Gain-Twist Barrel', 'Fast Magg II', 'Ergonomic Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('STRYDER .22', 7, 'Kepler Pistol Scope', 'Muzzle Brake', 'Long Barrel', 'Extended Mag II', 'Ergonomic Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('9mm PM', 8, 'Iron Sights', 'Ported Compensator', 'CHF Barrel', 'Stock Mag', 'CQB Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('9mm PM', 9, 'Iron Sights', 'Suppressor', 'Gain-Twisted Barrel', 'Fast Mag II', 'Commando Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GS45', 10, 'Kepler Microflex', 'Muzzle Brake', 'Reinforced Barrel', 'Stock Mag', 'Assault Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('Stryder .22', 11, 'Accu-Spot Reflex', 'Compensator', 'Short Barrel', 'Extended Mag I', 'Quickdraw Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GREKHOVA', 12, 'Otero Micro Dot', 'Suppressor', 'Long Barrel', 'Fast Mag I', 'Assault Grip')");

            db.close();
        }
    }
    private void initSecondaryRatings(){
        if (countRecordsFromTables(secondaryRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (1, '3', 1);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (2, '2', 2);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (3, '5', 3);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (4, '4', 4);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (5, '1', 5);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (6, '2', 6);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (7, '5', 7);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (8, '4', 8);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (9, '4', 9);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (10, '5', 10);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (11, '3', 11);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (12, '3', 12);");

            db.close();
        }
    }
    private void initTacticals(){
        if (countRecordsFromTables(tactical_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Shock Charge', 1);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Smoke', 2);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Concussion', 3);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Spy Cam', 4);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Decoy', 5);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Flashbang', 6);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Shock Charge', 7);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Stim Shot', 8);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Prox Alarm', 9);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Flashbang', 10);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Consussion', 11);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Stim Shot', 12);");

            db.close();
        }
    }
    private void initLethals(){
        if (countRecordsFromTables(lethal_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Thermo Grenade', 1);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Frag', 2);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Blast Charge', 3);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Combat Axe', 4);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('C4', 5);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Impact Grenade', 6);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Molotov', 7);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Semtex', 8);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Frag', 9);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Semtex', 10);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Combat Axe', 11);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Drill Charge', 12);");

            db.close();
        }
    }
    private void initPerks(){
        if (countRecordsFromTables(perks_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (1, 'Gung-Ho', 'Shadow', 'Quartermaster');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (2, 'Dexterity', 'Assassin', 'Double Time');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (3, 'Ninja', 'Tracker', 'Cold-Blooded');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (4, 'Flak Jacket', 'Forward Intel', 'Guardian');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (5, 'Tac Mask', 'Dispatcher', 'Gearhead');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (6, 'Ghost', 'Fast Hands', 'Bankroll');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (7, 'Gung-Ho', 'Engineer', 'Vigilance');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (8, 'Scavenger', 'Bruiser', 'Bankroll');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (9, 'Ghost', 'Shadow', 'Double Time');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (10, 'Flak Jacket', 'Assassin', 'Quartermaster');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (11, 'Dexterity', 'Fast Hands', 'Cold-Blooded');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (12, 'Tac Mask', 'Engineer', 'Gearhead');");

            db.close();
        }
    }

    public int countRecordsFromTables(String tableName){
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);

        db.close();

        return numRows;
    }

    public ArrayList<Loadout> allLoadoutsLiist(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + loadout_table_name, null);

        ArrayList<Loadout> loadoutArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                loadoutArrayList.add(new Loadout(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getString(8),
                        cursor.getString(9))
                );
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        return loadoutArrayList;
    }
}
