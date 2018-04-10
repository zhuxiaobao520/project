package com.cbd.bean;

/**
 * 日志bean
 * @author yg
 *
 */
public class LogBean {
	private int logId;
	private String logAccount;
	private String logTime;
	private String logIp;
	/**
	 * 登录、注销、数据库操作
	 */
	private String logOperationType;//
	/**
	 * 前台/后台
	 */
	private String logType;
	private String logOperationContent;
	public LogBean() {
		// TODO Auto-generated constructor stub
	}
	public LogBean(int logId, String logAccount, String logTime, String logIp, String logOperationType, String logType,
			String logOperationContent) {
		super();
		this.logId = logId;
		this.logAccount = logAccount;
		this.logTime = logTime;
		this.logIp = logIp;
		this.logOperationType = logOperationType;
		this.logType = logType;
		this.logOperationContent = logOperationContent;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getLogAccount() {
		return logAccount;
	}
	public void setLogAccount(String logAccount) {
		this.logAccount = logAccount;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getLogIp() {
		return logIp;
	}
	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}
	public String getLogOperationType() {
		return logOperationType;
	}
	public void setLogOperationType(String logOperationType) {
		this.logOperationType = logOperationType;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getLogOperationContent() {
		return logOperationContent;
	}
	public void setLogOperationContent(String logOperationContent) {
		this.logOperationContent = logOperationContent;
	}
	@Override
	public String toString() {
		return "LogBean [logId=" + logId + ", logAccount=" + logAccount + ", logTime=" + logTime + ", logIp=" + logIp
				+ ", logOperationType=" + logOperationType + ", logType=" + logType + ", logOperationContent="
				+ logOperationContent + "]";
	}
	
	
	
	
}
