package com.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.dao.IRentOutDao;
import com.cbd.dao.IUsercarportDao;
import com.cbd.entity.RentOutEntity;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IRentOutService;

/**
 * 出租记录的业务层实现类
 * @author 姚刚
 * @date 2018年1月31日
 */
@Component
public class RentOutServiceImpl implements IRentOutService {

	@Autowired
	private IRentOutDao rentOutDao;
	@Autowired
	private IUsercarportDao usercarportDao;
	/**
	 * 查询当前用户的出租记录
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId
	 * @param currentPage
	 * @param pageSize
	 * @return 查询当前用户的出租记录集合
	 */
	@Override
	public Pager getRentOutPager(int rentOutUserId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		int totalRecorNum =rentOutDao.getRentOutBeansNum(rentOutUserId);
		Pager pager = new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(rentOutDao.getRentOutBeans(rentOutUserId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public boolean addRentOutBean(RentOutInsertBean rentOutInsertBean) {
		// TODO Auto-generated method stub
		UsercarportEntity usercarportEntity=usercarportDao.getByIdUsercarport(rentOutInsertBean.getRentOutCarportId());
		//当前车位是空闲时，才添加
		if(usercarportEntity.getUserCarportStatus().equals("空闲")){
			//添加记录
			int resultid=rentOutDao.addRentOutBean(rentOutInsertBean);
			if(resultid!=0){
				return true;
			}
		}
		return false;
	}

	@Override
	public RentOutEntity getRentOutById(int rentOutId) {
		
		return rentOutDao.getRentOutById(rentOutId);
	}
	
	@Override
	public Pager getUseableCarportPager(int currentPage, int pageSize) {
		int totalRecorNum =rentOutDao.getUseableCarportNum();
		Pager pager = new Pager(pageSize, totalRecorNum, currentPage);
		pager.setDatas(rentOutDao.getUseableCarport(pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public UseableRentOutInfoBean getUseableRentOutInfoByRentOutId(int rentOutId) {
		// TODO Auto-generated method stub
		return rentOutDao.getUseableRentOutInfoByRentOutId(rentOutId);
	}

	@Override
	public RentOutBean getRentOutBean(int rentInId) {
		// TODO Auto-generated method stub
		return rentOutDao.getRentOutBean(rentInId);
	}

	@Override
	public boolean getRentOutByCarportId(int userCarportId) {
		// TODO Auto-generated method stub
		int num=rentOutDao.getRentOutByCarportId(userCarportId, "待租", "通过");
		if(num!=0){
			return true;
		}
		return false;
	}
}
