package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.dao.IGeneralManagerDao;
import com.cbd.service.IGeneralManagerService;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 *普通管理员业务逻辑实现层
 * @author 张同学
 *
 */
@Component
@Transactional //声明式事务管理
public class GeneralManagerServiceImpl implements IGeneralManagerService {
	@Autowired 
	IGeneralManagerDao iGeneralManagerDao;

	/**
	 * 修改普通管理员个人信息（密码）
	 */
	
	@Override

	
	public Boolean updateGeneralManager(String newPassword,int adminId) {
			int num = iGeneralManagerDao.updateGeneralManager(newPassword,adminId);

			if(num==1){
				return true;
			}
		return false;
	}

	/**
	 * 修改电话
	 */
	@Override
	public Boolean updateAdminPhone(String newPhone, int adminId) {
		int num = iGeneralManagerDao.updateAdminPhone(newPhone, adminId);
		if(num==1){
			return true;
		}
			return false;
	}
	
	
}
