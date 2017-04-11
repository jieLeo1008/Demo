package com.leisure.annotationdemo;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by leisure on 2017/4/5.
 */

public class ViewTool {
    private static Class<?> mClass;
    public static void inject(Activity activity){
        mClass = activity.getClass();
        injectView(activity);
        injectId(activity);
        injectEvent(activity);
    }



    //加载布局
    private static void injectView(Activity activity) {
        MyContentView contentView = mClass.getAnnotation(MyContentView.class);
        if (contentView != null){
            int id = contentView.value();
            //利用反射获取setContentView方法,注入我们自己定义的id
            try {
                mClass.getMethod("setContentView",Integer.class).invoke(activity,id);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }
    private static void injectId(Activity activity) {
        Field[] fields = mClass.getDeclaredFields();
        for (Field field : fields){
            MyFindViewById findId = field.getAnnotation(MyFindViewById.class);
            if (findId != null){
                int id = findId.value();
                try {
                    //这一步中同样也能够使用 Object view = activity.findViewById(id) 来获取View
                    Object view = mClass.getMethod("findViewById",Integer.TYPE).invoke(activity,id);
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    private static void injectEvent(Activity activity){

        Method[] methods = mClass.getMethods();

        for (Method method : methods) {
            MyClick onClick = method.getAnnotation(MyClick.class);
            if (onClick != null){
                int[] ids = onClick.value();
                MyInvocationHandler handler = new MyInvocationHandler(activity,method);

                //通过Java中的动态代理来执行View.OnClickListener
                Object listenerProxy = Proxy.newProxyInstance(
                        View.OnClickListener.class.getClassLoader(),
                        new Class<?>[] { View.OnClickListener.class }, handler);
                for (int id : ids) {

                    try {
                        Object view = mClass.getMethod("findViewById",Integer.TYPE).invoke(activity,id);
                        Method listenerMethod = view.getClass()
                                .getMethod("setOnClickListener", View.OnClickListener.class);
                        listenerMethod.invoke(view, listenerProxy);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
    //动态代理
    static class MyInvocationHandler implements InvocationHandler {

        private Object target = null;
        private Method method = null;

        public MyInvocationHandler(Object target,Method method) {
            super();
            this.target = target;
            this.method = method;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            return this.method.invoke(target,args);
        }
    }
    public static void unInject(){
        mClass = null;
    }
}
