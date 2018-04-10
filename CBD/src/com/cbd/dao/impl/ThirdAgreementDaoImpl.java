package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.bean.Pager;
import com.cbd.dao.IThirdAgreementDao;
import com.cbd.entity.ThirdAgreementEntity;
import com.cbd.mapper.ThirdAgreementMapper;
import com.cbd.validator.Log;

/**
 * 
 * 
 * <p>Title:ThirdAgreementDaoImpl</p>
 * <p>Description:第三方合约Dao实现类 </p>
 * @author 王菁
 * @date2018年1月31日下午3:13:57
 */

@Component
@Transactional//声明式事务管理
public class ThirdAgreementDaoImpl implements IThirdAgreementDao {

	@Autowired
	private ThirdAgreementMapper thirdAgreementMapper;

	/**
	 * 
	 * 
	 * <p>Title:findThirdAgreementPage</p>
	 * <p>Description:根据当前页查询第三方合约分页数据</p>
	 * @author 王菁
	 * @return Pager
	 */
	@Override
	public Pager findThirdAgreementPage(int currentPage) {
		
		//查询所有第三方合约
		List<ThirdAgreementEntity> list = thirdAgreementMapper.findAll();

		
		Pager pager = new Pager(5, list.size(), currentPage);
		List<ThirdAgreementEntity> thirdAgreements = thirdAgreementMapper.findThirdAgreementPage(pager.getStartIndex(), 5);
		
		pager.setDatas(thirdAgreements);
		return pager;
	}

	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:添加第三方合约</p>
	 * @author 王菁
	 * @return int
	 */


	@Override
	@Log(operationType="数据库操作",operationName="添加第三方合约")
	public int addThirdAgreement(ThirdAgreementEntity thirdAgreementEntity) {
		int i = thirdAgreementMapper.addThirdAgreement(thirdAgreementEntity);
		return i;
	}

	/**
	 * 
	 * 
	 * <p>Title:deleteAgreement</p>
	 * <p>Description:第三方合约解约</p>
	 * @author 王菁
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="第三方合约解约")
	@Override
	public int deleteAgreement(int id) {
		int i = thirdAgreementMapper.deleteAgreement(id);
		return i;
	}

	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:根据Id查询第三方合约</p>
	 * @author 王菁
	 * @return ThirdAgreementEntity
	 */
	@Override
	public ThirdAgreementEntity selectThirdAgreementById(int id) {
		ThirdAgreementEntity thirdAgreementEntity = thirdAgreementMapper.selectAgreementById(id);
		return thirdAgreementEntity;
	}

	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:第三方合约续约</p>
	 * @author 王菁
	 * @return int
	 */
	@Log(operationType="数据库操作",operationName="第三方合约续约")
	@Override
	public int updateAgreement(ThirdAgreementEntity thirdAgreementEntity) {
		int i = thirdAgreementMapper.updateAgreement(thirdAgreementEntity);
		return i;
	}

	@Override
	public int getThirdAgreementIdByNewNo(String thirdAggrementNewNo) {
		// TODO Auto-generated method stub
		int thirdAgreementId=thirdAgreementMapper.getThirdAgreementIdByNewNo(thirdAggrementNewNo);
		return thirdAgreementId;
	}





	
	
	
}
