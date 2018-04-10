package com.cbd.service;

import java.util.List;

import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.AgreementTaskBean;
import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.Pager;
import com.cbd.entity.AgreementEntity;

/**
 * 购买合同信息逻辑层层接口
 * 
 * @author 唐小雄
 * @date 2018年1月31日
 */
public interface IAgreementService {

	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 * @return 根据id查询合同信息
	 */
	public AgreementEntity getByIdAgreement(int id);

	/**
	 * 
	 * <p>
	 * Title:getBuyAgreementTaskPage
	 * </p>
	 * <p>
	 * Description:根据购买用户id按页查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:44:17
	 */
	public Pager getBuyAgreementTaskPage(int curPage, int userId);

	/**
	 * 
	 * <p>
	 * Title:getSaleAgreementTaskPage
	 * </p>
	 * <p>
	 * Description:根据出售用户id按页查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:45:10
	 */
	public Pager getSaleAgreementTaskPage(int curPage, int userId);

	/**
	 * 
	 * <p>
	 * Title:getBuyAgreementTask
	 * </p>
	 * <p>
	 * Description:根据合同id和买家用户id查询合同详情
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午4:12:14
	 */
	public AgreementTaskBean getBuyAgreementTask(int agreementId, int userId);

	/**
	 * <p>
	 * Title:getSaleAgreementTask
	 * </p>
	 * <p>
	 * Description:根据合同id和卖家用户id查询合同详情
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午4:12:27
	 */
	public AgreementTaskBean getSaleAgreementTask(int agreementId, int userId);

	/**
	 * 查询得到需要后台管理员发合同的出售信息pager
	 * 
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public Pager getAllApplyForAgreementBuyInfoPager(int currentPage, int pageSize);

	/**
	 * 根据出售记录的id得到管理员要派发合同的出售记录详情
	 * 
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyInfoId
	 * @return
	 */
	public BuyDetailBean getApplyForAgreementBuyDetailBean(int buyInfoId);

	/**
	 * 管理员新增用户购买合同 返回是否添加成功
	 * 
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementInsertBean
	 * @return
	 */
	public boolean addAgreement(AgreementInsertBean agreementInsertBean);
	/**
	 * 分页显示买家需要签订的合同详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Pager getBuyerAgreementPager(int buyUserId,int currentPage,int pageSize);
	/**
	 * 分页显示卖家的签订合同详情pager
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Pager getSalerAgreementPager(int salerUserId,int currentPage,int pageSize);
	
	/**
	 * 根据合同id 获得合同的信息
	 * 合同编号，合同生效时间
	 * 包括买家和买家的id用户名
	 * 出售发布时间出售价格 出售信息的id 
	 * 购买信息的id,购买记录的状态
	 * 车位地址 车位编号 车位id
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同id 
	 * @return
	 */
	public AgreementInfoBean getAgreementInfoBeanByAgreementId(int agreementId);
	
	/**
	 * 购买方签订合同
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同id
	 * @return
	 */
	public boolean updateBuyerSignedAgreement(int agreementId);
	
	/**
	 * 出售方签订合同
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同id
	 * @return
	 */
	public boolean updateSalerSignedAgreement(int agreementId);


	/**
	 * 
	 * <p>Title:updateBuyAgreementTask</p>
	 * <p>Description:买方签订</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:09:53
	 */
	public boolean updateBuyAgreementTask(int agreementId);
	
	/**
	 * 
	 * <p>Title:updateSaleAgreementTask</p>
	 * <p>Description:卖方签订</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:10:25
	 */
	public boolean updateSaleAgreementTask(int agreementId);
}
