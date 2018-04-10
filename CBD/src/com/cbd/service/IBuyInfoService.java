package com.cbd.service;

import java.util.List;

import com.cbd.bean.Pager;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.BuyInfoEntity;

/**
 * 购买车位信息逻辑层接口
 * @author 唐小雄
 *
 */
public interface IBuyInfoService{

	/**
	 * 查询所有购买车位信息(分页)
	 * @return 唐小雄
	 */
	public Pager getAllPageBuyInfo(int page,int size,String buyInfoStatus);
	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 * @return 根据id查询购买信息
	 */
	public BuyInfoEntity getByIdBuyInfo(int id);
	
	/**
	 * 根据id修改购买信息审核状态为‘交易成功’
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 */
	public void updateByIdBuyInfo(int id,String buyInfoStatus);
	
	
	/**
	 * 
	 * <p>Title:updateOtherUserbuyInfoStatus</p>
	 * <p>Description:根据出售id修改除了预约购买成功用户之外的其他预约该车位的用户的状态为“交易失败”</p>
	 * @author 龙成
	 * @date2018年2月2日下午4:31:19
	 */
	public boolean updateOtherUserbuyInfoStatus(int buyInfoSaleId, int buyInfoId, String buyInfoStatus);
	
	
	/**
	 * 
	 * <p>Title:getBuyInfoEntitysBySaleIdInfoId</p>
	 * <p>Description:多人预约购买同一车位时，查询出所有预约购买失败的购买信息集合</p>
	 * @author 龙成
	 * @date2018年2月2日下午5:06:17
	 */
	public List<BuyInfoEntity> getBuyInfoEntitysBySaleIdInfoId(int buyInfoSaleId,int buyInfoId);
	
	/**
	 * 
	 * <p>Title:getBuyInfoEntityByReserveBuyBean</p>
	 * <p>Description:根据预约购买信息查询购买信息</p>
	 * @author 杨明健
	 * @date2018年2月7日下午2:37:41
	 */
	public boolean getBuyInfoEntityByReserveBuyBean(ReserveBuyBean reserveBuyBean);
}




