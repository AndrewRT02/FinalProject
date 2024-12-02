package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class userProfile extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    EditText et_j_fname;
    EditText et_j_lname;
    EditText et_j_email;
    EditText et_j_age;

    Button btn_j_back;
    Button btn_j_update;
    Button btn_j_delete;

    Intent intent_j_backToWelcome;
    Intent intent_j_backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);

        et_j_fname = findViewById(R.id.et_v_prof_fname);
        et_j_lname = findViewById(R.id.et_v_prof_lname);
        et_j_email = findViewById(R.id.et_v_prof_email);
        et_j_age   = findViewById(R.id.et_v_prof_age);

        btn_j_back   = findViewById(R.id.btn_v_prof_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_update = findViewById(R.id.btn_v_prof_update);
        btn_j_update.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_delete = findViewById(R.id.btn_v_prof_delete);
        btn_j_delete.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_backToWelcome = new Intent(userProfile.this, welcomeScreen.class);
        intent_j_backToLogin   = new Intent(userProfile.this, loginScreen.class);

        Log.d("DragonFruit", SessionData.getRegisteredUser().getUsername());

        String uname = SessionData.getRegisteredUser().getUsername();

        et_j_fname.setText(SessionData.getRegisteredUser().getFname());
        et_j_lname.setText(SessionData.getRegisteredUser().getLname());
        et_j_email.setText(SessionData.getRegisteredUser().getEmail());

        String age = Integer.toString(SessionData.getRegisteredUser().getAge());

        et_j_age.setText(age);

        backBtnListener();

    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToWelcome);
            }
        });
    }

    private void updateBtnListener(String uname){
        btn_j_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateUser(uname, et_j_fname.getText().toString(), et_j_lname.getText().toString(), et_j_email.getText().toString(), Integer.parseInt(et_j_age.getText().toString()));
                startActivity(intent_j_backToLogin);
            }
        });
    }
}