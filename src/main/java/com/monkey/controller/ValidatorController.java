package com.monkey.controller;

import com.monkey.model.MonkeyValidatorModel;
import com.monkey.model.ValidatorModel;
import com.monkey.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.Arrays;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 11:49
 * @Modified By：
 */
@Validated
@RestController
public class ValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @GetMapping
    public void validator() {
        ValidatorModel model = new ValidatorModel();
        model.setName("张三");
        model.setFriendNames(Arrays.asList("李四", "王五"));
        model.setAge(2);
        model.setTel("188888888881");
        model.setMoney(100);
        model.setEmail("a");
        validatorService.validator(model, "也可以在参数上做验证");
    }

    @GetMapping("/group")
    public void validatorGroup(@Validated({ValidatorModel.Create.class, Default.class}) ValidatorModel model) {
        validatorService.validatorGroup(model, "也可以在参数上做验证");
    }


    /**
     * ======== 下面是自定注解使用演示 =========
     **/
    @GetMapping("/monkeyValidator")
    public void monkeyValidator(MonkeyValidatorModel model) {
        validatorService.monkeyValidator(model, "也可以在参数上做验证");
    }

}
