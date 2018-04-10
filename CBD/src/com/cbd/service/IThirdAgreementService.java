package com.cbd.service;

import com.cbd.bean.Pager;
import com.cbd.bean.ThirdAgreementBean;

/**
 * 
 * 
 * <p>Title:IThirdAgreementService</p>
 * <p>Description:第三方合约Service接口 </p>
 * @author 王菁
 * @date2018年1月31日下午3:18:45
 */

public interface IThirdAgreementService {

	/**
	 * 
	 * 
	 * <p>Title:handleInfo</p>
	 * <p>Description:第三方合约分页数据 </p>
	 * @author 王菁
	 * @return Pager
	 */
	public Pager handleInfo(int currentPage);
	
	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:添加第三方合约 </p>
	 * @author 王菁
	 * @return boolean
	 */
	public boolean addThirdAgreement(ThirdAgreementBean thirdAgreementBean);
	
	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:第三方合约解约 </p>
	 * @author 王菁
	 * @return boolean
	 */
	public boolean deleteAgreement(int id);
	
	/**
	 * 
	 * 
	 * <p>Title:selectThirdAgreementById</p>
	 * <p>Description:根据Id查询第三方合约 </p>
	 * @author 王菁
	 * @return ThirdAgreementBean
	 */
	public ThirdAgreementBean selectThirdAgreementById(int id);
	
	/**
	 * 
	 * 
	 * <p>Title:continueAgreement</p>
	 * <p>Description:第三方合约续约 </p>
	 * @author 王菁
	 * @return boolean
	 */
	public boolean updateAgreement(ThirdAgreementBean thirdAgreementBean);
	
	/**
	 * 
	 * <p>Title:getThirdAgreementIdByNewNo</p>
	 * <p>Description:根据合约号，查询合约id</p>
	 * @author 朱小宝
	 * @return int
	 */
	public int getThirdAgreementIdByNewNo(String thirdAggrementNewNo);
	
}
