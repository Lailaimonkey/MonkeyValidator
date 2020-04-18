package com.monkey.monkeyValidator.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: LailaiMonkey
 * @Description：用于字符集合每一项元素不能为空或空串
 * @Date：Created in 2020-04-17 08:33
 * @Modified By：
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface MonkeyNotBlankInCollection {

    /**
     * 提示信息
     * @return
     */
    String message() default "集合中不能为空或空串";

    /**
     * 不为Null则校验
     * @return
     */
    boolean nullable() default false;
}
