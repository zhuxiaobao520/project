package com.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLEditorKit.HTMLTextAction;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbd.bean.AdminBean;
import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.entity.UserEntity;
import com.cbd.service.IUserService;
import com.cbd.service.IUsercarportService;
import com.cbd.util.UseMD5;
import com.cbd.validator.Log;

/**
 * 个人用户登陆页面处理器
 * @author 张平
 *
 */
@Controller
@SessionAttributes("userLogin")
public class UserController {
	@Autowired
	private IUserService userService;//调用业务逻辑层接口
	@Autowired
	private IUsercarportService carService;
	
	/**
	 * 王菁
	 * 查询登录用户信息跳转修改个人信息页面
	 */
	@RequestMapping("userInfo")
	public String  selectUserById(UserBean userBean,ModelMap modelMap){

		UserBean userBean2 = (UserBean) modelMap.get("userLogin");
		UserBean uBean = userService.selectUserById(userBean2.getUserId());
		modelMap.addAttribute("userBean", uBean);
		return "userJsp/yangmingjian/user_info";
	}

	/**
	 * 王菁
	 * 查询登录用户跳转修改密码页面
	 */
	@RequestMapping("userChangePwd")
	public String selectUserPwd(UserBean userBean,ModelMap modelMap){	
		return "userJsp/yangmingjian/user_changePwd";
	}
	
	/**
	 * 王菁
	 * 修改登录用户密码然后跳转页面
	 */
	@RequestMapping("updatePassword")
	public String updateUserPwd(@RequestParam("oldPassword")String oldPassword,
			@RequestParam("newPassword")String newPassword,ModelMap modelMap,HttpSession session){
		if(oldPassword.trim().equals("")){
			modelMap.addAttribute("userPwdError", "原密码不能为空串");
			return "userJsp/yangmingjian/user_changePwd";
		}
		if(newPassword.trim().equals("")){
			modelMap.addAttribute("userPwdNew", "新密码不能为空串");
			return "userJsp/yangmingjian/user_changePwd";
		}
		UserBean userBean=(UserBean) modelMap.get("userLogin");
		String oldPwd=UseMD5.md5MakePassword(oldPassword);
		if(oldPwd.equals(userBean.getUserPassword())){
			Boolean flag=userService.updateUserPwd(userBean.getUserId(), UseMD5.md5MakePassword(newPassword));
			if(flag){
				session.removeAttribute("userLogin");
				return "login";
			}
		}
		modelMap.addAttribute("userPwdError", "原密码错误");
		return "userJsp/yangmingjian/user_changePwd";
		
	}
	
	/**
	 * 王菁
	 * 修改登录用户个人信息然后跳转页面
	 */
	@RequestMapping("update")
	public String updateUserInfo(UserBean userBean,ModelMap modelMap){
		

		UserBean userBean2 = (UserBean) modelMap.get("userLogin");
		UserBean uBean = userService.selectUserById(userBean2.getUserId());
		userBean.setUserName(uBean.getUserName());
		userBean.setUserIdCard(uBean.getUserIdCard());
		userBean.setUserRealName(uBean.getUserRealName());
		
		
		if (!userBean.getUserAddress().matches("^[\\u4e00-\\u9fa5]*[0-9]+[号]")) {
			modelMap.addAttribute("MessageAddress", "地址只能为汉字加数字如：XXX1号");
			modelMap.addAttribute("userBean",userBean );
			return "userJsp/yangmingjian/user_info";
		}else if(!userBean.getUserProfession().matches("^[\\u4e00-\\u9fa5]*$")) {
			modelMap.addAttribute("MessageP", "职业只能为汉字");
			modelMap.addAttribute("userBean",userBean );
			return "userJsp/yangmingjian/user_info";
		}else {
			boolean flag = userService.updateUserInfo(userBean);
			if (flag) {
				return "userJsp/userHome";
			} else {
				modelMap.addAttribute("wrongMessage", "修改信息失败！请核对信息！");
				return "userJsp/yangmingjian/user_info";
			}
		}
		
		

		
	}
	
	/**
	 * 跳转到个人用户主页
	 * @author yinshi
	 * @date 2018年2月7日
	 * @return
	 */
	@RequestMapping("showUserHome")
	public String goToUserHome(){
		return "redirect:jsp/userJsp/userHome.jsp";
	}
	
	/**
	 * 显示个人信息
	 * @author yinshi
	 * @date 2018年2月7日
	 * @return
	 */
	@RequestMapping("showUserInfo")
	public String showUserInfo(HttpSession session,ModelMap modelMap){
		UserBean userBean = (UserBean)session.getAttribute("userLogin");
		userBean = userService.getUserByUsername(userBean.getUserName());
		modelMap.addAttribute("userBean", userBean);
		return "userJsp/yinshi/showUserInfo";
	}
	
	
	/**
	 * 分类查询个人车位信息
	 * @author yinshi
	 * @date 2018年2月7日
	 * @param curPage
	 * @param buyRecordType
	 * @param request
	 * @return
	 */
	@RequestMapping("showUserMyselfCarPort")
	@ResponseBody
	public Pager buyRecordInfo(@RequestParam("currentPage") int curPage,@RequestParam("choiceSelete") String choiceSelete,
			HttpSession session){
		/**
		 * 获取当前登录用户
		 */
		UserBean userBean=(UserBean) session.getAttribute("userLogin");
		Pager pager=null;
		/**
		 * 根据记录传出当前用户id查询用户的买卖记录数据
		 */
		if(choiceSelete.equals("已发布车位信息")){
			 pager=carService.getUserOutCarportsByUserId(userBean.getUserId(), curPage, 5);
		}else {
			pager=carService.getUserNullCarportByUserId(userBean.getUserId(), curPage, 5);
		}
		return pager;
	}
}
