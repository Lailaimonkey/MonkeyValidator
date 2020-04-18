package com.monkey;

import com.monkey.monkeyValidator.EnableMonkeyValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMonkeyValidator
@SpringBootApplication
public class MonkeyValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonkeyValidatorApplication.class, args);
	}

}
