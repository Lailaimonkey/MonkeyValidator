package com.monkey.model;

import com.monkey.monkeyValidator.validator.*;
import lombok.Data;

import java.util.List;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-18 16:09
 * @Modified By：
 */
@Data
public class MonkeyValidatorModel {

    @MonkeyNotBlank
    private String name;

    @MonkeySize(min = 3, max = 6)
    private List<String> friendNames;

    @MonkeyMin(value = 18)
    @MonkeyMax(value = 60)
    private Integer age;

    @MonkeyValidatorOnCondition("age != null && age == 18")
    @MonkeyTel
    private String tel;

    @MonkeyEmail
    private String email;


}
