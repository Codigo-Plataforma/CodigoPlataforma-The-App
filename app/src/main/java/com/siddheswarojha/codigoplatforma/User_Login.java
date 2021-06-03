package com.siddheswarojha.codigoplatforma;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;


public class User_Login extends AppCompatActivity {
    FirebaseAuth fAuth;
    Button signIn;
    TextInputEditText etMail,Password;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        fAuth = FirebaseAuth.getInstance();
        etMail =  findViewById(R.id.etLoginMail);
        Password =  findViewById(R.id.etLoginPassword);
        signIn = findViewById(R.id.myLoginBtn);

         progressBar = findViewById(R.id.loginProgressBar);
        Circle circle = new Circle();
        progressBar.setIndeterminateDrawable(circle);





        signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setVisibility(View.VISIBLE);

                    String email = etMail.getText().toString();
                    String password = Password.getText().toString();
                    if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password))
                    {
                        Toast.makeText(User_Login.this, "Fields Can't be null", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    else {
                        logIn(email, password);
                    }

                }
            });


        }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You cannot go back at this moment", Toast.LENGTH_SHORT).show();
    }

    private void logIn(String email, String password) {
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(User_Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(User_Login.this, "Successful", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(User_Login.this, Drawer_Layout.class);
                        startActivity(i);
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                    else
                    {
                        Toast.makeText(User_Login.this, "Something Unusual Occurred", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);;
                    }
                }
            });
        }
    }