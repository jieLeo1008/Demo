package com.example.jieleo.matierialdesigndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jieleo.matierialdesigndemo.activity.CharacterCounterActivity;
import com.example.jieleo.matierialdesigndemo.activity.MenuActivity;
import com.example.jieleo.matierialdesigndemo.activity.RatingBarActivity;
import com.example.jieleo.matierialdesigndemo.activity.SplashScreensActivity;
import com.example.jieleo.matierialdesigndemo.activity.TimePickerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.character_counter:
                startActivity(new Intent(this, CharacterCounterActivity.class));
                break;
            case R.id.splash_screen:
                startActivity(new Intent(this, SplashScreensActivity.class));
                break;
            case R.id.menu:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            case R.id.time_picker_dialog:
                startActivity(new Intent(this, TimePickerActivity.class));
                break;
            case R.id.rating_bar:
                startActivity(new Intent(this, RatingBarActivity.class));
                break;
        }
    }
}
