package com.example.shade.fcitrainingcenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shade.fcitrainingcenter.model.Course;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<Course> courses;
    Context context;

    public RecyclerAdapter(Context context,List<Course> itemsData) {
        this.courses=new ArrayList<>();
        this.courses.addAll(itemsData);
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercourse,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Course course=courses.get(position);
        holder.courseName.setText(course.getName());
        holder.coursePic.setImageResource(R.drawable.javacourse);
        holder.coursePrice.setText(course.getPrice()+"$");
        holder.courseLevel.setText("Level: "+course.getLevel());
        holder.courseCertified.setText("Certified:"+course.getCertified());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context,CourseView.class);
                myIntent.putExtra("courseName",course.getName());
                myIntent.putExtra("courseCertified",course.getCertified());
                myIntent.putExtra("courseLevel",course.getLevel());
                myIntent.putExtra("coursePrice",course.getPrice());
                myIntent.putExtra("courseSessi",course.getNumOfSessions());
                myIntent.putExtra("courseStart",course.getStartDate());
                myIntent.putExtra("courseEnd",course.getEndDate());
                Log.d("flintent",course.getName());

                context.startActivity(myIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
