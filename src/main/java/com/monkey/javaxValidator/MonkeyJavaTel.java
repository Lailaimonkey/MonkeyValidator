package com.monkey.javaxValidator;

import com.monkey.javaxValidator.impl.MonkeyJavaTelImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 15:18
 * @Modified By：
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
// 指定真正实现校验规则的类
@Constraint(validatedBy = MonkeyJavaTelImpl.class)
public @interface MonkeyJavaTel {
    String message() default "手机号必须是11位";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
