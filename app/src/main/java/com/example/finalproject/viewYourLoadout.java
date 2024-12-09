package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class viewYourLoadout extends AppCompatActivity {

    TextView tv_j_lName;
    TextView tv_j_lId;
    TextView tv_j_creator;
    TextView tv_j_primary;
    TextView tv_j_secondary;
    TextView tv_j_tactical;
    TextView tv_j_lethal;
    TextView tv_j_melee;
    TextView tv_j_fU;
    TextView tv_j_perk1;
    TextView tv_j_perk2;
    TextView tv_j_perk3;

    Button btn_j_rate;
    Button btn_j_update;
    Button btn_j_primary;
    Button btn_j_back;
    Button btn_j_secondary;

    Intent intent_j_rate;
    Intent intent_j_updateLoadout;
    Intent intent_j_updatePrimary;
    Intent intent_j_backToUserLoadouts;
    Intent intent_j_secondaryUpdate;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_your_loadout);

        tv_j_lName = findViewById(R.id.tv_v_your_lName);
        tv_j_lId   = findViewById(R.id.tv_v_your_lID);
        tv_j_creator = findViewById(R.id.tv_v_your_creator);
        tv_j_primary = findViewById(R.id.tv_v_your_primary);
        tv_j_secondary = findViewById(R.id.tv_v_your_secondary);
        tv_j_tactical = findViewById(R.id.tv_v_your_tactical);
        tv_j_lethal = findViewById(R.id.tv_v_your_lethal);
        tv_j_melee = findViewById(R.id.tv_v_your_melee);
        tv_j_fU = findViewById(R.id.tv_v_your_fU);
        tv_j_perk1 = findViewById(R.id.tv_v_your_perk1);
        tv_j_perk2 = findViewById(R.id.tv_v_your_perk2);
        tv_j_perk3 = findViewById(R.id.tv_v_your_perk3);


        btn_j_update = findViewById(R.id.btn_v_your_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_primary = findViewById(R.id.btn_v_your_primary);
        btn_j_primary.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_back = findViewById(R.id.btn_v_your_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_secondary = findViewById(R.id.btn_v_your_secondary);
        btn_j_secondary.setBackgroundColor(Color.rgb(250, 103, 0));


        intent_j_updateLoadout = new Intent(viewYourLoadout.this, updateLoadout.class);
        intent_j_updatePrimary = new Intent(viewYourLoadout.this, updatePrimary.class);
        intent_j_backToUserLoadouts = new Intent(viewYourLoadout.this, viewUsersLoadouts.class);
        intent_j_secondaryUpdate = new Intent(viewYourLoadout.this, updateSecondary.class);

        tv_j_lName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());

        String lId = Integer.toString(LoadoutSessionData.getRegisteredLoadout().getLoadoutId());
        tv_j_lId.setText(lId);

        tv_j_creator.setText(LoadoutSessionData.getRegisteredLoadout().getUsername());
        tv_j_primary.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryName());
        tv_j_secondary.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryName());

        int tactId = db.getTacticalInforGivenCreatorAndLoadoutName(tv_j_creator.getText().toString(), tv_j_lName.getText().toString());
        String tactName = db.getTacticalNameFromTacticalId(tactId);
        tv_j_tactical.setText(tactName);

        int lethId = db.getLethalInforGivenCreatorAndLoadoutName(tv_j_creator.getText().toString(), tv_j_lName.getText().toString());
        String lethName = db.getLethalNameFromLethalId(lethId);
        tv_j_lethal.setText(lethName);
        tv_j_melee.setText(LoadoutSessionData.getRegisteredLoadout().getMelee());
        tv_j_fU.setText(LoadoutSessionData.getRegisteredLoadout().getFieldUpgrade());
        tv_j_perk1.setText(PerksSessionData.getRegisteredPerks().getPerk1());
        tv_j_perk2.setText(PerksSessionData.getRegisteredPerks().getPerk2());
        tv_j_perk3.setText(PerksSessionData.getRegisteredPerks().getPerk3());

        backToUserLoadoutsBtnListener();
        updateLoadoutBtnListener();
        updatePrimaryBtnListener();
        updateSecondaryBtnListener();
    }

    private void backToUserLoadoutsBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToUserLoadouts);
            }
        });
    }

    private void updateLoadoutBtnListener(){
        btn_j_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_updateLoadout);
            }
        });
    }

    private void updatePrimaryBtnListener(){
        btn_j_primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_updatePrimary);
            }
        });
    }

    private void updateSecondaryBtnListener(){
        btn_j_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_secondaryUpdate);
            }
        });
    }
}