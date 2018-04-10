package com.cbd.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户合同详情bean
 * 包括
 * 出售详情/购买详情
 * 车位信息
 * 出售人信息
 * 购买人信息
 * 出售信息
 * @author 姚刚
 * @date 2018年2月4日
 */
public class AgreementInfoBean {
	private int agreementId;
	private String agreementNo;
	private Date agreementTime;
	private String agreementDate;
	private int buyInfoId;//购买信息表的主键
	private String buyInfoStatus;//购买记录的状态,申请签约，待签约,交易成功，交易失败
	private int saleId;//出售信息的主键
	private double salePrice;//出售价格
	private Date salePublishTime;//出售信息发布时间
	private String salePublishDate;//出售时间，前端页面显示用
	private int userCarportId;//出售车位Id
	private String userCarportAddress;//车位地址
	private String userCarportAddressNo;//车位编号
	private int buyUserId;//购买人id;
	private String buyUserName;//购买人用户名
	private int saleUserId;//出售人主键
	private String saleUserName;//出售人姓名
	
	public AgreementInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public Date getAgreementTime() {
		return agreementTime;
	}

	public void setAgreementTime(Date agreementTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (agreementTime != null) {
			agreementDate = simpleDateFormat.format(agreementTime);
		}
		this.agreementTime = agreementTime;
	}

	public String getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(String agreementDate) {
		this.agreementDate = agreementDate;
	}

	public int getBuyInfoId() {
		return buyInfoId;
	}

	public void setBuyInfoId(int buyInfoId) {
		this.buyInfoId = buyInfoId;
	}

	public String getBuyInfoStatus() {
		return buyInfoStatus;
	}

	public void setBuyInfoStatus(String buyInfoStatus) {
		this.buyInfoStatus = buyInfoStatus;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSalePublishTime() {
		return salePublishTime;
	}

	public void setSalePublishTime(Date salePublishTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (salePublishTime != null) {
			salePublishDate = simpleDateFormat.format(salePublishTime);
		}
		this.salePublishTime = salePublishTime;
	}

	public String getSalePublishDate() {
		return salePublishDate;
	}

	public void setSalePublishDate(String salePublishDate) {
		this.salePublishDate = salePublishDate;
	}

	public int getUserCarportId() {
		return userCarportId;
	}

	public void setUserCarportId(int userCarportId) {
		this.userCarportId = userCarportId;
	}

	public String getUserCarportAddress() {
		return userCarportAddress;
	}

	public void setUserCarportAddress(String userCarportAddress) {
		this.userCarportAddress = userCarportAddress;
	}

	public String getUserCarportAddressNo() {
		return userCarportAddressNo;
	}

	public void setUserCarportAddressNo(String userCarportAddressNo) {
		this.userCarportAddressNo = userCarportAddressNo;
	}

	public int getBuyUserId() {
		return buyUserId;
	}

	public void setBuyUserId(int buyUserId) {
		this.buyUserId = buyUserId;
	}

	public String getBuyUserName() {
		return buyUserName;
	}

	public void setBuyUserName(String buyUserName) {
		this.buyUserName = buyUserName;
	}

	public int getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(int saleUserId) {
		this.saleUserId = saleUserId;
	}

	public String getSaleUserName() {
		return saleUserName;
	}

	public void setSaleUserName(String saleUserName) {
		this.saleUserName = saleUserName;
	}

	@Override
	public String toString() {
		return "AgreementInfoBean [agreementId=" + agreementId + ", agreementNo=" + agreementNo + ", agreementDate="
				+ agreementDate + ", buyInfoId=" + buyInfoId + ", buyInfoStatus=" + buyInfoStatus + ", saleId=" + saleId
				+ ", salePrice=" + salePrice + ", salePublishDate=" + salePublishDate + ", userCarportId="
				+ userCarportId + ", userCarportAddress=" + userCarportAddress + ", userCarportAddressNo="
				+ userCarportAddressNo + ", buyUserId=" + buyUserId + ", buyUserName=" + buyUserName + ", saleUserId="
				+ saleUserId + ", saleUserName=" + saleUserName + "]";
	}
	
	
}
