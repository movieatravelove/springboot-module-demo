package com.zhang.web.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)  //该注解应用于方法
@Retention(RetentionPolicy.RUNTIME) //在vm运行期间保留注解
@Documented           //将注解包含在javadoc中
public @interface SysLog {
    String value() default "";
}
