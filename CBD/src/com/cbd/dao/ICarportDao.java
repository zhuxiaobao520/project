package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.bean.Pager;
/**
 * 车位管理Dao层
 * @author 刘芯宇
 *
 */
import com.cbd.entity.CartportEntity;
public interface ICarportDao {

/*	public Pager findCarportPage(int curPage,int size);*/
	
	public CarportBean findCarport(CarportBean carportBean);
	/**
	 * 添加单个车位
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param carportBean
	 */
	public void addSingle(CarportBean carportBean);
	/**
	 * 模糊查询加分页
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param carportInfoBean
	 * @return
	 */
	public Pager searchPage(CarportInfoBean carportInfoBean);
	
	/**
	 * 批量添加租户车位
	 * @author 刘芯宇
	 * @Date 2018年2月7日
	 * @param carportBeans
	 */
	public void addRentAgreement(List<CarportBean> carportBeans);
	/**
	 * 获取所有的空闲车位
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @return
	 */
	public List<CartportEntity> findNullCarport();
	
	/*public List<CartportEntity> findNullCarportByParam(String cbdCarportAddress,String cbdCarportAddressNo);*/
   /**
    * 车位绑定企业Id
    * @author 刘芯宇
    * @Date 2018年2月5日
    * @param cbdCarportAddress
    * @param cbdCarportAddressNo
    * @param CompanyId
    */
	 public void  updateCompanyId(String cbdCarportAddress,String cbdCarportAddressNo,int CompanyId,int rentAgrementId);

	 /**
	  * 
	  * <p>Title:addManyCarport</p>
	  * <p>Description: 批量添加车位</p>
	  * @author 朱小宝
	  * @return void
	  */
	 public void addManyCarport(List<CarportBean> carportBeans);
	 
	 /**
	   * 
	   * <p>Title:deleteManyCarport</p>
	   * <p>Description:批量删除已解约的车位 </p>
	   * @author 朱小宝
	   * @return void
	   */
	 public void deleteManyCarport(int id);
	 
	 /**
	  * 
	  * <p>Title:updateManyCarport</p>
	  * <p>Description: 删除企业，更新车位状态以及Id</p>
	  * @author 朱小宝
	  * @return void
	  */
	 public void updateManyCarport(int id);
}
