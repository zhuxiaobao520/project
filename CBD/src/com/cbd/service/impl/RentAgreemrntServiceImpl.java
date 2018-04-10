package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.RenterAgreementBean;
import com.cbd.dao.IRentAgreementDao;
import com.cbd.entity.RenterAgreementEntity;
import com.cbd.service.IRentAgreementService;
@Component
public class RentAgreemrntServiceImpl implements IRentAgreementService {
   @Autowired
	private IRentAgreementDao rentDao;
	@Override
	public Pager getAgreementPage(int curPage) {
		// TODO Auto-generated method stub
		Pager pager=rentDao.findRentAgreement(curPage);
		return pager;
	}
	@Override
	public RenterAgreementEntity findAgreementById(int id) {
		// TODO Auto-generated method stub
		return rentDao.findAgreementById(id);
		
	}
	
	@Override
	public int updateOldAgreement(RenterAgreementEntity rentEntity) {
		// TODO Auto-generated method stub
		return  rentDao.updateOldAgreement(rentEntity);
	}
	@Override
	public void updateAgreemrntById(int id) {
		// TODO Auto-generated method stub
		rentDao.updateAgreemrntById(id);
	}


}
