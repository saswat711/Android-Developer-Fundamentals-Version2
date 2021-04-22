package com.example.checkboxes_and_etc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox[] cb = new CheckBox[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb[0] = findViewById(R.id.ChoclateSyrupCb);
        cb[1] = findViewById(R.id.CherrriesCb);
        cb[2] = findViewById(R.id.OrioCookieCrumblesCb);
        cb[3] = findViewById(R.id.ChrushedNutsCb);
        cb[4] = findViewById(R.id.SprinklesCb);

    }

    public void ToastShow(View view) {
        String message = "Toppings: ";
        for(int i=0;i<=4;i++)
        {
         Boolean check = cb[i].isChecked();
         if(check)
         {
             message= message + cb[i].getText().toString() +" ";
         }
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}