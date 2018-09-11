package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class Home extends Fragment {

    TextView welcometext ;
    TextView datenow;

    public  Home()
    {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.homelayout,container,false);


        welcometext=(TextView)   view.findViewById(R.id.welcome);
        datenow=(TextView) view.findViewById(R.id.date);
        Date currentTime = Calendar.getInstance().getTime();

        Intent intent = getActivity().getIntent();
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        String type=intent.getStringExtra("type");


        welcometext.setText("Welcome "+name);
        datenow.setText(currentTime.toString());





        return view;


    }
}
