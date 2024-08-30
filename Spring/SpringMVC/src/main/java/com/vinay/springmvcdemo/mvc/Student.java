package com.vinay.springmvcdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String branch;
    private Map<String, String> branchOptions;
    private String favoriteLanguage;
    private String[] languagesKnown;

    public Student() {
        branchOptions = new LinkedHashMap<>();
        branchOptions.put("CSE", "Computer Science & Engineering");
        branchOptions.put("IT", "Information Technology");
        branchOptions.put("ECE", "Electronics and Communication Engineering");
        branchOptions.put("MECH", "Mechanical Engineering");
        branchOptions.put("AERO", "Aeronautical Engineering");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Map<String, String> getBranchOptions() {
        return branchOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(String[] languagesKnown) {
        this.languagesKnown = languagesKnown;
    }
}