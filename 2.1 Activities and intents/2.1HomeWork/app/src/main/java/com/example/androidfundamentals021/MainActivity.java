package com.example.androidfundamentals021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countv;
private  Integer mcount = 0;
public static String countn0 = "com.example.android.MainActivity.countn0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countv=findViewById(R.id.countv);
    }

    public void sayhello(View view) {
        String count = countv.getText().toString();
        Intent intent = new Intent(MainActivity.this, activity2.class);
        intent.putExtra(countn0,count);
        startActivity(intent);

    }

    public void countup(View view) {
        mcount++;
        countv.setText(Integer.toString(mcount));
    }
}