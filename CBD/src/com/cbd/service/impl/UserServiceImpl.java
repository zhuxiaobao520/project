package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.UserBean;
import com.cbd.dao.IUserDao;
import com.cbd.entity.UserEntity;
import com.cbd.service.IUserService;

/**
 * 个人用户登陆业务逻辑实现层
 * 
 * @author 张平
 *
 */
@Component
public class UserServiceImpl implements IUserService {
	/**
	 * 个人用户登陆
	 * 
	 * @author zhangping
	 * @date 2018年2月1日
	 * @param name
	 * @return
	 */
	@Autowired
	private IUserDao userDao;

	@Override
	public UserEntity uEntity(String name) {
		UserEntity userEntity = userDao.getUser(name);
		return userEntity;
	}

	/**
	 * 
	 * 王菁
	 */
	@Override
	public UserBean selectUserById(int userId) {
		UserBean userBean = new UserBean();
		UserEntity userEntity = userDao.selectUserById(userId);
		userBean.setUserId(userEntity.getUserId());
		userBean.setUserName(userEntity.getUserName());
		userBean.setUserPassword(userEntity.getUserPassword());
		userBean.setUserRealName(userEntity.getUserRealName());
		userBean.setUserAddress(userEntity.getUserAddress());
		userBean.setUserPhone(userEntity.getUserPhone());
		userBean.setUserIdCard(userEntity.getUserIdCard());
		userBean.setUserProfession(userEntity.getUserProfession());
		userBean.setUserComplainedCount(userEntity.getUserComplainedCount());
		userBean.setUserReputation(userEntity.getUserReputation());
		userBean.setUserBussinessCount(userEntity.getUserBussinessCount());
		userBean.setUserEmail(userEntity.getUserEmail());
		return userBean;
	}

	/**
	 * 
	 * 王菁
	 */
	@Override
	public boolean updateUserPwd(int userId, String userPassword) {

		int i = userDao.updateUserPwd(userId, userPassword);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * 王菁
	 */
	@Override
	public boolean updateUserInfo(UserBean userBean) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userBean.getUserId());
		userEntity.setUserAddress(userBean.getUserAddress());
		userEntity.setUserPhone(userBean.getUserPhone());
		userEntity.setUserProfession(userBean.getUserProfession());
		userEntity.setUserEmail(userBean.getUserEmail());
		int i = userDao.updateUserInfo(userEntity);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserBean getUserByUsername(String username) {
		UserEntity userEntity = userDao.getUser(username);
		if (userEntity != null) {
			return userEntityToUserbean(userEntity);
		}
		return null;
	}

	@Override
	public void addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		UserEntity userEntity = new UserEntity(userBean.getUserName(), userBean.getUserPassword(),
				userBean.getUserRealName(), userBean.getUserAddress(), userBean.getUserPhone(),
				userBean.getUserIdCard(), userBean.getUserProfession(), userBean.getUserEmail());
		int num = userDao.userRegister(userEntity);
	}

	@Override
	public UserBean getUserByNameAndPwd(String userName, String userPassword) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.getUserByNameAndPwd(userName, userPassword);
		if(userEntity != null){
			return  userEntityToUserbean(userEntity);
		}
		return null;
	}

	private UserBean userEntityToUserbean(UserEntity userEntity) {
		UserBean userBean = new UserBean(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserPassword(),
				userEntity.getUserRealName(), userEntity.getUserAddress(), userEntity.getUserPhone(),
				userEntity.getUserIdCard(), userEntity.getUserProfession(), userEntity.getUserComplainedCount(),
				userEntity.getUserEmail(), userEntity.getUserReputation(), userEntity.getUserBussinessCount());
		return userBean;
	}

	@Override
	public boolean updateUserBussinessCountById(int userId) {
		int num = userDao.updateUserBussinessCountById(userId);
		if(num != 1){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserReputation(int userId) {
		int num = userDao.updateUserReputation(userId);
		if(num != 1){
			return false;
		}
		return true;
	}

}
