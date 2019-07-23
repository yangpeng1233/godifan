package com.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 ElementType.ANNOTATION_TYPE 应用于其他注解的元注解
 ElementType.CONSTRUCTOR 构造函数
 ElementType.FIELD   字段
 ElementType.LOCAL_VARIABLE  方法中的本地变量
 ElementType.METHOD  方法
 ElementType.PACKAGE 包
 ElementType.PARAMETER   方法的参数
 ElementType.TYPE    类，接口或者枚举声明

 RetentionPolicy.SOURCE、
 RetentionPolicy.CLASS、
 RetentionPolicy.RUNTIME
 分别对应：Java源文件(.java文件)---->.class文件---->内存中的字节码
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

    boolean check() default false;
}
