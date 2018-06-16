package com.lc.duoweidu.project;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.note.HttpInlet;

import org.json.JSONObject;

import java.io.File;


/**
 * Created by Benny on 2018/3/31.
 */
@HttpInlet(Conn.TASK)
public class Base64TestAsyPost  extends Base64Post<Base64TestAsyPost.PostInfo>{
    public File img;


    public Base64TestAsyPost setImg(File img) {
        this.img = img;
        return this;
    }

    public Base64TestAsyPost(AsyCallBack<PostInfo> asyCallBack) {
        super(asyCallBack);
    }

    @Override
    protected PostInfo parser(JSONObject object) throws Exception {



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
