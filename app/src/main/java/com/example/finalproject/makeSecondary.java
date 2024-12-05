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

public class makeSecondary extends AppCompatActivity {

    TextView secondarySel;
    TextView opticSel;
    TextView muzzleSel;
    TextView barrelSel;
    TextView uBarrelSel;
    TextView stockSel;

    ArrayList<String> secondaries;
    ArrayList<String> optics;
    ArrayList<String> muzzles;
    ArrayList<String> barrels;
    ArrayList<String> uBarrels;
    ArrayList<String> stocks;

    Dialog secondaryPopUp;
    Dialog opticPopUp;
    Dialog muzzlePopUp;
    Dialog barrelPopUp;
    Dialog uBarrelPopUp;
    Dialog stockPopUp;

    EditText secondary_popup_search;
    EditText optic_popup_search;
    EditText muzzle_popup_search;
    EditText barrel_popup_search;
    EditText ubarrel_popup_search;
    EditText stock_popup_search;

    ListView dialog_secondary_listview;
    ListView dialog_optic_listview;
    ListView dialog_muzzle_listview;
    ListView dialog_barrel_listview;
    ListView dialog_ubarrel_listview;
    ListView dialog_stock_listview;

    ArrayAdapter<String> secondary_popup_adapter;
    ArrayAdapter<String> optic_popup_adapter;
    ArrayAdapter<String> muzzle_popup_adapter;
    ArrayAdapter<String> barrel_popup_adapter;
    ArrayAdapter<String> ubarrel_popup_adapter;
    ArrayAdapter<String> stock_popup_adapter;


    Button btn_j_back;
    Button btn_j_next;

    Intent intent_j_next;
    Intent intent_j_back;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_make_secondary);

    }

    //=======================Secondaries==============================================
    private void secondarySelClickListenerTextView(){
        secondarySel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryPopUp = new Dialog(makeSecondary.this);
                secondaryPopUp.setContentView(R.layout.secondary_spinner_data);

                secondaryPopUp.getWindow().setLayout(800, 1200);
                secondaryPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));

                secondaryPopUp.show();

                //initialize the gui elements
                secondary_popup_search      = secondaryPopUp.findViewById(R.id.et_secondarySearch);
                dialog_secondary_listview   = secondaryPopUp.findViewById(R.id.lv_secondaries);

                //create an adapter for the listview
                secondary_popup_adapter = new ArrayAdapter<>(makeSecondary.this, android.R.layout.simple_list_item_1, secondaries);

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
}