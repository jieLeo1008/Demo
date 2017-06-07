package com.example.jieleo.customviewdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.password_view:
                break;
            case R.id.item_decoration:
                startActivity(new Intent(this,ItemDecorationActivity.class));
                break;
            case R.id.object_animator:
                startActivity(new Intent(this,ObjectAnimatorActivity.class));
                break;
            case R.id.bga_aty:
                startActivity(new Intent(this,BGABadgeViewActivity.class));
                break;
            case R.id.text_input_layout:
                startActivity(new Intent(this,TextInputLayoutActivity.class));
                break;
            case R.id.caipiao:
                startActivity(new Intent(this,CaiPiaoActivity.class));
                break;
            case R.id.catulator:
                startActivity(new Intent(this,CatulatorActivity.class));
                break;
            case R.id.awesome_qr_code:
                startActivity(new Intent(this,QRCodeActivity.class));
                break;
            case R.id.dlt:
                startActivity(new Intent(this,DLTActivity.class));
                break;
            case R.id.bitmap_size:
                startActivity(new Intent(this,CatulatorBitmapActivity.class));
                break;
        }
    }

}
