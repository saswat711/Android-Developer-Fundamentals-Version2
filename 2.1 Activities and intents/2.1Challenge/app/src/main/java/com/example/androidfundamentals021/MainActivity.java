package com.example.androidfundamentals021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String which_passage = "com.example.android.MainActivity.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void text1(View view) {
        Intent intent = new Intent(MainActivity.this, secondactivity.class);
        String passage = "text1";
        intent.putExtra(which_passage, passage );
        startActivity(intent);
    }

    public void text2(View view) {
        Intent intent = new Intent(MainActivity.this, secondactivity.class);
        String passage = "text2";
        intent.putExtra(which_passage, passage );
        startActivity(intent);
    }

    public void text3(View view) {
        Intent intent = new Intent(MainActivity.this, secondactivity.class);
        String passage = "text3";
        intent.putExtra(which_passage, passage );
        startActivity(intent);
    }
}