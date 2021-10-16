package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.sharedprefs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private int mColor;
    private final String COUNT_KEY = "count";
    private final String COLOR_KEY = "color";
    private final String COUNT_SAVE_KEY = "count_save";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "me.mahakagg.hellosharedprefs";
    private String COUNT_EXTRA = "count_extra";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mColor = ContextCompat.getColor(this, R.color.default_background);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        mCount = mPreferences.getInt(COUNT_KEY, 0);
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        binding.tvShowCount.setText(String.format("%s", mCount));
        binding.tvShowCount.setBackgroundColor(mColor);
    }

    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        binding.tvShowCount.setBackgroundColor(color);
        mColor = color;
    }

    public void countUp(View view) {
        mCount++;
        binding.tvShowCount.setText(String.format("%s", mCount));
    }

    public void reset(View view) {
        mCount = 0;
        binding.tvShowCount.setText(String.format("%s", mCount));
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        binding.tvShowCount.setBackgroundColor(mColor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        boolean countSave = mPreferences.getBoolean(COUNT_SAVE_KEY, true);
        if (countSave){
            editor.putInt(COUNT_KEY, mCount);
        }
        else{
            editor.putInt(COUNT_KEY, 0);
        }
        editor.apply();
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}