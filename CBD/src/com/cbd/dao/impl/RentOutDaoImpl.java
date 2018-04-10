package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.dao.IRentOutDao;
import com.cbd.entity.RentOutEntity;
import com.cbd.mapper.RentOutMapper;
import com.cbd.mapper.UsercarportMapper;
import com.cbd.validator.Log;

/**
 * 出租记录的dao实现类
 * @author 姚刚
 * @date 2018年1月31日
 */
@Component
@Transactional
public class RentOutDaoImpl implements IRentOutDao {
	@Autowired
	private RentOutMapper rentOutMapper;
	
	@Autowired
	private UsercarportMapper usercarportMapper;
	/**
	 * 查询出租记录
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId 出租用户id 即是当前用户id
	 * @param startIndex
	 * @param pageSize
	 * @return 当前出租记录集合
	 */
	@Override
	public List<RentOutBean> getRentOutBeans(int rentOutUserId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return rentOutMapper.getRentOutBeans(rentOutUserId, startIndex, pageSize);
	}
	
	/**
	 * 
	 * @author 姚刚
	 * @date 2018年1月31日
	 * @param rentOutUserId 出租用户id 即是当前用户id
	 * @return 出租记录条数
	 */
	@Override
	public int getRentOutBeansNum(int rentOutUserId) {
		// TODO Auto-generated method stub
		return rentOutMapper.getRentOutBeansNum(rentOutUserId);
	}
	
	@Log(operationType="数据库操作",operationName="添加出租信息")
	@Override
	public int addRentOutBean(RentOutInsertBean rentOutInsertBean) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			/**
			 * 修改车位状态为待租
			 */
			rentOutMapper.addRentOutBean(rentOutInsertBean);
			usercarportMapper.updateUserCarportStatusByUserCarportId(rentOutInsertBean.getRentOutCarportId(),"待租");
			result=rentOutInsertBean.getRentOutCarportId();
		} catch (Exception e) {
			// TODO: handle exception
			result=0;
		}
		return result;
	}
	
	@Override
	public RentOutEntity getRentOutById(int rentOutId) {
		return rentOutMapper.getRentOutById(rentOutId);
	}
	@Override
	public List<UseableRentOutInfoBean> getUseableCarport(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return rentOutMapper.getUseableCarport(startIndex, pageSize);
	}
	@Override
	public int getUseableCarportNum() {
		// TODO Auto-generated method stub
		return rentOutMapper.getUseableCarportNum();
	}
	@Override
	public UseableRentOutInfoBean getUseableRentOutInfoByRentOutId(int rentOutId) {
		// TODO Auto-generated method stub
		return rentOutMapper.getUseableRentOutInfoByRentOutId(rentOutId);
	}
	@Override
	public RentOutBean getRentOutBean(int rentInId) {
		// TODO Auto-generated method stub
		return rentOutMapper.getRentOutBean(rentInId);
	}

	@Override
	public int getRentOutByCarportId(int userCarportId, String userCarportStatus, String userCarportAuditingStatus) {
		// TODO Auto-generated method stub
		return rentOutMapper.getRentOutByCarportId(userCarportId, userCarportStatus, userCarportAuditingStatus);
	}
}
