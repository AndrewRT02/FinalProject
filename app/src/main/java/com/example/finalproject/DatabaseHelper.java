package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String database_name = "Loadout.db";
    private static final String user_table_name = "User";
    private static final String loadout_table_name = "Loadout";
    private static final String primary_table_name = "Primary";
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


        //loadout table
        //db.execSQL("CREATE TABLE " + loadout_table_name + "");

        //primary's table
        //db.execSQL("CREATE TABLE " + primary_table_name + " (pname String, )");

        //secondary table


        //tactical table


        //lethal table


        //perks table

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

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
}
