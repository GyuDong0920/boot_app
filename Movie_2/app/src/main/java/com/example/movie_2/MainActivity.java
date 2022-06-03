package com.example.movie_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Movie;
import android.os.Bundle;

import com.example.movie_2.databinding.ActivityMainBinding;
import com.example.movie_2.repository.FragmentType;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replaceFragment(FragmentType.MOVIE);
        addBottomNavListener();


    }
    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(type == FragmentType.MOVIE) {
            fragment = M
        }

    }

    private void addBottomNavListener() {
    }


}