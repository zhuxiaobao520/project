package com.cbd.service;

import com.cbd.bean.Pager;

/**
 * 
 * <p>Title:ISaleTaskService</p>
 * <p>Description:待办出售任务service接口</p>
 * @author 龙成
 * @date2018年2月2日上午10:35:36
 */
public interface ISaleTaskService {
	
	/**
	 * 
	 * <p>Title:getSaleTaskPager</p>
	 * <p>Description:按页获取待办出售任务</p>
	 * @author 龙成
	 * @date2018年2月2日上午10:36:31
	 */
	public Pager getSaleTaskPager(int curPage, int userId);
	
}








