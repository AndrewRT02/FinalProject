package com.example.finalproject;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String database_name = "UserLoadout.db";
    private static final String user_table_name = "User";
    private static final String loadout_table_name = "Loadout";
    private static final String primary_table_name = "'Primary'";
    private static final String secondary_table_name = "Secondary";
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
        db.execSQL("CREATE TABLE " + loadout_table_name + " (creator String, loadoutName String, loadoutId integer primary key autoincrement not null, primaryGun integer, secondaryGun integer, tactical integer, lethal integer, perks integer, melee String, fieldUpgrade String, foreign key (username) references " + user_table_name + " (username), foreign key (primaryGun) references " + primary_table_name + " (primaryId), foreign key (secondaryGun) references " + secondary_table_name + " (secondaryId), foreign key (tactical) references " + tactical_table_name + " (tacticalId), foreign key (lethal) references " + lethal_table_name + " (lethalId), foreign key (perks) references " + perks_table_name + " (perksId));");

        //loadout rating table


        //primary's table
        db.execSQL("CREATE TABLE " + primary_table_name + " (primaryName String, primaryId integer primary key autoincrement not null, primaryOptic String, primaryMuzzle String, primaryBarrel String, primaryUnderbarrel String, primaryStock String)");

        //primary rating table


        //secondary table
        db.execSQL("CREATE TABLE " + secondary_table_name + " (secondaryName String, secondaryId integer primary key autoincrement not null, secondaryOptic String, secondaryMuzzle String, secondaryBarrel String, secondaryMagazine String, secondaryGrip String)");

        //secondary rating table


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
        //loadout rating table
        db.execSQL("DROP TABLE IF EXISTS " + primary_table_name + ";");
        //primary rating table
        db.execSQL("DROP TABLE IF EXISTS " + secondary_table_name + ";");
        //secondary rating table
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

    }

    private void initUsers(){
        if (countRecordsFromTables(user_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + user_table_name + "(username, fname, lname, email, age) VALUES ('ZMoore', 'Zackary', 'Moore', 'zmoore@monroeccc.edu', '32');");

            db.close();
        }
    }
    private void initLoadouts(){
        if (countRecordsFromTables(loadout_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + loadout_table_name + "(creator, loadoutName, loadoutId, primaryGun, secondaryGun, tactical, lethal, perks, melee, fieldUpgrade) VALUES ('Zmoore', 'Meh', 1, 1, 1, 1, 1, 'Baseball Bat', 'Trophy System');");

            db.close();
        }
    }
    private void initPrimaries(){
        if (countRecordsFromTables(primary_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL();

            db.close();
        }
    }
    private void initSecondaries(){
        if (countRecordsFromTables(secondary_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL();

            db.close();
        }
    }
    private void initTacticals(){
        if (countRecordsFromTables(tactical_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL();

            db.close();
        }
    }
    private void initLethals(){
        if (countRecordsFromTables(lethal_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL();

            db.close();
        }
    }
    private void initPerks(){
        if (countRecordsFromTables(perks_table_name) == 0){
            SQLiteDatabase db = this.getWritableDatabase();

            //db.execSQL();

            db.close();
        }
    }

    public int countRecordsFromTables(String tableName){
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);

        db.close();

        return numRows;
    }
}
