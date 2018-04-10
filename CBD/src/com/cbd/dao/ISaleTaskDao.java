package com.cbd.dao;

import java.util.List;

import com.cbd.bean.SaleTaskBean;

/**
 * 
 * <p>Title:ISaleTaskDao</p>
 * <p>Description:待办出售任务Dao接口</p>
 * @author 龙成
 * @date2018年2月2日上午10:22:16
 */
public interface ISaleTaskDao {
	
	/**
	 * 
	 * <p>Title:getAllSaleTaskById</p>
	 * <p>Description:根据用户id查询所有待办出售任务</p>
	 * @author 龙成
	 * @date2018年2月2日上午10:23:19
	 */
	public List<SaleTaskBean> getAllSaleTaskById(int userId,String buyInfoStatus);
	
	
	/**
	 * 
	 * <p>Title:getSaleTaskPage</p>
	 * <p>Description:根据id，按页查询当前页的待办出售任务</p>
	 * @author 龙成
	 * @date2018年2月2日上午10:31:34
	 */
	public List<SaleTaskBean> getSaleTaskPage(int starPage,int pageSize,int userId,String buyInfoStatus);
	
}
