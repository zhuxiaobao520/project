package com.cbd.service;

import java.util.List;

import com.cbd.bean.Pager;
import com.cbd.bean.SaleBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.UsercarportEntity;

/**
 * 个人车位信息业务层接口
 * @author 唐小雄
 *
 */
public interface IUsercarportService {
	
	/**
	 * 根据id查询车位信息接口
	 * @return 唐小雄
	 */
	public UsercarportEntity getByIdUsercarport(int id);
	
	/**
	 * 根据id修改车位审核状态
	 * @param id
	 * @return null
	 * @user 唐小雄
	 */
	public void updateByIdUsercarport(String userCarportAuditingStatus,int id);

	/**
	 * 
	 * <p>Title:getUsercarportsByUserId</p>
	 * <p>Description:根据用户id查询所有车位空闲的车位</p>
	 * @author 杨明健
	 * @date2018年1月31日上午10:43:44
	 */
	public List<UsercarportEntity> getUserCarportsByUserId(int id);
	
	/**
	 * 
	 * <p>Title:addSaleBySaleBean</p>
	 * <p>Description:根据返回的int的值来判断是否修改和增加成功</p>
	 * @author 杨明健
	 * @date2018年1月31日下午1:52:30
	 */
	public boolean addSaleBySaleBean(SaleBean saleBean);
	
	/**
	 * 
	 * <p>Title:addUsercarportByUsercarportBean</p>
	 * <p>Description:根据返回的int的值来判断是否增加成功</p>
	 * @author 杨明健
	 * @date2018年1月31日下午3:36:29
	 */
	public boolean addUsercarportByUsercarportBean(UsercarportBean usercarportBean);
	
	/**
	 * 
	 * <p>Title:getPageUsercarport</p>
	 * <p>Description:分页查询所有出售车位的信息</p>
	 * @author 杨明健
	 * @date2018年2月1日上午11:38:58
	 */
	public Pager getPageUsercarport(int curPage, String endTime,int userId);
	
	/**
	 * 
	 * <p>Title:updateUserCarportStatusByUserCarportId</p>
	 * <p>Description:根据车位id修改车位的状态</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:22:28
	 */
	public int updateUserCarportStatusByUserCarportId(int userCarportId,String userCarportStatus);
	
	/**
	 * 
	 * <p>Title:addReserveBuy</p>
	 * <p>Description:根据返回值判断是否添加预定买车位信息</p>
	 * @author 杨明健
	 * @date2018年2月2日上午9:15:17
	 */
	public boolean addReserveBuy(ReserveBuyBean reserveBuyBean);
	/**
	 * 查询用户发布出去的车位信息
	 * @author yinshi
	 * @date 2018年2月7日
	 * @param userId
	 * @param curPage
	 * @param i
	 * @return
	 */
	public Pager getUserOutCarportsByUserId(int userId, int curPage, int i);

	
	/**
	 * 查询用户空闲车位
	 * @author yinshi
	 * @date 2018年2月8日
	 * @param userId
	 * @param curPage
	 * @param i
	 * @return
	 */
	public Pager getUserNullCarportByUserId(int userId, int curPage, int i);
}












