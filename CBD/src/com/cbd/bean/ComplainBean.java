package com.cbd.bean;

import com.cbd.entity.UserEntity;

/**
 * 
 * <p>Title:ComplainBean</p>
 * <p>Description: 投诉信息Bean</p>
 * @author 朱小宝
 * @date2018年2月1日下午2:29:48
 */
public class ComplainBean {

	private int complainId;
	//投诉者
	private UserEntity complainUser;
	//被投诉者
	private UserEntity complainedUser;
	//投诉事件id
	private int complainEventId;
	//投诉类型（租赁、买卖）
	private String complainEventType;
	//投诉状态
	private String complainStatus;
	//投诉时间
	private String complainTime;
	//投诉理由
	private String complainMessage;
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public UserEntity getComplainUser() {
		return complainUser;
	}
	public void setComplainUser(UserEntity complainUser) {
		this.complainUser = complainUser;
	}
	public UserEntity getComplainedUser() {
		return complainedUser;
	}
	public void setComplainedUser(UserEntity complainedUser) {
		this.complainedUser = complainedUser;
	}
	public int getComplainEventId() {
		return complainEventId;
	}
	public void setComplainEventId(int complainEventId) {
		this.complainEventId = complainEventId;
	}
	public String getComplainEventType() {
		return complainEventType;
	}
	public void setComplainEventType(String complainEventType) {
		this.complainEventType = complainEventType;
	}
	public String getComplainStatus() {
		return complainStatus;
	}
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	
	public String getComplainTime() {
		return complainTime;
	}
	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}
	
	public String getComplainMessage() {
		return complainMessage;
	}
	public void setComplainMessage(String complainMessage) {
		this.complainMessage = complainMessage;
	}
	@Override
	public String toString() {
		return "ComplainBean [complainId=" + complainId + ", complainUser=" + complainUser + ", complainedUser="
				+ complainedUser + ", complainEventId=" + complainEventId + ", complainEventType=" + complainEventType
				+ ", complainStatus=" + complainStatus + "]";
	}
	
	
}
