package com.cbd.bean;

/**
 * 
 * <p>Title:reserveBuyBean</p>
 * <p>Description:预定买车位Bean</p>
 * @author 杨明健
 * @date2018年2月1日下午5:11:13
 */
public class ReserveBuyBean {
	/**
	 * 留言
	 */
	private String buyInfoMassage;
	/**
	 * 出售信息id
	 */
	private int buyInfoSaleId;
	/**
	 * 购买人id
	 */
	private int buyInfoUserId;
	/**
	 * 交易状态
	 */
	private String buyInfoStatus;
	/**
	 * 卖家id
	 */
	private int messageUserId;
	public String getBuyInfoMassage() {
		return buyInfoMassage;
	}
	public void setBuyInfoMassage(String buyInfoMassage) {
		this.buyInfoMassage = buyInfoMassage;
	}
	public int getBuyInfoSaleId() {
		return buyInfoSaleId;
	}
	public void setBuyInfoSaleId(int buyInfoSaleId) {
		this.buyInfoSaleId = buyInfoSaleId;
	}
	public int getBuyInfoUserId() {
		return buyInfoUserId;
	}
	public void setBuyInfoUserId(int buyInfoUserId) {
		this.buyInfoUserId = buyInfoUserId;
	}
	public String getBuyInfoStatus() {
		return buyInfoStatus;
	}
	public void setBuyInfoStatus(String buyInfoStatus) {
		this.buyInfoStatus = buyInfoStatus;
	}
	public int getMessageUserId() {
		return messageUserId;
	}
	public void setMessageUserId(int messageUserId) {
		this.messageUserId = messageUserId;
	}
	@Override
	public String toString() {
		return "reserveBuyBean [buyInfoMassage=" + buyInfoMassage + ", buyInfoSaleId=" + buyInfoSaleId
				+ ", buyInfoUserId=" + buyInfoUserId + ", buyInfoStatus=" + buyInfoStatus + ", messageUserId="
				+ messageUserId + "]";
	}
	
}
