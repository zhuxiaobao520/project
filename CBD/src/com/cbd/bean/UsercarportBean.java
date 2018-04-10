package com.cbd.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <p>Title:UsercarportBean</p>
 * <p>Description:个人用户车位Bean</p>
 * @author 杨明健
 * @date2018年1月31日下午3:07:23
 */
public class UsercarportBean {
	/**
	 * 车位产权证编号
	 */
	private String userCarportPropertityRight;
	/**
	 * 车位所在小区地址
	 */
	private String userCarportAddress;		
	/**
	 * 小区车位编号
	 */
	private String userCarportAddressNo;			
	/**
	 * 上传车位产权证复印件Url
	 */
	private String userCarportImageUrl;
	/**
	 * 产品状态
	 */
	private String userCarportStatus;
	/**
	 * 审核状态（待审、通过、未通过）
	 */
	private String userCarportAuditingStatus;		
	/**
	 * 用户id
	 */
	private int userCarportUserId;
	
	public String getUserCarportPropertityRight() {
		return userCarportPropertityRight;
	}
	public void setUserCarportPropertityRight(String userCarportPropertityRight) {
		this.userCarportPropertityRight = userCarportPropertityRight;
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
	public String getUserCarportImageUrl() {
		return userCarportImageUrl;
	}
	public void setUserCarportImageUrl(String userCarportImageUrl) {
		this.userCarportImageUrl = userCarportImageUrl;
	}
	public String getUserCarportAuditingStatus() {
		return userCarportAuditingStatus;
	}
	public void setUserCarportAuditingStatus(String userCarportAuditingStatus) {
		this.userCarportAuditingStatus = userCarportAuditingStatus;
	}
	public int getUserCarportUserId() {
		return userCarportUserId;
	}
	public void setUserCarportUserId(int userCarportUserId) {
		this.userCarportUserId = userCarportUserId;
	}
	
	
	public String getUserCarportStatus() {
		return userCarportStatus;
	}
	public void setUserCarportStatus(String userCarportStatus) {
		this.userCarportStatus = userCarportStatus;
	}
	@Override
	public String toString() {
		return "UsercarportBean [userCarportPropertityRight=" + userCarportPropertityRight + ", userCarportAddress="
				+ userCarportAddress + ", userCarportAddressNo=" + userCarportAddressNo + ", userCarportImageUrl="
				+ userCarportImageUrl + ", userCarportStatus=" + userCarportStatus + ", userCarportAuditingStatus="
				+ userCarportAuditingStatus + ", userCarportUserId=" + userCarportUserId + "]";
	}
	
	
	
}
