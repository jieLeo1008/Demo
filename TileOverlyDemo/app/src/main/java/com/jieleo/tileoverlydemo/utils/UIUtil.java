
package com.jieleo.tileoverlydemo.utils;

import android.content.Context;

import com.jieleo.tileoverlydemo.base.MyApp;


public class UIUtil {
    private static final String TAG = UIUtil.class.getSimpleName();

    public static int dp2Px(float dp) {
        return dp2Px(MyApp.getContext(), dp);
    }

    public static int px2Dp(float px) {
        return px2Dp(MyApp.getContext(), px);
    }

    public static int dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
