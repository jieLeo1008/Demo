package com.benny.viewdemo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Benny on 2018/3/7.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String CREATE_BOOK="create table Book (id integer primary key autoincrement, author text, " +
            "price read, " +
            "page integer, " +
            "name text)";

    public static final String CREATE_CATEGORY="create table Category (" +
            "id integer primary key autoincrement, " +
            "category_name text, " +
            "category_code integer)";

    private Context context;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(context, "created success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 1:

            case 2:

        }
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
