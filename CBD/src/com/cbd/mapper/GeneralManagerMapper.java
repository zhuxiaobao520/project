package com.cbd.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * 普通管理员Mapper
 * 
 * @author 张同学
 *
 */
public interface GeneralManagerMapper extends SqlMapper {
	/**
	 * 修改普通管理员个人信息（密码）
	 * 
	 * @param newPassword
	 * @param newPhone
	 * @return
	 */
	@Update("update t_admin set adminPassword=#{param1} where adminId=#{param2}")
	public int updateGeneralManager(String newPassword,int adminId);
	
	/**
	 * 修改普通管理员个人信息（电话）
	 * @author zhangping
	 * @date 2018年2月8日
	 * @param newPhone
	 * @param adminId
	 * @return
	 */
	@Update("update t_admin set adminPhone=#{param1} where adminId=#{param2}")
	public int updateAdminPhone(String newPhone,int adminId);
}
