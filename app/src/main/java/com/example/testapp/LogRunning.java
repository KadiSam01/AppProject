package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LogRunning extends AppCompatActivity {
    private EditText title, distance, time, pace;
    private Button date, submit;
    private CheckBox share;

    private Run current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_log_running);

        current = new Run();

      ///  title = findViewById(R.id.)
    }
}