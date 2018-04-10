package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.AdminBean;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.UsercarportEntity;

/**
 * 
 * <p>Title:AdminMapper</p>
 * <p>Description: 管理员Mapper接口</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:57:29
 */
public interface AdminMapper extends SqlMapper{

	//查询所有普通管理员
	@Select("select * from t_admin where adminType=0")
	public List<AdminEntity> getAdmins();
	
	//根据当前页查询相应的管理员
	@Select("select * from t_admin where adminType=0 limit #{param1},#{param2}")
	public List<AdminEntity> getAdminsByPage(int starPage,int pageSize);
	
	//修改超级管理员密码
	@Update("update t_admin set adminPassword=#{newPassword} where adminType=1")
	public int updateSuperAdminPassword(String newPassword);
	
	//增加普通管理员
	@Insert("insert into t_admin(adminAccount,adminPassword,adminType,adminNo,adminRealName,"
			+ "adminPhone,admiUserManagerPower,adminCarPortManagerPower,adminAgreementManagerPower,"
			+ "adminCompaintManagerPower)values(#{adminAccount},#{adminPassword},#{adminType},"
			+ "#{adminNo},#{adminRealName},#{adminPhone},#{admiUserManagerPower},"
			+ "#{adminCarPortManagerPower},#{adminAgreementManagerPower},#{adminCompaintManagerPower})")
	public int addAdminByParam(AdminEntity adminEntity);
	
	/**
	 * 查询所有待租待审车位信息
	 * @return
	 */
	@Select("SELECT count(*) FROM t_usercarport WHERE t_usercarport."
			+ "userCarportAuditingStatus = '待审' and t_usercarport."
			+ "userCarportStatus = '空闲'")
	public int getAllDaiZuUser();
	
	/**
	 * 查询所有待租待审车位信息(分页)
	 * @return
	 */
	@Select("SELECT * FROM t_usercarport WHERE t_usercarport."
			+ "userCarportAuditingStatus = '待审' and t_usercarport."
			+ "userCarportStatus = '空闲' limit #{param1},#{param2}")
	@Results({  
	    @Result(id=true,property="userCarportId",column="userCarportId"),  
	    @Result(property="userCarportPropertityRight",column="userCarportPropertityRight"),  
	    @Result(property="userCarportAddress",column="userCarportAddress"),  
	    @Result(property="userCarportAddressNo",column="userCarportAddressNo"),  
	    @Result(property="userCarportImageUrl",column="userCarportImageUrl"),  
	    @Result(property="userCarportAuditingStatus",column="userCarportAuditingStatus"),  
	    @Result(property="userCarportStatus",column="userCarportStatus"),  
	    @Result(property="user",column="userCarportUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))  
	})  
	public List<UsercarportEntity> getAllPageDaiZuUser(int page,int size);
	
	/**
	 * 
	 * <p>Title:getAdminInfoById</p>
	 * <p>Description: 查询管理员信息</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Select("select * from t_admin where adminId=#{adminId}")
	public AdminEntity getAdminInfoById(int adminId);
	
	/**
	 * 
	 * <p>Title:updateAdminPower</p>
	 * <p>Description: 修改管理员权限</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Update("update t_admin set admiUserManagerPower=#{admiUserManagerPower},"
			+ "adminCarPortManagerPower=#{adminCarPortManagerPower},adminAgreementManagerPower"
			+ "=#{adminAgreementManagerPower},adminCompaintManagerPower=#{adminCompaintManagerPower} "
			+ "where adminId=#{adminId}")
	public int updateAdminPower(AdminEntity adminEntity);
	
	/**
	 * 
	 * <p>Title:deleteAdminInfo</p>
	 * <p>Description: 删除管理员信息</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Delete("delete from t_admin where adminId=#{adminId}")
	public int deleteAdminInfo(int adminId);
	
	/**
	 * 
	 * <p>Title:getAdminByName</p>
	 * <p>Description: 根据管理员用户名查询管理员</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Select("select * from t_admin where adminAccount=#{adminAccount}")
	public AdminEntity getAdminByName(String adminAccount);
	
	/**
	 * 
	 * <p>Title:getAdminByAdminNo</p>
	 * <p>Description: 根据工号查询管理员</p>
	 * @author 朱小宝
	 * @return AdminEntity
	 */
	@Select("select * from t_admin where adminNo=#{adminNo}")
	public AdminEntity getAdminByAdminNo(String adminNo);
}
