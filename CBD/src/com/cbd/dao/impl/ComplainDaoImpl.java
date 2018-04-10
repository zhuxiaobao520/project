package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.ComplainBean;
import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;
import com.cbd.dao.IComplainDao;
import com.cbd.entity.ComplainEntity;
import com.cbd.mapper.ComplainMapper;
import com.cbd.validator.Log;

/**
 * 
 * <p>Title:ComplainDaoImpl</p>
 * <p>Description: 投诉信息Dao层实现类</p>
 * @author 朱小宝
 * @date2018年2月1日下午2:50:36
 */
@Component
@Transactional
public class ComplainDaoImpl implements IComplainDao{

	@Autowired
	private ComplainMapper complanMapper;
	
	@Override
	public List<ComplainEntity> getComplainsList() {
		// TODO Auto-generated method stub
		List<ComplainEntity>list=complanMapper.getComplainsList();
		return list;
	}

	@Override
	public Pager getComplainByPage(int curPage) {
		// TODO Auto-generated method stub
		Pager pager=new Pager(5, getComplainsList().size(), curPage);
		List<ComplainEntity>list=complanMapper.getComplainByPage(pager.getStartIndex(), pager.getPageSize());
		pager.setDatas(list);
		return pager;
	}

	@Override
	public ComplainBean getComplainById(int id) {
		// TODO Auto-generated method stub
		ComplainBean complainBean=complanMapper.getComplainById(id);
		return complainBean;
	}

	@Log(operationType="数据库操作",operationName="修改投诉状态")
	@Override
	public int updateComplainStatus(int id, String complainStatus) {
		// TODO Auto-generated method stub
		int num=complanMapper.updateComplainStatus(id, complainStatus);
		return num;
	}

	@Override
	@Log(operationType="数据库操作",operationName="添加投诉记录")
	public int addComplainInsertBean(ComplainInsertBean complainInsertBean) {
		// TODO Auto-generated method stub
		return complanMapper.addComplainInsertBean(complainInsertBean);
	}

	@Override
	public int getComplainNumByComplainUserIdAndEventId(int complainUserId, int complainEventId,
			String complainEventType) {
		// TODO Auto-generated method stub
		return complanMapper.getComplainNumByComplainUserIdAndEventId(complainUserId, complainEventId, complainEventType);
	}

}
