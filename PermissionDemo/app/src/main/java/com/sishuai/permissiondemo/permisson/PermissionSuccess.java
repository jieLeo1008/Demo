package com.sishuai.permissiondemo.permisson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sishuai on 2017/3/30.
 */
@Retention(RetentionPolicy.RUNTIME)//该注解作用在运行时
@Target(ElementType.METHOD)//该注解被用于方法上
public @interface PermissionSuccess {
    int requestCode();//注解中参数的声明
}
