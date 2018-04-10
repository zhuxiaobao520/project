package com.cbd.entity;

import java.sql.Date;

/**
 * 购买合同信息实体类
 * @author 唐小雄
 * @date 2018年1月31日
 */
public class AgreementEntity {

	private int agreementId;						//id
	private String agreementNo;						//合同编号
	private UsercarportEntity agreementCarport;		//车位信息
	private BuyInfoEntity agreementBuyInfo;			//购买信息
	private boolean agreementBuyerSigned;			//购买人是否签订
	private boolean agreementSalerSigned;			//出售人是否签订
	private Date agreementTime;						//合同生效日期
	
	public AgreementEntity() {
		super();
	}

	public AgreementEntity(int agreementId, String agreementNo, UsercarportEntity agreementCarport,
			BuyInfoEntity agreementBuyInfo, boolean agreementBuyerSigned, boolean agreementSalerSigned,
			Date agreementTime) {
		super();
		this.agreementId = agreementId;
		this.agreementNo = agreementNo;
		this.agreementCarport = agreementCarport;
		this.agreementBuyInfo = agreementBuyInfo;
		this.agreementBuyerSigned = agreementBuyerSigned;
		this.agreementSalerSigned = agreementSalerSigned;
		this.agreementTime = agreementTime;
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

	public UsercarportEntity getAgreementCarport() {
		return agreementCarport;
	}

	public void setAgreementCarport(UsercarportEntity agreementCarport) {
		this.agreementCarport = agreementCarport;
	}

	public BuyInfoEntity getAgreementBuyInfo() {
		return agreementBuyInfo;
	}

	public void setAgreementBuyInfo(BuyInfoEntity agreementBuyInfo) {
		this.agreementBuyInfo = agreementBuyInfo;
	}

	public boolean getAgreementBuyerSigned() {
		return agreementBuyerSigned;
	}

	public void setAgreementBuyerSigned(boolean agreementBuyerSigned) {
		this.agreementBuyerSigned = agreementBuyerSigned;
	}

	public boolean getAgreementSalerSigned() {
		return agreementSalerSigned;
	}

	public void setAgreementSalerSigned(boolean agreementSalerSigned) {
		this.agreementSalerSigned = agreementSalerSigned;
	}

	public Date getAgreementTime() {
		return agreementTime;
	}

	public void setAgreementTime(Date agreementTime) {
		this.agreementTime = agreementTime;
	}

	@Override
	public String toString() {
		return "AgreementEntity [agreementId=" + agreementId + ", agreementNo=" + agreementNo + ", agreementCarport="
				+ agreementCarport + ", agreementBuyInfo=" + agreementBuyInfo + ", agreementBuyerSigned="
				+ agreementBuyerSigned + ", agreementSalerSigned=" + agreementSalerSigned + ", agreementTime="
				+ agreementTime + "]";
	}
	
}
