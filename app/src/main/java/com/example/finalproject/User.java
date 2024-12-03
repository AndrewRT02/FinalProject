package com.example.finalproject;

public class User {
    String uname;    //Primary Key
    String fname;
    String lname;
    String email;
    int age;

    public User(){

    }

    public User(String u, String f, String l, String e, int a){
        uname = u;
        fname = f;
        lname = l;
        email = e;
        age = a;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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
