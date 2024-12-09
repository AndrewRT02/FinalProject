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

public class makePerks extends AppCompatActivity {

    TextView p1Sel;
    TextView p2Sel;
    TextView p3Sel;

    ArrayList<String> p1;
    ArrayList<String> p2;
    ArrayList<String> p3;

    Dialog p1PopUp;
    Dialog p2PopUp;
    Dialog p3PopUp;

    EditText p1_popup_search;
    EditText p2_popup_search;
    EditText p3_popup_search;

    ListView dialog_p1_listview;
    ListView dialog_p2_listview;
    ListView dialog_p3_listview;

    ArrayAdapter<String> p1_popup_adapter;
    ArrayAdapter<String> p2_popup_adapter;
    ArrayAdapter<String> p3_popup_adapter;


    Button btn_j_back;
    Button btn_j_next;
    Button btn_j_home;

    Intent intent_j_next;
    Intent intent_j_back;
    Intent intent_j_home;

    TextView tv_j_p1Error;
    TextView tv_j_p2Error;
    TextView tv_j_p3Error;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_make_perks);

        btn_j_back = findViewById(R.id.btn_v_makePerk_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_next = findViewById(R.id.btn_v_makePerk_next);
        btn_j_next.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_home = findViewById(R.id.btn_v_makePerk_home);
        btn_j_home.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_back = new Intent(makePerks.this, makeSecondary.class);
        intent_j_next = new Intent(makePerks.this, makeLoadout.class);
        intent_j_home = new Intent(makePerks.this, welcomeScreen.class);

        tv_j_p1Error = findViewById(R.id.tv_v_makePerk_p1Error);
        tv_j_p2Error = findViewById(R.id.tv_v_makePerk_p2Error);
        tv_j_p3Error = findViewById(R.id.tv_v_makePerk_p3Error);



        p1Sel = findViewById(R.id.tv_makePerk_p1_selection);
        //-------------------------------Perk 1------------------------------
        p1 = new ArrayList<>();

        //Perk 1
        p1.add("Gung-Ho");
        p1.add("Dexterity");
        p1.add("Scavenger");
        p1.add("Ghost");
        p1.add("Ninja");
        p1.add("Flak Jacket");
        p1.add("Tac Mask");


        p2Sel = findViewById(R.id.tv_makePerk_p2_selection);
        //-------------------------------Perk 2------------------------------
        p2 = new ArrayList<>();

        p2.add("Assassin");
        p2.add("Bruiser");
        p2.add("Engineer");
        p2.add("Tracker");
        p2.add("Forward Intel");
        p2.add("Shadow");
        p2.add("Dispatcher");
        p2.add("Fast Hands");


        p3Sel = findViewById(R.id.tv_makePerk_p3_selection);
        //-------------------------------Perk 2------------------------------
        p3 = new ArrayList<>();

        p3.add("Double Time");
        p3.add("Bankroll");
        p3.add("Vigilance");
        p3.add("Cold-Blooded");
        p3.add("Quartermaster");
        p3.add("Guardian");
        p3.add("Gearhead");


        p1SelClickListenerTextView();
        p2SelClickListenerTextView();
        p3SelClickListenerTextView();

        backBtnListener();
        homeBtnListener();
        nextBtnListener();
    }

    //=======================Perk 1==============================================
    private void p1SelClickListenerTextView(){
        p1Sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1PopUp = new Dialog(makePerks.this);
                p1PopUp.setContentView(R.layout.p1_spinner_data);
                p1PopUp.getWindow().setLayout(800, 1200);
                p1PopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                p1PopUp.show();

                //initialize the gui elements
                p1_popup_search      = p1PopUp.findViewById(R.id.et_p1Search);
                dialog_p1_listview   = p1PopUp.findViewById(R.id.lv_p1);

                //create an adapter for the listview
                p1_popup_adapter = new ArrayAdapter<>(makePerks.this, android.R.layout.simple_list_item_1, p1);

                //set the adapter
                dialog_p1_listview.setAdapter(p1_popup_adapter);

                p1PopUpEditTextChangeListener();
            }
        });
    }

    private void p1PopUpEditTextChangeListener(){
        p1_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                p1_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_p1_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        p1Sel.setText(p1_popup_adapter.getItem(i));

                        p1PopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Perk 2==============================================
    private void p2SelClickListenerTextView(){
        p2Sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2PopUp = new Dialog(makePerks.this);
                p2PopUp.setContentView(R.layout.p2_spinner_data);
                p2PopUp.getWindow().setLayout(800, 1200);
                p2PopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                p2PopUp.show();

                //initialize the gui elements
                p2_popup_search      = p2PopUp.findViewById(R.id.et_p2Search);
                dialog_p2_listview   = p2PopUp.findViewById(R.id.lv_p2);

                //create an adapter for the listview
                p2_popup_adapter = new ArrayAdapter<>(makePerks.this, android.R.layout.simple_list_item_1, p2);

                //set the adapter
                dialog_p2_listview.setAdapter(p2_popup_adapter);

                p2PopUpEditTextChangeListener();
            }
        });
    }

    private void p2PopUpEditTextChangeListener(){
        p2_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                p2_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_p2_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        p2Sel.setText(p2_popup_adapter.getItem(i));

                        p2PopUp.dismiss();
                    }
                });
            }
        });
    }

    //=======================Perk 3==============================================
    private void p3SelClickListenerTextView(){
        p3Sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p3PopUp = new Dialog(makePerks.this);
                p3PopUp.setContentView(R.layout.p3_spinner_data);
                p3PopUp.getWindow().setLayout(800, 1200);
                p3PopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(250, 103, 0)));
                p3PopUp.show();

                //initialize the gui elements
                p3_popup_search      = p3PopUp.findViewById(R.id.et_p3Search);
                dialog_p3_listview   = p3PopUp.findViewById(R.id.lv_p3);

                //create an adapter for the listview
                p3_popup_adapter = new ArrayAdapter<>(makePerks.this, android.R.layout.simple_list_item_1, p3);

                //set the adapter
                dialog_p3_listview.setAdapter(p3_popup_adapter);

                p3PopUpEditTextChangeListener();
            }
        });
    }

    private void p3PopUpEditTextChangeListener(){
        p3_popup_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                p3_popup_adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                dialog_p3_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        p3Sel.setText(p3_popup_adapter.getItem(i));

                        p3PopUp.dismiss();
                    }
                });
            }
        });
    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_back);
            }
        });
    }

    private void homeBtnListener(){
        btn_j_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_home);
            }
        });
    }

    private void nextBtnListener(){
        btn_j_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean bool;
                bool = perksErrorField();

                Log.d("Apple", MakeSecondarySessionData.getSecondaryParts().getUserSecondaryName());
                int i = db.getLastMadePerkId();
                Log.d("Apple", String.valueOf(i));
                //make sure to add error checking
                if (bool){
                    db.setUserPerksInfo(p1Sel.getText().toString(), p2Sel.getText().toString(), p3Sel.getText().toString());

                    startActivity(intent_j_next);
                }
            }
        });
    }


    //Make an error checking field
    private boolean perksErrorField(){
        Boolean bool = true;

        //P1 Error Checking
        if (p1Sel.getText().toString().isEmpty()){
            tv_j_p1Error.setVisibility(View.VISIBLE);
            bool = false;
        } else if (p1Sel != null) {
            tv_j_p1Error.setVisibility(View.INVISIBLE);
        }

        //p2 Error Checking
        if (p2Sel.getText().toString().isEmpty()){
            tv_j_p2Error.setVisibility(View.VISIBLE);
            bool = false;
        } else if (p2Sel != null) {
            tv_j_p2Error.setVisibility(View.INVISIBLE);
        }

        //p3 Error Checking
        if (p3Sel.getText().toString().isEmpty()){
            tv_j_p3Error.setVisibility(View.VISIBLE);
            bool = false;
        } else if (p3Sel != null) {
            tv_j_p3Error.setVisibility(View.INVISIBLE);
        }

        return bool;
    }

}