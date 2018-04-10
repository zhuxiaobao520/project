package com.cbd.bean;

/**
 * 
 * <p>Title:AgreementTaskBean</p>
 * <p>Description:合同信息显示Bean</p>
 * @author 杨明健
 * @date2018年2月2日上午11:08:59
 */
public class AgreementTaskBean {
	/**
	 * 合同id
	 */
	private int agreementId;
	/**
	 * 合同编号
	 */
	private String agreementNo;
	/**
	 * 车位地址
	 */
	private String userCarportAddress;
	/**
	 * 车位号
	 */
	private String userCarportAddressNo;
	/**
	 * 车位产权证编号
	 */
	private String userCarportPropertityRight;
	/**
	 * 车位产权证复印件
	 */
	private String userCarportImageUrl;
	/**
	 * 卖家id
	 */
	private int saleId;
	/**
	 * 卖家姓名
	 */
	private String saleUserName;
	/**
	 * 卖家真实姓名
	 */
	private String saleUserRealName;
	/**
	 * 卖家身份证号码
	 */
	private String saleUserIdCard;
	/**
	 * 卖家电话号码
	 */
	private String saleUserPhone;
	/**
	 * 买家id
	 */
	private int buyId;
	/**
	 * 买家姓名
	 */
	private String buyUserName;
	/**
	 * 买家真实姓名
	 */
	private String buyUserRealName;
	/**
	 * 买家身份证号码
	 */
	private String buyUserIdCard;
	/**
	 * 买家电话号码
	 */
	private String buyUserPhone;
	/**
	 * 出售价格
	 */
	private double salePrice;
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
	public String getUserCarportPropertityRight() {
		return userCarportPropertityRight;
	}
	public void setUserCarportPropertityRight(String userCarportPropertityRight) {
		this.userCarportPropertityRight = userCarportPropertityRight;
	}
	public String getUserCarportImageUrl() {
		return userCarportImageUrl;
	}
	public void setUserCarportImageUrl(String userCarportImageUrl) {
		this.userCarportImageUrl = userCarportImageUrl;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public String getSaleUserName() {
		return saleUserName;
	}
	public void setSaleUserName(String saleUserName) {
		this.saleUserName = saleUserName;
	}
	public String getSaleUserRealName() {
		return saleUserRealName;
	}
	public void setSaleUserRealName(String saleUserRealName) {
		this.saleUserRealName = saleUserRealName;
	}
	public String getSaleUserIdCard() {
		return saleUserIdCard;
	}
	public void setSaleUserIdCard(String saleUserIdCard) {
		this.saleUserIdCard = saleUserIdCard;
	}
	public String getSaleUserPhone() {
		return saleUserPhone;
	}
	public void setSaleUserPhone(String saleUserPhone) {
		this.saleUserPhone = saleUserPhone;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public String getBuyUserName() {
		return buyUserName;
	}
	public void setBuyUserName(String buyUserName) {
		this.buyUserName = buyUserName;
	}
	public String getBuyUserRealName() {
		return buyUserRealName;
	}
	public void setBuyUserRealName(String buyUserRealName) {
		this.buyUserRealName = buyUserRealName;
	}
	public String getBuyUserIdCard() {
		return buyUserIdCard;
	}
	public void setBuyUserIdCard(String buyUserIdCard) {
		this.buyUserIdCard = buyUserIdCard;
	}
	public String getBuyUserPhone() {
		return buyUserPhone;
	}
	public void setBuyUserPhone(String buyUserPhone) {
		this.buyUserPhone = buyUserPhone;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	@Override
	public String toString() {
		return "AgreementTaskBean [agreementId=" + agreementId + ", agreementNo=" + agreementNo
				+ ", userCarportAddress=" + userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo
				+ ", userCarportPropertityRight=" + userCarportPropertityRight + ", userCarportImageUrl="
				+ userCarportImageUrl + ", saleId=" + saleId + ", saleUserName=" + saleUserName + ", saleUserRealName="
				+ saleUserRealName + ", saleUserIdCard=" + saleUserIdCard + ", saleUserPhone=" + saleUserPhone
				+ ", buyId=" + buyId + ", buyUserName=" + buyUserName + ", buyUserRealName=" + buyUserRealName
				+ ", buyUserIdCard=" + buyUserIdCard + ", buyUserPhone=" + buyUserPhone + ", salePrice=" + salePrice
				+ "]";
	}
	
}
