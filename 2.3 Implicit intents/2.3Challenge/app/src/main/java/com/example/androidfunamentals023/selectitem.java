package com.example.androidfunamentals023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectitem extends AppCompatActivity {
private Button[] bitem = new Button[10];
String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectitem);
        bitem[0]=findViewById(R.id.button_bread);
        bitem[1]=findViewById(R.id.button_cheese);
        bitem[2]=findViewById(R.id.button_Chocolate);
        bitem[3]=findViewById(R.id.button_eggs);
        bitem[4]=findViewById(R.id.button_milk);
        bitem[5]=findViewById(R.id.button_oil);

        bitem[6]=findViewById(R.id.button_rice);
        bitem[7]=findViewById(R.id.button_salt);
        bitem[8]=findViewById(R.id.button_sugar);
        bitem[9]=findViewById(R.id.button_wheat);


    }

    public void selectItem(View view) {
        switch (view.getId()){
         case R.id.button_bread:
            message =  bitem[0].getText().toString();
             Intent intent=new Intent();
             intent.putExtra("MESSAGE",message);
             setResult(2,intent);
             finish();
           break;

         case R.id.button_cheese:
             String message =  bitem[1].getText().toString();
             intent=new Intent();
             intent.putExtra("MESSAGE",message);
             setResult(2,intent);
             finish();
           break;

         case R.id.button_Chocolate:
             message =  bitem[2].getText().toString();
              intent=new Intent();
             intent.putExtra("MESSAGE",message);
             setResult(2,intent);
             finish();
           break;

            case R.id.button_eggs:
               message =  bitem[3].getText().toString();
                intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;

            case R.id.button_milk:
                message =  bitem[4].getText().toString();
                intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;
            case R.id.button_oil:
             message =  bitem[5].getText().toString();
               intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;
            case R.id.button_rice:
                message =  bitem[6].getText().toString();
                intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;
            case R.id.button_salt:
                message =  bitem[7].getText().toString();
                intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;
            case R.id.button_sugar:
              message =  bitem[8].getText().toString();
                intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
                break;
                case R.id.button_wheat:
                    message =  bitem[9].getText().toString();
                  intent=new Intent();
                    intent.putExtra("MESSAGE",message);
                    setResult(2,intent);
                    finish();
                break;


    }
    }
}