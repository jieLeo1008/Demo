package com.lc.duoweidu.project;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lc.duoweidu.project.util.Utils;
import com.zcx.helper.activity.AppActivity;
import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.util.UtilBase64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class PostTestActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_test);

        final File file =new File("/storage/20CB-1C14/DCIM/Camera/VID_20180315_213729.mp4");
        final File filesss =new File("/storage/emulated/0/trimmedVideo_20180331_113616.mp4");
        final File filess =new File("/storage/emulated/0/bluetooth/1522480674658.mp4");
        final File files =new File(" /storage/emulated/0/Android/data/com.iknow.android/cachetrimmedVideo_20180319_100710.mp4");

        findViewById(R.id.post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestPost.img=File2byte("/storage/emulated/0/bluetooth/1522480674658.mp4");
                mTestPost.execute();
            }
        });

//        byte[] out =new byte[1024*4];
//
//        try {
//            InputStream inputStream =new FileInputStream("/storage/emulated/0/trimmedVideo_20180331_113616.mp4");
//
//
//            ByteArrayOutputStream baos =new ByteArrayOutputStream();
//
//            byte[] buffer =new byte[1024*4];
//
//            int n=0;
//
//            while ((n=inputStream.read(buffer) )!=-1){
//                baos.write(buffer,0,n);
//            }
//
//            out=baos.toByteArray();
//
//            inputStream.close();
//
//            baos.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        final byte[] finalOut = out;


//        final String a=Utils.fileToBase64(filess);
//        Log.d("PostTestActivity", a);
//
//        final String c=a.substring(0,100000);
//
//        Log.d("PostTestActivity", "a.length():" + a.length());
        findViewById(R.id.base64post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Base64TestAsyPost(new AsyCallBack<Base64TestAsyPost.PostInfo>(){


                }).
                        setImg(filess)
//                        setImg(UtilBase64.encodeBase64File("/storage/emulated/0/trimmedVideo_20180331_113616.mp4"))
//                        setImg(com.lc.duoweidu.project.face.Base64.encode(finalOut))
                        .execute();

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



    public  byte[] File2byte(String filePath)
    {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.d("PostTestActivity", "buffer:" + buffer);
        return buffer;
    }

}
