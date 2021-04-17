package com.example.androidfundamentals011;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "hello world in debug");
        Log.i("MainActivity", "hello world in info");
        Log.v("MainActivity", "hello world in verbose");
        Log.w("MainActivity", "hello world in warn");
        Log.e("MainActivity", "hello world in error");



    }
}