package com.example.myapplication;



import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/image/random")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiListDog dogRestApi = retrofit.create(ApiListDog.class);


        Call<RestDogResponse> call = dogRestApi.getListDog();
        call.enqueue(new Callback<RestDogResponse>() {
            @Override
            public void onResponse(Call<RestDogResponse> call, Response<RestDogResponse> response) {
                RestDogResponse restDogResponse = response.body();
                List<Dog> listDog = restDogResponse.getResults();
                showList(listDog);
            }

            @Override
            public void onFailure(Call<RestDogResponse> call, Throwable t) {
                Log.d("Erreur", "API KO");


       /* recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);*/
    }

            private void showList(List<Dog> list) {
                // use this setting to
                // improve performance if you know that changes
                // in content do not change the layout size
                // of the RecyclerView
                recyclerView.setHasFixedSize(true);
                // use a linear layout manager
                layoutManager = new LinearLayoutManager(getBaseContext());
                recyclerView.setLayoutManager(layoutManager);
                // define an adapter
                mAdapter = new MyAdapter(list);
                recyclerView.setAdapter(mAdapter);
            }
        });
    }
}