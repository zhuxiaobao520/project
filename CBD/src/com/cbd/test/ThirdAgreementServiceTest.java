package com.cbd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.Pager;
import com.cbd.dao.IThirdAgreementDao;
import com.cbd.entity.ThirdAgreementEntity;
import com.cbd.mapper.ThirdAgreementMapper;
import com.cbd.service.IThirdAgreementService;


/**
 * 第三方合约Service测试用例
 * @author 王菁
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@Transactional//声明式事务管理
public class ThirdAgreementServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private IThirdAgreementService thirdAgreementService;	
	
	@Autowired
	private IThirdAgreementDao thirdDao;
	
	@Autowired
	private ThirdAgreementMapper t;
	
	@Test
	public void serviceTest() throws Exception{
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	
		Date startTime = simpleDateFormat.parse("2017-02-03");
		Date endTime=simpleDateFormat.parse("2018-01-01");
	
/*		
		ThirdAgreementEntity thirdAgreementEntity = new ThirdAgreementEntity();
		thirdAgreementEntity.setThirdAggrementCompany("wefwvwevwvw");
		thirdAgreementEntity.setThirdAggrementNewNo("sdv");
		thirdAgreementEntity.setThirdAggrementLinkMan("asdvsdvs");
		thirdAgreementEntity.setThirdAggrementLinkManPhone("sdvsdvd");
		thirdAgreementEntity.setThirdAggrementStartTime(startTime);
		thirdAgreementEntity.setThirdAggrementEndTime(endTime);
		thirdAgreementEntity.setThirdAggrementPrice(444);
		thirdAgreementEntity.setThirdAggrementImageUrl("sdvsd");
		thirdAgreementEntity.setThirdAggrementCompanyAddress("wsdvwsdv");
		thirdAgreementEntity.setThirdAggrementStatus(1);
		int i = t.addThirdAgreement(thirdAgreementEntity);*/
		Pager pager = thirdDao.findThirdAgreementPage(1);
		System.out.println(pager);

		
		
		
	}
	
}
