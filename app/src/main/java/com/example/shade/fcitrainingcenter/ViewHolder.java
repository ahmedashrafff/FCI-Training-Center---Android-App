package com.example.shade.fcitrainingcenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView coursePic;
    TextView courseName;
    TextView courseCertified;
    TextView courseLevel;
    TextView coursePrice;
    LinearLayout linearLayout;


    public ViewHolder(View itemView) {
        super(itemView);
        this.coursePic = (ImageView) itemView.findViewById(R.id.coursePic);
        this.courseName = (TextView)itemView.findViewById(R.id.courseName);
        this.courseCertified = (TextView)itemView.findViewById(R.id.certified);
        this.courseLevel = (TextView)itemView.findViewById(R.id.level);
        this.coursePrice = (TextView)itemView.findViewById(R.id.coursePrice);
        this.linearLayout=(LinearLayout) itemView.findViewById(R.id.linearlayout);
    }


}
