package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class viewLoadouts extends AppCompatActivity {

    ListView lv_j_listOfLoadouts;

    static ArrayList<Loadout> listOfLoadouts;
    static ArrayList<Primary> listOfPrimaries;
    static ArrayList<Secondary> listOfSecondaries;

    Button btn_j_back;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    Intent intent_j_welcomeScreen;

    LoadoutListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_loadouts);

        lv_j_listOfLoadouts = findViewById(R.id.lv_v_view_listOfLoadouts);

        btn_j_back = findViewById(R.id.btn_v_view_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_welcomeScreen = new Intent(viewLoadouts.this, welcomeScreen.class);

        listOfLoadouts = dbHelper.allLoadoutsList();
        listOfPrimaries = dbHelper.allPrimariesList();
        listOfSecondaries = dbHelper.allSecondariesList();

        Log.d("Appricot", listOfPrimaries.get(5).getPrimaryName());

        fillListView();
        welcomeScreenBackBtnListener();
    }

   private void fillListView(){
       adapter = new LoadoutListAdapter(this, listOfLoadouts, listOfPrimaries, listOfSecondaries);
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
}