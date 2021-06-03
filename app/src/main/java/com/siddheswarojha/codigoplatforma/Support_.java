package com.siddheswarojha.codigoplatforma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Support_ extends AppCompatActivity {
    EditText etSupportQuery, etEmailSupport, Topic;
    Button btnSendSupportQuery;
    FirebaseFirestore fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_);
        etSupportQuery = findViewById(R.id.etSupportQuery);
        etEmailSupport = findViewById(R.id.etContactDetail);
        Topic = findViewById(R.id.topic);
        btnSendSupportQuery = findViewById(R.id.sendSupportQuery);


        btnSendSupportQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = etSupportQuery.getText().toString();
                String topic = Topic.getText().toString();
                String email  = etEmailSupport.getText().toString();


                if(TextUtils.isEmpty(query)||TextUtils.isEmpty(topic)||TextUtils.isEmpty(email))
                {
                    Toast.makeText(Support_.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
                }
                else{
                    SendQuery(query,topic,email);

                }
            }
        });






    }

    private void SendQuery(String query, String topic, String email) {
        fb = FirebaseFirestore.getInstance();
        Map<String, Object> listQuery = new HashMap<>();
        listQuery.put("Query",query);
        listQuery.put("topic",topic);
        listQuery.put("Email",email);


        fb.collection("Queries").add(listQuery);
        Intent i = new Intent(Support_.this, CommonQuery.class);
        startActivity(i);

        Toast.makeText(Support_.this, "Query sent, We will get back to you soon. Till then, you can see other common queries of your friends", Toast.LENGTH_SHORT).show();


    }

}
