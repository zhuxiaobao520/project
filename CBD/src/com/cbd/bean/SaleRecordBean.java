package com.cbd.bean;

import java.util.Date;

import com.cbd.entity.UserEntity;
import com.cbd.util.DateUtil;

/**
 * 
 * @Title:SellRecordBean
 * @Description:用户出售买卖记录Bean 
 * @author 黄先明
 * @dated 2018年2月1日
 */
public class SaleRecordBean {
	/**
	 * 购买信息id
	 */
	private int buyInfoId;
	/**
	 * 购买人
	 */
	private UserEntity  buyInfoUser;
	/**
	 * 出售车位地址
	 */
	private String userCarportAddress;
	/**
	 * 购买车位编号
	 */
	private String userCarportAddressNo;
	/**
	 * 出售人信息
	 */
	private UserEntity sellUser;
	/**
	 * 交易时间
	 */
	private Date dealDate;
	/**
	 * 页面显示时间
	 */
	private String dealTime;
	/**
	 * 交易价格
	 */
	private double dealPrice;
	
	
	
	public int getBuyInfoId() {
		return buyInfoId;
	}
	public void setBuyInfoId(int buyInfoId) {
		this.buyInfoId = buyInfoId;
	}
	public String getDealTime() {
		return DateUtil.dateToStr(dealDate, "yyyy-MM-dd HH:mm:ss");
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public UserEntity getBuyInfoUser() {
		return buyInfoUser;
	}
	public void setBuyInfoUser(UserEntity buyInfoUser) {
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
	public UserEntity getSellUser() {
		return sellUser;
	}
	public void setSellUser(UserEntity sellUser) {
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
		return "SaleRecordBean [buyInfoId=" + buyInfoId + ", buyInfoUser=" + buyInfoUser + ", userCarportAddress="
				+ userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo + ", sellUser=" + sellUser
				+ ", dealDate=" + dealDate + ", dealTime=" + dealTime + ", dealPrice=" + dealPrice + "]";
	}
	
	


	
}
