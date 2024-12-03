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

public class primaryInfo extends AppCompatActivity {

    TextView tv_j_loadoutName;
    TextView tv_j_primaryName;
    TextView tv_j_optic;
    TextView tv_j_muzzle;
    TextView tv_j_barrel;
    TextView tv_j_uBarrel;
    TextView tv_j_stock;

    Button btn_j_back;
    Button btn_j_update;

    ImageView im_j_pImage;

    Intent intent_j_backToLoadoutInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primary_info);

        tv_j_loadoutName = findViewById(R.id.tv_v_pInfo_lName);
        tv_j_primaryName = findViewById(R.id.tv_v_pInfo_pName);
        tv_j_optic   = findViewById(R.id.tv_v_pInfo_optic);
        tv_j_muzzle  = findViewById(R.id.tv_v_pInfo_muzzle);
        tv_j_barrel  = findViewById(R.id.tv_v_pInfo_barrel);
        tv_j_uBarrel = findViewById(R.id.tv_v_pInfo_ubarrel);
        tv_j_stock   = findViewById(R.id.tv_v_pInfo_stock);

        btn_j_back   = findViewById(R.id.btn_v_pInfo_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_update = findViewById(R.id.btn_v_pInfo_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));

        im_j_pImage  = findViewById(R.id.iv_v_pInfo_primaryImage);

        intent_j_backToLoadoutInfo = new Intent(primaryInfo.this, loadoutInfo.class);

        tv_j_loadoutName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());
        tv_j_primaryName.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryName());
        tv_j_optic.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryOptic());
        tv_j_muzzle.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryMuzzle());
        tv_j_barrel.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryBarrel());
        tv_j_uBarrel.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryUnderbarrel());
        tv_j_stock.setText(PrimarySessionData.getRegisteredPrimary().getPrimaryStock());

        String p = PrimarySessionData.getRegisteredPrimary().getPrimaryName();
        getPrimaryImage(p);

        backToLoadoutInfo();
    }

    private void backToLoadoutInfo(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToLoadoutInfo);
            }
        });
    }

    private void getPrimaryImage(String p){

        //Ars
        if (p.equals("XM4")){
            im_j_pImage.setImageResource(R.drawable.xm4);
        }
        if (p.equals("AK-74")){
            im_j_pImage.setImageResource(R.drawable.ak74);
        }
        if (p.equals("AMES 85")){
            im_j_pImage.setImageResource(R.drawable.ames85);
        }
        if (p.equals("GPR 91")){
            im_j_pImage.setImageResource(R.drawable.gpr91);
        }
        if (p.equals("MODEL L")){
            im_j_pImage.setImageResource(R.drawable.modell);
        }
        if (p.equals("GOBLIN MK2")){
            im_j_pImage.setImageResource(R.drawable.goblinmk2);
        }
        if (p.equals("AS VAL")){
            im_j_pImage.setImageResource(R.drawable.asval);
        }
        if (p.equals("KRIG C")){
            im_j_pImage.setImageResource(R.drawable.krigc);
        }

        //SMGs
        if (p.equals("C9")){
            im_j_pImage.setImageResource(R.drawable.c9);
        }
        if (p.equals("KSV")){
            im_j_pImage.setImageResource(R.drawable.ksv);
        }
        if (p.equals("TANTO .22")){
            im_j_pImage.setImageResource(R.drawable.tanto22);
        }
        if (p.equals("PP-919")){
            im_j_pImage.setImageResource(R.drawable.pp919);
        }
        if (p.equals("JACKAL PDW")){
            im_j_pImage.setImageResource(R.drawable.jackalpdw);
        }
        if (p.equals("KOMPAKT 92")){
            im_j_pImage.setImageResource(R.drawable.kompakt92);
        }
        if (p.equals("SAUG")){
            im_j_pImage.setImageResource(R.drawable.saug);
        }

        //LMGs
        if (p.equals("PU-21")){
            im_j_pImage.setImageResource(R.drawable.pu21);
        }
        if (p.equals("XMG")){
            im_j_pImage.setImageResource(R.drawable.xmg);
        }
        if (p.equals("GPMG-7")){
            im_j_pImage.setImageResource(R.drawable.gpmg7);
        }

        //MARKSMANs
        if (p.equals("SWAT 5.56")){
            im_j_pImage.setImageResource(R.drawable.swat556);
        }
        if (p.equals("TSARKOV 7.62")){
            im_j_pImage.setImageResource(R.drawable.tsarkov);
        }
        if (p.equals("AEK-973")){
            im_j_pImage.setImageResource(R.drawable.aek973);
        }
        if (p.equals("DM-10")){
            im_j_pImage.setImageResource(R.drawable.dm10);
        }

        //SNIPERS
        if (p.equals("LW3A1 FROSTLINE")){
            im_j_pImage.setImageResource(R.drawable.lw3a1frostline);
        }
        if (p.equals("SVD")){
            im_j_pImage.setImageResource(R.drawable.svd);
        }
        if (p.equals("LR 7.62")){
            im_j_pImage.setImageResource(R.drawable.lr762);
        }
    }
}