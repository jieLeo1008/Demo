package com.example.jieleo.customviewdemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StarAnimActivity extends AppCompatActivity {

    @InjectView(R.id.iv_01)
    ImageView mIv01;
    @InjectView(R.id.iv_02)
    ImageView mIv02;
    @InjectView(R.id.iv_03)
    ImageView mIv03;
    @InjectView(R.id.iv_04)
    ImageView mIv04;
    @InjectView(R.id.fla_btn)
    FloatingActionButton mFlaBtn;
    private boolean showing;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_anim);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.iv_01, R.id.iv_02, R.id.iv_03, R.id.iv_04, R.id.fla_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_01:

                Toast.makeText(this, "点我干啥", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_02:


                break;
            case R.id.iv_03:

                break;
            case R.id.iv_04:

                break;
            case R.id.fla_btn:



                if (System.currentTimeMillis() - lastTime < 300 && lastTime != 0) {
                    Toast.makeText(this, "点那么快干啥", Toast.LENGTH_SHORT).show();
                    lastTime = System.currentTimeMillis();
                    break;
                }

                if (showing) {

                    ObjectAnimator iv1X = ObjectAnimator.ofFloat(mIv01, "translationX", -300F, 0F);
                    ObjectAnimator iv1Y = ObjectAnimator.ofFloat(mIv01, "translationY", -200F, 0F);
                    ObjectAnimator iv1R = ObjectAnimator.ofFloat(mIv01, "rotation", 0F, 360F);
                    ObjectAnimator iv2X = ObjectAnimator.ofFloat(mIv02, "translationX", -120F, 0F);
                    ObjectAnimator iv2Y = ObjectAnimator.ofFloat(mIv02, "translationY", -300F, 0F);
                    ObjectAnimator iv2R = ObjectAnimator.ofFloat(mIv02, "rotation", 0F, 360F);
                    ObjectAnimator iv3X = ObjectAnimator.ofFloat(mIv03, "translationX", 120F, 0F);
                    ObjectAnimator iv3Y = ObjectAnimator.ofFloat(mIv03, "translationY", -300F, 0F);
                    ObjectAnimator iv3R = ObjectAnimator.ofFloat(mIv03, "rotation", 0F, 360F);
                    ObjectAnimator iv4X = ObjectAnimator.ofFloat(mIv04, "translationX", 300F, 0F);
                    ObjectAnimator iv4Y = ObjectAnimator.ofFloat(mIv04, "translationY", -200F, 0F);
                    ObjectAnimator iv4R = ObjectAnimator.ofFloat(mIv04, "rotation", 0F, 360F);


                    AnimatorSet animatorSet1 = new AnimatorSet();
                    animatorSet1.setDuration(1500);
                    animatorSet1.setInterpolator(new Interpolator() {
                        @Override
                        public float getInterpolation(float input) {
                            return input*input*input*input*input;
                        }
                    });
                    animatorSet1.playTogether(iv1X, iv1Y, iv1R, iv2X, iv2Y, iv2R, iv3X, iv3Y, iv3R, iv4R, iv4X, iv4Y);
                    animatorSet1.start();
                    showing = false;

                } else {
                    ObjectAnimator iv1X = ObjectAnimator.ofFloat(mIv01, "translationX", 0F, -300F);
                    ObjectAnimator iv1Y = ObjectAnimator.ofFloat(mIv01, "translationY", 0F, -200F);
                    ObjectAnimator iv1R = ObjectAnimator.ofFloat(mIv01, "rotation", 0F, 360F);
                    ObjectAnimator iv2X = ObjectAnimator.ofFloat(mIv02, "translationX", 0F, -120F);
                    ObjectAnimator iv2Y = ObjectAnimator.ofFloat(mIv02, "translationY", 0F, -300F);
                    ObjectAnimator iv2R = ObjectAnimator.ofFloat(mIv02, "rotation", 0F, 360F);
                    ObjectAnimator iv3X = ObjectAnimator.ofFloat(mIv03, "translationX", 0F, 120F);
                    ObjectAnimator iv3Y = ObjectAnimator.ofFloat(mIv03, "translationY", 0F, -300F);
                    ObjectAnimator iv3R = ObjectAnimator.ofFloat(mIv03, "rotation", 0F, 360F);
                    ObjectAnimator iv4X = ObjectAnimator.ofFloat(mIv04, "translationX", 0F, 300F);
                    ObjectAnimator iv4Y = ObjectAnimator.ofFloat(mIv04, "translationY", 0F, -200F);
                    ObjectAnimator iv4R = ObjectAnimator.ofFloat(mIv04, "rotation", 0F, 360F);


                    AnimatorSet animatorSet1 = new AnimatorSet();
                    animatorSet1.setDuration(1500);
                    animatorSet1.setInterpolator(new Interpolator() {
                        @Override
                        public float getInterpolation(float input) {
                            return input*input*input;
                        }
                    });
                    animatorSet1.playTogether(iv1X, iv1Y, iv1R, iv2X, iv2Y, iv2R, iv3X, iv3Y, iv3R, iv4R, iv4X, iv4Y);
                    animatorSet1.start();

                    showing = true;
                }

                lastTime = System.currentTimeMillis();

                break;
        }
    }
}
