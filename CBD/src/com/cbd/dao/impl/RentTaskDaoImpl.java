package com.cbd.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.RentTaskBean;
import com.cbd.dao.IRentTaskDao;
import com.cbd.mapper.RentTaskMapper;

@Component
@Transactional
public class RentTaskDaoImpl implements IRentTaskDao{
	
	@Autowired
	private RentTaskMapper rentTaskMapper;
	
	private static Logger logger=Logger.getLogger(RentTaskDaoImpl.class);
	
	
	@Override
	public List<RentTaskBean> getAllRentTask(int userId) {
		List<RentTaskBean> allRentTask = null;
		allRentTask = rentTaskMapper.getAllRentTask(userId);
		logger.debug(allRentTask);
		return allRentTask;
	}

	@Override
	public List<RentTaskBean> getRentTaskPage(int starPage, int pageSize, int userId) {
		List<RentTaskBean> rentTaskPage = null;
		rentTaskPage = rentTaskMapper.getRentTaskPage(starPage, pageSize, userId);
		logger.debug(rentTaskPage);
		return rentTaskPage;
	}

}
