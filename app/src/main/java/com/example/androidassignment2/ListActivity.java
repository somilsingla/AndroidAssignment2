package com.example.androidassignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView;

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycle);

        ArrayList<item> items = new ArrayList<>();


        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int count = sharedPreferences.getInt("counter",0);

        for(int i=0;i<=count;i++) {
            String Name = sharedPreferences.getString("namekey"+i, "Not Defined");
            String Message = sharedPreferences.getString("mesagekey"+i, "Not Defined");
            if (Name == "Not Defined" || Message == "Not Defined");
            else   {
                items.add(new item(Name, Message, R.drawable.dp));
            }
        }
        count++;
        editor.putInt("counter",count);
        editor.commit();

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewCustomAdapter adapter = new RecyclerViewCustomAdapter(items,this);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(ListActivity.this,AddItemActivity.class);
                startActivity(open);
            }
        });
    }

}
