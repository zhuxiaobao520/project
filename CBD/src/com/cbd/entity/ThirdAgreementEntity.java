﻿package com.cbd.entity;

import java.util.Date;

import com.cbd.util.DateUtil;

/**
 * 
 * 
 * <p>Title:ThirdAgreementEntity</p>
 * <p>Description:第三方合约实体类 </p>
 * @author 王菁
 * @date2018年1月31日下午3:32:38
 */
public class ThirdAgreementEntity {

	/**
	 * 第三方合约id
	 */
	private int thirdAggrementId;

	/**
	 * 第三方合约旧编号
	 */
	private String thirdAggrementOldNo;
	
	/**
	 * 第三方合约新编号
	 */
	private String thirdAggrementNewNo;
	
	/**
	 * 第三方合约单位
	 */	
	private String thirdAggrementCompany;
	
	/**
	 * 第三方合约单位联系人
	 */	
	private String thirdAggrementLinkMan;
	
	/**
	 * 第三方合约单位联系人电话
	 */	
	private String thirdAggrementLinkManPhone;
	
	/**
	 * 第三方合约单位地址
	 */
	private String thirdAggrementCompanyAddress;
	
	/**
	 * 第三方合约开始时间
	 */	
	private Date thirdAggrementStartTime;
	
	private String thirdAgreementBeginTime;
	
	/**
	 * 第三方合约结束时间
	 */	
	private Date thirdAggrementEndTime;
	
	private String thirdAgreementOverTime;
	
	/**
	 * 第三方合约图片路径
	 */	
	private String thirdAggrementImageUrl;
	
	/**
	 * 第三方合约状态
	 */	
	private int thirdAggrementStatus;
	
	private String thirdAgreementStatus;
	
	/**
	 * 第三方合约价格
	 */	
	private double thirdAggrementPrice;

	public int getThirdAggrementId() {
		return thirdAggrementId;
	}

	public void setThirdAggrementId(int thirdAggrementId) {
		this.thirdAggrementId = thirdAggrementId;
	}

	public String getThirdAggrementCompanyAddress() {
		return thirdAggrementCompanyAddress;
	}

	public void setThirdAggrementCompanyAddress(String thirdAggrementCompanyAddress) {
		this.thirdAggrementCompanyAddress = thirdAggrementCompanyAddress;
	}

	public int getThirdAgreementId() {
		return thirdAggrementId;
	}

	public void setThirdAgreementId(int thirdAgreementId) {
		this.thirdAggrementId = thirdAgreementId;
	}

	public String getThirdAggrementOldNo() {
		return thirdAggrementOldNo;
	}

	public void setThirdAggrementOldNo(String thirdAggrementOldNo) {
		this.thirdAggrementOldNo = thirdAggrementOldNo;
	}

	public String getThirdAggrementNewNo() {
		return thirdAggrementNewNo;
	}

	public void setThirdAggrementNewNo(String thirdAggrementNewNo) {
		this.thirdAggrementNewNo = thirdAggrementNewNo;
	}

	public String getThirdAggrementCompany() {
		return thirdAggrementCompany;
	}

	public void setThirdAggrementCompany(String thirdAggrementCompany) {
		this.thirdAggrementCompany = thirdAggrementCompany;
	}

	public String getThirdAggrementLinkMan() {
		return thirdAggrementLinkMan;
	}

	public void setThirdAggrementLinkMan(String thirdAggrementLinkMan) {
		this.thirdAggrementLinkMan = thirdAggrementLinkMan;
	}

	public String getThirdAggrementLinkManPhone() {
		return thirdAggrementLinkManPhone;
	}

	public void setThirdAggrementLinkManPhone(String thirdAggrementLinkManPhone) {
		this.thirdAggrementLinkManPhone = thirdAggrementLinkManPhone;
	}

	public Date getThirdAggrementStartTime() {
		return thirdAggrementStartTime;
	}

	public void setThirdAggrementStartTime(Date thirdAggrementStartTime) {
		this.thirdAggrementStartTime = thirdAggrementStartTime;
	}

	public Date getThirdAggrementEndTime() {
		return thirdAggrementEndTime;
	}

	public void setThirdAggrementEndTime(Date thirdAggrementEndTime) {
		this.thirdAggrementEndTime = thirdAggrementEndTime;
	}

	public String getThirdAggrementImageUrl() {
		return thirdAggrementImageUrl;
	}

	public void setThirdAggrementImageUrl(String thirdAggrementImageUrl) {
		this.thirdAggrementImageUrl = thirdAggrementImageUrl;
	}

	public int getThirdAggrementStatus() {
		return thirdAggrementStatus;
	}

	public void setThirdAggrementStatus(int thirdAggrementStatus) {
		this.thirdAggrementStatus = thirdAggrementStatus;
	}

	public double getThirdAggrementPrice() {
		return thirdAggrementPrice;
	}

	public void setThirdAggrementPrice(double thirdAggrementPrice) {
		this.thirdAggrementPrice = thirdAggrementPrice;
	}

	
	
	public String getThirdAgreementBeginTime() {
		return DateUtil.dateToStr(thirdAggrementStartTime, "yyyy-MM-dd HH:mm:ss");
	}

	public void setThirdAgreementBeginTime(String thirdAgreementBeginTime) {
		this.thirdAgreementBeginTime = thirdAgreementBeginTime;
	}

	public String getThirdAgreementOverTime() {
		return DateUtil.dateToStr(thirdAggrementEndTime, "yyyy-MM-dd HH:mm:ss");
	}

	public void setThirdAgreementOverTime(String thirdAgreementOverTime) {
		this.thirdAgreementOverTime = thirdAgreementOverTime;
	}

	public String getThirdAgreementStatus() {
		return thirdAggrementStatus==1?"生效":"无效";
	}

	public void setThirdAgreementStatus(String thirdAgreementStatus) {
		this.thirdAgreementStatus = thirdAgreementStatus;
	}

	@Override
	public String toString() {
		return "ThirdAgreementEntity [thirdAggrementId=" + thirdAggrementId + ", thirdAggrementOldNo="
				+ thirdAggrementOldNo + ", thirdAggrementNewNo=" + thirdAggrementNewNo + ", thirdAggrementCompany="
				+ thirdAggrementCompany + ", thirdAggrementLinkMan=" + thirdAggrementLinkMan
				+ ", thirdAggrementLinkManPhone=" + thirdAggrementLinkManPhone + ", thirdAggrementCompanyAddress="
				+ thirdAggrementCompanyAddress + ", thirdAggrementStartTime=" + thirdAggrementStartTime
				+ ", thirdAggrementEndTime=" + thirdAggrementEndTime + ", thirdAggrementImageUrl="
				+ thirdAggrementImageUrl + ", thirdAggrementStatus=" + thirdAggrementStatus + ", thirdAggrementPrice="
				+ thirdAggrementPrice + "]";
	}
	
	
}
