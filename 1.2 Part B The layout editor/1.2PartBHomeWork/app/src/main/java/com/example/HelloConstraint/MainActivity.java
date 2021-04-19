package com.example.HelloConstraint;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button countUp,zero;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        countUp = findViewById(R.id.button_count);
        zero = findViewById(R.id.button_zero);
        if(mCount == 0)
        {
            zero.setBackgroundColor(getColor(R.color.design_default_color_background));
        }
        else{
            zero.setBackgroundColor(getColor(R.color.colorAccent));
        }
    }


    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }


    @SuppressLint("SetTextI18n")
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

            if(mCount%2 == 0)
            {
                countUp.setBackgroundColor(getColor(R.color.teal_700));
            }
            if(mCount%2 != 0)
            {
                countUp.setBackgroundColor(getColor(R.color.purple_700));
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void zero(View view) {
        if(mCount == 0)
        {
            Toast toastzero = Toast.makeText(this, R.string.toast_zero,Toast.LENGTH_SHORT);
            toastzero.show();
        }
        if(mCount != 0) {
            mCount = 0;
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}