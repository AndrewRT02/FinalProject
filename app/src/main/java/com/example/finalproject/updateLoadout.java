package com.example.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class updateLoadout extends AppCompatActivity {

    EditText et_j_lName;

    TextView tv_lNameError;
    TextView tv_tactError;
    TextView tv_lethError;
    TextView tv_melError;
    TextView tv_fUError;

    Button btn_back;
    Button btn_update;
    Button btn_delete;

    DatabaseHelper db = new DatabaseHelper(this);

    Intent intent_j_back;
    Intent intent_j_update;


    TextView tacticalSel;
    TextView lethalSel;
    TextView meleeSel;
    TextView fieldUpgradeSel;

    ArrayList<String> tacticals;
    ArrayList<String> lethals;
    ArrayList<String> melee;
    ArrayList<String> fieldUpgrades;

    Dialog tacticalPopUp;
    Dialog lethalPopUp;
    Dialog meleePopUp;
    Dialog fieldUpgradePopUp;

    EditText tactical_popup_search;
    EditText lethal_popup_search;
    EditText melee_popup_search;
    EditText fieldupgrade_popup_search;

    ListView dialog_tactical_listview;
    ListView dialog_lethal_listview;
    ListView dialog_melee_listview;
    ListView dialog_fieldupgrade_listview;

    ArrayAdapter<String> tactical_popup_adapter;
    ArrayAdapter<String> lethal_popup_adapter;
    ArrayAdapter<String> melee_popup_adapter;
    ArrayAdapter<String> fieldupgrade_popup_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_loadout);

        et_j_lName = findViewById(R.id.et_v_updateL_lName);

        tv_lNameError = findViewById(R.id.tv_v_updateL_lNameError);
        tv_tactError = findViewById(R.id.tv_v_updateL_tError);
        tv_lethError = findViewById(R.id.tv_v_updateL_lError);
        tv_melError = findViewById(R.id.tv_v_updateL_mError);
        tv_fUError = findViewById(R.id.tv_v_updateL_fUError);

        btn_back = findViewById(R.id.btn_v_updateL_back);
        btn_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_update = findViewById(R.id.btn_v_updateL_update);
        btn_update.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_delete = findViewById(R.id.btn_v_updateL_delete);
        btn_delete.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_back = new Intent(updateLoadout.this, viewYourLoadout.class);
        intent_j_update = new Intent(updateLoadout.this, welcomeScreen.class);

        et_j_lName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());

        String tv_j_creator = (LoadoutSessionData.getRegisteredLoadout().getUsername());

        //Log.d("Bananas", tacticalSel.getText().toString());

        //int tactId = db.getIdFromTacticalName(tacticalSel.getText().toString());
        //String tactName = db.getTacticalNameFromTacticalId(tactId);
        //tacticalSel.setText(tactName);
//
        //int lethId = db.getIdFromLethalName(lethalSel.getText().toString());
        //String lethName = db.getLethalNameFromLethalId(lethId);
        //lethalSel.setText(lethName);

        //meleeSel.setText(LoadoutSessionData.getRegisteredLoadout().getMelee());
        //fieldUpgradeSel.setText(LoadoutSessionData.getRegisteredLoadout().getFieldUpgrade());


        tacticalSel = findViewById(R.id.tv_updateL_tactical_selection);
        //-----------------------------Tacticals--------------------------------
        tacticals = new ArrayList<>();

        //Tacticals
        tacticals.add("Concussion");
        tacticals.add("Flashbang");
        tacticals.add("Spy Cam");
        tacticals.add("Smoke");
        tacticals.add("Prox Alarm");
        tacticals.add("Stim Shot");
        tacticals.add("Decoy");
        tacticals.add("Shock Charge");


        lethalSel = findViewById(R.id.tv_updateL_lethal_selection);
        //-----------------------------Lethals--------------------------------
        lethals = new ArrayList<>();

        //Lethals
        lethals.add("Frag");
        lethals.add("Semtex");
        lethals.add("C4");
        lethals.add("Thermo Grenade");
        lethals.add("Impact Grenade");
        lethals.add("Molotov");
        lethals.add("Blast Charge");
        lethals.add("Drill Charge");
        lethals.add("Combat Axe");


        meleeSel = findViewById(R.id.tv_updateL_melee_selection);
        //-----------------------------Melees--------------------------------
        melee = new ArrayList<>();

        //Melees
        melee.add("Knife");
        melee.add("Baseball Bat");
        melee.add("Power Drill");


        fieldUpgradeSel = findViewById(R.id.tv_updateL_fU_selection);
        //-----------------------------Field Upgrades--------------------------------
        fieldUpgrades = new ArrayList<>();

        fieldUpgrades.add("Assault Pack");
        fieldUpgrades.add("Spring Mine");
        fieldUpgrades.add("Trophy System");
        fieldUpgrades.add("Scrambler");
        fieldUpgrades.add("Signal Lure");
        fieldUpgrades.add("War Cry");
        fieldUpgrades.add("Tactical Insertion");
        fieldUpgrades.add("Acoustic Amp");
        fieldUpgrades.add("Morphine Injector");
        fieldUpgrades.add("NeuroGas");
        fieldUpgrades.add("Sleeper Agent");


        tacticalSelClickListenerTextView();
        lethalSelClickListenerTextView();
        meleeSelClickListenerTextView();
        fieldUpgradeClickListenerTextView();

        updateBtnListener();
        backBtnListener();
        deleteBtnListener();
    }

    private void backBtnListener(){
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_back);
            }
        });
    }

    private void updateBtnListener(){
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bool;
                bool = uLoadoutErroChecking();

                if (bool){
                    int tactId = db.getIdFromTacticalName(tacticalSel.getText().toString());
                    int lethId = db.getIdFromLethalName(lethalSel.getText().toString());
                    db.updateLoadout(LoadoutSessionData.getRegisteredLoadout().getUsername(), LoadoutSessionData.getRegisteredLoadout().getLoadoutId(), et_j_lName.getText().toString(), tactId, lethId, meleeSel.getText().toString(), fieldUpgradeSel.getText().toString());

                    startActivity(intent_j_update);
                }
            }
        });
    }

    private void deleteBtnListener(){
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletePrimary(LoadoutSessionData.getRegisteredLoadout().getPrimary());
                db.deleteSecondary(LoadoutSessionData.getRegisteredLoadout().getSecondary());
                db.deletePerks(LoadoutSessionData.getRegisteredLoadout().getPerks());
                db.deleteLoadout(LoadoutSessionData.getRegisteredLoadout().getLoadoutId());

                startActivity(intent_j_update);
            }
        });
    }

    private boolean uLoadoutErroChecking(){
        Boolean bool = true;

        //Tactical Error Checking
        if (tacticalSel.getText().toString().isEmpty()){
            tv_tactError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (tacticalSel != null) {
            tv_tactError.setVisibility(View.INVISIBLE);
        }

        //Lethal Error Checking
        if (lethalSel.getText().toString().isEmpty()){
            tv_lethError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (lethalSel != null) {
            tv_lethError.setVisibility(View.INVISIBLE);
        }

        //Melee Error Checking
        if (meleeSel.getText().toString().isEmpty()){
            tv_melError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (meleeSel != null) {
            tv_melError.setVisibility(View.INVISIBLE);
        }

        //Field Upgrade Error CHecking
        if (fieldUpgradeSel.getText().toString().isEmpty()){
            tv_fUError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (fieldUpgradeSel != null) {
            tv_fUError.setVisibility(View.INVISIBLE);
        }

        return bool;
    }


    //=============================Tacticals============================================
    private void tacticalSelClickListenerTextView(){
        tacticalSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticalPopUp = new Dialog(updateLoadout.this);
                tacticalPopUp.setContentView(R.layout.tactical_spinner_data);

                tacticalPopUp.getWindow().setLayout(800, 1200);
                tacticalPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                tacticalPopUp.show();

                tactical_popup_search       = tacticalPopUp.findViewById(R.id.et_tacticalSearch);
                dialog_tactical_listview    = tacticalPopUp.findViewById(R.id.lv_tacticals);

                tactical_popup_adapter = new ArrayAdapter<>(updateLoadout.this, android.R.layout.simple_list_item_1, tacticals);
                dialog_tactical_listview.setAdapter(tactical_popup_adapter);

                tacticalPopUpEditTextChangeListener();
            }
        });
    }

    private void tacticalPopUpEditTextChangeListener(){
        tactical_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tactical_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_tactical_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        tacticalSel.setText(tactical_popup_adapter.getItem(i));
                        tacticalPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=============================Lethals============================================
    private void lethalSelClickListenerTextView(){
        lethalSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lethalPopUp = new Dialog(updateLoadout.this);
                lethalPopUp.setContentView(R.layout.lethal_spinner_data);

                lethalPopUp.getWindow().setLayout(800, 1200);
                lethalPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                lethalPopUp.show();

                lethal_popup_search     = lethalPopUp.findViewById(R.id.et_lethalSearch);
                dialog_lethal_listview  = lethalPopUp.findViewById(R.id.lv_lethals);

                lethal_popup_adapter    = new ArrayAdapter<>(updateLoadout.this, android.R.layout.simple_list_item_1, lethals);
                dialog_lethal_listview.setAdapter(lethal_popup_adapter);

                lethalPopUpEditTextChangeListener();
            }
        });
    }

    private void lethalPopUpEditTextChangeListener(){
        lethal_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lethal_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_lethal_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        lethalSel.setText(lethal_popup_adapter.getItem(i));
                        lethalPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=============================Melees============================================
    private void meleeSelClickListenerTextView(){
        meleeSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meleePopUp = new Dialog(updateLoadout.this);
                meleePopUp.setContentView(R.layout.melee_spinner_data);

                meleePopUp.getWindow().setLayout(800, 1200);
                meleePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                meleePopUp.show();

                melee_popup_search      = meleePopUp.findViewById(R.id.et_meleeSearch);
                dialog_melee_listview   = meleePopUp.findViewById(R.id.lv_melees);

                melee_popup_adapter     = new ArrayAdapter<>(updateLoadout.this, android.R.layout.simple_list_item_1, melee);
                dialog_melee_listview.setAdapter(melee_popup_adapter);

                meleePopUpEditTextChangeListner();
            }
        });
    }

    private void meleePopUpEditTextChangeListner(){
        melee_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                melee_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_melee_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        meleeSel.setText(melee_popup_adapter.getItem(i));
                        meleePopUp.dismiss();
                    }
                });
            }
        });
    }

    //=============================Field Upgrade============================================
    private void fieldUpgradeClickListenerTextView(){
        fieldUpgradeSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldUpgradePopUp = new Dialog(updateLoadout.this);
                fieldUpgradePopUp.setContentView(R.layout.fieldupgrade_spinner_data);

                fieldUpgradePopUp.getWindow().setLayout(800, 1200);
                fieldUpgradePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                fieldUpgradePopUp.show();

                fieldupgrade_popup_search    = fieldUpgradePopUp.findViewById(R.id.et_fieldUpgradeSearch);
                dialog_fieldupgrade_listview = fieldUpgradePopUp.findViewById(R.id.lv_fieldUpgrades);

                fieldupgrade_popup_adapter   = new ArrayAdapter<>(updateLoadout.this, android.R.layout.simple_list_item_1, fieldUpgrades);
                dialog_fieldupgrade_listview.setAdapter(fieldupgrade_popup_adapter);

                fieldUpgradePopUpEditTextChangeListener();
            }
        });
    }

    private void fieldUpgradePopUpEditTextChangeListener(){
        fieldupgrade_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fieldupgrade_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_fieldupgrade_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        fieldUpgradeSel.setText(fieldupgrade_popup_adapter.getItem(i));
                        fieldUpgradePopUp.dismiss();
                    }
                });
            }
        });
    }
}