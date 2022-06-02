package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private FragmentOne fragmentOne;
    private FragmentTwo fragmenttwo;
    private ImageView btnHome;
    private ImageView btnImage;
    private ImageView btnGps;
    private ImageView btnChat;
    private ImageView btnInfo;
    private LinearLayout containerone;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btnHome);
        btnImage = findViewById(R.id.btnImage);
        btnGps = findViewById(R.id.btnGPS);
        btnChat = findViewById(R.id.btnChat);
        btnInfo = findViewById(R.id.btnInfo);


        btnHome.setOnClickListener(view -> {
            fragmentOne = new FragmentOne();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction  transaction = manager.beginTransaction();
            transaction.replace(R.id.container1,fragmentOne);
            transaction.commit();

        });
//        btnImage.setOnClickListener(view -> {
//            fragmenttwo = new FragmentTwo();
//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction  transaction = manager.beginTransaction();
//            transaction.replace(R.id.container1,fragmentOne);
//            transaction.commit();
//
//        });
//        btnHome.setOnClickListener(view -> {
//            fragmentOne = new FragmentOne();
//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction  transaction = manager.beginTransaction();
//            transaction.replace(R.id.container1,fragmentOne);
//            transaction.commit();
//
//        });
//        btnHome.setOnClickListener(view -> {
//            fragmentOne = new FragmentOne();
//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction  transaction = manager.beginTransaction();
//            transaction.replace(R.id.container1,fragmentOne);
//            transaction.commit();
//
//        });
//        btnHome.setOnClickListener(view -> {
//            fragmentOne = new FragmentOne();
//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction  transaction = manager.beginTransaction();
//            transaction.replace(R.id.container1,fragmenttwo);
//            transaction.commit();
//
//        });



    }
}