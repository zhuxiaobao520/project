package com.cbd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.AdminBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.dao.IAdminDao;
import com.cbd.dao.ILogDao;
import com.cbd.dao.IRentInDao;
import com.cbd.dao.IRentOutDao;
import com.cbd.service.IRentInSerevice;
import com.cbd.service.IRentOutService;

/**
 * 用户测试用例
 * 
 * @author yg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@Transactional
public class LogDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ILogDao logDao;
	@Autowired
	private IRentInSerevice rentInService;

	@Autowired
	private IRentInDao rentInDao;
	@Autowired
	private IAdminDao iAdminDao;
	@Autowired
	private IRentOutDao rentOutDao;
	@Autowired
	private IRentOutService rentOutService;

	@Test
	public void logDaoTest() throws ParseException {
		// System.out.println(rentInService.getRentInPager(2, 1, 3));
		// System.out.println(rentInDao.getRentOutBeans(1, 0, 7));
		// System.out.println(rentOutService.getRentOutPager(1, 1, 7));
//		System.out.println(rentOutDao.getRentOutBean(6));
//		System.out.println(rentInDao.getRentInComplainBean(1));
//		System.out.println(rentInDao.getRentInfoBeanByRentInId(1));
		RentInInsertBean rentInInsertBean=new RentInInsertBean(1, 2, "我要租车");
		System.out.println(rentInDao.addRentInRecord(rentInInsertBean));
	}

}
