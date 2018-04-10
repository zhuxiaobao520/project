package com.cbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.bean.Pager;
import com.cbd.dao.ICarportDao;
import com.cbd.entity.CartportEntity;
import com.cbd.service.ICarportService;
import com.sun.org.apache.bcel.internal.generic.NEW;
/**
 * 车辆管理service层
 * @author 刘芯宇
 *
 */
@Component
public class CarportServiceImpl implements ICarportService {

	@Autowired
	private ICarportDao CarportDao;
	
	/**
	 * 车辆管理单个添加车辆
	 */
	@Override
	public boolean addSingle(CarportBean carportBean) {
		// TODO Auto-generated method stub
		CarportBean carport=CarportDao.findCarport(carportBean);
		if(carport==null){
			CarportDao.addSingle(carportBean);
			return false;
		}else {
			return true;
		}		
	}
	
	
	/**
	 * 模糊查询
	 */
	@Override
	public Pager searchInfo(CarportInfoBean carportInfoBean) {
		// TODO Auto-generated method stub
		Pager pager=CarportDao.searchPage(carportInfoBean);
		return pager;
	}
     /**
      * 获取所有空闲车位
      */
	@Override
	public List<CartportEntity> findNullCarport() {
		// TODO Auto-generated method stub
		return CarportDao.findNullCarport();
	}
	
    /**
     * 批量添加租户车位
     */
	@Override
	public void addRentCarport(CarportBean carportBean) {
		// TODO Auto-generated method stub
		List<CarportBean>list=new ArrayList<>();
		for(int i=0;i<carportBean.getCbdCarporSum();i++){
			CarportBean cBean=new CarportBean();
			cBean.setCbdCarportAddress(carportBean.getCbdCarportAddress());
			cBean.setCbdCarportThirdAggremenId(carportBean.getCbdCarportRenterAgreementId());
			cBean.setCbdCarportAddressNo(carportBean.getCbdCarportAddressNo()+(Integer.parseInt(carportBean.getCbdCarporStartNo())+i));
			 list.add(cBean) ;
		  }
		CarportDao.addRentAgreement(list);
             
	}
  /**
   * 根据条件更改绑定企业信息
   */
	@Override
	public void updateCompanyId(String cbdCarportAddress, String cbdCarportAddressNo, int CompanyId,int rentAgreement) {
		// TODO Auto-generated method stub
		CarportDao.updateCompanyId(cbdCarportAddress, cbdCarportAddressNo, CompanyId,rentAgreement);
	}
    /**
     * 批量添加第三方车位
     */
	@Override
	public Boolean addManyCarport(CarportBean carportBean) {
		// TODO Auto-generated method stub
		List<CarportBean>list=new ArrayList<>();
		for(int i=Integer.parseInt(carportBean.getCbdCarporStartNo());i<carportBean.getCbdCarporSum();++i){
			CarportBean cBean=new CarportBean();
			cBean.setCbdCarportAddress(carportBean.getCbdCarportAddress());
			cBean.setCbdCarportThirdAggremenId(carportBean.getCbdCarportThirdAggremenId());
			cBean.setCbdCarportAddressNo(carportBean.getCbdCarportAddressNo()+i);
			list.add(cBean);
		}
		CarportDao.addManyCarport(list);
		return null;
	}

	@Override
	public void deleteManyCarport(int id) {
		// TODO Auto-generated method stub
		CarportDao.deleteManyCarport(id);
	}

  
	/*@Override
	public List<CartportEntity> findNullCarportByParam(String cbdCarportAddress, String cbdCarportAddressNo) {
		// TODO Auto-generated method stub
		return CarportDao.findNullCarportByParam(cbdCarportAddress, cbdCarportAddressNo);
	}*/

}
