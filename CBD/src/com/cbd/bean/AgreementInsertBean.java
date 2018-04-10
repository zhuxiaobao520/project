package com.cbd.bean;

import java.util.Date;

/**
 * 购买合同bean
 * 用于新增购买合同
 * @author 姚刚
 * @date 2018年2月4日
 */
public class AgreementInsertBean {
	private int agreementId;
	private String agreementNo;
	private int  agreementCarportId;
	private int  agreementBuyInfoId;
	private Date agreementTime;
	public String getAgreementNo() {
		return agreementNo;
	}
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}
	public int getAgreementCarportId() {
		return agreementCarportId;
	}
	public void setAgreementCarportId(int agreementCarportId) {
		this.agreementCarportId = agreementCarportId;
	}
	public int getAgreementBuyInfoId() {
		return agreementBuyInfoId;
	}
	public void setAgreementBuyInfoId(int agreementBuyInfoId) {
		this.agreementBuyInfoId = agreementBuyInfoId;
	}
	public Date getAgreementTime() {
		return agreementTime;
	}
	public void setAgreementTime(Date agreementTime) {
		this.agreementTime = agreementTime;
	}
	public int getAgreementId() {
		return agreementId;
	}
	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}
	@Override
	public String toString() {
		return "AgreementInsertBean [agreementId=" + agreementId + ", agreementNo=" + agreementNo
				+ ", agreementCarportId=" + agreementCarportId + ", agreementBuyInfoId=" + agreementBuyInfoId
				+ ", agreementTime=" + agreementTime + "]";
	}
	
}
