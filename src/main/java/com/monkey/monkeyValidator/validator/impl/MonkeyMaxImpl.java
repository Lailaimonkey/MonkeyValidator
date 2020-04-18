package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyMax;

import java.math.BigDecimal;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-12 15:18
 * @Modified By：
 */
public class MonkeyMaxImpl extends AbstractMonkeyResolver<MonkeyMax> {

    @Override
    public Class<MonkeyMax> getHandleClass() {
        return MonkeyMax.class;
    }

    @Override
    public boolean validator(Object value, MonkeyMax annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).compareTo(BigDecimal.valueOf(annotation.value())) < 0;
        } else if (value instanceof Number) {
            return ((Number) value).doubleValue() < ((double) annotation.value());
        }

        return true;
    }

    @Override
    public String getMessage(MonkeyMax annotation) {
        return annotation.message() + annotation.value();
    }
}
