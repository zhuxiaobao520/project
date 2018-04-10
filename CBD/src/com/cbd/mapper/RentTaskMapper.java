package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cbd.bean.RentTaskBean;

/**
 * 
 * <p>Title:RentTaskMapper</p>
 * <p>Description:待办租赁任务映射接口</p>
 * @author 龙成
 * @date2018年2月1日上午10:39:13
 */
public interface RentTaskMapper extends SqlMapper{
	
	/**
	 * 
	 * <p>Title:getRentTask</p>
	 * <p>Description:根据用户id查询所有待办租赁任务</p>
	 * @author 龙成
	 * @date2018年2月1日上午10:45:36
	 */
	
	@Select("SELECT * from t_user a JOIN t_usercarport b JOIN t_rentout c JOIN t_rentin d "
			+ "ON (a.userId=b.userCarportUserId AND b.userCarportId = c.rentOutCarportId AND c.rentOutId = d.rentOutId)"
			+ "WHERE a.userId=#{userId} AND d.rentInStatus='待交易'")
	@Results({
		@Result(property="userCarportAddress",column="userCarportAddress"),
		@Result(property="userCarportAddressNo",column="userCarportAddressNo"),
		@Result(property="rentOutStartTime",column="rentOutStartTime"),
		@Result(property="rentOutEndTime",column="rentOutEndTime"),
		@Result(property="rentOutPrice",column="rentOutPrice"),
		@Result(property="rentInMessage",column="rentInMessage"),
		@Result(property="userCarportId",column="userCarportId"),
		@Result(property="rentInId",column="rentInId"),
		@Result(property="rentOutId",column="rentOutId"),
		@Result(property="userEntity",column="rentInUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))
	})
	public List<RentTaskBean> getAllRentTask(int userId);
	
	
	/**
	 * 
	 * <p>Title:getRentTask</p>
	 * <p>Description:根据用户id按页查询当前页待办租赁任务记录</p>
	 * @author 龙成
	 * @date2018年2月1日上午10:44:26
	 */
	@Select("SELECT * from t_user a JOIN t_usercarport b JOIN t_rentout c JOIN t_rentin d "
			+ "ON (a.userId=b.userCarportUserId AND b.userCarportId = c.rentOutCarportId AND c.rentOutId = d.rentOutId)"
			+ "WHERE a.userId=#{param3} AND d.rentInStatus='待交易' limit #{param1},#{param2}")
	@Results({
		@Result(property="userCarportAddress",column="userCarportAddress"),
		@Result(property="userCarportAddressNo",column="userCarportAddressNo"),
		@Result(property="rentOutStartTime",column="rentOutStartTime"),
		@Result(property="rentOutEndTime",column="rentOutEndTime"),
		@Result(property="rentOutPrice",column="rentOutPrice"),
		@Result(property="rentInMessage",column="rentInMessage"),
		@Result(property="userCarportId",column="userCarportId"),
		@Result(property="rentInId",column="rentInId"),
		@Result(property="rentOutId",column="rentOutId"),
		@Result(property="userEntity",column="rentInUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))
	})
	public List<RentTaskBean> getRentTaskPage(int starPage,int pageSize,int userId);
	
	
	
	
	
	
}
