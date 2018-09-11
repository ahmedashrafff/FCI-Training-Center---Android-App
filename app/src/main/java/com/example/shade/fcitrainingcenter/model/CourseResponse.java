package com.example.shade.fcitrainingcenter.model;

import com.google.gson.annotations.SerializedName;

public class CourseResponse {

    @SerializedName("name")
    private String name;

    public CourseResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
