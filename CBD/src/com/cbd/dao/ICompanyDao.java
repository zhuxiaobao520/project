package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.Pager;

import com.cbd.bean.CompanyBean;

import com.cbd.entity.CompanyEntity;

/**
 * 企业登陆Dao层接口
 * 
 * @author 张同学
 *
 */
public interface ICompanyDao {
	/**
	 * 企业用户登陆
	 * 
	 * @param name
	 * @return
	 */
	public CompanyEntity getCompany(String name);

	/**
	 * 企业用户添加
	 */
	public int addTheEnterprise(CompanyBean companyBean);

	/**
	 * 根据企业用户名字查询企业用户
	 */
	public CompanyEntity getCompanyName(String companyAccount);
	
	/**
	 * 根据用户民和密码查询
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public CompanyEntity getCompanyByNameAndPwd(String userName,String userPassword);
	
	/**
	 * 根据条件查询所有企业用户总数量
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param companyName
	 * @param companyAddress
	 * @param companyLinkMan
	 * @param companyPhone
	 * @return
	 */
	public int getAllCompany(String companyName,String
			companyAddress,String companyLinkMan,String companyPhone);
	
	/**
	 * 根据条件查询所有企业用户(分页)
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param companyName
	 * @param companyAddress
	 * @param companyLinkMan
	 * @param companyPhone
	 * @param page
	 * @param size
	 * @return
	 */
	public List<CompanyEntity> getAllPageCompany(String companyName,String
			companyAddress,String companyLinkMan,String companyPhone,
			int page,int size);
	
		
		/**
		 * 
		 * 
		 * <p>Title:findCompanyById</p>
		 * <p>Description:根据id查询企业用户 </p>
		 * @author 王菁
		 * @return CompanyEntity
		 */
		public CompanyEntity findCompanyById(int id);
		
		
		/**
		 * 
		 * 
		 * <p>Title:updateCompanyInfo</p>
		 * <p>Description:修改企业用户信息 </p>
		 * @author 王菁
		 * @return int
		 */
		public int updateCompanyInfo(CompanyEntity companyEntity);
		
		
		/**
		 * 
		 * 
		 * <p>Title:updateCompanyPwd</p>
		 * <p>Description:修改企业用户密码 </p>
		 * @author 王菁
		 * @return int
		 */
		public int updateCompanyPwd(int id,String newPwd);
		
		
		/**
		 * 
		 * 
		 * <p>Title:findCompanyRentCarportPage</p>
		 * <p>Description:企业已租车位分页数据 </p>
		 * @author 王菁
		 * @return Pager
		 */
		public Pager findCompanyRentCarportPage(int currentPage,int cbdCarportRenterCompanyId);
		
		/**
		 * 
		 * 
		 * <p>Title:findCompanyCanRentCarportPage</p>
		 * <p>Description:企业可租车位分页数据 </p>
		 * @author 王菁
		 * @return Pager
		 */
		public Pager findCompanyCanRentCarportPage(int currentPage,int cbdCarportRenterCompanyId);
		

		/**
		 * 根据id查询企业用户
		 * @author 唐小雄
		 * @date 2018年2月1日
		 * @param id
		 * @return
		 */
		public CompanyEntity getByIdCompany(int id);
		
		/**
		 * 根据ids删除企业用户
		 * @author 唐小雄
		 * @date 2018年2月1日
		 * @param id
		 * @param map
		 * @return
		 */
		public void deleteByIdCompany(int id);
		//获取所有的企业信息
		public List<CompanyEntity> findAllCompany();
		
		/**
		 * 根据企业登录名查询是否存在
		 * @author 唐小雄
		 * @date 2018年2月8日
		 * @param companyAccount
		 * @return
		 */
		public int getCompanyAccount(String companyAccount);
}
