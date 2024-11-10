package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class registerUser extends AppCompatActivity {

    Button btn_j_back;
    Button btn_j_register;

    Intent intent_j_backToIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_user);

        btn_j_back      = findViewById(R.id.btn_v_reg_back);
        btn_j_register  = findViewById(R.id.btn_v_reg_register);

        intent_j_backToIntro   = new Intent(registerUser.this, introScreen.class);


        backBtnListener();
        registerBtnListener();
    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToIntro);
            }
        });
    }

    private void registerBtnListener(){
        btn_j_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Will need to add error checking to this
                //If username or email is already in use the user can't register with that username/email
                Log.d("Error Checking", "needs to be added before this can work");
                //startActivity(intent_j_backToIntro);
            }
        });
    }
}