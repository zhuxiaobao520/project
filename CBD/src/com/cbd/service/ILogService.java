package com.cbd.service;

import java.util.Date;

import com.cbd.bean.LogBean;
import com.cbd.bean.Pager;
import com.mysql.jdbc.log.Log;
/**
 * 
 * @author 姚刚
 * @date 2018年2月2日
 */
public interface ILogService {
	/**
	 * 日志模糊分页
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param currentPage
	 * @param pageSize
	 * @param logOperationType 操作类型 登录，注销，数据库操作
	 * @param logType 日志类型：前台，后台
	 * @param startTime
	 * @param endTime
	 * @return
	 */
     public Pager getPager(int currentPage,int pageSize,String logOperationType,String logType,Date startTime,Date endTime);
     /**
      * 添加日志记录
      * @author 刘芯宇
      * @Date 2018年1月31日
      * @param logBean
      */
     public void addLogBeans(LogBean logBean);
}
