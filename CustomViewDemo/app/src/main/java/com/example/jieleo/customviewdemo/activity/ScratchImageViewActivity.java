package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import com.cooltechworks.views.ScratchImageView;
import com.cooltechworks.views.ScratchTextView;
import com.example.jieleo.customviewdemo.R;

public class ScratchImageViewActivity extends AppCompatActivity {


    ScratchImageView mScratchImageView;

    ScratchTextView mScratchTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch_image_view);

        mScratchImageView = (ScratchImageView) findViewById(R.id.scratch_image_view);

        mScratchTextView = (ScratchTextView) findViewById(R.id.scratch_text_view);

        mScratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView scratchImageView) {
                Log.d("ScratchImageViewActivit", "onRevealed");
            }

            @Override
            public void onRevealPercentChangedListener(ScratchImageView scratchImageView, float v) {
                Log.d("ScratchImageViewActivit", "onRevealPercent");
                Log.d("ScratchImageViewActivit", "v:" + v);

                if (v>0.5){
                    //去除覆盖层
                    mScratchImageView.clear();
                }
            }
        });


        mScratchTextView.setText("你太差了  赶紧走");
        mScratchTextView.setTextSize(50f);
        mScratchTextView.setGravity(Gravity.CENTER);
        mScratchTextView.setRevealListener(new ScratchTextView.IRevealListener() {
            @Override
            public void onRevealed(ScratchTextView scratchTextView) {

            }

            @Override
            public void onRevealPercentChangedListener(ScratchTextView scratchTextView, float v) {

            }
        });


    }
}
