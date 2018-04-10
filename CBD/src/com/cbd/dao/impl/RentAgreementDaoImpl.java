package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.Pager;
import com.cbd.bean.RenterAgreementBean;
import com.cbd.dao.IRentAgreementDao;
import com.cbd.entity.RenterAgreementEntity;
import com.cbd.mapper.RentAgreementMapper;
import com.cbd.util.Constant;
import com.cbd.validator.Log;
@Component
@Transactional
public class RentAgreementDaoImpl implements IRentAgreementDao{
    @Autowired
	private RentAgreementMapper rentMapper;
	@Override
	public Pager findRentAgreement(int curPage) {
		// TODO Auto-generated method stub
		int size =Constant.PAGE_RENTSIZE;
		List<RenterAgreementEntity> list=rentMapper.getAllAgreement();
		List<RenterAgreementEntity> list2=rentMapper.getPageAgreement((curPage-1)*size,size);
		Pager pager=new Pager(size, list.size(), curPage);
		pager.setDatas(list2);
		return pager;
	}
	@Override
	public RenterAgreementEntity findAgreementById(int id) {
		// TODO Auto-generated method stub
	  RenterAgreementEntity rentEntity=rentMapper.findAgreementById(id);
	  return rentEntity;
	}
	@Override
	@Log(operationType="数据库操作",operationName="添加新合约信息")
	public int updateOldAgreement(RenterAgreementEntity rentEntity) {
		// TODO Auto-generated method stub
		 rentMapper.updateAgreementById(rentEntity.getRenterAgreementId());	
		  rentMapper.addNewAgreement(rentEntity);
		 return rentEntity.getRenterAgreementId();
	}
	@Override
	@Log(operationType="数据库操作",operationName="更新续约合同信息")
	public void updateAgreemrntById(int id) {
		// TODO Auto-generated method stub
		rentMapper.updateAgreementById(id);
	}
	
	@Log(operationType="数据库操作",operationName="删除合同信息")
	@Override
	public void deleteManyAgreement(int id) {
		// TODO Auto-generated method stub
		rentMapper.deleteManyAgreement(id);
	}

 
}
