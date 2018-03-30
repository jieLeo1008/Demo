package com.lc.duoweidu.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zcx.helper.activity.AppActivity;
import com.zcx.helper.http.AsyCallBack;

import java.io.File;

public class PostTestActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_test);

        final File file =new File("/storage/20CB-1C14/DCIM/Camera/VID_20180315_213729.mp4");
        final File files =new File(" /storage/emulated/0/Android/data/com.iknow.android/cachetrimmedVideo_20180319_100710.mp4");

        findViewById(R.id.post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestPost.img=file;
                mTestPost.execute();
            }
        });


    }

    TestPost mTestPost = new TestPost(new AsyCallBack<TestPost.PostInfo>(){
        @Override
        public void onSuccess(String toast, int type, TestPost.PostInfo postInfo) throws Exception {
            super.onSuccess(toast, type, postInfo);

        }

        @Override
        public void onFail(String toast, int type) throws Exception {
            super.onFail(toast, type);

        }
    });
}
