package com.cbd.service;


import java.util.List;

import com.cbd.bean.Pager;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.entity.RentInEntity;
/**
 * 租赁记录的业务层
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface IRentInSerevice {
	/**
	 * 根据当前用户id 获得当前用户租赁记录集合
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 当前用户的id
	 * @param currentPage
	 * @param pageSize
	 * @return 当前用户租赁记录集合
	 */
	public Pager getRentInPager(int rentInUserId,int currentPage,int pageSize);
	
	/**
	 * 
	 * <p>Title:updateRentInStatus</p>
	 * <p>Description:根据租赁者id和租赁信息id修改交易状态</p>
	 * @author 龙成
	 * @date2018年2月1日下午3:50:08
	 */
	public boolean updateRentInStatus(int rentInId, int rentInUserId, String rentInStatus);
	
	/**
	 * 
	 * <p>Title:updateOtherUserRentInStatus</p>
	 * <p>Description:根据招租id和租赁者id，修改对应这条招租id的租赁记录状态（多个人预约同一个车位）</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:16:13
	 */
	public boolean updateOtherUserRentInStatus(int rentOutId, int rentInUserId, String rentInStatus);
	
	/**
	 * 
	 * <p>Title:getRentInEntitiesByRentOutId</p>
	 * <p>Description:根据招租信息id，查询所有预约租赁该车位且未成功的租赁信息</p>
	 * @author 龙成
	 * @date2018年2月1日下午9:03:57
	 */
	public List<RentInEntity> getRentInEntitiesByRentOutId(int rentOutId, int rentInId);
	
	/**
	 * 租车位时，新增记录
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentInInsertBean
	 * @return 是否成功租赁
	 */
	public boolean addRentInRecord(RentInInsertBean rentInInsertBean);
	/**
	 * 用于查询当前用户是否租赁了响应的出租记录
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param rentOutId
	 * @param rentInUserId
	 * @return
	 */
	public int getRentInNumByRentOutIdAndRentInUserId(int rentOutId,int rentInUserId);
	/**
	 * 根据租赁记录id查询出租赁相关信息，包括出租人信息和出租信息
	 * 及车位信息
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param rentInId
	 * @return
	 */
	public RentInComplainBean getRentInComplainBean(int rentInId);
	
}
