package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jieleo.customviewdemo.R;

import cn.bingoogolapple.badgeview.BGABadgeTextView;

public class BGABadgeViewActivity extends AppCompatActivity {

    private BGABadgeTextView mBGABadgeTextView;
    private Button showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgabadge_view);
        mBGABadgeTextView = (BGABadgeTextView) findViewById(R.id.tv_01);
        showBtn = (Button) findViewById(R.id.btn_01);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBGABadgeTextView.isShowBadge()){
                    mBGABadgeTextView.hiddenBadge();
                }else {
                    mBGABadgeTextView.showTextBadge("哈哈哈");
//                    mBGABadgeTextView.showCirclePointBadge();
                }
            }
        });
    }
}
