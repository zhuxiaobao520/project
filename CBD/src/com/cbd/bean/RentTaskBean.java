package com.cbd.bean;

import com.cbd.entity.UserEntity;

/**
 * 
 * <p>Title:RentTaskBean</p>
 * <p>Description:待办租赁任务Bean</p>
 * @author 龙成
 * @date2018年2月1日上午10:27:25
 */
public class RentTaskBean {
	/**
	 * 车位小区地址
	 */
	private String userCarportAddress;
	
	/**
	 * 车位区域编号
	 */
	private String userCarportAddressNo;
	
	/**
	 * 车位id
	 */
	private int userCarportId;
	
	/**
	 * 租赁信息id
	 */
	private int rentInId;
	
	/**
	 * 招租信息id
	 */
	private int rentOutId;
	
	
	/**
	 * 租赁开始时间
	 */
	private String rentOutStartTime;
	
	
	/**
	 * 租赁结束时间
	 */
	private String rentOutEndTime;
	
	/**
	 * 出租价格
	 */
	private double rentOutPrice;
	
	/**
	 * 预约留言
	 */
	private String rentInMessage;
	
	/**
	 * 预约租赁人引用
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

	public String getRentOutStartTime() {
		return rentOutStartTime;
	}

	public void setRentOutStartTime(String rentOutStartTime) {
		this.rentOutStartTime = rentOutStartTime;
	}

	public String getRentOutEndTime() {
		return rentOutEndTime;
	}

	public void setRentOutEndTime(String rentOutEndTime) {
		this.rentOutEndTime = rentOutEndTime;
	}

	public double getRentOutPrice() {
		return rentOutPrice;
	}

	public void setRentOutPrice(double rentOutPrice) {
		this.rentOutPrice = rentOutPrice;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getRentInMessage() {
		return rentInMessage;
	}

	public void setRentInMessage(String rentInMessage) {
		this.rentInMessage = rentInMessage;
	}

	
	public int getUserCarportId() {
		return userCarportId;
	}

	public void setUserCarportId(int userCarportId) {
		this.userCarportId = userCarportId;
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

	@Override
	public String toString() {
		return "RentTaskBean [userCarportAddress=" + userCarportAddress + ", userCarportAddressNo="
				+ userCarportAddressNo + ", userCarportId=" + userCarportId + ", rentInId=" + rentInId + ", rentOutId="
				+ rentOutId + ", rentOutStartTime=" + rentOutStartTime + ", rentOutEndTime=" + rentOutEndTime
				+ ", rentOutPrice=" + rentOutPrice + ", rentInMessage=" + rentInMessage + ", userEntity=" + userEntity
				+ "]";
	}
}
