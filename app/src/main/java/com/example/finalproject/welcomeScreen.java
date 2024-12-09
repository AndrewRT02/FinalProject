package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class welcomeScreen extends AppCompatActivity {

    //TextView tv_j_user;

    Button btn_j_search;
    Button btn_j_make;
    Button btn_j_userLoadouts;
    Button btn_j_allLoadouts;
    Button btn_j_profile;
    Button btn_j_signOut;


    Intent intent_j_searchLoadout;
    Intent intent_j_makeLoadoutStep1;
    Intent intent_j_viewUserLoadouts;
    Intent intent_j_allLoadouts;
    Intent intent_j_profile;
    Intent intent_j_loginScreen;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_screen);

        //tv_j_user           = findViewById(R.id.tv_v_welcome_user);

        btn_j_search        = findViewById(R.id.btn_v_wel_search);
        btn_j_search.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_make          = findViewById(R.id.btn_v_wel_make);
        btn_j_make.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_userLoadouts  = findViewById(R.id.btn_v_wel_userLoadouts);
        btn_j_userLoadouts.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_allLoadouts   = findViewById(R.id.btn_v_wel_allLoadouts);
        btn_j_allLoadouts.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_profile       = findViewById(R.id.btn_v_wel_profile);
        btn_j_profile.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_signOut       = findViewById(R.id.btn_v_wel_signout);
        btn_j_signOut.setBackgroundColor(Color.rgb(250, 103, 0));


        intent_j_searchLoadout  = new Intent(welcomeScreen.this, searchLoadouts.class);
        intent_j_makeLoadoutStep1 = new Intent(welcomeScreen.this, makePrimary.class);
        intent_j_viewUserLoadouts = new Intent(welcomeScreen.this, viewUsersLoadouts.class);
        intent_j_allLoadouts    = new Intent(welcomeScreen.this, viewLoadouts.class);
        intent_j_profile        = new Intent(welcomeScreen.this, userProfile.class);
        intent_j_loginScreen    = new Intent(welcomeScreen.this, loginScreen.class);

        //Bundle extras = getIntent().getExtras();
        //String uname = extras.getString("DisplayUName");

        //For some reason when I try to put Username into tv_j_user, it crashes

        //String uname = SessionData.getRegisteredUser().getUname();

        //tv_j_user.setText(SessionData.getRegisteredUser().getUname());

        dbHelper.initAllTables();

        Log.d("Cranberry", dbHelper.getPrimaryNameFromId(1));

        //Log.d("SessionName", SessionData.getRegisteredUser().getUname());


        searchLoadoutBtnListener();
        makeLoadoutBtnListener();
        usersLoadoutsBtnListener();
        allLoadoutsBtnListener();
        userProfileBtnListener();
        signOutBtnListener();
    }

    private void allLoadoutsBtnListener(){
        btn_j_allLoadouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_allLoadouts);
            }
        });
    }

    private void signOutBtnListener(){
        btn_j_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_loginScreen);
            }
        });
    }

    private void searchLoadoutBtnListener(){
        btn_j_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_searchLoadout);
            }
        });
    }

    private void userProfileBtnListener(){
        btn_j_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_profile);
            }
        });
    }

    private void makeLoadoutBtnListener(){
        btn_j_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_makeLoadoutStep1);
            }
        });
    }

    private void usersLoadoutsBtnListener(){
        btn_j_userLoadouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_viewUserLoadouts);
            }
        });
    }
}