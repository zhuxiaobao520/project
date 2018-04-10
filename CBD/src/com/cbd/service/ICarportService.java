package com.cbd.service;

import java.util.List;

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.bean.Pager;
/**
 * 车位管理service层
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
import com.cbd.entity.CartportEntity;
public interface ICarportService {

/*	public Pager handleInfo(int curPage,int size);*/
	/**
	 * 车位管理单个添加车位
	 */
	public boolean addSingle(CarportBean carportBean);
	/**
	 * 车位管理模糊查询
	 * @author 刘芯宇
	 * @Date 2018年2月6日
	 * @param carportInfoBean
	 * @return
	 */
	
	public Pager searchInfo(CarportInfoBean carportInfoBean);
	/**
	 * 	获取所有的空闲车位
	 */
	public List<CartportEntity> findNullCarport();	
/*	public List<CartportEntity> findNullCarportByParam(String cbdCarportAddress,String cbdCarportAddressNo);*/
   /**
    * 车位绑定企业Id
    * @author 刘芯宇
    * @Date 2018年2月6日
    * @param cbdCarportAddress
    * @param cbdCarportAddressNo
    * @param CompanyId
    */
	public void  updateCompanyId(String cbdCarportAddress,String cbdCarportAddressNo,int CompanyId,int rentAgreementId);
	
	/**
	 * 批量添加租户车位
	 * @author 刘芯宇
	 * @Date 2018年2月7日
	 * @param carportBean
	 */
	public void addRentCarport(CarportBean carportBean);
	/**
	 * 
	 * <p>Title:addManyCarport</p>
	 * <p>Description: 批量添加第三方合约签订的车位</p>
	 * @author 朱小宝
	 * @return Boolean
	 */
	public Boolean addManyCarport(CarportBean carportBean);
	
	 /**
	   * 
	   * <p>Title:deleteManyCarport</p>
	   * <p>Description:批量删除已解约的车位 </p>
	   * @author 朱小宝
	   * @return void
	   */
	 public void deleteManyCarport(int id);
}
