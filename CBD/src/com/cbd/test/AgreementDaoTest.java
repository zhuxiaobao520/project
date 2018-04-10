package com.cbd.test;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.AgreementInsertBean;
import com.cbd.dao.IAgreementDao;
import com.cbd.service.IAgreementService;


/**
 * 用户签约合同测试用例
 * 
 * @author yg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@Transactional
public class AgreementDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private IAgreementDao iAgreeMentDao;
	@Autowired
	private IAgreementService iAgreementService;

	@Test
	public void AgreeMentDao() throws ParseException {
		AgreementInsertBean agreementInsertBean=new AgreementInsertBean();
		agreementInsertBean.setAgreementBuyInfoId(1);
		agreementInsertBean.setAgreementCarportId(19);
		System.out.println(iAgreementService.addAgreement(agreementInsertBean));
	}

}
