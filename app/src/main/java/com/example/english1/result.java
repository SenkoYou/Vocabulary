package com.example.english1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class result extends AppCompatActivity {

    int min = 0;
    int max = 5;
    int diff = max - min;
    Random random = new Random();
    int activity = random.nextInt(diff + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle key = getIntent().getExtras();
        int points = key.getInt("points4");
        int t1 = key.getInt("test1");
        int t2 = key.getInt("test2");
        int t3 = key.getInt("test3");
        int t4 = key.getInt("test4");
        TextView res = findViewById(R.id.pointres);
        TextView test1 = findViewById(R.id.test1res);
        TextView test2 = findViewById(R.id.test2res);
        TextView test3 = findViewById(R.id.test3res);
        TextView test4 = findViewById(R.id.test4res);
        Button replay = (Button) findViewById(R.id.replay);
        ImageView line1 = (ImageView) findViewById(R.id.liniyare1);
        ImageView line2 = (ImageView) findViewById(R.id.liniyare2);
        if(activity == 0){
            activity = activity + 1;
        }

        if(t1==1){
            test1.setText("№1 - correct");
            test1.setBackgroundColor(Color.GREEN);
        }else if(t1==0){
            test1.setText("№1 - incorrect");
            test1.setBackgroundColor(Color.RED);
        }

        if(t2==1){
            test2.setText("№2 - correct");
            test2.setBackgroundColor(Color.GREEN);
        }else if(t2==0){
            test2.setText("№2 - incorrect");
            test2.setBackgroundColor(Color.RED);
        }

        if(t3==1){
            test3.setText("№3 - correct");
            test3.setBackgroundColor(Color.GREEN);
        }else if(t3==0){
            test3.setText("№3 - incorrect");
            test3.setBackgroundColor(Color.RED);
        }

        if(t4==1){
            test4.setText("№4 - correct");
            test4.setBackgroundColor(Color.GREEN);
        }else if(t4==0){
            test4.setText("№4 - incorrect");
            test4.setBackgroundColor(Color.RED);
        }

        if(points==4){
            res.setText("100% - Great!");
        }else if(points==3){
            res.setText("75% - Well!");
        }else if(points==2){
            res.setText("50% - Not Bad!");
            replay.setVisibility(View.VISIBLE);
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.VISIBLE);
        }else if(points==1){
            res.setText("25% - Badly!");
            replay.setVisibility(View.VISIBLE);
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.VISIBLE);
        }else if(points==0){
            res.setText("0% - Very Bad!");
            replay.setVisibility(View.VISIBLE);
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.VISIBLE);
        }

        @SuppressLint("WrongViewCast") Button b1 = findViewById(R.id.bmenu);
        @SuppressLint("WrongViewCast") Button b2 = findViewById(R.id.replay);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(activity == 1){
                    Intent intent = new Intent(getApplicationContext(), test1.class);
                    startActivity(intent);
                }else if (activity == 2){
                    Intent intent = new Intent(getApplicationContext(), test1v2.class);
                    startActivity(intent);
                }else if (activity == 3){
                    Intent intent = new Intent(getApplicationContext(), test1v3.class);
                    startActivity(intent);
                }else if (activity == 4){
                    Intent intent = new Intent(getApplicationContext(), test1v4.class);
                    startActivity(intent);
                }else if (activity == 5){
                    Intent intent = new Intent(getApplicationContext(), test1v5.class);
                    startActivity(intent);
                }
            }
        });

    }
}