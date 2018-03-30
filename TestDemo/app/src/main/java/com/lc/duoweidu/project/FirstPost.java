package com.lc.duoweidu.project;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.AsyPost;
import com.zcx.helper.http.AsyPostForm;
import com.zcx.helper.http.note.HttpServer;

import org.json.JSONObject;

/**
 * Created by Benny on 2018/3/19.
 */

@HttpServer(Conn.SERVICE_PATH)
public class FirstPost<T> extends AsyPostForm<T> {


    public FirstPost(AsyCallBack<T> asyCallBack) {
        super(asyCallBack);
    }

    @Override
    protected T parser(JSONObject object) throws Exception {
        return object.optString("success").equals("200") ? successParser(object) : null;
    }





    protected T successParser(JSONObject object){

        return null;

    }

}