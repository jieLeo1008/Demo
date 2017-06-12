package com.sishuai.permissiondemo.permisson;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sishuai on 2017/3/30.
 */

public class MPermission {
    private MPermission(){

    }

    /**
     * 对外提供的申请权限的方法
     * @param activity      //请求的对象
     * @param requestCode   //请求码
     * @param permissions   //请求的权限列表
     */
    public static void needPermission(Activity activity, int requestCode,String... permissions){
        requestPermission(activity,requestCode,permissions);
    }
    public static void needPermission(Fragment fragment, int requestCode, String... permissions){
        requestPermission(fragment,requestCode,permissions);
    }
    /**
     * 内部真的权限请求方法
     * @param object        //请求权限的对象
     * @param requestCode   //请求码
     * @param permissions   //权限集合
     */

    @TargetApi(Build.VERSION_CODES.M)
    private static void requestPermission(Object object, int requestCode, String[] permissions) {
        //如果是6.0以前的系统 则直接返回权限申请成功并触发成功方法
        if (!Utils.isOverMarshamllow()){
            Utils.executeMethod(object,PermissionSuccess.class,requestCode);
            return;
        }
        List<String> denyPermissions = Utils.findDeniedPermissions(Utils.getActivity(object),permissions);
        if (denyPermissions != null && denyPermissions.size() > 0){
            if (object instanceof Activity){
                ((Activity)object).requestPermissions(permissions, requestCode);
            }else if (object instanceof Fragment){
                ((Fragment)object).requestPermissions(permissions,requestCode);
            }else {
                throw new IllegalArgumentException(object.getClass().getName()+"is not support!!!");
            }
        }else {
            Utils.executeMethod(object,PermissionSuccess.class,requestCode);
        }
    }

    /**
     * 对外提供的权限申请结果回调方法
     * @param object //权限对象
     * @param requestCode   //请求码
     * @param permissions   //权限集合
     * @param grantResults  //权限结果集合
     */
    public static void onRequestPermissionsResult(Object object,int requestCode,String[] permissions,int[] grantResults){
        requestResult(object,requestCode,permissions,grantResults);
    }

    /**
     * 对内的真正处理结果回调方法
     * @param object
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    private static void requestResult(Object object, int requestCode, String[] permissions, int[] grantResults) {
        List<String> denyPermissions = new ArrayList<>();
        for (String permission : permissions) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    denyPermissions.add(permissions[i]);
                }
            }
        }
        if (denyPermissions.size()>0){
            Utils.executeMethod(object,PermissionFailed.class,requestCode);
        }else {
            Utils.executeMethod(object,PermissionSuccess.class,requestCode);
        }
    }
}
