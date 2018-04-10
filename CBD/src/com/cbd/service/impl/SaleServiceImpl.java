package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.SaleRecordBean;
import com.cbd.dao.ISaleDao;
import com.cbd.entity.SaleEntity;
import com.cbd.service.ISaleService;

/**
 * 
 * @Title:SaleServiceImpl
 * @Description:用户出售购买记录信息业务实现类
 * @author 黄先明
 * @dated 2018年2月1日
 */
@Component
public class SaleServiceImpl implements ISaleService{
	@Autowired
	private ISaleDao ISaleDao;

	@Override
	public Pager getSaleRecordPager(int sellUserId, int currentPage, int pageSize) {
		int totalSize=ISaleDao.getUserSellNum(sellUserId);
		
		Pager pager =new Pager(pageSize, totalSize, currentPage);
		pager.setDatas(ISaleDao.getSellRecordBean(sellUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public Pager getBuyRecordPager(int buyUserId, int currentPage, int pageSize) {
		int totalSize=ISaleDao.getUserBuyNum(buyUserId);
		Pager pager =new Pager(pageSize, totalSize, currentPage);
		pager.setDatas(ISaleDao.getBuyRecordBean(buyUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public SaleRecordBean getSaleRecordByBuyInfoId(int buyInfoId) {
		// TODO Auto-generated method stub
		return ISaleDao.getSaleRecordByBuyInfoId(buyInfoId);
	}

	@Override
	public SaleEntity getByIdPageSale(int id) {
		return ISaleDao.getByIdPageSale(id);
	}
	

}
