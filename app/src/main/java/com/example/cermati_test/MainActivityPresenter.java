package com.example.cermati_test;

import android.content.Context;

import com.example.cermati_test.Model.Items;
import com.example.cermati_test.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityInterface.presenter {
    MainActivityInterface.View view;
    Context context;

    public MainActivityPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(MainActivityInterface.View view) {
        this.view = view;
    }


    @Override
    public void getUser(String user) {
        view.setLoadingVisible();
        ApiInterface apiInterfaces = ConnectionManager.getRetrofit().create(ApiInterface.class);
        Call<Items> call = apiInterfaces.getUser(user);
        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                view.setLoadingGone();
                if(response.isSuccessful()){
                    Items itemsUser = response.body();
                    List<User> userList = itemsUser.getItem();
                    view.setAdapter(userList);

                }else if(response.body()==null){
                    view.errorToast("The api is limited 10 hit per-minute");
                }


            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                view.setLoadingGone();
                view.errorToast("Error Connection");
            }
        });
    }



}
