package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mRecipeNames = new LinkedList<>();
    private final LinkedList<String> mRecipeDesc = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] a1=getResources().getStringArray(R.array.Recipe_Name);
        String[] a2=getResources().getStringArray(R.array.Recipe_Desc);
        for(int i =0;i<12;i++){
            mRecipeNames.add(a1[i]);
            mRecipeDesc.add(a2[i]);
        }

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        RecipeListAdapter mAdapter = new RecipeListAdapter(this, mRecipeNames , mRecipeDesc);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}