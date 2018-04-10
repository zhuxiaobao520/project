package com.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.RentTaskBean;
import com.cbd.dao.IRentTaskDao;

/**
 * 
 * <p>Title:RentTaskDaoTest</p>
 * <p>Description:待办任务DAO测试类</p>
 * @author 龙成
 * @date2018年2月1日上午11:03:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@Transactional//声明式事务管理
public class RentTaskDaoTest {
	@Autowired
	private IRentTaskDao rentTaskDao;
	
	@Test
	public void testGetAllRentTask(){
		List<RentTaskBean> list = null;
		list = rentTaskDao.getAllRentTask(2);
		System.out.println(list);
	}
}
