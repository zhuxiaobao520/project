package com.cbd.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.AgreementSingleBean;
import com.cbd.bean.AgreementTaskBean;
import com.cbd.dao.IAgreementDao;
import com.cbd.dao.IUserDao;
import com.cbd.entity.AgreementEntity;
import com.cbd.mapper.IAgreementMapper;

import com.cbd.mapper.IBuyInfoMapper;
import com.cbd.mapper.IMessageMapper;
import com.cbd.mapper.UsercarportMapper;

import com.cbd.mapper.IBuyInfoMapper;
import com.cbd.mapper.IMessageMapper;
import com.cbd.mapper.UsercarportMapper;
import com.cbd.util.Constant;
import com.cbd.validator.Log;


/**
 * 购买合同dao层实现类
 * 
 * @author 唐小雄
 * @date 2018年1月31日
 */
@Component
public class AgreementDaoImpl implements IAgreementDao {

	@Autowired
	private IAgreementMapper agreementMapper;

	@Autowired
	private UsercarportMapper usercarportMapper;
	@Autowired
	private IBuyInfoMapper iBuyInfoMapper;
	@Autowired
	private IMessageMapper IMessageMapper;
	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private UsercarportMapper userCarportMapper;

	@Autowired
	private IBuyInfoMapper buyInfoMapper;

	
	@Autowired
	private IMessageMapper iMessageMapper;

	@Override
	public AgreementEntity getByIdAgreement(int id) {
		// TODO Auto-generated method stub
		return agreementMapper.getByIdAgreement(id);
	}

	@Override
	public List<AgreementTaskBean> getAllBuyAgreementTask(int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> taskBeans = agreementMapper.getAllBuyAgreementTask(userId);
		return taskBeans;
	}

	@Override
	public List<AgreementTaskBean> getBuyAgreementTaskPage(int starPage, int pageSize, int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> taskBeans = agreementMapper.getBuyAgreementTaskPage(starPage, pageSize, userId);
		return taskBeans;
	}

	@Override
	public List<AgreementTaskBean> getAllSaleAgreementTask(int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> taskBeans = agreementMapper.getAllSaleAgreementTask(userId);
		return taskBeans;
	}

	@Override
	public List<AgreementTaskBean> getSaleAgreementTaskPage(int starPage, int pageSize, int userId) {
		// TODO Auto-generated method stub
		List<AgreementTaskBean> taskBeans = agreementMapper.getSaleAgreementTaskPage(starPage, pageSize, userId);
		return taskBeans;
	}

	@Override
	public AgreementTaskBean getBuyAgreementTask(int agreementId, int userId) {
		// TODO Auto-generated method stub
		AgreementTaskBean agreementTaskBean = agreementMapper.getBuyAgreementTask(agreementId, userId);
		return agreementTaskBean;
	}

	@Override
	public AgreementTaskBean getSaleAgreementTask(int agreementId, int userId) {
		// TODO Auto-generated method stub
		AgreementTaskBean agreementTaskBean = agreementMapper.getSaleAgreementTask(agreementId, userId);
		return agreementTaskBean;
	}


	@Log(operationType="数据库操作",operationName="买方签约，修改合同状态")
	@Override
	public int updateBuyAgreementTask(int agreementId) {
		// TODO Auto-generated method stub
		int i = agreementMapper.updateBuyAgreementTask(agreementId);
		AgreementEntity agreementEntity = agreementMapper.getAgreementByAgreementId(agreementId);
		if(agreementEntity.getAgreementSalerSigned()){
			Date agreementTime = new Date(System.currentTimeMillis());
			agreementMapper.updateAgreementTime(agreementTime, agreementId);
			usercarportMapper.updateUserCarportStatusByUserCarportId(agreementEntity.getAgreementCarport().getUserCarportId(), "已售");
			iBuyInfoMapper.updateByIdBuyInfo(agreementEntity.getAgreementBuyInfo().getBuyInfoId(), "交易成功");
			IMessageMapper.insertMessage(agreementEntity.getAgreementCarport().getUserCarportAddress()+agreementEntity.getAgreementCarport().getUserCarportAddressNo()
					+"买卖合同已签约，购买车位成功", agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			IMessageMapper.insertMessage(agreementEntity.getAgreementCarport().getUserCarportAddress()+agreementEntity.getAgreementCarport().getUserCarportAddressNo()
					+"买卖合同已签约，出售车位成功", agreementEntity.getAgreementCarport().getUser().getUserId());
			iUserDao.updateUserBussinessCountById(agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			iUserDao.updateUserBussinessCountById(agreementEntity.getAgreementCarport().getUser().getUserId());
			iUserDao.updateUserReputation(agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			iUserDao.updateUserReputation(agreementEntity.getAgreementCarport().getUser().getUserId());
		}
		return i;
	}

	@Log(operationType="数据库操作",operationName="卖方签约，修改合同状态")
	@Override
	public int updateSaleAgreementTask(int agreementId) {
		// TODO Auto-generated method stub
		int i = agreementMapper.updateSaleAgreementTask(agreementId);
		AgreementEntity agreementEntity = agreementMapper.getAgreementByAgreementId(agreementId);
		if(agreementEntity.getAgreementBuyerSigned()){
			Date agreementTime = new Date(System.currentTimeMillis());
			agreementMapper.updateAgreementTime(agreementTime, agreementId);
			usercarportMapper.updateUserCarportStatusByUserCarportId(agreementEntity.getAgreementCarport().getUserCarportId(), "已售");
			iBuyInfoMapper.updateByIdBuyInfo(agreementEntity.getAgreementBuyInfo().getBuyInfoId(), "交易成功");
			IMessageMapper.insertMessage(agreementEntity.getAgreementCarport().getUserCarportAddress()+agreementEntity.getAgreementCarport().getUserCarportAddressNo()
					+"已买", agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			IMessageMapper.insertMessage(agreementEntity.getAgreementCarport().getUserCarportAddress()+agreementEntity.getAgreementCarport().getUserCarportAddressNo()
					+"已出售", agreementEntity.getAgreementCarport().getUser().getUserId());
			iUserDao.updateUserBussinessCountById(agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			iUserDao.updateUserBussinessCountById(agreementEntity.getAgreementCarport().getUser().getUserId());
			iUserDao.updateUserReputation(agreementEntity.getAgreementBuyInfo().getBuyInfoUser().getUserId());
			iUserDao.updateUserReputation(agreementEntity.getAgreementCarport().getUser().getUserId());
		}
		return i;
	}

	@Override
	public List<BuyDetailBean> getAllApplyForAgreementBuyInfoList(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return agreementMapper.getAllApplyForAgreementBuyInfoList(startIndex, pageSize);
	}

	@Override
	public int getAllApplyForAgreementBuyInfoNum() {
		// TODO Auto-generated method stub
		return agreementMapper.getAllApplyForAgreementBuyInfoNum();
	}

	@Override
	public BuyDetailBean getApplyForAgreementBuyDetailBean(int buyInfoId) {
		return agreementMapper.getApplyForAgreementBuyDetailBean(buyInfoId);
	}

	@Log(operationType="数据库操作",operationName="后台管理员新增用户出售合同")
	@Override
	public int addAgreement(AgreementInsertBean agreementInsertBean) {
		int result = 0;
		try {
			result = agreementMapper.addAgreement(agreementInsertBean);
			// 修改车位状态为待签约
			userCarportMapper.updateUserCarportStatusByUserCarportId(agreementInsertBean.getAgreementCarportId(),
					"待签约");
			// 修改购买信息的状态为待签约
			buyInfoMapper.updateByIdBuyInfo(agreementInsertBean.getAgreementBuyInfoId(), "待签约");
			//获得合同对应的详情
			result=agreementInsertBean.getAgreementId();
			AgreementInfoBean agreementInfoBean=agreementMapper.getAgreementInfoBeanByAgreementId(result);
			String buyerMessage=agreementInfoBean.getSaleUserName()+"已经同意出售车位"+agreementInfoBean.getUserCarportAddress()+agreementInfoBean.getUserCarportAddressNo()+"给你，请您尽快签约";
			iMessageMapper.insertMessage(buyerMessage, agreementInfoBean.getBuyUserId());
			
			String salerMessage=agreementInfoBean.getBuyUserName()+"已经购买您的车位："+agreementInfoBean.getUserCarportAddress()+agreementInfoBean.getUserCarportAddressNo()+"，请您尽快签约";
			iMessageMapper.insertMessage(salerMessage, agreementInfoBean.getSaleUserId());
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	@Override
	public List<AgreementInfoBean> getBuyerAgreementInfoBeansByPage(int buyUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		// param buyer.userId 或者saleuser.userId 用于拼接查询条件用
		return agreementMapper.getAgreementInfoBeansByPage(Constant.BUYER_USER_ID_PARAM_NAME, buyUserId, startIndex,
				pageSize);
	}

	@Override
	public int getBuyerAgreementInfoBeansNum(int buyUserId) {
		// TODO Auto-generated method stub
		return agreementMapper.getAgreementInfoBeansNum(Constant.BUYER_USER_ID_PARAM_NAME, buyUserId);
	}

	@Override
	public AgreementInfoBean getAgreementInfoBeanByAgreementId(int agreementId) {
		// TODO Auto-generated method stub
		return agreementMapper.getAgreementInfoBeanByAgreementId(agreementId);
	}

	@Override
	public List<AgreementInfoBean> getSalerAgreementInfoBeansByPage(int salerUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return agreementMapper.getAgreementInfoBeansByPage(Constant.SALER_USER_ID_PARAM_NAME, salerUserId, startIndex,
				pageSize);
	}

	@Override
	public int getSalerAgreementInfoBeansNum(int salerUserId) {
		// TODO Auto-generated method stub
		return agreementMapper.getAgreementInfoBeansNum(Constant.SALER_USER_ID_PARAM_NAME, salerUserId);
	}

	@Log(operationType="数据库操作",operationName="买家签约，修改合同状态")
	@Override
	public int updateBuyerSignedAgreement(int agreementId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = agreementMapper.updateUserSignedAgreement(Constant.BUYER_SIGNED, 1, agreementId);
			AgreementSingleBean agreementSingleBean = agreementMapper.getAgreementSingleBeanByAgreementId(agreementId);
			if (agreementSingleBean.getAgreementSalerSigned() == 1) {
				// 卖家已经签约则需要改变购买信息的状态为出售,
				// 修改车位状态为待签约
				userCarportMapper.updateUserCarportStatusByUserCarportId(agreementSingleBean.getAgreementCarportId(),
						"已售");
				// 修改购买信息的状态为待签约
				buyInfoMapper.updateByIdBuyInfo(agreementSingleBean.getAgreementBuyInfoId(), "交易成功");
			}
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	@Log(operationType="数据库操作",operationName="卖家签约，修改合同状态")
	@Override
	public int updateSalerSignedAgreement(int agreementId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = agreementMapper.updateUserSignedAgreement(Constant.SALER_SIGNED, 1, agreementId);
			AgreementSingleBean agreementSingleBean = agreementMapper.getAgreementSingleBeanByAgreementId(agreementId);
			if (agreementSingleBean.getAgreementBuyerSigned() == 1) {
				// 卖家已经签约则需要改变购买信息的状态为出售,
				// 修改车位状态为待签约
				userCarportMapper.updateUserCarportStatusByUserCarportId(agreementSingleBean.getAgreementCarportId(),
						"已售");
				// 修改购买信息的状态为待签约
				buyInfoMapper.updateByIdBuyInfo(agreementSingleBean.getAgreementBuyInfoId(), "交易成功");
			}
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

}
