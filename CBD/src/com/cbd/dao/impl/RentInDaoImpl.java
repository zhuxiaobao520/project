package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.RentInBean;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.bean.RentInfoBean;
import com.cbd.dao.IRentInDao;
import com.cbd.entity.RentInEntity;
import com.cbd.mapper.IMessageMapper;
import com.cbd.mapper.RentInMapper;
import com.cbd.validator.Log;

/**
 * 租赁信息dao
 * @author 姚刚
 * @date 2018年2月2日
 */
@Component
@Transactional
public class RentInDaoImpl implements IRentInDao {

	@Autowired
	private RentInMapper rentInMapper;
	@Autowired
	private IMessageMapper iMessageMapper;

	@Override
	public List<RentInBean> getRentInBeans(int rentInUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInBeans(rentInUserId, startIndex, pageSize);
	}

	@Override
	public int getRentInBeansNum(int rentInUserId) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInBeansNum(rentInUserId);
	}

	@Override
	@Log(operationType="数据库操作",operationName="修改租赁记录状态")
	public int updateRentInStatus(int rentInId, int rentInUserId, String rentInStatus) {

		return rentInMapper.updateRentInStatus(rentInId, rentInUserId, rentInStatus);
	}

	@Override
	@Log(operationType="数据库操作",operationName="修改未预约成功的租赁记录状态")
	public int updateOtherUserRentInStatus(int rentOutId, int rentInUserId, String rentInStatus) {
		// TODO Auto-generated method stub
		return rentInMapper.updateOtherUserRentInStatus(rentOutId, rentInUserId, rentInStatus);
	}

	@Override
	public List<RentInEntity> getRentInEntitiesByRentOutId(int rentOutId, int rentInId) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInEntitiesByRentOutId(rentOutId, rentInId);
	}

	

	@Override
	public RentInEntity getRentInById(int id, int userId) {
		// TODO Auto-generated method stub
		RentInEntity rentInEntity = rentInMapper.getRentInById(id, userId);
		return rentInEntity;
	}

	@Log(operationType="数据库操作",operationName="新增租赁记录")
	@Override
	public int addRentInRecord(RentInInsertBean rentInInsertBean) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			rentInMapper.addRentInRecord(rentInInsertBean);
			RentInfoBean rentInfoBean=rentInMapper.getRentInfoBeanByRentInId(rentInInsertBean.getRentInId());
			String rentInMessage="用户："+rentInfoBean.getRentInUserName()+"已经预定租赁您的车位："+rentInfoBean.getUserCarportAddress()+rentInfoBean.getUserCarportAddressNo();
			iMessageMapper.insertMessage(rentInMessage, rentInfoBean.getRentOutUserId());
			result=rentInInsertBean.getRentInId();
		} catch (Exception e) {
			result=0;
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int getRentInNumByRentOutIdAndRentInUserId(int rentOutId, int rentInUserId) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInNumByRentOutIdAndRentInUserId(rentOutId, rentInUserId);
	}

	@Override
	public RentInComplainBean getRentInComplainBean(int rentInId) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInComplainBean(rentInId);
	}

	@Override
	public RentInfoBean getRentInfoBeanByRentInId(int rentInId) {
		// TODO Auto-generated method stub
		return rentInMapper.getRentInfoBeanByRentInId(rentInId);
	}

}
