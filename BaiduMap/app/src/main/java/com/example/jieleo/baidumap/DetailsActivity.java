package com.example.jieleo.baidumap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final Intent intent =getIntent();

        mTextView = (TextView) findViewById(R.id.tv_01);
        mTextView.setText(intent.getStringExtra("xx"));
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(DetailsActivity.this,SecondMapActivity.class);
                intent1.putExtra("Lat",intent.getDoubleExtra("Lat",0));
                intent1.putExtra("Lng",intent.getDoubleExtra("Lng",0));
                startActivity(intent1);
                finish();
            }
        });
    }
}
