package com.jieleo.tileoverlydemo.utils.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/6/24.
 */

public class MPermission {

    private MPermission(){

    }

    public static void needPermission(Activity activity, int requestCode,String... permissions){
        requestPermission(activity,requestCode,permissions);
    }
    public static void needPermission(Fragment fragment, int requestCode, String... permissions){
        requestPermission(fragment,requestCode,permissions);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private static void requestPermission(Object object,int requestCode,String[] permissions){
        if (!PermissionUtils.isOverMarshamllow()){
            PermissionUtils.executeMethod(object,PermissionSuccess.class,requestCode);
            return;
        }
        List<String> denyPermission=PermissionUtils.findDeniedPermissions(PermissionUtils.getActivity(object),permissions);
        if (denyPermission!=null&&denyPermission.size()>0){
            if (object instanceof Activity){
                ((Activity)object).requestPermissions(permissions, requestCode);
            }else if (object instanceof Fragment){
                ((Fragment)object).requestPermissions(permissions,requestCode);
            }else {
                throw new IllegalArgumentException(object.getClass().getName()+"is not support!!!");
            }
        }else {
        PermissionUtils.executeMethod(object,PermissionSuccess.class,requestCode);
    }
    }

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
            PermissionUtils.executeMethod(object,PermissionFailed.class,requestCode);
        }else {
            PermissionUtils.executeMethod(object,PermissionSuccess.class,requestCode);
        }
    }
}
