package com.cbd.entity;

/**
 * 用户车位实体类
 * @author 唐小雄
 *
 */
public class UsercarportEntity {

	private int userCarportId;						//id
	private String userCarportPropertityRight;		//车位产权证编号
	private String userCarportAddress;				//车位所在小区地址
	private String userCarportAddressNo;			//小区车位编号
	private String userCarportImageUrl;				//上传车位产权证复印件Url
	private String userCarportAuditingStatus;		//审核状态（待审、通过、未通过）
	private String userCarportStatus;				//车位状态
	private UserEntity user;							//用户外键
	
	public UsercarportEntity() {
		super();
	}

	public UsercarportEntity(int userCarportId, String userCarportPropertityRight, String userCarportAddress,
			String userCarportAddressNo, String userCarportImageUrl, String userCarportAuditingStatus,
			String userCarportStatus, UserEntity user) {
		super();
		this.userCarportId = userCarportId;
		this.userCarportPropertityRight = userCarportPropertityRight;
		this.userCarportAddress = userCarportAddress;
		this.userCarportAddressNo = userCarportAddressNo;
		this.userCarportImageUrl = userCarportImageUrl;
		this.userCarportAuditingStatus = userCarportAuditingStatus;
		this.userCarportStatus = userCarportStatus;
		this.user = user;
	}

	public int getUserCarportId() {
		return userCarportId;
	}

	public void setUserCarportId(int userCarportId) {
		this.userCarportId = userCarportId;
	}

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

	public String getUserCarportStatus() {
		return userCarportStatus;
	}

	public void setUserCarportStatus(String userCarportStatus) {
		this.userCarportStatus = userCarportStatus;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsercarportBean [userCarportId=" + userCarportId + ", userCarportPropertityRight="
				+ userCarportPropertityRight + ", userCarportAddress=" + userCarportAddress + ", userCarportAddressNo="
				+ userCarportAddressNo + ", userCarportImageUrl=" + userCarportImageUrl + ", userCarportAuditingStatus="
				+ userCarportAuditingStatus + ", userCarportStatus=" + userCarportStatus + ", user=" + user + "]";
	}

}
