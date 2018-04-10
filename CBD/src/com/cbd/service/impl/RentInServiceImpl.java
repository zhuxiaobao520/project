package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.dao.IRentInDao;
import com.cbd.entity.RentInEntity;
import com.cbd.service.IRentInSerevice;

/**
 * 租赁信息的service实现类
 * @author 姚刚
 *
 */
@Component
public class RentInServiceImpl implements IRentInSerevice{

	@Autowired
	private IRentInDao rentInDao;
	
	/**
	 * 根据当前用户id 获得当前用户租赁记录集合
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentInUserId 当前用户的id
	 * @param currentPage
	 * @param pageSize
	 * @return 当前用户租赁记录集合
	 */
	@Override
	public Pager getRentInPager(int rentInUserId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		int totalRecorNum=rentInDao.getRentInBeansNum(rentInUserId);
		Pager pager=new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(rentInDao.getRentInBeans(rentInUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	
	@Override
	public boolean updateRentInStatus(int rentInId, int rentInUserId, String rentInStatus) {
		int num = rentInDao.updateRentInStatus(rentInId, rentInUserId, rentInStatus);
		if(num == 0){
			return false;
		}
		return true;
	}


	@Override
	public boolean updateOtherUserRentInStatus(int rentOutId, int rentInUserId, String rentInStatus) {
		int num = rentInDao.updateOtherUserRentInStatus(rentOutId, rentInUserId, rentInStatus);
		if(num == 0){
			return false;
		}
		return true;
	}


	@Override
	public List<RentInEntity> getRentInEntitiesByRentOutId(int rentOutId, int rentInId) {	
		return rentInDao.getRentInEntitiesByRentOutId(rentOutId, rentInId);
	}
	

	@Override
	public boolean addRentInRecord(RentInInsertBean rentInInsertBean) {
		// TODO Auto-generated method stub
		int num = rentInDao.addRentInRecord(rentInInsertBean);
		if(num != 0){
			return true;
		}
		return false;
	}

	@Override
	public int getRentInNumByRentOutIdAndRentInUserId(int rentOutId, int rentInUserId) {
		// TODO Auto-generated method stub
		return rentInDao.getRentInNumByRentOutIdAndRentInUserId(rentOutId, rentInUserId);
	}


	@Override
	public RentInComplainBean getRentInComplainBean(int rentInId) {
		// TODO Auto-generated method stub
		return rentInDao.getRentInComplainBean(rentInId);
	}


	

}
