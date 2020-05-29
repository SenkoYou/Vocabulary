package com.example.english1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Dialog;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int points = 0;
    int min = 0;
    int max = 5;
    int diff = max - min;
    Random random = new Random();
    int activity = random.nextInt(diff + 1);
//добавление элементов
    DBvoc dbvoc;//добавление базы в активити
    Button btnWrite;//добавление кнопки записи
    Button btnDelete;//добавление кнопки удаления
    //

    class MyAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(activity == 0){
            activity = activity + 1;
        }

        @SuppressLint("WrongViewCast") Button b1 = findViewById(R.id.play_btn);
        Button btnVoc = findViewById(R.id.voc_btn);
        btnVoc.setOnClickListener(this);
        b1.setOnClickListener(new View.OnClickListener() {

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

        //присвание для кнопок листенера
        dbvoc = new DBvoc(this);//база для работы
        //

        //Подключение диалогового окна
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_layout);
        Button buttonDialog = (Button) dialog.findViewById(R.id.buttonDialog);
        TextView textDialog = (TextView) dialog.findViewById(R.id.textViewDialog1);
        SQLiteDatabase database = dbvoc.getReadableDatabase(); //экземпляр базы данных, который можно только прочесть
        //рандомное слово
        Cursor cursor = database.query(DBvoc.TABLE_CONSTANTS,null, null, null, null, null, null);
        if(cursor.moveToFirst()) {
            cursor.moveToPosition((int) (Math.random() * 100));
            int idRussian = cursor.getColumnIndex(DBvoc.KEY_RUSSIAN);
            int idEnglish = cursor.getColumnIndex(DBvoc.KEY_ENGLISH);
            textDialog.setText(cursor.getString(idRussian) + " - это " + "\n" + cursor.getString(idEnglish));
            cursor.close();
            buttonDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    @Override
    public void onClick(View v) {
        TextView textRead =(TextView)findViewById(R.id.TextRead);
        SQLiteDatabase database = dbvoc.getWritableDatabase();//экземпляр базы данных, изменяемой базы данных
        ContentValues contentValues = new ContentValues();
        switch (v.getId()){
        case R.id.voc_btn:
                database.delete(DBvoc.TABLE_CONSTANTS,null,null);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Угол");
            contentValues.put(DBvoc.KEY_ENGLISH, "Angle");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Муравей");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ant");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Яблоко ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Apple ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рука");
            contentValues.put(DBvoc.KEY_ENGLISH, "Arm ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Армия");
            contentValues.put(DBvoc.KEY_ENGLISH, "Army ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Сумка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bag ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Мяч");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ball ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Банк");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bank ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Бассейн");
            contentValues.put(DBvoc.KEY_ENGLISH, "Basin ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Корзина");
            contentValues.put(DBvoc.KEY_ENGLISH, "Basket ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//10
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кровать");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bed ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Пчела");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bee ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ягода");
            contentValues.put(DBvoc.KEY_ENGLISH, "Berry ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Птица");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bird ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Лезвие");
            contentValues.put(DBvoc.KEY_ENGLISH, "Blade ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Доска");
            contentValues.put(DBvoc.KEY_ENGLISH, "Board ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Лодка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Boat ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кость");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bone ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Книга");
            contentValues.put(DBvoc.KEY_ENGLISH, "Book ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ботинок");
            contentValues.put(DBvoc.KEY_ENGLISH, "Boot ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//20
            contentValues.put(DBvoc.KEY_RUSSIAN, "Бутылка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bottle ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Коробка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Box ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Мальчик");
            contentValues.put(DBvoc.KEY_ENGLISH, "Boy ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Мозг");
            contentValues.put(DBvoc.KEY_ENGLISH, "Brain ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Тормоз");
            contentValues.put(DBvoc.KEY_ENGLISH, "Brake ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

            contentValues.put(DBvoc.KEY_RUSSIAN,

                    "Кирпич");
            contentValues.put(DBvoc.KEY_ENGLISH, "Brick ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Щётка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Brush ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ведро");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bucket ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кнопка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Button ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ребёнок");
            contentValues.put(DBvoc.KEY_ENGLISH, "Baby ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//30
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кот");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bat ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Цепь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Bhain ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Сыр");
            contentValues.put(DBvoc.KEY_ENGLISH, "Cheese ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Церковь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Church ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Круг");
            contentValues.put(DBvoc.KEY_ENGLISH, "Circle ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Часы");
            contentValues.put(DBvoc.KEY_ENGLISH, "Clock ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Облако");
            contentValues.put(DBvoc.KEY_ENGLISH, "Cloud ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Корова ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Cow");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Чашка ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Cup ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Пирог ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Cake ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//40
            contentValues.put(DBvoc.KEY_RUSSIAN, "Камера ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Camera ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Собака");
            contentValues.put(DBvoc.KEY_ENGLISH, "Dog ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Дверь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Door ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Платье, одевать ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Dress ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Капля, опускать");
            contentValues.put(DBvoc.KEY_ENGLISH, "Drop ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ухо");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ear ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Яйцо");
            contentValues.put(DBvoc.KEY_ENGLISH, "Egg ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Двигатель");
            contentValues.put(DBvoc.KEY_ENGLISH, "Engine ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Глаз");
            contentValues.put(DBvoc.KEY_ENGLISH, "Eye ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Лицо");
            contentValues.put(DBvoc.KEY_ENGLISH, "Face ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//50

            contentValues.put(DBvoc.KEY_RUSSIAN, "Ферма");

            contentValues.put(DBvoc.KEY_ENGLISH, "Farm ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Перо, украшать");
            contentValues.put(DBvoc.KEY_ENGLISH, "Feather");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Палец ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Finger");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рыба");
            contentValues.put(DBvoc.KEY_ENGLISH, "Fish");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Флаг");
            contentValues.put(DBvoc.KEY_ENGLISH, "Flag");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Пол, этаж");
            contentValues.put(DBvoc.KEY_ENGLISH, "Floor");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Муха, лететь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Fly");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Нога");
            contentValues.put(DBvoc.KEY_ENGLISH, "Foot");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рамка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Frame");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Сад");
            contentValues.put(DBvoc.KEY_ENGLISH, "Garden ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//60
            contentValues.put(DBvoc.KEY_RUSSIAN, "Девочка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Girl ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Перчатка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Glove ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Коза ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Goat ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Оружие");
            contentValues.put(DBvoc.KEY_ENGLISH, "Gun ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Волосы");
            contentValues.put(DBvoc.KEY_ENGLISH, "Hair");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Молоток");
            contentValues.put(DBvoc.KEY_ENGLISH, "Hammer");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рука");
            contentValues.put(DBvoc.KEY_ENGLISH, "Hand ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Шляпа");
            contentValues.put(DBvoc.KEY_ENGLISH, "Hat ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Голова");
            contentValues.put(DBvoc.KEY_ENGLISH, "Head ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Сердце");
            contentValues.put(DBvoc.KEY_ENGLISH, "Heart ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//70
            contentValues.put(DBvoc.KEY_RUSSIAN, "Лошадь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Horse ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Больница");
            contentValues.put(DBvoc.KEY_ENGLISH, "Hospital ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Дом");
            contentValues.put(DBvoc.KEY_ENGLISH, "House ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Остров");
            contentValues.put(DBvoc.KEY_ENGLISH, "Island ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ключ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Key ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

            contentValues.put(DBvoc.KEY_RUSSIAN, "Нож");

            contentValues.put(DBvoc.KEY_ENGLISH, "Knife ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Узел");
            contentValues.put(DBvoc.KEY_ENGLISH, "Knot ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Нога");
            contentValues.put(DBvoc.KEY_ENGLISH, "Leg ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Библиотека");
            contentValues.put(DBvoc.KEY_ENGLISH, "Library ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Линия");
            contentValues.put(DBvoc.KEY_ENGLISH, "Line ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//80
            contentValues.put(DBvoc.KEY_RUSSIAN, "Замок");
            contentValues.put(DBvoc.KEY_ENGLISH, "Lock ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Карта");
            contentValues.put(DBvoc.KEY_ENGLISH, "Map ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Спичка ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Match ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Обезьяна");
            contentValues.put(DBvoc.KEY_ENGLISH, "Monkey ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Луна");
            contentValues.put(DBvoc.KEY_ENGLISH, "Moon ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рот");
            contentValues.put(DBvoc.KEY_ENGLISH, "Mouth ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Мускул");
            contentValues.put(DBvoc.KEY_ENGLISH, "Muscle ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ноготь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Nail ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Шея");
            contentValues.put(DBvoc.KEY_ENGLISH, "Neck ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Нерв");
            contentValues.put(DBvoc.KEY_ENGLISH, "Nerve ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//90
            contentValues.put(DBvoc.KEY_RUSSIAN, "Нос");
            contentValues.put(DBvoc.KEY_ENGLISH, "Nose ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Орех");
            contentValues.put(DBvoc.KEY_ENGLISH, "Nut ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Офис");
            contentValues.put(DBvoc.KEY_ENGLISH, "Office");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Апельсин");
            contentValues.put(DBvoc.KEY_ENGLISH, "Orange ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Духовка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Oven ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Пакет");
            contentValues.put(DBvoc.KEY_ENGLISH, "Parcel ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ручка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pen ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Карандаш");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pencil ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Картина");
            contentValues.put(DBvoc.KEY_ENGLISH, "Picture ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Свинья");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pig ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
// 100

            contentValues.put(DBvoc.KEY_RUSSIAN, "Булавка");

            contentValues.put(DBvoc.KEY_ENGLISH, "Pin ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Труба");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pipe ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Самолёт");
            contentValues.put(DBvoc.KEY_ENGLISH, "Plane ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Карман");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pocket ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Картофель");
            contentValues.put(DBvoc.KEY_ENGLISH, "Potato ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Горшок ");
            contentValues.put(DBvoc.KEY_ENGLISH, "Pot");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рельс");
            contentValues.put(DBvoc.KEY_ENGLISH, "Rail ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Крыса");
            contentValues.put(DBvoc.KEY_ENGLISH, "Rat ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кольцо");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ring ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Крыша");
            contentValues.put(DBvoc.KEY_ENGLISH, "Roof ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//110
            contentValues.put(DBvoc.KEY_RUSSIAN, "Корень");
            contentValues.put(DBvoc.KEY_ENGLISH, "Root ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Парус");
            contentValues.put(DBvoc.KEY_ENGLISH, "Sail ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Школа");
            contentValues.put(DBvoc.KEY_ENGLISH, "School ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Овцы");
            contentValues.put(DBvoc.KEY_ENGLISH, "Sheep ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Корабль");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ship ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Рубашка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Shirt ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Ботинок");
            contentValues.put(DBvoc.KEY_ENGLISH, "Shoe ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Кожа");
            contentValues.put(DBvoc.KEY_ENGLISH, "Skin ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Юбка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Skirt ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Змея");
            contentValues.put(DBvoc.KEY_ENGLISH, "Snake ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//120
            contentValues.put(DBvoc.KEY_RUSSIAN, "Носок");
            contentValues.put(DBvoc.KEY_ENGLISH, "Sock ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Губка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Sponge ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Квадрат");
            contentValues.put(DBvoc.KEY_ENGLISH, "Square ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Звезда");
            contentValues.put(DBvoc.KEY_ENGLISH, "Star ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Станция");
            contentValues.put(DBvoc.KEY_ENGLISH, "Station ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

            contentValues.put(DBvoc.KEY_RUSSIAN, "Весна ");

            contentValues.put(DBvoc.KEY_ENGLISH, "Spring");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Палка");
            contentValues.put(DBvoc.KEY_ENGLISH, "Stick ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Магазин");
            contentValues.put(DBvoc.KEY_ENGLISH, "Store ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Улица");
            contentValues.put(DBvoc.KEY_ENGLISH, "Street ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Солнце");
            contentValues.put(DBvoc.KEY_ENGLISH, "Sun ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//130
            contentValues.put(DBvoc.KEY_RUSSIAN, "Стол");
            contentValues.put(DBvoc.KEY_ENGLISH, "Table ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Хвост");
            contentValues.put(DBvoc.KEY_ENGLISH, "Tail ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Нить");
            contentValues.put(DBvoc.KEY_ENGLISH, "Thread ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Билет");
            contentValues.put(DBvoc.KEY_ENGLISH, "Ticket ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Зуб");
            contentValues.put(DBvoc.KEY_ENGLISH, "Tooth ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Город");
            contentValues.put(DBvoc.KEY_ENGLISH, "Town ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Поезд");
            contentValues.put(DBvoc.KEY_ENGLISH, "Train ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Дерево");
            contentValues.put(DBvoc.KEY_ENGLISH, "Tree ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Брюки");
            contentValues.put(DBvoc.KEY_ENGLISH, "Trousers ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Зонт");
            contentValues.put(DBvoc.KEY_ENGLISH, "Umbrella ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//140
            contentValues.put(DBvoc.KEY_RUSSIAN, "Стена");
            contentValues.put(DBvoc.KEY_ENGLISH, "Wall ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Часы");
            contentValues.put(DBvoc.KEY_ENGLISH, "Watch ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Колесо");
            contentValues.put(DBvoc.KEY_ENGLISH, "Wheel ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Окно");
            contentValues.put(DBvoc.KEY_ENGLISH, "Window ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Крыло");
            contentValues.put(DBvoc.KEY_ENGLISH, "Wing ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(DBvoc.KEY_RUSSIAN, "Червь");
            contentValues.put(DBvoc.KEY_ENGLISH, "Worm ");
            database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            Intent intent = new Intent(getApplicationContext(), voc.class);
            startActivity(intent);
                break;
        }
        dbvoc.close();//закрывает базу и освобождает память
    }
}
