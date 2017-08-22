package com.jieleo.videoplayer;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.video_view);

        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/VID_20170811_215605.mp4";

        /**
         * 本地播放
         */
        mVideoView.setVideoPath(path);


        /**
         * 网络播放
         */

//        mVideoView.setVideoURI(Uri.parse(""));


        /**
         * 使用MediaController
         */

        MediaController controller =new MediaController(this);

        /**
         * 设置VideoView与MediaController建立关联
         */

        mVideoView.setMediaController(controller);


        /**
         * 设置MediaController建立关联
         */

        controller.setMediaPlayer(mVideoView);
    }
}
