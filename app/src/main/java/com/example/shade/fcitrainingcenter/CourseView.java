package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CourseView extends AppCompatActivity {


    public void enroll(View view)
    {
        Toast.makeText(getBaseContext(),"Enrolled Successfully",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent myIntent = getIntent();
        TextView name=(TextView) findViewById(R.id.coursename);
        TextView price=(TextView) findViewById(R.id.courseprice);
        TextView certi=(TextView) findViewById(R.id.coursecertified);
        TextView level=(TextView) findViewById(R.id.courselevel);
        TextView start=(TextView) findViewById(R.id.coursestart);
        TextView end=(TextView) findViewById(R.id.courseend);
        TextView sessi=(TextView) findViewById(R.id.numofsessions);


        name.setText(myIntent.getStringExtra("courseName"));
        price.setText("Price: "+myIntent.getStringExtra("coursePrice"));
        certi.setText("Certified: "+myIntent.getStringExtra("courseCertified"));
        level.setText("Level: "+myIntent.getStringExtra("courseLevel"));
        start.setText("Start: "+myIntent.getStringExtra("courseStart"));
        end.setText("End: "+myIntent.getStringExtra("courseEnd"));
        sessi.setText("Sessions: "+myIntent.getStringExtra("courseSessi"));


    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
