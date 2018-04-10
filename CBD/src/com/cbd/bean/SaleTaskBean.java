package com.cbd.bean;

import com.cbd.entity.UserEntity;

/**
 * 
 * <p>Title:SaleTaskBean</p>
 * <p>Description:待办出售任务Bean</p>
 * @author 龙成
 * @date2018年2月2日上午9:43:06
 */
public class SaleTaskBean {
	/**
	 * 车位小区地址
	 */
	private String userCarportAddress;
	
	/**
	 * 车位区域编号
	 */
	private String userCarportAddressNo;
	
	/**
	 * 出售车位id
	 */
	private int saleCarportId;
	
	
	/**
	 * 购买信息id
	 */
	private int buyInfoId;
	
	/**
	 * 出售信息id
	 */
	private int buyInfoSaleId;	
	
	/**
	 * 出售价格
	 */
	private double salePrice;
	
	/**
	 * 留言
	 */
	private String buyInfoMassage;
	
	/**
	 * 购买人引用
	 */
	private UserEntity userEntity;

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

	public int getSaleCarportId() {
		return saleCarportId;
	}

	public void setSaleCarportId(int saleCarportId) {
		this.saleCarportId = saleCarportId;
	}

	public int getBuyInfoId() {
		return buyInfoId;
	}

	public void setBuyInfoId(int buyInfoId) {
		this.buyInfoId = buyInfoId;
	}

	public int getBuyInfoSaleId() {
		return buyInfoSaleId;
	}

	public void setBuyInfoSaleId(int buyInfoSaleId) {
		this.buyInfoSaleId = buyInfoSaleId;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getBuyInfoMassage() {
		return buyInfoMassage;
	}

	public void setBuyInfoMassage(String buyInfoMassage) {
		this.buyInfoMassage = buyInfoMassage;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "SaleTaskBean [userCarportAddress=" + userCarportAddress + ", userCarportAddressNo="
				+ userCarportAddressNo + ", saleCarportId=" + saleCarportId + ", buyInfoId=" + buyInfoId
				+ ", buyInfoSaleId=" + buyInfoSaleId + ", salePrice=" + salePrice + ", buyInfoMassage=" + buyInfoMassage
				+ ", userEntity=" + userEntity + "]";
	}
	
}
