package com.cbd.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.CompanyBean;
import com.cbd.bean.Pager;
import com.cbd.dao.ICarportDao;
import com.cbd.dao.ICompanyDao;
import com.cbd.dao.IRentAgreementDao;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.entity.CompanyEntity;
import com.cbd.service.ICompanyService;

/**
 * 企业用户登陆业务逻辑是实现层
 * 
 * @author 张平
 *
 */
@Component
public class CompanyServiceImpl implements ICompanyService {
	/**
	 * 企业用户登陆
	 * 
	 * @author zhangping
	 * @date 2018年2月1日
	 * @param name
	 * @return
	 */
	@Autowired
	public ICompanyDao companyDao;
	
	@Autowired
	public ICarportDao carportDao;
	
	@Autowired
	public IRentAgreementDao rentAgreementDao;

	@Override
	public CompanyEntity companyEntity(String name) {
		CompanyEntity companyEntity = companyDao.getCompany(name);
		return companyEntity;
	}

	@Override
	public CompanyBean getCompanyByName(String username) {
		// TODO Auto-generated method stub
		CompanyEntity companyEntity = companyDao.getCompany(username);
		if (companyEntity != null) {
			return companyEntityToBean(companyEntity);
		}
		return null;
	}

	/**
	 * zhangping 添加企业用户
	 */
	@Override
	public int AddTheEnterprise(CompanyBean companyBean,String companyAccount) {
		// 掉用dao层方法查询有没有用户输出名
		CompanyEntity companyEntity = companyDao.getCompanyName(companyBean.getCompanyName());
		int num2 = companyDao.getCompanyAccount(companyAccount);
		if (num2 != 0) {
			return 1;
		}else if(companyEntity != null){
			return 2;
		}else{
			int num = companyDao.addTheEnterprise(companyBean);
			if (num == 1) {
				// 返回boolea类型
				return 3;
			}
			return 4;
		}
	}

	@Override
	public CompanyBean getCompanyByNameAndPwd(String userName, String companyPwd) {
		// TODO Auto-generated method stub
		CompanyEntity companyEntity = companyDao.getCompanyByNameAndPwd(userName, companyPwd);
		if(companyEntity != null){
			return companyEntityToBean(companyEntity);
		}
		return null;
	}


	/**
	 * 
	 * 
	 * <p>Title:findAllCompanyRentCarport</p>
	 * <p>Description:查询所有企业已租车位 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager findAllCompanyRentCarport(int currentPage, int cbdCarportRenterCompanyId) {
		Pager pager = companyDao.findCompanyRentCarportPage(currentPage, cbdCarportRenterCompanyId);
		if (pager!=null) {
			return pager;
		} else {
			return null;
		}
		
	}

	/**
	 * 
	 * 
	 * <p>Title:getCompanyById</p>
	 * <p>Description:根据Id查询企业用户 </p>
	 * @author 王菁
	 * @return CompanyBean
	 */
	@Override
	public CompanyBean getCompanyById(int id) {
		CompanyEntity companyEntity = companyDao.findCompanyById(id);
		CompanyBean companyBean = null;
		if (companyEntity!=null) {
			companyBean = new CompanyBean(companyEntity.getCompanyId(), 
					companyEntity.getCompanyAccount(), companyEntity.getCompanyPassword(),
					companyEntity.getCompanyName(), companyEntity.getCompanyAddress(),
					companyEntity.getCompanyLinkMan(), companyEntity.getCompanyPhone());
			return companyBean;
		}
		return null;
		
	}

	/**
	 * 
	 * 
	 * <p>Title:updateCompanyInfo</p>
	 * <p>Description:判断企业用户修改信息是否成功 </p>
	 * @author 王菁
	 * @return boolean
	 */
	@Override
	public boolean updateCompanyInfo(CompanyBean companyBean) {
		CompanyEntity companyEntity = new CompanyEntity(companyBean.getCompanyId(), 
				companyBean.getCompanyAccount(), companyBean.getCompanyPassword(),
				companyBean.getCompanyName(), companyBean.getCompanyAddress(), 
				companyBean.getCompanyLinkMan(), companyBean.getCompanyPhone());
		int i = companyDao.updateCompanyInfo(companyEntity);
		if (i>0) {
			return true;
		} else {
			return false;
		}
		
	}


	private CompanyBean companyEntityToBean(CompanyEntity companyEntity) {
		CompanyBean companyBean = new CompanyBean(companyEntity.getCompanyId(), companyEntity.getCompanyAccount(),
				companyEntity.getCompanyPassword(), companyEntity.getCompanyName(), companyEntity.getCompanyAddress(),
				companyEntity.getCompanyLinkMan(), companyEntity.getCompanyPhone());
		return companyBean;
	}

	@Override
	public Pager getAllPageCompany(String companyName, String companyAddress, String companyLinkMan,
			String companyPhone, int page, int size) {
		// TODO Auto-generated method stub
		int totalSize = companyDao.getAllCompany(companyName, companyAddress, companyLinkMan, companyPhone);
		Pager pager = new Pager(size, totalSize, page);
		List<CompanyEntity> list = companyDao.getAllPageCompany(companyName, companyAddress, companyLinkMan, companyPhone, pager.getStartIndex(), size);
		pager.setDatas(list);
		return pager;
	}

	
	/**
	 * 
	 * 
	 * <p>Title:findCompanyByName</p>
	 * <p>Description:判断企业用户修改密码是否成功 </p>
	 * @author 王菁
	 * @return boolean
	 */
	@Override
	public boolean updateCompanyPwd(int id,String newPwd) {
		
		int i = companyDao.updateCompanyPwd(id,newPwd);
		if (i>0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 根据id查询企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @return
	 */
	public CompanyEntity getByIdCompany(int id){
		return companyDao.getByIdCompany(id);
	}
	
	/**
	 * 根据ids删除企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @param map
	 * @return
	 */
	public void removeByIdCompany(int id){
		carportDao.updateManyCarport(id);
		rentAgreementDao.deleteManyAgreement(id);
		companyDao.deleteByIdCompany(id);
	}

	@Override
	public List<CompanyEntity> findAllCompany() {
		// TODO Auto-generated method stub
		return companyDao.findAllCompany();
	}
	
	/**
	 * 
	 * 
	 * <p>Title:findAllCompanyCanRentCarpor</p>
	 * <p>Description:查询所有企业可租车位 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager findAllCompanyCanRentCarpor(int currentPage, int cbdCarportRenterCompanyId) {
		Pager pager = companyDao.findCompanyCanRentCarportPage(currentPage, cbdCarportRenterCompanyId);
		return pager;
	}

}
