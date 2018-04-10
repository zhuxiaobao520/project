package com.cbd.bean;

/**
 * 用于向租赁记录表插入数据的bean
 * @author 姚刚
 * @date 2018年2月1日
 */
public class RentInInsertBean {
	private int rentInId;
	private int rentOutId;
	private int rentInUserId;
	private String rentInMessage;
	public RentInInsertBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RentInInsertBean(int rentOutId, int rentInUserId, String rentInMessage) {
		super();
		this.rentOutId = rentOutId;
		this.rentInUserId = rentInUserId;
		this.rentInMessage = rentInMessage;
	}


	public int getRentOutId() {
		return rentOutId;
	}
	public void setRentOutId(int rentOutId) {
		this.rentOutId = rentOutId;
	}
	public int getRentInUserId() {
		return rentInUserId;
	}
	public void setRentInUserId(int rentInUserId) {
		this.rentInUserId = rentInUserId;
	}
	public String getRentInMessage() {
		return rentInMessage;
	}
	public void setRentInMessage(String rentInMessage) {
		this.rentInMessage = rentInMessage;
	}


	public int getRentInId() {
		return rentInId;
	}


	public void setRentInId(int rentInId) {
		this.rentInId = rentInId;
	}
}
