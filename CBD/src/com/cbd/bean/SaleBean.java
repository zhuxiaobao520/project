package com.cbd.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;

/**
 * 
 * <p>Title:SaleBean</p>
 * <p>Description:出售信息Bean</p>
 * @author 杨明健
 * @date2018年1月31日下午1:39:07
 */
public class SaleBean {
	/**
	 * id
	 */
	private int saleCarportId;
	/**
	 * 出售价格
	 */
	private double salePrice;
	/**
	 * 页面的出售
	 */
	private String sellPrice;
	/**
	 * 发布时间
	 */
	private Date salePublishTime;
	public int getSaleCarportId() {
		return saleCarportId;
	}
	public void setSaleCarportId(int saleCarportId) {
		this.saleCarportId = saleCarportId;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Date getSalePublishTime() {
		return salePublishTime;
	}
	public void setSalePublishTime(Date salePublishTime) {
		this.salePublishTime = salePublishTime;
	}
	@Override
	public String toString() {
		return "SaleBean [saleCarportId=" + saleCarportId + ", salePrice=" + salePrice + ", sellPrice=" + sellPrice
				+ ", salePublishTime=" + salePublishTime + "]";
	}     
	
}
