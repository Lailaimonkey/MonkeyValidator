package com.monkey.monkeyValidator.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: LailaiMonkey
 * @Description：元素长度不能大于max或小于min（包含min、max）
 * @Date：Created in 2020-04-12 15:16
 * @Modified By：
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface MonkeySize {

    /**
     * 提示信息
     * @return
     */
    String message() default "长度需要在{0}和{1}之间";

    /**
     * 最小长度
     * @return
     */
    int min() default 0;

    /**
     * 最大长度
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 不为Null则校验
     * @return
     */
    boolean nullable() default false;
}
