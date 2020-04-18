package com.monkey.monkeyValidator.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: LailaiMonkey
 * @Description：
 * 如果el表达式为true, 表示该属性需要验证
 * 否则该属性上任何自定义校验注解不生效
 * @Date：Created in 2020-04-13 09:18
 * @Modified By：
 */
@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Documented
public @interface MonkeyValidatorOnCondition {
    /**
     * 使用Spring el表达式
     * 例子 "name != null"
     */
    String value();
}
