package com.example.finalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loginScreen extends AppCompatActivity {

    Button btn_j_back;
    Button btn_j_login;

    Intent intent_j_back;
    Intent intent_j_login;

    MediaPlayer loginBtnPressSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        btn_j_back  = findViewById(R.id.btn_v_login_back);
        btn_j_login = findViewById(R.id.btn_v_login_login);

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
                startActivity(intent_j_login);
            }
        });
    }
}