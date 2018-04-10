package com.cbd.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.AgreementSingleBean;
import com.cbd.bean.AgreementTaskBean;
import com.cbd.entity.AgreementEntity;

/**
 * 购买合同信息mapper接口
 * 
 * @author 唐小雄
 * @date 2018年1月31日
 */
public interface IAgreementMapper extends SqlMapper {

	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 * @return 根据id查询合同信息
	 */
	@Select("select * from t_agreement where agreementBuyInfoId=#{id} ")
	@Results({ @Result(id = true, property = "agreementId", column = "agreementId"),
			@Result(property = "agreementNo", column = "agreementNo"),
			@Result(property = "agreementBuyerSigned", column = "agreementBuyerSigned"),
			@Result(property = "agreementSalerSigned", column = "agreementSalerSigned"),
			@Result(property = "agreementTime", column = "agreementTime"),
			@Result(property = "agreementBuyInfo", column = "agreementBuyInfoId", one = @One(select = "com.cbd.mapper.IBuyInfoMapper.getByIdBuyInfo")),
			@Result(property = "agreementCarport", column = "agreementCarportId", one = @One(select = "com.cbd.mapper.UsercarportMapper.getByIdUsercarport")) })
	public AgreementEntity getByIdAgreement(int id);

	/**
	 * 
	 * <p>
	 * Title:getAllBuyAgreementTask
	 * </p>
	 * <p>
	 * Description:根据购买用户id查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:28:51
	 */
	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where c.userId=#{param1} and a.agreementBuyerSigned = 0")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public List<AgreementTaskBean> getAllBuyAgreementTask(int userId);

	/**
	 * 
	 * <p>
	 * Title:getAgreementTaskPage
	 * </p>
	 * <p>
	 * Description:根据购买用户id按页查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:26:18
	 */
	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where c.userId=#{param3} and a.agreementBuyerSigned = 0 limit #{param1},#{param2}")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public List<AgreementTaskBean> getBuyAgreementTaskPage(int starPage, int pageSize, int userId);

	/**
	 * 
	 * <p>
	 * Title:getAllSaleAgreementTask
	 * </p>
	 * <p>
	 * Description:根据出售用户id查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:30:27
	 */
	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where e.userId=#{param1} and a.agreementSalerSigned = 0")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public List<AgreementTaskBean> getAllSaleAgreementTask(int userId);

	/**
	 * 
	 * <p>
	 * Title:getSaleAgreementTaskPage
	 * </p>
	 * <p>
	 * Description:根据出售用户id按页查询合同记录
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年2月2日下午1:31:41
	 */
	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where e.userId=#{param3} and a.agreementSalerSigned = 0 limit #{param1},#{param2}")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public List<AgreementTaskBean> getSaleAgreementTaskPage(int starPage, int pageSize, int userId);

	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where c.userId=#{param2} and a.agreementId=#{param1}")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public AgreementTaskBean getBuyAgreementTask(int agreementId, int userId);

	@Select("select a.agreementId,a.agreementNo,d.userCarportAddress,d.userCarportAddressNo,"
			+ " d.userCarportPropertityRight,d.userCarportImageUrl,e.userId as saleId," + " e.userName as saleUserName,"
			+ " e.userRealName as saleUserRealName,e.userIdCard as saleUserIdCard,"
			+ " e.userPhone as saleUserPhone,c.userId as buyId,c.userName as buyUserName,"
			+ " c.userRealName as buyUserRealName,"
			+ " c.userIdCard as buyUserIdCard,c.userPhone as buyUserPhone,f.salePrice"
			+ " from t_agreement a join t_buyInfo b join t_sale f "
			+ " join t_user c join t_userCarport d join t_user e "
			+ " on (a.agreementBuyInfoId=b.buyInfoId and b.buyInfoUserId=c.userId and " + " b.buyInfoSaleId=f.saleId"
			+ " and a.agreementCarportId=d.userCarportId and d.userCarportUserId=e.userId) "
			+ " where e.userId=#{param2} and a.agreementId=#{param1}")
	@Results({ @Result(property = "agreementId", column = "a.agreementId"),
			@Result(property = "agreementNo", column = "a.agreementNo"),
			@Result(property = "userCarportAddress", column = "d.userCarportAddress"),
			@Result(property = "userCarportAddressNo", column = "d.userCarportAddressNo"),
			@Result(property = "userCarportPropertityRight", column = "d.userCarportPropertityRight"),
			@Result(property = "userCarportImageUrl", column = "d.userCarportImageUrl"),
			@Result(property = "saleId", column = "saleId"),
			@Result(property = "saleUserName", column = "saleUserName"),
			@Result(property = "saleUserRealName", column = "saleUserRealName"),
			@Result(property = "saleUserIdCard", column = "saleUserIdCard"),
			@Result(property = "saleUserPhone", column = "saleUserPhone"),
			@Result(property = "buyId", column = "buyId"), @Result(property = "buyUserName", column = "buyUserName"),
			@Result(property = "buyUserRealName", column = "buyUserRealName"),
			@Result(property = "buyUserIdCard", column = "buyUserIdCard"),
			@Result(property = "buyUserPhone", column = "buyUserPhone"),
			@Result(property = "salePrice", column = "f.salePrice"), })
	public AgreementTaskBean getSaleAgreementTask(int agreementId, int userId);

	/**
	 * 分页查询得到需要后台管理员发合同的出售信息
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Select("<script>" + "SELECT buy.buyInfoId, buy.buyInfoStatus, "
			+ "sale.saleId,sale.salePrice,sale.salePublishTime, "
			+ " carport.userCarportId,carport.userCarportAddress, "
			+ " carport.userCarportAddressNo, saleuser.userId AS saleUserId, "
			+ " saleuser.userName AS saleUserName, buyer.userId AS buyUserId, "
			+ " buyer.userName AS buyUserName FROM t_buyinfo as buy JOIN  t_sale AS sale "
			+ " ON buy.buyInfoSaleId=sale.saleId  JOIN t_usercarport AS carport "
			+ " ON sale.saleCarportId=carport.userCarportId JOIN "
			+ " t_user as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer  ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='申请签约' and buy.buyInfoStatus='申请签约'"
			+ " <if test=\"param1 >=0 and param2>=0\"> limit #{param1},#{param2} "
			+ " </if></script>")
	public List<BuyDetailBean> getAllApplyForAgreementBuyInfoList(int startIndex, int pageSize);
	
	/**
	 * 查询得到需要后台管理员发合同的出售信息数量
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @return
	 */
	@Select( "SELECT count(buy.buyInfoId) FROM t_buyinfo as buy JOIN  t_sale AS sale "
			+ " ON buy.buyInfoSaleId=sale.saleId  JOIN t_usercarport AS carport "
			+ " ON sale.saleCarportId=carport.userCarportId JOIN "
			+ " t_user as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer  ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='申请签约' and buy.buyInfoStatus='申请签约'")
	public int getAllApplyForAgreementBuyInfoNum();
	
	/**
	 * 根据出售记录的id得到管理员要派发合同的出售记录详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyInfoId
	 * @return
	 */
	@Select("SELECT buy.buyInfoId, buy.buyInfoStatus, "
			+ "sale.saleId,sale.salePrice,sale.salePublishTime, "
			+ " carport.userCarportId,carport.userCarportAddress, "
			+ " carport.userCarportAddressNo, saleuser.userId AS saleUserId, "
			+ " saleuser.userName AS saleUserName, buyer.userId AS buyUserId, "
			+ " buyer.userName AS buyUserName FROM t_buyinfo as buy JOIN  t_sale AS sale "
			+ " ON buy.buyInfoSaleId=sale.saleId  JOIN t_usercarport AS carport "
			+ " ON sale.saleCarportId=carport.userCarportId JOIN "
			+ " t_user as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer  ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='申请签约' "
			+ " and buy.buyInfoStatus='申请签约' AND buy.buyInfoId=#{buyInfoId} ")
	public BuyDetailBean getApplyForAgreementBuyDetailBean(int buyInfoId);
	
	/**
	 * 管理员新增用户购买合同
	 * 返回受影响行
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementInsertBean
	 * @return
	 */
	@Insert("INSERT INTO t_agreement VALUES (NULL,#{agreementNo},#{agreementCarportId},#{agreementBuyInfoId},0,0,#{agreementTime})")
	@Options(useGeneratedKeys=true,keyProperty="agreementId")
	public int addAgreement(AgreementInsertBean agreementInsertBean);
	//根据买家id查询买家待签约的合同详情集合
	/**
	 * 根据买家id查询买家/卖家需要签约的合同详情集合
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId 买家id
	 * @param param buyer.userId 或者saleuser.userId 用于拼接查询条件用
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Select("<script>"
			+"SELECT  agreement.agreementId,agreement.agreementNo,"
			+ " agreement.agreementTime,buy.buyInfoId, "
			+ " buy.buyInfoStatus,sale.saleId,sale.salePrice, "
			+ " sale.salePublishTime,carport.userCarportId, "
			+ "carport.userCarportAddress,carport.userCarportAddressNo, "
			+ " saleuser.userId AS saleUserId,saleuser.userName AS saleUserName, "
			+ " buyer.userId AS buyUserId ,buyer.userName AS buyUserName "
			+ " FROM t_agreement AS agreement JOIN t_buyinfo as "
			+ " buy ON agreement.agreementBuyInfoId=buy.buyInfoId "
			+ " JOIN  t_sale AS sale ON buy.buyInfoSaleId=sale.saleId "
			+ " JOIN t_usercarport AS carport ON sale.saleCarportId=carport.userCarportId "
			+ " JOIN t_user as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='待签约'  and buy.buyInfoStatus='待签约' "
			+ " AND ${param1}=#{param2}"
			+ " <if test=\"param3 >=0 and param4>=0\"> limit #{param3},#{param4} "
			+ " </if></script>")
	public List<AgreementInfoBean> getAgreementInfoBeansByPage(String buyerOrSaler,int buyUserId, int startIndex,int pageSize);
	
	/**
	 * 根据买家id查询买家/卖家需要签订合同的总数
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param buyUserId	买家的id 
	 * @param param buyer.userId 或者saleuser.userId 用于拼接查询条件用
	 * @return
	 */
	@Select("SELECT count(*) FROM t_agreement AS agreement JOIN t_buyinfo as "
			+ " buy ON agreement.agreementBuyInfoId=buy.buyInfoId  JOIN  t_sale "
			+ " AS sale ON buy.buyInfoSaleId=sale.saleId  JOIN t_usercarport AS "
			+ " carport ON sale.saleCarportId=carport.userCarportId JOIN t_user "
			+ " as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='待签约'  and buy.buyInfoStatus='待签约' AND "
			+ " ${param1}=#{param2}")
	public int getAgreementInfoBeansNum(String buyerOrSaler,int buyUserId);
	/** 
	 * 根据合同id 查询待签约的合同详情
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId
	 * @return
	 */
	@Select("SELECT agreement.agreementId,agreement.agreementNo,"
			+ " agreement.agreementTime,buy.buyInfoId, "
			+ " buy.buyInfoStatus,sale.saleId,sale.salePrice, "
			+ " sale.salePublishTime,carport.userCarportId, "
			+ "carport.userCarportAddress,carport.userCarportAddressNo, "
			+ " saleuser.userId AS saleUserId,saleuser.userName AS saleUserName, "
			+ " buyer.userId AS buyUserId ,buyer.userName AS buyUserName "
			+ " FROM t_agreement AS agreement JOIN t_buyinfo as "
			+ " buy ON agreement.agreementBuyInfoId=buy.buyInfoId "
			+ " JOIN  t_sale AS sale ON buy.buyInfoSaleId=sale.saleId "
			+ " JOIN t_usercarport AS carport ON sale.saleCarportId=carport.userCarportId "
			+ " JOIN t_user as saleuser on saleuser.userId=carport.userCarportUserId "
			+ " JOIN t_user AS buyer ON buy.buyInfoUserId=buyer.userId "
			+ " WHERE carport.userCarportStatus='待签约'  and buy.buyInfoStatus='待签约' "
			+ " AND agreement.agreementId=#{agreementId}")
	public AgreementInfoBean getAgreementInfoBeanByAgreementId(int agreementId);
	/**
	 * 修改用户的签约状态
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param usertype agreementBuyerSigned:买家签约时或者agreementSalerSigned：卖家签约时
	 * @param isSigned 是否签约，0，否，1是
	 * @param agreementId 合同id
	 * @return
	 */
	@Update("update t_agreement set ${param1}=#{param2} where agreementId=#{param3}")
	public int updateUserSignedAgreement(String usertype,int isSigned,int agreementId);
	/**
	 * 
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param usertype
	 * @param agreementId
	 * @return
	 */
	/**
	 * 查询合同的简单信息，包括购买信息的主键
	 * 出售车位的主键，
	 * 双方签约的状态
	 * @author 姚刚
	 * @date 2018年2月4日
	 * @param agreementId 合同的主键
	 * @return
	 */
	@Select("SELECT agreement.agreementId,agreement.agreementCarportId, "
			+ " agreement.agreementBuyInfoId,agreement.agreementBuyerSigned,"
			+ " agreement.agreementSalerSigned FROM t_agreement AS agreement "
			+ " WHERE agreement.agreementId=#{agreementId}; ")
	@Results(value={
			@Result(property="agreementId",column="agreementId",id=true),
			@Result(property="agreementCarportId",column="agreementCarportId"),
			@Result(property="agreementBuyInfoId",column="agreementBuyInfoId"),
			@Result(property="agreementBuyerSigned",column="agreementBuyerSigned"),
			@Result(property="agreementSalerSigned",column="agreementSalerSigned")
	})
	public AgreementSingleBean getAgreementSingleBeanByAgreementId(int agreementId);

	/**
	 * 
	 * <p>Title:updateBuyAgreementTask</p>
	 * <p>Description:买方签订</p>
	 * @author 杨明健
	 * @date2018年2月4日下午11:55:24
	 */
	@Update("update t_agreement set agreementBuyerSigned = 1 where agreementId=#{agreementId}")
	public int updateBuyAgreementTask(int agreementId);
	
	/**
	 * 
	 * <p>Title:updateSaleAgreementTask</p>
	 * <p>Description:卖方签订</p>
	 * @author 杨明健
	 * @date2018年2月4日下午11:56:34
	 */
	@Update("update t_agreement set agreementSalerSigned = 1 where agreementId=#{agreementId}")
	public int updateSaleAgreementTask(int agreementId);
	
	/**
	 * 
	 * <p>Title:getAgreementByAgreementId</p>
	 * <p>Description:根据合同id查询</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:01:56
	 */
	@Select("select * from t_agreement where agreementId=#{agreementId} ")
	@Results({  
	    @Result(id=true,property="agreementId",column="agreementId"),  
	    @Result(property="agreementNo",column="agreementNo"),  
	    @Result(property="agreementBuyerSigned",column="agreementBuyerSigned"),  
	    @Result(property="agreementSalerSigned",column="agreementSalerSigned"),  
	    @Result(property="agreementTime",column="agreementTime"),  
	    @Result(property="agreementBuyInfo",column="agreementBuyInfoId",one=@One(select="com.cbd.mapper.IBuyInfoMapper.getByIdBuyInfo")),
	    @Result(property="agreementCarport",column="agreementCarportId",one=@One(select="com.cbd.mapper.UsercarportMapper.getByIdUsercarport"))  }) 
	public AgreementEntity getAgreementByAgreementId(int agreementId);
	
	/**
	 * 
	 * <p>Title:updateAgreementTime</p>
	 * <p>Description:当双方签订后生成合同日期</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:02:37
	 */
	@Update("update t_agreement set agreementTime = #{param1} where agreementId=#{param2}")
	public int updateAgreementTime(Date agreementTime,int agreementId);
}
