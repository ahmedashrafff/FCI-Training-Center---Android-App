package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private TextInputLayout emailTab;
    private TextInputLayout passwordTab;

    public void login(View view)
    {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        emailTab= (TextInputLayout) findViewById(R.id.emailTab);
        passwordTab = (TextInputLayout) findViewById(R.id.passwordTab);

        final String email = emailTab.getEditText().getText().toString();
        final String password = passwordTab.getEditText().getText().toString();



        if(!email.equals("") && !password.equals(""))
        {

            Call<String> call = apiService.login(email,password);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    Toast.makeText(getBaseContext(),"Successfully Loged In",Toast.LENGTH_LONG).show();


                    if(response.body().equals("true:instructor"))
                    {

                        Intent intent = new Intent(getBaseContext(),MainActivity.class);
                        intent.putExtra("name",email);
                        intent.putExtra("password",password);
                        intent.putExtra("type","instructor");
                        startActivity(intent);

                    }

                    else if(response.body().equals("true:student"))
                    {
                        Intent intent = new Intent(getBaseContext(),MainActivity.class);
                        intent.putExtra("name",email);
                        intent.putExtra("password",password);
                        intent.putExtra("type","student");
                        startActivity(intent);
                    }

                    else
                        Toast.makeText(getBaseContext(),"Please Check your credentials and try again",Toast.LENGTH_LONG).show();



                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Error on fail","Stacktrace");

                    t.printStackTrace();


                }
            });

        }
        else
            Toast.makeText(this,"Please Fill Empty Fields & Try again",Toast.LENGTH_LONG).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
