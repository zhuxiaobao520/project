package com.cbd.entity;

/**
 * 购买信息实体类
 * @author 唐小雄
 *
 */
public class BuyInfoEntity {

	private int buyInfoId;			//id
	private SaleEntity buyInfoSale;	//出售信息
	private UserEntity buyInfoUser;	//购买人
	private String buyInfoStatus;	//交易状态
	private String buyInfoMassage;	//留言 
	
	public BuyInfoEntity() {
		super();
	}

	public BuyInfoEntity(int buyInfoId, SaleEntity buyInfoSale, UserEntity buyInfoUser, String buyInfoStatus,
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

	public SaleEntity getBuyInfoSale() {
		return buyInfoSale;
	}

	public void setBuyInfoSale(SaleEntity buyInfoSale) {
		this.buyInfoSale = buyInfoSale;
	}

	public UserEntity getBuyInfoUser() {
		return buyInfoUser;
	}

	public void setBuyInfoUser(UserEntity buyInfoUser) {
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
