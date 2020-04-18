package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyNotBlank;
import org.springframework.util.StringUtils;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-12 15:18
 * @Modified By：
 */
public class MonkeyNotBlankImpl extends AbstractMonkeyResolver<MonkeyNotBlank> {

    @Override
    public Class<MonkeyNotBlank> getHandleClass() {
        return MonkeyNotBlank.class;
    }

    @Override
    public boolean validator(Object value, MonkeyNotBlank annotation) {
        if (value == null) {
            return annotation.nullable();
        }
        return !StringUtils.isEmpty(value.toString().trim());
    }

    @Override
    public String getMessage(MonkeyNotBlank annotation) {
        return annotation.message();
    }
}
