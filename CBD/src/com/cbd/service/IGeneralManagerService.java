package com.cbd.service;

/**
 * 普通管理员业务逻辑接口
 * @author 张同学
 *
 */

public interface IGeneralManagerService {
			/**
			 * 修改普通管理员个人信息（密码）
			 * 
			 */
	public Boolean updateGeneralManager(String newPassword,int adminId);
	
	/**
	 * 修改普通管理员个人信息（电话）
	 * 
	 */
public Boolean updateAdminPhone(String newPhone,int adminId);
}
