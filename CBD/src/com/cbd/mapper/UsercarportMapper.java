package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.AllSaleInfoBean;
import com.cbd.bean.SaleBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.SaleEntity;
import com.cbd.entity.UsercarportEntity;

/**
 * 个人车位信息mapper接口
 * 
 * @author 唐小雄
 *
 */
public interface UsercarportMapper extends SqlMapper {

	/**
	 * 根据id查询车位信息接口
	 * 
	 * @return 唐小雄
	 */
	@Select("SELECT * FROM t_usercarport WHERE userCarportId=#{id}")
	@Results({ @Result(id = true, property = "userCarportId", column = "userCarportId"),
			@Result(property = "userCarportPropertityRight", column = "userCarportPropertityRight"),
			@Result(property = "userCarportAddress", column = "userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "userCarportAddressNo"),
			@Result(property = "userCarportImageUrl", column = "userCarportImageUrl"),
			@Result(property = "userCarportAuditingStatus", column = "userCarportAuditingStatus"),
			@Result(property = "userCarportStatus", column = "userCarportStatus"),
			@Result(property = "user", column = "userCarportUserId", one = @One(select = "com.cbd.mapper.UserMapper.getByIdUser")) })
	public UsercarportEntity getByIdUsercarport(int id);

	/**
	 * 根据id修改车位审核状态
	 * 
	 * @param id
	 * @return null
	 * @user 唐小雄
	 */
	@Update("update t_usercarport set userCarportAuditingStatus = #{param1} where userCarportId=#{param2}")

	public void updateByIdUsercarport(String userCarportAuditingStatus, int id);



	

	/**
	 * 
	 * <p>
	 * Title:getUsercarportsByUserId
	 * </p>
	 * <p>
	 * Description:根据用户id查询所有车位空闲的车位
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日上午10:09:39
	 */
	@Select("select * from t_usercarport where userCarportUserId = #{id} and userCarportAuditingStatus = '通过' and userCarportStatus = '空闲'")
	@Results({ @Result(id = true, property = "userCarportId", column = "userCarportId"),
			@Result(property = "userCarportPropertityRight", column = "userCarportPropertityRight"),
			@Result(property = "userCarportAddress", column = "userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "userCarportAddressNo"),
			@Result(property = "userCarportImageUrl", column = "userCarportImageUrl"),
			@Result(property = "userCarportAuditingStatus", column = "userCarportAuditingStatus"),
			@Result(property = "userCarportStatus", column = "userCarportStatus"),
			@Result(property = "user", column = "userCarportUserId", one = @One(select = "com.cbd.mapper.UserMapper.getByIdUser")) })
	public List<UsercarportEntity> getUserCarportsByUserId(int id);

	/**
	 * 

	 * <p>
	 * Title:updateUserCarportStatusBySaleBean
	 * </p>
	 * <p>
	 * Description:根据出售信息的车位id更改车位表的车位状态
	 * </p>
	 * 

	 * @author 杨明健
	 * @date2018年1月31日下午1:36:22
	 */
	@Update("update t_usercarport set userCarportStatus =#{param2}  where userCarportId = #{param1}")
	public int updateUserCarportStatusByUserCarportId(int userCarportId,String userCarportStatus);

	/**
	 * 
	 * <p>
	 * Title:addSellCarportBySaleBean
	 * </p>
	 * <p>
	 * Description:根据出售信息添加车位的出售信息表
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午1:25:54
	 */
	@Insert("insert into t_sale (saleCarportId,salePrice,salePublishTime) value (#{saleCarportId},#{salePrice},#{salePublishTime})")
	public int addSaleBySaleBean(SaleBean saleBean);

	/**
	 * 
	 * <p>
	 * Title:getUsercarportByUserCarportPropertityRight
	 * </p>
	 * <p>
	 * Description:根据个人车位的车位产权证编号查询
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午3:22:01
	 */
	@Select("SELECT * FROM t_usercarport WHERE userCarportPropertityRight=#{userCarportPropertityRight}")
	@Results({ @Result(id = true, property = "userCarportId", column = "userCarportId"),
			@Result(property = "userCarportPropertityRight", column = "userCarportPropertityRight"),
			@Result(property = "userCarportAddress", column = "userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "userCarportAddressNo"),
			@Result(property = "userCarportImageUrl", column = "userCarportImageUrl"),
			@Result(property = "userCarportAuditingStatus", column = "userCarportAuditingStatus"),
			@Result(property = "userCarportStatus", column = "userCarportStatus"),
			@Result(property = "user", column = "userCarportUserId", one = @One(select = "com.cbd.mapper.UserMapper.getByIdUser")) })
	public UsercarportEntity getUsercarportByUserCarportPropertityRight(UsercarportBean usercarportBean);

	/**
	 * 
	 * <p>
	 * Title:addUsercarportByUsercarportBean
	 * </p>
	 * <p>
	 * Description:添加新车位
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午3:28:25
	 */
	@Insert("insert into t_usercarport (userCarportPropertityRight,userCarportAddress,userCarportAddressNo,userCarportImageUrl,userCarportAuditingStatus,userCarportUserId,userCarportStatus) value (#{userCarportPropertityRight},#{userCarportAddress},#{userCarportAddressNo},#{userCarportImageUrl},#{userCarportAuditingStatus},#{userCarportUserId},'空闲')")
	public int addUsercarportByUsercarportBean(UsercarportBean usercarportBean);

	/**
	 * 
	 * <p>Title:getAllUsercarport</p>
	 * <p>Description:分页查询所有出售车位的信息</p>
	 * @author 杨明健
	 * @date2018年2月1日上午11:10:46
	 */
	@Select("<script>" 
			+ "select saleId,salePrice,salePublishTime,userCarportUserId,userCarportAddress,"
			+ "userCarportAddressNo from t_sale join t_usercarport on userCarportId = "
			+ "saleCarportId" 
			+ "<where>" 
			+ " userCarportStatus = '待售' and userCarportUserId != #{param4}"
			+ "<if test=\"param3 != null and param3 != ''\">"
			+ " and salePublishTime &lt;= #{param3}" 
			+ "</if>" 
			+ "</where>"
			+ "<if test=\"param1 >= 0 and param2 >= 0\">" 
			+ " limit #{param1},#{param2} "
			+ "</if>"
			+ "</script>")
	@Results({
		@Result(id=true,property = "saleId",column = "saleId"),
		@Result(property = "salePrice",column = "salePrice"),
		@Result(property = "salePublishTime",column = "salePublishTime"),
		@Result(property = "userCarportUserId",column = "userCarportUserId"),
		@Result(property = "userCarportAddress",column = "userCarportAddress")
	})
	public List<AllSaleInfoBean> getPageUsercarport(int startPosition, int pageSize, String endTime,int userId);
	
	/**
	 * 
	 * <p>Title:getAllUsercarport</p>
	 * <p>Description:查询所有出售车位的信息</p>
	 * @author 杨明健
	 * @date2018年2月1日上午11:28:17
	 */
	@Select("select saleId,salePrice,salePublishTime,userCarportUserId,"
			+ "userCarportAddress,userCarportAddressNo from t_sale join "
			+ "t_usercarport on userCarportId = saleCarportId where userCarportStatus = '待售' and userCarportUserId != #{userId}")
	@Results({
		@Result(id=true, property = "saleId",column = "saleId"),
		@Result(property = "salePrice",column = "salePrice"),
		@Result(property = "salePublishTime",column = "salePublishTime"),
		@Result(property = "userCarportUserId",column = "userCarportUserId"),
		@Result(property = "userCarportAddress",column = "userCarportAddress")
	})
	public List<AllSaleInfoBean> getAllUsercarport(int userId);
	
	/**
	 * 
	 * <p>Title:addReserveBuy</p>
	 * <p>Description:添加预定车位购买信息</p>
	 * @author 杨明健
	 * @date2018年2月1日下午5:22:09
	 */
	@Insert("insert into t_buyInfo (buyInfoSaleId,buyInfoUserId,buyInfoStatus,buyInfoMassage) value (#{buyInfoSaleId},#{buyInfoUserId},#{buyInfoStatus},#{buyInfoMassage})")
	public int addReserveBuy(ReserveBuyBean reserveBuyBean);
	
	/**
	 * @author 吴雪
	 * 2018年2月7日
	 * 删除不通过审核的车位
	 */
	@Delete("delete from t_usercarport where userCarportId=#{id}")
	public int deleteUserCarportById(int id);

	
	/**
	 * 得到用户发布出去的车位信息的条数
	 * @author yinshi
	 * @date 2018年2月7日
	 * @param userId
	 * @return
	 */
	@Select("select COUNT(*) from t_usercarport where userCarportUserId = #{userId} and userCarportStatus in('待租','待售','已租出')")
	public int getUserOutCarPortById(int userId);

	
	/**
	 * 分页查询用户的发布车位信息
	 * @author yinshi
	 * @date 2018年2月8日
	 * @param userId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Select("select * from t_usercarport where userCarportUserId = #{param1} and userCarportStatus in('待租','待售','已租出') limit #{param2},#{param3}")
	public List<UsercarportBean> getUserOutCarPortByParam(int userId, int startIndex, int pageSize);
	
	/**
	 * 得到用户发布出去的车位信息的条数
	 * @author yinshi
	 * @date 2018年2月7日
	 * @param userId
	 * @return
	 */
	@Select("select COUNT(*) from t_usercarport where userCarportUserId = #{userId} and userCarportStatus = '空闲' ")
	public int getUserNullCarPortById(int userId);

	
	/**
	 * 分页查询用户的发布车位信息
	 * @author yinshi
	 * @date 2018年2月8日
	 * @param userId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Select("select * from t_usercarport where userCarportUserId = #{param1} and userCarportStatus = '空闲' limit #{param2},#{param3}")
	public List<UsercarportBean> getUserNullCarPortByParam(int userId, int startIndex, int pageSize);
	
	
	
	
}
