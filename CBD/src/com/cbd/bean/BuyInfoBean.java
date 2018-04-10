package com.cbd.bean;

/**
 * 购买信息Bean
 * @author 唐小雄
 *
 */
public class BuyInfoBean {

	private int buyInfoId;			//id
	private SaleBean buyInfoSale;	//出售信息
	private UserBean buyInfoUser;	//购买人
	private String buyInfoStatus;	//交易状态
	private String buyInfoMassage;	//留言 
	
	public BuyInfoBean() {
		super();
	}

	public BuyInfoBean(int buyInfoId, SaleBean buyInfoSale, UserBean buyInfoUser, String buyInfoStatus,
			String buyInfoMassage) {
		super();
		this.buyInfoId = buyInfoId;
		this.buyInfoSale = buyInfoSale;
		this.buyInfoUser = buyInfoUser;
		this.buyInfoStatus = buyInfoStatus;
		this.buyInfoMassage = buyInfoMassage;
	}

	public int getBuyInfoId() {
		return buyInfoId;
	}

	public void setBuyInfoId(int buyInfoId) {
		this.buyInfoId = buyInfoId;
	}

	public SaleBean getBuyInfoSale() {
		return buyInfoSale;
	}

	public void setBuyInfoSale(SaleBean buyInfoSale) {
		this.buyInfoSale = buyInfoSale;
	}

	public UserBean getBuyInfoUser() {
		return buyInfoUser;
	}

	public void setBuyInfoUser(UserBean buyInfoUser) {
		this.buyInfoUser = buyInfoUser;
	}

	public String getBuyInfoStatus() {
		return buyInfoStatus;
	}

	public void setBuyInfoStatus(String buyInfoStatus) {
		this.buyInfoStatus = buyInfoStatus;
	}

	public String getBuyInfoMassage() {
		return buyInfoMassage;
	}

	public void setBuyInfoMassage(String buyInfoMassage) {
		this.buyInfoMassage = buyInfoMassage;
	}

	@Override
	public String toString() {
		return "BuyInfoEntity [buyInfoId=" + buyInfoId + ", buyInfoSale=" + buyInfoSale + ", buyInfoUser=" + buyInfoUser
				+ ", buyInfoStatus=" + buyInfoStatus + ", buyInfoMassage=" + buyInfoMassage + "]";
	}
	
}
