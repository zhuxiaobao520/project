package com.cbd.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 租赁信息的bean
 * 
 * @author yg
 *
 */
public class RentInBean {
	private int rentInId;
	private String userCarportAddress;
	private String userCarportAddressNo;
	private Date rentOutStartTime;
	private Date rentOutEndTime;
	private String rentOutStartDate;
	private String rentOutEndDate;
	private String rentOutUserName;
	private int rentOutPrice;

	public RentInBean() {
		// TODO Auto-generated constructor stub
	}

	public int getRentInId() {
		return rentInId;
	}

	public void setRentInId(int rentInId) {
		this.rentInId = rentInId;
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

	public String getRentOutStartDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (rentOutStartTime != null) {
			rentOutStartDate = simpleDateFormat.format(rentOutStartTime);
		}
		return rentOutStartDate;
	}

	public void setRentOutStartDate(String rentOutStartDate) {
		this.rentOutStartDate = rentOutStartDate;
	}

	public String getRentOutEndDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (rentOutEndTime != null) {
			rentOutEndDate = simpleDateFormat.format(rentOutEndTime);
		}
		return rentOutEndDate;
	}

	public void setRentOutEndDate(String rentOutEndDate) {
		this.rentOutEndDate = rentOutEndDate;
	}



	public int getRentOutPrice() {
		return rentOutPrice;
	}

	public void setRentOutPrice(int rentOutPrice) {
		this.rentOutPrice = rentOutPrice;
	}

	public String getRentOutUserName() {
		return rentOutUserName;
	}

	public void setRentOutUserName(String rentOutUserName) {
		this.rentOutUserName = rentOutUserName;
	}

	@Override
	public String toString() {
		return "RentInBean [rentInId=" + rentInId + ", userCarportAddress=" + userCarportAddress
				+ ", userCarportAddressNo=" + userCarportAddressNo + ", rentOutStartTime=" + rentOutStartTime
				+ ", rentOutEndTime=" + rentOutEndTime + ", rentOutStartDate=" + rentOutStartDate + ", rentOutEndDate="
				+ rentOutEndDate + ", rentOutUserName=" + rentOutUserName + ", rentOutPrice=" + rentOutPrice + "]";
	}
	

}
