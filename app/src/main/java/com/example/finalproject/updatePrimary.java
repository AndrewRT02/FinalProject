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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class updatePrimary extends AppCompatActivity {

    TextView primarySel;
    TextView opticSel;
    TextView muzzleSel;
    TextView barrelSel;
    TextView uBarrelSel;
    TextView stockSel;

    ArrayList<String> primaries;
    ArrayList<String> optics;
    ArrayList<String> muzzles;
    ArrayList<String> barrels;
    ArrayList<String> uBarrels;
    ArrayList<String> stocks;

    Dialog primaryPopUp;
    Dialog opticPopUp;
    Dialog muzzlePopUp;
    Dialog barrelPopUp;
    Dialog uBarrelPopUp;
    Dialog stockPopUp;

    EditText primary_popup_search;
    EditText optic_popup_search;
    EditText muzzle_popup_search;
    EditText barrel_popup_search;
    EditText ubarrel_popup_search;
    EditText stock_popup_search;

    ListView dialog_primary_listview;
    ListView dialog_optic_listview;
    ListView dialog_muzzle_listview;
    ListView dialog_barrel_listview;
    ListView dialog_ubarrel_listview;
    ListView dialog_stock_listview;

    ArrayAdapter<String> primary_popup_adapter;
    ArrayAdapter<String> optic_popup_adapter;
    ArrayAdapter<String> muzzle_popup_adapter;
    ArrayAdapter<String> barrel_popup_adapter;
    ArrayAdapter<String> ubarrel_popup_adapter;
    ArrayAdapter<String> stock_popup_adapter;

    Button btn_j_back;
    Button btn_j_update;

    Intent intent_j_back;
    Intent intent_j_update;

    TextView tv_j_pError;
    TextView tv_j_oError;
    TextView tv_j_mError;
    TextView tv_j_bError;
    TextView tv_j_uBError;
    TextView tv_j_sError;

    DatabaseHelper db = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_primary);

        btn_j_back = findViewById(R.id.btn_v_updateP_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_update = findViewById(R.id.btn_v_updateP_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_back = new Intent(updatePrimary.this, viewYourLoadout.class);
        intent_j_update = new Intent(updatePrimary.this, welcomeScreen.class);

        tv_j_pError = findViewById(R.id.tv_v_updateP_primaryError);
        tv_j_oError = findViewById(R.id.tv_v_updateP_opticError);
        tv_j_mError = findViewById(R.id.tv_v_updateP_muzzleError);
        tv_j_bError = findViewById(R.id.tv_v_updateP_barrelError);
        tv_j_uBError = findViewById(R.id.tv_v_updateP_uBarrelError);
        tv_j_sError = findViewById(R.id.tv_v_updateP_errorStock);

        primarySel = findViewById(R.id.tv_updateP_primary_selection);
        //--------------------------------Primary------------------------------
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


        opticSel = findViewById(R.id.tv_updateP_optic_selection);
        //--------------------------------Optics------------------------------
        optics = new ArrayList<>();

        //Optics
        optics.add("Kepler Microflex");
        optics.add("PrismaTech Reflex");
        optics.add("Volzhskiy Reflex");
        optics.add("Merlin Reflex");
        optics.add("PrismaTech 4x");
        optics.add("PrismaPoint Hybrid");
        optics.add("Hawker Hybrid");
        optics.add("R&K Multizoom");
        optics.add("K&S Thermal Holo");
        optics.add("Iron Sights");


        muzzleSel = findViewById(R.id.tv_updateP_muzzle_selection);
        //--------------------------------Muzzles------------------------------
        muzzles = new ArrayList<>();

        //Muzzles
        muzzles.add("Suppressor");
        muzzles.add("Compensator");
        muzzles.add("Muzzle Brake");
        muzzles.add("Ported Compensator");


        barrelSel = findViewById(R.id.tv_updateP_barrel_selection);
        //--------------------------------Barrels------------------------------
        barrels = new ArrayList<>();

        //Barrels
        barrels.add("Gain-Twist Barrel");
        barrels.add("CHF Barrel");
        barrels.add("Long Barrel");
        barrels.add("Short Barrel");
        barrels.add("Reinforced Barrel");


        uBarrelSel = findViewById(R.id.tv_updateP_uBarrel_selection);
        //-----------------------------UnderBarrels---------------------------
        uBarrels = new ArrayList<>();

        uBarrels.add("Vertical Foregrip");
        uBarrels.add("Launcher - Standard");
        uBarrels.add("Launcher - High Explosive");
        uBarrels.add("Precision Foregrip");
        uBarrels.add("Lightweight Foregrip");
        uBarrels.add("Marksman Foregrip");


        stockSel = findViewById(R.id.tv_updateP_stock_selection);
        //--------------------------------Stock-------------------------------
        stocks = new ArrayList<>();

        stocks.add("Light Stock");
        stocks.add("Heavy Stock");
        stocks.add("Balanced Stock");
        stocks.add("Combat Stock");
        stocks.add("Infiltrator Stock");
        stocks.add("Buffer Weight Stock");
        stocks.add("No Stock");



        primarySelClickListenerTextView();
        opticSelClickListenerTextView();
        muzzleSelClickListenerTextView();
        barrelSelClickListenerTextView();
        uBarrelSelClickListenerTextView();
        stockSelClickListenerTextView();

        backBtnListener();
        updateBtnListener();

    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_back);
            }
        });
    }

    private void updateBtnListener(){
        btn_j_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bool;
                bool = uPrimaryErroChecking();

                if (bool){
                    db.updatePrimary(primarySel.getText().toString(), opticSel.getText().toString(), muzzleSel.getText().toString(), barrelSel.getText().toString(), uBarrelSel.getText().toString(), stockSel.getText().toString(), PrimarySessionData.getRegisteredPrimary().getPrimaryId());
                    startActivity(intent_j_update);
                }

            }
        });
    }

    private boolean uPrimaryErroChecking(){
        Boolean bool = true;

        if (primarySel.getText().toString().isEmpty()){
            tv_j_pError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (primarySel != null) {
            tv_j_pError.setVisibility(View.INVISIBLE);
        }

        if (opticSel.getText().toString().isEmpty()){
            tv_j_oError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (opticSel != null) {
            tv_j_oError.setVisibility(View.INVISIBLE);
        }

        if (muzzleSel.getText().toString().isEmpty()){
            tv_j_mError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (muzzleSel != null) {
            tv_j_mError.setVisibility(View.INVISIBLE);
        }

        if (barrelSel.getText().toString().isEmpty()){
            tv_j_bError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (barrelSel != null) {
            tv_j_bError.setVisibility(View.INVISIBLE);
        }

        if (uBarrelSel.getText().toString().isEmpty()){
            tv_j_uBError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (uBarrelSel != null) {
            tv_j_uBError.setVisibility(View.INVISIBLE);
        }

        if (stockSel.getText().toString().isEmpty()){
            tv_j_sError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (stockSel != null) {
            tv_j_sError.setVisibility(View.INVISIBLE);
        }

        return bool;
    }

    //=======================Primaries=============================================
    private void primarySelClickListenerTextView(){
        primarySel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryPopUp = new Dialog(updatePrimary.this);

                primaryPopUp.setContentView(R.layout.primary_spinner_data);

                primaryPopUp.getWindow().setLayout(800, 1200);

                primaryPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));

                primaryPopUp.show();

                //initialize the gui elements
                primary_popup_search    = primaryPopUp.findViewById(R.id.et_primarySearch);
                dialog_primary_listview = primaryPopUp.findViewById(R.id.lv_primaries);

                //create an adapter for the listview
                primary_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, primaries);

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

    //=======================Optics==============================================
    private void opticSelClickListenerTextView(){
        opticSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opticPopUp = new Dialog(updatePrimary.this);
                opticPopUp.setContentView(R.layout.poptic_spinner_data);
                opticPopUp.getWindow().setLayout(800, 1200);
                opticPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                opticPopUp.show();

                //initialize the gui elements
                optic_popup_search    = opticPopUp.findViewById(R.id.et_opticSearch);
                dialog_optic_listview = opticPopUp.findViewById(R.id.lv_optics);

                //create an adapter for the listview
                optic_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, optics);

                //set the adapter
                dialog_optic_listview.setAdapter(optic_popup_adapter);

                //Change the results that are shown in the listview
                opticPopUpEditTextChangeListener();
            }
        });
    }

    private void opticPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        optic_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                optic_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_optic_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        opticSel.setText(optic_popup_adapter.getItem(i));

                        //remove the popup
                        opticPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Muzzles=============================================
    private void muzzleSelClickListenerTextView(){
        muzzleSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muzzlePopUp = new Dialog(updatePrimary.this);
                muzzlePopUp.setContentView(R.layout.pmuzzle_spinner_data);
                muzzlePopUp.getWindow().setLayout(800, 1200);
                muzzlePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                muzzlePopUp.show();

                //initialize the gui elements
                muzzle_popup_search    = muzzlePopUp.findViewById(R.id.et_muzzleSearch);
                dialog_muzzle_listview = muzzlePopUp.findViewById(R.id.lv_muzzles);

                //create an adapter for the listview
                muzzle_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, muzzles);

                //set the adapter
                dialog_muzzle_listview.setAdapter(muzzle_popup_adapter);

                //Change the results that are shown in the listview
                muzzlePopUpEditTextChangeListener();
            }
        });
    }

    private void muzzlePopUpEditTextChangeListener(){
        //the user is typing in the edit text

        muzzle_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                muzzle_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_muzzle_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        muzzleSel.setText(muzzle_popup_adapter.getItem(i));

                        //remove the popup
                        muzzlePopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Barrels=============================================
    private void barrelSelClickListenerTextView(){
        barrelSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barrelPopUp = new Dialog(updatePrimary.this);
                barrelPopUp.setContentView(R.layout.pbarrel_spinner_data);
                barrelPopUp.getWindow().setLayout(800, 1200);
                barrelPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                barrelPopUp.show();

                //initialize the gui elements
                barrel_popup_search    = barrelPopUp.findViewById(R.id.et_barrelSearch);
                dialog_barrel_listview = barrelPopUp.findViewById(R.id.lv_barrels);

                //create an adapter for the listview
                barrel_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, barrels);

                //set the adapter
                dialog_barrel_listview.setAdapter(barrel_popup_adapter);

                //Change the results that are shown in the listview
                barrelPopUpEditTextChangeListener();
            }
        });
    }

    private void barrelPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        barrel_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                barrel_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_barrel_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        barrelSel.setText(barrel_popup_adapter.getItem(i));

                        //remove the popup
                        barrelPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Underbarrels========================================
    private void uBarrelSelClickListenerTextView(){
        uBarrelSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uBarrelPopUp = new Dialog(updatePrimary.this);
                uBarrelPopUp.setContentView(R.layout.pubarrel_spinner_data);
                uBarrelPopUp.getWindow().setLayout(800, 1200);
                uBarrelPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                uBarrelPopUp.show();

                //initialize the gui elements
                ubarrel_popup_search    = uBarrelPopUp.findViewById(R.id.et_ubarrelSearch);
                dialog_ubarrel_listview = uBarrelPopUp.findViewById(R.id.lv_ubarrels);

                //create an adapter for the listview
                ubarrel_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, uBarrels);

                //set the adapter
                dialog_ubarrel_listview.setAdapter(ubarrel_popup_adapter);

                //Change the results that are shown in the listview
                uBarrelPopUpEditTextChangeListener();
            }
        });
    }

    private void uBarrelPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        ubarrel_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                ubarrel_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_ubarrel_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        uBarrelSel.setText(ubarrel_popup_adapter.getItem(i));

                        //remove the popup
                        uBarrelPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Stocks==============================================
    private void stockSelClickListenerTextView(){
        stockSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stockPopUp = new Dialog(updatePrimary.this);
                stockPopUp.setContentView(R.layout.pstock_spinner_data);
                stockPopUp.getWindow().setLayout(800, 1200);
                stockPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                stockPopUp.show();

                //initialize the gui elements
                stock_popup_search    = stockPopUp.findViewById(R.id.et_stockSearch);
                dialog_stock_listview = stockPopUp.findViewById(R.id.lv_stocks);

                //create an adapter for the listview
                stock_popup_adapter = new ArrayAdapter<>(updatePrimary.this, android.R.layout.simple_list_item_1, stocks);

                //set the adapter
                dialog_stock_listview.setAdapter(stock_popup_adapter);

                //Change the results that are shown in the listview
                stockPopUpEditTextChangeListener();
            }
        });
    }

    private void stockPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        stock_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                stock_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_stock_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        stockSel.setText(stock_popup_adapter.getItem(i));

                        //remove the popup
                        stockPopUp.dismiss();
                    }
                });
            }
        });
    }

}