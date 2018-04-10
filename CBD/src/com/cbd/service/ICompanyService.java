package com.cbd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.CompanyBean;
import com.cbd.bean.Pager;
import com.cbd.entity.CompanyEntity;

/**
 * 企业用户业务逻辑接口
 * @author 张同学
 *
 */
public interface ICompanyService {
			/**
			 * 企业用户登陆
			 * @author zhangping
			 * @date 2018年2月1日
			 * @param name
			 * @return
			 */
		public CompanyEntity companyEntity(String name);

		
		/**
		 * 根据用户民查询
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param username
		 * @return companyBean
		 */
		public CompanyBean getCompanyByName(String username);

		
		/**
		 * 
		 * 
		 * <p>Title:getCompanyById</p>
		 * <p>Description:根据id查询企业 </p>
		 * @author 王菁
		 * @return CompanyBean
		 */
		public CompanyBean getCompanyById(int id);
		
		
		
		/**
		 * 
		 * 
		 * <p>Title:updateCompanyInfo</p>
		 * <p>Description:判断修改信息是否成功 </p>
		 * @author 王菁
		 * @return boolean
		 */
		public boolean updateCompanyInfo(CompanyBean companyBean);
		
		
		/**
		 * 
		 * 
		 * <p>Title:updateCompanyPwd</p>
		 * <p>Description:判断修改密码是否成功 </p>
		 * @author 王菁
		 * @return boolean
		 */
		public boolean updateCompanyPwd(int id,String newPwd);
		
		
		/**
		 * 
		 * 
		 * <p>Title:findAllCompanyRentCarport</p>
		 * <p>Description: 查询所有企业已租车位信息</p>
		 * @author 王菁
		 * @return Pager
		 */
		public Pager findAllCompanyRentCarport(int currentPage,int cbdCarportRenterCompanyId);
		
		/**
		 * 
		 * 
		 * <p>Title:findAllCompanyCanRentCarpor</p>
		 * <p>Description:查询所有企业可租车位信息 </p>
		 * @author 王菁
		 * @return Pager
		 */
		public Pager findAllCompanyCanRentCarpor(int currentPage,int cbdCarportRenterCompanyId);
		
		
		/**
		 * zhangping
		 * 添加企业用户
		 */
		
		public int AddTheEnterprise(CompanyBean companyBean,String companyAccount);

		/**
		 * 添加根据用户名和密码查询
		 * @author yinshi
		 * @date 2018年2月1日
		 * @param userName
		 * @param companyPwd
		 * @return
		 */
		public CompanyBean getCompanyByNameAndPwd(String userName, String companyPwd);

		
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
		public Pager getAllPageCompany(String companyName,String
				companyAddress,String companyLinkMan,String companyPhone,
				int page,int size);
		
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
		public void removeByIdCompany(int id);
		
		//获取所有的企业信息
		public List<CompanyEntity> findAllCompany();
		
}
