package com.cbd.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.cbd.validator.PhoneNo;
import com.cbd.validator.uniqueUsername;

public class UserBean {
	
	/**
	 * 个人用户bean类
	 * @author yinshi
	 * @date 2018年1月29日
	 */

		/**
		 * 用户id
		 */
		private int userId;
		/**
		 * 用户名
		 */
		@Pattern(regexp="\\w{4,25}",message="用户名为4到25个字母，数字或下划线")
		@uniqueUsername //用户名唯一的校验
		private String userName;
		/**
		 * 密码
		 */
		@Pattern(regexp="[0-9a-zA-z,.'*`]{6,12}",message="密码中不能含有空格或特殊字符，如：（@#$%^&*<>,./\\[]{}）等")
		private String userPassword;
		/**
		 * 真实姓名
		 */
		@Pattern(regexp="^[\\u4e00-\\u9fa5]*$|^[a-zA-Z]*$",message="真实姓名只能填纯中文或者纯英文")
		private String userRealName;
		/**
		 * 家庭地址
		 */
		@Pattern(regexp="^[\\u4e00-\\u9fa5-—,.，。、！!‘’“”''\"\"a-zA-Z0-9]*$",message="家庭地址输入不符合规范")
		private String userAddress;
		/**
		 * 电话号码
		 */
		@PhoneNo
		private String userPhone;
		/**
		 * 身份证号码
		 */
		@Pattern(regexp="[1-9][0-9]{16}[0-9xX]{1}",message="请输入有效的身份证号码")
		private String userIdCard;
		/**
		 * 职业描述
		 */
		@Pattern(regexp="^[\\u4e00-\\u9fa5-—,.，。、！!‘’“”''\"\"a-zA-Z0-9]*$",message="职业描述输入不符合规范")
		private String userProfession;
		/**
		 * 被投诉次数
		 */
		private int userComplainedCount;
		/**
		 * 个人邮箱
		 */
		@Pattern(regexp="^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$",message="邮箱格式不正确")
		private String userEmail;

		/**
		 * 信誉度
		 */
		private double userReputation;
		/**
		 * 交易次数
		 */
		private int userBussinessCount;
		/**
		 * 车位list请放这下面
		 */
		
		
		
		
		/**
		 * 无参构造
		 */
		public UserBean() {
			// TODO Auto-generated constructor stub
			
		}
		
		
		/**
		 * 
		 * @param userName
		 * @param userPassword
		 * @param userRealName
		 * @param userAddress
		 * @param userPhone
		 * @param userIdCard
		 * @param userProfession
		 * @param userComplainedCount
		 * @param userEmail
		 * @param userReputation
		 * @param userBussinessCount
		 */
		public UserBean(String userName, String userPassword, String userRealName, String userAddress, String userPhone,
				String userIdCard, String userProfession, int userComplainedCount, String userEmail,
				double userReputation, int userBussinessCount) {
			super();
			this.userName = userName;
			this.userPassword = userPassword;
			this.userRealName = userRealName;
			this.userAddress = userAddress;
			this.userPhone = userPhone;
			this.userIdCard = userIdCard;
			this.userProfession = userProfession;
			this.userComplainedCount = userComplainedCount;
			this.userEmail = userEmail;
			this.userReputation = userReputation;
			this.userBussinessCount = userBussinessCount;
		}

		
		
		
		
		public UserBean(int userId, String userName, String userPassword, String userRealName, String userAddress,
				String userPhone, String userIdCard, String userProfession, int userComplainedCount, String userEmail,
				double userReputation, int userBussinessCount) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userPassword = userPassword;
			this.userRealName = userRealName;
			this.userAddress = userAddress;
			this.userPhone = userPhone;
			this.userIdCard = userIdCard;
			this.userProfession = userProfession;
			this.userComplainedCount = userComplainedCount;
			this.userEmail = userEmail;
			this.userReputation = userReputation;
			this.userBussinessCount = userBussinessCount;
		}


		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getUserPassword() {
			return userPassword;
		}


		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}


		public String getUserEmail() {
			return userEmail;
		}


		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserRealName() {
			return userRealName;
		}


		public void setUserRealName(String userRealName) {
			this.userRealName = userRealName;
		}


		public String getUserAddress() {
			return userAddress;
		}


		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}


		public String getUserPhone() {
			return userPhone;
		}


		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}


		public String getUserIdCard() {
			return userIdCard;
		}


		public void setUserIdCard(String userIdCard) {
			this.userIdCard = userIdCard;
		}


		public String getUserProfession() {
			return userProfession;
		}


		public void setUserProfession(String userProfession) {
			this.userProfession = userProfession;
		}


		public int getUserComplainedCount() {
			return userComplainedCount;
		}


		public void setUserComplainedCount(int userComplainedCount) {
			this.userComplainedCount = userComplainedCount;
		}


		public double getUserReputation() {
			return userReputation;
		}


		public void setUserReputation(double userReputation) {
			this.userReputation = userReputation;
		}


		public int getUserBussinessCount() {
			return userBussinessCount;
		}

		public void setUserBussinessCount(int userBussinessCount) {
			this.userBussinessCount = userBussinessCount;
		}

		/**
		 * 重写toString方法
		 */

		@Override
		public String toString() {
			return "UserEntity [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
					+ ", userRealName=" + userRealName + ", userAddress=" + userAddress + ", userPhone=" + userPhone
					+ ", userIdCard=" + userIdCard + ", userProfession=" + userProfession + ", userComplainedCount="
					+ userComplainedCount + ", userEmail=" + userEmail + ", userReputation=" + userReputation
					+ ", userBussinessCount=" + userBussinessCount + "]";
		}

}
