package com.cbd.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.Pager;
import com.cbd.service.ILogService;

/**
 * 日志控制器，分页
 * @author 姚刚
 *
 */
@Controller
public class LogController {

	@Autowired
	private ILogService logService;
	
	
	@RequestMapping(value="Log_yg/turnToLogPage")
	public String turnToLogPage(){
		return "managerJsp/logJsp_yg/LogPage_yg";
	}
	
	@RequestMapping(value="Log_yg/getLogPager")
	@ResponseBody
	public Pager getPager(HttpServletRequest request){
		String page=request.getParameter("currentPage");
		int currentPage=1;
		if(page.matches("[0-9]{1,}")){
			currentPage=Integer.parseInt(page);
		}
		if(currentPage<0){
			currentPage=1;
		}
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String startTime=request.getParameter("startDate");
		String endTime=request.getParameter("endDate");
		Date startDate=null;
		if(startTime!=null&&!"".equals(startTime)){
			try {
				startDate = simpleDateFormat.parse(startTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Date endDate=null;
		if(startTime!=null&&!"".equals(endTime)){
			try {
				endDate = simpleDateFormat.parse(endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String logOperationType=request.getParameter("logOperationType");
		String logType=request.getParameter("logType");
		Pager pager=logService.getPager(currentPage, 4, logOperationType, logType, startDate, endDate);
		return pager;
	} 
}
