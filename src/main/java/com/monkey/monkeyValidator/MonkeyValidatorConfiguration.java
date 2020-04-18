package com.monkey.monkeyValidator;

import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.impl.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @Author: LailaiMonkey
 * @Description：加载所有注解
 * @Date：Created in 2020-04-12 15:27
 * @Modified By：
 */
public class MonkeyValidatorConfiguration {

    /**
     * MonkeyValidatorImpl没有@component修饰，所以无法直接在AOP中注入，通过加载bean方式注入
     *
     * @param monkeyInterface
     * @return
     */
    @Bean
    public MonkeyValidatorAOP monkeyInterfaceAOP(MonkeyValidatorImpl monkeyInterface) {
        return new MonkeyValidatorAOP(monkeyInterface);
    }

    /**
     * 可以获得继承所有分解器的注解
     *
     * @param monkeyResolvers
     * @return
     */
    @Bean
    public MonkeyValidatorImpl monkeyInterfaceImpl(List<AbstractMonkeyResolver> monkeyResolvers) {
        return new MonkeyValidatorImpl(monkeyResolvers);
    }

    /**
     * 加载所有注解
     *
     * @return
     */
    @Bean
    public MonkeyEmailImpl monkeyEmail() {
        return new MonkeyEmailImpl();
    }

    @Bean
    public MonkeyMaxImpl monkeyMax() {
        return new MonkeyMaxImpl();
    }

    @Bean
    public MonkeyMinImpl monkeyMin() {
        return new MonkeyMinImpl();
    }

    @Bean
    public MonkeyNotBlankImpl monkeyNotBlank() {
        return new MonkeyNotBlankImpl();
    }

    @Bean
    public MonkeyNotBlankInCollectionImpl monkeyNotBlankInCollection() {
        return new MonkeyNotBlankInCollectionImpl();
    }

    @Bean
    public MonkeyNotNullImpl monkeyNotNull() {
        return new MonkeyNotNullImpl();
    }

    @Bean
    public MonkeyNotNullInCollectionImpl monkeyNotNullInCollection() {
        return new MonkeyNotNullInCollectionImpl();
    }

    @Bean
    public MonkeySizeImpl monkeySize() {
        return new MonkeySizeImpl();
    }

    @Bean
    public MonkeyTellImpl monkeyTell() {
        return new MonkeyTellImpl();
    }

}
