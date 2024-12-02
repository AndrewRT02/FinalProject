package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loginScreen extends AppCompatActivity {

    Button btn_j_back;
    Button btn_j_login;

    TextView tv_j_uNameError;
    TextView tv_j_userNameUsed;

    EditText et_j_uName;

    Intent intent_j_back;
    Intent intent_j_login;

    MediaPlayer loginBtnPressSound;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        btn_j_back  = findViewById(R.id.btn_v_login_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_login = findViewById(R.id.btn_v_login_login);
        btn_j_login.setBackgroundColor(Color.rgb(250, 103, 0));

        et_j_uName = findViewById(R.id.et_v_login_uName);

        tv_j_uNameError = findViewById(R.id.tv_v_login_uError);
        tv_j_userNameUsed = findViewById(R.id.tv_v_login_uUsed);

        intent_j_back   = new Intent(loginScreen.this, introScreen.class);
        intent_j_login  = new Intent(loginScreen.this, welcomeScreen.class);

        loginBtnPressSound = MediaPlayer.create(loginScreen.this, R.raw.hitmarker);

        backBtnListener();
        loginBtnListener();
    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_back);
            }
        });
    }

    private void loginBtnListener(){
        btn_j_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginBtnPressSound.start();

                Boolean bool;
                bool = uNameErrorField();

                String uname = et_j_uName.getText().toString();

                //-------------------------Remember to add the error field checking---------------------------------
                //Remember to remove the commented out section

                if (bool){
                    //Log.d("Cranberry", "Got Here");
                    for (int i = 0; i < dbHelper.allUsersList().size(); i++){
                        if (uname.equals(dbHelper.allUsersList().get(i).getUsername())){
                            //Log.d("Cranberry", "Got Here");
                            tv_j_userNameUsed.setVisibility(View.INVISIBLE);
                            dbHelper.getAllUserInfoGivenUsername(uname);
                            //intent_j_login.putExtra("DisplayUName", uname);
                            startActivity(intent_j_login);
                            et_j_uName.setText("");
                            return;
                        }
                        tv_j_userNameUsed.setVisibility(View.VISIBLE);
                    }
                }
                //startActivity(intent_j_login);
            }
        });
    }

    private Boolean uNameErrorField(){
        Boolean bool = true;

       //Username Error Checking
       if(et_j_uName.getText().toString().isEmpty()){
           tv_j_uNameError.setVisibility(View.VISIBLE);
           bool = false;
       } else if (et_j_uName != null) {
           tv_j_uNameError.setVisibility(View.INVISIBLE);
       }

       return bool;
    }
}