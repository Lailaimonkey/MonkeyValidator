package com.monkey.monkeyValidator.exception;

/**
 * @Author: LailaiMonkey
 * @Description：
 * @Date：Created in 2020-04-13 09:01
 * @Modified By：
 */
public class MonkeyValidatorException extends RuntimeException {

    public MonkeyValidatorException(String message) {
        super(message);
    }

    public MonkeyValidatorException(Throwable cause) {
        super(cause);
    }
}
