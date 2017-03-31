package com.example.jieleo.dynamicapplicationpermissions.permission;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by OldFour on 2017/3/30.
 */

public class Utils {
    private Utils(){

    }

    /**
     * 判断Android系统版本
     * @return
     */
    public static boolean isOverMarshmallow(){
        return Build.VERSION.SDK_INT>=Build.VERSION_CODES.M;
    }

    /**
     * 通过给Object对象返回对应的Activity只支持Activ
     * @param object
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
     * 解析自定义注解  找打对应的注解方法并返回
     * @param clazz  包含注解方法的注解类
     * @param annoation  要解析的注解对象
     * @param requestCode  请求码
     * @param <A>
     * @return
     */
    public static <A extends Annotation>Method findMethodWithRequest(Class clazz, Class<A> annoation,int requestCode){
       for(Method method:clazz.getDeclaredMethods()){//返回所有方法

           if (method.isAnnotationPresent(annoation)){
               //判断是否有加注解的方法
               if (isEqualRequestCodeFromANNoation(method,annoation,requestCode)){
                   return method;
               }
           }
       }
       return null;
    }

    /**
     * 判断某个方法是否是制定类型的注解方法
     * @param method
     * @param annoation
     * @param requestCode
     * @param <A>
     * @return
     */
    private static <A extends Annotation> boolean isEqualRequestCodeFromANNoation(Method method,
                                                                                  Class<A> annoation,int requestCode){
        if (annoation.equals(PermissionSuccess.class)){
            return requestCode==method.getAnnotation(PermissionSuccess.class).requestCode();
        }else if (annoation.equals(PermissionFailed.class)){
            return requestCode==method.getAnnotation(PermissionFailed.class).requestCode();
        }else {
        return false;

        }

    }

    /**
     * 通过反射的方式执行某一个原子方法
     * @param object  包含原子方法的对象
     * @param annotaion 要执行的注解
     * @param requestCode 请求码
     * @param <A>
     */
    public static<A extends Annotation> void executeMethod(Object object,Class<A> annotaion,int requestCode){
        Method method=findMethodWithRequest(object.getClass(),annotaion,requestCode);
        if (method!=null){
            /**
             * 如果当前方法不是公有方法 则设置一下访问属性
             */
            if (!method.isAccessible()){
                method.setAccessible(true);

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
}
