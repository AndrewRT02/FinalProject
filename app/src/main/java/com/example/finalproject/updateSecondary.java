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

public class updateSecondary extends AppCompatActivity {

    TextView secondarySel;
    TextView opticSel;
    TextView muzzleSel;
    TextView barrelSel;
    TextView magSel;
    TextView gripSel;

    ArrayList<String> secondaries;
    ArrayList<String> optics;
    ArrayList<String> muzzles;
    ArrayList<String> barrels;
    ArrayList<String> mags;
    ArrayList<String> grips;

    Dialog secondaryPopUp;
    Dialog opticPopUp;
    Dialog muzzlePopUp;
    Dialog barrelPopUp;
    Dialog magPopUp;
    Dialog gripPopUp;

    EditText secondary_popup_search;
    EditText optic_popup_search;
    EditText muzzle_popup_search;
    EditText barrel_popup_search;
    EditText mag_popup_search;
    EditText grip_popup_search;

    ListView dialog_secondary_listview;
    ListView dialog_optic_listview;
    ListView dialog_muzzle_listview;
    ListView dialog_barrel_listview;
    ListView dialog_mag_listview;
    ListView dialog_grip_listview;

    ArrayAdapter<String> secondary_popup_adapter;
    ArrayAdapter<String> optic_popup_adapter;
    ArrayAdapter<String> muzzle_popup_adapter;
    ArrayAdapter<String> barrel_popup_adapter;
    ArrayAdapter<String> mag_popup_adapter;
    ArrayAdapter<String> grip_popup_adapter;

    Button btn_j_back;
    Button btn_j_update;

    Intent intent_j_back;
    Intent intent_j_update;

    TextView tv_j_sError;
    TextView tv_j_oError;
    TextView tv_j_mError;
    TextView tv_j_bError;
    TextView tv_j_magError;
    TextView tv_j_gError;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_secondary);

        btn_j_back = findViewById(R.id.btn_v_updateS_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_update = findViewById(R.id.btn_v_updateS_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_back = new Intent(updateSecondary.this, viewYourLoadout.class);
        intent_j_update = new Intent(updateSecondary.this, welcomeScreen.class);

        tv_j_sError = findViewById(R.id.tv_v_updateS_secondaryError);
        tv_j_oError = findViewById(R.id.tv_v_updateS_opticError);
        tv_j_mError = findViewById(R.id.tv_v_updateS_muzzleError);
        tv_j_bError = findViewById(R.id.tv_v_updateS_barrelError);
        tv_j_magError = findViewById(R.id.tv_v_updateS_magError);
        tv_j_gError = findViewById(R.id.tv_v_updateS_gripError);


        secondarySel = findViewById(R.id.tv_updateS_secondary_selection);
        //-------------------------------Secondary------------------------------
        secondaries = new ArrayList<>();

        //Pistols
        secondaries.add("9MM PM");
        secondaries.add("GREKHOVA");
        secondaries.add("GS45");
        secondaries.add("STRYDER .22");


        opticSel = findViewById(R.id.tv_updateS_optic_selection);
        //-------------------------------Optics------------------------------
        optics = new ArrayList<>();

        //Optics
        optics.add("Kepler Microflex");
        optics.add("Merlin Mini");
        optics.add("Accu-Spot Reflex");
        optics.add("Kepler Pistol Scope");
        optics.add("Otero Micro Dot");
        optics.add("Iron Sights");


        muzzleSel = findViewById(R.id.tv_updateS_muzzle_selection);
        //--------------------------------Muzzles------------------------------
        muzzles = new ArrayList<>();

        //Muzzles
        muzzles.add("Suppressor");
        muzzles.add("Compensator");
        muzzles.add("Muzzle Brake");
        muzzles.add("Ported Compensator");


        barrelSel = findViewById(R.id.tv_updateS_barrel_selection);
        //--------------------------------Barrels------------------------------
        barrels = new ArrayList<>();

        //Barrels
        barrels.add("Gain-Twist Barrel");
        barrels.add("CHF Barrel");
        barrels.add("Long Barrel");
        barrels.add("Short Barrel");
        barrels.add("Reinforced Barrel");


        magSel = findViewById(R.id.tv_updateS_mag_selection);
        //--------------------------------Magazines------------------------------
        mags = new ArrayList<>();

        //Magazines
        mags.add("Fast Mag I");
        mags.add("Extended Mag I");
        mags.add("Fast Mag II");
        mags.add("Extended Mag II");
        mags.add("Stock Mag");


        gripSel = findViewById(R.id.tv_updateS_grip_selection);
        //--------------------------------Grip------------------------------
        grips = new ArrayList<>();

        //Grips
        grips.add("Assault Grip");
        grips.add("Quickdraw Grip");
        grips.add("Commando Grip");
        grips.add("CQB Grip");
        grips.add("Ergonomic Grip");


        secondarySelClickListenerTextView();
        opticSelClickListenerTextView();
        muzzleSelClickListenerTextView();
        barrelSelClickListenerTextView();
        magSelClickListenerTextView();
        gripSelClickListenerTextView();


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
                bool = secondaryErroChecking();

                //secondaryName, secondaryId, secondaryOptic, secondaryMuzzle, secondaryBarrel, secondaryMagazine, secondaryGrip
                if (bool){
                    db.updateSecondary(secondarySel.getText().toString(), opticSel.getText().toString(), muzzleSel.getText().toString(), barrelSel.getText().toString(), magSel.getText().toString(), gripSel.getText().toString(), SecondarySessionData.getRegisteredSecondary().getSecondaryId());

                }
            }
        });
    }

    private boolean secondaryErroChecking(){
        Boolean bool = true;

        if (secondarySel.getText().toString().isEmpty()){
            tv_j_sError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (secondarySel != null) {
            tv_j_sError.setVisibility(View.INVISIBLE);
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

        if (magSel.getText().toString().isEmpty()){
            tv_j_magError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (magSel != null) {
            tv_j_magError.setVisibility(View.INVISIBLE);
        }

        if (gripSel.getText().toString().isEmpty()){
            tv_j_gError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (gripSel != null) {
            tv_j_gError.setVisibility(View.INVISIBLE);
        }

        return bool;
    }



    //=======================Secondaries==============================================
    private void secondarySelClickListenerTextView(){
        secondarySel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryPopUp = new Dialog(updateSecondary.this);
                secondaryPopUp.setContentView(R.layout.secondary_spinner_data);

                secondaryPopUp.getWindow().setLayout(800, 1200);
                secondaryPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));

                secondaryPopUp.show();

                //initialize the gui elements
                secondary_popup_search      = secondaryPopUp.findViewById(R.id.et_secondarySearch);
                dialog_secondary_listview   = secondaryPopUp.findViewById(R.id.lv_secondaries);

                //create an adapter for the listview
                secondary_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, secondaries);

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

    //=======================Optics==============================================
    private void opticSelClickListenerTextView(){
        opticSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opticPopUp = new Dialog(updateSecondary.this);
                opticPopUp.setContentView(R.layout.soptic_spinner_data);
                opticPopUp.getWindow().setLayout(800, 1200);
                opticPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                opticPopUp.show();

                //initialize the gui elements
                optic_popup_search    = opticPopUp.findViewById(R.id.et_opticSearch);
                dialog_optic_listview = opticPopUp.findViewById(R.id.lv_optics);

                //create an adapter for the listview
                optic_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, optics);

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
                muzzlePopUp = new Dialog(updateSecondary.this);
                muzzlePopUp.setContentView(R.layout.smuzzle_spinner_data);
                muzzlePopUp.getWindow().setLayout(800, 1200);
                muzzlePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                muzzlePopUp.show();

                //initialize the gui elements
                muzzle_popup_search    = muzzlePopUp.findViewById(R.id.et_muzzleSearch);
                dialog_muzzle_listview = muzzlePopUp.findViewById(R.id.lv_muzzles);

                //create an adapter for the listview
                muzzle_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, muzzles);

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
                barrelPopUp = new Dialog(updateSecondary.this);
                barrelPopUp.setContentView(R.layout.sbarrel_spinner_data);
                barrelPopUp.getWindow().setLayout(800, 1200);
                barrelPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                barrelPopUp.show();

                //initialize the gui elements
                barrel_popup_search    = barrelPopUp.findViewById(R.id.et_barrelSearch);
                dialog_barrel_listview = barrelPopUp.findViewById(R.id.lv_barrels);

                //create an adapter for the listview
                barrel_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, barrels);

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

    //=======================Magazine=============================================
    private void magSelClickListenerTextView(){
        magSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                magPopUp = new Dialog(updateSecondary.this);
                magPopUp.setContentView(R.layout.smag_spinner_data);
                magPopUp.getWindow().setLayout(800, 1200);
                magPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                magPopUp.show();

                //initialize the gui elements
                mag_popup_search    = magPopUp.findViewById(R.id.et_magSearch);
                dialog_mag_listview = magPopUp.findViewById(R.id.lv_mags);

                //create an adapter for the listview
                mag_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, mags);

                //set the adapter
                dialog_mag_listview.setAdapter(mag_popup_adapter);

                //Change the results that are shown in the listview
                magPopUpEditTextChangeListener();
            }
        });
    }

    private void magPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        mag_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                mag_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_mag_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        magSel.setText(mag_popup_adapter.getItem(i));

                        //remove the popup
                        magPopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Grip=============================================
    private void gripSelClickListenerTextView(){
        gripSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gripPopUp = new Dialog(updateSecondary.this);
                gripPopUp.setContentView(R.layout.sgrip_spinner_data);
                gripPopUp.getWindow().setLayout(800, 1200);
                gripPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                gripPopUp.show();

                //initialize the gui elements
                grip_popup_search    = gripPopUp.findViewById(R.id.et_gripSearch);
                dialog_grip_listview = gripPopUp.findViewById(R.id.lv_grips);

                //create an adapter for the listview
                grip_popup_adapter = new ArrayAdapter<>(updateSecondary.this, android.R.layout.simple_list_item_1, grips);

                //set the adapter
                dialog_grip_listview.setAdapter(grip_popup_adapter);

                //Change the results that are shown in the listview
                gripPopUpEditTextChangeListener();
            }
        });
    }

    private void gripPopUpEditTextChangeListener(){
        //the user is typing in the edit text

        grip_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                grip_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_grip_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        gripSel.setText(grip_popup_adapter.getItem(i));

                        //remove the popup
                        gripPopUp.dismiss();
                    }
                });
            }
        });
    }
}