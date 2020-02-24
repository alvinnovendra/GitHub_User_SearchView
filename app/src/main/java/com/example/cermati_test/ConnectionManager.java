package com.example.cermati_test;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionManager {
    public static String baseUrl = "https://api.github.com/";

    public static Retrofit getRetrofit(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .callTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .build();
        return  new Retrofit.Builder().baseUrl(baseUrl).client(httpClient).
                addConverterFactory(GsonConverterFactory.create()).build();
    }


}