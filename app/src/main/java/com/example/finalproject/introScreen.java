package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class introScreen extends AppCompatActivity {

    Button btn_j_login;
    Button btn_j_register;

    Intent intent_j_register;
    Intent intent_j_login;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_j_login     = findViewById(R.id.btn_v_main_login);
        btn_j_register  = findViewById(R.id.btn_v_main_register);

        btn_j_login.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_register.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_register = new Intent(introScreen.this, registerUser.class);
        intent_j_login    = new Intent(introScreen.this, loginScreen.class);

        registerBtnListener();
        loginBtnListener();
    }

    private void registerBtnListener(){
        btn_j_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_register);
            }
        });
    }

    private void loginBtnListener(){
        btn_j_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_login);
            }
        });
    }
}