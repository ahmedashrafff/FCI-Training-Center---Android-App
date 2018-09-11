package com.example.shade.fcitrainingcenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.shade.fcitrainingcenter.model.Course;
import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


public class MyCourses extends AppCompatActivity {
    public ArrayList<Course> courses = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<List<Course>> call = apiService.getAllCourses();
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Course>> call, Response<List<Course>> response)
            {
                recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),response.body()));

            }

            @Override
            public void onFailure(retrofit2.Call<List<Course>> call, Throwable t) {
                t.printStackTrace();
            }
        });


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}
