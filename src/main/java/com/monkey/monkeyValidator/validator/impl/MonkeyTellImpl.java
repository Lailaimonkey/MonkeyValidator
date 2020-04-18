package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyTel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 18:47
 * @Modified By：
 */
public class MonkeyTellImpl extends AbstractMonkeyResolver<MonkeyTel> {
    private final String REGEX = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public Class<MonkeyTel> getHandleClass() {
        return MonkeyTel.class;
    }

    @Override
    public boolean validator(Object value, MonkeyTel annotation) {
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
    public String getMessage(MonkeyTel annotation) {
        return annotation.message();
    }
}
