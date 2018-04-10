package com.cbd.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 车位管理bean
 * @author 刘芯宇
 *
 */
public class CarportBean {

	    private int cbdCartportId;//主键ID
		private int cbdCarportRenterCompanyId;//租车企业ID
		private String cbdCarportPropertityRight;//车位产权证编号
		private String cbdCarportAddress;//车位地址
		@NotEmpty
		private String cbdCarportAddressNo;//车位编号
		private int cbdCarportThirdAggremenId;//第三方合约ID
		private int cbdCarportRenterAgreementId;//租户合约ID
		@NotEmpty
		private String cbdCarporStartNo;//车位起始号
		private int cbdCarporSum;//车位总数
		public CarportBean() {
		}
		public int getCbdCartportId() {
			return cbdCartportId;
		}
		public void setCbdCartportId(int cbdCartportId) {
			this.cbdCartportId = cbdCartportId;
		}
		public int getCbdCarportRenterCompanyId() {
			return cbdCarportRenterCompanyId;
		}
		public void setCbdCarportRenterCompanyId(int cbdCarportRenterCompanyId) {
			this.cbdCarportRenterCompanyId = cbdCarportRenterCompanyId;
		}
		public String getCbdCarportPropertityRight() {
			return cbdCarportPropertityRight;
		}
		public void setCbdCarportPropertityRight(String cbdCarportPropertityRight) {
			this.cbdCarportPropertityRight = cbdCarportPropertityRight;
		}
		public String getCbdCarportAddress() {
			return cbdCarportAddress;
		}
		public void setCbdCarportAddress(String cbdCarportAddress) {
			this.cbdCarportAddress = cbdCarportAddress;
		}
		public String getCbdCarportAddressNo() {
			return cbdCarportAddressNo;
		}
		public void setCbdCarportAddressNo(String cbdCarportAddressNo) {
			this.cbdCarportAddressNo = cbdCarportAddressNo;
		}
		public int getCbdCarportThirdAggremenId() {
			return cbdCarportThirdAggremenId;
		}
		public void setCbdCarportThirdAggremenId(int cbdCarportThirdAggremenId) {
			this.cbdCarportThirdAggremenId = cbdCarportThirdAggremenId;
		}
		public int getCbdCarportRenterAgreementId() {
			return cbdCarportRenterAgreementId;
		}
		public void setCbdCarportRenterAgreementId(int cbdCarportRenterAgreementId) {
			this.cbdCarportRenterAgreementId = cbdCarportRenterAgreementId;
		}
	
		public String getCbdCarporStartNo() {
			return cbdCarporStartNo;
		}
		public void setCbdCarporStartNo(String cbdCarporStartNo) {
			this.cbdCarporStartNo = cbdCarporStartNo;
		}
		public int getCbdCarporSum() {
			return cbdCarporSum;
		}
		public void setCbdCarporSum(int cbdCarporSum) {
			this.cbdCarporSum = cbdCarporSum;
		}
		@Override
		public String toString() {
			return "CarportBean [cbdCartportId=" + cbdCartportId + ", cbdCarportRenterCompanyId="
					+ cbdCarportRenterCompanyId + ", cbdCarportPropertityRight=" + cbdCarportPropertityRight
					+ ", cbdCarportAddress=" + cbdCarportAddress + ", cbdCarportAddressNo=" + cbdCarportAddressNo
					+ ", cbdCarportThirdAggremenId=" + cbdCarportThirdAggremenId + ", cbdCarportRenterAgreementId="
					+ cbdCarportRenterAgreementId + ", cbdCarporStartNo=" + cbdCarporStartNo + ", cbdCarporSum="
					+ cbdCarporSum + "]";
		}
		
	
}
