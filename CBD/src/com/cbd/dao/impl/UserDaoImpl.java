package com.cbd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.UserBean;
import com.cbd.dao.IUserDao;
import com.cbd.entity.UserEntity;
import com.cbd.mapper.UserMapper;
import com.cbd.validator.Log;

/**
 * 个人用户登陆接口实现类
 * @author 张同学
 *
 */
@Component
@Transactional //声明式事务管理
public class UserDaoImpl implements IUserDao {
	/**
	 * 个人用户登陆
	 */
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserEntity getUser(String name) {
		UserEntity userEntity =  userMapper.userBeans(name);
		return userEntity;
	}

	/**
	 * 王菁
	 */
	@Override
	public UserEntity selectUserById(int userId) {
		UserEntity userEntity = new UserEntity();
		userEntity = userMapper.selecteUserById(userId);
		return userEntity;
	}

	/**
	 * 王菁
	 */
	@Override
	@Log(operationType="数据库操作",operationName="修改用户密码")
	public int updateUserPwd(int userId, String userPassword) {
		int i = userMapper.updateUserPwdByParams(userId, userPassword);
		return i;
	}

	/**
	 * 王菁
	 */
	@Override
	@Log(operationType="数据库操作",operationName="修改用户信息")
	public int updateUserInfo(UserEntity userEntity) {
		int i = userMapper.updateUserInfo(userEntity);
		return i;
	}

	@Override
	public String selectUserNameById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserNameById(userId);
	}

	@Override
	@Log(operationType="数据库操作",operationName="添加用户")
	public int userRegister(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userMapper.addUser(userEntity);
	}
	
	@Override
	public UserEntity getUserByNameAndPwd(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userMapper.getUserByNameAndPwd(userName,userPassword);
	}

	@Log(operationType="数据库操作",operationName="修改投诉次数")
	@Override
	public int updateUserComplainedCount(int id) {
		// TODO Auto-generated method stub
		int num =userMapper.updateUserComplainedCount(id);
		updateUserReputation(id);
		return num;
	}

	

	@Override
	@Log(operationType="数据库操作",operationName="修改个人交易次数")
	public int updateUserBussinessCountById(int userId) {
		int num = userMapper.updateUserBussinessCountById(userId);		
		return num;
	}


	@Override
	@Log(operationType="数据库操作",operationName="修改个人信誉度")
	public int updateUserReputation(int userId) {
		UserEntity userEntity = selectUserById(userId);
		int userComplainedCount = userEntity.getUserComplainedCount();
		int userBussinessCount = userEntity.getUserBussinessCount();
		/* 重新计算信誉度 */
		double userReputation = (double)userComplainedCount/userBussinessCount;
		if(userReputation>=0 && userReputation<= 0.2){
			userReputation = 5.0;
		}else if(userReputation<=0.4){
			userReputation = 4.0;
		}else if(userReputation<=0.6){
			userReputation = 3.0;
		}else if(userReputation<=0.8){
			userReputation = 2.0;
		}else{
			userReputation = 1.0;
		}	
		return userMapper.updateUserReputation(userId, userReputation);
	}
}
