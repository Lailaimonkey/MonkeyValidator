package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyNotNull;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 08:46
 * @Modified By：
 */
public class MonkeyNotNullImpl extends AbstractMonkeyResolver<MonkeyNotNull> {
    @Override
    public Class<MonkeyNotNull> getHandleClass() {
        return MonkeyNotNull.class;
    }

    @Override
    public boolean validator(Object value, MonkeyNotNull annotation) {
        return value != null;
    }

    @Override
    public String getMessage(MonkeyNotNull annotation) {
        return annotation.message();
    }
}
