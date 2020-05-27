package com.example.english1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class test1v3 extends AppCompatActivity {

    int t1 = 0;
    int points = 0;
    int min = 0;
    int max = 5;
    int diff = max - min;
    Random random = new Random();
    int activity = random.nextInt(diff + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1v3);

        if(activity == 0){
            activity = activity + 1;
        }

        @SuppressLint("WrongViewCast") Button b1 = findViewById(R.id.yes1v3);
        @SuppressLint("WrongViewCast") Button b2 = findViewById(R.id.no1v3);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    points = points+1;
                    t1 = t1 + 1;
                if(activity == 1){
                    Intent intent = new Intent(getApplicationContext(), test2.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 2){
                    Intent intent = new Intent(getApplicationContext(), test2v2.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 3){
                    Intent intent = new Intent(getApplicationContext(), test2v3.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 4){
                    Intent intent = new Intent(getApplicationContext(), test2v4.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 5){
                    Intent intent = new Intent(getApplicationContext(), test2v5.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(activity == 1){
                    Intent intent = new Intent(getApplicationContext(), test2.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 2){
                    Intent intent = new Intent(getApplicationContext(), test2v2.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 3){
                    Intent intent = new Intent(getApplicationContext(), test2v3.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 4){
                    Intent intent = new Intent(getApplicationContext(), test2v4.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }else if (activity == 5){
                    Intent intent = new Intent(getApplicationContext(), test2v5.class);
                    intent.putExtra("points1", points);
                    intent.putExtra("test1", t1);
                    startActivity(intent);
                }
            }
        });

    }
}