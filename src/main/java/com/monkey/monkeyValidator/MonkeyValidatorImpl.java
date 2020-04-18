package com.monkey.monkeyValidator;

import com.monkey.monkeyValidator.exception.MonkeyValidatorException;
import com.monkey.monkeyValidator.validator.AbstractMonkeyResolver;
import com.monkey.monkeyValidator.validator.MonkeyModel;
import com.monkey.monkeyValidator.validator.MonkeyValidatorOnCondition;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.util.FieldUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-12 15:34
 * @Modified By：
 */
public class MonkeyValidatorImpl {

    private final ExpressionParser expressionParser = new SpelExpressionParser();

    private Map<Class, AbstractMonkeyResolver> monkeyResolversMap = new HashMap<>();

    /**
     * 把注解和实现类对应起来
     *
     * @param monkeyResolvers
     */
    MonkeyValidatorImpl(List<AbstractMonkeyResolver> monkeyResolvers) {
        for (AbstractMonkeyResolver monkeyResolver : monkeyResolvers) {
            monkeyResolversMap.put(monkeyResolver.getHandleClass(), monkeyResolver);
        }
    }

    /**
     * @param parameterAnnotations 参数注解
     * @param parameterName        参数名
     * @param parameterValue       参数值
     */
    public void validator(Annotation[] parameterAnnotations,
                          String parameterName,
                          Object parameterValue) {
        //根据方法注解调用相关验证
        for (Annotation methodAnnotation : parameterAnnotations) {
            //验证实体类型
            if (MonkeyModel.class.isAssignableFrom(methodAnnotation.annotationType())) {
                if (parameterValue != null) {
                    //集合、数组、Map、实体
                    if (parameterValue instanceof Collection) {
                        int index = 0;
                        for (Object o : ((Collection) parameterValue)) {
                            validatorModel(o, index);
                            index++;
                        }
                    } else if (parameterValue instanceof Object[]) {
                        int index = 0;
                        for (Object o : (Object[]) parameterValue) {
                            validatorModel(o, index);
                            index++;
                        }
                    } else if (parameterValue instanceof Map) {
                        int[] index = {0};
                        ((Map) parameterValue).forEach((k, v) -> {
                            validatorModel(v, index[0]);
                            index[0]++;
                        });
                    } else {
                        validatorModel(parameterValue, null);
                    }
                }
            } else {
                //筛选自定义验证注解
                monkeyValidator(methodAnnotation, parameterName, parameterValue, null, null);
            }
        }
    }

    /**
     * 验证实体
     *
     * @param model
     */
    private void validatorModel(Object model, Integer index) {
        try {
            Field[] fields = model.getClass().getDeclaredFields();
            String modelName = model.getClass().getName();
            for (Field field : fields) {
                //字段值
                Object fieldValue = FieldUtils.getFieldValue(model, field.getName());

                //获得属性上所有注解
                Annotation[] annotations = findAnnotations(field, model.getClass());

                boolean needValidator = true;
                for (Annotation annotation : annotations) {
                    if (MonkeyValidatorOnCondition.class.isAssignableFrom(annotation.annotationType())) {
                        MonkeyValidatorOnCondition validate = (MonkeyValidatorOnCondition) annotation;
                        //获得该注解表达式
                        String value = validate.value();
                        //使用了Spring的SqEL，可以在EvaluationContext单独计算表达式的值
                        //把整个Model值放入EvaluationContext中
                        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(model);
                        //解析表达式
                        Expression expression = expressionParser.parseExpression(value);
                        //计算指定表达式值
                        Object expressionValue = expression.getValue(standardEvaluationContext);
                        //表达式为假不需要验证
                        if (Boolean.FALSE.equals(expressionValue)) {
                            needValidator = false;
                            break;
                        }
                    }
                }

                //需要验证
                if (needValidator) {
                    for (Annotation annotation : annotations) {
                        monkeyValidator(annotation, field.getName(), fieldValue, index, modelName);
                    }
                }
            }
        } catch (Exception e) {
            throw new MonkeyValidatorException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void monkeyValidator(Annotation methodAnnotation, String parameterName,
                                 Object parameterValue, Integer index, String modelName) {
        //筛选自定义验证注解
        if (monkeyResolversMap.containsKey(methodAnnotation.annotationType())) {
            AbstractMonkeyResolver monkeyResolver = monkeyResolversMap.get(methodAnnotation.annotationType());

            boolean validator = monkeyResolver.validator(parameterValue, methodAnnotation);

            //验证失败抛出异常
            if (!validator) {
                StringBuilder errorMessage = new StringBuilder(parameterName + ":" + monkeyResolver.getMessage(methodAnnotation));
                if (!StringUtils.isEmpty(modelName)) {
                    if (index == null) {
                        errorMessage.replace(0, errorMessage.length(), modelName.substring(modelName.lastIndexOf('.') + 1) + "." + errorMessage);
                    } else {
                        errorMessage.replace(0, errorMessage.length(), modelName.substring(modelName.lastIndexOf('.') + 1) + "[" + index + "]." + errorMessage);
                    }
                }
                throw new MonkeyValidatorException(errorMessage.toString());
            }
        }
    }

    /**
     * 获得该字段上所有注解，set方法注解优先于字段注解
     *
     * @param field
     * @param clazz
     * @return
     */
    private Annotation[] findAnnotations(Field field, Class<?> clazz) {
        //获得set方法上注解
        Method method = MethodUtils.getAccessibleMethod(clazz, "set" + StringUtils.capitalize(field.getName()), field.getType());
        Annotation[] methodAnnotations = method.getDeclaredAnnotations();
        if (methodAnnotations.length > 0) {
            return methodAnnotations;
        }
        //字段上注解
        return field.getDeclaredAnnotations();
    }

}
