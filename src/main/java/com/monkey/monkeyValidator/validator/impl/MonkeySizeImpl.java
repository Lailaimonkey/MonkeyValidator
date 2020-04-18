package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeySize;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 08:52
 * @Modified By：
 */
public class MonkeySizeImpl extends AbstractMonkeyResolver<MonkeySize> {
    @Override
    public Class<MonkeySize> getHandleClass() {
        return MonkeySize.class;
    }

    @Override
    public boolean validator(Object value, MonkeySize annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof String) {
            int length = value.toString().length();
            return length <= annotation.max() && length >= annotation.min();
        }
        if (value instanceof Collection) {
            int size = ((Collection) value).size();
            return size <= annotation.max() && size >= annotation.min();
        }
        if (value instanceof Map) {
            int size = ((Map) value).size();
            return size <= annotation.max() && size >= annotation.min();
        }

        return false;
    }

    @Override
    public String getMessage(MonkeySize annotation) {
        return MessageFormat.format(annotation.message(), annotation.min(), annotation.max());
    }
}
