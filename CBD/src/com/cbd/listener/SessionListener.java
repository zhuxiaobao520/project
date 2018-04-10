package com.cbd.listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CompanyBean;
import com.cbd.bean.UserBean;

/**
 * @author 吴雪
 * 2018年2月5日
 * 统计在线人数监听器类
 */
@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		ServletContext context=session.getServletContext();
		/**
		 * 用set集合来存储session对象
		 */
		HashSet<HttpSession> sessionSet=(HashSet<HttpSession>) context.getAttribute("sessionSet");
		
		if (sessionSet==null) {
			sessionSet=new HashSet<>();
			context.setAttribute("sessionSet", sessionSet);
		}
		
		
		UserBean userBean=(UserBean) session.getAttribute("userLogin");
		CompanyBean companyBean=(CompanyBean) session.getAttribute("companyLogin");
		AdminBean adminBean=(AdminBean) session.getAttribute("adminLogining");
		/**
		 * 用于判断是哪个类型的用户登陆（企业用户/个人用户/管理员）
		 * 并获取登录用户的用户名
		 */
		Object object=null;
		if(userBean!=null){
			object=userBean;
		}else if(companyBean!=null){
			object=companyBean;
		}else if(adminBean!=null){
			object=adminBean;
		}
		
		/**
		 * 为了检验用户是否登录，登录的话移除session，加入新session
		 */
		for(HttpSession s:sessionSet){
			if (s.getAttribute("userLogin")!=null) {
				if(object==s.getAttribute("userLogin")){
					sessionSet.remove(s);
				}
			}
			if (s.getAttribute("companyLogin")!=null) {
				if(object==s.getAttribute("companyLogin")){
					sessionSet.remove(s);
				}
			}
			if (s.getAttribute("adminLogining")!=null) {
				if(object==s.getAttribute("adminLogining")){
					sessionSet.remove(s);
				}
			}
		}
		sessionSet.add(session);
		/**
		 * 存储在线人数，利用了set的不重复特性，避免重复登录
		 */
		context.setAttribute("lineCount", sessionSet.size());
	}

	@Override
	/**
	 * session的销毁监听
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		ServletContext context=event.getSession().getServletContext();
		if(context.getAttribute("lineCount")==null){
			context.setAttribute("lineCount", 0);
		}else {
			int lineCount=(int) context.getAttribute("lineCount");
			if(lineCount<1){
				lineCount=1;
			}
			context.setAttribute("lineCount", lineCount-1);
		}
		HttpSession session=event.getSession();
		HashSet<HttpSession> sessionSet=(HashSet<HttpSession>) context.getAttribute("sessionSet");
		if(sessionSet!=null){
			sessionSet.remove(session);
		}
	}

}
