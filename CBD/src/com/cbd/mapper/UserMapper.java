package com.cbd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.UserBean;
import com.cbd.entity.UserEntity;



/**
 * 个人用户登陆Mapper接口
 * @author 张同学
 *
 */
public interface UserMapper extends SqlMapper {
	/**
	 * 个人用户登陆
	 * @author zhangping
	 * @date 2018年2月1日
	 * @param name
	 * @return
	 */
	@Select("select * from t_user where userName=#{name}")
	public UserEntity userBeans(String name);
	
	@Select("select * from t_user where userId=#{id}")
	public UserEntity getByIdUser(int id);

	/**
	 * 王菁
	 * 根据id查询个人用户
	 */
	@Select("select * from t_user where userId=#{userId}")
	public UserEntity selecteUserById(int userId);
	
	/**
	 * 王菁
	 * 修改个人用户密码
	 */
	@Update("update t_user set userPassword = #{param2} where userId = #{param1} ")
	public int updateUserPwdByParams(int userId,String password);
	
	/**
	 * 王菁
	 * 修改个人信息
	 */
	@Update("update t_user set userAddress = #{userAddress},"
			+ "userPhone = #{userPhone},userProfession = #{userProfession},"
			+ " userEmail = #{userEmail} where userId = #{userId}")
	public int updateUserInfo(UserEntity userEntity);
	
	/**
	 * 王菁
	 * 添加注册用户
	 */
	@Insert("insert into t_user(userName,userPassword,userRealName,userAddress,userPhone,userIdCard,userProfession,userEmail)"
			+ "values("
			+ "#{userName},#{userPassword},#{userRealName},#{userAddress},#{userPhone},#{userIdCard},#{userProfession},#{userEmail})")
	public int addUser(UserEntity userEntity);
	
	/**
	* 姚刚
	* 查询用户名
	 */
	@Select("select userName from t_user where userId=#{userId}")
	public String selectUserNameById(int userId);

	
	/**
	 * 根据用户名和密码查询
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	@Select("select * from t_user where userName = #{param1} and userPassword = #{param2}")
	public UserEntity getUserByNameAndPwd(String userName, String userPassword);

	
	/**
	 * 
	 * <p>Title:updateUserComplainedCount</p>
	 * <p>Description: 投诉生效后，用户被投诉次数加1</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Update("update t_user set userComplainedCount=userComplainedCount+1 where userId=#{id}")
	public int updateUserComplainedCount(int id);

	
	/**
	 * 
	 * <p>Title:updateUserBussinessCountById</p>
	 * <p>Description:根据个人id修改个人交易次数(+1)</p>
	 * @author 龙成
	 * @date2018年2月2日上午11:16:17
	 */
	@Update("update t_user set userBussinessCount = userBussinessCount+1 where userId=#{userId}")
	public int updateUserBussinessCountById(int userId);
	
	/**
	 * 
	 * <p>Title:updateUserReputation</p>
	 * <p>Description:根据用户id，修改用户的信誉度</p>
	 * @author 龙成
	 * @date2018年2月2日上午11:36:24
	 */
	@Update("update t_user set userReputation=#{param2} where userId=#{param1}")
	public int updateUserReputation(int userId,double userReputation);
	

}
