package com.monkey.monkeyValidator.validator.impl;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyNotNullInCollection;

import java.util.Collection;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 08:33
 * @Modified By：
 */
public class MonkeyNotNullInCollectionImpl extends AbstractMonkeyResolver<MonkeyNotNullInCollection> {
    @Override
    public Class<MonkeyNotNullInCollection> getHandleClass() {
        return MonkeyNotNullInCollection.class;
    }

    @Override
    public boolean validator(Object value, MonkeyNotNullInCollection annotation) {
        if (value == null) {
            return annotation.nullable();
        }

        if (value instanceof Collection) {
            Collection collection = (Collection) value;
            if (collection.isEmpty()) {
                return false;
            }

            for (Object c : collection) {
                if (c == null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public String getMessage(MonkeyNotNullInCollection annotation) {
        return annotation.message();
    }
}
