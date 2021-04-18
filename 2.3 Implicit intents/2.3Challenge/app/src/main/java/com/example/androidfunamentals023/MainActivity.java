package com.example.androidfunamentals023;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity<savedInstanceState> extends AppCompatActivity {

    private EditText etstorename;
    private final TextView[] vl = new TextView[10];
    private ArrayList<String> itemlist = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vl[0] = findViewById(R.id.listview);
        vl[1] = findViewById(R.id.listview2);
        vl[2] = findViewById(R.id.listview3);
        vl[3] = findViewById(R.id.listview4);
        vl[4] = findViewById(R.id.listview5);
        vl[5] = findViewById(R.id.listview6);
        vl[6] = findViewById(R.id.listview7);
        vl[7] = findViewById(R.id.listview8);
        vl[8] = findViewById(R.id.listview9);
        vl[9] = findViewById(R.id.listview10);

        etstorename = findViewById(R.id.etstorename);
        if (savedInstanceState != null) {
            itemlist = savedInstanceState.getStringArrayList("ItemsListArray");
            int i;
            if (itemlist != null && itemlist.size() > 0) {
                for (i = 0; i < itemlist.size(); i++) {
                    if (itemlist.size() > 10) {
                        Toast.makeText(MainActivity.this, "Cannot add more items to the list", Toast.LENGTH_LONG).show();
                        break;
                    }
                    vl[i+1].setVisibility(View.VISIBLE);
                    vl[i+1].setText(itemlist.get(i));
                }
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (itemlist.size() != 0) {
            outState.putStringArrayList("ItemsListArray", itemlist);
        }
    }

    public void additem(View view) {
        Intent item = new Intent(this, selectitem.class);
        startActivityForResult(item, 2);


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
          if (resultCode == 2) {


            String message=data.getStringExtra("MESSAGE");
            itemlist.add(message);
            int i;

            for (i = 0; i < itemlist.size(); i++) {
                if (itemlist.size() > 10) {
                    Toast.makeText(MainActivity.this, " more items Cannot be added to the list", Toast.LENGTH_LONG).show();
                    break;
                }
                vl[i].setVisibility(View.VISIBLE);
                vl[i].setText(itemlist.get(i));
            }
          }

         }
    }

    public void locate(View view) {
        String location = etstorename.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}