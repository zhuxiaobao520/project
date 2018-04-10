package com.cbd.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 
 * <p>Title:RenterAgreementEntity</p>
 * <p>Description:租户合约实体类 </p>
 * @author 王菁
 * @date2018年2月1日上午11:26:32
 */
public class RenterAgreementEntity {

	/**
	 * 主键ID
	 */
	private int renterAgreementId;
	
	/**
	 * 企业ID
	 */
	private int renterAgreementCompanyId;
	
	/**
	 * 原合约编号
	 */
	private String renterAgreementOldNo;
	
	/**
	 * 现合约编号
	 */
	private String renterAgreementNewNo;
	
	/**
	 * 合约生效时间
	 */
	private Date renterAgreementStartTime;
	
	/**
	 * 合约截止时间
	 */
	private Date renterAgreementEndTime;
	
	/**
	 * 合约状态
	 */
	private int renterAgreementStatus;
	
	/**
	 * 合同复印件
	 */
	private String renterAgreementUrl;
	
	/**
	 * 成交价格
	 */
	private double renterAgreementPrice;
	/**
	 * 集合
	 */
	private List datas;

	public int getRenterAgreementId() {
		return renterAgreementId;
	}

	public void setRenterAgreementId(int renterAgreementId) {
		this.renterAgreementId = renterAgreementId;
	}

	public int getRenterAgreementCompanyId() {
		return renterAgreementCompanyId;
	}

	public void setRenterAgreementCompanyId(int renterAgreementCompanyId) {
		this.renterAgreementCompanyId = renterAgreementCompanyId;
	}

	public String getRenterAgreementOldNo() {
		return renterAgreementOldNo;
	}

	public void setRenterAgreementOldNo(String renterAgreementOldNo) {
		this.renterAgreementOldNo = renterAgreementOldNo;
	}

	public String getRenterAgreementNewNo() {
		return renterAgreementNewNo;
	}

	public void setRenterAgreementNewNo(String renterAgreementNewNo) {
		this.renterAgreementNewNo = renterAgreementNewNo;
	}
     @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getRenterAgreementStartTime() {
		return renterAgreementStartTime;
	}

	public void setRenterAgreementStartTime(Date renterAgreementStartTime) {
		this.renterAgreementStartTime = renterAgreementStartTime;
	}
	 @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getRenterAgreementEndTime() {
		return renterAgreementEndTime;
	}

	public void setRenterAgreementEndTime(Date renterAgreementEndTime) {
		this.renterAgreementEndTime = renterAgreementEndTime;
	}

	public int getRenterAgreementStatus() {
		return renterAgreementStatus;
	}

	public void setRenterAgreementStatus(int renterAgreementStatus) {
		this.renterAgreementStatus = renterAgreementStatus;
	}

	public String getRenterAgreementUrl() {
		return renterAgreementUrl;
	}

	public void setRenterAgreementUrl(String renterAgreementUrl) {
		this.renterAgreementUrl = renterAgreementUrl;
	}

	public double getRenterAgreementPrice() {
		return renterAgreementPrice;
	}

	public void setRenterAgreementPrice(double renterAgreementPrice) {
		this.renterAgreementPrice = renterAgreementPrice;
	}
    
	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "RenterAgreementEntity [renterAgreementId=" + renterAgreementId + ", renterAgreementCompanyId="
				+ renterAgreementCompanyId + ", renterAgreementOldNo=" + renterAgreementOldNo
				+ ", renterAgreementNewNo=" + renterAgreementNewNo + ", renterAgreementStartTime="
				+ renterAgreementStartTime + ", renterAgreementEndTime=" + renterAgreementEndTime
				+ ", renterAgreementStatus=" + renterAgreementStatus + ", renterAgreementUrl=" + renterAgreementUrl
				+ ", renterAgreementPrice=" + renterAgreementPrice + ", datas=" + datas + "]";
	}


}
