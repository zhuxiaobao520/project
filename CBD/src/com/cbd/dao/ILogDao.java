package com.cbd.dao;

import java.util.Date;
import java.util.List;

import com.cbd.bean.LogBean;

/**
 * 日志的dao
 * @author 姚刚
 *
 */
public interface ILogDao {
	/**
	 * 日志模糊分页
	 * @author 姚刚
	 *
	 */
	public List<LogBean>getLogBeans(int startIndex,int pageSize,String logOperationType,String logType,Date startTime,Date endTime);
	/**
	 * 日志模糊记录数
	 * @author 姚刚
	 *
	 */
	public int getLogBeansNum(String logOperationType,String logType,Date startTime,Date endTime);
    /**
     * 添加日志记录
     * @author 刘芯宇
     * @Date 2018年1月31日
     * @param logBean
     */
    public void addLogBeans(LogBean logBean);
}
