package com.example.sample.DataBase;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import com.example.sample.Model.UserData;

public class UserRepository {

    Context context;
    public UserRepository(Context context) {
        this.context = context;
    }

    public void insert(UserData user) {
        new InsertAsyncTask(context).execute(user);
    }

    private static class InsertAsyncTask extends AsyncTask<UserData, Void, Void> {
        private Context context;
        int id = 0;
        InsertAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(final UserData... params) {
            DataBase.getInstance(context).applicationDao().insertUser(params[0]);
             id = DataBase.getInstance(context).applicationDao().getMaxId();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            Toast.makeText(context,"New user is created with id :- "+id,Toast.LENGTH_LONG).show();
        }
    }
}
