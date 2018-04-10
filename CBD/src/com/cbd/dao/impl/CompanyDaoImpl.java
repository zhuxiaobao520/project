package com.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.cbd.bean.Pager;

import com.cbd.bean.CompanyBean;
import com.cbd.bean.CompanyCanRentCarport;
import com.cbd.bean.CompanyRentCarport;
import com.cbd.dao.ICompanyDao;
import com.cbd.entity.CompanyEntity;
import com.cbd.mapper.CompanyMapper;
import com.cbd.util.Constant;
import com.cbd.validator.Log;

/**
 * 企业用户登陆接口实现层
 * @author 张平
 *
 */
@Component
@Transactional //声明式事务管理
public class CompanyDaoImpl implements ICompanyDao {
	/**
	 * zhangping
	 * 企业用户登陆
	 */
	@Autowired
	public CompanyMapper companyMapper;
	@Override
	public CompanyEntity getCompany(String name) {
			CompanyEntity companyEntity = companyMapper.company(name);
			return companyEntity;
	}
	
	/**
	 * 
	 * 
	 * <p>Title:findCompanyRentCarportPage</p>
	 * <p>Description:企业已租车位分页数据 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager findCompanyRentCarportPage(int currentPage,int cbdCarportRenterCompanyId) {
		
		List<CompanyRentCarport> list = companyMapper.findAllRentCarport(cbdCarportRenterCompanyId);
		
		Pager pager = new Pager(Constant.PAGE_SIZE, list.size(), currentPage);
		List<CompanyRentCarport> companyRentCarports = companyMapper.findRentCarpotPage(cbdCarportRenterCompanyId, pager.getStartIndex(), Constant.PAGE_SIZE);
		
		pager.setDatas(companyRentCarports);
		
		return pager;
	}


	/**
	 * 
	 * 
	 * <p>Title:findCompanyById</p>
	 * <p>Description:根据Id查询企业用户 </p>
	 * @author 王菁
	 * @return CompanyEntity
	 */
	@Override
	public CompanyEntity findCompanyById(int id) {
		CompanyEntity companyEntity = companyMapper.findCompanyById(id);
		return companyEntity;
	}

	/**
	 * 
	 * 
	 * <p>Title:findCompanyByName</p>
	 * <p>Description:修改企业用户信息 </p>
	 * @author 王菁
	 * @return int
	 */
	@Override
	@Log(operationType="数据库操作",operationName="修改企业用户信息")
	public int updateCompanyInfo(CompanyEntity companyEntity) {
		int i = companyMapper.updateCompanyInfo(companyEntity);
		return i;
	}


	
	/**
	 * zhangping
	 * 添加企业用户
	 */
	@Override
	@Log(operationName="添加企业用户",operationType="数据库操作")
	public int addTheEnterprise(CompanyBean companyBean) {
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setCompanyAccount(companyBean.getCompanyAccount());
		companyEntity.setCompanyPassword(companyBean.getCompanyPassword());
		companyEntity.setCompanyName(companyBean.getCompanyName());
		companyEntity.setCompanyAddress(companyBean.getCompanyAddress());
		companyEntity.setCompanyLinkMan(companyBean.getCompanyLinkMan());
		companyEntity.setCompanyPhone(companyBean.getCompanyPhone());
			int num = companyMapper.AddTheEnterprise(companyEntity);
		return num;
	}
	
	/**
	 * zhangping
	 * 根据企业用户名字查询企业用户
	 */
	@Override
	public CompanyEntity getCompanyName(String companyAccount) {
		CompanyEntity companyEntity = companyMapper.getCompanyName(companyAccount);
		return companyEntity;
	}
	/**
	 * 添加根据用户名和密码查询
	 * @author yinshi
	 * @date 2018年2月1日
	 * @param userName
	 * @param companyPwd
	 * @return
	 */
	@Override
	public CompanyEntity getCompanyByNameAndPwd(String userName, String companyPwd) {
		// TODO Auto-generated method stub
		return companyMapper.getCompanyByNameAndPwd(userName,companyPwd);
	}


	@Override
	public int getAllCompany(String companyName, String companyAddress, String companyLinkMan, String companyPhone) {
		// TODO Auto-generated method stub
		return companyMapper.getAllCompany(companyName, companyAddress, companyLinkMan, companyPhone);
	}


	@Override
	public List<CompanyEntity> getAllPageCompany(String companyName, String companyAddress, String companyLinkMan,
			String companyPhone, int page, int size) {
		// TODO Auto-generated method stub
		return companyMapper.getAllPageCompany(companyName, companyAddress, companyLinkMan, companyPhone, page, size);
	}


	/**
	 * 
	 * 
	 * <p>Title:findCompanyByName</p>
	 * <p>Description:修改企业用户密码 </p>
	 * @author 王菁
	 * @return int
	 */
	@Override
	@Log(operationType="数据库操作",operationName="修改企业用户密码 ")
	public int updateCompanyPwd(int id,String newPwd) {
		int i = companyMapper.updateCompanyPwd(id,newPwd);
		return i;
	}
	
	/**
	 * 根据id查询企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @return
	 */
	public CompanyEntity getByIdCompany(int id){
		return companyMapper.getByIdCompany(id);
	}

	/**
	 * <p>Title:findCompanyCanRentCarportPage</p>
	 * <p>Description:企业可租车位分页数据 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager findCompanyCanRentCarportPage(int currentPage, int cbdCarportRenterCompanyId) {
		List<CompanyCanRentCarport> list = companyMapper.findAllCanrentCarport(cbdCarportRenterCompanyId);
		Pager pager = new Pager(Constant.PAGE_SIZE, list.size(), currentPage);
		List<CompanyCanRentCarport> canRentCarports = companyMapper.findAllCanrentCarportPage(cbdCarportRenterCompanyId, pager.getStartIndex(), Constant.PAGE_SIZE);
		pager.setDatas(canRentCarports);
		return pager;
	}

	@Override
	public List<CompanyEntity> findAllCompany() {
		// TODO Auto-generated method stub
		return companyMapper.findAllCompany();
	}

	@Override
	@Log(operationType="数据库操作",operationName="根据id，删除用户")
	public void deleteByIdCompany(int id) {
		companyMapper.removeByIdCompany(id);
	}
	
	/**
	 * 根据企业登录名查询是否存在
	 * @author 唐小雄
	 * @date 2018年2月8日
	 * @param companyAccount
	 * @return
	 */
	public int getCompanyAccount(String companyAccount){
		return companyMapper.getCompanyAccount(companyAccount);
	}
}
