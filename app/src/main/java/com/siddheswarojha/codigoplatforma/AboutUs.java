package com.siddheswarojha.codigoplatforma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class AboutUs extends AppCompatActivity {

    RecyclerView rvAboutUs;
    AboutUsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toast.makeText(this, "please wait", Toast.LENGTH_SHORT).show();
        rvAboutUs = findViewById(R.id.rvAboutUs);
        rvAboutUs.setLayoutManager(new LinearLayoutManager(this));
//
   Query query =    FirebaseDatabase.getInstance().getReference().child("Members");
        FirebaseRecyclerOptions<AboutModel> options =
                new FirebaseRecyclerOptions.Builder<AboutModel>()
                        .setQuery(query, AboutModel.class)
                        .build();
        adapter = new AboutUsAdapter(options);
        rvAboutUs.setAdapter(adapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}