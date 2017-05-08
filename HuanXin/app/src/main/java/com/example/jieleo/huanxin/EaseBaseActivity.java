package com.example.jieleo.huanxin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

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
        }
    }
}
