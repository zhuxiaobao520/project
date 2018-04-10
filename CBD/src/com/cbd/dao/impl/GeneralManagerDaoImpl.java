package com.cbd.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.controller.GeneralManagerController;
import com.cbd.dao.IGeneralManagerDao;
import com.cbd.mapper.GeneralManagerMapper;
import com.cbd.validator.Log;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;

/**
 * 普通管理接口实现层
 * @author 张同学
 *
 */
@Component
@Transactional
public class GeneralManagerDaoImpl implements IGeneralManagerDao{
	@Autowired
	private GeneralManagerMapper generalManagerMapper;
	
	/**
	 * 修改普通管理员个人信息（密码）
	 */
	@Override
	@Log(operationType="数据库操作",operationName="修改普通管理员个人信息（密码）")
	public int updateGeneralManager(String newPassword,int adminId) {
		// TODO Auto-generated method stub
		int num = generalManagerMapper.updateGeneralManager(newPassword,adminId);
		return num;
	}

		/**
		 * 修改普通管理员个人信息（电话）
		 */
	@Override
	@Log(operationType="数据库操作",operationName="修改普通管理员个人信息（电话）")
	public int updateAdminPhone(String newPhone, int adminId) {
		return generalManagerMapper.updateAdminPhone(newPhone, adminId);
	}
	
}
