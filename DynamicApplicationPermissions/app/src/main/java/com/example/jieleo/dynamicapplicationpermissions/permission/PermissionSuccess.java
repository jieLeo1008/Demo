package com.example.jieleo.dynamicapplicationpermissions.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by OldFour on 2017/3/30.
 */
@Retention(RetentionPolicy.RUNTIME)//该注解作用在运行时上
@Target(ElementType.METHOD)//该注解作用在方法上
public @interface PermissionSuccess {
    int requestCode();//注解中的参数说明

}
