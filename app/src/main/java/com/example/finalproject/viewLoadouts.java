package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class viewLoadouts extends AppCompatActivity {

    ListView lv_j_listOfLoadouts;

    static ArrayList<Loadout> listOfLoadouts;
    static ArrayList<Primary> listOfPrimaries;
    static ArrayList<Secondary> listOfSecondaries;
    static ArrayList<LoadoutRating> listOfLoadoutRatings;
    static ArrayList<Double> loadoutRatings;

    Button btn_j_back;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    Intent intent_j_welcomeScreen;
    Intent intent_j_loadoutInfo;

    LoadoutListAdapter adapter;

    Loadout l = new Loadout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_loadouts);

        DecimalFormat df = new DecimalFormat("#.00");

        lv_j_listOfLoadouts = findViewById(R.id.lv_v_view_listOfLoadouts);

        btn_j_back = findViewById(R.id.btn_v_view_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_welcomeScreen = new Intent(viewLoadouts.this, welcomeScreen.class);
        intent_j_loadoutInfo   = new Intent(viewLoadouts.this, loadoutInfo.class);

        listOfLoadouts = dbHelper.allLoadoutsList();
        listOfPrimaries = dbHelper.allPrimariesList();
        listOfSecondaries = dbHelper.allSecondariesList();

        loadoutRatings = new ArrayList<>();

        for (int i = 1; i <= listOfLoadouts.size(); i++){
            Double d = 1.00;
            d = (dbHelper.getLoadoutRatingFromId(i));
            loadoutRatings.add(d);
        }


        Log.d("Appricot", listOfPrimaries.get(5).getPrimaryName());

        fillListView();
        welcomeScreenBackBtnListener();
        itemClickListener();
    }

   private void fillListView(){
       adapter = new LoadoutListAdapter(this, listOfLoadouts, listOfPrimaries, listOfSecondaries, loadoutRatings);
       lv_j_listOfLoadouts.setAdapter(adapter);
   }

   private void welcomeScreenBackBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_welcomeScreen);
            }
        });
   }

   private void itemClickListener(){
        lv_j_listOfLoadouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int lId;
                lId = listOfLoadouts.get(i).getLoadoutId();
                //intent_j_loadoutInfo.putExtra("findThisId", lId);

                dbHelper.getAllLoadoutInfoGivenLoadoutId(lId);
                dbHelper.getAllPrimaryInfoGivenId(lId);
                dbHelper.getAllSecondaryInfoGivenID(lId);
                dbHelper.getAllTacticalInfoGivenID(lId);
                dbHelper.getAllLethalInfoGivenID(lId);
                dbHelper.getAllPerksInfoGivenID(lId);

                startActivity(intent_j_loadoutInfo);

            }
        });
   }
}