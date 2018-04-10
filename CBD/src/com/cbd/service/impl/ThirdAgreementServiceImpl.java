package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.ThirdAgreementBean;
import com.cbd.dao.IThirdAgreementDao;
import com.cbd.entity.ThirdAgreementEntity;
import com.cbd.service.IThirdAgreementService;


/**
 * 
 * 
 * <p>Title:ThirdAgreementServiceImpl</p>
 * <p>Description:第三方合约service实现类 </p>
 * @author 王菁
 * @date2018年1月31日下午3:09:03
 */

@Component
public class ThirdAgreementServiceImpl implements IThirdAgreementService {

	@Autowired
	private IThirdAgreementDao thirdAgreementDao;
	
	/**
	 * 
	 * 
	 * <p>Title:handleInfo</p>
	 * <p>Description:第三方合约分页数据 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager handleInfo(int currentPage) {
		Pager pager = thirdAgreementDao.findThirdAgreementPage(currentPage);
		return pager;
	}

	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:判断第三方合约是否添加成功 </p>
	 * @author 王菁
	 * @return boolean
	 */
	@Override
	public boolean addThirdAgreement(ThirdAgreementBean thirdAgreementBean) {
		
		ThirdAgreementEntity thirdAgreementEntity = new ThirdAgreementEntity();
		thirdAgreementEntity.setThirdAggrementNewNo(thirdAgreementBean.getThirdAggrementNewNo());
		thirdAgreementEntity.setThirdAggrementCompany(thirdAgreementBean.getThirdAggrementCompany());
		thirdAgreementEntity.setThirdAggrementLinkMan(thirdAgreementBean.getThirdAggrementLinkMan());
		thirdAgreementEntity.setThirdAggrementLinkManPhone(thirdAgreementBean.getThirdAggrementLinkManPhone());
		thirdAgreementEntity.setThirdAggrementStartTime(thirdAgreementBean.getThirdAggrementStartTime());
		thirdAgreementEntity.setThirdAggrementEndTime(thirdAgreementBean.getThirdAggrementEndTime());
		thirdAgreementEntity.setThirdAggrementPrice(thirdAgreementBean.getThirdAggrementPrice());
		thirdAgreementEntity.setThirdAggrementImageUrl(thirdAgreementBean.getThirdAggrementImageUrl());
		thirdAgreementEntity.setThirdAggrementCompanyAddress(thirdAgreementBean.getThirdAggrementCompanyAddress());
		thirdAgreementEntity.setThirdAggrementStatus(1);
		
		int i = thirdAgreementDao.addThirdAgreement(thirdAgreementEntity);
		if (i>0) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:判断第三方合约是否解约成功 </p>
	 * @author 王菁
	 * @return boolean
	 */
	@Override
	public boolean deleteAgreement(int id) {
		int i = thirdAgreementDao.deleteAgreement(id);
		if (i>0) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * 
	 * 
	 * <p>Title:selectThirdAgreementById</p>
	 * <p>Description:根据Id查询第三方合约 </p>
	 * @author 王菁
	 * @return ThirdAgreementBean
	 */
	@Override
	public ThirdAgreementBean selectThirdAgreementById(int id) {
		
		ThirdAgreementBean thirdAgreementBean = new ThirdAgreementBean();
		//实体类转换成Bean类
		ThirdAgreementEntity thirdAgreementEntity = thirdAgreementDao.selectThirdAgreementById(id);
		thirdAgreementBean.setThirdAggrementId(thirdAgreementBean.getThirdAggrementId());
		thirdAgreementBean.setThirdAggrementOldNo(thirdAgreementEntity.getThirdAggrementOldNo());
		thirdAgreementBean.setThirdAggrementNewNo(thirdAgreementEntity.getThirdAggrementNewNo());
		thirdAgreementBean.setThirdAggrementCompany(thirdAgreementEntity.getThirdAggrementCompany());
		thirdAgreementBean.setThirdAggrementLinkMan(thirdAgreementEntity.getThirdAggrementLinkMan());
		thirdAgreementBean.setThirdAggrementLinkManPhone(thirdAgreementEntity.getThirdAggrementLinkManPhone());
		thirdAgreementBean.setThirdAggrementStartTime(thirdAgreementEntity.getThirdAggrementStartTime());
		thirdAgreementBean.setThirdAggrementEndTime(thirdAgreementEntity.getThirdAggrementEndTime());
		thirdAgreementBean.setThirdAggrementImageUrl(thirdAgreementEntity.getThirdAggrementImageUrl());
		thirdAgreementBean.setThirdAggrementStatus(thirdAgreementEntity.getThirdAggrementStatus());
		thirdAgreementBean.setThirdAggrementPrice(thirdAgreementEntity.getThirdAggrementPrice());
		
		return thirdAgreementBean;
	}

	/**
	 * 
	 * 
	 * <p>Title:continueAgreement</p>
	 * <p>Description:判断第三方合约续约是否成功 </p>
	 * @author 王菁
	 * @return boolean
	 */
	@Override
	public boolean updateAgreement(ThirdAgreementBean thirdAgreementBean) {
		
		ThirdAgreementEntity thirdAgreementEntity = new ThirdAgreementEntity();
		thirdAgreementEntity.setThirdAggrementId(thirdAgreementBean.getThirdAggrementId());
		thirdAgreementEntity.setThirdAggrementNewNo(thirdAgreementBean.getThirdAggrementNewNo());
		thirdAgreementEntity.setThirdAggrementImageUrl(thirdAgreementBean.getThirdAggrementImageUrl());
		thirdAgreementEntity.setThirdAggrementEndTime(thirdAgreementBean.getThirdAggrementEndTime());
		thirdAgreementEntity.setThirdAggrementStartTime(thirdAgreementBean.getThirdAggrementStartTime());
		
		int i = thirdAgreementDao.updateAgreement(thirdAgreementEntity);
		if (i>0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int getThirdAgreementIdByNewNo(String thirdAggrementNewNo) {
		// TODO Auto-generated method stub
		int thirdAgreementId=thirdAgreementDao.getThirdAgreementIdByNewNo(thirdAggrementNewNo);
		return thirdAgreementId;
	}

	
	
}
