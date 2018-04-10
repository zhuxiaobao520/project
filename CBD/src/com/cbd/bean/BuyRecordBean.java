package com.cbd.bean;

import java.util.Date;

/**
 * 购买记录Bean
 * @Title:BuyRecordBean
 * @Description:
 * @author 黄先明
 * @dated 2018年2月1日
 */
public class BuyRecordBean {
	
	private int buyInfoId;			//id
	private UserBean buyInfoUser;	//购买人
	private String userCarportAddress;//购买车位地址
	private String userCarportAddressNo;//购买车位编号
	private UserBean sellUser;//出售人信息
	private Date dealDate;//交易时间
	private double dealPrice;//交易价格
	public int getBuyInfoId() {
		return buyInfoId;
	}
	public void setBuyInfoId(int buyInfoId) {
		this.buyInfoId = buyInfoId;
	}
	public UserBean getBuyInfoUser() {
		return buyInfoUser;
	}
	public void setBuyInfoUser(UserBean buyInfoUser) {
		this.buyInfoUser = buyInfoUser;
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
	public UserBean getSellUser() {
		return sellUser;
	}
	public void setSellUser(UserBean sellUser) {
		this.sellUser = sellUser;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public double getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}
	@Override
	public String toString() {
		return "BuyRecordBean [buyInfoId=" + buyInfoId + ", buyInfoUser=" + buyInfoUser + ", userCarportAddress="
				+ userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo + ", sellUser=" + sellUser
				+ ", dealDate=" + dealDate + ", dealPrice=" + dealPrice + "]";
	}
	
	
	
}
