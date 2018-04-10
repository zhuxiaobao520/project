package com.cbd.interceptor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class PerformanceCountInterceptor extends HandlerInterceptorAdapter{
	/**
	 * 执行开始系统时间
	 */
	private static long beginTime;
	/**
	 * 执行结束系统时间
	 */
	private static long endTime;
	/**
	 * 响应执行消耗时间
	 */
	private static String elapseTime;
	/**
	 * 获取响应的路径
	 */
	private static String path;
	
	/**
	 * 存放路径集合
	 */
	private List<String> allElapseTime=new ArrayList<>();
	
	/**
	 * 存放时间集合
	 */
	private List<String> allPath=new ArrayList<>();
	
	/**
	 * 存放路径和时间集合
	 */
	private static List<List<String>> allInfo=new ArrayList<>();
	
	/**
	 * 在前端控制器发给页面控制器的过程中拦截
	 * 获取执行前的系统时间
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		this.beginTime=System.currentTimeMillis();
		return true;
	}

	/**
	 * 在前端控制器渲染视图后,发给前端浏览器的过程中拦截
	 * 获取执行后系统执行时间和响应名
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//使用DecimalFormat使得到的时间保留两位小数
		DecimalFormat dFormat=new DecimalFormat("######0.000");
		
		this.endTime=System.currentTimeMillis();
		this.elapseTime=dFormat.format((this.endTime-this.beginTime)*0.001);
		
		/**
		 * 获取相应的controller页面处理器响应的路径，得到如：/userLogin
		 */
		path=request.getServletPath();
		
		/**
		 * 去path中的斜杠,仅获取路径名
		 */
		path=path.substring(1);
		
		allPath.add(path);
		allElapseTime.add(elapseTime);
		
		/**
		 * 控制数组的长度使其只装5个记录，避免服务器开的时间过长，缓存过大
		 */
		if(allInfo.size()>5){
			allInfo.clear();
		}
		allInfo.add(allPath);
		allInfo.add(allElapseTime);
		
	}
	
	public static List<List<String>> getPerformanceInfo(){
		return allInfo;
	}
}
