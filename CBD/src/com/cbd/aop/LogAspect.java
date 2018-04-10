package com.cbd.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CompanyBean;
import com.cbd.bean.LogBean;
import com.cbd.bean.UserBean;
import com.cbd.dao.impl.LogDaoImpl;
import com.cbd.service.ILogService;
import com.cbd.util.DateUtil;
import com.cbd.validator.Log;


/**
 * 日志切面类
 * @author 吴雪
 * 2018年2月1日
 */
@Component
@Aspect // 声明切面类
public class LogAspect {
	/**
	 * 注入LogService用于把日志保存数据库  
	 */
	@Autowired		
	private ILogService logService;
	
	private Logger logger = Logger.getLogger(LogAspect.class);
	
	/**
	 * @Pointcut 定义一个可被别的方法引用的切入点表达式
	 * dao层切点  ，给dao层实现类中的所用add、delete、update开头的方法打上标记
	 */
	@Pointcut("execution (* com.cbd.dao.impl.*.add*(..))"
			+ "||execution (* com.cbd.dao.impl.*.delete*(..))"
			+ "||execution (* com.cbd.dao.impl.*.update*(..))")  
	 public  void daoAspect() { }  

	/**
	 * 针对注销功能添加切点  ，
	 * 给loginController类中的注销exitLogin方法打上标记
	 */
	@Pointcut("execution (* com.cbd.controller.LoginController.exitLogin(..))")  
	 public  void controllerAspect() { }  
	
	/**
	 * @author 吴雪
	 * 2018年2月1日
	 * 后置增强加切点(抛出异常后依然执行),用于拦截Controller层记录用户的操作 
	 */
	@After("controllerAspect()||daoAspect() && !execution (* com.cbd.dao.impl.LogDaoImpl.*(..))")
	public void after(JoinPoint joinpoint) throws Throwable {
		/**
		 * 登陆者的用户名loginAccount
		 * 日志类型logType：前台或者后台（即管理员或用户）
		 * 操作类型operationType：增删改等
		 * 操作内容operationName:具体操作
		 */
		String loginAccount="";
		String logType="";
		String operationType="";
		String operationName="";
		
		/**
		 * 先获取request对象
		 * 然后获取登录后session中的登录用户对象和请求IP
		 */
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();
		String ip=request.getRemoteAddr();
		
		UserBean userBean=(UserBean) session.getAttribute("userLogin");
		CompanyBean companyBean=(CompanyBean) session.getAttribute("companyLogin");
		AdminBean adminBean=(AdminBean) session.getAttribute("adminLogining");
		
		/**
		 * 用于判断是哪个类型的用户登陆（企业用户/个人用户/管理员）
		 */
		if(userBean!=null){
			if(!"".equals(userBean.getUserName())&& userBean.getUserName()!=null){
				loginAccount=userBean.getUserName();
				logType="前台";
			}
		}else if(companyBean!=null){
			if(!"".equals(companyBean.getCompanyAccount())&&companyBean.getCompanyAccount()!=null){
				loginAccount=companyBean.getCompanyAccount();
				logType="前台";
			}
		}else if(adminBean!=null){
			if(!"".equals(adminBean.getAdminAccount())&&adminBean.getAdminAccount()!=null){
				loginAccount=adminBean.getAdminAccount();
				logType="后台";
			}
		}
		
		/**
		 *  获取目标对象包全名,通过反射获取该类中的所有方法名
		 */
		String classType = joinpoint.getTarget().getClass().getName();
		Class targetClass=Class.forName(classType);
		Method[] methods=targetClass.getMethods();
		
		/**
		 *  获取类名 className
		 *  获取方法名methodName
		 *  获取方法所有形参args
		 */
		String className = joinpoint.getTarget().getClass().getSimpleName();
		String methodName = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		
		/**
		 * 为了防止同一个类中有同名方法（方法重载），通过比较参数个数和参数类型确定方法
		 * 获取注解中的操作类型operationType和操作内容operationName
		 */
		for (Method method : methods) {
			if(method.getName().equals(methodName)){
				//获取方法所有形参类型
				Class[] clazzs=method.getParameterTypes();	
				if(clazzs.length==args.length){
					operationName=method.getAnnotation(Log.class).operationName()+","+methodName;
					operationType=method.getAnnotation(Log.class).operationType();
					break;
				}
			}
		}
		
		/**
		 * 往数据库中添加日志
		 */
		LogBean logBean=new LogBean(0, loginAccount,
						DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"), 
						ip, operationType, logType, operationName);
		
		logService.addLogBeans(logBean);
	}
}
