package com.example.thagadur.androidsession12assignment4;

/**
 * Created by Thagadur on 8/28/2017.
 */
//ListModel Class used to generate getter and setter for the variables fullName,phoneNumber,DOB

public class ListModel {

    private String fullName;
    private String phoneNumber;
    private String DOB;

    //............Getters for variables...............
    public String getFullName() {

        return fullName;

    }

    public String getPhoneNumber() {

        return phoneNumber;

    }

    public String getDOB() {

        return DOB;

    }

    //............Setters for variables...............
    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public void setDOB(String DOB) {

        this.DOB = DOB;
    }
}
