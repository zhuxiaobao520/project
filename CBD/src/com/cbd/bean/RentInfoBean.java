package com.cbd.bean;

import java.util.Date;

/**
 * 租赁相关的详细bean
 * 包含租赁相关的所有信息
 * @author 姚刚
 * @date 2018年2月5日
 */
public class RentInfoBean {
	@Override
	public String toString() {
		return "RentInfoBean [rentInId=" + rentInId + ", rentOutId=" + rentOutId + ", rentOutPrice=" + rentOutPrice
				+ ", rentOutStartTime=" + rentOutStartTime + ", rentOutEndTime=" + rentOutEndTime + ", rentOutUserId="
				+ rentOutUserId + ", rentOutUserName=" + rentOutUserName + ", userCarportId=" + userCarportId
				+ ", userCarportAddress=" + userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo
				+ ", rentInUserId=" + rentInUserId + ", rentInUserName=" + rentInUserName + "]";
	}
	private int rentInId;
	//出租信息
	private int rentOutId;
	private double rentOutPrice;
	private Date rentOutStartTime;
	private Date rentOutEndTime;//
	//出租人信息
	private int rentOutUserId;
	private String rentOutUserName;
	//车位信息
	private int userCarportId;
	private String userCarportAddress;
	private String userCarportAddressNo;
	//租赁人信息
	private int rentInUserId;
	private String rentInUserName;
	public RentInfoBean() {
		// TODO Auto-generated constructor stub
	}
	public int getRentInId() {
		return rentInId;
	}
	public void setRentInId(int rentInId) {
		this.rentInId = rentInId;
	}
	public int getRentOutId() {
		return rentOutId;
	}
	public void setRentOutId(int rentOutId) {
		this.rentOutId = rentOutId;
	}
	public double getRentOutPrice() {
		return rentOutPrice;
	}
	public void setRentOutPrice(double rentOutPrice) {
		this.rentOutPrice = rentOutPrice;
	}
	public Date getRentOutStartTime() {
		return rentOutStartTime;
	}
	public void setRentOutStartTime(Date rentOutStartTime) {
		this.rentOutStartTime = rentOutStartTime;
	}
	public Date getRentOutEndTime() {
		return rentOutEndTime;
	}
	public void setRentOutEndTime(Date rentOutEndTime) {
		this.rentOutEndTime = rentOutEndTime;
	}
	public int getRentOutUserId() {
		return rentOutUserId;
	}
	public void setRentOutUserId(int rentOutUserId) {
		this.rentOutUserId = rentOutUserId;
	}
	public String getRentOutUserName() {
		return rentOutUserName;
	}
	public void setRentOutUserName(String rentOutUserName) {
		this.rentOutUserName = rentOutUserName;
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
	public int getRentInUserId() {
		return rentInUserId;
	}
	public void setRentInUserId(int rentInUserId) {
		this.rentInUserId = rentInUserId;
	}
	public String getRentInUserName() {
		return rentInUserName;
	}
	public void setRentInUserName(String rentInUserName) {
		this.rentInUserName = rentInUserName;
	}
	
}
