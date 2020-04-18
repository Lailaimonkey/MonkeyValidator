package com.monkey.monkeyValidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-12 15:04
 * @Modified By：
 */
@Aspect
@Order
public class MonkeyValidatorAOP {

    private MonkeyValidatorImpl monkeyValidator;

    public MonkeyValidatorAOP(MonkeyValidatorImpl monkeyValidator) {
        this.monkeyValidator = monkeyValidator;
    }

    /**
     * 只拦截自定义注解
     */
    @Pointcut("@within(com.monkey.monkeyValidator.MonkeyValidator) " +
            "|| @annotation(com.monkey.monkeyValidator.MonkeyValidator)")
    private void validateObject() {

    }

    @Before("validateObject()")
    public void before(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取方法上的注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        //参数名
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        //参数值
        Object[] parameterValues = joinPoint.getArgs();

        for (int i = 0; i < parameterValues.length; i++) {
            //获得每个参数上的注解
            Annotation[] annotations = parameterAnnotations[i];
            monkeyValidator.validator(annotations, parameterNames[i], parameterValues[i]);
        }

    }

}
