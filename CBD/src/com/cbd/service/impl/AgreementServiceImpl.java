package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.AgreementTaskBean;
import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.Pager;
import com.cbd.dao.IAgreementDao;
import com.cbd.entity.AgreementEntity;
import com.cbd.service.IAgreementService;

/**
 * 购买合同逻辑层实现类
 * 
 * @author 唐小雄
 * @date 2018年1月31日
 */
@Component
public class AgreementServiceImpl implements IAgreementService {

	@Autowired
	private IAgreementDao agreementDao;

	@Override
	public AgreementEntity getByIdAgreement(int id) {
		// TODO Auto-generated method stub
		return agreementDao.getByIdAgreement(id);
	}

	@Override
	public Pager getBuyAgreementTaskPage(int curPage, int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> list = agreementDao.getAllBuyAgreementTask(userId);
		Pager pager = new Pager(5, list.size(), curPage);
		List<AgreementTaskBean> agreementTaskBeans = agreementDao.getBuyAgreementTaskPage(pager.getStartIndex(), 5,
				userId);
		pager.setDatas(agreementTaskBeans);
		return pager;
	}

	@Override
	public Pager getSaleAgreementTaskPage(int curPage, int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> list = agreementDao.getAllSaleAgreementTask(userId);
		Pager pager = new Pager(5, list.size(), curPage);
		List<AgreementTaskBean> agreementTaskBeans = agreementDao.getSaleAgreementTaskPage(pager.getStartIndex(), 5,
				userId);
		pager.setDatas(agreementTaskBeans);
		return pager;
	}

	@Override
	public AgreementTaskBean getBuyAgreementTask(int agreementId, int userId) {
		// TODO Auto-generated method stub
		AgreementTaskBean agreementTaskBean = agreementDao.getBuyAgreementTask(agreementId, userId);
		return agreementTaskBean;
	}

	@Override
	public AgreementTaskBean getSaleAgreementTask(int agreementId, int userId) {
		// TODO Auto-generated method stub
		AgreementTaskBean agreementTaskBean = agreementDao.getSaleAgreementTask(agreementId, userId);
		return agreementTaskBean;
	}


	@Override
	public boolean updateBuyAgreementTask(int agreementId) {
		// TODO Auto-generated method stub
		int i = agreementDao.updateBuyAgreementTask(agreementId);
		if(i==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSaleAgreementTask(int agreementId) {
		// TODO Auto-generated method stub
		int i = agreementDao.updateSaleAgreementTask(agreementId);
		if(i==1){
			return true;
		}
		return false;
	}


	@Override
	public Pager getAllApplyForAgreementBuyInfoPager(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int totalRecorNum = agreementDao.getAllApplyForAgreementBuyInfoNum();
		Pager pager = new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(agreementDao.getAllApplyForAgreementBuyInfoList(pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public BuyDetailBean getApplyForAgreementBuyDetailBean(int buyInfoId) {
		// TODO Auto-generated method stub
		return agreementDao.getApplyForAgreementBuyDetailBean(buyInfoId);
	}

	@Override
	public boolean addAgreement(AgreementInsertBean agreementInsertBean) {
		// TODO Auto-generated method stub
		if(agreementDao.addAgreement(agreementInsertBean)!=0){
			return true;
		}
		return false;
	}

	@Override
	public Pager getBuyerAgreementPager(int buyUserId ,int currentPage, int pageSize) {
		int totalRecorNum = agreementDao.getBuyerAgreementInfoBeansNum(buyUserId);
		Pager pager = new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(agreementDao.getBuyerAgreementInfoBeansByPage(buyUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public Pager getSalerAgreementPager(int salerUserId, int currentPage, int pageSize) {
		int totalRecorNum = agreementDao.getBuyerAgreementInfoBeansNum(salerUserId);
		Pager pager = new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(agreementDao.getSalerAgreementInfoBeansByPage(salerUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public AgreementInfoBean getAgreementInfoBeanByAgreementId(int agreementId) {
		// TODO Auto-generated method stub
		return agreementDao.getAgreementInfoBeanByAgreementId(agreementId);
	}

	@Override
	public boolean updateBuyerSignedAgreement(int agreementId) {
		// TODO Auto-generated method stub
		if(agreementDao.updateBuyerSignedAgreement(agreementId)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSalerSignedAgreement(int agreementId) {
		if(agreementDao.updateSalerSignedAgreement(agreementId)==1){
			return true;
		}
		return false;
	}

}
