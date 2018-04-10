package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.SaleRecordBean;
import com.cbd.entity.SaleEntity;

/**
 * 出售买卖记录接口
 * @Title:ISaleDao
 * @Description:
 * @author 黄先明
 * @dated 2018年2月1日
 */
public interface ISaleDao {
		
	/**
	 * 
	 * @Title:getSellRecordBean
	 * @Description:获取用户出售记录信息
	 * @author 黄先明
	 * @param sellUserId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 *
	 */
	public List<SaleRecordBean> getSellRecordBean(int sellUserId ,int startIndex,int pageSize);
	
	/**
	 * 
	 * @Title:getUserSellNum
	 * @Description:获取用户出售记录的条数
	 * @author 黄先明
	 * @param sellUserId
	 * @return
	 *
	 */
	public int getUserSellNum(int sellUserId);
	
	/**
	 * 
	 * @Title:getBuyRecordBean
	 * @Description:获取用户购买记录
	 * @author 黄先明
	 * @param buyUserId
	 * @param startIndex
	 * @param pageSize
	 * @return List<SaleRecordBean> 
	 *
	 */
	public List<SaleRecordBean> getBuyRecordBean(int buyUserId ,int startIndex,int pageSize);
	
	/**
	 * 
	 * @Title:getUserBuyNum
	 * @Description:获取用户购买记录总数
	 * @author 黄先明
	 * @param buyUserId
	 * @return int
	 *
	 */
	public int getUserBuyNum(int buyUserId);
	
	/**
	 * 
	 * @Title:getSaleRecordByBuyInfoId
	 * @Description:根据购买信息id获取购买信息
	 * @author 黄先明
	 * @param buyInfoId
	 * @return SaleRecordBean
	 *
	 */
	public SaleRecordBean getSaleRecordByBuyInfoId(int buyInfoId);
	
	/**
	 * 
	 * <p>Title:getByIdPageSale</p>
	 * <p>Description:根据出售信息id查询出售信息记录</p>
	 * @author 龙成
	 * @date2018年2月2日下午4:11:23
	 */
	public SaleEntity getByIdPageSale(int id);
	
	
}







