package com.example.jieleo.customviewdemo.view.password_view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by OldFour on 2017/5/17.
 */

public class PassWordView extends View{
    private Mode mMode;//样式模式
    private int passwordLength;//密码个数
    private long cursorFlashTime;//光标闪动间隔时间
    private int passwordPading;//每个密码之间的间隔
    private int passwordSize=dp2px(40);
    private int borderColor;//边框颜色
    private int borderWidth;//下划线粗细
    private int cursorPosition;//光标位置
    private int cursorWidth;//光标粗细
    private int cursorHeight;//光标长度
    private int cursorColor;//光标颜色
    private boolean isCursorShowing;//光标是否正在显示
    private boolean isCursorEnable;//是否开启光标
    private boolean isInPutComplete;//是否输入完毕
    private int chiperTextSize;//密文符号大小
    private boolean isChiperEnable;//是否开启密文
    private static String CIPHER_TEXT = "*"; //密文符号
    private String[] password;//密码数组

    private InputMethodManager inputManager;
//    private PasswordListener passwordListener;
    private Paint paint;
    private Timer timer;
    private TimerTask timerTask;

    public PassWordView(Context context) {
        super(context);
    }

    public Mode getMode() {
        return mMode;
    }

    public PassWordView setMode(Mode mode) {
        mMode = mode;
        return this;
    }


    public enum Mode {
        /**
         * 下划线样式
         */
        UNDERLINE(0),

        /**
         * 边框样式
         */
        RECT(1);
        private int mode;

        Mode(int mode) {
            this.mode = mode;
        }

        public int getMode() {
            return this.mode;
        }

        static Mode formMode(int mode) {
            for (Mode m : values()) {
                if (mode == m.mode) {
                    return m;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public PassWordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        readAttributeSet(attrs);
    }

    private void readAttributeSet(AttributeSet attrs) {


    }

    private int dp2px(float dp) {
        float scale=getContext().getResources().getDisplayMetrics().density;
        return (int)(dp*scale+0.5f);
    }


}
