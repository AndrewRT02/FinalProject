package com.example.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class searchLoadouts extends AppCompatActivity {

    TextView primarySel;
    TextView secondarySel;
    TextView tacticalSel;
    TextView lethalSel;
    TextView meleeSel;
    TextView fieldUpgradeSel;
    TextView startRatingSel;
    TextView endRatingSel;

    ArrayList<String> primaries;
    ArrayList<String> secondaries;
    ArrayList<String> tacticals;
    ArrayList<String> lethals;
    ArrayList<String> melee;
    ArrayList<String> fieldUpgrades;
    ArrayList<String> startRatings;
    ArrayList<String> endRatings;

    Dialog primaryPopUp;
    Dialog secondaryPopUp;
    Dialog tacticalPopUp;
    Dialog lethalPopUp;
    Dialog meleePopUp;
    Dialog fieldUpgradePopUp;
    Dialog startRatingPopUp;
    Dialog endRatingPopUp;

    EditText primary_popup_search;
    EditText secondary_popup_search;
    EditText tactical_popup_search;
    EditText lethal_popup_search;
    EditText melee_popup_search;
    EditText fieldupgrade_popup_search;
    EditText start_rating_popup_search;
    EditText end_rating_popup_search;

    ListView dialog_primary_listview;
    ListView dialog_secondary_listview;
    ListView dialog_tactical_listview;
    ListView dialog_lethal_listview;
    ListView dialog_melee_listview;
    ListView dialog_fieldupgrade_listview;
    ListView dialog_start_rating_listview;
    ListView dialog_end_rating_listview;

    ArrayAdapter<String> primary_popup_adapter;
    ArrayAdapter<String> secondary_popup_adapter;
    ArrayAdapter<String> tactical_popup_adapter;
    ArrayAdapter<String> lethal_popup_adapter;
    ArrayAdapter<String> melee_popup_adapter;
    ArrayAdapter<String> fieldupgrade_popup_adapter;
    ArrayAdapter<String> start_rating_popup_adapter;
    ArrayAdapter<String> end_rating_popup_adapter;

    Button btn_j_back;
    Button btn_j_search;

    Intent intent_j_welcome;
    Intent intent_j_searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_loadouts);

        btn_j_back   = findViewById(R.id.btn_v_makeS_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_search = findViewById(R.id.btn_v_makeS_next);
        btn_j_search.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_welcome    = new Intent(searchLoadouts.this, welcomeScreen.class);

        primarySel = findViewById(R.id.tv_makeS_secondary_selection);

        //-----------------------------Primaries--------------------------------
        primaries = new ArrayList<>();

        //ARs
        primaries.add("XM4");
        primaries.add("AK-74");
        primaries.add("AMES 85");
        primaries.add("GPR 91");
        primaries.add("MODEL L");
        primaries.add("GOBLIN MK2");
        primaries.add("AS VAL");
        primaries.add("KRIG C");

        //SMGs
        primaries.add("C9");
        primaries.add("KSV");
        primaries.add("TANTO .22");
        primaries.add("PP-919");
        primaries.add("JACKAL PDW");
        primaries.add("KOMPAKT 92");
        primaries.add("SAUG");

        //LMGs
        primaries.add("PU-21");
        primaries.add("XMG");
        primaries.add("GPMG-7");

        //Marksmans
        primaries.add("SWAT 5.56");
        primaries.add("TSARKOV 7.62");
        primaries.add("AEK-973");
        primaries.add("DM-10");

        //Snipers
        primaries.add("LW3A1 FROSTLINE");
        primaries.add("SVD");
        primaries.add("LR 7.62");

        primarySelClickListenerTextView();


        secondarySel = findViewById(R.id.tv_makeS_optic_selection);

        //-----------------------------Secondaries--------------------------------
        secondaries = new ArrayList<>();

        //Pistols
        secondaries.add("9MM PM");
        secondaries.add("GREKHOVA");
        secondaries.add("GS45");
        secondaries.add("STRYDER .22");

        secondarySelClickListenerTextView();


        tacticalSel = findViewById(R.id.tv_makeS_muzzle_selection);

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

        tacticalSelClickListenerTextView();


        lethalSel = findViewById(R.id.tv_makeS_barrel_selection);

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

        lethalSelClickListenerTextView();


        meleeSel = findViewById(R.id.tv_makeS_mag_selection);
        //-----------------------------Melees--------------------------------
        melee = new ArrayList<>();

        //Melees
        melee.add("Knife");
        melee.add("Baseball Bat");
        melee.add("Power Drill");

        meleeSelClickListenerTextView();


        fieldUpgradeSel = findViewById(R.id.tv_makeS_grip_selection);
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

        fieldUpgradeClickListenerTextView();


        startRatingSel = findViewById(R.id.tv_start_rating_selection);
        //-----------------------------Start Rating--------------------------------
        startRatings = new ArrayList<>();

        //Start Rating
        startRatings.add("1");
        startRatings.add("2");
        startRatings.add("3");
        startRatings.add("4");
        startRatings.add("5");

        startRatingSelClickListenerTextView();


        endRatingSel = findViewById(R.id.tv_end_rating_selection);
        //-----------------------------Start Rating--------------------------------
        endRatings = new ArrayList<>();

        //end Rating
        endRatings.add("1");
        endRatings.add("2");
        endRatings.add("3");
        endRatings.add("4");
        endRatings.add("5");

        endRatingSelClickListenerTextView();


        backBtnListener();
    }

    //=========================Primaries================================================
    private void primarySelClickListenerTextView(){
        primarySel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryPopUp = new Dialog(searchLoadouts.this);

                primaryPopUp.setContentView(R.layout.primary_spinner_data);

                primaryPopUp.getWindow().setLayout(800, 1200);

                primaryPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));

                primaryPopUp.show();

                //initialize the gui elements
                primary_popup_search    = primaryPopUp.findViewById(R.id.et_primarySearch);
                dialog_primary_listview = primaryPopUp.findViewById(R.id.lv_primaries);

                //create an adapter for the listview
                primary_popup_adapter = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, primaries);

                //set the adapter
                dialog_primary_listview.setAdapter(primary_popup_adapter);

                //Change the results that are shown in the listview
                primaryPopUpEditTextChangeListener();
            }
        });
    }

    private void primaryPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        primary_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                primary_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_primary_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        primarySel.setText(primary_popup_adapter.getItem(i));

                        //remove the popup
                        primaryPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Secondaries==============================================
    private void secondarySelClickListenerTextView(){
        secondarySel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryPopUp = new Dialog(searchLoadouts.this);
                secondaryPopUp.setContentView(R.layout.secondary_spinner_data);

                secondaryPopUp.getWindow().setLayout(800, 1200);
                secondaryPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));

                secondaryPopUp.show();

                //initialize the gui elements
                secondary_popup_search      = secondaryPopUp.findViewById(R.id.et_secondarySearch);
                dialog_secondary_listview   = secondaryPopUp.findViewById(R.id.lv_secondaries);

                //create an adapter for the listview
                secondary_popup_adapter = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, secondaries);

                //set the adapter
                dialog_secondary_listview.setAdapter(secondary_popup_adapter);

                secondaryPopUpEditTextChangeListener();
            }
        });
    }

    private void secondaryPopUpEditTextChangeListener(){
        secondary_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                secondary_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_secondary_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        secondarySel.setText(secondary_popup_adapter.getItem(i));

                        secondaryPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=============================Tacticals============================================
    private void tacticalSelClickListenerTextView(){
        tacticalSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tacticalPopUp = new Dialog(searchLoadouts.this);
                tacticalPopUp.setContentView(R.layout.tactical_spinner_data);

                tacticalPopUp.getWindow().setLayout(800, 1200);
                tacticalPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                tacticalPopUp.show();

                tactical_popup_search       = tacticalPopUp.findViewById(R.id.et_tacticalSearch);
                dialog_tactical_listview    = tacticalPopUp.findViewById(R.id.lv_tacticals);

                tactical_popup_adapter = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, tacticals);
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
                lethalPopUp = new Dialog(searchLoadouts.this);
                lethalPopUp.setContentView(R.layout.lethal_spinner_data);

                lethalPopUp.getWindow().setLayout(800, 1200);
                lethalPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                lethalPopUp.show();

                lethal_popup_search     = lethalPopUp.findViewById(R.id.et_lethalSearch);
                dialog_lethal_listview  = lethalPopUp.findViewById(R.id.lv_lethals);

                lethal_popup_adapter    = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, lethals);
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
                meleePopUp = new Dialog(searchLoadouts.this);
                meleePopUp.setContentView(R.layout.melee_spinner_data);

                meleePopUp.getWindow().setLayout(800, 1200);
                meleePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                meleePopUp.show();

                melee_popup_search      = meleePopUp.findViewById(R.id.et_meleeSearch);
                dialog_melee_listview   = meleePopUp.findViewById(R.id.lv_melees);

                melee_popup_adapter     = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, melee);
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
                fieldUpgradePopUp = new Dialog(searchLoadouts.this);
                fieldUpgradePopUp.setContentView(R.layout.fieldupgrade_spinner_data);

                fieldUpgradePopUp.getWindow().setLayout(800, 1200);
                fieldUpgradePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                fieldUpgradePopUp.show();

                fieldupgrade_popup_search    = fieldUpgradePopUp.findViewById(R.id.et_fieldUpgradeSearch);
                dialog_fieldupgrade_listview = fieldUpgradePopUp.findViewById(R.id.lv_fieldUpgrades);

                fieldupgrade_popup_adapter   = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, fieldUpgrades);
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

    //=============================Start Rating============================================
    private void startRatingSelClickListenerTextView(){
        startRatingSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRatingPopUp = new Dialog(searchLoadouts.this);
                startRatingPopUp.setContentView(R.layout.start_rating_spinner_data);

                startRatingPopUp.getWindow().setLayout(800, 1200);
                startRatingPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                startRatingPopUp.show();

                start_rating_popup_search    = startRatingPopUp.findViewById(R.id.et_startRatingSearch);
                dialog_start_rating_listview = startRatingPopUp.findViewById(R.id.lv_startRating);

                start_rating_popup_adapter   = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, startRatings);
                dialog_start_rating_listview.setAdapter(start_rating_popup_adapter);

                startRatingPopUpEditTextChangeListener();
            }
        });
    }

    private void startRatingPopUpEditTextChangeListener(){
        start_rating_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                start_rating_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_start_rating_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startRatingSel.setText(start_rating_popup_adapter.getItem(i));
                        startRatingPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=============================End Rating============================================
    private void endRatingSelClickListenerTextView(){
        endRatingSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endRatingPopUp = new Dialog(searchLoadouts.this);
                endRatingPopUp.setContentView(R.layout.end_rating_spinner_data);

                endRatingPopUp.getWindow().setLayout(800, 1200);
                endRatingPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                endRatingPopUp.show();

                end_rating_popup_search     = endRatingPopUp.findViewById(R.id.et_endRatingSearch);
                dialog_end_rating_listview  = endRatingPopUp.findViewById(R.id.lv_endRating);

                end_rating_popup_adapter    = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, endRatings);
                dialog_end_rating_listview.setAdapter(end_rating_popup_adapter);

                endRatingPopUpEditTextChangeListener();
            }
        });
    }

    private void endRatingPopUpEditTextChangeListener(){
        end_rating_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                end_rating_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_end_rating_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        endRatingSel.setText(end_rating_popup_adapter.getItem(i));
                        endRatingPopUp.dismiss();
                    }
                });
            }
        });
    }


    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent_j_welcome);
            }
        });
    }


}