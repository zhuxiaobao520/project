package com.cbd.bean;

/**
 * 登录类型枚举 
 * @author yinshi
 * @date 2018年2月4日
 */
public enum LoginType {

	USER("User"),COMPANY("Company"),ADMIN("Admin");
	
	private String type;
	
	private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
