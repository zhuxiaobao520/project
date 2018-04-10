package com.cbd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.AdminBean;
import com.cbd.bean.ComplainInsertBean;
import com.cbd.dao.IAdminDao;
import com.cbd.dao.IComplainDao;
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
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@Transactional
public class ComplainTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private IComplainDao iComplainDao;
	
	@Test
	public void iComplainDaoTest() throws ParseException {
		
		ComplainInsertBean complainInsertBean=new ComplainInsertBean(1, 2, 3, "出租", "未处理", "新增投诉", new Date());
		
		System.out.println(iComplainDao.addComplainInsertBean(complainInsertBean));
	}


}
