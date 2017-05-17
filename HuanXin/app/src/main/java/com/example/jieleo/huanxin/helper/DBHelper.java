package com.example.jieleo.huanxin.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OldFour on 2017/5/11.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="test.db";
    private static final int DB_VERSION=1;
    private static final String TAB_NAME="info";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
