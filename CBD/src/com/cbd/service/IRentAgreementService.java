package com.cbd.service;

import com.cbd.bean.Pager;
import com.cbd.bean.RenterAgreementBean;
import com.cbd.entity.RenterAgreementEntity;
/**
 * 租户合约service层接口
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
public interface IRentAgreementService {
	/**
	 * 获取分页信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param curPage
	 * @return
	 */
	public Pager getAgreementPage(int curPage);
	/**
	 * 获取续约的合同信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param id
	 * @return
	 */
     public RenterAgreementEntity findAgreementById(int id);
     /**
      * 续约信息添加到数据库
      * @author 刘芯宇
      * @Date 2018年2月5日
      * @param rentEntity
      */
     public int updateOldAgreement(RenterAgreementEntity rentEntity);
     /**
      * 更新续约合同信息
      * @author 刘芯宇
      * @Date 2018年2月5日
      * @param id
      */
     public void  updateAgreemrntById(int id);
}
