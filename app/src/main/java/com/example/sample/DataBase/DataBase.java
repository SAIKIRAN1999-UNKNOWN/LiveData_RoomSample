package com.example.sample.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sample.Model.UserData;


@Database(entities = {UserData.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    private static DataBase instance;

    public abstract   ApplicationDao applicationDao();

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                            DataBase.class, "Sample")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
