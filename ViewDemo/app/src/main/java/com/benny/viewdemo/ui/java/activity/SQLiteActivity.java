package com.benny.viewdemo.ui.java.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.benny.viewdemo.R;
import com.benny.viewdemo.util.DBHelper;

public class SQLiteActivity extends AppCompatActivity {

    private DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        mDBHelper=new DBHelper(this,"BookStore.db",null,3);
        findViewById(R.id.create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDBHelper.getWritableDatabase();
            }
        });


        findViewById(R.id.add_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=mDBHelper.getWritableDatabase();
                ContentValues values =new ContentValues();
                values.put("name","张三");
                values.put("author","李白");
                values.put("price",23.5);
                values.put("page",12);
                db.insert("Book",null,values);

                values.clear();

                values.put("name","李四");
                values.put("author","王田峰");
                values.put("price",30.15);
                values.put("page",129);
                db.insert("Book",null,values);

            }
        });


        findViewById(R.id.update_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database =mDBHelper.getWritableDatabase();
                ContentValues contentValues =new ContentValues();
                contentValues.put("page",50);
                database.update("Book",contentValues,"page=?",new String[]{"李四"});
            }
        });


        findViewById(R.id.delete_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database =mDBHelper.getWritableDatabase();
                database.delete("Book","page > ?",new String[]{"24"});
            }
        });


        findViewById(R.id.query_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database =mDBHelper.getWritableDatabase();
                Cursor cursor =database.rawQuery("select * from Book",null);
//                Cursor cursor =database.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        String price=cursor.getString(cursor.getColumnIndex("price"));
                        String page=cursor.getString(cursor.getColumnIndex("page"));
                        Log.d("SQLiteActivity", "book name" + name);
                        Log.d("SQLiteActivity", "book author" + author);
                        Log.d("SQLiteActivity", "book price" + price);
                        Log.d("SQLiteActivity", "book page" + page);
                    }while (cursor.moveToNext());
                }

                cursor.close();


            }
        });



        findViewById(R.id.replace_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database =mDBHelper.getWritableDatabase();
                database.beginTransaction();
                try {


                    database.delete("Book", null, null);



                    ContentValues values = new ContentValues();

                    values.put("name", "Python");
                    values.put("author", "benny");
                    values.put("page", 200);
                    values.put("price", 200.2);
                    database.insert("Book", null, values);
                    database.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                }
                database.endTransaction();
            }
        });
    }
}
