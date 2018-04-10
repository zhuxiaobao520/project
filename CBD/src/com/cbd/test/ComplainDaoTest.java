package com.cbd.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.Pager;
import com.cbd.controller.AdminController;
import com.cbd.dao.IAdminDao;
import com.cbd.dao.IComplainDao;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.ComplainEntity;

/**
 * 
 * <p>Title:ComplainDaoTest</p>
 * <p>Description: 投诉管理单元测试</p>
 * @author 朱小宝
 * @date2018年2月2日下午4:12:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@Transactional//声明式事务管理
public class ComplainDaoTest {

	@Autowired
	private IComplainDao complainDao;
	
	private static Logger logger=Logger.getLogger(ComplainDaoTest.class);
	@Test
	public void testComplainDao(){
	
//		List<ComplainEntity>list=complainDao.getComplainsList();
//		logger.debug(list);
		Pager pager=complainDao.getComplainByPage(0);
		logger.debug(pager);
	}
}
