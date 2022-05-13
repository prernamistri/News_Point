package com.rajaystudios.application.newspoint;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class science extends Fragment {
    @Nullable
    String api = "852068c180154060820c5bb0aa46dc8e";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String Country="in";
    private RecyclerView recyclerViewofsports;
    private  String category = "science";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View v =  inflater.inflate(R.layout.science, null);
        recyclerViewofsports = v.findViewById(R.id.recyclerviewofscience);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewofsports.setAdapter(adapter);
        findnews();
        return v;

    }

    private void findnews() {
        ApiUtilities.getApiinterface().getCategoryNews(Country, 100, category,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });


    }
}

