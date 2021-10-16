package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.standup.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void next_alarm_button(View view) {
        AlarmManager.AlarmClockInfo info = alarmManager.getNextAlarmClock();
        String message;
        if (info != null){
            Date nextAlarm = new Date(info.getTriggerTime());
            String newDate = DateFormat.getTimeInstance().format(nextAlarm);

            message = "The alarm is set for " + newDate + ".";
        }
        else{
            message = "There is no alarm scheduled.";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}