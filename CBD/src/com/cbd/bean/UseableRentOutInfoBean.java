package com.cbd.bean;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 可用待租车位信息
 * 包含车位id，地址，编号
 * 出租信息主键，起始时间，结束时间，出租价格
 * 出租人id，职业，信誉度
 * @author 姚刚
 * @date 2018年2月1日
 */
public class UseableRentOutInfoBean {
	private int rentOutId;
	private double rentOutPrice;
	private Date rentOutStartTime;
	private Date rentOutEndTime;
	private int rentOutCarportId;
	private String userCarportAddress;
	private String userCarportAddressNo;
	private int userId;
	private String userName;
	private String userProfession;
	private String userPhone;
	private double userReputation;
	
	private String rentOutStartDate;
	private String rentOutEndDate;
	/**
	 * 	•待租车位信息：车位所在小区地址+小区车位编号（如成都市天府一街12号中海兰亭小区E023车位）
	•租借开始时间：（如:2014年11月25日18时4分）
	•租借结束时间：（如:2015年11月25日18时4分）
	•用户名：（如:我是招租车位的）
	•职业：（如：家庭主妇、自由职业者）
	•信誉度：投诉次数/交易次数（如：2/17）
	•出租价格：（如280元/月）
	 */
	public UseableRentOutInfoBean() {
		// TODO Auto-generated constructor stub
	}
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
	public Date getRentOutStartTime() {
		return rentOutStartTime;
	}
	public void setRentOutStartTime(Date rentOutStartTime) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(rentOutStartTime!=null){
			rentOutStartDate=simpleDateFormat.format(rentOutStartTime);
		}
		this.rentOutStartTime = rentOutStartTime;
	}
	public Date getRentOutEndTime() {
		return rentOutEndTime;
	}
	public void setRentOutEndTime(Date rentOutEndTime) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(rentOutEndTime!=null){
			rentOutEndDate=simpleDateFormat.format(rentOutEndTime);
		}
		this.rentOutEndTime = rentOutEndTime;
	}
	public int getRentOutCarportId() {
		return rentOutCarportId;
	}
	public void setRentOutCarportId(int rentOutCarportId) {
		this.rentOutCarportId = rentOutCarportId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserProfession() {
		return userProfession;
	}
	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}
	public double getUserReputation() {
		return userReputation;
	}
	public void setUserReputation(double userReputation) {
		this.userReputation = userReputation;
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
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "UseableRentOutInfoBean [rentOutId=" + rentOutId + ", rentOutPrice=" + rentOutPrice
				+ ", rentOutCarportId=" + rentOutCarportId + ", userCarportAddress=" + userCarportAddress
				+ ", userCarportAddressNo=" + userCarportAddressNo + ", userId=" + userId + ", userName=" + userName
				+ ", userProfession=" + userProfession + ", userPhone=" + userPhone + ", userReputation="
				+ userReputation + ", rentOutStartDate=" + rentOutStartDate + ", rentOutEndDate=" + rentOutEndDate
				+ "]";
	}
	
	
	
}
