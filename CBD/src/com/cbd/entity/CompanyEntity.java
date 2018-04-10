package com.cbd.entity;

/**
 * 企业用户实体类
 * @author 张平
 *
 */
public class CompanyEntity {
	
			private  int companyId; //id
			private String companyAccount; //企业登录名
			private String companyPassword;//企业登录密码
			private String companyName;//企业名称
			private String companyAddress;//企业楼层
			private String companyLinkMan;//企业联系人
			private String companyPhone;//企业联系电话
			
			//无参构造
			public CompanyEntity() {
				super();
			}

			//带参数构造
			public CompanyEntity(int companyId, String companyAccount, String companyPassword, String companyName,
					String companyAddress, String companyLinkMan, String companyPhone) {
				super();
				this.companyId = companyId;
				this.companyAccount = companyAccount;
				this.companyPassword = companyPassword;
				this.companyName = companyName;
				this.companyAddress = companyAddress;
				this.companyLinkMan = companyLinkMan;
				this.companyPhone = companyPhone;
			}

			public int getCompanyId() {
				return companyId;
			}

			public void setCompanyId(int companyId) {
				this.companyId = companyId;
			}

			public String getCompanyAccount() {
				return companyAccount;
			}

			public void setCompanyAccount(String companyAccount) {
				this.companyAccount = companyAccount;
			}

			public String getCompanyPassword() {
				return companyPassword;
			}

			public void setCompanyPassword(String companyPassword) {
				this.companyPassword = companyPassword;
			}

			public String getCompanyName() {
				return companyName;
			}

			public void setCompanyName(String companyName) {
				this.companyName = companyName;
			}

			public String getCompanyAddress() {
				return companyAddress;
			}

			public void setCompanyAddress(String companyAddress) {
				this.companyAddress = companyAddress;
			}

			public String getCompanyLinkMan() {
				return companyLinkMan;
			}

			public void setCompanyLinkMan(String companyLinkMan) {
				this.companyLinkMan = companyLinkMan;
			}

			public String getCompanyPhone() {
				return companyPhone;
			}

			public void setCompanyPhone(String companyPhone) {
				this.companyPhone = companyPhone;
			}

			@Override
			public String toString() {
				return "CompanyEntity [companyId=" + companyId + ", companyAccount=" + companyAccount
						+ ", companyPassword=" + companyPassword + ", companyName=" + companyName + ", companyAddress="
						+ companyAddress + ", companyLinkMan=" + companyLinkMan + ", companyPhone=" + companyPhone
						+ "]";
			}
			
			
			
}
