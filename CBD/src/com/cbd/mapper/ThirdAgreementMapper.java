package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.entity.ThirdAgreementEntity;


/**
 * 
 * 
 * <p>Title:ThirdAgreementMapper</p>
 * <p>Description:第三方合约映射接口 </p>
 * @author 王菁
 * @date2018年1月31日下午3:05:08
 */
public interface ThirdAgreementMapper extends SqlMapper {

	/**
	 * 
	 * 
	 * <p>Title:findAll</p>
	 * <p>Description:查询所有合约 </p>
	 * @author 王菁
	 * @return List<ThirdAgreementEntity>
	 */
	@Select("select * from t_thirdaggrement")
	public List<ThirdAgreementEntity> findAll();
	
	/**
	 * 
	 * 
	 * <p>Title:findThirdAgreementPage</p>
	 * <p>Description:分页查询 </p>
	 * @author 王菁
	 * @return List<ThirdAgreementEntity>
	 */
	@Select("select * from t_thirdaggrement limit #{param1},#{param2}")
	public List<ThirdAgreementEntity> findThirdAgreementPage(int startPosition,int pageSize);
	
	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:添加第三方合约 </p>
	 * @author 王菁
	 * @return int
	 */
	@Insert("insert into t_thirdaggrement(thirdAggrementNewNo,thirdAggrementCompany,"
			+ "thirdAggrementLinkMan,thirdAggrementLinkManPhone,"
			+ "thirdAggrementCompanyAddress,thirdAggrementStartTime,"
			+ "thirdAggrementEndTime,thirdAggrementImageUrl,"
			+ "thirdAggrementStatus,thirdAggrementPrice) values(#{thirdAggrementNewNo},"
			+ "#{thirdAggrementCompany},#{thirdAggrementLinkMan},"
			+ "#{thirdAggrementLinkManPhone},#{thirdAggrementCompanyAddress},"
			+ "#{thirdAggrementStartTime},#{thirdAggrementEndTime},"
			+ "#{thirdAggrementImageUrl},#{thirdAggrementStatus},"
			+ "#{thirdAggrementPrice})")
	public int addThirdAgreement(ThirdAgreementEntity thirdAgreementEntity);
	
	/**
	 * 
	 * 
	 * <p>Title:selectAgreementById</p>
	 * <p>Description:根据Id查询第三方合约 </p>
	 * @author 王菁
	 * @return ThirdAgreementEntity
	 */
	@Select("select * from t_thirdaggrement where thirdAggrementId = #{thirdAgreementId}")
	public ThirdAgreementEntity selectAgreementById(int thirdAgreementId);
	
	/**
	 * 
	 * 
	 * <p>Title:cancelAgreement</p>
	 * <p>Description:根据Id第三方合约解约 </p>
	 * @author 王菁
	 * @return int
	 */

	@Delete("delete from t_thirdaggrement where thirdAggrementId = #{thirdAgreementId}")
	public int deleteAgreement(int thirdAgreementId);



	
	/**
	 * 
	 * 
	 * <p>Title:continueAgreement</p>
	 * <p>Description:根据Id第三方合约续约 </p>
	 * @author 王菁
	 * @return int
	 */
	@Update("update t_thirdaggrement set thirdAggrementOldNo=thirdAggrementNewNo, thirdAggrementNewNo = #{thirdAggrementNewNo}, "
			+ "thirdAggrementImageUrl=#{thirdAggrementImageUrl},thirdAggrementStartTime=#{thirdAggrementStartTime},  "
			+"thirdAggrementEndTime=#{thirdAggrementEndTime},thirdAggrementStatus=1 "
			+ "where thirdAggrementId = #{thirdAggrementId}")
	public int updateAgreement(ThirdAgreementEntity thirdAgreementEntity);
	
	/**
	 * 
	 * <p>Title:getThirdAgreementIdByNewNo</p>
	 * <p>Description:根据合约号，查询合约id</p>
	 * @author 朱小宝
	 * @return int
	 */
	@Select("select thirdAggrementId from t_thirdaggrement where thirdAggrementNewNo=#{thirdAggrementNewNo}")
	public int getThirdAgreementIdByNewNo(String thirdAggrementNewNo);
}
