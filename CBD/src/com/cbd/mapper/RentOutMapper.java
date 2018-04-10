package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.entity.RentOutEntity;

/**
 * 出租记录mappere
 * @author 姚刚
 * @date 2018年1月31日
 */
public interface RentOutMapper extends SqlMapper {
	/**
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId 出租用户的id,当前用户
	 * @param startIndex
	 * @param pageSize
	 * @return 得到当前用户出租完成交易的记录
	 */
	@Select("<script> SELECT rentout.rentOutId,rentInUserId,rentin.rentInId,"
			+ "userCarportAddress,userCarportAddressNo,rentout.rentOutStartTime,"
			+ "rentout.rentOutEndTime,userId,rentout.rentOutPrice "
			+ " FROM t_usercarport carport JOIN t_user as tuser ON " + " carport.userCarportUserId=tuser.userId "
			+ "JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ " JOIN t_rentin as rentin ON rentin.rentOutId=rentout.rentOutId "
			+ " where tuser.userId=#{param1} and rentin.rentInStatus='交易成功'"
			+" order by rentout.rentOutId desc"
			+ "<if test=\"param2 >=0 and param3>=0\">" + " limit #{param2},#{param3} " + "</if>"
			+ "</script>")
	@Results(value = { @Result(column = "rentOutId", property = "rentOutId", id = true),
			@Result(column = "userCarportAddress", property = "userCarportAddress"),
			@Result(column = "userCarportAddressNo", property = "userCarportAddressNo"),
			@Result(column = "rentInId", property = "rentInId"),
			@Result(column = "rentOutStartTime", property = "rentOutStartTime"),
			@Result(column = "rentOutEndTime", property = "rentOutEndTime"),
			@Result(column = "rentOutPrice", property = "rentOutPrice"),
			@Result(column = "rentInUserId", property = "rentInUserId"),
			@Result(column = "rentInUserId", property = "rentInUserName", one = @One(select = "com.cbd.mapper.UserMapper.selectUserNameById")) })
	public List<RentOutBean> getRentOutBeans(int rentOutUserId, int startIndex, int pageSize);

	/**
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId 当前用户id,出租者id
	 * @return 当前用户的出租完成交易的记录数，
	 */
	@Select("SELECT count(*) FROM t_usercarport carport JOIN t_user as tuser ON " + " carport.userCarportUserId=tuser.userId "
			+ "JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ " JOIN t_rentin as rentin ON rentin.rentOutId=rentout.rentOutId "
			+ " where tuser.userId=#{rentOutUserId} and rentin.rentInStatus='交易成功'")
	public int getRentOutBeansNum(int rentOutUserId);
	
	
	
	/**
	 * 
	 * <p>Title:getRentOutById</p>
	 * <p>Description:根据招租id查询招租记录</p>
	 * @author 龙成
	 * @date2018年2月1日下午4:31:05
	 */
	@Select("select * from t_rentout where rentOutId=#{rentOutId}")
	@Results({
		@Result(id=true,property="rentOutId",column="rentOutId"),
		@Result(property="rentOutPrice",column="rentOutPrice"),
		@Result(property="rentOutStartTime",column="rentOutStartTime"),
		@Result(property="rentOutEndTime",column="rentOutEndTime"),
		@Result(property="usercarportEntity",column="rentOutCarportId",one = @One(select ="com.cbd.mapper.UsercarportMapper.getByIdUsercarport"))
	})
	public RentOutEntity getRentOutById(int rentOutId);
	
	
	/**
	 * 添加出租信息
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return 受影响行
	 */
	@Insert("insert into t_rentout (rentOutPrice,rentOutCarportId,rentOutStartTime,rentOutEndTime) values(#{rentOutPrice},#{rentOutCarportId},#{rentOutStartTime},#{rentOutEndTime})")
	public int addRentOutBean(RentOutInsertBean rentOutInsertBean);
	/**
	 * 查询可用的待租车位信息
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return 可以租的出租信息
	 */
	@Select("<script>SELECT rentout.rentOutId,rentOutPrice,rentOutStartTime,rentOutEndTime, "
			+ " rentOutCarportId,userCarportAddress,userCarportAddressNo,userId,userName,userProfession,userReputation,userPhone "
			+ " FROM t_usercarport AS carport JOIN t_user as tuser ON  carport.userCarportUserId=tuser.userId "
			+ " JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ " where carport.userCarportStatus='待租'  order by rentout.rentOutId desc "
			+ " <if test=\"param1 >=0 and param2>=0\">" + " limit #{param1},#{param2} " + "</if>"
			+ "</script>")
	public List<UseableRentOutInfoBean>getUseableCarport(int startIndex, int pageSize);
	/**
	 * 得到所有可租空闲车位的数量
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	@Select("SELECT count(*) FROM t_usercarport AS carport JOIN t_user as tuser "
			+ " ON  carport.userCarportUserId=tuser.userId JOIN "
			+ " t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ "where carport.userCarportStatus='待租'")
	public int getUseableCarportNum();
	
	/**
	 * 得到出租信息表指定可以租的记录详情
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param rentOutId 出租信息表主键
	 * @return
	 */
	@Select("SELECT rentout.rentOutId,rentOutPrice,rentOutStartTime,rentOutEndTime, "
			+ " rentOutCarportId,userCarportAddress,userCarportAddressNo,userId,userName,userProfession,userReputation ,userPhone"
			+ " FROM t_usercarport AS carport JOIN t_user as tuser ON  carport.userCarportUserId=tuser.userId "
			+ " JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			
			+ " where  carport.userCarportStatus='待租' and rentout.rentOutId=#{rentOutId} ")
	public UseableRentOutInfoBean getUseableRentOutInfoByRentOutId(int rentOutId);
	
	/**
	 * 查询当前用户发布的租车信息（未完成交易的）
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return 可以租的出租信息
	 */
	@Select("<script>SELECT rentout.rentOutId,rentOutPrice,rentOutStartTime,rentOutEndTime, "
			+ " rentOutCarportId,userCarportAddress,userCarportAddressNo,userId,userName,userProfession,userReputation "
			+ " FROM t_usercarport AS carport JOIN t_user as tuser ON  carport.userCarportUserId=tuser.userId "
			+ " JOIN t_rentout as rentout ON rentout.rentOutCarportId=carport.userCarportId "
			+ " LEFT JOIN t_rentin as rentin ON rentin.rentOutId=rentout.rentOutId "
			+ " where (rentin.rentInStatus='待交易' or ISNULL(rentin.rentInStatus))  and carport.userCarportStatus='待租' and userId=#{param1}   order by rentout.rentOutId desc "
			+ " <if test=\"param2 >=0 and param3>=0\">" + " limit #{param2},#{param3} " + "</if>"
			+ "</script>")
	public List<UseableRentOutInfoBean>getUnRentOut(int userId,int startIndex, int pageSize);
	
	/**
	 * 查询当前用户发布的租车信息数量（未完成交易的）
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return 可以租的出租信息
	 */
	@Select("SELECT count(rentin.rentOutId)"
			+ " FROM t_usercarport AS carport JOIN t_user as tuser ON "
			+ " carport.userCarportUserId=tuser.userId "
			+ " JOIN t_rentout as rentout ON "
			+ " rentout.rentOutCarportId=carport.userCarportId "
			+ " where carport.userCarportStatus='待租' and userId=#{param1} and rentin.rentOutId=#{param2}")
	public int getUnRentOutNum(int userId,int rentOutId);
	
	
	/**
	 * 查询指定的出租记录
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutId 出租记录的id
	 * @return 得到当前用户出租完成交易的记录
	 */
	@Select("SELECT rentout.rentOutId,rentInUserId,rentin.rentInId,"
			+ "userCarportAddress,rentInMessage,rentin.rentInStatus,userCarportAddressNo,rentout.rentOutStartTime,"
			+ "rentout.rentOutEndTime,userId,rentout.rentOutPrice "
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
			@Result(column = "rentInMessage", property = "rentInMessage"),
			@Result(column = "rentOutPrice", property = "rentOutPrice"),
			@Result(column = "rentInStatus", property = "rentInStatus"),
			@Result(column = "rentInUserId", property = "rentInUserId"),
			@Result(column = "rentInUserId", property = "rentInUserName", one = @One(select = "com.cbd.mapper.UserMapper.selectUserNameById")),
			})
	public RentOutBean getRentOutBean(int rentInId);
	
	/**
	 * 根据车位id查询车位出租记录的数量
	 * 用于验证车位是否已经出租过了
	 * @author 姚刚
	 * @date 2018年2月7日
	 * @param userCarportId
	 * @param userCarportStatus 车位状态
	 * @param userCarportAuditingStatus 审核状态
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_usercarport AS usercarport JOIN t_rentout "
			+ " AS rentout WHERE usercarport.userCarportId=1#{param1} AND "
			+ " usercarport.userCarportStatus=#{param2} AND "
			+ " usercarport.userCarportAuditingStatus=#{param3}")
	public int getRentOutByCarportId(int userCarportId,String userCarportStatus,String  userCarportAuditingStatus);
	
}
