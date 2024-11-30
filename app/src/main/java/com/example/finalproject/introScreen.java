package com.example.finalproject;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

public class introScreen extends AppCompatActivity {

    Button btn_j_login;
    Button btn_j_register;

    Intent intent_j_register;
    Intent intent_j_login;

    DatabaseHelper dbHelper;

    private String CHANNEL_ID = "User Registered!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.intro_screen_main);

        btn_j_login     = findViewById(R.id.btn_v_main_login);
        btn_j_login.setBackgroundColor(Color.rgb(250, 103, 0));
        btn_j_register  = findViewById(R.id.btn_v_main_register);
        btn_j_register.setBackgroundColor(Color.rgb(250, 103, 0));

        intent_j_register = new Intent(introScreen.this, registerUser.class);
        intent_j_login    = new Intent(introScreen.this, loginScreen.class);

        //notificationPermission();
        //makeNotification();

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

    private void makeNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(introScreen.this, CHANNEL_ID);
        builder.setContentTitle("Hello and");
        builder.setContentText("Welcome to Black Ops 6 Loadout Maker!");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        //makes the notification automatically dismiss when touched
        builder.setAutoCancel(true);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "myNotification", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        manager.notify(0, builder.build());
    }

    private void notificationPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(introScreen.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 0);
            }
        }
    }
}