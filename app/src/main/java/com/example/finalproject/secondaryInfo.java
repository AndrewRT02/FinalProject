package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin._Assertions;

public class secondaryInfo extends AppCompatActivity {

    TextView tv_j_loadoutName;
    TextView tv_j_sName;
    TextView tv_j_optic;
    TextView tv_j_muzzle;
    TextView tv_j_barrel;
    TextView tv_j_mag;
    TextView tv_j_rGrip;

    Button btn_j_back;
    Button btn_j_update;

    ImageView iv_j_sImage;

    Intent intent_j_backToLoadoutInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondary_info);

        tv_j_loadoutName = findViewById(R.id.tv_v_sInfo_lName);
        tv_j_sName       = findViewById(R.id.tv_v_sInfo_sName);
        tv_j_optic       = findViewById(R.id.tv_v_sInfo_optic);
        tv_j_muzzle      = findViewById(R.id.tv_v_sInfo_muzzle);
        tv_j_barrel      = findViewById(R.id.tv_v_sInfo_barrel);
        tv_j_mag         = findViewById(R.id.tv_v_sInfo_magazine);
        tv_j_rGrip       = findViewById(R.id.tv_v_sInfo_rGrip);

        btn_j_back       = findViewById(R.id.btn_v_sInfo_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_update     = findViewById(R.id.btn_v_sInfo_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));

        iv_j_sImage  = findViewById(R.id.iv_v_sInfo_secondaryImage);

        intent_j_backToLoadoutInfo = new Intent(secondaryInfo.this, loadoutInfo.class);

        String s = SecondarySessionData.getRegisteredSecondary().getSecondaryName();
        getSecondaryImage(s);

        tv_j_loadoutName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());
        tv_j_sName.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryName());
        tv_j_optic.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryOptic());
        tv_j_muzzle.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryMuzzle());
        tv_j_barrel.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryBarrel());
        tv_j_mag.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryMagazine());
        tv_j_rGrip.setText(SecondarySessionData.getRegisteredSecondary().getSecondaryGrip());

        backToLoadoutInfoBtnListener();
    }

    private void getSecondaryImage(String s) {

        //Pistols
        if (s.equals("9MM PM")) {
            iv_j_sImage.setImageResource(R.drawable.pm);
        }
        if (s.equals(("9mm PM"))){
            iv_j_sImage.setImageResource(R.drawable.pm);
        }
        if (s.equals("GREKHOVA")) {
            iv_j_sImage.setImageResource(R.drawable.grekhova);
        }
        if (s.equals("GS45")) {
            iv_j_sImage.setImageResource(R.drawable.gs45);
        }
        if (s.equals("STRYDER .22")) {
            iv_j_sImage.setImageResource(R.drawable.stryder22);
        }
        if (s.equals("Stryder .22")) {
            iv_j_sImage.setImageResource(R.drawable.stryder22);
        }

    }

    private void backToLoadoutInfoBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToLoadoutInfo);
            }
        });
    }

}