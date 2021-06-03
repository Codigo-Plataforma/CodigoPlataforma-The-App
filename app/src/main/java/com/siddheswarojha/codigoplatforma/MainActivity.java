package com.siddheswarojha.codigoplatforma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


Button roll;
RadioButton radioTerm;
boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        roll = findViewById(R.id.ButtonRollers);
        radioTerm = findViewById(R.id.radioBtnTerm);
        radioTerm.setOnClickListener(v -> {
            isChecked = true;
        });




        roll.setOnClickListener(v -> {
            if(isChecked)
            {
                Intent i = new Intent(MainActivity.this, User_Login.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Please Agree our T&C to continue", Toast.LENGTH_SHORT).show();
            }

        });








    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if(user!=null)
        {
            Intent i1 = new Intent(MainActivity.this, Drawer_Layout.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i1);
        }
    }
}