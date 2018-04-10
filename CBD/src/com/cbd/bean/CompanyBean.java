package com.cbd.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.cbd.util.UseMD5;
import com.cbd.validator.PhoneNo;

/**
 * 企业用户Bean
 * @author 张同学
 *
 */
public class CompanyBean {
	
		private  int companyId; //id
		
		@Pattern(regexp="\\w{4,25}",message="企业登录名为4到25个字母、数字或下划线")
		private String companyAccount; //企业登录名
		
		@Pattern(regexp="\\w{6,16}",message="密码为6到16个字母、数字或下划线")
		private String companyPassword;//企业登录密码
		
		@Pattern(regexp="^[\\u4e00-\\u9fa5a-zA-Z0-9]*$",message="企业名称输入不符合规范")
		private String companyName;//企业名称
		
		@Pattern(regexp="^[\\u4e00-\\u9fa5-—,.，。、！!‘’“”''\"\"a-zA-Z0-9]*$",message="企业地址输入不符合规范")
		private String companyAddress;//企业楼层
		
		@Pattern(regexp="^[\\u4e00-\\u9fa5]*$|^[a-zA-Z]*$",message="企业联系人只能填纯中文或者纯英文")
		private String companyLinkMan;//企业联系人
		
		@PhoneNo
		private String companyPhone;//企业联系电话
		
		public CompanyBean() {
			super();
		}
		public CompanyBean(int companyId, String companyAccount, String companyPassword, String companyName,
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
			return "CompanyBean [companyId=" + companyId + ", companyAccount=" + companyAccount + ", companyPassword="
					+ companyPassword + ", companyName=" + companyName + ", companyAddress=" + companyAddress
					+ ", companyLinkMan=" + companyLinkMan + ", companyPhone=" + companyPhone + "]";
		}
		

				
}	
