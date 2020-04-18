package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyNotBlankInCollection;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 08:37
 * @Modified By：
 */
public class MonkeyNotBlankInCollectionImpl extends AbstractMonkeyResolver<MonkeyNotBlankInCollection> {
    @Override
    public Class<MonkeyNotBlankInCollection> getHandleClass() {
        return MonkeyNotBlankInCollection.class;
    }

    @Override
    public boolean validator(Object value, MonkeyNotBlankInCollection annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof Collection) {
            Collection collection = (Collection) value;
            if (collection.isEmpty()) {
                return false;
            }

            for (Object c : collection) {
                if (StringUtils.isEmpty(c.toString().trim())) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public String getMessage(MonkeyNotBlankInCollection annotation) {
        return annotation.message();
    }
}
