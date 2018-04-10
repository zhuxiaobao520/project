package com.cbd.bean;

import java.util.List;



/**
 * 封装分页数据类
 * 
 * @author yg
 *
 */
public class Pager {
	private int pageSize = 5;// 页面记录数
	private int totalRecorNum;// 总记录
	private int totalPageNum;// 总页面数
	private int currentPage;// 当前页面
	private int startIndex;// 数据库其实位置
	private List datas;// 返回的分页数据
	public Pager() {
		super();
	}

	public Pager(int pageSize, int totalRecorNum, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecorNum = totalRecorNum;
		this.totalPageNum = totalRecorNum % pageSize == 0 ? (totalRecorNum / pageSize) : (totalRecorNum / pageSize + 1);
		if (currentPage > 1) {
			startIndex = (currentPage - 1) * pageSize;
		} else {
			startIndex = 0;
		}

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecorNum() {
		return totalRecorNum;
	}

	public void setTotalRecorNum(int totalRecorNum) {
		this.totalRecorNum = totalRecorNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", totalRecorNum=" + totalRecorNum + ", totalPageNum=" + totalPageNum
				+ ", currentPage=" + currentPage + ", startIndex=" + startIndex + ", datas=" + datas + "]";
	}

}
