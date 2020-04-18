package com.monkey.javaxValidator.impl;

import com.monkey.javaxValidator.MonkeyJavaTel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: LailaiMonkey
 * @Description：
 * String：参数类型
 * @Date：Created in 2020-04-17 15:19
 * @Modified By：
 */
public class MonkeyJavaTelImpl implements ConstraintValidator<MonkeyJavaTel, String> {

    /**
     * 手机号是十一位为true
     * @param value 值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  value.length() == 11;
    }
}
