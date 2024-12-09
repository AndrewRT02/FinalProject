package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loadoutInfo extends AppCompatActivity {

    TextView tv_j_lName;
    TextView tv_j_lID;
    TextView tv_j_creator;
    TextView tv_j_primary;
    TextView tv_j_secondary;
    TextView tv_j_tactical;
    TextView tv_j_lethal;
    TextView tv_j_melee;
    TextView tv_j_fU;
    TextView tv_j_p1;
    TextView tv_j_p2;
    TextView tv_j_p3;

    Button btn_j_rate;
    Button btn_j_update;
    Button btn_j_back;
    Button btn_j_primary;
    Button btn_j_secondary;

    Intent intent_j_backToViewLoadouts;
    Intent intent_j_seePrimary;
    Intent intent_j_seeSecondary;
    Intent intent_j_rateLoadout;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loadout_info);

        tv_j_lName     = findViewById(R.id.tv_v_info_lName);
        tv_j_lID       = findViewById(R.id.tv_v_info_lID);
        tv_j_creator   = findViewById(R.id.tv_v_info_creator);
        tv_j_primary   = findViewById(R.id.tv_v_info_primary);
        tv_j_secondary = findViewById(R.id.tv_v_info_secondary);
        tv_j_tactical  = findViewById(R.id.tv_v_info_tactical);
        tv_j_lethal    = findViewById(R.id.tv_v_info_lethal);
        tv_j_melee     = findViewById(R.id.tv_v_info_melee);
        tv_j_fU        = findViewById(R.id.tv_v_info_fU);
        tv_j_p1        = findViewById(R.id.tv_v_info_perk1);
        tv_j_p2        = findViewById(R.id.tv_v_info_perk2);
        tv_j_p3        = findViewById(R.id.tv_v_info_perk3);

        btn_j_rate      = findViewById(R.id.btn_v_info_addRating);
        btn_j_rate.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_back      = findViewById(R.id.btn_v_info_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_primary   = findViewById(R.id.btn_v_info_primary);
        btn_j_primary.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_secondary = findViewById(R.id.btn_v_info_secondary);
        btn_j_secondary.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_backToViewLoadouts = new Intent(loadoutInfo.this, viewLoadouts.class);
        intent_j_seePrimary = new Intent(loadoutInfo.this, primaryInfo.class);
        intent_j_seeSecondary       = new Intent(loadoutInfo.this, secondaryInfo.class);
        intent_j_rateLoadout = new Intent(loadoutInfo.this, rateLoadout.class);

        //When I go back to the Loadout Screen from Primary/Secondary it erases all of the info in Loadout Info
        //Find a way around this

        //Bundle extras = getIntent().getExtras();
        //if (extras != null){
        //    int lId = extras.getInt("findThisId");

            //dbHelper.getAllLoadoutInfoGivenLoadoutId(lId);

            //Log.d("Grape", LoadoutSessionData.getRegisteredLoadout().getLoadoutName());

            tv_j_lName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());

            String ID;
            ID = Integer.toString(LoadoutSessionData.getRegisteredLoadout().getLoadoutId());

            tv_j_lID.setText(ID);
            tv_j_creator.setText(LoadoutSessionData.getRegisteredLoadout().getUsername());
            tv_j_melee.setText(LoadoutSessionData.getRegisteredLoadout().getMelee());
            tv_j_fU.setText(LoadoutSessionData.getRegisteredLoadout().getFieldUpgrade());

            //dbHelper.getAllPrimaryInfoGivenId(lId);
            tv_j_primary.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryName());

            //dbHelper.getAllSecondaryInfoGivenID(lId);
            tv_j_secondary.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryName());



            int tacticalId = dbHelper.getTacticalInforGivenCreatorAndLoadoutName(tv_j_creator.getText().toString(), tv_j_lName.getText().toString());

            Log.d("Banana", String.valueOf(tacticalId));

            int lethalId = dbHelper.getLethalInforGivenCreatorAndLoadoutName(tv_j_creator.getText().toString(), tv_j_lName.getText().toString());

            Log.d("LethalId", String.valueOf(lethalId));

            String tacticalName = dbHelper.getTacticalNameFromTacticalId(tacticalId);

            String lethalName = dbHelper.getLethalNameFromLethalId(lethalId);



            //dbHelper.getAllTacticalInfoGivenID(lId);
            tv_j_tactical.setText(tacticalName);

            //dbHelper.getAllLethalInfoGivenID(lId);
            tv_j_lethal.setText(lethalName);



            //dbHelper.getAllPerksInfoGivenID(lId);
            tv_j_p1.setText(PerksSessionData.getRegisteredPerks().getPerk1());
            tv_j_p2.setText(PerksSessionData.getRegisteredPerks().getPerk2());
            tv_j_p3.setText(PerksSessionData.getRegisteredPerks().getPerk3());

        //}


        backToViewLoadotsBtnListener();
        toPrimaryInfoBtnListener();
        toSecondaryInfoBtnListener();
        toRateLoadoutBtnListener();
    }

    private void backToViewLoadotsBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToViewLoadouts);
            }
        });
    }

    private void toPrimaryInfoBtnListener(){
        btn_j_primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_seePrimary);
            }
        });
    }

    private void toSecondaryInfoBtnListener(){
        btn_j_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_seeSecondary);
            }
        });
    }

    private void toRateLoadoutBtnListener(){
        btn_j_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_rateLoadout);
            }
        });
    }

}