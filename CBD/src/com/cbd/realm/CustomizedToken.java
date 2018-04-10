package com.cbd.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 登录类型判断
 * @author yinshi
 * @date 2018年2月4日
 */
public class CustomizedToken extends UsernamePasswordToken{

	//登录类型，判断是普通用户登录，企业用户登录，还是管理员登录
    private String loginType;

    public CustomizedToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
    
}
