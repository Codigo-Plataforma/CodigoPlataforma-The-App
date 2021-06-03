package com.siddheswarojha.codigoplatforma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CommonQuery extends AppCompatActivity {
    RecyclerView rv;
    FirebaseFirestore fb;

    FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_query);
        rv = findViewById(R.id.RV_QUERY);
        fb = FirebaseFirestore.getInstance();
        Query query = fb.collection("Queries");
        FirestoreRecyclerOptions<QueryModel> options = new FirestoreRecyclerOptions.Builder<QueryModel>()
                .setQuery(query, QueryModel.class)
                .build();


        adapter = new FirestoreRecyclerAdapter<QueryModel, CommonQuery.ProductViewHolder>(options) {
            @NonNull
            @Override
            public CommonQuery.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.design_query, parent, false);
                return new CommonQuery.ProductViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final CommonQuery.ProductViewHolder holder, int position, @NonNull QueryModel model) {

               holder.topic.setText(model.getTopic());
                holder.txtQuery.setText(model.getQuery());
                holder.name.setText(model.getEmail());


            }
        };
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


    }

    private class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuery, topic,name;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuery = itemView.findViewById(R.id.ActualQuery);
            topic = itemView.findViewById(R.id.topicOfQuery);
            name = itemView.findViewById(R.id.nameOfQueryPerson);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (adapter != null) {
            adapter.stopListening();
        }
    }
}
