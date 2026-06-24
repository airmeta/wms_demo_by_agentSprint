package com.ruoyi.common.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Operation log annotation, recorded by {@code com.ruoyi.common.log.aspect.LogAspect}.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String title() default "";
    String businessType() default "OTHER";
    boolean saveRequestData() default true;
    boolean saveResponseData() default true;
    String operatorType() default "MANAGE";
}
