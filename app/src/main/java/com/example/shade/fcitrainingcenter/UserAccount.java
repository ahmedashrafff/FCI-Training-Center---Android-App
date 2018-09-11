package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shade.fcitrainingcenter.model.UserResponse;
import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");
        final TextView userName = (TextView) findViewById(R.id.userName);
        final TextView userPhone = (TextView) findViewById(R.id.userPhone);
        final TextView userAddress = (TextView) findViewById(R.id.userAddress);
        final TextView userCollege = (TextView) findViewById(R.id.userCollege);
        final TextView userEmail = (TextView) findViewById(R.id.userEmail);
        final TextView useruniversity = (TextView) findViewById(R.id.useruniversity);
        final TextView userType = (TextView) findViewById(R.id.userType);


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<UserResponse> call = apiService.getUser(name,password);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                userAddress.setText("Address: "+response.body().getAddress());
                userCollege.setText("College: "+response.body().getCollege());
                Log.d("Result is",response.body().getUsername());
                userName.setText("Name: "+response.body().getUsername());
                userEmail.setText("Email: "+response.body().getEmail());
                userPhone.setText("Phone: "+response.body().getPhone());
                userType.setText(response.body().getType());
                useruniversity.setText("University: "+response.body().getUniversity());

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
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
