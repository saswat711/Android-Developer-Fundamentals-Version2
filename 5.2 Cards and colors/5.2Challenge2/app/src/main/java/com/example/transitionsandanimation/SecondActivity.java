package com.example.transitionsandanimation;

import android.os.Bundle;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ToastMessage();
    }

    public void ToastMessage() {
        Toast.makeText(this , "Go to previous activity for animations", Toast.LENGTH_LONG).show();
    }
}
