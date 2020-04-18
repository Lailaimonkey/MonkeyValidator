package com.monkey.monkeyValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: LailaiMonkey
 * @Description：表示该类中所能方法启用注解验证
 * @Date：Created in 2020-04-12 15:03
 * @Modified By：
 */
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
public @interface MonkeyValidator {
}
