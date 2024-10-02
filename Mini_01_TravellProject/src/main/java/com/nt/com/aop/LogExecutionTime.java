package com.nt.com.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Can be applied to methods
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime

public @interface LogExecutionTime {
}