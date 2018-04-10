package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.AgreementTaskBean;
import com.cbd.entity.AgreementEntity;

/**
 * 购买合同信息Dao层接口
 * @author 唐小雄
 * @date 2018年1月31日
 */
public interface IAgreementDao {

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
	 * <p>Title:getAllBuyAgreementTask</p>
	 * <p>Description:根据购买用户id查询合同记录</p>
	 * @author 杨明健
	 * @date2018年2月2日下午1:35:12
	 */
	public List<AgreementTaskBean> getAllBuyAgreementTask(int userId);
	
	/**
	 * 
	 * <p>Title:getBuyAgreementTaskPage</p>
	 * <p>Description:根据购买用户id按页查询合同记录</p>
	 * @author 杨明健
	 * @date2018年2月2日下午1:35:54
	 */
	public List<AgreementTaskBean> getBuyAgreementTaskPage(int starPage,int pageSize,int userId);
	
	/**
	 * 
	 * <p>Title:getAllSaleAgreementTask</p>
	 * <p>Description:根据出售用户id查询合同记录</p>
	 * @author 杨明健
	 * @date2018年2月2日下午1:36:26
	 */
	public List<AgreementTaskBean> getAllSaleAgreementTask(int userId);
	
	/**
	 * 
	 * <p>Title:getSaleAgreementTaskPage</p>
	 * <p>Description:根据出售用户id按页查询合同记录</p>
	 * @author 杨明健
	 * @date2018年2月2日下午1:37:38
	 */
	public List<AgreementTaskBean> getSaleAgreementTaskPage(int starPage,int pageSize,int userId);
	
	/**
	 * 
	 * <p>Title:getBuyAgreementTask</p>
	 * <p>Description:根据合同id和买家用户id查询合同详情</p>
	 * @author 杨明健
	 * @date2018年2月2日下午4:09:28
	 */
	public AgreementTaskBean getBuyAgreementTask(int agreementId,int userId);
	
	/**
	 * 
	 * <p>Title:getSaleAgreementTask</p>
	 * <p>Description:根据合同id和卖家用户id查询合同详情</p>
	 * @author 杨明健
	 * @date2018年2月2日下午4:09:57
	 */
	public AgreementTaskBean getSaleAgreementTask(int agreementId,int userId);


	/**
	 * 
	 * <p>Title:updateBuyAgreementTask</p>
	 * <p>Description:买方签订</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:03:55
	 */
	public int updateBuyAgreementTask(int agreementId);
	
	/**
	 * 
	 * <p>Title:updateSaleAgreementTask</p>
	 * <p>Description:卖方签订</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:04:23
	 */
	public int updateSaleAgreementTask(int agreementId);

	
	/**
	 * 查询得到需要后台管理员发合同的出售信息
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<BuyDetailBean>  getAllApplyForAgreementBuyInfoList(int startIndex, int pageSize);
	
	/**
	 * 查询得到需要后台管理员发合同的出售信息数量
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @return
	 */
	public int getAllApplyForAgreementBuyInfoNum();
	
	/**
	 * 根据出售记录的id得到管理员要派发合同的出售记录详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyInfoId
	 * @return
	 */
	public BuyDetailBean getApplyForAgreementBuyDetailBean(int buyInfoId);
	
	/**
	 * 管理员新增用户购买合同
	 * 返回受影响行
	 * 新增过程须同时改变车位状态，和购买表的状态为待签约
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementInsertBean
	 * @return
	 */
	public int addAgreement(AgreementInsertBean agreementInsertBean);
	/**
	 * 根据买家Id查询买家需要签订的合同的详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId 买家的id
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<AgreementInfoBean> getBuyerAgreementInfoBeansByPage(int buyUserId, int startIndex,int pageSize);
	/**
	 * 根据买家id查询买家需要签订合同的总数
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId	买家的id 
	 * @return
	 */
	public int getBuyerAgreementInfoBeansNum(int buyUserId);
	
	/** 
	 * 根据合同id 查询待签约的合同详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId
	 * @return
	 */
	public AgreementInfoBean getAgreementInfoBeanByAgreementId(int agreementId);
	/**
	 * 获得卖家需要签约的合同详情集合
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<AgreementInfoBean> getSalerAgreementInfoBeansByPage(int salerUserId, int startIndex,int pageSize);
	
	/**
	 * 根据买家id查询买家需要签订合同的总数
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId	买家的id 
	 * @return
	 */
	public int getSalerAgreementInfoBeansNum(int salerUserId);
	/**
	 * 购买方签订合同
	 * 需要查询卖家是否签订了合同
	 * 如果签了需要改变车位状态和购买信息的状态
	 * 事务操作
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同id
	 * @return
	 */
	public int updateBuyerSignedAgreement(int agreementId);
	
	/**
	 * 卖家签订合同
	 * 需要查询买家是否签订了合同
	 * 如果签了需要改变车位状态和购买信息的状态
	 * 事务操作
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同id
	 * @return
	 */
	public int updateSalerSignedAgreement(int agreementId);
}
