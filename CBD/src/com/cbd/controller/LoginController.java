package com.cbd.controller;

import java.util.Date;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CompanyBean;
import com.cbd.bean.LogBean;
import com.cbd.bean.LoginType;
import com.cbd.bean.UserBean;
import com.cbd.realm.CustomizedToken;
import com.cbd.service.IAdminService;
import com.cbd.service.ICompanyService;
import com.cbd.service.ILogService;
import com.cbd.service.IUserService;
import com.cbd.util.DateUtil;
import com.cbd.util.UseMD5;
import com.cbd.validator.Log;

/**
 * 登录控制器
 * 
 * @author yinshi
 * @date 2018年2月1日
 */
@Controller
public class LoginController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ILogService logService;
	
	private Logger logger = Logger.getLogger(LoginController.class); 
	
	
	private static final String USER_LOGIN_TYPE = LoginType.USER.toString();
	private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();
	private static final String COMPANY_LOGIN_TYPE = LoginType.COMPANY.toString();
	private int lineCount = 0; 
	/**
	 * 个人用户登录
	 * 
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param userBean
	 * @param session
	 * @return
	 */
	@RequestMapping(value="userLogin", method = RequestMethod.POST)
	public String userlogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userPassword") String userPassword, HttpServletRequest request,
			HttpSession session) {
		Subject currentUser = SecurityUtils.getSubject();
		request.removeAttribute("message");
		request.removeAttribute("userName");
		String userPwd = UseMD5.md5MakePassword(userPassword);
		UserBean userBean = userService.getUserByNameAndPwd(userName, userPwd);
		if (userBean != null) {
			CustomizedToken token = new CustomizedToken(userName, userPwd, USER_LOGIN_TYPE);
			try {
				logger.debug(userBean);
				currentUser.login(token);
				session.setAttribute("userLogin", userBean);
		        
				addLog(userName, request.getRemoteAddr(), "登录", "前台", "个人用户登录");
				return "redirect:jsp/userJsp/userHome.jsp";
			} catch (IncorrectCredentialsException ice) {
				
			} catch (LockedAccountException lae) {
				
			} catch (AuthenticationException ae) {
				
			}
		}
		request.setAttribute("userName", userName);
		request.setAttribute("message", "用户名/密码不匹配，请确认你的登录类型");
		return "login";
	}

	/**
	 * 企业用户登录
	 * 
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param userName
	 * @param userPassword
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="companyLogin", method = RequestMethod.POST)
	public String companyLogin(@RequestParam(value = "userName") String companyAccount,
			@RequestParam(value = "userPassword") String companyPassword, HttpServletRequest request,
			HttpSession session) {
		Subject currentUser = SecurityUtils.getSubject();
		request.removeAttribute("message");
		request.removeAttribute("userName");
		String companyPwd = UseMD5.md5MakePassword(companyPassword);
		CompanyBean companyBean = companyService.getCompanyByNameAndPwd(companyAccount, companyPwd);
		if (companyBean != null) {
			CustomizedToken token = new CustomizedToken(companyAccount, companyPwd,COMPANY_LOGIN_TYPE);
			try {
				logger.debug(companyBean);
				currentUser.login(token);
				session.setAttribute("companyLogin", companyBean);
				addLog(companyAccount, request.getRemoteAddr(), "登录", "前台", "企业用户登录");
				return "redirect:jsp/companyJsp/wangjing/companyMain.jsp";
			} catch (IncorrectCredentialsException ice) {
				
			} catch (LockedAccountException lae) {
			} catch (AuthenticationException ae) {
			}
		}
		request.setAttribute("userName", companyAccount);
		request.setAttribute("message", "用户名/密码不匹配，请确认你的登录类型");
		return "login";
	}

	/**
	 * 管理员登录
	 * <p>
	 * Title:adminLogin
	 * </p>
	 * <p>
	 * Description: 管理员登录
	 * </p>
	 * 
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping(value = "admLogin", method = RequestMethod.POST)
	public String adminLogin(@RequestParam("userName") String adminAccount,
			@RequestParam("userPassword") String adminPassword, HttpServletRequest request,
			HttpSession session) {
		// 将用户输入的密码加密盐后在与数据库中的密码比对
		Subject currentUser = SecurityUtils.getSubject();
		request.removeAttribute("message");
		request.removeAttribute("userName");
		String adminPwd = UseMD5.md5MakePassword(adminPassword);
		AdminBean adminBean = adminService.getAdminByAccount(adminAccount, adminPwd);
		
		if (adminBean != null) {
			CustomizedToken token = new CustomizedToken(adminAccount, adminPwd,ADMIN_LOGIN_TYPE);
			try {
				currentUser.login(token);
				logger.debug(adminBean);
				session.setAttribute("adminLogining", adminBean);
				if (adminBean.getAdminType() == 1) {
					addLog(adminAccount, request.getRemoteAddr(), "登录", "后台", "超级管理员登录");
					return "redirect:jsp/managerJsp/hxm/superAdmin.jsp";
				} else {
					addLog(adminAccount, request.getRemoteAddr(), "登录", "后台", "管理员登录");
					return "redirect:jsp/managerJsp/adminTemplate.jsp";
				}
			} catch (IncorrectCredentialsException ice) {
				
			} catch (LockedAccountException lae) {
			} catch (AuthenticationException ae) {
			}
		}
		request.setAttribute("userName", adminAccount);
		request.setAttribute("message", "用户名/密码不匹配，请确认你的登录类型");
		return "login";
	}

	
	/**
	 * @author 吴雪
	 * 2018年2月2日
	 * 用户注销
	 */
	@RequestMapping("jumpExit")
	@Log(operationName="用户退出登录",operationType="注销")
	public String exitLogin(HttpSession session){
        ServletContext context = session.getServletContext();  
        int lineCount = 0;
        if(context.getAttribute("lineCount")!=null){
        	lineCount=(Integer) context.getAttribute("lineCount"); 
        }
        context.setAttribute("lineCount", lineCount - 1);  
        HashSet<HttpSession> sessionSet = (HashSet<HttpSession>) context.getAttribute("sessionSet");  
        if(sessionSet!=null){  
            sessionSet.remove(session);  
        }  
       
		return "redirect:jsp/home.jsp";
	}
	
	/**
	 * @author 吴雪
	 * 2018年2月2日
	 * 如果使用aop监视用户登录，会出现登陆失败也书写登陆操作日志的情况
	 * 所以没有使用aop监视登陆操作，而是直接添加
	 */
	public void addLog(String account,String ip,String operationType,String logType,String operationName){
		LogBean logBean=new LogBean(0, account,
				DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"), 
				ip, operationType, logType, operationName);

		logService.addLogBeans(logBean);
	}
}
