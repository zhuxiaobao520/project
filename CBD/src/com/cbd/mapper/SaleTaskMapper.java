package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cbd.bean.SaleTaskBean;

/**
 * 
 * <p>Title:SaleTaskMapper</p>
 * <p>Description:待办出售任务映射接口</p>
 * @author 龙成
 * @date2018年2月2日上午9:49:28
 */
public interface SaleTaskMapper extends SqlMapper{
	
	/**
	 * 
	 * <p>Title:getAllSaleTaskById</p>
	 * <p>Description:根据用户id查询所有待办出售任务</p>
	 * @author 龙成
	 * @date2018年2月2日上午9:51:48
	 */
	@Select("SELECT * FROM t_user a JOIN t_usercarport b JOIN t_sale c JOIN t_buyinfo d"
			+ " ON (a.userId=b.userCarportUserId AND b.userCarportId=c.saleCarportId AND c.saleId=d.buyInfoSaleId)"
			+ " WHERE a.userId=#{param1} AND d.buyInfoStatus = #{param2}")
	@Results({
		@Result(property="userCarportAddress",column="userCarportAddress"),
		@Result(property="userCarportAddressNo",column="userCarportAddressNo"),
		@Result(property="saleCarportId",column="saleCarportId"),
		@Result(property="buyInfoId",column="buyInfoId"),
		@Result(property="buyInfoSaleId",column="buyInfoSaleId"),
		@Result(property="salePrice",column="salePrice"),
		@Result(property="buyInfoMassage",column="buyInfoMassage"),
		@Result(property="userEntity",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))
	})
	public List<SaleTaskBean> getAllSaleTaskById(int userId,String buyInfoStatus);
	
	
	
	
	/**
	 * 
	 * <p>Title:getSaleTaskPage</p>
	 * <p>Description:按页获取当前页显示的待办出售任务</p>
	 * @author 龙成
	 * @date2018年2月2日上午10:21:13
	 */
	@Select("SELECT * FROM t_user a JOIN t_usercarport b JOIN t_sale c JOIN t_buyinfo d"
			+ " ON (a.userId=b.userCarportUserId AND b.userCarportId=c.saleCarportId AND c.saleId=d.buyInfoSaleId)"
			+ " WHERE a.userId=#{param3} AND d.buyInfoStatus = #{param4} limit #{param1},#{param2}")
	@Results({
		@Result(property="userCarportAddress",column="userCarportAddress"),
		@Result(property="userCarportAddressNo",column="userCarportAddressNo"),
		@Result(property="saleCarportId",column="saleCarportId"),
		@Result(property="buyInfoId",column="buyInfoId"),
		@Result(property="buyInfoSaleId",column="buyInfoSaleId"),
		@Result(property="salePrice",column="salePrice"),
		@Result(property="buyInfoMassage",column="buyInfoMassage"),
		@Result(property="userEntity",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))
	})
	public List<SaleTaskBean> getSaleTaskPage(int starPage,int pageSize,int userId,String buyInfoStatus);
	
	
}





















