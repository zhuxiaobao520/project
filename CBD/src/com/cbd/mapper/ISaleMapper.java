package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cbd.bean.SaleRecordBean;
import com.cbd.entity.SaleEntity;

/**
 * 出售车位信息mapper接口
 * @author 唐小雄
 *
 */
public interface ISaleMapper extends SqlMapper{

	/**
	 * 查询所有出售车位信息
	 * @return 唐小雄
	 */
	@Select("select count(*) from t_sale")
	public int getAllSale();
	
	/**
	 * 查询所有出售车位信息（分页）
	 * @return 唐小雄
	 */
	@Select("select * from t_sale limit #{param1},#{param2}")
	@Results({  
	    @Result(id=true,property="saleId",column="saleId"),  
	    @Result(property="salePrice",column="salePrice"),  
	    @Result(property="salePublishTime",column="salePublishTime"),  
	    @Result(property="saleCarport",column="saleCarportId",one=@One(select="com.cbd.mapper.UsercarportMapper.getByIdUsercarport"))  })  
	public List<SaleEntity> getAllPageSale(int page,int size);
	
	/**
	 * 根据id查询出售车位信息
	 * @return 唐小雄
	 */
	@Select("select * from t_sale where saleId=#{id}")
	@Results({  
		@Result(id=true,property="saleId",column="saleId"),  
		@Result(property="salePrice",column="salePrice"),  
		@Result(property="salePublishTime",column="salePublishTime"),  
		@Result(property="saleCarport",column="saleCarportId",one=@One(select="com.cbd.mapper.UsercarportMapper.getByIdUsercarport"))  })  
	public SaleEntity getByIdPageSale(int id);
	


	/**
	 * 
	 * @Title:getSellRecordBean
	 * @Description:获取用户出售记录
	 * @author 黄先明
	 * @param sellUserId
	 * @param startIndex
	 * @param pageSize
	 * @return List<SaleRecordBean>
	 *
	 */
	@Select("SELECT * FROM (t_user JOIN t_usercarport ON userId = userCarportUserId  join t_sale ON "+ 
			"userCarportId = saleCarportId join t_buyinfo ON saleId= buyInfoSaleId) JOIN t_agreement ON "+
			"agreementBuyInfoId=buyInfoId "+
			"WHERE userId=#{param1} and buyInfoStatus='交易成功' LIMIT #{param2},#{param3}")
	@Results(value={
			@Result(column="buyInfoId",property="buyInfoId"),
			@Result(column="carportAddress",property="userCarportAddress"),
			@Result(column="carportAddressNo",property="userCarportAddressNo"),
			@Result(column="agreementTime",property="dealDate"),
			@Result(column="salePrice",property="dealPrice"),
			@Result(column="buyInfoUserId",property="buyInfoUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById")),
			@Result(column="userId",property="sellUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById"))
	})
	public List<SaleRecordBean> getSellRecordBean(int sellUserId ,int startIndex,int pageSize);
	

	/**
	 * 
	 * @Title:getUserSellNum
	 * @Description:获取用户出售记录条数
	 * @author 黄先明
	 * @param sellUserId
	 * @return int
	 *
	 */
	@Select("SELECT count(*) FROM (t_user JOIN t_usercarport ON userId = userCarportUserId  join t_sale ON "+ 
			"userCarportId = saleCarportId join t_buyinfo ON saleId= buyInfoSaleId) JOIN t_agreement ON "+
			"agreementBuyInfoId=buyInfoId "+
			"WHERE userId=#{param1} and buyInfoStatus='交易成功' ")
	public int getUserSellNum(int sellUserId);
	
	
	/**
	 * 
	 * @Title:getBuyRecordBean
	 * @Description:用户获取购买记录
	 * @author 黄先明
	 * @param buyUserId
	 * @param startIndex
	 * @param pageSize
	 * @return List<SaleRecordBean>
	 *
	 */
	@Select("SELECT * FROM (t_user JOIN t_usercarport ON userId = userCarportUserId  join t_sale ON "+ 
			"userCarportId = saleCarportId join t_buyinfo ON saleId= buyInfoSaleId) JOIN t_agreement ON "+
			"agreementBuyInfoId=buyInfoId "+
			"WHERE buyInfoUserId=#{param1} and buyInfoStatus='交易成功' LIMIT #{param2},#{param3}")
	@Results(value={
			@Result(column="buyInfoId",property="buyInfoId"),
			@Result(column="carportAddress",property="userCarportAddress"),
			@Result(column="carportAddressNo",property="userCarportAddressNo"),
			@Result(column="agreementTime",property="dealDate"),
			@Result(column="salePrice",property="dealPrice"),
			@Result(column="buyInfoUserId",property="buyInfoUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById")),
			@Result(column="userId",property="sellUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById"))
	})
	public List<SaleRecordBean> getBuyRecordBean(int buyUserId ,int startIndex,int pageSize);
	
	/**
	 * 
	 * @Title:getUserBuyNum
	 * @Description:获取用户购买记录条数
	 * @author 黄先明
	 * @param buyUserId
	 * @return int
	 *
	 */
	@Select("SELECT count(*) FROM (t_user JOIN t_usercarport ON userId = userCarportUserId  join t_sale ON "+ 
			"userCarportId = saleCarportId join t_buyinfo ON saleId= buyInfoSaleId) JOIN t_agreement ON "+
			"agreementBuyInfoId=buyInfoId "+
			"WHERE buyInfoUserId=#{param1} and buyInfoStatus='交易成功' ")
	public int getUserBuyNum(int buyUserId);
	
	/**
	 * 
	 * @Title:getSaleRecordByBuyInfoId
	 * @Description:根据购买信息id获取买卖记录信息
	 * @author 黄先明
	 * @param buyInfoId
	 * @return SaleRecordBean
	 *
	 */
	@Select("SELECT * FROM (t_user JOIN t_usercarport ON userId = userCarportUserId  join t_sale ON "+ 
			"userCarportId = saleCarportId join t_buyinfo ON saleId= buyInfoSaleId) JOIN t_agreement ON "+
			"agreementBuyInfoId=buyInfoId "+
			"WHERE buyInfoId=#{param1} and buyInfoStatus='交易成功'")
	@Results(value={
			@Result(column="buyInfoId",property="buyInfoId"),
			@Result(column="carportAddress",property="userCarportAddress"),
			@Result(column="carportAddressNo",property="userCarportAddressNo"),
			@Result(column="agreementTime",property="dealDate"),
			@Result(column="salePrice",property="dealPrice"),
			@Result(column="buyInfoUserId",property="buyInfoUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById")),
			@Result(column="userId",property="sellUser",one=@One(select="com.cbd.mapper.UserMapper.selecteUserById"))
	})
	public SaleRecordBean getSaleRecordByBuyInfoId(int buyInfoId);
	
}
