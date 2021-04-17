package com.example.androidfundamentals021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
TextView countv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Intent intent = getIntent();
       String count = intent.getStringExtra(MainActivity.countn0);
       countv2 = findViewById(R.id.countv2);
       countv2.setText(count);
    }
}