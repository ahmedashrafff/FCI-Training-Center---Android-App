package com.example.shade.fcitrainingcenter.rest;

import com.example.shade.fcitrainingcenter.model.Course;
import com.example.shade.fcitrainingcenter.model.CourseResponse;
import com.example.shade.fcitrainingcenter.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface  ApiInterface {

    @GET("allcourses.php/")
     Call<List<Course>> getAllCourses();

    @GET("closedcourses.php/")
    Call<List<CourseResponse>> getClosedCourses();

    @FormUrlEncoded
    @POST("getcourse.php/")
    Call<Course> getCourse(@Field("name") String name);

    @FormUrlEncoded
    @POST("getUser.php/")
    Call<UserResponse> getUser(@Field("username") String name , @Field("password") String password);


    @FormUrlEncoded
    @POST("login.php/")
    Call<String> login(@Field("username") String username , @Field("password") String password);

    @FormUrlEncoded
    @POST("signup.php/")
     Call<String> signUp(@Field("username") String name , @Field("password") String password,
                                @Field("email") String email,@Field("university") String university,
                                @Field("college") String college ,@Field("qualifications") String qualifications,
                                @Field("address") String address , @Field("phone") String phone,
                                @Field("ssn") String ssn, @Field("type") String type);




}
