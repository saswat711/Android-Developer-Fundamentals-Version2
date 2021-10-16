package com.example.headset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private HeadReceiver cReceiver = new HeadReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(cReceiver, intentFilter);
    }
    @Override
    protected void onDestroy() {
        this.unregisterReceiver(cReceiver);
        super.onDestroy();
    }
}