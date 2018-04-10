package com.cbd.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CompanyBean;
import com.cbd.bean.UserBean;
import com.cbd.service.IAdminService;
import com.cbd.service.ICompanyService;
import com.cbd.service.IUserService;
import com.cbd.service.impl.AdminServiceImpl;
import com.cbd.service.impl.CompanyServiceImpl;
import com.cbd.service.impl.UserServiceImpl;

/**
 * 自定义电话号码注解校验器
 * @author yin
 *
 */
public class uniqueUsernameValidator implements ConstraintValidator<uniqueUsername, String>{
	@Autowired 
	private IUserService userService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICompanyService companyService;
	
	@Override
	public void initialize(uniqueUsername arg0) {}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(username == null || username.isEmpty()){
			return false;
		}

		UserBean userBean = userService.getUserByUsername(username);
		AdminBean adminBean = adminService.getAdminByAdminName(username);
		CompanyBean companyBean = companyService.getCompanyByName(username);
		if(userBean == null && adminBean == null && companyBean == null){
			return true;
		}	
		
		return false;
	}

}
