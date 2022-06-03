package com.example.movie_2;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_2.databinding.FragmentCoffeeBinding;


public class CoffeeFragment extends Fragment {

    private FragmentCoffeeBinding binding;

    // 통신 요청
    private Mo


    public CoffeeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_coffee, container, false);
    }
}