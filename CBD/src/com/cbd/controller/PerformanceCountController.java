package com.cbd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.interceptor.PerformanceCountInterceptor;

/**
 * 
 * @author 吴雪
 *
 */
@Controller
public class PerformanceCountController {
	private static Logger logger=Logger.getLogger(PerformanceCountController.class);
	
	/**
	 * 跳转到性能统计界面
	 */
	@RequestMapping("jumpPerformance")
	public String jumpPerformance(){
		return "/managerJsp/wuxue/perfomanceCount";
	}
	
	/**
	 * @author 吴雪
	 * Description：接收性能统计拦截器中的数据，经过处理在页面中显示折线图
	 * @return:从性能统计拦截器中获取的数据
	 */
	@RequestMapping("performanceCount")
	@ResponseBody
	public List<List<String>> performanceInfo(){
		List<List<String>> performanceInfo=new ArrayList<>();
		performanceInfo=PerformanceCountInterceptor.getPerformanceInfo();
		return performanceInfo;
	}
}
