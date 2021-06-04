package com.example.drawabletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int indicator = 0;
    ImageView battery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery = findViewById(R.id.ivIndicator);
    }

    public void onChange(View view) {
        switch (view.getId()){
            case R.id.btMinus:
                if(indicator<0){
                    Toast.makeText(this,"Can't Go Below 0 Percent",Toast.LENGTH_SHORT).show();
                }
                if (indicator > 0){
                    indicator --;
                    battery.setImageLevel(indicator);
                }
                break;
            case R.id.btPlus:
                if(indicator>6){
                    Toast.makeText(this,"Can't Go Beyond 100 Percent",Toast.LENGTH_SHORT).show();
                }
                if (indicator <6){
                    indicator ++;
                    battery.setImageLevel(indicator);
                }
                break;
            default:
                break;
        }

    }


}