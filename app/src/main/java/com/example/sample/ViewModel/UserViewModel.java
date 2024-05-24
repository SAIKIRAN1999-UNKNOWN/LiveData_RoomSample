package com.example.sample.ViewModel;


import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;

import com.example.sample.DataBase.UserRepository;
import com.example.sample.Model.UserData;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;

    public UserViewModel(Application application) {
        super(application);
        repository = new UserRepository(application);
    }

    public void insert(UserData user) {
        repository.insert(user);
    }
}
