package com.monkey.monkeyValidator.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: LailaiMonkey
 * @Description：验证email邮箱
 * @Date：Created in 2020-04-12 15:16
 * @Modified By：
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface MonkeyEmail {

    /**
     * 提示信息
     * @return
     */
    String message() default "不是一个合法的电子邮件地址";

    /**
     * 不为Null则校验
     * @return
     */
    boolean nullable() default false;

}
