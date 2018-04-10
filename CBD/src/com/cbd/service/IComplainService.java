package com.cbd.service;

import java.util.HashMap;

import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;

	/**
	 * 
	 * <p>Title:IComplainService</p>
	 * <p>Description: 投诉信息service层接口</p>
	 * @author 朱小宝
	 * @date2018年2月1日下午2:51:44
	 */
	public interface IComplainService {

	/**
	 * 
	 * <p>Title:getComplainByPage</p>
	 * <p>Description: 投诉信息Dao层接口</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	public Pager getComplainByPage(int curPage);
	
	/**
	 * 
	 * <p>Title:getComplainInfoById</p>
	 * <p>Description: 根据Id查询被选中的投诉记录信息</p>
	 * @author 朱小宝
	 * @return HashMap<String,Object>
	 */
	public HashMap<String, Object> getComplainInfoById(int id);
	
	/**
	 * 
	 * <p>Title:updateComplainStatus</p>
	 * <p>Description:修改投诉状态 </p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	public Boolean updateComplainStatus(int id,String complainStatus);
	
	/**
	 * 
	 * @Title:addComplainInsertBean
	 * @Description:插入投诉记录
	 * @author 黄先明
	 * @param complainInsertBean
	 * @return
	 *
	 */
	public int addComplainInsertBean(ComplainInsertBean complainInsertBean);
	
	

	/**
	 * 判断事件是否被用户投诉
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param complainUserId 投诉人Id
	 * @param complainEventId 事件id 
	 * @param complainEventType 事件类型:招租，租赁，出售，购买
	 * @return true 已投诉，false 未投诉
	 */
	public boolean eventIsComplained(int complainUserId,int complainEventId,String complainEventType);
}
