package com.cbd.bean;

import java.util.Date;

/**
 * 
 * 
 * <p>Title:CompanyCanRentCarport</p>
 * <p>Description:平台待租车位Bean </p>
 * @author 王菁
 * @date2018年2月2日上午11:22:40
 */

public class CompanyCanRentCarport {

	private String cbdCarportAddress;//车位地址
	
	private String cbdCarportAddressNo;//车位编号
	
	private String thirdAggrementEndTime;//最长可租日期

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

	public String getThirdAggrementEndTime() {
		return thirdAggrementEndTime;
	}

	public void setThirdAggrementEndTime(String thirdAggrementEndTime) {
		this.thirdAggrementEndTime = thirdAggrementEndTime;
	}

	@Override
	public String toString() {
		return "CompanyCanRentCarport [cbdCarportAddress=" + cbdCarportAddress + ", cbdCarportAddressNo="
				+ cbdCarportAddressNo + ", thirdAggrementEndTime=" + thirdAggrementEndTime + "]";
	}

	
}
