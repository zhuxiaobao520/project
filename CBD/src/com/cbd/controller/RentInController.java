package com.cbd.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.RentInComplainBean;
import com.cbd.bean.RentInInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.bean.UserBean;
import com.cbd.service.IComplainService;
import com.cbd.service.IMessageService;
import com.cbd.service.IRentInSerevice;
import com.cbd.service.IRentOutService;

/**
 * 租赁的相关控制器 需要修改当前用户id 修改用户名
 * 
 * @author 姚刚
 * @date 2018年2月1日
 */
@Controller
public class RentInController {
	@Autowired
	private IRentInSerevice iRentInservice;
	@Autowired
	private IRentOutService iRentOutService;
	@Autowired
	private IMessageService iMessageService;
	@Autowired
	private IComplainService iComplainService;

	@RequestMapping(value = "rentInController_yg/addRentIn")
	@ResponseBody
	public HashMap<String, Object> addRentInBean(HttpServletRequest httpServletRequest, HttpSession session) {
		boolean result = false;
		String failedReson = "";
		HashMap<String, Object> resultMap = new HashMap<>();
		int rentOutId = 0;
		String rentOutIdStr = httpServletRequest.getParameter("rentOutId");
		if (rentOutIdStr != null && !"".equals(rentOutIdStr) && rentOutIdStr.matches("[0-9]{1,}")) {
			rentOutId = Integer.parseInt(rentOutIdStr);
		}

		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		// 当出租信息id不等于0时才添加
		if (userBean != null) {
			if (rentOutId != 0) {
				// 通过rentOutId获得出租详情
				UseableRentOutInfoBean rentOutInfoBean = iRentOutService.getUseableRentOutInfoByRentOutId(rentOutId);
				if (rentOutInfoBean != null) {
					String rentInMessage = httpServletRequest.getParameter("rentInMessage");
					RentInInsertBean rentInInsertBean = new RentInInsertBean();
					rentInInsertBean.setRentOutId(rentOutInfoBean.getRentOutId());
					rentInInsertBean.setRentInUserId(userBean.getUserId());
					rentInInsertBean.setRentInMessage(rentInMessage);
					if (rentOutInfoBean.getUserId() != userBean.getUserId()) {
						if (iRentInservice.getRentInNumByRentOutIdAndRentInUserId(rentOutInfoBean.getRentOutId(),
								userBean.getUserId()) == 0) {// 判断当前用户是否租过这条记录
							result = iRentInservice.addRentInRecord(rentInInsertBean);
						} else {
							failedReson = "您已经租赁过该车位了，请勿重复租赁";
						}
					} else {
						failedReson = "您不能租赁自己的车位";
					}
				} else {
					failedReson = "您选择的车位已经租出";
				}
			} else {
				failedReson = "您尚未选中任何可租车位";
			}
		} else {
			failedReson = "您当前尚未登录";
		}
		resultMap.put("result", result);
		resultMap.put("failedReson", failedReson);
		return resultMap;
	}

	@RequestMapping(value = "rentInController_yg/turnToComplainRentInPage")
	public String turnToRentOutInfoPage(HttpServletRequest httpServletRequest) {
		String rentInInfoId = httpServletRequest.getParameter("rentInId");
		int rentInId = 0;
		if (rentInInfoId != null && !"".equals(rentInInfoId)) {
			if (rentInInfoId.matches("[0-9]{1,}")) {
				rentInId = Integer.parseInt(rentInInfoId);
			}
		}
		if (rentInId != 0) {
			RentInComplainBean rentInComplainBean = iRentInservice.getRentInComplainBean(rentInId);
			httpServletRequest.setAttribute("rentInComplainBean", rentInComplainBean);
			return "userJsp/RentJsp_yg/rentInRecordComplain_yg";
		}
		return "userJsp/transactionRecordsJsp/userRentRecord_yg/userRentRecord_yg";
	}

	@RequestMapping(value = "rentInController_yg/rentInRecordComplain")
	@ResponseBody
	public HashMap<String, Object> rentOutRecordComplain(HttpServletRequest httpServletRequest, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		boolean result = false;
		String resultMessage = "";
		String rentInIdStr = httpServletRequest.getParameter("rentInId");
		String rentOutUserIdStr = httpServletRequest.getParameter("rentOutUserId");
		String complainMessage = httpServletRequest.getParameter("complainMessage");
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		if (rentInIdStr != null && rentInIdStr.matches("[0-9]{1,}") && rentOutUserIdStr != null
				&& rentOutUserIdStr.matches("[0-9]{1,}")) {
			// 验证用户已经登录
			if (userBean != null) {
				// 判断当前的招租记录是否被投诉
				int rentInId = Integer.parseInt(rentInIdStr);
				int rentOutUserId = Integer.parseInt(rentOutUserIdStr);
				if (iComplainService.eventIsComplained(userBean.getUserId(), rentInId, "租赁")) {
					ComplainInsertBean complainInsertBean = new ComplainInsertBean(userBean.getUserId(), rentOutUserId,
							rentInId, "租赁", "未处理", complainMessage, new Date());
					iComplainService.addComplainInsertBean(complainInsertBean);
					result = true;
				} else {
					resultMessage = "您已经投诉过该笔交易了，请勿重复投诉";
				}

			} else {
				resultMessage = "您当前尚未登录，请登录后操作";
			}
		} else {
			resultMessage = "你选择的租赁 记录有误，请重新操作";
		}
		map.put("result", result);
		map.put("resultMessage", resultMessage);
		return map;
	}
}
