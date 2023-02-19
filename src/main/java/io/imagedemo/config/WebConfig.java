package io.imagedemo.config;

import org.hibernate.validator.HibernateValidator;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
	@Bean
	public Validator validator() {
	    return Validation.byProvider(HibernateValidator.class)
	        .configure()
	        .failFast(true)
	        .buildValidatorFactory()
	        .getValidator();
	}


}
