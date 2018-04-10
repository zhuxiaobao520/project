package com.cbd.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.AdminBean;
import com.cbd.bean.Pager;
import com.cbd.controller.AdminController;
import com.cbd.dao.IAdminDao;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.UserEntity;
import com.cbd.entity.UsercarportEntity;
import com.cbd.mapper.AdminMapper;
import com.cbd.validator.Log;

/**
 * 
 * <p>Title:AdminDaoImpl</p>
 * <p>Description: 管理员Dao实现类</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:56:56
 */

@Component
@Transactional
public class AdminDaoImpl implements IAdminDao{

	@Autowired
	private AdminMapper adminMapper;
	
	private static Logger logger=Logger.getLogger(AdminController.class);
	
	/**
	 * <p>Title:getAdmins</p>
	 * <p>Description: 查询所有管理员</p>
	 * @author 朱小宝
	 * @return list
	 */
	@Override
	public List<AdminEntity> getAdmins() {
		// TODO Auto-generated method stub
		List<AdminEntity> list=adminMapper.getAdmins();
		return list;
	}

	/**
	 * <p>Title:getAdminsByPage</p>
	 * <p>Description: 根据页数得到数据</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@Override
	public Pager getAdminsByPage(int currentPage) {
		// TODO Auto-generated method stub
		Pager pager=new Pager(5, getAdmins().size(), currentPage);
		List<AdminEntity> list=adminMapper.getAdminsByPage(pager.getStartIndex(), 5);
		pager.setDatas(list);
		logger.debug(list);
		return pager;
	}

	/**
	 * <p>Title:updateSuperAdminPassword</p>
	 * <p>Description: 修改超级管理员密码</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="修改超级管理员密码")
	@Override
	public int updateSuperAdminPassword(String newPassword) {
		// TODO Auto-generated method stub
		int num=adminMapper.updateSuperAdminPassword(newPassword);
		logger.debug("新密码:"+newPassword+"修改数据:"+num);
		return num;
	}

	/**
	 * 查询所有待租待审车位信息
	 * @return List<UserEntity>
	 */
	@Override
	public int getAllDaiZuUser() {
		// TODO Auto-generated method stub
		return adminMapper.getAllDaiZuUser();
	}

	/**
	 * 查询所有待租待审车位信息(分页)
	 * @return List<UserEntity>
	 */
	@Override
	public List<UsercarportEntity> getAllPageDaiZuUser(int page, int size) {
		// TODO Auto-generated method stub
		List<UsercarportEntity> list = adminMapper.getAllPageDaiZuUser(page, size);
		return list;
	} 
	
	/**
	 * <p>Title:addAdminByParam</p>
	 * <p>Description: 添加员工</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="新增普通管理员")
	@Override
	public int addAdminByParam(AdminBean adminBean) {
		// TODO Auto-generated method stub
		logger.debug(adminBean);
		AdminEntity adminEntity=new AdminEntity();
		adminEntity.setAdminAccount(adminBean.getAdminAccount());
		adminEntity.setAdminAgreementManagerPower(adminBean.getAdminAgreementManagerPower());
		adminEntity.setAdminCarPortManagerPower(adminBean.getAdminCarPortManagerPower());
		adminEntity.setAdminCompaintManagerPower(adminBean.getAdminCompaintManagerPower());
		adminEntity.setAdminNo(adminBean.getAdminNo());
		adminEntity.setAdminPassword(adminBean.getAdminPassword());
		adminEntity.setAdminPhone(adminBean.getAdminPhone());
		adminEntity.setAdminRealName(adminBean.getAdminRealName());
		adminEntity.setAdminType(0);
		adminEntity.setAdmiUserManagerPower(adminBean.getAdmiUserManagerPower());
		
		int num=adminMapper.addAdminByParam(adminEntity);
		return num;
	}

	/**
	 * <p>Title:getAdminInfoById</p>
	 * <p>Description: 根据id查询管理员</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Override
	public AdminEntity getAdminInfoById(int adminId) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=adminMapper.getAdminInfoById(adminId);
		return adminEntity;
	}

	/**
	 * <p>Title:updateAdminPower</p>
	 * <p>Description: 修改管理员权限</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="修改普通管理员权限")
	@Override
	public int updateAdminPower(AdminBean adminBean) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=new AdminEntity();
		adminEntity.setAdminAgreementManagerPower(adminBean.getAdminAgreementManagerPower());
		adminEntity.setAdminCarPortManagerPower(adminBean.getAdminCarPortManagerPower());
		adminEntity.setAdminCompaintManagerPower(adminBean.getAdminCompaintManagerPower());
		adminEntity.setAdmiUserManagerPower(adminBean.getAdmiUserManagerPower());
		adminEntity.setAdminId(adminBean.getAdminId());
		int num=adminMapper.updateAdminPower(adminEntity);
		return num;
	}

	/**
	 * <p>Title:deleteAdminInfo</p>
	 * <p>Description: 删除管理员信息</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="删除管理员")
	@Override
	public int deleteAdminInfo(int adminId) {
		// TODO Auto-generated method stub
		int num =adminMapper.deleteAdminInfo(adminId);
		return num;
	}

	/**
	 * <p>Title:getAdminByName</p>
	 * <p>Description: 根据管理员用户名查询管理员</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Override
	public AdminEntity getAdminByName(String adminAccount) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=adminMapper.getAdminByName(adminAccount);
		return adminEntity;
	}

	@Override
	public AdminEntity getAdminByAdminNo(String adminNo) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=adminMapper.getAdminByAdminNo(adminNo);
		return adminEntity;
	} 


}
