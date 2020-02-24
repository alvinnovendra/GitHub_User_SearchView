package com.example.cermati_test;

import com.example.cermati_test.Model.User;

import java.util.List;

public interface MainActivityInterface {

    interface View{
        void setAdapter(List<User>userPreferences);
        void errorToast(String message);
        void setLoadingVisible();
        void setLoadingGone();
    }

    interface presenter{
        void attachView(View view);
        void getUser(String user);


    }
}
