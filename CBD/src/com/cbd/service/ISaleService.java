package com.cbd.service;

import com.cbd.bean.Pager;
import com.cbd.bean.SaleRecordBean;
import com.cbd.entity.SaleEntity;

/**
 * 
 * @Title:ISaleService
 * @Description:出售购买记录业务层
 * @author 黄先明
 * @dated 2018年2月1日
 */
public interface ISaleService {
	
	/**
	 * 
	 * @Title:getSaleRecordPager
	 * @Description:获取个人出售记录页面数据
	 * @author 黄先明
	 * @param sellUserId
	 * @param currentPage
	 * @param pageSize
	 * @return Pager
	 *
	 */
	public Pager getSaleRecordPager(int sellUserId, int currentPage, int pageSize);
	/**
	 * 
	 * @Title:getBuyRecordPager
	 * @Description:获取个人购买记录页面数据
	 * @author 黄先明
	 * @param buyUserId
	 * @param currentPage
	 * @param pageSize
	 * @return Pager
	 *
	 */
	public Pager getBuyRecordPager(int buyUserId, int currentPage, int pageSize);

	/**
	 * 
	 * @Title:getSaleRecordByBuyInfoId
	 * @Description:根据购买信息id查询买卖记录
	 * @author 黄先明
	 * @param buyInfoId
	 * @return SaleRecordBean
	 *
	 */
	public SaleRecordBean getSaleRecordByBuyInfoId(int buyInfoId);
	
	/**
	 * 
	 * <p>Title:getByIdPageSale</p>
	 * <p>Description:根据出售信息id查询出售记录</p>
	 * @author 龙成
	 * @date2018年2月2日下午4:12:37
	 */
	public SaleEntity getByIdPageSale(int id);
	
}
