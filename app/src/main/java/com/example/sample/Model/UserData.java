package com.example.sample.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userData")
public class UserData {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String name;
    private int age;
    private String dob;
    private String address;

    public UserData() {
    }

    public UserData(String name, int age, String dob, String address) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
