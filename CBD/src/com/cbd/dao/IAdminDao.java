package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.AdminBean;
import com.cbd.bean.Pager;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.UsercarportEntity;

/**
 * 
 * <p>Title:IAdminDao</p>
 * <p>Description: 管理员Dao接口</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:56:37
 */
public interface IAdminDao {

	//查询所有普通管理员
	public List<AdminEntity> getAdmins();
	
	//根据当前页查询相应的管理员
	public Pager getAdminsByPage(int currentPage);
	
	//修改超级管理员密码
	public int updateSuperAdminPassword(String newPassword);
	
	//添加普通管理员
	public int addAdminByParam(AdminBean adminBean);
	
	//根据Id查询管理员
	public AdminEntity getAdminInfoById(int adminId);
	
	//修改管理员权限
	public int updateAdminPower(AdminBean adminBean);
	
	//删除管理员信息
	public int deleteAdminInfo(int adminId);
	
	//根据管理员账号名查询管理员
	public AdminEntity getAdminByName(String adminAccount);

	//查询所有待租待审车位信息
	public int getAllDaiZuUser();

	//查询所有待租待审车位信息(分页)
	public List<UsercarportEntity> getAllPageDaiZuUser(int begin, int size);
	
	/**
	 * 
	 * <p>Title:getAdminByAdminNo</p>
	 * <p>Description: 根据工号查询管理员</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	public AdminEntity getAdminByAdminNo(String adminNo);
}
