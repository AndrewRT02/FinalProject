package com.example.finalproject;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class searchLoadouts extends AppCompatActivity {

    TextView primarySel;
    TextView secondarySel;
    TextView tacticalSel;
    TextView lethalSel;
    TextView meleeSel;
    TextView fieldUpgradeSel;

    ArrayList<String> primaries;
    ArrayList<String> secondaries;
    ArrayList<String> tacticals;
    ArrayList<String> lethals;
    ArrayList<String> fieldUpgrades;

    Dialog primaryPopUp;
    Dialog secondaryPopUp;
    Dialog tacticalPopUp;
    Dialog lethalPopUp;
    Dialog meleePopUp;
    Dialog fieldUpgradePopUp;

    EditText primary_popup_search;
    EditText secondary_popup_search;
    EditText tactical_popup_search;
    EditText lethal_popup_search;
    EditText melee_popup_search;
    EditText fieldupgrade_popup_search;

    ListView dialog_primary_listview;
    ListView dialog_secondary_listview;
    ListView dialog_tactical_listview;
    ListView dialog_lethal_listview;
    ListView dialog_melee_listview;
    ListView dialog_fieldupgrade_listview;

    ArrayAdapter<String> primary_popup_adapter;
    ArrayAdapter<String> secondary_popup_adapter;
    ArrayAdapter<String> tactical_popup_adapter;
    ArrayAdapter<String> lethal_popup_adapter;
    ArrayAdapter<String> melee_popup_adapter;
    ArrayAdapter<String> fieldupgrade_popup_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_loadouts);

        primarySel = findViewById(R.id.tv_primary_selection);

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

    }

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
                primary_popup_search = primaryPopUp.findViewById(R.id.et_primarySearch);
                dialog_primary_listview = primaryPopUp.findViewById(R.id.lv_primaries);

                //create an adapter for the listview
                primary_popup_adapter = new ArrayAdapter<>(searchLoadouts.this, android.R.layout.simple_list_item_1, primaries);

                //set the adapter
                dialog_primary_listview.setAdapter(primary_popup_adapter);

                //Change the results that are shown in the listview
                primaryPopUpEditTextChangeListener();

                //Determine what item was selected
                primaryPopUpClickListener();
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

    private void primaryPopUpClickListener(){

    }
}