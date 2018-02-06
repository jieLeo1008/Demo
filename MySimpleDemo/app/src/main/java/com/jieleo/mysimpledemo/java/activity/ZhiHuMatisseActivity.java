package com.jieleo.mysimpledemo.java.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jieleo.mysimpledemo.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

/**
 * Created by Benny on 2017/10/30.
 */

public class ZhiHuMatisseActivity extends BaseActivity {

    private EditText mEditText;

    private Button mButton;
    private int REQUEST_CODE_CHOOSE=200;

    private List<Uri> selected;

    @Override
    public int bindLayout() {
        return R.layout.activity_zhi_hu_mastiise;
    }

    @Override
    public void initView() {
        mEditText= (EditText) findViewById(R.id.get_num);

        mButton= (Button) findViewById(R.id.to_matisse);

    }

    @Override
    public void initDate() {

    }

    @Override
    public void bindEvent() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMatisse();
            }
        });
    }

    private void toMatisse() {
        Matisse.from(this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(9)
                .gridExpectedSize(getResources().getDimensionPixelOffset(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_CHOOSE&&resultCode==RESULT_OK){
            selected=Matisse.obtainResult(data);
            for (Uri uri : selected) {
                Log.d("ZhiHuMatisseActivity", uri.toString());
            }
        }
    }
}
