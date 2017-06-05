package com.example.jieleo.matierialdesigndemo.activity;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TimePicker;

import com.example.jieleo.matierialdesigndemo.R;

public class TimePickerActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this,R.style.MyDiaLogTheme,this,0,0,true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("TimePickerActivity", "hourOfDay:" + hourOfDay);
        Log.d("TimePickerActivity", "minute:" + minute);
    }

}
