package com.cbd.entity;

import java.security.KeyStore.PrivateKeyEntry;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

/**
 * 个人用户实体类
 * @author yinshi
 * @date 2018年1月29日
 */
public class UserEntity {

	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 真实姓名
	 */
	private String userRealName;
	/**
	 * 家庭地址
	 */
	private String userAddress;
	/**
	 * 电话号码
	 */
	private String userPhone;
	/**
	 * 身份证号码
	 */
	private String userIdCard;
	/**
	 * 职业描述
	 */
	private String userProfession;
	/**
	 * 被投诉次数
	 */
	private int userComplainedCount;
	/**
	 * 个人邮箱
	 */
	private String userEmail;
	/**
	 * 信誉度
	 */
	private double userReputation;
	/**
	 * 交易次数
	 */
	private int userBussinessCount;
	/**
	 * 车位list请放这下面
	 */
	
	
	
	/**
	 * 无参构造
	 */
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 带参构造
	 * @param userName
	 * @param userPassword
	 * @param userRealName
	 * @param userAddress
	 * @param userPhone
	 * @param userIdCard
	 * @param userProfession
	 */
	public UserEntity(String userName, String userPassword, String userRealName, String userAddress, String userPhone,
			String userIdCard, String userProfession,String userEmail) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealName = userRealName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userIdCard = userIdCard;
		this.userProfession = userProfession;
		this.userEmail = userEmail;
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


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserRealName() {
		return userRealName;
	}


	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserIdCard() {
		return userIdCard;
	}


	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}


	public String getUserProfession() {
		return userProfession;
	}


	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}


	public int getUserComplainedCount() {
		return userComplainedCount;
	}


	public void setUserComplainedCount(int userComplainedCount) {
		this.userComplainedCount = userComplainedCount;
	}


	public double getUserReputation() {
		return userReputation;
	}


	public void setUserReputation(double userReputation) {
		this.userReputation = userReputation;
	}


	public int getUserBussinessCount() {
		return userBussinessCount;
	}

	public void setUserBussinessCount(int userBussinessCount) {
		this.userBussinessCount = userBussinessCount;
	}

	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userRealName=" + userRealName + ", userAddress=" + userAddress + ", userPhone=" + userPhone
				+ ", userIdCard=" + userIdCard + ", userProfession=" + userProfession + ", userComplainedCount="
				+ userComplainedCount + ", userEmail=" + userEmail + ", userReputation=" + userReputation
				+ ", userBussinessCount=" + userBussinessCount + "]";
	}



	
	
	
	
	
}
