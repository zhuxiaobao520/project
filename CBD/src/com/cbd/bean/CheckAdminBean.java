package com.cbd.bean;

import javax.validation.constraints.Pattern;

import com.sun.javafx.binding.StringFormatter;

/**
 * 封装校验修改普通管理员信息
 * @author 张平
 * @date 2018年2月7日
 */
public class CheckAdminBean {
	
		/*//管理员电话
		@Pattern(regexp="1[3|5|8]{1}[0-9]{9}",message="手机号码格式错误")
		private String newPhone;*/
		
		//管理员密码()
		@Pattern(regexp="\\w{6,16}",message="密码为6到16个字母、数字或下划线")
		private String oldPassword;
		
		//管理员密码()
		@Pattern(regexp="\\w{6,16}",message="密码为6到16个字母、数字或下划线")
		private String newPassword;
		//管理员密码()
		@Pattern(regexp="\\w{6,16}",message="密码为6到16个字母、数字或下划线")
		private String chongfuPassword;
		
		
		public String getOldPassword() {
			return oldPassword;
		}
		public void setOldPassword(String oldPassword) {
			this.oldPassword = oldPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		public String getChongfuPassword() {
			return chongfuPassword;
		}
		public void setChongfuPassword(String chongfuPassword) {
			this.chongfuPassword = chongfuPassword;
		}
		
}
