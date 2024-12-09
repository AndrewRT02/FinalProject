package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class registerUser extends AppCompatActivity {
    EditText et_j_username;
    EditText et_j_fname;
    EditText et_j_lname;
    EditText et_j_email;
    EditText et_j_age;

    TextView tv_j_unameError;
    TextView tv_j_fnameError;
    TextView tv_j_lnameError;
    TextView tv_j_emailError;
    TextView tv_j_ageError;
    TextView tv_j_ueError;

    Button btn_j_back;
    Button btn_j_register;

    Intent intent_j_backToIntro;

    MediaPlayer registerBtnSound;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_user);

        et_j_username   = findViewById(R.id.et_v_regUser_username);
        et_j_fname      = findViewById(R.id.et_v_regUser_fname);
        et_j_lname      = findViewById(R.id.et_v_regUser_lname);
        et_j_email      = findViewById(R.id.et_v_regUser_email);
        et_j_age        = findViewById(R.id.et_v_regUser_age);

        tv_j_unameError = findViewById(R.id.tv_v_regUser_uError);
        tv_j_fnameError = findViewById(R.id.tv_v_regUser_fnameError);
        tv_j_lnameError = findViewById(R.id.tv_v_regUser_lnameError);
        tv_j_emailError = findViewById(R.id.tv_v_regUser_emailError);
        tv_j_ageError   = findViewById(R.id.tv_v_regUser_ageError);
        tv_j_ueError    = findViewById(R.id.tv_v_reg_ueError);

        btn_j_back      = findViewById(R.id.btn_v_reg_back);
        btn_j_back.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_register  = findViewById(R.id.btn_v_reg_register);
        btn_j_register.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_backToIntro   = new Intent(registerUser.this, introScreen.class);

        registerBtnSound = MediaPlayer.create(registerUser.this, R.raw.letsdothis);

        backBtnListener();
        registerNewUserBtnListener();
    }

    private void backBtnListener(){
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_backToIntro);
            }
        });
    }

    private void registerNewUserBtnListener(){
        btn_j_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Will need to add error checking to this
                //If username or email is already in use the user can't register with that username/email
                Log.d("Error Checking", "needs to be added before this can work");
                //make a push notification
                Boolean bool;
                bool = userErrorField();

                String uname = et_j_username.getText().toString();
                String fname = et_j_fname.getText().toString();
                String lname = et_j_lname.getText().toString();
                String email = et_j_email.getText().toString();
                String age   = et_j_age.getText().toString();

                if (bool){
                    //Log.d("Cranberry", "Got Here");
                    for (int i = 0; i < dbHelper.allUsersList().size(); i++){
                        if (uname.equals(dbHelper.allUsersList().get(i).getUname()) || email.equalsIgnoreCase(dbHelper.allUsersList().get(i).getEmail())){
                            //Log.d("Cranberry", "Got Here");
                            tv_j_ueError.setVisibility(View.VISIBLE);
                            return;
                        }
                        else{
                            //Log.d("Cranberry", "Here I got");
                            tv_j_ueError.setVisibility(View.INVISIBLE);
                            registerBtnSound.start();
                            dbHelper.createUser(new User(uname, fname, lname, email, Integer.parseInt(age)));
                            startActivity(intent_j_backToIntro);
                        }
                    }

                }
            }
        });
    }

    private boolean userErrorField(){

        Boolean bool = true;

        //Username Error Checking
        if(et_j_username.getText().toString().isEmpty()){
            tv_j_unameError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (et_j_username != null) {
            tv_j_unameError.setVisibility(View.INVISIBLE);
        }
        //-----------------Need to add the error checking to make sure that the username isn't already being used
                            //This error checking is in the register user function

        //FName Error Checking
        if (et_j_fname.getText().toString().isEmpty()){
            tv_j_fnameError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (et_j_fname != null) {
            tv_j_fnameError.setVisibility(View.INVISIBLE);
        }

        //LName Error Checking
        if (et_j_lname.getText().toString().isEmpty()){
            tv_j_lnameError.setVisibility(View.VISIBLE);
            bool = false;
        } else if (et_j_lname != null) {
            tv_j_lnameError.setVisibility(View.INVISIBLE);
        }

        //Email Error Checking
        if (et_j_email.getText().toString().isEmpty()){
            tv_j_emailError.setVisibility(View.VISIBLE);
        } else if (et_j_email != null) {
            tv_j_emailError.setVisibility(View.INVISIBLE);
        }
        //-----------------Need to add the error checking to make sure that the email isn't already being used

        //Age Error Checking
        if (et_j_age.getText().toString().isEmpty()){
            tv_j_ageError.setVisibility(View.VISIBLE);
        } else if (et_j_age != null) {
            tv_j_ageError.setVisibility(View.INVISIBLE);
        }

        return bool;
    }

}