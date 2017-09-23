package com.example.jieleo.customviewdemo.activity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jieleo.customviewdemo.R;

public class SimpleRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler);

        Log.d("SimpleRecyclerActivity", "onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();


        Log.d("SimpleRecyclerActivity", "onStart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("SimpleRecyclerActivity", "onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("SimpleRecyclerActivity", "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("SimpleRecyclerActivity", "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d("SimpleRecyclerActivity", "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SimpleRecyclerActivity", "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("SimpleRecyclerActivity", "onDestroy");
    }



}
