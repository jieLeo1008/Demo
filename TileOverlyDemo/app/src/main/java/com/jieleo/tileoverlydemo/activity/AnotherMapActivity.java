package com.jieleo.tileoverlydemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.base.MyApp;

public class AnotherMapActivity extends AppCompatActivity {


    private LinearLayout mImageView;
    private TextureMapView mMapView;
    private TabLayout mTabLayout;
    private Button mButton;
    private Button closeBtn;
private RelativeLayout rl01;

    private BaiduMap mBaiduMap;
    private int mA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_map);
        mMapView = (TextureMapView) findViewById(R.id.map_view);
        mImageView = (LinearLayout) findViewById(R.id.iv_01);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mButton = (Button) findViewById(R.id.btn_01);
        closeBtn = (Button) findViewById(R.id.btn_02);
        mBaiduMap=mMapView.getMap();
//        Display display =this.getWindowManager().getDefaultDisplay();
//        int height=display.getHeight();
//        int width =display.getWidth();

//        LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(width,height);
//        mMapView.setLayoutParams(layoutParams);
        final TranslateAnimation translateAnimation =new TranslateAnimation(0,0,0,0);
        translateAnimation.setDuration(1000);
//        translateAnimation.setFillAfter(true);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation =AnimationUtils.loadAnimation(AnotherMapActivity.this,R.anim.hide_anim);
//                animation.setFillAfter(true);
//                mMapView.startAnimation(translateAnimation);


//                rl01.startAnimation(translateAnimation);
//               MapStatus ma = mBaiduMap.getMapStatus();
//                animClose(mMapView);
//                animOpen(mImageView);

//                animOpen(mMapView);


                ObjectAnimator animator=ObjectAnimator.ofFloat(mMapView,"translationY",0,500f,500f);
                animator.setDuration(2000);
                animator.start();

            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator an =ObjectAnimator.ofFloat(mMapView,"translationY",500f,0f,0f);
                an.setDuration(2000);
                an.start();
            }
        });




//        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                if (mImageView.getVisibility()==View.VISIBLE){
//                    animClose(mMapView);
//                }
//            }
//
//            @Override
//            public boolean onMapPoiClick(MapPoi mapPoi) {
//                return false;
//            }
//        });

//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
    }

    private void animOpen(View view){
        view.setVisibility(View.VISIBLE);
        mA = view.getHeight();
        ValueAnimator animator =createDropAnim(view, 1000,1920);
        animator.start();
    }


    private void animClose(final View view){
        int origHeight=view.getHeight();
        ValueAnimator animator =createDropAnim(view,1000,500);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                view.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    /**
     * 使用动画的方式来改变高度解决Visible不一闪而过出现
     * @param view  view
     * @param start 初始状态值
     * @param end   结束状态值
     * @return
     */
    private ValueAnimator createDropAnim(final View view, int start, int end){
        ValueAnimator animator =ValueAnimator.ofInt(start,end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =view.getLayoutParams();
                layoutParams.height=value;
                view.setLayoutParams(layoutParams);
            }
        });
        animator.setDuration(1500);
        return animator;
    }

}
