package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.bean.Pager;
import com.cbd.dao.ICarportDao;
import com.cbd.entity.CartportEntity;
import com.cbd.mapper.CartportMapper;
import com.cbd.validator.Log;
/**
 * 车位管理DaoImpl
 * @author 刘芯宇
 *
 */
@Component
public class CartportDaoImpl implements ICarportDao{
  
	@Autowired
	 private CartportMapper carMapper;
	
	//车位管理单个添加
	@Override
	@Log(operationType="数据库操作",operationName="单个添加车位")
	public void addSingle(CarportBean carportBean) {
		// TODO Auto-generated method stub
		carMapper.insertSingle(carportBean);
	}
	//车位管理模糊查询
	@Override
	public Pager searchPage(CarportInfoBean carportInfoBean) {
		// TODO Auto-generated method stub
		int list2=carMapper.searchAll(carportInfoBean);
		List<CartportEntity> datas=carMapper.searchPage(carportInfoBean);
		Pager pager=new Pager(carportInfoBean.getSize(), list2, carportInfoBean.getCurPage());
		 pager.setDatas(datas);
	     return pager;
	}
	@Override
	public List<CartportEntity> findNullCarport() {
		// TODO Auto-generated method stub
	  return carMapper.findNullCarport();
	
	}
	@Log(operationType="数据库操作",operationName="批量添加车位")
	@Override
	public void addRentAgreement(List<CarportBean> carportBeans) {
		// TODO Auto-generated method stub
		carMapper.addRentAgreement(carportBeans);
	}
	
	@Log(operationType="数据库操作",operationName="车位绑定企业Id")
	@Override
	public void updateCompanyId(String cbdCarportAddress, String cbdCarportAddressNo, int CompanyId,int rentAgreement) {
		// TODO Auto-generated method stub
		carMapper.updateCompanyId(cbdCarportAddress, cbdCarportAddressNo, CompanyId,rentAgreement);
	}
	
	@Log(operationType="数据库操作",operationName="批量添加车位")
	@Override
	public void addManyCarport(List<CarportBean> carportBeans) {
		// TODO Auto-generated method stub
		carMapper.addManyCarport(carportBeans);
	}
	
	@Log(operationType="数据库操作",operationName="批量删除车位")
	@Override
	public void deleteManyCarport(int id) {
		// TODO Auto-generated method stub
		carMapper.deleteManyCarport(id);
	}
	/**
	 * 根据编号找到车位
	 */
	@Override
	public CarportBean findCarport(CarportBean carportBean) {
		// TODO Auto-generated method stub
		CarportBean carport=carMapper.findCarport(carportBean);
		return carport;
	}
	
	@Log(operationType="数据库操作",operationName="更新车位信息")
	@Override
	public void updateManyCarport(int id) {
		// TODO Auto-generated method stub
		carMapper.updateManyCarport(id);
	}
   
}
