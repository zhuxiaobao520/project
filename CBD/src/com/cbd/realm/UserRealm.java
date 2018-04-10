package com.cbd.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

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

import com.cbd.bean.CompanyBean;
import com.cbd.bean.UserBean;
import com.cbd.service.IUserService;

/**
 * 处理普通用户的realm
 * 
 * @author yinshi
 * @date 2018年2月4日
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	/**
	 * 授权管理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
//		Object object = principalCollection.getPrimaryPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		/*if (object instanceof UserBean) {
			userBean = (UserBean) object;
		}*/
		if (userBean != null) {
			SimpleAuthorizationInfo simpleAuthorizationInfo = null;
			List<String> permissions = new ArrayList<String>();
			permissions.add("user");
			// 将权限信息封闭为AuthorizationInfo
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			for (String permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission);
			}
			return simpleAuthorizationInfo;
		}
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 1. 把AuthenticationToken转换为CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) token;
		// 2. 从CustomizedToken中获取用户名
		String userName = customizedToken.getUsername();
		// 3. 若用户不存在，抛出UnknownAccountException异常
		UserBean userBean = userService.getUserByUsername(userName);
		if (userBean == null) {
			throw new UnknownAccountException("用户不存在！");
		}
//		Session session = SecurityUtils.getSubject().getSession();
//		session.setAttribute("userLogin", userBean);
		// 4.
		// 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
		// （1）principal：认证的实体信息，可以是email，也可以是数据表对应的用户的实体类对象
		Object principal = userName;
		// （2）credentials：密码
		Object credentials = userBean.getUserPassword();
		// （3）realmName：当前realm对象的name，调用父类的getName()方法即可
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}

}
