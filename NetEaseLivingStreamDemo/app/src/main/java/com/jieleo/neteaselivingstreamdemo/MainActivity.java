package com.jieleo.neteaselivingstreamdemo;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.netease.LSMediaCapture.lsMediaCapture;
import com.netease.LSMediaCapture.util.string.StringUtil;
import com.netease.vcloud.video.effect.VideoEffect;

import java.io.Serializable;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

import static com.netease.LSMediaCapture.lsMediaCapture.FormatType.RTMP;
import static com.netease.LSMediaCapture.lsMediaCapture.StreamType.AV;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PublishParam publishParam = null;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.to_AV).setOnClickListener(this);
        findViewById(R.id.to_QR_code).setOnClickListener(this);

        publishParam = new PublishParam();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.to_AV:

                publishParam.pushUrl = "rtmp://pc53396cf.live.126.net/live/a34b4b39af3341d9b125896118008877?wsSecret=3216785b7c06391ffcbda1526c5abe67&wsTime=1504165140";
                publishParam.streamType = lsMediaCapture.StreamType.AV;
                publishParam.useFilter = false;
                publishParam.graffitiOn = false;
                publishParam.watermark = false;
                publishParam.frontCamera = true;
                publishParam.formatType = lsMediaCapture.FormatType.RTMP;
                publishParam.videoQuality = lsMediaCapture.VideoQuality.HIGH;
                publishParam.isScale_16x9 = true;


                mIntent = new Intent(MainActivity.this, LivingStreamPullActivity.class);
                mIntent.putExtra("data", publishParam);


                PermissionGen.needPermission(this, 100, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE});

                break;
            case R.id.to_QR_code:
                startActivity(new Intent(this,MyQRcodeActivity.class));


                break;
        }
    }


    /**
     * 推流参数设置
     */
    public static class PublishParam implements Serializable {
        String pushUrl = null; //推流地址
        lsMediaCapture.StreamType streamType = AV;  // 推流类型
        lsMediaCapture.FormatType formatType = RTMP; // 推流格式
        String recordPath; //文件录制地址，当formatType 为 MP4 或 RTMP_AND_MP4 时有效
        lsMediaCapture.VideoQuality videoQuality = lsMediaCapture.VideoQuality.HIGH; //清晰度
        boolean isScale_16x9 = false; //是否强制16:9
        boolean useFilter = true; //是否使用滤镜
        VideoEffect.FilterType filterType = VideoEffect.FilterType.clean; //滤镜类型
        boolean frontCamera = true; //是否默认前置摄像头
        boolean watermark = false; //是否添加水印
        boolean qosEnable = true;  //是否开启QOS
        boolean graffitiOn = false; //是否添加涂鸦
        boolean uploadLog = true; //是否上传SDK运行日志

    }


    @PermissionSuccess(requestCode = 100)
    public void success() {
        startActivity(mIntent);

    }

    @PermissionFail(requestCode = 100)
    public void failed(){

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionGen.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
}
