package com.example.sample.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.sample.Model.UserData;

import java.util.List;

@Dao
public interface ApplicationDao {

    @Insert
    public void insertUser(UserData userData);

    @Query("select * from userData")
    public List<UserData> getUser();

    @Query("select count(*) from userData")
    public int getUserCount();

    @Query("select max(id) from userData")
    public int getMaxId();
}
