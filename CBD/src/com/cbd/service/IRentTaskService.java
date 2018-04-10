package com.cbd.service;

import com.cbd.bean.Pager;

/**
 * 
 * <p>Title:IRentTaskService</p>
 * <p>Description:待办任务Service接口</p>
 * @author 龙成
 * @date2018年2月1日上午11:13:10
 */

public interface IRentTaskService {
	
	/**
	 * 
	 * <p>Title:getRentTaskPager</p>
	 * <p>Description:根据页面要求获取pagerBean对象</p>
	 * @author 龙成
	 * @date2018年2月1日上午11:14:14
	 */
	public Pager getRentTaskPager(int curPage,int userId);
}
