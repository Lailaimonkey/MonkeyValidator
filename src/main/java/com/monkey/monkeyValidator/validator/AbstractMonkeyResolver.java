package com.monkey.monkeyValidator.validator;

import java.lang.annotation.Annotation;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-12 15:23
 * @Modified By：
 */
abstract public class AbstractMonkeyResolver<T extends Annotation> {

    public abstract Class<T> getHandleClass();

    public abstract boolean validator(Object value, T annotation);

    public abstract String getMessage(T annotation);

}
