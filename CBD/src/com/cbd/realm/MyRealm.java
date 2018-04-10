package com.cbd.realm;

import java.util.HashSet;
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
import com.cbd.service.ICompanyService;
import com.cbd.service.IUserService;


/**
 * 登录的认证与授权
 * @author yinshi
 * @date 2018年2月6日
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICompanyService comService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		Session session = SecurityUtils.getSubject().getSession();
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		CompanyBean companyBean = (CompanyBean) session.getAttribute("companyLogin");
		AdminBean adminBean = (AdminBean) session.getAttribute("adminLogining");
		SimpleAuthorizationInfo simpleAuthorizationInfo = null;
		Set<String> permissions = new HashSet<String>();
		if (userBean != null) {
			permissions.add("user");
			// 将权限信息封闭为AuthorizationInfo
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			for (String permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission);
			}
			return simpleAuthorizationInfo;
		} else if (companyBean != null) {
			permissions.add("company");
			// 将权限信息封闭为AuthorizationInfo
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			for (String permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission);
			}
			return simpleAuthorizationInfo;
		} else if (adminBean != null) {
			permissions.add("manager");
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			if (adminBean.getAdminType() == 1) {
				permissions.add("superAdmin");
			}
			if (adminBean.getAdmiUserManagerPower() == 1) {
				permissions.add("userAdmin");
			}
			if (adminBean.getAdminCarPortManagerPower() == 1) {
				permissions.add("carportAdmin");
			}
			if (adminBean.getAdminCompaintManagerPower() == 1) {
				permissions.add("complaintAdmin");
			}
			if (adminBean.getAdminAgreementManagerPower() == 1) {
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
		CustomizedToken customizedToken = (CustomizedToken) token;
		// 2. 从CustomizedToken中获取email
		Session session = SecurityUtils.getSubject().getSession();
		session.removeAttribute("userLogin");
		session.removeAttribute("companyLogin");
		session.removeAttribute("adminLogining");
		String userName = customizedToken.getUsername();
		String loginType = customizedToken.getLoginType();
		// 3. 若用户不存在，抛出UnknownAccountException异常
		if ("User".equals(loginType)) {
			UserBean userBean = userService.getUserByUsername(userName);
			if (userBean == null)
				throw new UnknownAccountException("用户不存在！");
			session.setAttribute("userLogin", userBean);
		} else if ("Company".equals(loginType)) {
			CompanyBean companyBean = comService.getCompanyByName(userName);
			if (companyBean == null)
				throw new UnknownAccountException("用户不存在！");
			session.setAttribute("companyLogin", companyBean);
		} else if ("Admin".equals(loginType)) {
			AdminBean adminBean = adminService.getAdminByAdminName(userName);
			if (adminBean == null)
				throw new UnknownAccountException("用户不存在！");
			session.setAttribute("adminLogining", adminBean);
		}
		// 4.
		// 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
		// （1）principal：认证的实体信息，可以是email，也可以是数据表对应的用户的实体类对象
		String principal = userName;
		// （2）credentials：密码
		String credentials = new String(customizedToken.getPassword());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, getName());
		return info;
	}
}
