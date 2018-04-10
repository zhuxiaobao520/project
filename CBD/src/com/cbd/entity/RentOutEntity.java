package com.cbd.entity;

/**
 * 
 * <p>Title:RentOutEntity</p>
 * <p>Description:招租信息实体类</p>
 * @author 龙成
 * @date2018年2月1日下午3:19:16
 */

public class RentOutEntity {
	/** 招租信息主键标识 */
	private int rentOutId;
	/** 招租价格 */
	private double rentOutPrice;
	/** 招租开始时间 */
	private String rentOutStartTime;
	/** 招租结束时间 */
	private String rentOutEndTime;
	/** 招租车位引用 */
	private UsercarportEntity usercarportEntity;
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
	public UsercarportEntity getUsercarportEntity() {
		return usercarportEntity;
	}
	public void setUsercarportEntity(UsercarportEntity usercarportEntity) {
		this.usercarportEntity = usercarportEntity;
	}
	@Override
	public String toString() {
		return "RentOutEntity [rentOutId=" + rentOutId + ", rentOutPrice=" + rentOutPrice + ", rentOutStartTime="
				+ rentOutStartTime + ", rentOutEndTime=" + rentOutEndTime + ", usercarportEntity=" + usercarportEntity
				+ "]";
	}
	
}
