package com.leisure.annotationdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by leisure on 2017/4/5.
 */

/*
 @Target
    @Target表示Annotation可用在什么地方。其中的ElementType取值如下：
    TYPE：类，接口或者是enum声明
    FIELD：域声明（包括enum实例）
    METHOD：方法声明
    PARAMETER：参数声明
    CONSTRUCTOR：构造器声明
    LOCAL_VARIABLE：局部变量声明
    ANNOTATION_TYPE：注解类型声明
    PACKAGE：包声明
*/
//这个注解的意思是声明这个自定义的注解是修饰类的,也就是说我们把这个注解放在类的上面
@Target(ElementType.TYPE)

/*@Retention表示在什么级别保存该注解信息。其中RetentionPolicy取值如下：
        SOURCE：只在源码中保留，该注解将会被编译器丢掉
        CLASS：注解在class文件中可用，但是会被VM丢弃
        RUNTIME：VM会在运行时保留注解，这时可以通过反射读取注解信息。
        */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyContentView {
    int value();
}
