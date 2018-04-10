package com.cbd.entity;

/**
 * 
 * <p>Title:AdminEntity</p>
 * <p>Description: 管理员实体类</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:45:31
 */
public class AdminEntity {

		//管理员主键
		private int adminId;
		//管理员账号
		private String adminAccount;
		//管理员密码
		private String adminPassword;
		//管理员类型（1为超级管理员，2为普通管理员）
		private int adminType;
		//管理员工号
		private String adminNo;
		//管理员真实姓名
		private String adminRealName;
		//管理员电话
		private String adminPhone;
		
		private int admiUserManagerPower;
		private int adminCarPortManagerPower;
		private int adminAgreementManagerPower;
		private int adminCompaintManagerPower;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public int getAdminType() {
		return adminType;
	}
	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminRealName() {
		return adminRealName;
	}
	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public int getAdmiUserManagerPower() {
		return admiUserManagerPower;
	}
	public void setAdmiUserManagerPower(int admiUserManagerPower) {
		this.admiUserManagerPower = admiUserManagerPower;
	}
	public int getAdminCarPortManagerPower() {
		return adminCarPortManagerPower;
	}
	public void setAdminCarPortManagerPower(int adminCarPortManagerPower) {
		this.adminCarPortManagerPower = adminCarPortManagerPower;
	}
	public int getAdminAgreementManagerPower() {
		return adminAgreementManagerPower;
	}
	public void setAdminAgreementManagerPower(int adminAgreementManagerPower) {
		this.adminAgreementManagerPower = adminAgreementManagerPower;
	}
	public int getAdminCompaintManagerPower() {
		return adminCompaintManagerPower;
	}
	public void setAdminCompaintManagerPower(int adminCompaintManagerPower) {
		this.adminCompaintManagerPower = adminCompaintManagerPower;
	}
	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPassword=" + adminPassword
				+ ", adminType=" + adminType + ", adminNo=" + adminNo + ", adminRealName=" + adminRealName
				+ ", adminPhone=" + adminPhone + ", admiUserManagerPower=" + admiUserManagerPower
				+ ", adminCarPortManagerPower=" + adminCarPortManagerPower + ", adminAgreementManagerPower="
				+ adminAgreementManagerPower + ", adminCompaintManagerPower=" + adminCompaintManagerPower + "]";
	}
	
	
}
