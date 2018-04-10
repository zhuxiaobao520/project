package com.cbd.bean;

import java.util.Date;

/**
 * 用于插入投诉记录的bean
 * @author 姚刚
 * @date 2018年2月2日
 */
public class ComplainInsertBean {
	private int complainUserId;//投诉人id当前用户
	private int complainedUserId;//被投诉人id
	private int complainEventId;//投诉的交易记录的
	private String complainEventType;///招租、租赁、出售/购买
	private String complainStatus;//投诉状态：投诉生效/投诉无效/暂缓处理/未处理
	private String complainMessage;//投诉理由
	private Date complainTime;//投诉时间
	
	public ComplainInsertBean() {
		// TODO Auto-generated constructor stub
	}

	public ComplainInsertBean(int complainUserId, int complainedUserId, int complainEventId, String complainEventType,
			String complainStatus, String complainMessage, Date complainTime) {
		super();
		this.complainUserId = complainUserId;
		this.complainedUserId = complainedUserId;
		this.complainEventId = complainEventId;
		this.complainEventType = complainEventType;
		this.complainStatus = complainStatus;
		this.complainMessage = complainMessage;
		this.complainTime = complainTime;
	}

	public int getComplainUserId() {
		return complainUserId;
	}

	public void setComplainUserId(int complainUserId) {
		this.complainUserId = complainUserId;
	}

	public int getComplainedUserId() {
		return complainedUserId;
	}

	public void setComplainedUserId(int complainedUserId) {
		this.complainedUserId = complainedUserId;
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

	public String getComplainMessage() {
		return complainMessage;
	}

	public void setComplainMessage(String complainMessage) {
		this.complainMessage = complainMessage;
	}

	public Date getComplainTime() {
		return complainTime;
	}

	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}

	@Override
	public String toString() {
		return "ComplainInsertBean [complainUserId=" + complainUserId + ", complainedUserId=" + complainedUserId
				+ ", complainEventId=" + complainEventId + ", complainEventType=" + complainEventType
				+ ", complainStatus=" + complainStatus + ", complainMessage=" + complainMessage + ", complainTime="
				+ complainTime + "]";
	}
	
}
