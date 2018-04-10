package com.cbd.bean;

import java.util.Date;

/**
 * 
 * 
 * <p>Title:CompanyRentCarportBean</p>
 * <p>Description:企业已租车位Bean </p>
 * @author 王菁
 * @date2018年2月2日上午10:05:53
 */

public class CompanyRentCarport {
	
	private String cbdCarportAddress;//车位地址
	
	private String cbdCarportAddressNo;//车位编号
	
	private String renterAgreementNewNo;//现合约编号
	
	private String renterAgreementStartTime;//合约生效时间
	
	private String renterAgreementEndTime;//合约截止时间

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

	public String getRenterAgreementNewNo() {
		return renterAgreementNewNo;
	}

	public void setRenterAgreementNewNo(String renterAgreementNewNo) {
		this.renterAgreementNewNo = renterAgreementNewNo;
	}

	public String getRenterAgreementStartTime() {
		return renterAgreementStartTime;
	}

	public void setRenterAgreementStartTime(String renterAgreementStartTime) {
		this.renterAgreementStartTime = renterAgreementStartTime;
	}

	public String getRenterAgreementEndTime() {
		return renterAgreementEndTime;
	}

	public void setRenterAgreementEndTime(String renterAgreementEndTime) {
		this.renterAgreementEndTime = renterAgreementEndTime;
	}

	@Override
	public String toString() {
		return "CompanyRentCarportBean [cbdCarportAddress=" + cbdCarportAddress + ", cbdCarportAddressNo="
				+ cbdCarportAddressNo + ", renterAgreementNewNo=" + renterAgreementNewNo + ", renterAgreementStartTime="
				+ renterAgreementStartTime + ", renterAgreementEndTime=" + renterAgreementEndTime + "]";
	}
	
	
	
}
