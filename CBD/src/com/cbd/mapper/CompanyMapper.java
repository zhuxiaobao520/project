package com.cbd.mapper;

import java.util.List;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbd.bean.CompanyCanRentCarport;
import com.cbd.bean.CompanyRentCarport;
import com.cbd.entity.CartportEntity;
import com.cbd.bean.Pager;
import com.cbd.entity.CartportEntity;
import com.cbd.entity.CompanyEntity;



/**
 * 企业用户登陆Mapper接口
 * @author 张平
 *
 */
public interface CompanyMapper extends SqlMapper {
		/**
		 * 企业用户登陆
		 * @author zhangping
		 * @date 2018年2月1日
		 * @param name
		 * @return
		 */
	@Select("select * from t_company where companyAccount=#{name}")
		public CompanyEntity company(String name);

	
	/**
	 * 
	 * 
	 * <p>Title:findCompanyById</p>
	 * <p>Description:根据Id查询企业用户 </p>
	 * @author 王菁
	 * @return CompanyEntity
	 */
	@Select("select * from t_company where companyId=#{id}")
	public CompanyEntity findCompanyById(int id);
	
	
	/**
	 * 
	 * 
	 * <p>Title:findCompanyByName</p>
	 * <p>Description:根据用户名查询企业用户 </p>
	 * @author 王菁
	 * @return CompanyEntity
	 */
	@Select("select * from t_company where companyAccount=#{userName}")
	public CompanyEntity findCompanyByName(String userName);
	
	
	/**
	 * 
	 * 
	 * <p>Title:updateCompanyInfo</p>
	 * <p>Description:修改企业用户信息 </p>
	 * @author 王菁
	 * @return int
	 */
	@Update("update t_company set companyAccount=#{companyAccount},"
			+ "companyLinkMan=#{companyLinkMan},companyPhone=#{companyPhone} "
			+ "where companyId=#{companyId}")
	public int updateCompanyInfo(CompanyEntity companyEntity);
	
	/**
	 * 
	 * 
	 * <p>Title:updateCompanyPwd</p>
	 * <p>Description:修改企业用户密码 </p>
	 * @author 王菁
	 * @return int
	 */
	@Update("update t_company set companyPassword=#{param2} where companyId =#{param1}")
	public int updateCompanyPwd(int id,String newPwd);
	
	
	/**
	 * 
	 * 
	 * <p>Title:findAllRentCarport</p>
	 * <p>Description:查询所有企业已租车位 </p>
	 * @author 王菁
	 * @return List<CompanyRentCarportEntity>
	 */
	@Select("select * from t_cbdcartport JOIN t_renterAgreement ON "
			+ "cbdCarportRenterAgreementId = renterAgreementId "
			+ "where cbdCarportRenterCompanyId=#{cbdCarportRenterCompanyId} "
			+ "and renterAgreementStatus = 1")
	@Results(value={
			@Result(property="cbdCarportAddress",column="cbdCarportAddress"),
			@Result(property="cbdCarportAddressNo",column="cbdCarportAddressNo"),
			@Result(property="renterAgreementNewNo",column="renterAgreementNewNo"),
			@Result(property="renterAgreementStartTime",column="renterAgreementStartTime"),
			@Result(property="renterAgreementEndTime",column="renterAgreementEndTime")
	})
	public List<CompanyRentCarport> findAllRentCarport(int cbdCarportRenterCompanyId);
	
	/**
	 * 
	 * 
	 * <p>Title:findRentCarpotPage</p>
	 * <p>Description:分页查询企业已租车位 </p>
	 * @author 王菁
	 * @return List<CompanyRentCarportEntity>
	 */
	@Select("select * from t_cbdcartport JOIN t_renterAgreement ON "
			+ "cbdCarportRenterAgreementId = renterAgreementId "
			+ "where cbdCarportRenterCompanyId=#{param1} and renterAgreementStatus = 1"
			+ " limit #{param2},#{param3}")
	@Results(value={
			@Result(property="cbdCarportAddress",column="cbdCarportAddress"),
			@Result(property="cbdCarportAddressNo",column="cbdCarportAddressNo"),
			@Result(property="renterAgreementNewNo",column="renterAgreementNewNo"),
			@Result(property="renterAgreementStartTime",column="renterAgreementStartTime"),
			@Result(property="renterAgreementEndTime",column="renterAgreementEndTime")
	})	
	public List<CompanyRentCarport> findRentCarpotPage(int cbdCarportRenterCompanyId,
			int startPositin,int pageSize);
	
	
	/**
	 * 
	 * 
	 * <p>Title:findAllCanrentCarport</p>
	 * <p>Description:查询所有企业可租车位 </p>
	 * @author 王菁
	 * @return List<CompanyCanRentCarport>
	 */
	@Select("select * from t_cbdcartport left JOIN t_thirdAggrement ON "
			+ "cbdCarportThirdAggremenId = thirdAggrementId "
			+ " where (thirdAggrementStatus = 1 and cbdCarportStutas = 0) or cbdCarportStutas = 0")
	@Results(value={
			@Result(property="cbdCarportAddress",column="cbdCarportAddress"),
			@Result(property="cbdCarportAddressNo",column="cbdCarportAddressNo"),
			@Result(property="thirdAggrementEndTime",column="thirdAggrementEndTime"),			
	})
	public List<CompanyCanRentCarport> findAllCanrentCarport(int cbdCarportRenterCompanyId);
	
	
	/**
	 * 
	 * 
	 * <p>Title:findAllCanrentCarportPage</p>
	 * <p>Description: 分页查询所有企业可租车位</p>
	 * @author 王菁
	 * @return List<CompanyCanRentCarport>
	 */
	@Select("select * from t_cbdcartport left JOIN t_thirdAggrement ON "
			+ "cbdCarportThirdAggremenId = thirdAggrementId "
			+ "where (thirdAggrementStatus = 1 and cbdCarportStutas = 0 ) or cbdCarportStutas = 0 "
			+ "limit #{param2},#{param3}")
	@Results(value={
			@Result(property="cbdCarportAddress",column="cbdCarportAddress"),
			@Result(property="cbdCarportAddressNo",column="cbdCarportAddressNo"),
			@Result(property="thirdAggrementEndTime",column="thirdAggrementEndTime"),			
	})	
	public List<CompanyCanRentCarport> findAllCanrentCarportPage(int cbdCarportRenterCompanyId,
			int startPositin,int pageSize);

	
	/**
	 * 添加企业用户
	 */
	@Insert("insert into t_company values(0,#{companyAccount},#{companyPassword},#{companyName},"
			+ "#{companyAddress},#{companyLinkMan},#{companyPhone})")
		public int AddTheEnterprise(CompanyEntity companyEntity);
	
	/**
	 * zhangping
	 * 根据企业名字查询企业用户
	 * 
	 */
	@Select("Select * from t_company where companyName=#{companyName}")
			public CompanyEntity getCompanyName(String companyName);
	
	/**
	 * 根据企业登录名查询是否存在
	 * @author 唐小雄
	 * @date 2018年2月8日
	 * @param companyAccount
	 * @return
	 */
	@Select("Select count(*) from t_company where companyAccount=#{companyAccount}")
	public int getCompanyAccount(String companyAccount);

	@Select("Select * from t_company where companyAccount=#{param1} and companyPassword = #{param2}")
	public CompanyEntity getCompanyByNameAndPwd(String userName, String companyPwd);

	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @return 根据条件查询所有企业用户总数量
	 */
	@Select("<script>"
			   +"select count(*) from t_company"
			   +"<where>"
				+"<if test='param1 !=null'>"
				+"and companyName like concat('%',#{param1},'%')"
				+"</if>"
				+"<if test='param2 !=null'>"
				+"and companyAddress like concat('%',#{param2},'%')"
				+"</if>"
				+"<if test='param3 !=null'>"
				+"and companyLinkMan like concat('%',#{param3},'%')"
				+"</if>"
				+"<if test='param4 !=null'>"
				+"and companyPhone like concat('%',#{param4},'%')"
				+"</if>"
			   +"</where>"
			   +"</script>")
	public int getAllCompany(String companyName,String
			companyAddress,String companyLinkMan,String companyPhone);
	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @return 根据条件查询所有企业用户(分页)
	 */
	@Select("<script>"
			+"select * from t_company"
			+"<where>"
			+"<if test='param1 !=null'>"
			+"and companyName like concat('%',#{param1},'%')"
			+"</if>"
			+"<if test='param2 !=null'>"
			+"and companyAddress like concat('%',#{param2},'%')"
			+"</if>"
			+"<if test='param3 !=null'>"
			+"and companyLinkMan like concat('%',#{param3},'%')"
			+"</if>"
			+"<if test='param4 !=null'>"
			+"and companyPhone like concat('%',#{param4},'%')"
			+"</if>"
			+"</where> limit #{param5},#{param6}"
			+"</script>")
	public List<CompanyEntity> getAllPageCompany(String companyName,String
		companyAddress,String companyLinkMan,String companyPhone,
		int page,int size);
	
	/**
	 * 根据id查询企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @return
	 */
	@Select("select * from t_company where companyId=#{id}")
	public CompanyEntity getByIdCompany(int id);
	
	/**
	 * 根据ids删除企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @param map
	 * @return
	 */
	@Select("delete from t_company where companyId=#{id}")
	public String removeByIdCompany(int id);
	//获取所有的企业信息
	@Select("select * from t_company")
	public List<CompanyEntity> findAllCompany();
}
