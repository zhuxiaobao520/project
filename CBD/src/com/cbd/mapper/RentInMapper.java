package com.cbd.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.RentInBean;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentOutBean;
import com.cbd.entity.RentInEntity;
import com.cbd.bean.RentInInsertBean;
import com.cbd.bean.RentInfoBean;

/**
 * 出租记录的mapper
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface RentInMapper extends SqlMapper {

	/**
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 当前用户id,租户id
	 * @param startIndex
	 * @param pageSize
	 * @return 租赁信息集合
	 */
	@Select("<script> SELECT rentInId,userId,carport.userCarportAddress,"
			+ "carport.userCarportAddressNo,rentout.rentOutStartTime,rentout.rentOutEndTime,rentout.rentOutPrice "
			+ " FROM t_rentin As rentin JOIN t_rentout "
			+ " AS rentout ON rentin.rentOutId=rentout.rentOutId  "
			+ "JOIN t_usercarport as carport ON rentout.rentOutCarportId=carport.userCarportId "
			+ "	JOIN t_user as tuser ON tuser.userId=carport.userCarportUserId "
			+ " WHERE rentin.rentInUserId=#{param1} and rentin.rentInStatus='交易成功'"
			+ "<if test=\"param2 >=0 and param3>=0\">" 
			+" limit #{param2},#{param3} "
			+"</if></script>")
	@Results(value={
			@Result(column="rentInId",property="rentInId",id=true),
			@Result(column="userCarportAddress",property="userCarportAddress"),
			@Result(column="userCarportAddressNo",property="userCarportAddressNo"),
			@Result(column="rentOutStartTime",property="rentOutStartTime"),
			@Result(column="rentOutEndTime",property="rentOutEndTime"),
			@Result(column="rentOutPrice",property="rentOutPrice"),
			@Result(column="userId",property="rentOutUserName",one=@One(select="com.cbd.mapper.UserMapper.selectUserNameById"))
	})
	public List<RentInBean> getRentInBeans(int rentInUserId,int startIndex,int pageSize);
	
	/**
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 当前用户id,租户id
	 * @return 当前用户租赁记录条数
	 */
	@Select("SELECT count(*)"
			+ " FROM t_rentin As rentin JOIN t_rentout "
			+ " AS rentout ON rentin.rentOutId=rentout.rentOutId  "
			+ "JOIN t_usercarport as carport ON rentout.rentOutCarportId=carport.userCarportId "
			+ "	JOIN t_user as tuser ON tuser.userId=carport.userCarportUserId "
			+ " WHERE rentin.rentInUserId=#{rentInUserId}  and rentin.rentInStatus='交易成功'")
	public int getRentInBeansNum(int rentInUserId);
	
	
	/**
	 * 
	 * <p>Title:updateRentInStatus</p>
	 * <p>Description:根据租赁者id和租赁信息id修改交易状态</p>
	 * @author 龙成
	 * @date2018年2月1日下午3:26:17
	 */
	@Update("UPDATE t_rentin SET rentInStatus = #{param3} WHERE rentInId= #{param1} and rentInUserId=#{param2}")
	public int updateRentInStatus(int rentInId,int rentInUserId,String rentInStatus);
	
	/**
	 * 
	 * <p>Title:updateRentInStatusByrentOutId</p>
	 * <p>Description:根据招租id和租赁者id，修改对应这条招租id的租赁记录状态（多个人预约同一个车位）</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:08:24
	 */
	@Update("UPDATE t_rentin SET rentInStatus = #{param3} WHERE rentOutId= #{param1} and rentInUserId != #{param2}")
	public int updateOtherUserRentInStatus(int rentOutId,int rentInUserId,String rentInStatus);
	
	
	/**
	 * 
	 * <p>Title:getRentInEntitiesByRentOutId</p>
	 * <p>Description:根据招租信息id查询所有预约该车位失败的租赁信息</p>
	 * @author 龙成
	 * @date2018年2月1日下午8:48:51
	 */
	@Select("select * from t_rentin where rentOutId=#{param1} and rentInId != #{param2}")
	@Results({
		@Result(id=true,property="rentInId",column="rentInId"),
		@Result(property="rentInStatus",column="rentInStatus"),
		@Result(property="rentInMessage",column="rentInMessage"),
		@Result(property="rentOutEntity",column="rentOutId",one=@One(select="com.cbd.mapper.RentOutMapper.getRentOutById")),
		@Result(property="userEntity",column="rentInUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))
	})
	public List<RentInEntity> getRentInEntitiesByRentOutId(int rentOutId,int rentInId);
	

	/**
	 * 
	 * <p>Title:getRentInById</p>
	 * <p>Description: 根据租赁信息id查询租赁信息</p>
	 * @author 朱小宝
	 * @return RentInEntity
	 */
	@Select("select * from t_rentIn where rentInId=#{param1} and rentInUserId=#{param2} and rentInStatus='交易成功'")
	@Results(value={
			@Result(column="rentInId",property="rentInId",id=true),
			@Result(column="rentOutId",property="rentOutEntity",one=@One(select="com.cbd.mapper.RentOutMapper.getRentOutById"))
	})
	public RentInEntity getRentInById(int id ,int userId);
		
	/**
	 * 租车位时，新增记录
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentInInsertBean
	 * @return 受影响行数
	 */
	@Insert("INSERT into t_rentin (rentOutId,rentInUserId,rentInMessage) VALUES (#{rentOutId},#{rentInUserId},#{rentInMessage})")
	@Options(useGeneratedKeys=true,keyProperty="rentInId")
	public int addRentInRecord(RentInInsertBean rentInInsertBean);

	/**
	 * 用于查询当前用户是否租赁了响应的出租记录
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param rentOutId
	 * @param rentInUserId
	 * @return
	 */
	@Select("select count(*) from t_rentIn where rentOutId=#{param1} and rentInUserId=#{param2}")
	public int getRentInNumByRentOutIdAndRentInUserId(int rentOutId,int rentInUserId);
	
	/**
	 * 根据租赁记录id查询出租赁相关信息，包括出租人信息和出租信息
	 * 及车位信息
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param rentInId
	 * @return
	 */
	@Select("SELECT rentout.rentOutId,rentin.rentInId,carport.userCarportId,"
			+ "userCarportAddress,rentInMessage,rentin.rentInStatus,userCarportAddressNo,rentout.rentOutStartTime,"
			+ "rentout.rentOutEndTime,tuser.userId,tuser.userName,rentout.rentOutPrice "
			+ " FROM t_usercarport carport JOIN t_user as tuser ON " + " carport.userCarportUserId=tuser.userId "
			+ "JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ " JOIN t_rentin as rentin ON rentin.rentOutId=rentout.rentOutId "
			+ " where  rentInId=#{rentInId} and rentin.rentInStatus!='待交易'")
	@Results(value = { @Result(column = "rentOutId", property = "rentOutId", id = true),
			@Result(column = "userCarportAddress", property = "userCarportAddress"),
			@Result(column = "userCarportAddressNo", property = "userCarportAddressNo"),
			@Result(column = "rentInId", property = "rentInId"),
			@Result(column = "rentOutStartTime", property = "rentOutStartTime"),
			@Result(column = "rentOutEndTime", property = "rentOutEndTime"),
			@Result(column = "rentOutPrice", property = "rentOutPrice"),
			@Result(property= "rentOutUserId", column= "userId"),
			@Result(column = "userCarportId", property = "userCarportId"),
			@Result(property= "rentOutUserName", column = "userName")
			})
	public RentInComplainBean getRentInComplainBean(int rentInId);
	
	/**
	 * 得到租赁的详细信息包括租赁方和出租方信息，车位信息
	 * @author 姚刚
	 * @date 2018年2月5日
	 * @param rentInId
	 * @return
	 */
	@Select("SELECT rentin.rentInId,rentout.rentOutId,rentout.rentOutStartTime, "
			+ " rentout.rentOutEndTime,rentout.rentOutPrice,carport.userCarportId, "
			+ " carport.userCarportAddress,carport.userCarportAddressNo, "
			+ " rentinuser.userId AS rentinuserid,rentinuser.userName AS rentinusername, "
			+ " rentoutuser.userId as rentoutuserid,rentoutuser.userName as rentoutusername "
			+ " from t_rentin AS rentin JOIN t_rentout AS rentout ON "
			+ " rentin.rentOutId=rentout.rentOutId JOIN t_usercarport  AS carport "
			+ " ON carport.userCarportId=rentout.rentOutCarportId JOIN t_user "
			+ " AS rentoutuser ON rentoutuser.userId=carport.userCarportUserId "
			+ "	JOIN t_user AS rentinuser ON rentinuser.userId=rentin.rentInUserId "
			+ " where rentin.rentInId=#{rentInId} ")
	public RentInfoBean getRentInfoBeanByRentInId(int rentInId);
}














