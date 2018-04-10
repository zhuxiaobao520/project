package com.cbd.dao;

import org.apache.ibatis.annotations.Delete;

import com.cbd.bean.Pager;
import com.cbd.bean.RenterAgreementBean;
import com.cbd.entity.RenterAgreementEntity;
/**
 * 租户合约Dao层
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
public interface IRentAgreementDao {
	/**
	 * 租户合约分页
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param curPage
	 * @return
	 */
	public Pager findRentAgreement(int curPage);
	/**
	 * 获取续约的合同信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param id
	 * @return
	 */
	public RenterAgreementEntity findAgreementById(int id);
	/**
	 * 添加新合约信息
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
	
	/**
	 * 
	 * <p>Title:deleteManyAgreement</p>
	 * <p>Description: 根据企业删除合约</p>
	 * @author 朱小宝
	 * @return void
	 */
	public void deleteManyAgreement(int id);
}
