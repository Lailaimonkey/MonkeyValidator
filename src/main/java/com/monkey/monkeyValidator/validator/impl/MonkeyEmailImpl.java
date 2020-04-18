package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 18:47
 * @Modified By：
 */
public class MonkeyEmailImpl extends AbstractMonkeyResolver<MonkeyEmail> {
    private final String REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public Class<MonkeyEmail> getHandleClass() {
        return MonkeyEmail.class;
    }

    @Override
    public boolean validator(Object value, MonkeyEmail annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof String) {
            String v = value.toString();
            Matcher matcher = pattern.matcher(v);
            return matcher.matches();
        }
        return false;
    }

    @Override
    public String getMessage(MonkeyEmail annotation) {
        return annotation.message();
    }
}
