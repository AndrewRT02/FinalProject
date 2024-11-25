package com.example.finalproject;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class viewLoadouts extends AppCompatActivity {

    ListView lv_j_listOfLoadouts;

    static ArrayList<Loadout> listOfLoadouts;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    LoadoutListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_loadouts);

        lv_j_listOfLoadouts = findViewById(R.id.lv_v_view_listOfLoadouts);

        listOfLoadouts = dbHelper.allLoadoutsLiist();
        fillListView();

    }

   private void fillListView(){
       adapter = new LoadoutListAdapter(this, listOfLoadouts);
       lv_j_listOfLoadouts.setAdapter(adapter);
   }
}