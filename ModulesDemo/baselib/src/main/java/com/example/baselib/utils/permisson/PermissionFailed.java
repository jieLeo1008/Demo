package com.example.baselib.utils.permisson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by OldFour on 2017/3/30.
 */
@Retention(RetentionPolicy.RUNTIME)//注解用在运行时
@Target(ElementType.METHOD)//注解用在方法中
public @interface PermissionFailed {
    int requestCode();//传递一个请求码
}

