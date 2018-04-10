package com.cbd.service;

import com.cbd.bean.Pager;
import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.entity.RentOutEntity;
/**
 * 出租记录的业务层
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface IRentOutService {
	/**
	 * 查询当前用户的出租记录
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId
	 * @param currentPage
	 * @param pageSize
	 * @return 查询当前用户的出租交易完成的记录集合
	 */
	public Pager getRentOutPager(int rentOutUserId,int currentPage,int pageSize);
	/**
	 * 添加出租记录
	 * 当对应车位为空闲时才能添加出租信息
	 * 添加出租信息后车位状态改为待租
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentOutInsertBean 出租记录表对应的所有信息
	 * @return 添加是否成功
	 */
	public boolean addRentOutBean(RentOutInsertBean rentOutInsertBean);
	
	
	/**
	 * 
	 * <p>Title:getRentOutById</p>
	 * <p>Description:根据招租信息id查询招租记录</p>
	 * @author 龙成
	 * @date2018年2月1日下午4:41:59
	 */
	public RentOutEntity getRentOutById(int rentOutId);
	
	/**
	 * 得到所有可租空闲车位的数量
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	public Pager getUseableCarportPager(int currentPage, int pageSize);
	/**
	 * 得到出租信息表指定可以租的记录详情
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentOutId 出租信息表主键
	 * @return
	 */
	public UseableRentOutInfoBean getUseableRentOutInfoByRentOutId(int rentOutId);
	
	/**
	 * 查询指定的出租记录
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutId 出租记录的id
	 * @param rentInId 租赁记录的id
	 * @return 得到当前用户出租完成交易的记录
	 */
	public RentOutBean getRentOutBean(int rentInId);
	
	/**
	 * 用于查询当前车位是否已经申请出租，
	 * 防治重复提交车位
	 * @author 姚刚
	 * @date 2018年2月7日
	 * @param userCarportId
	 * @return
	 */
	public boolean getRentOutByCarportId(int userCarportId);
}
