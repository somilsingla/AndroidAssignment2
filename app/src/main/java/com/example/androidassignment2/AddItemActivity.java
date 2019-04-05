package com.example.androidassignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddItemActivity extends AppCompatActivity {

    String Name;
    String Message;
    Image icon;
    ImageView imageView;
    SharedPreferences sharedPreferences;
    EditText edit1,edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Button button = findViewById(R.id.button3);
        edit1 = (EditText)findViewById(R.id.Name);
        edit2 = (EditText)findViewById(R.id.Message);
        imageView = findViewById(R.id.user);
        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count=sharedPreferences.getInt("counter",0);
                Name = edit1.getText().toString();
                Message = edit2.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("namekey"+count,Name);
                editor.putString("messagekey"+count, Message);
                editor.commit();
                Intent open = new Intent(AddItemActivity.this , ListActivity.class);
                startActivity(open);

            }
        });
    }
}
