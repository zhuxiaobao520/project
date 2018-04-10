package com.cbd.dao;

import com.cbd.bean.UserBean;
import com.cbd.entity.UserEntity;

/**
 * 用户登陆Dao接口
 * @author 张同学
 *
 */
public interface IUserDao {
		/**
		 * 个人用户登陆
		 * @param name
		 * @return
		 */
		public UserEntity getUser(String name);
		
		/**
		 * 王菁
		 * 根据用户id查询用户
		 */
		public UserEntity selectUserById(int userId);
		
		/**
		 * 王菁
		 * 修改用户密码
		 */
		public int updateUserPwd(int userId,String userPassword);
		
		/**
		 * 王菁
		 * 修改个人信息
		 */
		public int updateUserInfo(UserEntity userEntity);
		
		/**
		 * 姚刚
		 * 查询用户名
		 */
		public String selectUserNameById(int userId);

		/**
		 * 添加用户
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param userEntity
		 * @return 影响的行数
		 */
		public int userRegister(UserEntity userEntity);

		/**
		 * 根据用户名和密码查询
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param userName
		 * @param userPassword
		 * @return 返回用户实体
		 */
		public UserEntity getUserByNameAndPwd(String userName, String userPassword);

		
		/**
		 * 
		 * <p>Title:updateUserComplainedCount</p>
		 * <p>Description: 投诉生效后，用户被投诉次数加1</p>
		 * @author 朱小宝
		 * @return int
		 */
		public int updateUserComplainedCount(int id);


		/**
		 * 
		 * <p>Title:updateUserBussinessCountById</p>
		 * <p>Description:根据id修改个人交易次数（+1）</p>
		 * @author 龙成
		 * @date2018年2月2日上午11:37:55
		 */
		public int updateUserBussinessCountById(int userId);
		
		/**
		 * 
		 * <p>Title:updateUserReputation</p>
		 * <p>Description:根据用户id修改用户的信誉度</p>
		 * @author 龙成
		 * @date2018年2月2日上午11:38:38
		 */
		public int updateUserReputation(int userId);

}





