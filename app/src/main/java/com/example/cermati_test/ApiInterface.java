package com.example.cermati_test;

import com.example.cermati_test.Model.Items;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/search/users")
    Call<Items> getUser(@Query("q") String user);
}
