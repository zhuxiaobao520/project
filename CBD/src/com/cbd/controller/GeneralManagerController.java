package com.cbd.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CheckAdminBean;
import com.cbd.service.IAdminService;
import com.cbd.service.IGeneralManagerService;
import com.cbd.util.UseMD5;

/**
 * 普通管理员页面控制器
 * @author 张平
 *
 */
@Controller
public class GeneralManagerController {
	@Autowired
	private IGeneralManagerService iGeneralManagerService;
	
	@Autowired
	private IAdminService adminService;
	
	
	/**
	 * 修改普通管理员个人信息（密码）
	 */
	
	@RequestMapping("updateGeneralManager")
	public String  GeneralManager(@Valid CheckAdminBean checkAdminBean,BindingResult bindingResult,
			ModelMap modelMap,HttpSession httpSession){
		//判断数据校验结果
		if (bindingResult.hasErrors()) {
			//打印校验错误信息
			List<FieldError>fieldErrors=bindingResult.getFieldErrors();
			for(FieldError fieldError:fieldErrors){
					modelMap.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());	
			}
			return "managerJsp/tangxiaoxiongJSP/updateAdminManager";
		}
			//把输入的密码加盐
			String oldPassword = UseMD5.md5MakePassword(checkAdminBean.getOldPassword());	
			//获取数据库密码
			AdminBean	adminBean	= (AdminBean)httpSession.getAttribute("adminLogining");
			
		if(oldPassword.equals(adminBean.getAdminPassword())){
			
			Boolean flag=iGeneralManagerService.updateGeneralManager(UseMD5.md5MakePassword(checkAdminBean.getNewPassword()),adminBean.getAdminId());
			if(flag){
			modelMap.addAttribute("GeneralManager", "");
				return "forward:jumpExit";
			}
		}
		modelMap.addAttribute("GeneralManager", "原密码错误");
		return "managerJsp/tangxiaoxiongJSP/updateAdminManager";
	}
	/**
	 * zhangping
	 * 修改个人信息跳转
	 */
	@RequestMapping("ModifyPersonalInformation")
		public String ModifyPersonalInformation(){
		 	return"managerJsp/tangxiaoxiongJSP/updateAdminManager";
	}
	
	/**
	 * zhangping
	 * 修改个人信息返回跳转
	 */
	@RequestMapping("PersonalInformationReturn")
	public String PersonalInformationReturn(){
	 	return"managerJsp/adminTemplate";
}
	/**
	 * 张平
	 * 导航栏修改信息跳转
	 */
	@RequestMapping("updatePersonalInformation")
	public String updateAdminPersonalInfo(){
			return"managerJsp/adminTemplate";
	}
	/**
	 * 修改管理员电话号码
	 * @author zhangping
	 * @date 2018年2月8日
	 * @return
	 */
	@RequestMapping("updateAdminPhone")
	public String updateAdminPhone(@RequestParam(value="newPhone") String updateAdminPhone
			,ModelMap modelMap,HttpSession httpSession){
		Pattern p = Pattern.compile("^((13\\d{9}$)|(15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(18[0,2,5,6,7,8,9]\\d{8}$)|(147\\d{8})$)");
	    Matcher m = p.matcher(updateAdminPhone);
	    if(m.matches()){
	    	/**
	    	 * 获取bean
	    	 */
	    	AdminBean	adminBean	= (AdminBean)httpSession.getAttribute("adminLogining");
	    		boolean num = iGeneralManagerService.updateAdminPhone(updateAdminPhone,adminBean.getAdminId());
	    		if (num) {
	    			 modelMap.addAttribute("AdminPhone", "修改成功");
	    			 /**
	    			  * 修改成功调查找方法
	    			  */
	    			 AdminBean adminBean2 = adminService.getAdminByAccount(adminBean.getAdminAccount(), adminBean.getAdminPassword());
	    			 httpSession.setAttribute("adminLogining", adminBean2);
	 				return "managerJsp/adminTemplate";
				}
	    }
	    modelMap.addAttribute("AdminPhone", "电话号码格式有误");
			return "managerJsp/adminTemplate";
	}
}

	