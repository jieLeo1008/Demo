package com.lc.duoweidu.project.face;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.nfc.Tag;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.arcsoft.ageestimation.ASAE_FSDKAge;
import com.arcsoft.ageestimation.ASAE_FSDKEngine;
import com.arcsoft.ageestimation.ASAE_FSDKVersion;
import com.arcsoft.facedetection.AFD_FSDKEngine;
import com.arcsoft.facedetection.AFD_FSDKError;
import com.arcsoft.facedetection.AFD_FSDKFace;
import com.arcsoft.facedetection.AFD_FSDKVersion;
import com.arcsoft.facetracking.AFT_FSDKEngine;
import com.arcsoft.facetracking.AFT_FSDKError;
import com.arcsoft.facetracking.AFT_FSDKFace;
import com.arcsoft.facetracking.AFT_FSDKVersion;
import com.arcsoft.genderestimation.ASGE_FSDKEngine;
import com.arcsoft.genderestimation.ASGE_FSDKGender;
import com.arcsoft.genderestimation.ASGE_FSDKVersion;
import com.guo.android_extend.image.ImageConverter;
import com.guo.android_extend.tools.CameraHelper;
import com.guo.android_extend.widget.CameraFrameData;
import com.guo.android_extend.widget.CameraGLSurfaceView;
import com.guo.android_extend.widget.CameraSurfaceView;
import com.lc.duoweidu.project.R;

import java.util.ArrayList;
import java.util.List;

public class DericetActivity extends Activity implements CameraSurfaceView.OnCameraListener, View.OnTouchListener, Camera.AutoFocusCallback {

    private CameraSurfaceView mSurfaceView;
    private CameraGLSurfaceView mGLSurfaceView;

    private ImageView mImageView;
    private Camera mCamera;

    private int mWidth, mHeight, mFormat;
    AFT_FSDKEngine engine = new AFT_FSDKEngine();
    AFT_FSDKVersion version = new AFT_FSDKVersion();
    List<AFT_FSDKFace> result = new ArrayList<>();


    int mCameraID;
    int mCameraRotate;
    boolean mCameraMirror;
    byte[] mImageNV21 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWidth = 1280;
        mHeight = 960;
        mFormat = ImageFormat.NV21;
        setContentView(R.layout.activity_dericet);
        mGLSurfaceView = findViewById(R.id.glsurfaceView);
        mGLSurfaceView.setOnTouchListener(this);
        mSurfaceView = findViewById(R.id.surfaceView);
        mImageView = findViewById(R.id.iv01);
        mSurfaceView.setOnCameraListener(this);
        mSurfaceView.setupGLSurafceView(mGLSurfaceView, true, true, 270);
        mSurfaceView.debug_print_fps(true, false);
        AFT_FSDKError error = engine.AFT_FSDK_InitialFaceEngine(FaceDB.appid, FaceDB.ft_key, AFT_FSDKEngine.CP_PAF_NV21, 16, 5);


        AFT_FSDKError error1 = engine.AFT_FSDK_GetVersion(version);

    }

    @Override
    public Camera setupCamera() {

        mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewSize(mWidth, mHeight);
            parameters.setPreviewFormat(mFormat);

            for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
//                Log.d(TAG, "SIZE:" + size.width + "x" + size.height);
            }
            for (Integer format : parameters.getSupportedPreviewFormats()) {
//                Log.d(TAG, "FORMAT:" + format);
            }

            List<int[]> fps = parameters.getSupportedPreviewFpsRange();
            for (int[] count : fps) {
//                Log.d(TAG, "T:");
                for (int data : count) {
//                    Log.d(TAG, "V=" + data);
                }
            }
            //parameters.setPreviewFpsRange(15000, 30000);
            //parameters.setExposureCompensation(parameters.getMaxExposureCompensation());
            //parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
            //parameters.setAntibanding(Camera.Parameters.ANTIBANDING_AUTO);
            //parmeters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            //parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
            //parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
            mCamera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mCamera != null) {
            mWidth = mCamera.getParameters().getPreviewSize().width;
            mHeight = mCamera.getParameters().getPreviewSize().height;
        }
        return mCamera;

    }

    @Override
    public void setupChanged(int format, int width, int height) {

    }

    @Override
    public boolean startPreviewLater() {
        return false;
    }

    @Override
    public Object onPreview(byte[] data, int width, int height, int format, long timestamp) {


        AFT_FSDKError error2 = engine.AFT_FSDK_FaceFeatureDetect(data, width, height, AFT_FSDKEngine.CP_PAF_NV21, result);


        Log.d("DericetActivity", "error2.getCode():" + error2.getCode());

        Log.d("DericetActivity", "result.size():" + result.size());


        result.clear();
        return null;
    }

    @Override
    public void onBeforeRender(CameraFrameData data) {

    }

    @Override
    public void onAfterRender(CameraFrameData data) {
//        mGLSurfaceView.getGLES2Render().draw_rect((Rect[])data.getParams(), Color.GREEN, 2);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        CameraHelper.touchFocus(mCamera, event, v, this);
        return false;
    }

    @Override
    public void onAutoFocus(boolean success, Camera camera) {
        if (success) {
            Log.d("DericetActivity", "AutoFocus_Success");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
