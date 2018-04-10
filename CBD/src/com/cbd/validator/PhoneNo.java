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
 * 自定义电话号码注解
 * @author yinshi
 * @date 2018年1月31日
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={phoneNoValidator.class})
public @interface PhoneNo {

	String message() default "手机号码格式错误";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target({FIELD,METHOD,PARAMETER,ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List{
		PhoneNo[] value();
	}
	
}
