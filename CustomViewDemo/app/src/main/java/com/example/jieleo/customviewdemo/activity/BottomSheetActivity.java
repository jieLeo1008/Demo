package com.example.jieleo.customviewdemo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jieleo.customviewdemo.R;

public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener {

//    private BottomSheetBehavior mBehavior;



    private Button mShowBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);


//        mBehavior = BottomSheetBehavior.from(findViewById(R.id.nest_scroll_view));
//
//
//        findViewById(R.id.btn_01).setOnClickListener(this);
//
//
//        /**
//         * CallBack监听BottomSheet
//         */
//        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                Log.d("BottomSheetActivity", "newState:" + newState);
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                Log.d("BottomSheetActivity", "slideOffset:" + slideOffset);
//            }
//        });

        //获取到Bottom Sheet对象
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mShowBottomSheet = (Button) findViewById(R.id.button);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btn_01:
//                /**
//                 * 判断状态  设置State
//                 */
//                if (mBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
//
//                    mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//
//                }else {
//
//                    mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//
//                }
//                break;
        }
    }

    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mShowBottomSheet.setText("隐藏布局");
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            mShowBottomSheet.setText("显示布局");
        }
    }


}
