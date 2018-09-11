package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shade.fcitrainingcenter.model.Course;
import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class AllCourses extends Fragment {

     List<Course> courses=new ArrayList<>();

    public AllCourses() {

    }


    public void goaway(View view)
    {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.allcourses,container,false);
        final RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());


        Button button = (Button) view.findViewById(R.id.buttonClosed);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getActivity(),ClosedCourses.class));

            }
        });

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<List<Course>> call = apiService.getAllCourses();
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Course>> call, Response<List<Course>> response)
            {
                recyclerView.setAdapter(new RecyclerAdapter(getActivity(),response.body()));

            }

            @Override
            public void onFailure(retrofit2.Call<List<Course>> call, Throwable t) {
                t.printStackTrace();
            }
        });



        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
