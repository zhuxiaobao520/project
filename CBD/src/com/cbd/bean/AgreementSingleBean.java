package com.cbd.bean;

/**
 * 只包含合同表中
 * 合同主键，车位主键，出售信息的主键
 * 双方的签约状态的bean
 * 用于签约时查询对方的签约状态用
 * @author 姚刚
 * @date 2018年2月4日
 */
public class AgreementSingleBean {
	private int agreementId;
	private int agreementCarportId;//出手呢车位的id 
	private int agreementBuyInfoId;//购买记录的Id
	private int agreementBuyerSigned;//购买人是否签约
	private int agreementSalerSigned;//出售人是否签约
	public AgreementSingleBean() {
	}
	public int getAgreementId() {
		return agreementId;
	}
	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}
	public int getAgreementCarportId() {
		return agreementCarportId;
	}
	public void setAgreementCarportId(int agreementCarportId) {
		this.agreementCarportId = agreementCarportId;
	}
	public int getAgreementBuyerSigned() {
		return agreementBuyerSigned;
	}
	public void setAgreementBuyerSigned(int agreementBuyerSigned) {
		this.agreementBuyerSigned = agreementBuyerSigned;
	}
	public int getAgreementSalerSigned() {
		return agreementSalerSigned;
	}
	public void setAgreementSalerSigned(int agreementSalerSigned) {
		this.agreementSalerSigned = agreementSalerSigned;
	}
	public int getAgreementBuyInfoId() {
		return agreementBuyInfoId;
	}
	public void setAgreementBuyInfoId(int agreementBuyInfoId) {
		this.agreementBuyInfoId = agreementBuyInfoId;
	}
}
