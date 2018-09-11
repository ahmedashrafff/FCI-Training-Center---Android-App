package com.example.shade.fcitrainingcenter.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("type")
    String  type;
    @SerializedName("userName")
    String username;
    @SerializedName("userPassword")
    String password;
    @SerializedName("email")
    String  email;
    @SerializedName("university")
    String university;
    @SerializedName("college")
    String college;
    @SerializedName("qualifications")
    String qualifications;
    @SerializedName("address")
    String  address;
    @SerializedName("phone")
    String phone;
    @SerializedName("ssn")
    String ssn;



    public User(String type, String username, String password, String email, String university, String college, String qualifications, String address, String phone, String ssn) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.email = email;
        this.university = university;
        this.college = college;
        this.qualifications = qualifications;
        this.address = address;
        this.phone = phone;
        this.ssn = ssn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

}
