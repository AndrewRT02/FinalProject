package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        db.execSQL("CREATE TABLE " + primaryRating_table_name + " (ratingId integer primary key not null, primaryRating integer, loadoutId integer, foreign key (loadoutId) references " + primary_table_name + "(primaryId));");

        //secondary table
        db.execSQL("CREATE TABLE " + secondary_table_name + " (secondaryName String, secondaryId integer primary key autoincrement not null, secondaryOptic String, secondaryMuzzle String, secondaryBarrel String, secondaryMagazine String, secondaryGrip String)");

        //secondary rating table
        db.execSQL("CREATE TABLE " + secondaryRating_table_name + " (ratingId integer primary key not null, secondaryRating integer, loadoutId integer, foreign key (loadoutId) references " + secondary_table_name + "(secondaryId));");

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

        onCreate(db);
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

            //db.execSQL("DROP TABLE IF EXISTS " + user_table_name + ";");
            ////users table
            //db.execSQL("CREATE TABLE " + user_table_name + " (username String primary key not null, fname String, lname String, email String, age integer);");

            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('ZMoore', 'Zackary', 'Moore', 'zmoore@monroeccc.edu', '32');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('PumpkinEater69', 'Peter', 'Griffin', 'pGriffin31@gmail.com', '41');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('xX_c00lguy_Xx', 'Leroy', 'Jenkins', 'leeerrroooyyy@gmail.com', '26');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Punisher', 'Frank', 'Castle', 'fcastle1974@gmail.com', '35');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Ghost', 'Simon', 'Riley', 'ghostsr141@hotmail.com', '33');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('Johnny', 'Jack', 'Torrance', 'jTorrance217@gmail.com', '28');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('ONE', 'Yusuke', 'Murata', 'YusMurata@ShonanJ.com', '46');");
            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('SnrBarricade', 'Andrew', 'Taylor', 'ataylor25980@my.monroeccc.edu', '22');");

            db.close();
        }
    }
    private void initLoadouts(){
        if (countRecordsFromTables(loadout_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + loadout_table_name + ";");
            ////loadout table
            //db.execSQL("CREATE TABLE " + loadout_table_name + " (creator String, loadoutName String, loadoutId integer primary key autoincrement not null, primaryGun integer, secondaryGun integer, tactical integer, lethal integer, perks integer, melee String, fieldUpgrade String, foreign key (creator) references " + user_table_name + " (username), foreign key (primaryGun) references " + primary_table_name + " (primaryId), foreign key (secondaryGun) references " + secondary_table_name + " (secondaryId), foreign key (tactical) references " + tactical_table_name + " (tacticalId), foreign key (lethal) references " + lethal_table_name + " (lethalId), foreign key (perks) references " + perks_table_name + " (perksId));");


            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('ZMoore', 'DeZtroyer Build', 1, 1, 1, 1, 1, 1, 'Baseball Bat', 'Trophy System');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('PumpkinEater69', 'Petah Build', 2, 2, 2, 2, 2, 2, 'Knife', 'Spring Mine');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('xX_c00lguy_Xx', 'WoW', 3, 3, 3, 3, 3, 3, 'Knife', 'Trophy System');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Punisher', 'BackinNam', 4, 4, 4, 4, 4, 4, 'Baseball Bat', 'Sleeper Agent');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Ghost', 'WannaHearAJoke', 5, 5, 5, 5, 5, 5, 'Knife', 'NeuroGas');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Johnny', 'AnotherDrink', 6, 6, 6, 6, 6, 6, 'Baseball Bat', 'Morphine Injector');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('ONE', 'MobPsycho', 7, 7, 7, 7, 7, 7, 'Knife', 'Sleeper Agent');");
            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('SnrBarricade', 'meh', 8, 8, 8, 8, 8, 8, 'Baseball Bat', 'Assault Pack');");

            db.close();
        }
    }
    private void initLoadoutRating(){
        if (countRecordsFromTables(loadoutRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + loadoutRating_table_name + ";");
            ////loadout rating table
            //db.execSQL("CREATE TABLE " + loadoutRating_table_name + " (ratingId integer primary key not null, loadoutRating integer, loadoutId integer, foreign key (loadoutId) references " + loadout_table_name + "(loadoutId));");


            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (1, '5', 1);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (2, '4', 2);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (3, '5', 3);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (4, '2', 4);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (5, '3', 5);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (6, '2', 6);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (7, '3', 7);");
            db.execSQL("INSERT INTO " + loadoutRating_table_name + "(ratingId, loadoutRating, loadoutId) VALUES (8, '5', 8);");

            db.close();
        }
    }
    private void initPrimaries(){
        if (countRecordsFromTables(primary_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + primary_table_name + ";");
            ////primary's table
            //db.execSQL("CREATE TABLE " + primary_table_name + " (primaryName String, primaryId integer primary key autoincrement not null, primaryOptic String, primaryMuzzle String, primaryBarrel String, primaryUnderbarrel String, primaryStock String)");

            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('C9', 1, 'K&S Thermal Holo', 'Compensator', 'Long Barrel', 'Vertical Grip', 'No Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('XM4', 2, 'PrismaTech 4', 'Muzzle Brake', 'Gain-Twist Barrel', 'Marksman Foregrip', 'Buffer Weight Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('Model L', 3, 'Merlin Reflex', 'Suppressor', 'Short Barrel', 'Launcher - High Explosive', 'Light Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('PU-21', 4, 'Volzhskiy Reflex', 'Compensator', 'CHF Barrel', 'Precision Foregrip', 'Combat Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('SWAT 5.56', 5, 'Hawker Hybrid', 'Muzzle Brake', 'Long Barrel', 'Precision Barrel', 'Heavy Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('TANTO .22', 6, 'PrismaTech Reflex', 'Compensator', 'Short Barrel', 'Vertical Foregrip', 'Balanced Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('LR 7.62', 7, 'Iron Sights', 'Muzzle Brake', 'Reinforced Barrel', 'Precision Foregrip', 'Buffer Weight Stock')");
            db.execSQL("INSERT INTO " + primary_table_name + " (primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('AK-74', 8, 'Merlin Reflex', 'Compensator', 'Long Barrel', 'Launcher - Standard', 'Combat Stock')");

            db.close();
        }
    }
    private void initPrimaryRatings(){
        if (countRecordsFromTables(primaryRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + primaryRating_table_name + ";");
            ////primary rating table
            //db.execSQL("CREATE TABLE " + primaryRating_table_name + " (ratingId integer primary key not null, primaryRating integer, loadoutId integer, foreign key (loadoutId) references " + primary_table_name + "(primaryId));");


            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (1, '5', 1);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (2, '5', 2);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (3, '3', 3);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (4, '2', 4);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (5, '1', 5);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (6, '5', 6);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (7, '4', 7);");
            db.execSQL("INSERT INTO " + primaryRating_table_name + " (ratingId, primaryRating, loadoutId) VALUES (8, '5', 8);");

            db.close();
        }
    }
    private void initSecondaries() {
        if (countRecordsFromTables(secondary_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + secondary_table_name + ";");
            ////secondary table
            //db.execSQL("CREATE TABLE " + secondary_table_name + " (secondaryName String, secondaryId integer primary key autoincrement not null, secondaryOptic String, secondaryMuzzle String, secondaryBarrel String, secondaryMagazine String, secondaryGrip String)");


            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('9MM PM', 1, 'Iron Sight', 'Suppresor', 'Long Barrel', 'Extended Magazine', 'Quickdraw Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GS45', 2, 'Kepler Microflex', 'Compensator', 'CHF Barrel', 'Fast Mag I', 'Assault Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GS45', 3, 'Merlin Mini', 'Suppressor', 'Short Barrel', 'Extended Mag II', 'CQB Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GREKHOVA', 4, 'Accu-Spot Reflex', 'Ported Compensator', 'Reinforced Barrel', 'Fast Mag II', 'CQB Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('STRYDER .22', 5, 'Iron Sights', 'Ported Compensator', 'Long Barrel', 'Extended Mag I', 'Commando Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('GREKHOVA', 6, 'Otero Micro Dot', 'Compensator', 'Gain-Twist Barrel', 'Fast Magg II', 'Ergonomic Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('STRYDER .22', 7, 'Kepler Pistol Scope', 'Muzzle Brake', 'Long Barrel', 'Extended Mag II', 'Ergonomic Grip')");
            db.execSQL("INSERT INTO " + secondary_table_name + " (secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('9MM PM', 8, 'Iron Sights', 'Ported Compensator', 'CHF Barrel', 'Stock Mag', 'CQB Grip')");

            db.close();
        }
    }
    private void initSecondaryRatings(){
        if (countRecordsFromTables(secondaryRating_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + secondaryRating_table_name + ";");
            ////secondary rating table
            //db.execSQL("CREATE TABLE " + secondaryRating_table_name + " (ratingId integer primary key not null, secondaryRating integer, loadoutId integer, foreign key (loadoutId) references " + secondary_table_name + "(secondaryId));");


            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (1, '3', 1);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (2, '2', 2);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (3, '5', 3);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (4, '4', 4);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (5, '1', 5);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (6, '2', 6);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (7, '5', 7);");
            db.execSQL("INSERT INTO " + secondaryRating_table_name + " (ratingId, secondaryRating, loadoutId) VALUES (8, '4', 8);");


            db.close();
        }
    }
    private void initTacticals(){
        if (countRecordsFromTables(tactical_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + tactical_table_name + ";");
            ////tactical table
            //db.execSQL("CREATE TABLE " + tactical_table_name + " (tacticalName String, tacticalId integer)");


            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Concussion', 1);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Flashbang', 2);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Spy Cam', 3);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Smoke', 4);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Prox Alarm', 5);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Stim Shot', 6);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Decoy', 7);");
            db.execSQL("INSERT INTO " + tactical_table_name + " (tacticalName, tacticalId) VALUES ('Shock Charge', 8);");

            db.close();
        }
    }
    private void initLethals(){
        if (countRecordsFromTables(lethal_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + lethal_table_name + ";");
            ////lethal table
            //db.execSQL("CREATE TABLE " + lethal_table_name + " (lethalName String, lethalId integer)");


            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Frag', 1);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Semtex', 2);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('C4', 3);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Thermo Grenade', 4);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Impact Grenade', 5);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Molotov', 6);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Blast Charge', 7);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Drill Charge', 8);");
            db.execSQL("INSERT INTO " + lethal_table_name + " (lethalName, lethalId) VALUES ('Combat Axe', 9);");

            db.close();
        }
    }
    private void initPerks(){
        if (countRecordsFromTables(perks_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL("DROP TABLE IF EXISTS " + perks_table_name + ";");
            ////perks table
            //db.execSQL("CREATE TABLE " + perks_table_name + " (perksId integer primary key autoincrement not null, perk1 String, perk2 String, perk3 String)");

            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (1, 'Gung-Ho', 'Shadow', 'Quartermaster');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (2, 'Dexterity', 'Assassin', 'Double Time');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (3, 'Ninja', 'Tracker', 'Cold-Blooded');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (4, 'Flak Jacket', 'Forward Intel', 'Guardian');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (5, 'Tac Mask', 'Dispatcher', 'Gearhead');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (6, 'Ghost', 'Fast Hands', 'Bankroll');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (7, 'Gung-Ho', 'Engineer', 'Vigilance');");
            db.execSQL("INSERT INTO " + perks_table_name + " (perksId, perk1, perk2, perk3) VALUES (8, 'Scavenger', 'Bruiser', 'Bankroll');");

            db.close();
        }
    }

    public int countRecordsFromTables(String tableName){
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);

        db.close();

        return numRows;
    }

    public ArrayList<User> allUsersList(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + user_table_name, null);

        ArrayList<User> userArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                userArrayList.add(new User(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4))
                );
            }
            while(cursor.moveToNext());
        }

        cursor.close();

        return userArrayList;
    }

    public ArrayList<Loadout> allLoadoutsList(){
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

    public ArrayList<Loadout> allLoadoutsListGivenUsername(String u){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + loadout_table_name + " WHERE creator = '" + u +"';";

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Loadout> usersLoadoutArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                usersLoadoutArrayList.add(new Loadout(
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

        //Log.d("Pumpkin", usersLoadoutArrayList.get(0).getLoadoutName());

        return usersLoadoutArrayList;
    }

    public ArrayList<Primary> allPrimariesList(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + primary_table_name, null);

        ArrayList<Primary> primaryArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                primaryArrayList.add(new Primary(
                        cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6))
                );
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        return primaryArrayList;
    }

    public ArrayList<Secondary> allSecondariesList(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + secondary_table_name, null);

        ArrayList<Secondary> secondaryArrayList = new ArrayList<>();

        Log.d("SECONDARIES", String.valueOf(cursor.getCount()));

        if (cursor.moveToFirst()){
            do {
                secondaryArrayList.add(new Secondary(
                        cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6))
                );
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        return secondaryArrayList;
    }

    public String getPrimaryNameFromId(int Id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT primaryName FROM " + primary_table_name + " WHERE primaryId= '" + Id + "';";

        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        //Log.d("Blueberry", cursor.getString(0));

        db.close();

        return cursor.getString(0);
    }

    public Double getLoadoutRatingFromId(int Id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT AVG(loadoutRating) FROM " + loadoutRating_table_name + " WHERE loadoutId= '" + Id + "';";

        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        //Log.d("Blueberry", cursor.getString(0));

        db.close();

        return cursor.getDouble(0);
    }

    public String getSecondaryNameFromId(int Id){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT secondaryName FROM " + secondary_table_name + " WHERE secondaryId= '" + Id + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        //Log.d("Blueberry", cursor.getString(0));

        db.close();

        return cursor.getString(0);
    }

    public void createUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('" + u.getUname() + "', '" + u.getFname() + "', '" + u.getLname() + "', '" + u.getEmail() + "', '" + u.getAge() + "');";

        db.execSQL(query);

        db.close();
    }

    public void createLoadoutRating(int lr, int lId){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + loadoutRating_table_name + "(loadoutRating, loadoutId) VALUES ('" + lr + "', '" + lId + "');";

        db.execSQL(query);
        db.close();
    }

    public void getAllUserInfoGivenUsername(String u){
        SQLiteDatabase db = this.getReadableDatabase();

        User registeredUser = new User();

        String query;
        query = "SELECT * FROM " + user_table_name + " WHERE username = '" + u + "';";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredUser.setUname(cursor.getString(0));
            registeredUser.setFname(cursor.getString(1));
            registeredUser.setLname(cursor.getString(2));
            registeredUser.setEmail(cursor.getString(3));
            registeredUser.setAge(cursor.getInt(4));

            SessionData.setRegisteredUser(registeredUser);
        }

        db.close();
    }

    public void getAllLoadoutInfoGivenLoadoutId(int i){
        Loadout registeredLoadout = new Loadout();

        String query;
        query = "SELECT * FROM " + loadout_table_name + " WHERE loadoutId= '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredLoadout.setUsername(cursor.getString(0));
            registeredLoadout.setLoadoutName(cursor.getString(1));
            registeredLoadout.setLoadoutId(cursor.getInt(2));
            registeredLoadout.setPrimary(cursor.getInt(3));
            registeredLoadout.setSecondary(cursor.getInt(4));
            registeredLoadout.setTactical(cursor.getInt(5));
            registeredLoadout.setLethal(cursor.getInt(6));
            registeredLoadout.setPerks(cursor.getInt(7));
            registeredLoadout.setMelee(cursor.getString(8));
            registeredLoadout.setFieldUpgrade(cursor.getString(9));

            LoadoutSessionData.setRegisteredLoadout(registeredLoadout);
        }
        else {
            LoadoutSessionData.setRegisteredLoadout(null);
        }
        db.close();
    }

    public Loadout getLoadoutInfoGivenLoadoutId(int i){
        Loadout registeredLoadout = new Loadout();

        String query;
        query = "SELECT * FROM " + loadout_table_name + " WHERE loadoutId= '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredLoadout.setUsername(cursor.getString(0));
            registeredLoadout.setLoadoutName(cursor.getString(1));
            registeredLoadout.setLoadoutId(cursor.getInt(2));
            registeredLoadout.setPrimary(cursor.getInt(3));
            registeredLoadout.setSecondary(cursor.getInt(4));
            registeredLoadout.setTactical(cursor.getInt(5));
            registeredLoadout.setLethal(cursor.getInt(6));
            registeredLoadout.setPerks(cursor.getInt(7));
            registeredLoadout.setMelee(cursor.getString(8));
            registeredLoadout.setFieldUpgrade(cursor.getString(9));

            LoadoutSessionData.setRegisteredLoadout(registeredLoadout);
        }
        else {
            LoadoutSessionData.setRegisteredLoadout(null);
        }


        db.close();

        return LoadoutSessionData.getRegisteredLoadout();
    }

    public Loadout loadoutGivenFieldUpgrade(String fU){
        Loadout registeredLoadout = new Loadout();

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + loadout_table_name + " WHERE fieldUpgrade = '" + fU + "';";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredLoadout.setUsername(cursor.getString(0));
            registeredLoadout.setLoadoutName(cursor.getString(1));
            registeredLoadout.setLoadoutId(cursor.getInt(2));
            registeredLoadout.setPrimary(cursor.getInt(3));
            registeredLoadout.setSecondary(cursor.getInt(4));
            registeredLoadout.setTactical(cursor.getInt(5));
            registeredLoadout.setLethal(cursor.getInt(6));
            registeredLoadout.setPerks(cursor.getInt(7));
            registeredLoadout.setMelee(cursor.getString(8));
            registeredLoadout.setFieldUpgrade(cursor.getString(9));

            LoadoutSessionData.setRegisteredLoadout(registeredLoadout);
        }
        else {
            LoadoutSessionData.setRegisteredLoadout(null);
        }


        db.close();

        return LoadoutSessionData.getRegisteredLoadout();
    }

    public Loadout allLoadoutListGivenLoadoutId(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + loadout_table_name + " WHERE loadoutId = '" + i +"';";

        Cursor cursor = db.rawQuery(query, null);

        Loadout l = new Loadout();

        if (cursor.moveToFirst()){new Loadout(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getString(8),
                        cursor.getString(9)); ;
        }
        cursor.close();

        //Log.d("Pumpkin", usersLoadoutArrayList.get(0).getLoadoutName());

        return l;
    }

    public void getAllLoadoutRatingInfoGivenLoadoutId(int i){
        LoadoutRating registeredLoadoutRating = new LoadoutRating();

        String query;
        query = "SELECT * FROM " + loadoutRating_table_name + " WHERE loadoutId = '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        //ratingId, loadoutRating, loadoutId

        if (cursor != null){
            cursor.moveToFirst();

            registeredLoadoutRating.setRatingId(cursor.getInt(0));
            registeredLoadoutRating.setLoadoutRating(cursor.getInt(1));
            registeredLoadoutRating.setLoadoutId(cursor.getInt(2));

            LoadoutRatingSessionData.setRegisteredLoadoutRating(registeredLoadoutRating);
        }
        else {
            LoadoutRatingSessionData.setRegisteredLoadoutRating(null);
        }
        db.close();
    }

    public int getLethalInforGivenCreatorAndLoadoutName(String c, String lN){
        Loadout l = new Loadout();

        String query;
        query = "SELECT * FROM " + loadout_table_name + " WHERE creator = '" + c + "' AND loadoutName = '" + lN + "';"; ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            cursor.moveToFirst();

            l.setUsername(cursor.getString(0));
            l.setLoadoutName(cursor.getString(1));
            l.setLoadoutId(cursor.getInt(2));
            l.setPrimary(cursor.getInt(3));
            l.setSecondary(cursor.getInt(4));
            l.setTactical(cursor.getInt(5));
            l.setLethal(cursor.getInt(6));
            l.setPerks(cursor.getInt(7));
            l.setMelee(cursor.getString(8));
            l.setFieldUpgrade(cursor.getString(9));
        }

        db.close();

        return cursor.getInt(6);
    }

    public int getTacticalInforGivenCreatorAndLoadoutName(String c, String lN){
        Loadout l = new Loadout();

        String query;
        query = "SELECT * FROM " + loadout_table_name + " WHERE creator = '" + c + "' AND loadoutName = '" + lN + "';"; ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            cursor.moveToFirst();

            l.setUsername(cursor.getString(0));
            l.setLoadoutName(cursor.getString(1));
            l.setLoadoutId(cursor.getInt(2));
            l.setPrimary(cursor.getInt(3));
            l.setSecondary(cursor.getInt(4));
            l.setTactical(cursor.getInt(5));
            l.setLethal(cursor.getInt(6));
            l.setPerks(cursor.getInt(7));
            l.setMelee(cursor.getString(8));
            l.setFieldUpgrade(cursor.getString(9));
        }

        db.close();

        return cursor.getInt(5);
    }

    public void getAllPrimaryInfoGivenId(int i){
        Primary registeredPrimary = new Primary();

        String query = "SELECT * FROM " + primary_table_name + " WHERE primaryId = '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredPrimary.setPrimaryName(cursor.getString(0));
            registeredPrimary.setPrimaryId(cursor.getInt(1));
            registeredPrimary.setPrimaryOptic(cursor.getString(2));
            registeredPrimary.setPrimaryMuzzle(cursor.getString(3));
            registeredPrimary.setPrimaryBarrel(cursor.getString(4));
            registeredPrimary.setPrimaryUnderbarrel(cursor.getString(5));
            registeredPrimary.setPrimaryStock(cursor.getString(6));

            PrimarySessionData.setRegisteredPrimary(registeredPrimary);
        }
        else {
            PrimarySessionData.setRegisteredPrimary(null);
        }

        db.close();
    }

//    public int getPrimaryIdGivenPrimaryGun(int i){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + primary_table_name + " WHERE primaryId = '" + i + "';";
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor != null){
//            cursor.moveToFirst();
//
//            (cursor.getString(0));
//            (cursor.getInt(1));
//            (cursor.getString(2));
//            (cursor.getString(3));
//            (cursor.getString(4));
//            (cursor.getString(5));
//            (cursor.getString(6));
//        }
//
//  }

    public void setUserPrimaryInfo(String p, String o, String m, String b, String uB, String s){
        UserPrimary uPrimary = new UserPrimary();

        uPrimary.setUserPrimaryName(p);
        uPrimary.setUserPrimaryOptic(o);
        uPrimary.setUserPrimaryMuzzle(m);
        uPrimary.setUserPrimaryBarrel(b);
        uPrimary.setUserPrimaryUnderbarrel(uB);
        uPrimary.setUserPrimaryStock(s);

        MakePrimarySessionData.setPrimaryParts(uPrimary);
    }

    public void createPrimary(UserPrimary uP){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + primary_table_name + " (primaryName, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock) VALUES ('" + uP.getUserPrimaryName() + "', '" + uP.getUserPrimaryOptic() + "', '" + uP.getUserPrimaryMuzzle() + "', '" + uP.getUserPrimaryBarrel() + "', '" + uP.getUserPrimaryUnderbarrel() + "', '" + uP.getUserPrimaryStock() + "');";

        db.execSQL(query);
        db.close();
    }

    public void getAllSecondaryInfoGivenID(int i){
        Secondary registeredSecondary = new Secondary();

        String query = "SELECT * FROM " + secondary_table_name + " WHERE secondaryId = '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredSecondary.setSecondaryName(cursor.getString(0));
            registeredSecondary.setSecondaryId(cursor.getInt(1));
            registeredSecondary.setSecondaryOptic(cursor.getString(2));
            registeredSecondary.setSecondaryMuzzle(cursor.getString(3));
            registeredSecondary.setSecondaryBarrel(cursor.getString(4));
            registeredSecondary.setSecondaryMagazine(cursor.getString(5));
            registeredSecondary.setSecondaryGrip(cursor.getString(6));

            SecondarySessionData.setRegisteredSecondary(registeredSecondary);
        }
        else {
            SecondarySessionData.setRegisteredSecondary(null);
        }

        db.close();
    }

    public void createSecondary(UserSecondary uS){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + secondary_table_name + " (secondaryName, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip) VALUES ('" + uS.getUserSecondaryName() + "', '" + uS.getUserSecondaryOptic() + "', '" + uS.getUserSecondaryMuzzle() + "', '" + uS.getUserSecondaryBarrel() + "', '" + uS.getUserSecondaryMag() + "', '" + uS.getUserSecondaryGrip() + "');";

        db.execSQL(query);
        db.close();
    }

    public void setUserSecondaryInfo(String s, String o, String m, String b, String mag, String g){
        UserSecondary uSecondary = new UserSecondary();

        uSecondary.setUserSecondaryName(s);
        uSecondary.setUserSecondaryOptic(o);
        uSecondary.setUserSecondaryMuzzle(m);
        uSecondary.setUserSecondaryBarrel(b);
        uSecondary.setUserSecondaryMag(mag);
        uSecondary.setUserSecondaryGrip(g);

        MakeSecondarySessionData.setSecondaryParts(uSecondary);
    }

    public void setUserPerksInfo(String uP1, String uP2, String uP3){
        UserPerks uPerks = new UserPerks();

        uPerks.setUserP1(uP1);
        uPerks.setUserP2(uP2);
        uPerks.setUserP3(uP3);

        MakePerksSessionData.setPerksParts(uPerks);
    }

    public void createPerks(UserPerks uP){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + perks_table_name + " (perk1, perk2, perk3) VALUES ('" + uP.getUserP1() + "', '" + uP.getUserP2() + "', '" + uP.getUserP3() + "');";

        db.execSQL(query);
        db.close();
    }

    public void createLoadout(UserLoadout uL){
        SQLiteDatabase db = this.getWritableDatabase();

        String query;
        query = "INSERT INTO " + loadout_table_name + "(creator, loadoutName, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('" + uL.getCreator() + "', '" + uL.getUserLoadoutName() + "', '" + uL.getUserPrimary() + "', '" + uL.getUserSecondary() + "', '" + uL.getUserTactical() + "', '" + uL.getUserLethal() + "', '" + uL.getUserPerks() + "', '" + uL.getUserMelee() + "', '" + uL.getUserFU() + "');";

        db.execSQL(query);
        db.close();
    }

    public void getAllTacticalInfoGivenID(int i){
        Tactical registeredTactical = new Tactical();

        String query = "SELECT * FROM " + tactical_table_name + " WHERE tacticalId = '" + i + "';";

        TacticalSessionData.setRegisteredTactical(null);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredTactical.setTacticalName(cursor.getString(0));
            registeredTactical.setTacticalId(cursor.getInt(1));

            TacticalSessionData.setRegisteredTactical(registeredTactical);
        }
        else {
            TacticalSessionData.setRegisteredTactical(null);
        }
        db.close();
    }

    public void getAllLethalInfoGivenID(int i){
        Lethal registeredLethal = new Lethal();

        String query = "SELECT * FROM " + lethal_table_name + " WHERE lethalId = '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredLethal.setLethalName(cursor.getString(0));
            registeredLethal.setLethalId(cursor.getInt(1));

            LethalSessionData.setRegisteredLethal(registeredLethal);
        }
        else {
            LethalSessionData.setRegisteredLethal(registeredLethal);
        }
        db.close();
    }

    public void getAllPerksInfoGivenID(int i){
        Perks registeredPerks = new Perks();

        String query = "SELECT * FROM " + perks_table_name + " WHERE perksId = '" + i + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null){
            cursor.moveToFirst();

            registeredPerks.setPerkId(cursor.getInt(0));
            registeredPerks.setPerk1(cursor.getString(1));
            registeredPerks.setPerk2(cursor.getString(2));
            registeredPerks.setPerk3(cursor.getString(3));

            PerksSessionData.setRegisteredPerks(registeredPerks);
        }
        else {
            PerksSessionData.setRegisteredPerks(null);
        }
        db.close();
    }

    public void updateUser(String u, String fn, String ln, String e, int a){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE " + user_table_name + " SET fname = '" + fn + "', lname = '" + ln + "',  email = '" + e + "', age = '" + a + "' WHERE username = '" + u + "';";

        db.execSQL(query);

        db.close();
    }

    public void updateLoadout(String c, int lId, String lN, int t, int l, String m, String fU){
        SQLiteDatabase db = this.getWritableDatabase();

        //creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade

        String query = "UPDATE " + loadout_table_name + " SET loadoutName = '" + lN + "', tactical = '" + t + "', lethal = '" + l + "', melee = '" + m + "', fieldUpgrade = '" + fU + "' WHERE creator = '" + c + "' AND loadoutId = '" + lId + "';";

        db.execSQL(query);
        db.close();
    }

    public void updatePrimary(String pN, String pO, String pM, String pB, String pUB, String pS, int pId){
        SQLiteDatabase db = this.getWritableDatabase();
        //primaryName, primaryId, primaryOptic, primaryMuzzle, primaryBarrel, primaryUnderbarrel, primaryStock

        String query = "UPDATE " + primary_table_name + " SET primaryName = '" + pN + "', primaryOptic = '" + pO + "', primaryMuzzle = '" + pM + "', primaryBarrel = '" + pB + "', primaryUnderbarrel = '" + pUB + "', primaryStock = '" + pS + "' WHERE primaryId = '" + pId + "';";

        db.execSQL(query);
        db.close();
    }

    public void updateSecondary(String sN, String sO, String sM, String sB, String pMag, String pG, int sId){
        SQLiteDatabase db = this.getWritableDatabase();
        //secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip

        String query = "UPDATE " + secondary_table_name + " SET secondaryName = '" + sN + "', secondaryOptic = '" + sO + "', secondaryMuzzle = '" + sM + "', secondaryBarrel = '" + sB + "', secondaryMagazine = '" + pMag + "', secondaryGrip = '" + pG + "' WHERE secondaryId = '" + sId + "';";

        db.execSQL(query);
        db.close();
    }

    public void deleteUser(String u){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + user_table_name + " WHERE username = '" + u + "';";

        db.execSQL(query);

        db.close();
    }

    public void deleteLoadout(int LoadId){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + loadout_table_name + " WHERE loadoutId = '" + LoadId + "';";

        db.execSQL(query);

        db.close();
    }

    public void deletePrimary(int primId){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + primary_table_name + " WHERE primaryId = '" + primId + "';";

        db.execSQL(query);

        db.close();
    }

    public void deleteSecondary(int secId){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + secondary_table_name + " WHERE secondaryId = '" + secId + "';";

        db.execSQL(query);

        db.close();
    }

    public void deletePerks(int perkId){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + perks_table_name + " WHERE perksId = '" + perkId + "';";

        db.execSQL(query);

        db.close();
    }

    public int getIdFromPrimaryName(String str){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + primary_table_name + " WHERE primaryName = '" + str + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        cursor.getInt(0);

        db.close();

        return cursor.getInt(0);
    }

    public int getIdFromSecondaryName(String str){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + secondary_table_name + " WHERE secondaryName = '" + str + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        cursor.getInt(0);

        db.close();

        return cursor.getInt(0);
    }

    public int getIdFromTacticalName(String str){
        SQLiteDatabase db = this.getReadableDatabase();

        Tactical t = new Tactical();

        String query = "SELECT * FROM " + tactical_table_name + " WHERE tacticalName = '" + str + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        t.setTacticalName(cursor.getString(0));
        t.setTacticalId(cursor.getInt(1));

        db.close();

        return cursor.getInt(1);
    }

    public String getTacticalNameFromTacticalId(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        Tactical t = new Tactical();

        String query = "SELECT * FROM " + tactical_table_name + " WHERE tacticalId = '" + i + "';";

        Cursor cursor = db.rawQuery(query, null);

        int s;
        String n = "";
        
        if (cursor != null){
            cursor.moveToFirst();

            n = (cursor.getString(0));
            Log.d("Help", cursor.getString(0));
            s = (cursor.getInt(1));

        }

        db.close();

        return n;


    }

    public String getLethalNameFromLethalId(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        Lethal l = new Lethal();

        String query = "SELECT * FROM " + lethal_table_name + " WHERE lethalId = '" + i + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        l.setLethalName(cursor.getString(0));
        l.setLethalId(cursor.getInt(1));

        db.close();

        return cursor.getString(0);
    }

    public int getIdFromLethalName(String str){
        SQLiteDatabase db = this.getReadableDatabase();

        Lethal l = new Lethal();

        String query = "SELECT * FROM " + lethal_table_name + " WHERE lethalName = '" + str + "';";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        l.setLethalName(cursor.getString(0));
        l.setLethalId(cursor.getInt(1));

        db.close();

        return cursor.getInt(1);
    }

    public int getLastMadePrimaryId(){
        SQLiteDatabase db = this.getReadableDatabase();

        Primary p = new Primary();

        Cursor cursor = db.rawQuery("SELECT * FROM " + primary_table_name, null);

        if (cursor != null){
            cursor.moveToLast();

            p.setPrimaryName(cursor.getString(0));
            p.setPrimaryId(cursor.getInt(1));
            p.setPrimaryOptic(cursor.getString(2));
            p.setPrimaryMuzzle(cursor.getString(3));
            p.setPrimaryBarrel(cursor.getString(4));
            p.setPrimaryUnderbarrel(cursor.getString(5));
            p.setPrimaryStock(cursor.getString(6));
        }

        cursor.getInt(1);

        db.close();

        return cursor.getInt(1);
    }

    public int getLastMadeSecondaryId(){
        SQLiteDatabase db = this.getReadableDatabase();

        Secondary s = new Secondary();

        Cursor cursor = db.rawQuery("SELECT * FROM " + secondary_table_name, null);

        if (cursor != null){
            cursor.moveToLast();

            s.setSecondaryName(cursor.getString(0));
            s.setSecondaryId(cursor.getInt(1));
            s.setSecondaryOptic(cursor.getString(2));
            s.setSecondaryMuzzle(cursor.getString(3));
            s.setSecondaryBarrel(cursor.getString(4));
            s.setSecondaryMagazine(cursor.getString(5));
            s.setSecondaryGrip(cursor.getString(6));
        }

        cursor.getInt(1);

        db.close();

        return cursor.getInt(1);
    }

    public int getLastMadePerkId(){
        SQLiteDatabase db = this.getReadableDatabase();

        Perks perks = new Perks();

        Cursor cursor = db.rawQuery("SELECT * FROM " + perks_table_name, null);

        if (cursor != null){
            cursor.moveToLast();

            perks.setPerkId(cursor.getInt(0));
            perks.setPerk3(cursor.getString(1));
            perks.setPerk2(cursor.getString(2));
            perks.setPerk3(cursor.getString(3));

        }

        cursor.getInt(0);

        db.close();

        return cursor.getInt(0);
    }



    public ArrayList<Integer> getLoadoutIDsFromStartandEndIngRatings(int sR, int eR){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + loadoutRating_table_name + " WHERE loadoutRating BETWEEN '" + sR + "' AND '" + eR + "';";

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Integer> loadoutRatingsFromLoadoutRating = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                loadoutRatingsFromLoadoutRating.add((
                        cursor.getInt(2))

                );

            }
            while(cursor.moveToNext());
        }

        cursor.close();

        return loadoutRatingsFromLoadoutRating;

    }

   //public void searchLoadouts(String p, String s, String t, String l, String m, String fU, int sR, int eR){
   //    SQLiteDatabase db = this.getReadableDatabase();
   //    String query;
   //    //query = "SELECT Loadout.*, p.primaryName, s.secondaryName FROM " + loadout_table_name + "Loadout INNER JOIN ( SELECT loadoutRating.loadoutId, AVG(loadoutRating) AS average_rating FROM loadoutRating GROUP BY loadoutRating.loadoutId) ON loadoutId = loadoutRating.loadoutId WHERE average_rating BETWEEN '" + sR + "' AND '" + eR + "';";
   //    //query = "SELECT Loadout.*, p.primaryName, s.secondaryName FROM " + loadout_table_name + " Loadout INNER JOIN " + primary_table_name + " s on Loadout."
   //    Cursor cursor;
   //    //cursor = db.rawQuery(query, null);
   //}

}
