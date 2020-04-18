package com.monkey.monkeyValidator;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LailaiMonkey
 * @Description：表示该项目启用注解验证
 * @Date：Created in 2020-04-12 15:46
 * @Modified By：
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({MonkeyValidatorConfiguration.class})
public @interface EnableMonkeyValidator {
}
