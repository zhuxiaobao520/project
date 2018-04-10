package com.cbd.bean;

/**
 * 
 * <p>Title:AllSaleInfoBean</p>
 * <p>Description:购买页面返回的所有出售车位的信息</p>
 * @author 杨明健
 * @date2018年2月1日上午10:31:40
 */
public class AllSaleInfoBean {
	/**
	 * 出售表id
	 */
	private int saleId;
	/**
	 * 出售价格
	 */
	private double salePrice;
	/**
	 * 发布时间
	 */
	private String salePublishTime;
	/**
	 * 车位用户id
	 */
	private int userCarportUserId;
	/**
	 * 车位地址
	 */
	private String userCarportAddress;
	/**
	 * 车位号
	 */
	private String userCarportAddressNo;
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
	public String getSalePublishTime() {
		return salePublishTime;
	}
	public void setSalePublishTime(String salePublishTime) {
		this.salePublishTime = salePublishTime;
	}
	public int getUserCarportUserId() {
		return userCarportUserId;
	}
	public void setUserCarportUserId(int userCarportUserId) {
		this.userCarportUserId = userCarportUserId;
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
	@Override
	public String toString() {
		return "AllSaleInfoBean [saleId=" + saleId + ", salePrice=" + salePrice + ", salePublishTime=" + salePublishTime
				+ ", userCarportUserId=" + userCarportUserId + ", userCarportAddress=" + userCarportAddress
				+ ", userCarportAddressNo=" + userCarportAddressNo + "]";
	}
	
}
