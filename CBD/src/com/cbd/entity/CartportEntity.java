package com.cbd.entity;
/**
 * 平台车辆管理实体类
 * @author 刘芯宇
 *
 */
public class CartportEntity {

    private int cbdCartportId;//主键ID
	private int cbdCarportRenterCompanyId;//租车企业ID
	private String cbdCarportPropertityRight;//车位产权证编号
	private String cbdCarportAddress;//车位地址
	private String cbdCarportAddressNo;//车位编号
	private int cbdCarportThirdAggremenId;//第三方合约ID
	private int cbdCarportRenterAgreementId;//租户合约ID
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
	@Override
	public String toString() {
		return "CartportEntity [cbdCartportId=" + cbdCartportId + ", cbdCarportRenterCompanyId="
				+ cbdCarportRenterCompanyId + ", cbdCarportPropertityRight=" + cbdCarportPropertityRight
				+ ", cbdCarportAddress=" + cbdCarportAddress + ", cbdCarportAddressNo=" + cbdCarportAddressNo
				+ ", cbdCarportThirdAggremenId=" + cbdCarportThirdAggremenId + ", cbdCarportRenterAgreementId="
				+ cbdCarportRenterAgreementId + "]";
	}
	

}
