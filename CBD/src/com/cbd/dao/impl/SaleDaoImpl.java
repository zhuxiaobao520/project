package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.SaleRecordBean;
import com.cbd.dao.ISaleDao;
import com.cbd.entity.SaleEntity;
import com.cbd.mapper.ISaleMapper;

/**
 * 用户出售买卖信息接口实现类
 * @Title:SaleDaoImpl
 * @Description:
 * @author 黄先明
 * @dated 2018年2月1日
 */

@Component
@Transactional
public class SaleDaoImpl implements ISaleDao{
	@Autowired
	private ISaleMapper ISaleMapper;
	@Override
	public List<SaleRecordBean> getSellRecordBean(int sellUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return ISaleMapper.getSellRecordBean(sellUserId, startIndex, pageSize);
	}
	@Override
	public int getUserSellNum(int sellUserId) {
		// TODO Auto-generated method stub
		return ISaleMapper.getUserSellNum(sellUserId);
	}
	@Override
	public List<SaleRecordBean> getBuyRecordBean(int buyUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return ISaleMapper.getBuyRecordBean(buyUserId, startIndex, pageSize);
	}
	@Override
	public int getUserBuyNum(int buyUserId) {
		// TODO Auto-generated method stub
		return ISaleMapper.getUserBuyNum(buyUserId);
	}
	@Override
	public SaleRecordBean getSaleRecordByBuyInfoId(int buyInfoId) {
		// TODO Auto-generated method stub
		return ISaleMapper.getSaleRecordByBuyInfoId(buyInfoId);
	}
	@Override
	public SaleEntity getByIdPageSale(int id) {
		// TODO Auto-generated method stub
		return ISaleMapper.getByIdPageSale(id);
	}

}
