package com.example.finalproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class usersLaodoutCell extends AppCompatActivity {

    TextView tv_j_creator;
    TextView tv_j_lName;
    TextView tv_j_primary;
    TextView tv_j_secondary;
    TextView tv_j_rating;
    TextView tv_j_fU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_users_laodout_cell);

    }
}