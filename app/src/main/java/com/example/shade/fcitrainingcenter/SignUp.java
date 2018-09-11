package com.example.shade.fcitrainingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.shade.fcitrainingcenter.rest.ApiClient;
import com.example.shade.fcitrainingcenter.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    private TextInputLayout userNameTab;
    private TextInputLayout emailTab;
    private TextInputLayout passwordTab;
    private CheckBox checkStudent;
    private  CheckBox chekInstructor;

    public void signup(View view)
    {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        userNameTab = (TextInputLayout) findViewById(R.id.userName);
        emailTab= (TextInputLayout) findViewById(R.id.email);
        passwordTab = (TextInputLayout) findViewById(R.id.password);
        checkStudent=(CheckBox) findViewById(R.id.checkStudent);
        chekInstructor=(CheckBox) findViewById(R.id.checkInstructor);

        String username = userNameTab.getEditText().getText().toString();
        String email = emailTab.getEditText().getText().toString();
        String password = passwordTab.getEditText().getText().toString();

        if ( checkStudent.isChecked() && chekInstructor.isChecked())
        Toast.makeText(this,"Please Select only one type",Toast.LENGTH_LONG).show();


        else if(checkStudent.isChecked() && !username.equals("") && !email.equals("") && !password.equals(""))
        {

            Call<String> call = apiService.signUp(username,password,email," "," "," "," "," ","","Student");
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String result = response.body();
                    Log.d("Resultis",result);
                    if(result.equals("true"))
                    {
                        Toast.makeText(getBaseContext(),"Successfully Signed Up , Please Log In",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getBaseContext(),StartScreen.class));
                    }
                    else
                    {
                        Log.d("Error",result.toString());
                        call.cancel();
                        Toast.makeText(getBaseContext(),"Error please try again",Toast.LENGTH_LONG).show();

                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Error on fail","Stacktrace");

                    t.printStackTrace();


                }
            });

        }
        else if(chekInstructor.isChecked() && !username.equals("") && !email.equals("") && !password.equals(""))
        {
            Call<String> call = apiService.signUp(username,password,email," "," "," "," "," ","","Instructor");
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String result = response.body();
                    if(result.equals("true"))
                    {
                        Toast.makeText(getBaseContext(),"Successfully Signed Up",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getBaseContext(),StartScreen.class));
                    }
                    else
                    {
                        Log.d("Error",result.toString());
                        call.cancel();
                        Toast.makeText(getBaseContext(),"Error please try again",Toast.LENGTH_LONG).show();

                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();

                }
            });

        }


        else
            Toast.makeText(this,"Please Fill Empty Fields & Check your type",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
