package com.example.jieleo.customviewdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jieleo.customviewdemo.R;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private ImageView mImageView,mImageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animatior);
        mImageView = (ImageView) findViewById(R.id.iv_01);
        mImageView1 = (ImageView) findViewById(R.id.iv_02);
        ObjectAnimator animator=ObjectAnimator.ofFloat(mImageView,"translationX",0F,300F);
        ObjectAnimator animator1=ObjectAnimator.ofFloat(mImageView,"translationY",0F,500F);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(mImageView,"rotation",720F,0F);
        ObjectAnimator animator5=ObjectAnimator.ofFloat(mImageView1,"rotation",360F,0F);
        AnimatorSet set=new AnimatorSet();
        AnimatorSet set1 =new AnimatorSet();
        set.playTogether(animator,animator5);

//        set.play(animator2).after(animator1);
        set.setDuration(2000).start();

//        animator2.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                ObjectAnimator animator3 =ObjectAnimator.ofFloat(mImageView,"scaleX",1F,5F,2F);
//                ObjectAnimator animator4=ObjectAnimator.ofFloat(mImageView,"scaleY",1F,2F,2F);
//                AnimatorSet animatorSet=new AnimatorSet();
//                animatorSet.play(animator3).before(animator4);
//                animatorSet.setDuration(1000).start();
//            }
//        });



    }
}
