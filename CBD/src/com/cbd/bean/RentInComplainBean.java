package com.cbd.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于租赁投诉相关的租赁bean
 * @author 姚刚
 * @date 2018年2月2日
 */
public class RentInComplainBean {

	private int rentOutId;
	private int rentInId;
	//租户
	private int rentInUserId;
	private String userCarportAddress;
	private String userCarportAddressNo;
	private Date rentOutStartTime;
	private Date rentOutEndTime;
	private String rentOutStartDate;
	private String rentOutEndDate;
	private int rentOutPrice;
	/**
	 * 出租用户名
	 */
	private int rentOutUserId;
	private int userCarportId;
	private String rentOutUserName;
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

	
	public Date getRentOutStartTime() {
		return rentOutStartTime;
	}

	public void setRentOutStartTime(Date rentOutStartTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (rentOutStartTime != null) {
			rentOutStartDate = simpleDateFormat.format(rentOutStartTime);
		}
		this.rentOutStartTime = rentOutStartTime;
	}

	public Date getRentOutEndTime() {
		return rentOutEndTime;
	}

	public void setRentOutEndTime(Date rentOutEndTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (rentOutEndTime != null) {
			rentOutEndDate = simpleDateFormat.format(rentOutEndTime);
		}
		this.rentOutEndTime = rentOutEndTime;
	}

	public String getRentOutStartDate() {

		return rentOutStartDate;
	}

	public void setRentOutStartDate(String rentOutStartDate) {
		this.rentOutStartDate = rentOutStartDate;
	}

	public String getRentOutEndDate() {
		return rentOutEndDate;
	}

	public void setRentOutEndDate(String rentOutEndDate) {
		this.rentOutEndDate = rentOutEndDate;
	}

	public int getRentOutId() {
		return rentOutId;
	}

	public void setRentOutId(int rentOutId) {
		this.rentOutId = rentOutId;
	}

	public int getRentOutPrice() {
		return rentOutPrice;
	}

	public void setRentOutPrice(int rentOutPrice) {
		this.rentOutPrice = rentOutPrice;
	}

	public int getRentInId() {
		return rentInId;
	}

	public void setRentInId(int rentInId) {
		this.rentInId = rentInId;
	}



	public int getRentInUserId() {
		return rentInUserId;
	}

	public void setRentInUserId(int rentInUserId) {
		this.rentInUserId = rentInUserId;
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

	public int getRentOutUserId() {
		return rentOutUserId;
	}

	public void setRentOutUserId(int rentOutUserId) {
		this.rentOutUserId = rentOutUserId;
	}
	@Override
	public String toString() {
		return "RentInComplainBean [rentOutId=" + rentOutId + ", rentInId=" + rentInId + ", rentInUserId="
				+ rentInUserId + ", userCarportAddress=" + userCarportAddress + ", userCarportAddressNo="
				+ userCarportAddressNo + ", rentOutStartDate=" + rentOutStartDate + ", rentOutEndDate=" + rentOutEndDate
				+ ", rentOutPrice=" + rentOutPrice + ", rentOutUserId=" + rentOutUserId + ", userCarportId="
				+ userCarportId + ", rentOutUserName=" + rentOutUserName + "]";
	}

}
