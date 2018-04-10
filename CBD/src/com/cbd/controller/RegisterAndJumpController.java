package com.cbd.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cbd.bean.CarportBean;
import com.cbd.bean.LogBean;
import com.cbd.bean.Pager;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.bean.UserBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.service.*;
import com.cbd.util.DateUtil;
import com.cbd.util.UseMD5;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * 用户注册控制器与未认证前的跳转控制
 * @author yinshi
 * @date 2018年1月29日
 */
@Controller
public class RegisterAndJumpController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRentOutService rentOutService;
	@Autowired
	private ICarportService carportService;
	@Autowired
	private ILogService logService;

	// 注册logger
	private static Logger logger = Logger.getLogger(RegisterAndJumpController.class);

	/**
	 * 
	 * @author yinshi
	 * @date 2018年1月31日
	 * @return 返回跳转到联系我们的页面去
	 */
	@RequestMapping("jumpContact")
	public String goToContact(){
		return "redirect:jsp/contact.jsp";
	}
	
	/**
	 * 
	 * @author yinshi
	 * @date 2018年1月31日
	 * @return 跳转到登录界面去
	 */
	@RequestMapping("jumpLogin")
	public String goToLogin(){
		return "redirect:jsp/login.jsp";
	}

	/**
	 * 
	 * @author yinshi
	 * @date 2018年1月31日
	 * @return 跳转到注册页面去
	 */
	@RequestMapping("jumpRegister")
	public String goToRegister() {
		return "redirect:jsp/register.jsp";
	}
	
	/**
	 * 
	 * @author yinshi
	 * @date 2018年1月31日
	 * @return 跳转跳转到注册页面去
	 */
	@RequestMapping("jumpHome")
	public String goToHome(ModelMap modelMap){
		Pager pager = rentOutService.getUseableCarportPager(1, 6);
		List<UseableRentOutInfoBean> usercarportBeans = pager.getDatas();
//		List<CarportBean> carportBeans = carportService.findNullCarport();
		modelMap.addAttribute("carportList",usercarportBeans);
		return "home";
	}

	/**
	 * 接受用户注册的请求
	 * @author yinshi
	 * @date 2018年1月31日
	 * @param userBean
	 * @param bindingResult
	 * @param modelMap
	 * @return 对不同的结果返回不同页面
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Valid UserBean userBean, BindingResult bindingResult,ModelMap modelMap,HttpServletRequest request) {
		logger.debug(userBean);
		// 判断数据校验结果
		if (bindingResult.hasErrors()) {
			// 打印校验信息
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				modelMap.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "register";
		}
		userBean.setUserPassword(UseMD5.md5MakePassword(userBean.getUserPassword()));
		/**
		 * 添加注册日志
		 * 如果用aop监视，注册时不能从session中获取用户名，并且只保存注册成功的日志
		 * 所以直接调用，添加日志
		 */
		LogBean logBean=new LogBean(0, userBean.getUserName(),
				DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"), 
				request.getRemoteAddr(), "数据库操作", "前台", "个人用户注册");

		logService.addLogBeans(logBean);
		
		userService.addUser(userBean);
		return "redirect:jsp/login.jsp";
	}


}
