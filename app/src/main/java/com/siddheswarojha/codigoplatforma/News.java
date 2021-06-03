package com.siddheswarojha.codigoplatforma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class News extends AppCompatActivity {
    FirebaseFirestore fb;
    RecyclerView Recycler;
    FirestoreRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

         Recycler = findViewById(R.id.Recycler);
        Recycler.setLayoutManager(new LinearLayoutManager(this));

        fb = FirebaseFirestore.getInstance();
        Query query = fb.collection("NEWS");
        FirestoreRecyclerOptions<NewsModel> options = new FirestoreRecyclerOptions.Builder<NewsModel>()
                .setQuery(query, NewsModel.class)
                .build();


        adapter = new FirestoreRecyclerAdapter<NewsModel, News.ProductViewHolder>(options) {
            @NonNull
            @Override
            public News.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.list_item_sample, parent, false);
                return new News.ProductViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final News.ProductViewHolder holder, int position, @NonNull NewsModel model) {

                holder.news.setText(model.getNews());
               Glide.with(holder.img.getContext()).load(model.getPic()).into(holder.img);
                holder.date.setText(model.getDate());


            }
        };
        Recycler.setHasFixedSize(true);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        Recycler.setAdapter(adapter);


    }

    private class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView news, date;
        ImageView img;
        CardView card;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            news = itemView.findViewById(R.id.txtNews);
            img = itemView.findViewById(R.id.imgSp);
            date = itemView.findViewById(R.id.date);

            card = itemView.findViewById(R.id.cardNews);
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
