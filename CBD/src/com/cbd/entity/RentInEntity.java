package com.cbd.entity;

/**
 * 
 * <p>Title:RentInEntity</p>
 * <p>Description:租赁信息实体类</p>
 * @author 龙成
 * @date2018年2月1日下午8:40:46
 */
public class RentInEntity {
	/** 租赁信息主键 */
	private int rentInId;
	/** 招租信息引用 */
	private RentOutEntity rentOutEntity;
	/** 租赁者引用 */
	private UserEntity userEntity;
	/** 租赁信息状态 */
	private String rentInStatus;
	/** 租赁者留言 */
	private String rentInMessage;
	public int getRentInId() {
		return rentInId;
	}
	public void setRentInId(int rentInId) {
		this.rentInId = rentInId;
	}
	public RentOutEntity getRentOutEntity() {
		return rentOutEntity;
	}
	public void setRentOutEntity(RentOutEntity rentOutEntity) {
		this.rentOutEntity = rentOutEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public String getRentInStatus() {
		return rentInStatus;
	}
	public void setRentInStatus(String rentInStatus) {
		this.rentInStatus = rentInStatus;
	}
	public String getRentInMessage() {
		return rentInMessage;
	}
	public void setRentInMessage(String rentInMessage) {
		this.rentInMessage = rentInMessage;
	}
	@Override
	public String toString() {
		return "RentInEntity [rentInId=" + rentInId + ", rentOutEntity=" + rentOutEntity + ", userEntity=" + userEntity
				+ ", rentInStatus=" + rentInStatus + ", rentInMessage=" + rentInMessage + "]";
	}
}
