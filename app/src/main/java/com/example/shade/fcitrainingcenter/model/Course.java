package com.example.shade.fcitrainingcenter.model;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("name")
    private String name;
    @SerializedName("level")
    private String level;
    @SerializedName("price")
    private String price;
    @SerializedName("certified")
    private String certified;
    @SerializedName("numOfSessions")
    private String numOfSessions;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;

   public Course(){}

    public Course(String name, String level, String price, String certified, String numOfSessions, String startDate, String endDate) {
        this.name = name;
        this.level = level;
        this.price = price;
        this.certified = certified;
        this.numOfSessions = numOfSessions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getNumOfSessions() {
        return numOfSessions;
    }

    public void setNumOfSessions(String numOfSessions) {
        this.numOfSessions = numOfSessions;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
