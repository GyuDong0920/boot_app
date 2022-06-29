package com.example.instagram.Repository;

import com.example.instagram.models.User;
import com.example.instagram.utils.Define;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SignUpService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("userList")
    Call<List<User>> userList();

   @POST("insta/sign")
    Call<User> sign(
            @Body User user
    );
    @POST("insta/login")
    Call<User> login(
            @Body User user
    );
}
