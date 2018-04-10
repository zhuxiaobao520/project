package com.cbd.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.ComplainBean;
import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;
import com.cbd.dao.IBuyInfoDao;
import com.cbd.dao.IComplainDao;
import com.cbd.dao.IRentInDao;
import com.cbd.dao.IUserDao;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.entity.ComplainEntity;
import com.cbd.entity.RentInEntity;
import com.cbd.service.IComplainService;

/**
 * 
 * <p>
 * Title:ComplainServiceImpl
 * </p>
 * <p>
 * Description:投诉信息Service层实现类
 * </p>
 * 
 * @author 朱小宝
 * @date2018年2月1日下午2:52:21
 */
@Component
public class ComplainServiceImpl implements IComplainService {

	@Autowired
	private IComplainDao complainDao;

	@Autowired
	private IRentInDao rentInDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IBuyInfoDao buyInfoDao;

	@Override
	public Pager getComplainByPage(int curPage) {
		// TODO Auto-generated method stub
		Pager pager = complainDao.getComplainByPage(curPage);
		return pager;
	}

	@Override
	public HashMap<String, Object> getComplainInfoById(int id) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
		ComplainBean complainBean = complainDao.getComplainById(id);
		// 判断是招租，租赁
		if (complainBean.getComplainEventType().equals("招租")) {
			RentInEntity rentInEntity = rentInDao.getRentInById(complainBean.getComplainEventId(),
					complainBean.getComplainedUser().getUserId());
			map.put("eventObject", rentInEntity);
		} else if (complainBean.getComplainEventType().equals("租赁")) {
			RentInEntity rentInEntity = rentInDao.getRentInById(complainBean.getComplainEventId(),
					complainBean.getComplainUser().getUserId());
			map.put("eventObject", rentInEntity);
		} else if (complainBean.getComplainEventType().equals("出售")) {
			BuyInfoEntity buyInfoEntity = buyInfoDao.getBuyInfoByIdAndStatus(complainBean.getComplainEventId(),
					complainBean.getComplainedUser().getUserId());
			map.put("eventObject", buyInfoEntity);
		} else {
			BuyInfoEntity buyInfoEntity = buyInfoDao.getBuyInfoByIdAndStatus(complainBean.getComplainEventId(),
					complainBean.getComplainUser().getUserId());
			map.put("eventObject", buyInfoEntity);
		}
		map.put("complainInfo", complainBean);
		return map;
	}

	@Override
	public Boolean updateComplainStatus(int id, String complainStatus) {
		// TODO Auto-generated method stub
		int num = complainDao.updateComplainStatus(id, complainStatus);
		if (num == 1) {
			if (complainStatus.equals("投诉生效")) {
				ComplainBean complainBean = complainDao.getComplainById(id);
				userDao.updateUserComplainedCount(complainBean.getComplainedUser().getUserId());
			}
			return true;
		}
		return false;
	}

	@Override
	public int addComplainInsertBean(ComplainInsertBean complainInsertBean) {
		// TODO Auto-generated method stub
		return complainDao.addComplainInsertBean(complainInsertBean);
	}

	@Override
	public boolean eventIsComplained(int complainUserId, int complainEventId, String complainEventType) {
		// TODO Auto-generated method stub
		int num = complainDao.getComplainNumByComplainUserIdAndEventId(complainUserId, complainEventId,
				complainEventType);
		if (num == 0) {
			return true;
		}
		return false;
	}

}
