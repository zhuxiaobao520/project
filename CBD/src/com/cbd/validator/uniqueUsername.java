package com.cbd.validator;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

/**
 * 自定义账号唯一校验注解
 * @author yin
 *
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={uniqueUsernameValidator.class})
public @interface uniqueUsername {

	String message() default "该账号已经存在了";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target({FIELD,METHOD,PARAMETER,ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List{
		uniqueUsername[] value();
	}
	
}
