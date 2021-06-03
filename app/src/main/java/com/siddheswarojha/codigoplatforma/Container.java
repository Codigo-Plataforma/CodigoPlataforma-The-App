package com.siddheswarojha.codigoplatforma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

public class Container extends AppCompatActivity {
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        i = getIntent();
       String url = i.getStringExtra("urlValue");


        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.parseColor("#ED4322"));
        String PackageName = "com.android.chrome";
        CustomTabsIntent customTabsIntent = builder.build();



        customTabsIntent.launchUrl(this, Uri.parse(url));


    }
}