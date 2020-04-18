package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyMin;

import java.math.BigDecimal;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 08:29
 * @Modified By：
 */
public class MonkeyMinImpl extends AbstractMonkeyResolver<MonkeyMin> {
    @Override
    public Class<MonkeyMin> getHandleClass() {
        return MonkeyMin.class;
    }

    @Override
    public boolean validator(Object value, MonkeyMin annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).compareTo(BigDecimal.valueOf(annotation.value())) > 0;
        } else if (value instanceof Number) {
            return ((Number) value).doubleValue() > ((double) annotation.value());
        }

        return true;
    }

    @Override
    public String getMessage(MonkeyMin annotation) {
        return annotation.message() + annotation.value();
    }
}
