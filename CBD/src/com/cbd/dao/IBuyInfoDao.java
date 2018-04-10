package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.BuyInfoEntity;

/**
 * 购买车位信息Dao接口
 * @author 唐小雄
 *
 */
public interface IBuyInfoDao{

	/**
	 * 查询所有购买车位信息
	 * @return 唐小雄
	 */
	public int getAllNumBuyInfo(String buyInfoStatus);
	
	/**
	 * 查询所有购买车位信息(分页)
	 * @return 唐小雄
	 */
	public List<BuyInfoEntity> getAllPageBuyInfo(int page,int size,String buyInfoStatus);
	
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
	 * <p>Title:getBuyInfoByIdAndStatus</p>
	 * <p>Description: 根据购买信息id和购买者Id以及交易状态为成功查询</p>
	 * @author 朱小宝
	 * @return BuyInfoEntity
	 */
	public BuyInfoEntity getBuyInfoByIdAndStatus(int buyInfoId,int userId); 
	
	
	/**
	 * 
	 * <p>Title:updateOtherUserbuyInfoStatus</p>
	 * <p>Description:根据出售id修改除了预约购买成功用户之外的其他预约该车位的用户的状态为“交易失败”</p>
	 * @author 龙成
	 * @date2018年2月2日下午4:30:05
	 */
	public int updateOtherUserbuyInfoStatus(int buyInfoSaleId,int buyInfoId,String buyInfoStatus);
	
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
	 * @date2018年2月7日下午2:35:45
	 */
	public BuyInfoEntity getBuyInfoEntityByReserveBuyBean(ReserveBuyBean reserveBuyBean);
}





