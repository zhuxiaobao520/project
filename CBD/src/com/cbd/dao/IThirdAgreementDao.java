package com.cbd.dao;

import java.util.List;

import com.cbd.bean.Pager;
import com.cbd.entity.ThirdAgreementEntity;
     

/**
 * 
 * 
 * <p>Title:IThirdAgreementDao</p>
 * <p>Description:第三方合约Dao接口 </p>
 * @author 王菁
 * @date2018年1月31日下午3:12:31
 */
public interface IThirdAgreementDao {
	
	
	/**
	 * 
	 * 
	 * <p>Title:findThirdAgreementPage</p>
	 * <p>Description:根据当前页查询分页数据 </p>
	 * @author 王菁
	 * @return Pager
	 */
	public Pager findThirdAgreementPage(int currentPage);
	
	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:添加第三方合约 </p>
	 * @author 王菁
	 * @return int
	 */
	public int addThirdAgreement(ThirdAgreementEntity thirdAgreementEntity);
	
	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:第三方合约解约 </p>
	 * @author 王菁
	 * @return int
	 */
	public int deleteAgreement(int id);
	
	/**
	 * 
	 * 
	 * <p>Title:selectThirdAgreementById</p>
	 * <p>Description:根据Id查询第三方合约 </p>
	 * @author 王菁
	 * @return ThirdAgreementEntity
	 */
	public ThirdAgreementEntity selectThirdAgreementById(int id);
	
	/**
	 * 
	 * 
	 * <p>Title:continueAgreement</p>
	 * <p>Description:第三方合约续约 </p>
	 * @author 王菁
	 * @return int
	 */
	public int updateAgreement(ThirdAgreementEntity thirdAgreementEntity);
	
	/**
	 * 
	 * <p>Title:getThirdAgreementIdByNewNo</p>
	 * <p>Description:根据合约号，查询合约id</p>
	 * @author 朱小宝
	 * @return int
	 */
	public int getThirdAgreementIdByNewNo(String thirdAggrementNewNo);
}
