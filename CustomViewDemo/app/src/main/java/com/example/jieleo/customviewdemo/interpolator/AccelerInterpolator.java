package com.example.jieleo.customviewdemo.interpolator;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.BaseInterpolator;

/**
 * Created by YongJie on 2017/8/17.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
public class AccelerInterpolator extends BaseInterpolator  {
    @Override
    public float getInterpolation(float input) {
        return 0;

    }
}
