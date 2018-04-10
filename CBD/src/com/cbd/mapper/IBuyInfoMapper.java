package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.ReserveBuyBean;
import com.cbd.entity.BuyInfoEntity;

/**
 * 购买车位信息mapper接口
 * @author 唐小雄
 *
 */
public interface IBuyInfoMapper extends SqlMapper{

	/**
	 * 查询所有购买车位信息
	 * @return 唐小雄
	 */
	@Select("select count(*) from t_buyinfo where buyInfoStatus=#{param1}")
	public int getAllBuyInfo(String buyInfoStatus);
	
	/**
	 * 查询所有购买车位信息(分页)
	 * @return 唐小雄
	 */
	@Select("select * from t_buyinfo where buyInfoStatus=#{param3} limit #{param1},#{param2}")
	@Results({  
	    @Result(id=true,property="buyInfoId",column="buyInfoId"),  
	    @Result(property="buyInfoStatus",column="buyInfoStatus"),  
	    @Result(property="buyInfoMassage",column="buyInfoMassage"),  
	    @Result(property="buyInfoSale",column="buyInfoSaleId",one=@One(select="com.cbd.mapper.ISaleMapper.getByIdPageSale")),
	    @Result(property="buyInfoUser",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))  })  
	public List<BuyInfoEntity> getAllPageBuyInfo(int page,int size,String buyInfoStatus);
	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @return	根据id查询购买信息
	 */
	@Select("select * from t_buyinfo where buyInfoId=#{id} ")
	@Results({  
	    @Result(id=true,property="buyInfoId",column="buyInfoId"),  
	    @Result(property="buyInfoStatus",column="buyInfoStatus"),  
	    @Result(property="buyInfoMassage",column="buyInfoMassage"),  
	    @Result(property="buyInfoSale",column="buyInfoSaleId",one=@One(select="com.cbd.mapper.ISaleMapper.getByIdPageSale")),
	    @Result(property="buyInfoUser",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))  }) 
	public BuyInfoEntity getByIdBuyInfo(int id);
	
	/**
	 * 根据id修改购买信息审核状态为‘交易成功’
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 */
	@Update("update t_buyinfo set buyInfoStatus = #{param2} where buyInfoId=#{param1}")
	public void updateByIdBuyInfo(int id,String buyInfoStatus);
	
	/**
	 * 
	 * <p>Title:getBuyInfoByIdAndStatus</p>
	 * <p>Description: 根据购买信息id和购买者Id以及交易状态为成功查询</p>
	 * @author 朱小宝
	 * @return BuyInfoEntity
	 */
	@Select("select * from t_buyinfo where buyInfoId=#{param1} and buyInfoUserId=#{param2} and buyInfoStatus='交易成功'")
	@Results({  
	    @Result(id=true,property="buyInfoId",column="buyInfoId"),  
	    @Result(property="buyInfoSale",column="buyInfoSaleId",one=@One(select="com.cbd.mapper.ISaleMapper.getByIdPageSale"))
	    }) 
	public BuyInfoEntity getBuyInfoByIdAndStatus(int buyInfoId,int userId);
	
	
	/**
	 * 
	 * <p>Title:updateOtherUserbuyInfoStatus</p>
	 * <p>Description:根据出售id修改除了预约购买成功用户之外的其他预约该车位的用户的状态为“交易失败”</p>
	 * @author 龙成
	 * @date2018年2月2日下午4:25:58
	 */
	@Update("update t_buyinfo set buyInfoStatus = #{param3} where buyInfoSaleId=#{param1} and buyInfoId != #{param2} ")
	public int updateOtherUserbuyInfoStatus(int buyInfoSaleId,int buyInfoId,String buyInfoStatus);
	
	/**
	 * 
	 * <p>Title:getBuyInfoEntitysBySaleIdInfoId</p>
	 * <p>Description:多人预约购买同一车位时，查询出所有预约购买失败的购买信息集合</p>
	 * @author 龙成
	 * @date2018年2月2日下午5:02:53
	 */
	@Select("select * from t_buyinfo where buyInfoSaleId=#{param1} and buyInfoId != #{param2}")
	@Results({  
	    @Result(id=true,property="buyInfoId",column="buyInfoId"),  
	    @Result(property="buyInfoStatus",column="buyInfoStatus"),  
	    @Result(property="buyInfoMassage",column="buyInfoMassage"),  
	    @Result(property="buyInfoSale",column="buyInfoSaleId",one=@One(select="com.cbd.mapper.ISaleMapper.getByIdPageSale")),
	    @Result(property="buyInfoUser",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))  
	    })
	public List<BuyInfoEntity> getBuyInfoEntitysBySaleIdInfoId(int buyInfoSaleId,int buyInfoId);
	
	/**
	 * 
	 * <p>Title:getBuyInfoEntityByReserveBuyBean</p>
	 * <p>Description:根据预约购买信息查询购买信息</p>
	 * @author 杨明健
	 * @date2018年2月7日下午2:34:21
	 */
	@Select("select * from t_buyinfo where buyInfoSaleId = #{buyInfoSaleId} and buyInfoUserId = #{buyInfoUserId}")
	@Results({  
	    @Result(id=true,property="buyInfoId",column="buyInfoId"),  
	    @Result(property="buyInfoStatus",column="buyInfoStatus"),  
	    @Result(property="buyInfoMassage",column="buyInfoMassage"),  
	    @Result(property="buyInfoSale",column="buyInfoSaleId",one=@One(select="com.cbd.mapper.ISaleMapper.getByIdPageSale")),
	    @Result(property="buyInfoUser",column="buyInfoUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser"))  
	    })
	public BuyInfoEntity getBuyInfoEntityByReserveBuyBean(ReserveBuyBean reserveBuyBean);
}





