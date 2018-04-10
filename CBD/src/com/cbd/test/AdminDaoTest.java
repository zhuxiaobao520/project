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
import com.cbd.bean.RentTaskBean;
import com.cbd.controller.AdminController;
import com.cbd.dao.IAdminDao;
import com.cbd.dao.IRentTaskDao;
import com.cbd.entity.AdminEntity;

/**
 * 
 * <p>Title:AdminDaoTest</p>
 * <p>Description: 超级管理员单元测试</p>
 * @author 朱小宝
 * @date2018年2月2日下午4:04:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@Transactional//声明式事务管理
public class AdminDaoTest {

	@Autowired
	private IAdminDao adminDao;
	
	private static Logger logger=Logger.getLogger(AdminDaoTest.class);
	@Test
	public void testAdminDao(){
		List<AdminEntity>list=adminDao.getAdmins();
		Pager pager=adminDao.getAdminsByPage(1);
//		logger.debug(list);
		logger.debug(pager);
	}
}
