package com.cbd.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbd.bean.AdminBean;
import com.cbd.bean.CompanyBean;
import com.cbd.bean.UserBean;
import com.cbd.service.IAdminService;

/**
 * 处理管理员登录的realm
 * 
 * @author yinshi
 * @date 2018年2月4日
 */
public class AdminRealm extends AuthorizingRealm {

	@Autowired
	private IAdminService adminService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		/*Object object = principalCollection.getPrimaryPrincipal();
		if(object instanceof AdminBean){
			adminBean = (AdminBean) object;
		}*/
		Session session = SecurityUtils.getSubject().getSession();
		AdminBean adminBean =(AdminBean) session.getAttribute("adminLogining");
		SimpleAuthorizationInfo simpleAuthorizationInfo = null;
		Set<String> permissions = new HashSet<String>();
		if(adminBean != null){	
			permissions.add("manager");
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			if(adminBean.getAdminType() == 1){
				permissions.add("superAdmin");
			}
			if(adminBean.getAdmiUserManagerPower() == 1){
				permissions.add("userAdmin");
			}
			if(adminBean.getAdminCarPortManagerPower() == 1){
				permissions.add("carportAdmin");
			}
			if(adminBean.getAdminCompaintManagerPower() == 1){
				permissions.add("complaintAdmin");
			}
			if(adminBean.getAdminAgreementManagerPower() == 1){
				permissions.add("agreementAdmin");
			}
			for (String permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission);
			}
			return simpleAuthorizationInfo;	
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 1. 把AuthenticationToken转换为CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) token;
		// 2. 从CustomizedToken中获取email
		String userName = customizedToken.getUsername();
		// 3. 若用户不存在，抛出UnknownAccountException异常
		AdminBean adminBean = adminService.getAdminByAdminName(userName);
		if (adminBean == null)
			throw new UnknownAccountException("用户不存在！");
//		Session session  = SecurityUtils.getSubject().getSession();
//		session.setAttribute("adminLogining", adminBean);
		// 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
		// （1）principal：认证的实体信息，可以是email，也可以是数据表对应的用户的实体类对象
		String principal = userName;
		// （2）credentials：密码
		String credentials = new String(customizedToken.getPassword());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, getName());
		return info;
	}
}
