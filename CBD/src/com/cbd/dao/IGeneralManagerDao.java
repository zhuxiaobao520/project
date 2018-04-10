package com.cbd.dao;

import org.apache.ibatis.annotations.Update;

/**
 * 普通管理接口
 * 
 * @author 张同学
 *
 */
public interface IGeneralManagerDao {
	/**
	 * 修改普通管理员个人信息（密码）
	 * 
	 * @param newphone
	 * @param newPassword
	 * @return
	 */
	public int updateGeneralManager(String newPassword, int adminId);
	
	/**
	 * 修改普通管理员个人信息（电话）
	 * @author zhangping
	 * @date 2018年2月8日
	 * @param newPhone
	 * @param adminId
	 * @return
	 */
	public int updateAdminPhone(String newPhone,int adminId);
}
