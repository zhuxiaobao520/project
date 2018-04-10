package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.cbd.bean.Pager;
import com.cbd.bean.SaleBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.UsercarportEntity;

/**
 * 个人车位信息dao层接口
 * @author 唐小雄
 *
 */
public interface IUsercarportDao {

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
	 * @date2018年1月31日上午10:29:21
	 */
	public List<UsercarportEntity> getUserCarportsByUserId(int id);
	
	/**
	 * 
	 * <p>Title:addSaleBySaleBean</p>
	 * <p>Description:根据出售信息的车位id更改车位表的车位状态和根据出售信息添加车位的出售信息表</p>
	 * @author 杨明健
	 * @date2018年1月31日下午1:45:46
	 */
	public int addSaleBySaleBean(SaleBean saleBean);
	
	/**
	 * 
	 * <p>Title:addUsercarportByUsercarportBean</p>
	 * <p>Description:先根据个人车位的车位产权证编号查询，再添加新车位</p>
	 * @author 杨明健
	 * @date2018年1月31日下午3:31:54
	 */
	public int addUsercarportByUsercarportBean(UsercarportBean usercarportBean);

	
	/**
	 * 
	 * <p>Title:getAllUsercarport</p>
	 * <p>Description:分页查询所有出售车位的信息</p>
	 * @author 杨明健
	 * @date2018年2月1日上午11:13:21
	 */
	public Pager getPageUsercarport(int curPage, String endTime,int userId);

	
	/**
	 * 根据车位id更改车位表的车位状态
	 * @author yg
	 * @date 2018年2月1日
	 * @param userCarportId 车位id
	 * @param userCarportStatus 车位状态，待租，待售，已租，已售，空闲
	 * @return
	 */
	public int updateUserCarportStatusByUserCarportId(int userCarportId,String userCarportStatus);

	/**
	 * 
	 * <p>Title:addReserveBuy</p>
	 * <p>Description:添加预定车位购买信息</p>
	 * @author 杨明健
	 * @date2018年2月1日下午5:23:39
	 */
	public int addReserveBuy(ReserveBuyBean reserveBuyBean);

	/**
	 * 删除未通过车位
	 * @author 吴雪
	 * 2018年2月7日
	 */
	public void deleteUserCarportById(int userCarportId);

	
	/**
	 * 得到用户发布出去的车位信息的条数
	 * @author yinshi
	 * @date 2018年2月7日
	 * @return
	 */
	public int getUserOutCarPortById(int userId);

	
	/**
	 * 分页查询用户发布的车位信息
	 * @author yinshi
	 * @date 2018年2月7日
	 * @param userId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List getUserOutCarPortByParam(int userId, int startIndex, int pageSize);

	
	/**
	 * 查询用户空闲车位条数
	 * @author yinshi
	 * @date 2018年2月8日
	 * @param userId
	 * @return
	 */
	public int getUserNullCarPortById(int userId);

	
	/**
	 * 分页查询用户空闲车位
	 * @author yinshi
	 * @date 2018年2月8日
	 * @param userId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List getUserNullCarPortByParam(int userId, int startIndex, int pageSize);
	
}
