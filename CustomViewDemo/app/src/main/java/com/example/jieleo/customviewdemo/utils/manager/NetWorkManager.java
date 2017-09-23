package com.example.jieleo.customviewdemo.utils.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by YongJie on 2017/9/5.
 */

public class NetWorkManager {

    private static NetWorkManager Instance;

    public static final int WIFI_STATE=1;

    public static final int GPRS_STATE=0;



    public static NetWorkManager getInstance() {
        if (Instance == null) {
            synchronized (NetWorkManager.class) {
                if (Instance == null) {
                    Instance = new NetWorkManager();
                }
            }
        }
        return Instance;
    }

    private NetWorkManager() {

    }


    /**
     * 判断当前网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }


    /**
     * 判断wifi状态是否可用
     *
     * @param context
     * @return
     */
    public boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo wifiNetWorkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (wifiNetWorkInfo != null) {
                return wifiNetWorkInfo.isAvailable();
            }
        }
        return false;
    }


    /**
     * 判断当前移动网络是否可用
     * @param context
     * @return
     */
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前的网络类型
     * @param context
     * @return
     */
    public int getConnectType(Context context){
        if (context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();

            if (networkInfo!=null&&networkInfo.isAvailable()){
                return networkInfo.getType();
            }
        }
        return -1;
    }

}
