package com.jieleo.neteaselivingstreamdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.netease.LSMediaCapture.lsLogUtil;
import com.netease.LSMediaCapture.lsMediaCapture;
import com.netease.LSMediaCapture.lsMessageHandler;
import com.netease.vcloud.video.render.NeteaseView;

import static com.netease.LSMediaCapture.lsMediaCapture.StreamType.AUDIO;

public class LivingStreamPullActivity extends AppCompatActivity implements lsMessageHandler, View.OnClickListener {


    private static final String TAG = "LivingStreamPullActivit";

    private String livingStreamURL;
    private boolean livingStreamOn;


    /**
     * 设置SDK相关参数
     */
    private boolean needWatermark;
    private boolean needGraffiti;
    private boolean useFilter;
    private lsMediaCapture mLsMediaCapture = null;
    private lsMediaCapture.LiveStreamingPara mLiveStreamingPara;


    //状态变量
    private boolean livingStreamInitFinished = false;
    private boolean m_liveStreamingOn = false;

    private boolean m_tryToStopLivestreaming = false;

    private boolean m_startVideoCamera = false;


    private ImageView playIv;


    private long mLastVideoProcessErrorAlertTime = 0;
    private long mLastAudioProcessErrorAlertTime = 0;

    private AudioManager mAudioManager;
    private boolean mGraffitiOn;
    private Thread mGraffitiThread;
    private boolean mFrontCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_stream_pull);

        playIv = (ImageView) findViewById(R.id.play_iv);

        playIv.setBackgroundResource(R.mipmap.restart);

        playIv.setOnClickListener(this);

        findViewById(R.id.switch_camera).setOnClickListener(this);
        findViewById(R.id.switch_camera).setBackgroundResource(R.mipmap.camera);


        //运行时高亮 不锁屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.screenBrightness = 0.7f;

        getWindow().setAttributes(params);


        /**
         * 上一个页面传的推流参数
         */

//        MainActivity.PublishParam param = (MainActivity.PublishParam) getIntent().getSerializableExtra("PushParam");

        livingStreamURL = "rtmp://pc53396cf.live.126.net/live/a34b4b39af3341d9b125896118008877?wsSecret=3216785b7c06391ffcbda1526c5abe67&wsTime=1504165140";

//        useFilter=param.useFilter;
//
//        needWatermark=param.watermark;
//
//        needGraffiti=param.graffitiOn;

        livingStreamOn = false;


        /**
         * 创建直播实例
         */

        lsMediaCapture.LsMediaCapturePara mediaCapturePara = new lsMediaCapture.LsMediaCapturePara();
        //设置SDK上下文  全局Context
        mediaCapturePara.setContext(MyApplication.getContext());
        //设置SDK消息回调
        mediaCapturePara.setMessageHandler(this);
        //设置日志级别
        mediaCapturePara.setLogLevel(lsLogUtil.LogLevel.INFO);
        //是否上传SDK日志
        mediaCapturePara.setUploadLog(false);

        mLsMediaCapture = new lsMediaCapture(mediaCapturePara);


        /**
         * 设置直播参数
         */

        mLiveStreamingPara = new lsMediaCapture.LiveStreamingPara();
        //设置推流类型  AV（音视频） 、AUDIO（单音频）、VIDEO（单视频）
        mLiveStreamingPara.setStreamType(lsMediaCapture.StreamType.AV);
        //设置推流格式  RTMP、MP4、RTMP_AND_MP4
        mLiveStreamingPara.setFormatType(lsMediaCapture.FormatType.RTMP);
        //formatType 为 MP4 或 RTMP_AND_MP4 时有效
        mLiveStreamingPara.setRecordPath("test");

        mLiveStreamingPara.setQosOn(false);


        /**
         * 预览参数设置
         */
        NeteaseView neteaseView = (NeteaseView) findViewById(R.id.net_ease_view);
//        if (param.streamType!= lsMediaCapture.StreamType.AUDIO){
        // 是否前置摄像头
        mFrontCamera = false;
        boolean mScale_16x9 = false; //是否强制16:9
        lsMediaCapture.VideoQuality videoQuality = lsMediaCapture.VideoQuality.HIGH; //视频模板（SUPER_HIGH 1280*720、SUPER 960*540、HIGH 640*480、MEDIUM 480*360、LOW 352*288）
        mLsMediaCapture.startVideoPreview(neteaseView, mFrontCamera, useFilter, videoQuality, mScale_16x9);
//        }


    }


    private void startAV() {
        //初始化直播
        livingStreamInitFinished = mLsMediaCapture.initLiveStream(mLiveStreamingPara, livingStreamURL);

        if (mLsMediaCapture != null && livingStreamInitFinished) {
            //开始直播
            mLsMediaCapture.startLiveStreaming();

            m_liveStreamingOn = true;


        }


    }


    //切换前后摄像头
    private void switchCamera() {
        if (mLsMediaCapture != null) {
            mLsMediaCapture.switchCamera();
        }
    }


    private void capture() {
        if (mLsMediaCapture != null) {
            mLsMediaCapture.enableScreenShot();
        }
    }

    private void stopAV() {
        Toast.makeText(this, "停止直播", Toast.LENGTH_SHORT).show();
        mGraffitiOn = false;
        if (mGraffitiThread != null) {
            try {
                mGraffitiThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (mLsMediaCapture != null) {
            mLsMediaCapture.stopLiveStreaming();
        }
    }

    private Toast mToast;

    private void showToast(final String text) {
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mToast.setText(text);
                    mToast.show();
                }
            });
        } else {
            mToast.setText(text);
            mToast.show();
        }
    }

    /**
     * 处理SDK抛上来的异常和事件，用户需要在这里监听各种消息，进行相应的处理。
     *
     * @param i
     * @param o
     */
    @Override
    public void handleMessage(int i, Object o) {
        switch (i) {
            case MSG_INIT_LIVESTREAMING_OUTFILE_ERROR://初始化直播出错
            case MSG_INIT_LIVESTREAMING_VIDEO_ERROR:
            case MSG_INIT_LIVESTREAMING_AUDIO_ERROR: {
                showToast("初始化直播出错");
                break;
            }
            case MSG_START_LIVESTREAMING_ERROR://开始直播出错
            {
                showToast("开始直播出错：" + o);
                break;
            }
            case MSG_STOP_LIVESTREAMING_ERROR://停止直播出错
            {
                if (m_liveStreamingOn) {
                    showToast("MSG_STOP_LIVESTREAMING_ERROR  停止直播出错");
                }
                break;
            }
            case MSG_AUDIO_PROCESS_ERROR://音频处理出错
            {
                if (m_liveStreamingOn && System.currentTimeMillis() - mLastAudioProcessErrorAlertTime >= 10000) {
                    showToast("音频处理出错");
                    mLastAudioProcessErrorAlertTime = System.currentTimeMillis();
                }

                break;
            }
            case MSG_VIDEO_PROCESS_ERROR://视频处理出错
            {
                if (m_liveStreamingOn && System.currentTimeMillis() - mLastVideoProcessErrorAlertTime >= 10000) {
                    showToast("视频处理出错");
                    mLastVideoProcessErrorAlertTime = System.currentTimeMillis();
                }
                break;
            }
            case MSG_START_PREVIEW_ERROR://视频预览出错，可能是获取不到camera的使用权限
            {
                Log.i(TAG, "test: in handleMessage, MSG_START_PREVIEW_ERROR");
                showToast("无法打开相机，可能没有相关的权限或者自定义分辨率不支持");
                break;
            }
            case MSG_AUDIO_RECORD_ERROR://音频采集出错，获取不到麦克风的使用权限
            {
                showToast("无法开启；录音，可能没有相关的权限");
                Log.i(TAG, "test: in handleMessage, MSG_AUDIO_RECORD_ERROR");
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        LiveStreamingActivity.this.finish();
//                    }
//                },3000);
                break;
            }
            case MSG_RTMP_URL_ERROR://断网消息
            {
                Log.i(TAG, "test: in handleMessage, MSG_RTMP_URL_ERROR");
                showToast("MSG_RTMP_URL_ERROR，推流已停止,正在退出当前界面");
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        LiveStreamingActivity.this.finish();
//                    }
//                },3000);
                break;
            }
            case MSG_URL_NOT_AUTH://直播URL非法，URL格式不符合视频云要求
            {
                showToast("MSG_URL_NOT_AUTH  直播地址不合法");
                break;
            }
            case MSG_SEND_STATICS_LOG_ERROR://发送统计信息出错
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SEND_STATICS_LOG_ERROR");
                break;
            }
            case MSG_SEND_HEARTBEAT_LOG_ERROR://发送心跳信息出错
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SEND_HEARTBEAT_LOG_ERROR");
                break;
            }
            case MSG_AUDIO_SAMPLE_RATE_NOT_SUPPORT_ERROR://音频采集参数不支持
            {
                Log.i(TAG, "test: in handleMessage, MSG_AUDIO_SAMPLE_RATE_NOT_SUPPORT_ERROR");
                break;
            }
            case MSG_AUDIO_PARAMETER_NOT_SUPPORT_BY_HARDWARE_ERROR://音频参数不支持
            {
                Log.i(TAG, "test: in handleMessage, MSG_AUDIO_PARAMETER_NOT_SUPPORT_BY_HARDWARE_ERROR");
                break;
            }
            case MSG_NEW_AUDIORECORD_INSTANCE_ERROR://音频实例初始化出错
            {
                Log.i(TAG, "test: in handleMessage, MSG_NEW_AUDIORECORD_INSTANCE_ERROR");
                break;
            }
            case MSG_AUDIO_START_RECORDING_ERROR://音频采集出错
            {
                Log.i(TAG, "test: in handleMessage, MSG_AUDIO_START_RECORDING_ERROR");
                break;
            }
            case MSG_QOS_TO_STOP_LIVESTREAMING://网络QoS极差，视频码率档次降到最低
            {
                showToast("MSG_QOS_TO_STOP_LIVESTREAMING");
                Log.i(TAG, "test: in handleMessage, MSG_QOS_TO_STOP_LIVESTREAMING");
                break;
            }
            case MSG_HW_VIDEO_PACKET_ERROR://视频硬件编码出错反馈消息
            {
                break;
            }
            case MSG_WATERMARK_INIT_ERROR://视频水印操作初始化出错
            {
                break;
            }
            case MSG_WATERMARK_PIC_OUT_OF_VIDEO_ERROR://视频水印图像超出原始视频出错
            {
                //Log.i(TAG, "test: in handleMessage: MSG_WATERMARK_PIC_OUT_OF_VIDEO_ERROR");
                break;
            }
            case MSG_WATERMARK_PARA_ERROR://视频水印参数设置出错
            {
                //Log.i(TAG, "test: in handleMessage: MSG_WATERMARK_PARA_ERROR");
                break;
            }
            case MSG_CAMERA_PREVIEW_SIZE_NOT_SUPPORT_ERROR://camera采集分辨率不支持
            {
                //Log.i(TAG, "test: in handleMessage: MSG_CAMERA_PREVIEW_SIZE_NOT_SUPPORT_ERROR");
                break;
            }
            case MSG_CAMERA_NOT_SUPPORT_FLASH:
                showToast("不支持闪光灯");
                break;
            case MSG_START_PREVIEW_FINISHED://camera采集预览完成
            {
                Log.i(TAG, "test: MSG_START_PREVIEW_FINISHED");
                break;
            }
            case MSG_START_LIVESTREAMING_FINISHED://开始直播完成
            {
                Log.i(TAG, "test: MSG_START_LIVESTREAMING_FINISHED");
                showToast("直播开始");
                m_liveStreamingOn = true;
//                startPauseResumeBtn.setClickable(true);
                break;
            }
            case MSG_STOP_LIVESTREAMING_FINISHED://停止直播完成
            {
                Log.i(TAG, "test: MSG_STOP_LIVESTREAMING_FINISHED");
                showToast("停止直播已完成");
                m_liveStreamingOn = false;
//                startPauseResumeBtn.setClickable(true);
//                {
//                    mIntentLiveStreamingStopFinished.putExtra("LiveStreamingStopFinished", 1);
//                    sendBroadcast(mIntentLiveStreamingStopFinished);
//                }

                break;
            }
            case MSG_STOP_VIDEO_CAPTURE_FINISHED: {
                Log.i(TAG, "test: in handleMessage: MSG_STOP_VIDEO_CAPTURE_FINISHED");
                break;
            }
            case MSG_STOP_AUDIO_CAPTURE_FINISHED: {
                Log.i(TAG, "test: in handleMessage: MSG_STOP_AUDIO_CAPTURE_FINISHED");
                break;
            }
            case MSG_SWITCH_CAMERA_FINISHED://切换摄像头完成
            {
//                int cameraId = (Integer) object;//切换之后的camera id
                break;
            }
            case MSG_SEND_STATICS_LOG_FINISHED://发送统计信息完成
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SEND_STATICS_LOG_FINISHED");
                break;
            }
            case MSG_SERVER_COMMAND_STOP_LIVESTREAMING://服务器下发停止直播的消息反馈，暂时不使用
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SERVER_COMMAND_STOP_LIVESTREAMING");
                break;
            }
            case MSG_GET_STATICS_INFO://获取统计信息的反馈消息
            {

//
//                Message message = Message.obtain(mHandler, MSG_GET_STATICS_INFO);
//                Statistics statistics = (Statistics) object;
//
//                Bundle bundle = new Bundle();
//                bundle.putInt("FR", statistics.videoEncodeFrameRate);
//                bundle.putInt("VBR", statistics.videoEncodeBitRate);
//                bundle.putInt("ABR", statistics.audioEncodeBitRate);
//                bundle.putInt("TBR", statistics.totalRealSendBitRate);
//                bundle.putString("resolution", statistics.videoEncodeWidth + " x " + statistics.videoEncodeHeight);
//                message.setData(bundle);
////				  Log.i(TAG, "test: audio : " + statistics.audioEncodeBitRate + "  video: " + statistics.videoEncodeBitRate + "  total: " + statistics.totalRealSendBitRate);
//
//                if(mHandler != null) {
//                    mHandler.sendMessage(message);
//                }
                break;
            }
            case MSG_BAD_NETWORK_DETECT://如果连续一段时间（10s）实际推流数据为0，会反馈这个错误消息
            {
                showToast("MSG_BAD_NETWORK_DETECT");
                //Log.i(TAG, "test: in handleMessage, MSG_BAD_NETWORK_DETECT");
                break;
            }
            case MSG_SCREENSHOT_FINISHED://视频截图完成后的消息反馈
            {
//                getScreenShotByteBuffer((Bitmap) object);

                break;
            }
            case MSG_SET_CAMERA_ID_ERROR://设置camera出错（对于只有一个摄像头的设备，如果调用了不存在的摄像头，会反馈这个错误消息）
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SET_CAMERA_ID_ERROR");
                break;
            }
            case MSG_SET_GRAFFITI_ERROR://设置涂鸦出错消息反馈
            {
                //Log.i(TAG, "test: in handleMessage, MSG_SET_GRAFFITI_ERROR");
                break;
            }
            case MSG_MIX_AUDIO_FINISHED://伴音一首MP3歌曲结束后的反馈
            {
                //Log.i(TAG, "test: in handleMessage, MSG_MIX_AUDIO_FINISHED");
                break;
            }
            case MSG_URL_FORMAT_NOT_RIGHT://推流url格式不正确
            {
                //Log.i(TAG, "test: in handleMessage, MSG_URL_FORMAT_NOT_RIGHT");
                showToast("MSG_URL_FORMAT_NOT_RIGHT");
                break;
            }
            case MSG_URL_IS_EMPTY://推流url为空
            {
                //Log.i(TAG, "test: in handleMessage, MSG_URL_IS_EMPTY");
                break;
            }

            case MSG_SPEED_CALC_SUCCESS:
            case MSG_SPEED_CALC_FAIL:
//                Message message = Message.obtain(mHandler, msg);
//                message.obj = object;
//                mHandler.sendMessage(message);
//                mSpeedCalcRunning = false;
                break;

            default:
                break;

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_iv:
                if (!m_liveStreamingOn) {

                    startAV();
                    m_liveStreamingOn = true;
                    playIv.setBackgroundResource(R.mipmap.stop);

                } else {

                    stopAV();
                    m_liveStreamingOn = false;
                    playIv.setBackgroundResource(R.mipmap.restart);

                }
                break;

            case R.id.switch_camera:


                switchCamera();


                break;
        }
    }


    @Override
    protected void onPause() {
        if (mLsMediaCapture != null) {
            if (!m_tryToStopLivestreaming && m_liveStreamingOn) {
                if (mLiveStreamingPara.getStreamType() != AUDIO) {
                    //推最后一帧图像
                    mLsMediaCapture.backgroundVideoEncode();
                } else {
                    //推静音帧
                    mLsMediaCapture.backgroundAudioEncode();
                }
            }
        }
        super.onPause();
    }


    @Override
    protected void onResume(){
        Log.i(TAG,"Activity onResume");
        super.onResume();
        if(mLsMediaCapture != null && m_liveStreamingOn) {
            if(mLiveStreamingPara.getStreamType() != AUDIO) {
                //关闭推流固定图像，正常推流
                mLsMediaCapture.resumeVideoEncode();
            }
            else  {
                //关闭推流静音帧
                mLsMediaCapture.resumeAudioEncode();
            }
        }
    }



    @Override
    protected void onDestroy() {
        Log.i(TAG,"activity onDestroy");


        //停止直播调用相关API接口
        if(mLsMediaCapture != null && m_liveStreamingOn) {

            //停止直播，释放资源
            stopAV();

            //如果音视频或者单独视频直播，需要关闭视频预览
            if(m_startVideoCamera)
            {
                mLsMediaCapture.stopVideoPreview();
                mLsMediaCapture.destroyVideoPreview();
            }

            //反初始化推流实例，当它与stopLiveStreaming连续调用时，参数为false
            mLsMediaCapture.uninitLsMediaCapture(false);
            mLsMediaCapture = null;

        }
        else if(mLsMediaCapture != null && m_startVideoCamera)
        {
            mLsMediaCapture.stopVideoPreview();
            mLsMediaCapture.destroyVideoPreview();

            //反初始化推流实例，当它不与stopLiveStreaming连续调用时，参数为true
            mLsMediaCapture.uninitLsMediaCapture(true);
            mLsMediaCapture = null;

        }


        if(m_liveStreamingOn) {
            m_liveStreamingOn = false;
        }

        super.onDestroy();
    }
    //用于接收Service发送的消息，伴音音量
    public class audioMixVolumeMsgReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            int audioMixVolumeMsg = intent.getIntExtra("AudioMixVolumeMSG", 0);

            //伴音音量的控制
            int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            int maxStreamVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

            streamVolume = audioMixVolumeMsg * maxStreamVolume / 10;
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, streamVolume, 1);
        }
    }
}
