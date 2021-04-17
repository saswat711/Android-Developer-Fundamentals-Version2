package com.example.androidfundamentals021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {
TextView passagev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        passagev= findViewById(R.id.passagev);
        Intent intent = getIntent();
        String passage= intent.getStringExtra(MainActivity.which_passage);
        if (passage.equals("text1")) {
            passagev.setText(R.string.passage_1);

        }
        if (passage.equals("text2")) {
            passagev.setText(R.string.passage_2);

        }
        if (passage.equals("text3")) {
            passagev.setText(R.string.passage_3);

        }
    }
}