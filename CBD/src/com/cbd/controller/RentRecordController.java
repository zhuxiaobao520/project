package com.cbd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.service.IRentInSerevice;
import com.cbd.service.IRentOutService;

/**
 * \ 租赁相关控制器 用户id还需要更改
 * 
 * @author 姚刚
 *
 */
@Controller
public class RentRecordController {

	@Autowired
	private IRentInSerevice rentInSerevice;

	@Autowired
	private IRentOutService rentOutServicce;

	/**
	 * 跳转到租赁记录页面
	 * 
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping(value = "rentRecord_yg/turnToRentRecord")
	public String turnToRentRecord() {
		return "userJsp/transactionRecordsJsp/userRentRecord_yg/userRentRecord_yg";
	}

	/**
	 * 局部刷新租赁记录表
	 * 
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "rentRecord_yg/getRentRencord")
	@ResponseBody
	public Pager getRentRecord(HttpServletRequest httpServletRequest, HttpSession session) {
		String page = httpServletRequest.getParameter("currentPage");
		int currentPage = 1;
		if (page != null && page.matches("[0-9]{1,}")) {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage < 0) {
			currentPage = 1;
		}
		/**
		 * 还应该判断用户是否登录 userId从session取得当前用户
		 */
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		Pager pager = null;
		if (userBean != null) {
			String recordType = httpServletRequest.getParameter("recordType");
			if (recordType != null && !"".equals(recordType)) {
				if (recordType.equals("招租记录")) {
					pager = rentOutServicce.getRentOutPager(userBean.getUserId(), currentPage, 3);
				} else if (recordType.equals("租赁记录")) {
					pager = rentInSerevice.getRentInPager(userBean.getUserId(), currentPage, 3);
				}
			}
		}
		return pager;

	}
}
