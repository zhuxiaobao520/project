package com.cbd.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 出租记录bean
 * 
 * @author 姚刚
 * @date 2018年1月31日
 */
public class RentOutBean {
	private int rentOutId;
	private int rentInId;
	
	private String userCarportAddress;
	private String userCarportAddressNo;
	private Date rentOutStartTime;
	private Date rentOutEndTime;
	private String rentOutStartDate;
	private String rentOutEndDate;
	private int rentOutPrice;
	/**
	 * 租户名
	 */
	private int rentInUserId;
	private String rentInUserName;

	private String rentInStatus;
	
	private int userCarportId;
	
	
	private String rentOutUserName;
	
	private String rentInMessage;

	public RentOutBean() {
		// TODO Auto-generated constructor stub
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

	public String getRentInUserName() {
		return rentInUserName;
	}

	public void setRentInUserName(String rentInUserName) {
		this.rentInUserName = rentInUserName;
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

	public String getRentInStatus() {
		return rentInStatus;
	}

	public void setRentInStatus(String rentInStatus) {
		this.rentInStatus = rentInStatus;
	}

	public int getRentInUserId() {
		return rentInUserId;
	}

	public void setRentInUserId(int rentInUserId) {
		this.rentInUserId = rentInUserId;
	}

	@Override
	public String toString() {
		return "RentOutBean [rentOutId=" + rentOutId + ", rentInId=" + rentInId + ", userCarportAddress="
				+ userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo + ", rentOutStartDate="
				+ rentOutStartDate + ", rentOutEndDate=" + rentOutEndDate + ", rentOutPrice=" + rentOutPrice
				+ ", rentInUserId=" + rentInUserId + ", rentInUserName=" + rentInUserName + ", rentInStatus="
				+ rentInStatus + "rentInMessage"+rentInMessage+"]";
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

	public String getRentInMessage() {
		return rentInMessage;
	}

	public void setRentInMessage(String rentInMessage) {
		this.rentInMessage = rentInMessage;
	}

}
