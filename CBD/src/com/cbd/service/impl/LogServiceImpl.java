package com.cbd.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.LogBean;
import com.cbd.bean.Pager;
import com.cbd.dao.ILogDao;
import com.cbd.service.ILogService;

@Component
public class LogServiceImpl implements ILogService {

	@Autowired
	private ILogDao logDao;
	
	@Override
	public Pager getPager(int currentPage, int pageSize, String logOperationType, String logType, Date startTime,
			Date endTime) {
		// TODO Auto-generated method stub
		int totalRecorNum=logDao.getLogBeansNum(logOperationType, logType, startTime, endTime);
		Pager pager=new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(logDao.getLogBeans(pager.getStartIndex(), pageSize, logOperationType, logType, startTime, endTime));
		return pager;
	}
   /**
    * 添加日志记录
    */
	@Override
	public void addLogBeans(LogBean logBean) {
		// TODO Auto-generated method stub
		logDao.addLogBeans(logBean);
	}

}
