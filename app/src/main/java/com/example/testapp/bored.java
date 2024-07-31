package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class bored extends AppCompatActivity implements View.OnClickListener{
    private Button[] buttons; boolean [] selects; boolean [] good;

    private Button checkAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_bored);
        buttons = new Button[9];
        selects = new boolean[9];
    }

    @Override
    public void onClick(View v) {
        //In
    }
}