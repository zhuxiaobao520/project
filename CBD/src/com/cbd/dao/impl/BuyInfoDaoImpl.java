package com.cbd.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.ReserveBuyBean;
import com.cbd.dao.IBuyInfoDao;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.mapper.IBuyInfoMapper;
import com.cbd.validator.Log;

/**
 * 购买车位信息Dao实现类
 * @author 唐小雄
 *
 */
@Component
public class BuyInfoDaoImpl implements IBuyInfoDao{

	@Autowired
	private IBuyInfoMapper buyInfoMapper;
	
	/**
	 * 查询所有购买车位信息(分页)
	 * @return 唐小雄
	 */
	public List<BuyInfoEntity> getAllPageBuyInfo(int page,int size,String buyInfoStatus){
		List<BuyInfoEntity> list = buyInfoMapper.getAllPageBuyInfo(page, size, buyInfoStatus);
		return list;
	}

	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param buyInfoStatus
	 * @return 根据交易状态查询总记录数
	 */
	@Override
	public int getAllNumBuyInfo(String buyInfoStatus) {
		// TODO Auto-generated method stub
		return buyInfoMapper.getAllBuyInfo(buyInfoStatus);
	}

	@Override
	public BuyInfoEntity getByIdBuyInfo(int id) {
		// TODO Auto-generated method stub
		return buyInfoMapper.getByIdBuyInfo(id);
	}
	
	/**
	 * 根据id修改购买信息审核状态为‘交易成功’
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 */
	@Log(operationType="数据库操作",operationName="根据id修改购买信息审核状态为‘交易成功’")
	@Override
	public void updateByIdBuyInfo(int id, String buyInfoStatus) {
		// TODO Auto-generated method stub
		buyInfoMapper.updateByIdBuyInfo(id, buyInfoStatus);
	}

	@Override
	public BuyInfoEntity getBuyInfoByIdAndStatus(int buyInfoId, int userId) {
		// TODO Auto-generated method stub
		BuyInfoEntity buyInfoEntity=buyInfoMapper.getBuyInfoByIdAndStatus(buyInfoId, userId);
		return buyInfoEntity;
	}

	@Override
	@Log(operationName="修改未预约成功的租赁记录状态为交易失败",operationType="数据库操作")
	public int updateOtherUserbuyInfoStatus(int buyInfoSaleId, int buyInfoId, String buyInfoStatus) {
		// TODO Auto-generated method stub
		return buyInfoMapper.updateOtherUserbuyInfoStatus(buyInfoSaleId, buyInfoId, buyInfoStatus);
	}

	@Override
	public List<BuyInfoEntity> getBuyInfoEntitysBySaleIdInfoId(int buyInfoSaleId, int buyInfoId) {
		// TODO Auto-generated method stub
		return buyInfoMapper.getBuyInfoEntitysBySaleIdInfoId(buyInfoSaleId, buyInfoId);
	}

	@Override
	public BuyInfoEntity getBuyInfoEntityByReserveBuyBean(ReserveBuyBean reserveBuyBean) {
		// TODO Auto-generated method stub
		return buyInfoMapper.getBuyInfoEntityByReserveBuyBean(reserveBuyBean);
	}
	
}
