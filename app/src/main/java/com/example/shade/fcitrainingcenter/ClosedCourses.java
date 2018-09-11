package com.example.shade.fcitrainingcenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shade.fcitrainingcenter.model.CourseResponse;
import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ClosedCourses extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<List<CourseResponse>> call = apiService.getClosedCourses();
        call.enqueue(new Callback<List<CourseResponse>>() {
            @Override
            public void onResponse(retrofit2.Call<List<CourseResponse>> call, Response<List<CourseResponse>> response)
            {
                TextView textView = (TextView) findViewById(R.id.textviewClose);
                String course="";
                List<CourseResponse> courses = response.body();
                Log.d("Stringis", response.body().get(0).getName());
                for( int i = 0; i < courses.size(); i++ )
                {
                        course+=courses.get(i).getName()+"\n";
                }

                textView.setText(course);
            }

            @Override
            public void onFailure(retrofit2.Call<List<CourseResponse>> call, Throwable t) {

                t.printStackTrace();
            }
        });




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
