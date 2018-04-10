package com.cbd.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义电话号码注解校验器
 * @author yinshi
 * @date 2018年1月31日
 */
public class phoneNoValidator implements ConstraintValidator<PhoneNo, String>{

	@Override
	public void initialize(PhoneNo arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(phoneNo == null || phoneNo.isEmpty()){
			return false;
		}
		
		if(phoneNo.matches("((\\+86)|(86))?1[3|4|5|7|8|9]\\d{9}")){
			return true;
		}
		return false;
	}

}
