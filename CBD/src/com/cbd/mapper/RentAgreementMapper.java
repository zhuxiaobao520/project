package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.RenterAgreementBean;
import com.cbd.entity.RenterAgreementEntity;
/**
 * 租户合约Mapper
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
public interface RentAgreementMapper extends SqlMapper{
	/**
	 * 获取所有条约
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @return
	 */
	@Select("select * from t_renteragreement")
	public List<RenterAgreementEntity> getAllAgreement();
	/**
	 * 获取分页信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param startIndex
	 * @param size
	 * @return
	 */
	@Select("select * from t_renteragreement limit #{param1},#{param2}")
	public List<RenterAgreementEntity> getPageAgreement(int startIndex,int size);
	/**
	 * 根据id查出对应信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param id
	 * @return
	 */
	@Select("select * from t_renteragreement where renterAgreementId=#{id}")
	public RenterAgreementEntity findAgreementById(int id);
	/**
	 * 添加合约信息
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param rentEntity
	 */
	@Options(useGeneratedKeys=true,keyProperty="renterAgreementId")
	@Insert("insert into t_renteragreement (renterAgreementCompanyId,renterAgreementOldNo,renterAgreementNewNo,"
			+ "renterAgreementStartTime,renterAgreementEndTime,renterAgreementStatus,renterAgreementUrl,renterAgreementPrice) "
			+ "values(#{renterAgreementCompanyId},#{renterAgreementOldNo},"
			+ "#{renterAgreementNewNo },#{renterAgreementStartTime},#{renterAgreementEndTime},"
			+ "#{renterAgreementStatus},"
			+ "#{renterAgreementUrl},#{renterAgreementPrice})")
	public int addNewAgreement(RenterAgreementEntity rentEntity);
	/**
	 * 根据id修改对应状态
	 * @author 刘芯宇
	 * @Date 2018年2月5日
	 * @param id
	 */
	@Update("update t_renteragreement set renterAgreementStatus=0  where renterAgreementId=#{id}")
	public void updateAgreementById(int id);
	
	/**
	 * 
	 * <p>Title:deleteManyAgreement</p>
	 * <p>Description: 根据企业删除合约</p>
	 * @author 朱小宝
	 * @return void
	 */
	@Delete("delete from t_renteragreement where renterAgreementCompanyId=#{id}")
	public void deleteManyAgreement(int id);
}
