package com.example.english1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        TextView DialogView = (TextView) findViewById(R.id.textViewDialog1);

        dialog.setContentView(R.layout.activity_dialog);
        Button buttonDialog = (Button) dialog.findViewById(R.id.buttonDialog);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.setTitle("Запомни!");
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        TextView textRead =(TextView)findViewById(R.id.TextRead);
        SQLiteDatabase database = dbvoc.getWritableDatabase();//экземпляр базы данных, изменяемой базы данных
        ContentValues contentValues = new ContentValues();
        switch (v.getId()){
        case R.id.voc_btn:
                database.delete(DBvoc.TABLE_CONSTANTS,null,null);
        contentValues.put(DBvoc.KEY_RUSSIAN, "угол");
        contentValues.put(DBvoc.KEY_ENGLISH, "angle");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "муравей");
        contentValues.put(DBvoc.KEY_ENGLISH, "ant");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "яблоко ");
        contentValues.put(DBvoc.KEY_ENGLISH, "apple ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рука");
        contentValues.put(DBvoc.KEY_ENGLISH, "arm ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "армия");
        contentValues.put(DBvoc.KEY_ENGLISH, "army ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "сумка");
        contentValues.put(DBvoc.KEY_ENGLISH, "bag ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "мяч");
        contentValues.put(DBvoc.KEY_ENGLISH, "ball ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "банк");
        contentValues.put(DBvoc.KEY_ENGLISH, "bank ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "бассейн");
        contentValues.put(DBvoc.KEY_ENGLISH, "basin ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "корзина");
        contentValues.put(DBvoc.KEY_ENGLISH, "basket ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//10
        contentValues.put(DBvoc.KEY_RUSSIAN, "кровать");
        contentValues.put(DBvoc.KEY_ENGLISH, "bed ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "пчела");
        contentValues.put(DBvoc.KEY_ENGLISH, "bee ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ягода");
        contentValues.put(DBvoc.KEY_ENGLISH, "berry ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "птица");
        contentValues.put(DBvoc.KEY_ENGLISH, "bird ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "лезвие");
        contentValues.put(DBvoc.KEY_ENGLISH, "blade ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "доска");
        contentValues.put(DBvoc.KEY_ENGLISH, "board ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "лодка");
        contentValues.put(DBvoc.KEY_ENGLISH, "boat ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "кость");
        contentValues.put(DBvoc.KEY_ENGLISH, "bone ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "книга");
        contentValues.put(DBvoc.KEY_ENGLISH, "book ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ботинок");
        contentValues.put(DBvoc.KEY_ENGLISH, "boot ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//20
        contentValues.put(DBvoc.KEY_RUSSIAN, "бутылка");
        contentValues.put(DBvoc.KEY_ENGLISH, "bottle ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "коробка");
        contentValues.put(DBvoc.KEY_ENGLISH, "box ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "мальчик");
        contentValues.put(DBvoc.KEY_ENGLISH, "boy ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "мозг");
        contentValues.put(DBvoc.KEY_ENGLISH, "brain ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "тормоз");
        contentValues.put(DBvoc.KEY_ENGLISH, "brake ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

        contentValues.put(DBvoc.KEY_RUSSIAN, "кирпич");
        contentValues.put(DBvoc.KEY_ENGLISH, "brick ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "щётка");
        contentValues.put(DBvoc.KEY_ENGLISH, "brush ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ведро");
        contentValues.put(DBvoc.KEY_ENGLISH, "bucket ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "кнопка");
        contentValues.put(DBvoc.KEY_ENGLISH, "button ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ребёнок");
        contentValues.put(DBvoc.KEY_ENGLISH, "baby ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//30
        contentValues.put(DBvoc.KEY_RUSSIAN, "кот");
        contentValues.put(DBvoc.KEY_ENGLISH, "cat ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "цепь");
        contentValues.put(DBvoc.KEY_ENGLISH, "chain ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "сыр");
        contentValues.put(DBvoc.KEY_ENGLISH, "cheese ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "церковь");
        contentValues.put(DBvoc.KEY_ENGLISH, "church ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "круг");
        contentValues.put(DBvoc.KEY_ENGLISH, "circle ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "часы");
        contentValues.put(DBvoc.KEY_ENGLISH, "clock ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "облако");
        contentValues.put(DBvoc.KEY_ENGLISH, "cloud ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "корова ");
        contentValues.put(DBvoc.KEY_ENGLISH, "корова");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "чашка ");
        contentValues.put(DBvoc.KEY_ENGLISH, "cup ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "пирог ");
        contentValues.put(DBvoc.KEY_ENGLISH, "cake ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//40
        contentValues.put(DBvoc.KEY_RUSSIAN, "камера ");
        contentValues.put(DBvoc.KEY_ENGLISH, "camera ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "собака");
        contentValues.put(DBvoc.KEY_ENGLISH, "dog ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "дверь");
        contentValues.put(DBvoc.KEY_ENGLISH, "door ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "платье, одевать ");
        contentValues.put(DBvoc.KEY_ENGLISH, "dress ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "капля, опускать");
        contentValues.put(DBvoc.KEY_ENGLISH, "drop ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ухо");
        contentValues.put(DBvoc.KEY_ENGLISH, "ear ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "яйцо");
        contentValues.put(DBvoc.KEY_ENGLISH, "egg ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "двигатель");
        contentValues.put(DBvoc.KEY_ENGLISH, "engine ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "глаз");
        contentValues.put(DBvoc.KEY_ENGLISH, "eye ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "лицо");
        contentValues.put(DBvoc.KEY_ENGLISH, "face ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//50

        contentValues.put(DBvoc.KEY_RUSSIAN, "ферма");
        contentValues.put(DBvoc.KEY_ENGLISH, "farm ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "перо, украшать");
        contentValues.put(DBvoc.KEY_ENGLISH, "feather");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "палец ");
        contentValues.put(DBvoc.KEY_ENGLISH, "finger");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рыба");
        contentValues.put(DBvoc.KEY_ENGLISH, "fish");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "флаг");
        contentValues.put(DBvoc.KEY_ENGLISH, "flag");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "пол, этаж");
        contentValues.put(DBvoc.KEY_ENGLISH, "floor");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "муха, лететь");
        contentValues.put(DBvoc.KEY_ENGLISH, "fly");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "нога");
        contentValues.put(DBvoc.KEY_ENGLISH, "foot");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рамка");
        contentValues.put(DBvoc.KEY_ENGLISH, "frame");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "сад");
        contentValues.put(DBvoc.KEY_ENGLISH, " garden ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//60
        contentValues.put(DBvoc.KEY_RUSSIAN, "девочка");
        contentValues.put(DBvoc.KEY_ENGLISH, "girl ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "перчатка");
        contentValues.put(DBvoc.KEY_ENGLISH, "glove ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "коза ");
        contentValues.put(DBvoc.KEY_ENGLISH, " goat ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "оружие");
        contentValues.put(DBvoc.KEY_ENGLISH, " gun ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "волосы");
        contentValues.put(DBvoc.KEY_ENGLISH, "hair");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "молоток");
        contentValues.put(DBvoc.KEY_ENGLISH, "hammer");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рука");
        contentValues.put(DBvoc.KEY_ENGLISH, " hand ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "шляпа");
        contentValues.put(DBvoc.KEY_ENGLISH, "hat ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "голова");
        contentValues.put(DBvoc.KEY_ENGLISH, " head ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "сердце");
        contentValues.put(DBvoc.KEY_ENGLISH, "heart ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//70
        contentValues.put(DBvoc.KEY_RUSSIAN, "лошадь");
        contentValues.put(DBvoc.KEY_ENGLISH, "horse ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "больница");
        contentValues.put(DBvoc.KEY_ENGLISH, "hospital ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, " дом");
        contentValues.put(DBvoc.KEY_ENGLISH, "house ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "остров");
        contentValues.put(DBvoc.KEY_ENGLISH, " island ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ключ");
        contentValues.put(DBvoc.KEY_ENGLISH, " key ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

        contentValues.put(DBvoc.KEY_RUSSIAN, "нож");
        contentValues.put(DBvoc.KEY_ENGLISH, " knife ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "узел");
        contentValues.put(DBvoc.KEY_ENGLISH, "knot ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "нога");
        contentValues.put(DBvoc.KEY_ENGLISH, " leg ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "библиотека");
        contentValues.put(DBvoc.KEY_ENGLISH, " library ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "линия");
        contentValues.put(DBvoc.KEY_ENGLISH, " line ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//80
        contentValues.put(DBvoc.KEY_RUSSIAN, "замок");
        contentValues.put(DBvoc.KEY_ENGLISH, "lock ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "карта");
        contentValues.put(DBvoc.KEY_ENGLISH, "map ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "спичка ");
        contentValues.put(DBvoc.KEY_ENGLISH, "match ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "обезьяна");
        contentValues.put(DBvoc.KEY_ENGLISH, " monkey ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "луна");
        contentValues.put(DBvoc.KEY_ENGLISH, "moon ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рот");
        contentValues.put(DBvoc.KEY_ENGLISH, "mouth ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "мускул");
        contentValues.put(DBvoc.KEY_ENGLISH, "muscle ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ноготь");
        contentValues.put(DBvoc.KEY_ENGLISH, "nail ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "шея");
        contentValues.put(DBvoc.KEY_ENGLISH, "neck ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "нерв");
        contentValues.put(DBvoc.KEY_ENGLISH, " nerve ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//90
        contentValues.put(DBvoc.KEY_RUSSIAN, "нос");
        contentValues.put(DBvoc.KEY_ENGLISH, "nose ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "орех");
        contentValues.put(DBvoc.KEY_ENGLISH, "nut ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "офис");
        contentValues.put(DBvoc.KEY_ENGLISH, "office");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "апельсин, оранжевый");
        contentValues.put(DBvoc.KEY_ENGLISH, "orange ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "духовка, печь");
        contentValues.put(DBvoc.KEY_ENGLISH, "oven ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "пакет");
        contentValues.put(DBvoc.KEY_ENGLISH, "parcel ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ручка");
        contentValues.put(DBvoc.KEY_ENGLISH, " pen ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "карандаш");
        contentValues.put(DBvoc.KEY_ENGLISH, "pencil ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "картина");
        contentValues.put(DBvoc.KEY_ENGLISH, " picture ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "свинья");
        contentValues.put(DBvoc.KEY_ENGLISH, "pig ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
// 100

        contentValues.put(DBvoc.KEY_RUSSIAN, "булавка");
        contentValues.put(DBvoc.KEY_ENGLISH, "pin ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "труба");
        contentValues.put(DBvoc.KEY_ENGLISH, "pipe ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "самолёт");
        contentValues.put(DBvoc.KEY_ENGLISH, " plane ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "карман");
        contentValues.put(DBvoc.KEY_ENGLISH, "pocket ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "картофель");
        contentValues.put(DBvoc.KEY_ENGLISH, "potato ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "pot ");
        contentValues.put(DBvoc.KEY_ENGLISH, "горшок");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рельс");
        contentValues.put(DBvoc.KEY_ENGLISH, "rail ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "крыса");
        contentValues.put(DBvoc.KEY_ENGLISH, "rat ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "кольцо, звонить");
        contentValues.put(DBvoc.KEY_ENGLISH, " ring ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "крыша");
        contentValues.put(DBvoc.KEY_ENGLISH, " roof ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//110
        contentValues.put(DBvoc.KEY_RUSSIAN, "корень");
        contentValues.put(DBvoc.KEY_ENGLISH, "root ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "парус");
        contentValues.put(DBvoc.KEY_ENGLISH, "sail ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "школа");
        contentValues.put(DBvoc.KEY_ENGLISH, " school ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "овцы");
        contentValues.put(DBvoc.KEY_ENGLISH, "sheep ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "корабль");
        contentValues.put(DBvoc.KEY_ENGLISH, "ship ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "рубашка");
        contentValues.put(DBvoc.KEY_ENGLISH, "shirt ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "ботинок");
        contentValues.put(DBvoc.KEY_ENGLISH, "shoe ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "кожа");
        contentValues.put(DBvoc.KEY_ENGLISH, "skin ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "юбка");
        contentValues.put(DBvoc.KEY_ENGLISH, " skirt ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "змея");
        contentValues.put(DBvoc.KEY_ENGLISH, " snake ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//120
        contentValues.put(DBvoc.KEY_RUSSIAN, "носок");
        contentValues.put(DBvoc.KEY_ENGLISH, "sock ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "губка");
        contentValues.put(DBvoc.KEY_ENGLISH, " sponge ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "квадрат");
        contentValues.put(DBvoc.KEY_ENGLISH, "square ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "звезда");
        contentValues.put(DBvoc.KEY_ENGLISH, "star ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "станция");
        contentValues.put(DBvoc.KEY_ENGLISH, "station ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);

        contentValues.put(DBvoc.KEY_RUSSIAN, "весна ");
        contentValues.put(DBvoc.KEY_ENGLISH, "spring");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "палка");
        contentValues.put(DBvoc.KEY_ENGLISH, "stick ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "магазин");
        contentValues.put(DBvoc.KEY_ENGLISH, "store ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "улица");
        contentValues.put(DBvoc.KEY_ENGLISH, "street ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "солнце");
        contentValues.put(DBvoc.KEY_ENGLISH, " sun ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//130
        contentValues.put(DBvoc.KEY_RUSSIAN, " стол");
        contentValues.put(DBvoc.KEY_ENGLISH, "table ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "хвост");
        contentValues.put(DBvoc.KEY_ENGLISH, "tail ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "нить");
        contentValues.put(DBvoc.KEY_ENGLISH, " thread ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "билет");
        contentValues.put(DBvoc.KEY_ENGLISH, "ticket ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "зуб");
        contentValues.put(DBvoc.KEY_ENGLISH, "tooth ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "город");
        contentValues.put(DBvoc.KEY_ENGLISH, "town ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "поезд");
        contentValues.put(DBvoc.KEY_ENGLISH, "train ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "дерево");
        contentValues.put(DBvoc.KEY_ENGLISH, "tree ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "брюки");
        contentValues.put(DBvoc.KEY_ENGLISH, "trousers ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "зонт");
        contentValues.put(DBvoc.KEY_ENGLISH, " umbrella ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
//140
        contentValues.put(DBvoc.KEY_RUSSIAN, "стена");
        contentValues.put(DBvoc.KEY_ENGLISH, "wall ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "часы");
        contentValues.put(DBvoc.KEY_ENGLISH, " watch ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "колесо");
        contentValues.put(DBvoc.KEY_ENGLISH, " wheel ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "окно");
        contentValues.put(DBvoc.KEY_ENGLISH, "window ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "крыло");
        contentValues.put(DBvoc.KEY_ENGLISH, "wing ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
        contentValues.put(DBvoc.KEY_RUSSIAN, "червь");
        contentValues.put(DBvoc.KEY_ENGLISH, "worm ");
        database.insert(DBvoc.TABLE_CONSTANTS, null, contentValues);
            Intent intent = new Intent(getApplicationContext(), voc.class);
            startActivity(intent);
                break;
        }
        dbvoc.close();//закрывает базу и освобождает память
    }
}
