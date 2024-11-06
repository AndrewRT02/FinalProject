package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_j_login;
    Button btn_j_register;

    Intent intent_j_register;

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

        intent_j_register = new Intent(MainActivity.this, RegisterUser.class);

        registerBtnListener();
    }

    private void registerBtnListener(){
        btn_j_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_register);
            }
        });
    }
}