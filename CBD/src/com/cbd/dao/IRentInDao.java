package com.cbd.dao;

import java.util.List;

import com.cbd.bean.RentInBean;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.bean.RentInfoBean;
import com.cbd.entity.RentInEntity;
/**
 * 招租租赁记录dao
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface IRentInDao {
	/**
	 * 得到租赁信息
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 租赁人id
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<RentInBean> getRentInBeans(int rentInUserId,int startIndex,int pageSize);
	/**
	 * 得到租赁记录条数
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 租赁人id
	 * @return
	 */
	public int getRentInBeansNum(int rentInUserId);
	
	/**
	 * 
	 * <p>Title:updateRentInStatus</p>
	 * <p>Description:根据租赁者id和租赁信息id修改交易状态</p>
	 * @author 龙成
	 * @date2018年2月1日下午3:48:16
	 */
	public int updateRentInStatus(int rentInId,int rentInUserId,String rentInStatus);
	
	/**
	 * 
	 * <p>Title:updateOtherUserRentInStatus</p>
	 * <p>Description:多个人预约同一个车位时，修改未预约成功的租赁信息状态</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:13:40
	 */
	public int updateOtherUserRentInStatus(int rentOutId,int rentInUserId,String rentInStatus);
	
	/**
	 * 
	 * <p>Title:getRentInEntitiesByRentOutId</p>
	 * <p>Description:根据招租信息id，查询所有预约租赁该车位失败的租赁信息</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:55:54
	 */
	public List<RentInEntity> getRentInEntitiesByRentOutId(int rentOutId,int rentInId);
	

	/**
	 * 
	 * <p>Title:getRentInById</p>
	 * <p>Description: 根据租赁信息id和租赁者id查询租赁信息</p>
	 * @author 朱小宝
	 * @return RentInEntity
	 */
	public RentInEntity getRentInById(int id ,int userId);
	

	/**
	 * 租车位时，新增记录
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentInInsertBean
	 * @return 受影响行数
	 */
	public int addRentInRecord(RentInInsertBean rentInInsertBean);
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
	
	/**
	 * 得到租赁的详细信息包括租赁方和出租方信息，车位信息
	 * @author 姚刚
	 * @date 2018年2月5日
	 * @param rentInId
	 * @return
	 */
	public RentInfoBean getRentInfoBeanByRentInId(int rentInId);
}








