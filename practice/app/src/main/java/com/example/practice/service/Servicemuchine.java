package com.example.practice.service;

import com.example.practice.dto.Music;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Servicemuchine {

    @GET("/posts")
    Call<Music> posts(
            @Query("name") Stirng name,
            @Query("")


    );


}
