package com.example.english1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBvoc extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "english";
    public static final String TABLE_CONSTANTS = "constants";

    public static final String KEY_ID = "_id";
    public static final String KEY_RUSSIAN = "russianWords";
    public static final String KEY_ENGLISH = "englishWords";

    public DBvoc(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONSTANTS + "(" + KEY_ID
                + " integer primary key," + KEY_RUSSIAN + " text," + KEY_ENGLISH + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_CONSTANTS);

        onCreate(db);
    }
    public final Activity getActivity() {
        return null;
    }
    public void getDataFromSqlite() {
        Cursor cursor = null;
        DBvoc mHelper = new DBvoc(getActivity().getApplicationContext());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String queryString = "select russianWords , englishWords" +
                "from english " +
                "order by rand()";
        Log.d("queryString", queryString.toString());


        try {
            cursor = db.rawQuery(queryString, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
}