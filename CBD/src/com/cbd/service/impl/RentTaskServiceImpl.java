package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.RentTaskBean;
import com.cbd.dao.IRentTaskDao;
import com.cbd.service.IRentTaskService;

/**
 * 
 * <p>Title:RentTaskServiceImpl</p>
 * <p>Description:待办任务Service实现类</p>
 * @author 龙成
 * @date2018年2月1日上午11:15:23
 */
@Component
public class RentTaskServiceImpl implements IRentTaskService{
	
	@Autowired
	private IRentTaskDao rentTaskDao;
	
	@Override
	public Pager getRentTaskPager(int curPage, int userId) {
		Pager rentTaskPager = new Pager();
		int totalRecorNum = rentTaskDao.getAllRentTask(userId).size();
		int pageSize = rentTaskPager.getPageSize();
		int totalPageNum = totalRecorNum%pageSize==0?totalRecorNum/pageSize:(totalRecorNum/pageSize+1);
		int startIndex = (curPage-1)*pageSize;
		List<RentTaskBean> datas = rentTaskDao.getRentTaskPage(startIndex, pageSize, userId);
		
		rentTaskPager.setCurrentPage(curPage);
		rentTaskPager.setDatas(datas);
		rentTaskPager.setStartIndex(startIndex);
		rentTaskPager.setTotalPageNum(totalPageNum);
		rentTaskPager.setTotalRecorNum(totalRecorNum);
		
		return rentTaskPager;
	}

}
