package com.example.finalproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rateLoadout extends AppCompatActivity {

    TextView tv_j_lName;
    TextView tv_j_lId;
    TextView tv_j_creator;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate_loadout);

        tv_j_lName = findViewById(R.id.tv_v_rate_lName);
        tv_j_lId = findViewById(R.id.tv_v_rate_lID);


        String ID;
        ID = Integer.toString(LoadoutSessionData.getRegisteredLoadout().getLoadoutId());
        tv_j_lId.setText(ID);

    }
}