package com.cbd.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.dao.IBuyInfoDao;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.mapper.IBuyInfoMapper;
import com.cbd.service.IBuyInfoService;

/**
 * 购买车位信息Service实现类
 * @author 唐小雄
 *
 */
@Component
public class BuyInfoServiceImpl implements IBuyInfoService{

	@Autowired
	private IBuyInfoDao buyInfoDao;

	/**
	 * 查询所有购买车位信息(分页)
	 * @return 唐小雄
	 */
	@Override
	public Pager getAllPageBuyInfo(int page, int size, String buyInfoStatus) {
		// TODO Auto-generated method stub
		int totalSize = buyInfoDao.getAllNumBuyInfo(buyInfoStatus);
		Pager pager = new Pager(size, totalSize, page);
		List<BuyInfoEntity> list = buyInfoDao.getAllPageBuyInfo(pager.getStartIndex(), size,buyInfoStatus);
		pager.setDatas(list);
		return pager;
	}
	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 * @return 
	 * 根据id查询购买信息
	 */
	@Override
	public BuyInfoEntity getByIdBuyInfo(int id) {
		// TODO Auto-generated method stub
		return buyInfoDao.getByIdBuyInfo(id);
	}
	
	/**
	 * 根据id修改购买信息审核状态为‘交易成功’
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 */
	@Override
	public void updateByIdBuyInfo(int id, String buyInfoStatus) {
		// TODO Auto-generated method stub
		buyInfoDao.updateByIdBuyInfo(id, buyInfoStatus);
	}

	@Override
	public boolean updateOtherUserbuyInfoStatus(int buyInfoSaleId, int buyInfoId, String buyInfoStatus) {
		int num = buyInfoDao.updateOtherUserbuyInfoStatus(buyInfoSaleId, buyInfoId, buyInfoStatus);
		if(num == 0){
			return false;
		}
		
		return true;
	}

	@Override
	public List<BuyInfoEntity> getBuyInfoEntitysBySaleIdInfoId(int buyInfoSaleId, int buyInfoId) {
		// TODO Auto-generated method stub
		return buyInfoDao.getBuyInfoEntitysBySaleIdInfoId(buyInfoSaleId, buyInfoId);
	}

	@Override
	public boolean getBuyInfoEntityByReserveBuyBean(ReserveBuyBean reserveBuyBean) {
		// TODO Auto-generated method stub
		BuyInfoEntity buyInfoEntity = buyInfoDao.getBuyInfoEntityByReserveBuyBean(reserveBuyBean);
		if(buyInfoEntity!=null){
			return true;
		}
		return false;
	}

}
