package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class viewUsersLoadouts extends AppCompatActivity {

    ListView lv_j_listOfUsersLoadouts;

    static ArrayList<Loadout> listOfUsersLoadouts;
    static ArrayList<Primary> listOfUsersPrimaries;
    static ArrayList<Secondary> listOfUsersSecondaries;

    static ArrayList<Integer> primarySecondaryIds;

    Button btn_j_back;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    Intent intent_j_welcomeScreen;
    Intent intent_j_usersLoadoutInfo;

    UsersLoadoutListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_users_loadouts);

        lv_j_listOfUsersLoadouts = findViewById(R.id.lv_v_uView_listOfUsersLoadouts);

        btn_j_back = findViewById(R.id.btn_v_uView_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_welcomeScreen = new Intent(viewUsersLoadouts.this, welcomeScreen.class);
        intent_j_usersLoadoutInfo = new Intent(viewUsersLoadouts.this, viewYourLoadout.class);

        listOfUsersLoadouts = dbHelper.allLoadoutsListGivenUsername(SessionData.getRegisteredUser().getUname());

        fillListView();
        welcomeScreenBackBtnListener();
        itemClickListener();

        Log.d("Pumpkin","Hello");
    }

    private void fillListView(){
        adapter = new UsersLoadoutListAdapter(this, listOfUsersLoadouts);
        lv_j_listOfUsersLoadouts.setAdapter(adapter);
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
        lv_j_listOfUsersLoadouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int lId;
                lId = listOfUsersLoadouts.get(i).getLoadoutId();
                //intent_j_loadoutInfo.putExtra("findThisId", lId);

                dbHelper.getAllLoadoutInfoGivenLoadoutId(lId);
                dbHelper.getAllPrimaryInfoGivenId(lId);
                dbHelper.getAllSecondaryInfoGivenID(lId);
                //dbHelper.getAllTacticalInfoGivenID(lId);
                //dbHelper.getAllLethalInfoGivenID(lId);
                dbHelper.getAllPerksInfoGivenID(lId);

                Log.d("Pumpkin", PrimarySessionData.getRegisteredPrimary().getPrimaryName());

                startActivity(intent_j_usersLoadoutInfo);

            }
        });
    }
}