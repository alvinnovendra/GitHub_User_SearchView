package com.example.cermati_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cermati_test.Model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityInterface.View{
    @BindView(R.id.searchBar)
    SearchView searchView;
    @BindView(R.id.recyclerUser)
    RecyclerView recyclerViewUser;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    MainActivityPresenter mainActivityPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityPresenter = new MainActivityPresenter(getApplicationContext());
        mainActivityPresenter.attachView(this);
        setSearchView();
        setRecyclerViewUser();
    }


    @Override
    public void setAdapter(List<User> userPreferences) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(userPreferences);
        recyclerViewUser.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void errorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoadingVisible() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setLoadingGone() {
        progressBar.setVisibility(View.GONE);
    }

    private void setRecyclerViewUser(){
        recyclerViewUser.setHasFixedSize(true);
        final LinearLayoutManager layoutManagerContract = new LinearLayoutManager(getApplicationContext());
        layoutManagerContract.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewUser.setLayoutManager(layoutManagerContract);
    }

    private void setSearchView(){
        searchView.setQueryHint("Search Github Users");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mainActivityPresenter.getUser(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }


}
