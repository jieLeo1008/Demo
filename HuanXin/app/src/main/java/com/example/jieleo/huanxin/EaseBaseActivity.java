package com.example.jieleo.huanxin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.hyphenate.easeui.controller.EaseUI;

/**
 * Created by OldFour on 2017/5/8.
 */

public class EaseBaseActivity extends FragmentActivity {

    protected InputMethodManager mInputMethodManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()){
            Intent intent=getIntent();
            String action=intent.getAction();
            if(intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)){
                finish();
                return;
            }
        }

        mInputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        EaseUI.getInstance().getNotifier().reset();
    }

    protected void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                mInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public void onBack(View view){
        finish();
    }
}
