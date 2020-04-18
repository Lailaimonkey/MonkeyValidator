package com.monkey.service;

import com.monkey.model.MonkeyValidatorModel;
import com.monkey.model.ValidatorModel;
import com.monkey.monkeyValidator.validator.MonkeyModel;
import com.monkey.monkeyValidator.validator.MonkeyNotBlank;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 11:49
 * @Modified By：
 */
@Validated
public interface ValidatorService {

    void validator(ValidatorModel model, @NotNull String param);

    void validatorGroup(ValidatorModel model, @NotNull String param);

    /**
     * ======== 下面是自定注解使用演示 =========
     **/
    void monkeyValidator(@MonkeyModel MonkeyValidatorModel model, @MonkeyNotBlank String param);
}
