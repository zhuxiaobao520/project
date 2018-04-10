package com.cbd.dao;

import java.util.List;

import com.cbd.bean.RentTaskBean;

/**
 * 
 * <p>Title:IRentTaskDao</p>
 * <p>Description:待办租赁任务DAO接口</p>
 * @author 龙成
 * @date2018年2月1日上午10:55:39
 */
public interface IRentTaskDao {
	
	/**
	 * 
	 * <p>Title:getRentTask</p>
	 * <p>Description:根据用户id获取所有待办租赁任务</p>
	 * @author 龙成
	 * @date2018年2月1日上午10:56:31
	 */
	public List<RentTaskBean> getAllRentTask(int userId);
	
	
	/**
	 * 
	 * <p>Title:getRentTask</p>
	 * <p>Description:根据用户id按页获取当前页待办租赁任务</p>
	 * @author 龙成
	 * @date2018年2月1日上午10:56:31
	 */
	public List<RentTaskBean> getRentTaskPage(int starPage,int pageSize,int userId);
}
