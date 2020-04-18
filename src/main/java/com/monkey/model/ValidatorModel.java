package com.monkey.model;

import com.monkey.javaxValidator.MonkeyJavaTel;
import lombok.Data;

import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.List;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-17 11:50
 * @Modified By：
 */
@Data
public class ValidatorModel {

    /**
     * 添加分组
     */
    public interface Create {
    }

    /**
     * 更新分组
     */
    public interface Update {
    }

    /**
     * 分组可以指定多个，用{}表示
     * 分组为：默认分组、更新分组
     */
    @NotBlank(message = "姓名不能为空", groups = {Default.class, Create.class})
    private String name;

    /**
     * 分组为添加分组
     */
    @Size(min = 3, max = 6, groups = {Create.class})
    private List<String> friendNames;

    @Min(value = 18)
    @Max(value = 60)
    private Integer age;

    @MonkeyJavaTel
    private String tel;

    @DecimalMin(value = "30", message = "金钱不能小于30")
    private Integer money;

    @Email
    private String email;
}
