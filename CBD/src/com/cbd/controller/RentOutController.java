package com.cbd.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;
import com.cbd.bean.RentOutBean;
import com.cbd.bean.RentOutInsertBean;
import com.cbd.bean.UseableRentOutInfoBean;
import com.cbd.bean.UserBean;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IComplainService;
import com.cbd.service.IRentOutService;
import com.cbd.service.IUsercarportService;

/**
 * 出租的控制器 需要获得当前用户-----后期需要调整 需要跳转到出租界面 添加新的出租车位信息 添加出租信息 出租成功后页面需要更改
 * 
 * @author 姚刚
 * @date 2018年2月1日
 */
@Controller
public class RentOutController {

	@Autowired
	private IUsercarportService iUsercarportService;

	@Autowired
	private IRentOutService iRentOutService;

	@Autowired
	private IComplainService iComplainService;

	/**
	 * 跳转到添加出租信息界面
	 * 
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	@RequestMapping(value = "rentOutController_yg/turnToAddRentOutPage")
	public String turnToAddRentOutPage(ModelMap modelMap, HttpSession session) {
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		if (userBean != null) {
			List<UsercarportEntity> usercarportEntities = iUsercarportService
					.getUserCarportsByUserId(userBean.getUserId());
			modelMap.addAttribute("usercarportEntities", usercarportEntities);
			return "userJsp/RentJsp_yg/addRentOutPage";
		}
		return "login";
	}

	/**
	 * 添加出租信息
	 * 
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	@RequestMapping(value = "rentOutController_yg/addRentOut",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> addRentOut(
			@RequestParam("rentOutCarportId") String CarportId,
			@RequestParam("rentOutPrice") String rentOutPriceStr,
			@RequestParam("rentOutStartTime") String rentOutStartTimeStr,
			@RequestParam("rentOutEndTime") String rentOutEndTimeStr,
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		boolean result = false;
		String reason = "";
		int rentOutCarportId = 0;
		if (CarportId != null && CarportId.matches("[0-9]{1,}")) {
			rentOutCarportId = Integer.parseInt(CarportId);
		}
		if (rentOutCarportId == 0) {
			reason = "您选择的车位信息有误，请重新选择";
			map.put("result", result);
			map.put("reason", reason);
			return map;
		}
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		if (userBean != null) {
			double rentOutPrice = 0;
			if (rentOutPriceStr != null && rentOutPriceStr.matches("[0-9]{1,}")) {
				rentOutPrice = Double.parseDouble(rentOutPriceStr);
			} else {
				reason = "您输入的价格有误，请输入正确的数字";
				map.put("result", result);
				map.put("reason", reason);
				return map;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date rentOutStartTime = null;
			if (rentOutStartTimeStr != null && !"".equals(rentOutStartTimeStr)) {
				try {
					rentOutStartTime = simpleDateFormat.parse(rentOutStartTimeStr);
				} catch (ParseException e) {
					e.printStackTrace();
					reason = "您选择的租赁开始时间有误，请选择正确的时间";
					map.put("result", result);
					map.put("reason", reason);
					return map;
				}
			}else{
				reason = "您选择的租赁开始时间有误，请选择正确的时间";
				map.put("result", result);
				map.put("reason", reason);
				return map;
			}
			Date rentOutEndTime = null;
			if (rentOutEndTimeStr != null && !"".equals(rentOutEndTimeStr)) {
				try {
					rentOutEndTime = simpleDateFormat.parse(rentOutEndTimeStr);
				} catch (ParseException e) {
					e.printStackTrace();
					reason = "您选择的租赁结束时间有误，请选择正确的租赁结束时间";
					map.put("result", result);
					map.put("reason", reason);
					return map;
				}
			}else{
				reason = "您选择的租赁结束时间有误，请选择正确的租赁结束时间";
				map.put("result", result);
				map.put("reason", reason);
				return map;
			}
			if (rentOutEndTime != null && rentOutStartTime != null) {
				if (rentOutCarportId != 0 && rentOutEndTime.after(rentOutStartTime)) {
					RentOutInsertBean rentOutInsertBean = new RentOutInsertBean(rentOutPrice, rentOutCarportId,
							rentOutStartTime, rentOutEndTime);
					UsercarportEntity usercarportEntity = iUsercarportService.getByIdUsercarport(rentOutCarportId);
					if (usercarportEntity != null) {
						if (usercarportEntity.getUserCarportStatus().equals("空闲")) {
							// 添加车位
							iRentOutService.addRentOutBean(rentOutInsertBean);
							result = true;
							map.put("result", result);
							return map;
						} else {
							reason = "您选择的车位已经租出或者已经出售，请选择正确的车位";
							map.put("result", result);
							map.put("reason", reason);
							return map;
						}
					} else {
						reason = "您选择车位不存在，请选择正确的车位";
						map.put("result", result);
						map.put("reason", reason);
						return map;
					}

				} else {
					reason = "租赁结束时间必须在租赁开始时间之后，请重新选择时间";
					map.put("result", result);
					map.put("reason", reason);
					return map;
				}
			} else {
				reason = "您选择的时间有误，请选择正确的时间";
				map.put("result", result);
				map.put("reason", reason);
				return map;
			}
		}
		return map;
	}

	/**
	 * 跳转到显示出租空闲车位详情的页面
	 * 
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "rentOutController_yg/turnToRentOutInfoPage", method = RequestMethod.POST)
	public String turnToUseableRentOutInfoPage(HttpServletRequest httpServletRequest) {
		String rentOutInfoId = httpServletRequest.getParameter("rentOutId");
		int rentOutId = 0;
		if (rentOutInfoId != null && !"".equals(rentOutInfoId)) {
			if (rentOutInfoId.matches("[0-9]{1,}")) {
				rentOutId = Integer.parseInt(rentOutInfoId);
			}
		}
		UseableRentOutInfoBean useableRentOutInfoBean = iRentOutService.getUseableRentOutInfoByRentOutId(rentOutId);
		httpServletRequest.setAttribute("useableRentOutInfoBean", useableRentOutInfoBean);
		return "userJsp/RentJsp_yg/showRentOutInfoPage";

	}

	/**
	 * 跳转到显示待租车位页面
	 * 
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	@RequestMapping(value = "rentIn_yg/turnToRentOutListPage")
	public String showRentOutCarport() {
		return "userJsp/RentJsp_yg/rentOutListPage_yg";
	}

	/**
	 * 局部刷新待租的信息
	 * 
	 * @author 姚刚
	 * @date 2018年2月1日
	 * @return
	 */
	@RequestMapping(value = "rentIn_yg/getRentOutPager")
	@ResponseBody
	public Pager getRentOutPager(HttpServletRequest httpServletRequest) {
		String page = httpServletRequest.getParameter("currentPage");
		int currentPage = 1;
		if (page.matches("[0-9]{1,}")) {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage < 0) {
			currentPage = 1;
		}
		Pager pager = iRentOutService.getUseableCarportPager(currentPage, 3);
		return pager;

	}

	@RequestMapping(value = "rentOutController_yg/turnToComplainRentOutPage")
	public String turnToRentOutInfoPage(HttpServletRequest httpServletRequest) {
		String rentInInfoId = httpServletRequest.getParameter("rentInId");
		int rentInId = 0;
		if (rentInInfoId != null && !"".equals(rentInInfoId)) {
			if (rentInInfoId.matches("[0-9]{1,}")) {
				rentInId = Integer.parseInt(rentInInfoId);
			}
		}
		if (rentInId != 0) {
			RentOutBean rentOutBean = iRentOutService.getRentOutBean(rentInId);
			httpServletRequest.setAttribute("rentOutBean", rentOutBean);
			return "userJsp/RentJsp_yg/rentOutRecordComplain_yg";
		}
		return "userJsp/transactionRecordsJsp/userRentRecord_yg/userRentRecord_yg";
	}

	@RequestMapping(value = "rentOutController_yg/rentOutRecordComplain")
	@ResponseBody
	public HashMap<String, Object> rentOutRecordComplain(HttpServletRequest httpServletRequest, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		boolean result = false;
		String resultMessage = "";
		String rentInIdStr = httpServletRequest.getParameter("rentInId");
		String rentInUserIdStr = httpServletRequest.getParameter("rentInUserId");
		String complainMessage = httpServletRequest.getParameter("complainMessage");
		UserBean userBean = (UserBean) session.getAttribute("userLogin");
		if (rentInIdStr != null && rentInIdStr.matches("[0-9]{1,}") && rentInUserIdStr != null
				&& rentInUserIdStr.matches("[0-9]{1,}")) {
			// 验证用户已经登录
			if (userBean != null) {
				// 判断当前的招租记录是否被投诉
				int rentInId = Integer.parseInt(rentInIdStr);
				int rentInUserId = Integer.parseInt(rentInUserIdStr);
				if (iComplainService.eventIsComplained(userBean.getUserId(), rentInId, "招租")) {
					ComplainInsertBean complainInsertBean = new ComplainInsertBean(userBean.getUserId(), rentInUserId,
							rentInId, "招租", "未处理", complainMessage, new Date());
					iComplainService.addComplainInsertBean(complainInsertBean);
					result = true;
				} else {
					resultMessage = "该交易已经投诉，请勿重复投诉";
				}

			} else {
				resultMessage = "您当前尚未登录，请登录后操作";
			}
		} else {
			resultMessage = "你选择的招租记录有误，请重新操作";
		}
		map.put("result", result);
		map.put("resultMessage", resultMessage);
		return map;
	}
}
