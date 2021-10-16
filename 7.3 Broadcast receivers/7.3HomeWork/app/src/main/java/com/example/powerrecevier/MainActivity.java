package com.example.powerrecevier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private PowerReceiver mReceiver = new PowerReceiver();
    private static final String EXTRA_RANDOM_NUMBER = "com.example.myapplication.RANDOM_NUMBER";
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID  + ".ACTION_CUSTOM_BROADCAST";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(mReceiver, intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }
    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        int num = randomNum();
        textView.setText(String.format("Number is %s", String.valueOf(num)));
        customBroadcastIntent.putExtra(EXTRA_RANDOM_NUMBER, String.valueOf(num));
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    public int randomNum(){
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}