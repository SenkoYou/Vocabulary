package com.example.english1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class voc extends AppCompatActivity implements View.OnClickListener {
    //добавление элементов
    DBvoc dbvoc;//добавление базы в активити
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voc);

        Button btnRead = (Button)findViewById(R.id.btnRead);//листенер для кнопок
        btnRead.setOnClickListener(this);
        dbvoc = new DBvoc(this);//добавление базы в активити
    }

    @Override
    public void onClick(View v) {

        TextView textRead =(TextView)findViewById(R.id.TextRead);//экземпляр текствью
        SQLiteDatabase database = dbvoc.getReadableDatabase(); //экземпляр базы данных, который можно только прочесть
        switch (v.getId()){
            case R.id.btnRead:
                Button btnRead = (Button)findViewById(R.id.btnRead);
                btnRead.setText("Vocabulary");
                Cursor cursor = database.query(DBvoc.TABLE_CONSTANTS,null, null, null, null, null, null);
                if (cursor.moveToFirst()){//если первый элемент сушествует, то...
                    //создаются индексы, с помощью которых можно будет взять строку
                    int idIndex = cursor.getColumnIndex(DBvoc.KEY_ID);
                    int idRussian = cursor.getColumnIndex(DBvoc.KEY_RUSSIAN);
                    int idEnglish = cursor.getColumnIndex(DBvoc.KEY_ENGLISH);

                    LinkedList<String> List = new LinkedList<>();// создается массив, чтобы можно было сохранить туда данные строки
                    List.add(0,cursor.getString(idRussian) + " - " + cursor.getString(idEnglish));//заполняется первый элемент
                    int i = 1;//переменная, чтобы можно было перебирать последующие элементы и выводить по одному
                    while (cursor.moveToNext()){//пока можно перейти на следующий элемент, делаем это...
                        int idIndexNext = cursor.getColumnIndex(DBvoc.KEY_ID);
                        int idRussianNext = cursor.getColumnIndex(DBvoc.KEY_RUSSIAN);
                        int idEnglishNext = cursor.getColumnIndex(DBvoc.KEY_ENGLISH);
                        List.add(i,cursor.getString(idRussianNext) + " - " + cursor.getString(idEnglishNext));//заполняются остальные элементы массива
                        i++;
                    };
                    for(int j = 0; j < List.size(); j++){//конструкция, чтобы можно было вывести все элементы, а не только последний
                        textRead.append(List.get(j)+"\n");
                    }
                }else//если не существует, то...
                    textRead.setText("Вы не добавили слова");
                cursor.close();//закрываем и освобождаем память, ОБЯЗАТЕЛЬНО
                v.setClickable(false);
                break;
        }
        dbvoc.close();//закрываем базу данных
    }
}