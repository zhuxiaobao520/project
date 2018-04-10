package com.cbd.service;

import com.cbd.bean.UserBean;
import com.cbd.entity.UserEntity;

/**
 * 个人用户业务逻辑接口
 * @author 张平
 *
 */
public interface IUserService {
		/**
		 * 个人用户登陆
		 * @author zhangping
		 * @date 2018年2月1日
		 * @param name
		 * @return
		 */
		public UserEntity uEntity(String name);
		
		/**
		 * 
		 * 根据id查询个人用户
		 * 王菁
		 */
		public UserBean selectUserById(int userId);
		
		/**
		 * 
		 * 修改个人用户密码
		 * 王菁
		 */
		public boolean updateUserPwd(int userId,String userPassword);
		
		/**
		 * 
		 * 修改个人信息
		 * 王菁
		 */
		public boolean updateUserInfo(UserBean userBean);

		/**
		 * 根据名字查询UserBean
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param username
		 * @return UserBean
		 */
		public UserBean getUserByUsername(String username);

		/**
		 * 添加注册用户
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param userBean
		 */
		public void addUser(UserBean userBean);
		
		/**
		 * 个人用户登录
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param userName --用户名
		 * @param userPassword  --密码
		 */
		public UserBean getUserByNameAndPwd(String userName,String userPassword);
		
		/**
		 * 
		 * <p>Title:updateUserBussinessCountById</p>
		 * <p>Description:根据id修改个人用户交易次数(+1)</p>
		 * @author 龙成
		 * @date2018年2月2日上午11:41:05
		 */
		public boolean updateUserBussinessCountById(int userId);
		
		/**
		 * 
		 * <p>Title:updateUserReputation</p>
		 * <p>Description:根据用户id更新用户的信誉度</p>
		 * @author 龙成
		 * @date2018年2月2日上午11:41:38
		 */
		public boolean updateUserReputation(int userId);
		
		
}
