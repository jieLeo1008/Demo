package com.lc.duoweidu.project;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.note.HttpInlet;

import org.json.JSONObject;

import java.io.File;

/**
 * Created by Benny on 2018/3/19.
 */
@HttpInlet(Conn.TASK)
public class TestPost extends FirstPost<TestPost.PostInfo>{

    public byte[] img;



    public TestPost(AsyCallBack<PostInfo> asyCallBack) {
        super(asyCallBack);
    }


    @Override
    protected PostInfo parser(JSONObject object) {

        return new PostInfo();
    }

    public static class PostInfo{

        /**
         * success : 200
         * message : 成功
         */

        private String success;
        private String message;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
