package com.example.english1;

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

public class test2v5 extends AppCompatActivity {

    int t2 = 0;
    String ca = "telephone";
    int min = 0;
    int max = 5;
    int diff = max - min;
    Random random = new Random();
    int activity = random.nextInt(diff + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2v5);

        if(activity == 0){
            activity = activity + 1;
        }

        final Bundle key = getIntent().getExtras();

        @SuppressLint("WrongViewCast") Button b1 = findViewById(R.id.btn2v5);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText ER = findViewById(R.id.er2v5);
                String response = ER.getText().toString().trim();
                int points = key.getInt("points1");
                int t1 = key.getInt("test1");
                if(response.equals(ca)){
                    points = points+1;
                    t2 = t2 + 1;
                }else{
                    points = points+0;
                    t2 = t2 + 0;
                }
                if(activity == 1){
                    Intent intent = new Intent(getApplicationContext(), test3.class);
                    intent.putExtra("points2", points);
                    intent.putExtra("test1", t1);
                    intent.putExtra("test2", t2);
                    startActivity(intent);
                }else if (activity == 2){
                    Intent intent = new Intent(getApplicationContext(), test3v2.class);
                    intent.putExtra("points2", points);
                    intent.putExtra("test1", t1);
                    intent.putExtra("test2", t2);
                    startActivity(intent);
                }else if (activity == 3){
                    Intent intent = new Intent(getApplicationContext(), test3v3.class);
                    intent.putExtra("points2", points);
                    intent.putExtra("test1", t1);
                    intent.putExtra("test2", t2);
                    startActivity(intent);
                }else if (activity == 4) {
                Intent intent = new Intent(getApplicationContext(), test3v4.class);
                intent.putExtra("points2", points);
                intent.putExtra("test1", t1);
                intent.putExtra("test2", t2);
                startActivity(intent);
            }else if (activity == 5) {
                Intent intent = new Intent(getApplicationContext(), test3v5.class);
                intent.putExtra("points2", points);
                intent.putExtra("test1", t1);
                intent.putExtra("test2", t2);
                startActivity(intent);
            }
            }
        });
    }
}
