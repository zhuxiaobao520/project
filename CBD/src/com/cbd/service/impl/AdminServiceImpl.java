package com.cbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.AdminBean;
import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.dao.IAdminDao;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.entity.UserEntity;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IAdminService;
import com.cbd.util.UseMD5;

/**
 * 
 * <p>Title:AdminServiceImpl</p>
 * <p>Description: 管理员Service实现类</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:58:13
 */

@Component
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminDao adminDao;
	
	/**
	 * <p>getAdminsByPage</p>
	 * <p>Description: 根据当前页数查询数据</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@Override
	public Pager getAdminsByPage(int currentPage) {
		// TODO Auto-generated method stub
		Pager pager=adminDao.getAdminsByPage(currentPage);
		return pager;
	}

	//根据当前页查询每页待租信息
	//By 唐小雄
	@Override
	public Pager getAllDaiZuUser(int page, int size) {
		// TODO Auto-generated method stub
		int totalSize = adminDao.getAllDaiZuUser();
		Pager pager = new Pager(size, totalSize, page);
		List<UsercarportEntity> list = adminDao.getAllPageDaiZuUser(pager.getStartIndex(), size);
		pager.setDatas(list);
		return pager;
	}

	/**
	 * <p>updateSuperAdminPassword</p>
	 * <p>Description: 修改超级管理员密码</p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	@Override
	public Boolean updateSuperAdminPassword(String password) {
		// TODO Auto-generated method stub
		int num=adminDao.updateSuperAdminPassword(password);
		if(num==1){
			return true;
		}
		return false;
	}

	/**
	 * <p>addAdminByParam</p>
	 * <p>Description: 添加员工</p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	@Override
	public Boolean addAdminByParam(AdminBean adminBean) {
		// TODO Auto-generated method stub
			int num=adminDao.addAdminByParam(adminBean);
			if(num==1){
				return true;
		}
		return false;
	}

	/**
	 * <p>getAdminInfoById</p>
	 * <p>Description: 添加员工</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Override
	public AdminEntity getAdminInfoById(int adminId) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=adminDao.getAdminInfoById(adminId);
		return adminEntity;
	}

	/**
	 * <p>updateAdminPower</p>
	 * <p>Description: 修改管理员权限</p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	@Override
	public Boolean updateAdminPower(AdminBean adminBean) {
		// TODO Auto-generated method stub
		int num=adminDao.updateAdminPower(adminBean);
		if(num==1){
			return true;
		}
		return false;
	}

	/**
	 * <p>deleteAdminInfo</p>
	 * <p>Description: 删除管理员信息</p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	@Override
	public Boolean deleteAdminInfo(int adminId) {
		// TODO Auto-generated method stub
		int num=adminDao.deleteAdminInfo(adminId);
		if(num==1){
			return true;
		}
		return false;
	}


	/**
	 * <p>getAdminByAccount</p>
	 * <p>Description: 根据用户名与密码查询是否登录</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Override
	public AdminBean getAdminByAccount(String adminAccount,String adminPassword){
		AdminEntity adminEntity=adminDao.getAdminByName(adminAccount);
		if(adminEntity!=null && adminEntity.getAdminPassword().equals(adminPassword)){
			AdminBean aBean=new AdminBean();
			aBean.setAdminAccount(adminEntity.getAdminAccount());
			aBean.setAdminAgreementManagerPower(adminEntity.getAdminAgreementManagerPower());
			aBean.setAdminCarPortManagerPower(adminEntity.getAdminCarPortManagerPower());
			aBean.setAdminCompaintManagerPower(adminEntity.getAdminCompaintManagerPower());
			aBean.setAdminId(adminEntity.getAdminId());
			aBean.setAdminNo(adminEntity.getAdminNo());
			aBean.setAdminPassword(adminEntity.getAdminPassword());
			aBean.setAdminPhone(adminEntity.getAdminPhone());
			aBean.setAdminRealName(adminEntity.getAdminRealName());
			aBean.setAdminType(adminEntity.getAdminType());
			aBean.setAdmiUserManagerPower(adminEntity.getAdmiUserManagerPower());
			return aBean;
		}
		return null;
	}

	@Override
	public AdminBean getAdminByAdminName(String username) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = adminDao.getAdminByName(username);
		if(adminEntity != null){
			AdminBean aBean=new AdminBean();
			aBean.setAdminAccount(adminEntity.getAdminAccount());
			aBean.setAdminAgreementManagerPower(adminEntity.getAdminAgreementManagerPower());
			aBean.setAdminCarPortManagerPower(adminEntity.getAdminCarPortManagerPower());
			aBean.setAdminCompaintManagerPower(adminEntity.getAdminCompaintManagerPower());
			aBean.setAdminId(adminEntity.getAdminId());
			aBean.setAdminNo(adminEntity.getAdminNo());
			aBean.setAdminPassword(adminEntity.getAdminPassword());
			aBean.setAdminPhone(adminEntity.getAdminPhone());
			aBean.setAdminRealName(adminEntity.getAdminRealName());
			aBean.setAdminType(adminEntity.getAdminType());
			aBean.setAdmiUserManagerPower(adminEntity.getAdmiUserManagerPower());
			return aBean;
		}
		return null;
	}

	@Override
	public AdminEntity getAdminByAdminNo(String adminNo) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity=adminDao.getAdminByAdminNo(adminNo);
		return adminEntity;
	}


}
