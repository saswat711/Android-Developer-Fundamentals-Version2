package com.example.pickerfortime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickTime(View view) {
        DialogFragment newFragment = new TimePickFragment();
        newFragment.show(getSupportFragmentManager(),"TimePicker");
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String TimeMessage = (hour_string +
                ":" + minute_string);
        Toast.makeText(this, "Time: " + TimeMessage,
                Toast.LENGTH_SHORT).show();
    }
}