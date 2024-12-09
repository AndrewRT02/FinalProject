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

public class rateLoadout extends AppCompatActivity {

    TextView ratingSel;
    ArrayList<String> ratings;
    Dialog ratePopUp;
    EditText rating_popup_search;
    ListView dialog_rate_listview;
    ArrayAdapter<String> rate_popup_adapter;

    TextView tv_j_lName;
    TextView tv_j_lId;
    TextView tv_j_creator;
    TextView tv_j_rError;

    Button btn_j_rate;
    Button btn_j_back;

    Intent intent_j_toWelcome;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate_loadout);

        tv_j_lName = findViewById(R.id.tv_v_rate_lName);
        tv_j_lId = findViewById(R.id.tv_v_rate_lID);
        tv_j_creator = findViewById(R.id.tv_v_rate_creator);

        btn_j_rate = findViewById(R.id.btn_v_rate_confirm);
        btn_j_rate.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_back = findViewById(R.id.btn_v_rate_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_toWelcome = new Intent(rateLoadout.this, welcomeScreen.class);

        tv_j_lName.setText(LoadoutSessionData.getRegisteredLoadout().getLoadoutName());
        String ID;
        ID = Integer.toString(LoadoutSessionData.getRegisteredLoadout().getLoadoutId());
        tv_j_lId.setText(ID);
        tv_j_creator.setText(LoadoutSessionData.getRegisteredLoadout().getUsername());


        ratingSel = findViewById(R.id.tv_rate_rateSel);
        ratings = new ArrayList<>();

        ratings.add("1");
        ratings.add("2");
        ratings.add("3");
        ratings.add("4");
        ratings.add("5");

        ratingSelClickListenerTextView();
        rateBtnListener();
        backBtn();
    }

    private void rateBtnListener(){
        btn_j_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bool;
                bool = ratingsErrorField();

                if (bool){
                    dbHelper.createLoadoutRating(Integer.parseInt(ratingSel.getText().toString()), Integer.parseInt(tv_j_lId.getText().toString()));
                    startActivity(intent_j_toWelcome);
                }
            }
        });
    }

    private void backBtn(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_toWelcome);
            }
        });
    }

    private Boolean ratingsErrorField(){
        Boolean bool = true;

        if (ratingSel.getText().toString().isEmpty()){

            bool = false;
        } else if (ratingSel != null) {
            
        }
        return bool;
    }


    private void ratingSelClickListenerTextView(){
        ratingSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratePopUp = new Dialog(rateLoadout.this);
                ratePopUp.setContentView(R.layout.rating_spinner_data);
                ratePopUp.getWindow().setLayout(800, 1200);
                ratePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                ratePopUp.show();

                //initialize the gui elements
                rating_popup_search    = ratePopUp.findViewById(R.id.et_rate);
                dialog_rate_listview = ratePopUp.findViewById(R.id.lv_rate);

                //create an adapter for the listview
                rate_popup_adapter = new ArrayAdapter<>(rateLoadout.this, android.R.layout.simple_list_item_1, ratings);

                //set the adapter
                dialog_rate_listview.setAdapter(rate_popup_adapter);

                //Change the results that are shown in the listview
                ratePopUpEditTextChangeListener();
            }
        });
    }

    private void ratePopUpEditTextChangeListener(){
        //the user is typing in the edit text

        rating_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //change the listview
                //filter the adapter
                rate_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_rate_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        ratingSel.setText(rate_popup_adapter.getItem(i));

                        //remove the popup
                        ratePopUp.dismiss();
                    }
                });
            }
        });
    }
}