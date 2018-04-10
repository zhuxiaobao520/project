package com.cbd.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.cbd.validator.PhoneNo;

/**
 * 
 * <p>Title:AdminBean</p>
 * <p>Description: 管理员Bean</p>
 * @author 朱小宝
 * @date2018年1月29日下午1:46:01
 */
public class AdminBean {

	//管理员主键
	private int adminId;
	//管理员账号
	@Pattern(regexp="\\w{4,25}",message="用户名为4到25个字母、数字或下划线")
	private String adminAccount;
	
	//管理员密码
	@Pattern(regexp="^(?:\\d+|[a-zA-Z]+|[!@#$%^&*]+)${6,16}",message="密码中不能含有特殊字符，如：（《》<>{}[]）")
	private String adminPassword;
	
	//管理员类型（1为超级管理员，2为普通管理员）
	private int adminType;
	
	//管理员工号
	@Pattern(regexp="[0-9]*",message="工号不能有特殊字符，必须为数字")
	private String adminNo;
	
	//管理员真实姓名
	@Pattern(regexp="^[\\u4e00-\\u9fa5]*$",message="真实姓名只能填中文")
	private String adminRealName;
	
	//管理员电话
	@PhoneNo
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
		return "AdminBean [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPassword=" + adminPassword
				+ ", adminType=" + adminType + ", adminNo=" + adminNo + ", adminRealName=" + adminRealName
				+ ", adminPhone=" + adminPhone + ", admiUserManagerPower=" + admiUserManagerPower
				+ ", adminCarPortManagerPower=" + adminCarPortManagerPower + ", adminAgreementManagerPower="
				+ adminAgreementManagerPower + ", adminCompaintManagerPower=" + adminCompaintManagerPower + "]";
	}
	
	
}
