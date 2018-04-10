package com.cbd.service;

import java.util.List;

import com.cbd.bean.AdminBean;
import com.cbd.bean.Pager;
import com.cbd.entity.AdminEntity;

/**
 * 
 * <p>Title:IAdminService</p>
 * <p>Description: 管理员Service接口</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:57:50
 */
public interface IAdminService {

	public Pager getAdminsByPage(int currentPage);
	/**
	 * 唐小雄
	 * @param page
	 * @param size
	 * @return
	 */
	public Pager getAllDaiZuUser(int page, int size);
	
	/**
	 * <p>Description: 修改管理员密码</p>
	 * @author朱小宝
	 * @return
	 */
	 public Boolean updateSuperAdminPassword(String password);
	 
   /**
	* <p>Description: 添加普通员工</p>
	* @author朱小宝
	* @return
	*/
	public Boolean addAdminByParam(AdminBean adminBean);
	
	//根据id查询管理员
	public AdminEntity getAdminInfoById(int adminId);
	
	//修改管理员权限
	public Boolean updateAdminPower(AdminBean adminBean);
	
	//删除管理员信息
	public Boolean deleteAdminInfo(int adminId);
	

	//登录根据用户名与密码查询
	public AdminBean getAdminByAccount(String adminAccount,String adminPassword);

	/**
	 * 根据用户名查询是否存在
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param username
	 * @return adminbean
	 */
	public AdminBean getAdminByAdminName(String username);
	
	/**
	 * 
	 * <p>Title:getAdminByAdminNo</p>
	 * <p>Description: 根据工号查询管理员</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	public AdminEntity getAdminByAdminNo(String adminNo);

	
	
}
