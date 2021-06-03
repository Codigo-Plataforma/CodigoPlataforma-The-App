package com.siddheswarojha.codigoplatforma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;


public class Drawer_Layout extends AppCompatActivity {
    NavigationView navigation;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionbartoggle;



    CardView imgus, imgQuiz, imgCode, imgNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer__layout);
        navigation = findViewById(R.id.navigaionView);
        setUptoolBar(); //function for setting the toolbar and navigation drawer
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ED4322"));


        imgus = findViewById(R.id.us);
        imgCode = findViewById(R.id.code);
        imgNews = findViewById(R.id.news);
        imgQuiz = findViewById(R.id.quiz);


        imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Drawer_Layout.this, News.class);

                startActivity(i);

            }
        });


        imgCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Drawer_Layout.this, Code.class);
                startActivity(i);

            }
        });


        imgQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Drawer_Layout.this, Quiz.class);
                startActivity(i);

            }
        });

        imgus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intenting from dashboard to about us activity


                Intent i = new Intent(Drawer_Layout.this, AboutUs.class);
                startActivity(i);
            }
        });
        /****
         * *Logic for menu items when they are clicked.
         * every intent carries a string and those string are received in the main activity.
         *****/
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.Blog:
                        Intent i1 = new Intent(Drawer_Layout.this, Container.class);
                        i1.putExtra("urlValue","https://codigo-plataforma.github.io/Website/index.html");
                        startActivity(i1);
                        break;
                    case R.id.Resources:
                        Intent i = new Intent(Drawer_Layout.this,CommonQuery.class);
                        startActivity(i);
                        break;

                    case R.id.Compete:
                        Toast.makeText(Drawer_Layout.this, "No Competitions Available. We will notify you soon", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.AboutUs:
                        Intent i2 = new Intent(Drawer_Layout.this, AboutUs.class);
                        startActivity(i2);

                        break;
                    case R.id.developer:

                                Uri uri= Uri.parse("https://github.com/siddheswarojha");
                                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                                intent.setPackage("com.codigo.sit");
                                try{
                                    startActivity(intent);
                                }catch(ActivityNotFoundException e){
                                    startActivity(new Intent(Intent.ACTION_VIEW,uri.parse("https://github.com/siddheswarojha")));
                                }
                        break;
                    case R.id.Share:

                        Intent ishare = new Intent();
                        ishare.setAction(Intent.ACTION_SEND);
                        ishare.setType("text/plain");
                        startActivity(ishare);
                        break;
                    case R.id.Support:
                      Intent iSupport = new Intent(Drawer_Layout.this, Support_.class);
                      startActivity(iSupport);
                        break;
                    case R.id.nav_Logout:
                        Toast.makeText(Drawer_Layout.this, "Logged Out", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Drawer_Layout.this, User_Login.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
                return true;
            }
        });




    }

    private void setUptoolBar() {
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        actionbartoggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionbartoggle);
        actionbartoggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        actionbartoggle.syncState();

    }
}