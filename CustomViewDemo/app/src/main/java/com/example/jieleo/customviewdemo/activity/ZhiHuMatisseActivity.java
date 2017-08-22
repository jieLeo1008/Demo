package com.example.jieleo.customviewdemo.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jieleo.customviewdemo.R;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ZhiHuMatisseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu_matisse);

        findViewById(R.id.zhi_hu_style).setOnClickListener(this);
        findViewById(R.id.dracule_style).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {

        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                        switch (v.getId()) {
                            case R.id.zhi_hu_style:
                                Matisse.from(ZhiHuMatisseActivity.this)
                                        .choose(MimeType.ofAll(), false)
                                        .countable(true)
                                        .capture(true)
                                        .captureStrategy(new CaptureStrategy(true, "com.example.jieleo.customviewdemo.fileprovdier"))
                                        .maxSelectable(9)
                                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                        .thumbnailScale(0.85f)
                                        .imageEngine(new GlideEngine())
                                        .forResult(REQUEST_CODE);


                                break;
                            case R.id.dracule_style:


                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> paths = Matisse.obtainPathResult(data);
            List<Uri> uris=Matisse.obtainResult(data);

            for (Uri uri : uris) {
                Log.d("ZhiHuMatisseActivity", "uri:" + uri);
            }
            for (String path : paths) {
                Log.d("ZhiHuMatisseActivity", path);
            }
        }
    }
}
