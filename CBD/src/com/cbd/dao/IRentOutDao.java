package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.entity.RentOutEntity;
import com.cbd.bean.UseableRentOutInfoBean;
/**
 * 出租记录的dao
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface IRentOutDao {
	/**
	 * 查询出租记录
	 * @author yg
	 * @date 2018年2月1日
	 * @param rentOutUserId 出租用户id 即是当前用户id
	 * @param userCarportStatus 是待租还是已租
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<RentOutBean> getRentOutBeans(int rentOutUserId, int startIndex, int pageSize);
	
	/**
	 * 当前出租记录数
	 * @author yg
	 * @date 2018年2月1日
	 * @param rentOutUserId 出租用户id 即是当前用户id
	 * @param userCarportStatus 是待租还是已租
	 * @return
	 */
	public int getRentOutBeansNum(int rentOutUserId);
	
	/**
	 * 添加出租记录返回添加成功后的主键id
	 * @author yg
	 * @date 2018年2月1日
	 * @param rentOutInsertBean
	 * @return
	 */
	public int addRentOutBean(RentOutInsertBean rentOutInsertBean);
	
	/**
	 * 
	 * <p>Title:getRentOutById</p>
	 * <p>Description:根据招租信息id查询招租记录</p>
	 * @author 龙成
	 * @date2018年2月1日下午4:40:20
	 */
	public RentOutEntity getRentOutById(int rentOutId);
	/**
	 * 查询所有可以租的出租车位信息
	 * @author yg
	 * @date 2018年2月1日
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<UseableRentOutInfoBean>getUseableCarport(int startIndex, int pageSize);
	/**
	 * 得到可以租的车位数量
	 * @author yg
	 * @date 2018年2月1日
	 * @return
	 */
	public int getUseableCarportNum();
	
	/**
	 * 得到出租信息表指定可以租的记录详情
	 * @author yg
	 * @date 2018年2月1日
	 * @param rentOutId 出租信息表主键
	 * @return
	 */
	public UseableRentOutInfoBean getUseableRentOutInfoByRentOutId(int rentOutId);
	
	/**
	 * 查询指定的出租记录
	 * @author yg
	 * @date 2018年1月31日
	 * @param rentOutId 出租记录的id
	 * @param rentInId 租赁记录的id
	 * @return 得到当前用户出租完成交易的记录
	 */
	public RentOutBean getRentOutBean(int rentInId);
	
	/**
	 * 根据车位id查询车位出租记录的数量
	 * 用于验证车位是否已经出租过了
	 * @author 姚刚
	 * @date 2018年2月7日
	 * @param userCarportId
	 * @param userCarportStatus 车位状态
	 * @param userCarportAuditingStatus 审核状态
	 * @return
	 */
	public int getRentOutByCarportId(int userCarportId,String userCarportStatus,String  userCarportAuditingStatus);
	
}
