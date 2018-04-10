package com.cbd.bean;

import java.util.Date;

/**
 * 用于插入数据库的出租记录bean
 * @author 姚刚
 * @date 2018年2月1日
 */
public class RentOutInsertBean {
	private double rentOutPrice;
	private int rentOutCarportId;
	private Date rentOutStartTime;
	private Date rentOutEndTime;
	public RentOutInsertBean(double rentOutPrice, int rentOutCarportId, Date rentOutStartTime, Date rentOutEndTime) {
		super();
		this.rentOutPrice = rentOutPrice;
		this.rentOutCarportId = rentOutCarportId;
		this.rentOutStartTime = rentOutStartTime;
		this.rentOutEndTime = rentOutEndTime;
	}
	public RentOutInsertBean() {
	}
	public double getRentOutPrice() {
		return rentOutPrice;
	}
	public void setRentOutPrice(double rentOutPrice) {
		this.rentOutPrice = rentOutPrice;
	}
	public int getRentOutCarportId() {
		return rentOutCarportId;
	}
	public void setRentOutCarportId(int rentOutCarportId) {
		this.rentOutCarportId = rentOutCarportId;
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
	@Override
	public String toString() {
		return "RentOutInsertBean [rentOutPrice=" + rentOutPrice + ", rentOutCarportId=" + rentOutCarportId
				+ ", rentOutStartTime=" + rentOutStartTime + ", rentOutEndTime=" + rentOutEndTime + "]";
	}
	
	
}
