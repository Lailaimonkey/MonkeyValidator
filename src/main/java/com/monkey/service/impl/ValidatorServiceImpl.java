package com.monkey.service.impl;

import com.monkey.model.MonkeyValidatorModel;
import com.monkey.model.ValidatorModel;
import com.monkey.monkeyValidator.MonkeyValidator;
import com.monkey.monkeyValidator.validator.MonkeyModel;
import com.monkey.monkeyValidator.validator.MonkeyNotBlank;
import com.monkey.service.ValidatorService;
import org.springframework.stereotype.Service;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 11:49
 * @Modified By：
 */
@MonkeyValidator
@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public void validator(ValidatorModel model, String param) {

    }

    @Override
    public void validatorGroup(ValidatorModel model, String param) {

    }


    /**
     * ======== 下面是自定注解使用演示 =========
     **/
    @Override
    public void monkeyValidator(@MonkeyModel MonkeyValidatorModel model, @MonkeyNotBlank String param) {

    }
}
