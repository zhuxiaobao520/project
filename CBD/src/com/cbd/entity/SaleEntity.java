package com.cbd.entity;

import java.sql.Date;

/**
 * 出售信息实体类
 * @author 唐小雄
 *
 */
public class SaleEntity {

	private int saleId;						//id
	private double salePrice;				//出售价格
	private UsercarportEntity saleCarport;	//个人车位信息
	private Date salePublishTime;			//发布时间
	
	public SaleEntity() {
		super();
	}

	public SaleEntity(int saleId, double salePrice, UsercarportEntity saleCarport, Date salePublishTime) {
		super();
		this.saleId = saleId;
		this.salePrice = salePrice;
		this.saleCarport = saleCarport;
		this.salePublishTime = salePublishTime;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public UsercarportEntity getSaleCarport() {
		return saleCarport;
	}

	public void setSaleCarport(UsercarportEntity saleCarport) {
		this.saleCarport = saleCarport;
	}

	public Date getSalePublishTime() {
		return salePublishTime;
	}

	public void setSalePublishTime(Date salePublishTime) {
		this.salePublishTime = salePublishTime;
	}

	@Override
	public String toString() {
		return "SaleEntity [saleId=" + saleId + ", salePrice=" + salePrice + ", saleCarport=" + saleCarport
				+ ", salePublishTime=" + salePublishTime + "]";
	}
}
