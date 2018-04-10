package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.SaleTaskBean;
import com.cbd.dao.ISaleTaskDao;
import com.cbd.mapper.SaleTaskMapper;

@Component
@Transactional
public class SaleTaskDaoImpl implements ISaleTaskDao{
	
	@Autowired
	private SaleTaskMapper saleTaskMapper;
	
	@Override
	public List<SaleTaskBean> getAllSaleTaskById(int userId, String buyInfoStatus) {
		return saleTaskMapper.getAllSaleTaskById(userId, buyInfoStatus);
	}

	@Override
	public List<SaleTaskBean> getSaleTaskPage(int starPage, int pageSize, int userId, String buyInfoStatus) {
		return saleTaskMapper.getSaleTaskPage(starPage, pageSize, userId, buyInfoStatus);
	}

}
