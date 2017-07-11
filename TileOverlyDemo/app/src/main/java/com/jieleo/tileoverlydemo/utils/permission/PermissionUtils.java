package com.jieleo.tileoverlydemo.utils.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/6/24.
 */

public class PermissionUtils {

    private PermissionUtils(){

    }


    public static boolean isOverMarshamllow(){
        return Build.VERSION.SDK_INT>=Build.VERSION_CODES.M;
    }

    /**
     * 通过给定Object对象 返回对应的Activity 只支持 Activity和 Fragment两种类型的参数
     * @param object    //要进行判断的对象
     * @return
     */
    public static Activity getActivity(Object object){
        if (object instanceof Activity){
            return (Activity) object;
        }else if (object instanceof Fragment){
            return ((Fragment) object).getActivity();
        }else {
            return null;
        }
    }

    /**
     * 检查权限集合没有申请的权限 并将没有申请的权限集合进行返回
     * @param activity  //申请权限的Activity对象
     * @param permissions   //被检查的权限组
     * @return
     */
    //加声明
    @TargetApi(Build.VERSION_CODES.M)
    public static List<String> findDeniedPermissions(Activity activity, String... permissions){
        List<String> denyPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (activity.checkSelfPermission(permission)!= PackageManager.PERMISSION_GRANTED){
                denyPermissions.add(permission);
            }
        }

        return denyPermissions;
    }

    /**1
     * 解析自定义注解类 找对对应的注解方法 并返回
     * @param clazz //包含注解方法的注解
     * @param  annotation //要解析的注解对象
     * @param requestCode //请求码
     * @return
     */
    public static <A extends Annotation>Method findMethodWithRequest(Class clazz, Class<A> annotation , int requestCode){
        for (Method method : clazz.getDeclaredMethods()){//返回所有方法
            if (method.isAnnotationPresent(annotation)){//判断方法有没有注解
                //如果注解类型匹配 并且请求吗也匹配 则将该方法进行返回
                if (isEqualRequestCodeFromAnnotation(method,annotation,requestCode)){
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * 判断某个方法是否是制定类型的注解方法
     * @param method    //要判断的方法
     * @param annotation    //要判断的注解类型
     * @param requestCode   //请求码
     * @param <A>
     * @return
     */
    private static <A extends Annotation> boolean isEqualRequestCodeFromAnnotation(
            Method method,Class<A> annotation , int requestCode){
        if (annotation.equals(PermissionSuccess.class)){
            return requestCode == method.getAnnotation(PermissionSuccess.class).requestCode();
        }else if (annotation.equals(PermissionFailed.class)){
            return requestCode == method.getAnnotation(PermissionFailed.class).requestCode();
        }else {
            return false;
        }
    }

    /**
     * 通过反射的方式 执行某一个原子方法
     * @param object        //包含原子方法的对
     * @param annotation    //要执行的注解类型
     * @param requestCode   //请求码
     * @param <A>
     */
    public static <A extends Annotation>void executeMethod(Object object,Class<A> annotation , int requestCode){
        Method method = findMethodWithRequest(object.getClass(),annotation,requestCode);
        if (method != null){
            //如果当前方法不是公有方法 则设置一下访问属性
            if (!method.isAccessible()){
                method.setAccessible(true);
            }
            try {
                method.invoke(object,new Object[]{});//执行某个方法
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
