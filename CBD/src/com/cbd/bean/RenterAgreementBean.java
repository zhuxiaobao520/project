package com.cbd.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * 
 * <p>Title:RenterAgreementBean</p>
 * <p>Description:租户合约Bean </p>
 * @author 王菁
 * @date2018年2月1日上午11:18:38
 */

public class RenterAgreementBean {

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
	@NotEmpty(message="输入开始时间不能为空")
	private Date renterAgreementStartTime;
	
	/**
	 * 合约截止时间
	 */
	@NotEmpty(message="输入截止时间不能为空")
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

	public Date getRenterAgreementStartTime() {
		return renterAgreementStartTime;
	}

	public void setRenterAgreementStartTime(Date renterAgreementStartTime) {
		this.renterAgreementStartTime = renterAgreementStartTime;
	}

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

	@Override
	public String toString() {
		return "RenterAgreementBean [renterAgreementId=" + renterAgreementId + ", renterAgreementCompanyId="
				+ renterAgreementCompanyId + ", renterAgreementOldNo=" + renterAgreementOldNo
				+ ", renterAgreementNewNo=" + renterAgreementNewNo + ", renterAgreementStartTime="
				+ renterAgreementStartTime + ", renterAgreementEndTime=" + renterAgreementEndTime
				+ ", renterAgreementStatus=" + renterAgreementStatus + ", renterAgreementUrl=" + renterAgreementUrl
				+ ", renterAgreementPrice=" + renterAgreementPrice + "]";
	}
	
	
}
