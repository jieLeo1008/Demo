package com.example.jieleo.customviewdemo;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.hyphenate.chat.ChatClient;
import com.hyphenate.helpdesk.easeui.UIProvider;


/**
 * Created by YongJie on 2017/8/7.
 */

public class MyApp extends MultiDexApplication {

    public static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
//        ChatClient.getInstance().init(this,new ChatClient.Options().setAppkey("1436170824061061#kefuchannelapp46533").setTenantId("46533"));

        ChatClient.Options options = new ChatClient.Options();
        options.setAppkey("1434170824061114#kefuchannelapp46524");//必填项，appkey获取地址：kefu.easemob.com，“管理员模式 > 渠道管理 > 手机APP”页面的关联的“AppKey”
        options.setTenantId("46524");//必填项，tenantId获取地址：kefu.easemob.com，“管理员模式 > 设置 > 企业信息”页面的“租户ID”

        // Kefu SDK 初始化
        if (!ChatClient.getInstance().init(this, options)){
            return;
        }
        // Kefu EaseUI的初始化
        UIProvider.getInstance().init(this);
        ChatClient.getInstance().setDebugMode(true);

    }

    public static Context getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);



    }
}
