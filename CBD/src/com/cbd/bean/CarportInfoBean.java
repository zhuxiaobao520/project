package com.cbd.bean;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 模糊查询bean
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
public class CarportInfoBean {
    
	private String site;//车位地址
	private  String  number;//车位编号
	private  int curPage;//翻页当前页
	private int size;//每页显示条数
	private String status;//车位状态
	private int startIndex;//开始条数
	public CarportInfoBean() {
	
	}

	public CarportInfoBean(String site, String number, int curPage, int size,int startIndex ,String status) {
		this.site = site;
		this.number = number;
		this.curPage = curPage;
		this.size = size;
		this.status = status;	
	    this.startIndex =startIndex;
	
	}

	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "CarportInfoBean [site=" + site + ", number=" + number + ", curPage=" + curPage + ", size=" + size
				+ ", status=" + status + ", startIndex=" + startIndex + "]";
	}
}
