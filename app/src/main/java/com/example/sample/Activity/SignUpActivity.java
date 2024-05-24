package com.example.sample.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sample.DataBase.DataBase;
import com.example.sample.Model.UserData;
import com.example.sample.R;
import com.example.sample.ViewModel.UserViewModel;

import java.util.Calendar;


public class SignUpActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        context = SignUpActivity.this;
        EditText nameEt = findViewById(R.id.et_name);
        EditText ageEt = findViewById(R.id.et_age);
        EditText dateEt = findViewById(R.id.et_dob);
        EditText addressEt = findViewById(R.id.et_address);
        Button saveBt = findViewById(R.id.bt_save);
        ImageView calenderIv = findViewById(R.id.iv_calender);
        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString().trim();
                String age = ageEt.getText().toString().trim();
                String date = dateEt.getText().toString().trim();
                String address = addressEt.getText().toString().trim();
                if(name.length() == 0){
                    Toast.makeText(context,"Please Enter valid Name",Toast.LENGTH_LONG).show();
                }else if(age.length() == 0 || Integer.parseInt(age) == 0){
                    Toast.makeText(context,"Please Enter valid Age",Toast.LENGTH_LONG).show();
                }else if(date.length() == 0){
                    Toast.makeText(context,"Please Enter valid DOB",Toast.LENGTH_LONG).show();
                }else if(address.length() == 0){
                    Toast.makeText(context,"Please Enter valid Address",Toast.LENGTH_LONG).show();
                }else {
                    viewModel.insert(new UserData(name,Integer.parseInt(age),date,address));
                }
            }
        });
        calenderIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Month is 0-based, so add 1 to it
                                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                                dateEt.setText(selectedDate);
                            }
                        },
                        year, month, day
                );
                datePickerDialog.show();

            }
        });
    }
}