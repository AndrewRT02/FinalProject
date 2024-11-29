package com.example.finalproject;

import java.sql.Date;

public class User {
    String username;    //Primary Key
    String fname;
    String lname;
    String email;
    int age;

    public User(){

    }

    public User(String u, String f, String l, String e, int a){
        username = u;
        fname = f;
        lname = l;
        email = e;
        age = a;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
