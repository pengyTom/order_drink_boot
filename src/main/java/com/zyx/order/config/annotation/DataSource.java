package com.zyx.order.config.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author pengy
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
