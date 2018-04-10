package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.RentTaskBean;
import com.cbd.bean.SaleTaskBean;
import com.cbd.dao.ISaleTaskDao;
import com.cbd.service.ISaleTaskService;

@Component
public class SaleTaskServiceImpl implements ISaleTaskService{
	@Autowired
	private ISaleTaskDao saleTaskDao;
	
	@Override
	public Pager getSaleTaskPager(int curPage, int userId) {
		Pager saleTaskPager = new Pager();
		int totalRecorNum = saleTaskDao.getAllSaleTaskById(userId, "待交易").size();
		int pageSize = saleTaskPager.getPageSize();
		int totalPageNum = totalRecorNum%pageSize==0?totalRecorNum/pageSize:(totalRecorNum/pageSize+1);
		int startIndex = (curPage-1)*pageSize;
		List<SaleTaskBean> datas = saleTaskDao.getSaleTaskPage(startIndex, pageSize, userId, "待交易");
		
		saleTaskPager.setCurrentPage(curPage);
		saleTaskPager.setDatas(datas);
		saleTaskPager.setStartIndex(startIndex);
		saleTaskPager.setTotalPageNum(totalPageNum);
		saleTaskPager.setTotalRecorNum(totalRecorNum);
		
		return saleTaskPager;
	}

}
