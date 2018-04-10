package com.cbd.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.LogBean;
import com.cbd.dao.ILogDao;
import com.cbd.mapper.LogMapper;
import com.cbd.validator.Log;

/**
 * 日志的dao实现类
 * @author 姚刚
 *
 */

@Component
@Transactional
public class LogDaoImpl implements ILogDao {
	@Autowired
	private LogMapper logMapper; 
	
	@Override
	public List<LogBean> getLogBeans(int startIndex,int pageSize,String logOperationType,String logType,Date startTime,Date endTime) {
		// TODO Auto-generated method stub
		return logMapper.getLogBeans(startIndex, pageSize, logOperationType, logType, startTime, endTime);
	}
	@Override
	public int getLogBeansNum(String logOperationType, String logType, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return logMapper.getLogBeansNum(logOperationType, logType, startTime, endTime);
	}
	
	@Log(operationType="数据库操作",operationName="新增日志")
	@Override
	public void addLogBeans(LogBean logBean) {
		// TODO Auto-generated method stub
		logMapper.addLogBeans(logBean);
	}

}
