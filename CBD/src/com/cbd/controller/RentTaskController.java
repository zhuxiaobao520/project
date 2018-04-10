package com.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbd.bean.Pager;
import com.cbd.bean.RentTaskBean;
import com.cbd.bean.UserBean;
import com.cbd.entity.RentInEntity;
import com.cbd.entity.RentOutEntity;
import com.cbd.entity.UserEntity;
import com.cbd.service.IMessageService;
import com.cbd.service.IRentInSerevice;
import com.cbd.service.IRentOutService;
import com.cbd.service.IRentTaskService;
import com.cbd.service.IUserService;
import com.cbd.service.IUsercarportService;

/**
 * 
 * <p>Title:RentTaskController</p>
 * <p>Description:待办租赁任务页面控制器</p>
 * @author 龙成
 * @date2018年2月1日上午11:21:51
 */
@Controller
@SessionAttributes("allRentTaskBean")
public class RentTaskController {
	@Autowired
	private IRentTaskService rentTaskService;
	
	@Autowired
	private IRentInSerevice rentInService;
	
	@Autowired
	private IRentOutService rentOutService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IUsercarportService usercarportService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 
	 * <p>Title:getRentTaskPage</p>
	 * <p>Description:获取待办租赁任务列表</p>
	 * @author 龙成
	 * @date2018年2月1日下午1:45:54
	 */
	@RequestMapping("bookedRentInfo")
	@ResponseBody
	public Pager getRentTaskPage(
			@RequestParam(value="curPage") int curPage,
			HttpSession httpSession,
			ModelMap modelMap
			){
		/* 获取登录用户的id*/
		UserBean user = (UserBean) httpSession.getAttribute("userLogin");
		int id = user.getUserId();
		Pager pager = rentTaskService.getRentTaskPager(curPage, id);	
		/* 将pager中包含的租赁任务信息集合放入到session中，用于根据购买者id显示购买的信息 */
		modelMap.addAttribute("allRentTaskBean", pager.getDatas());
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:showRentInInfo</p>
	 * <p>Description:获取待办租赁任务详情</p>
	 * @author 龙成
	 * @date2018年2月1日下午1:45:44
	 */
	@RequestMapping("lookRentInfo")
	public String showRentInInfo(
			@RequestParam(value="rentInUserId") int rentInUserId,
			ModelMap modelMap,
			HttpSession session
			){
		/* 从session中获取到所有的带半租赁任务集合 */
		List<RentTaskBean> rentTaskBeans = (List<RentTaskBean>) session.getAttribute("allRentTaskBean");
		/* 循环找到与传进来的预约者id相同的租赁任务 */
		RentTaskBean rentTaskBean =null;
		for (int i = 0; i < rentTaskBeans.size(); i++) {
			if(rentTaskBeans.get(i).getUserEntity().getUserId() == rentInUserId){
				rentTaskBean = rentTaskBeans.get(i);
				break;
			}			
		}
		/* 将得到的待办任务Bean放入到modelMap中，将数据传入到返回的页面中 */
		modelMap.addAttribute("rentTaskBean", rentTaskBean);	
		return "userJsp/hxm/rentInInfo";
	}
	
	
	/**
	 * 
	 * <p>Title:backToRentTask</p>
	 * <p>Description:返回待办租赁任务首页</p>
	 * @author 龙成
	 * @date2018年2月1日下午2:30:01
	 */
	@RequestMapping("dealRentTask")
	public String backToRentTask(){
		return "userJsp/hxm/rentTask";
	}
	
	/**
	 * 
	 * <p>Title:disagreeRent</p>
	 * <p>Description:拒绝预约租赁，并返回待办租赁任务首页</p>
	 * @author 龙成
	 * @date2018年2月1日下午3:06:51
	 */
	@RequestMapping("disagreeRent")
	public String disagreeRent(
			@RequestParam(value="rentInUserId") int rentInUserId,
			@RequestParam(value="userCarportId") int userCarportId,
			@RequestParam(value="rentInId") int rentInId,
			@RequestParam(value="rentOutId") int rentOutId
			){
		
		/* 根据rentInId和rentInUserId修改租赁信息表中记录状态为交易失败 */
		rentInService.updateRentInStatus(rentInId, rentInUserId, "交易失败");
		
		
		/* 根据rentOutId和rentInUserId将交易失败信息添加到信息推送表中 */
		/* 根据rentOutId查询出招租信息，获取到招租人和车位信息 */
		RentOutEntity rentOutEntity = rentOutService.getRentOutById(rentOutId);
		String messageContent = "未通过招租车预约审核" +rentOutEntity.getUsercarportEntity().getUserCarportAddress()+
				rentOutEntity.getUsercarportEntity().getUserCarportAddressNo()+"车位预约租赁失败";
		/* 添加信息到消息推送表中  */
		messageService.insertMessage(messageContent, rentInUserId);
		
		return "userJsp/hxm/rentTask";
	}
	
	
	/**
	 * 
	 * <p>Title:agreeRent</p>
	 * <p>Description:同意租赁预约申请控制器</p>
	 * @author 龙成
	 * @date2018年2月1日下午5:16:09
	 */
	@RequestMapping("agreeRent")
	public String agreeRent(
			@RequestParam(value="rentInUserId") int rentInUserId,
			@RequestParam(value="userCarportId") int userCarportId,
			@RequestParam(value="rentInId") int rentInId,
			@RequestParam(value="rentOutId") int rentOutId,
			HttpSession httpSession
			){
		/* 从session中获取当前用户id */
		UserBean user = (UserBean) httpSession.getAttribute("userLogin");
		int userId = user.getUserId();
	
		/* 根据rentInId和rentInUserId修改租赁信息表中记录状态为交易成功*/
		rentInService.updateRentInStatus(rentInId, rentInUserId, "交易成功");
		
		/* 根据userCarportId将车位状态改为已出租 */
		usercarportService.updateUserCarportStatusByUserCarportId(userCarportId, "已租出");
		
		/* 根据rentInUserId和当前登录用户id，将他们的个人交易次数加1*/
		userService.updateUserBussinessCountById(userId);
		userService.updateUserBussinessCountById(rentInUserId);
		/* 更新信誉度 */
		userService.updateUserReputation(userId);
		userService.updateUserReputation(rentInUserId);
		
		/* 根据rentOutId修改租赁信息表中记录状态为交易失败,rentInUserId对应的交易状态不变*/
		rentInService.updateOtherUserRentInStatus(rentOutId, rentInUserId, "交易失败");
		
		/* 根据rentOutId查询出招租信息，获取到招租人和车位信息 */
		RentOutEntity rentOutEntity = rentOutService.getRentOutById(rentOutId);
		
		/* 根据rentInUserId添加消息提示租赁交易成功 */
		String messageRentIn = "恭喜您!"+rentOutEntity.getUsercarportEntity().getUserCarportAddress()+
				rentOutEntity.getUsercarportEntity().getUserCarportAddressNo()+"车位预约租赁成功";
		messageService.insertMessage(messageRentIn, rentInUserId);			
		
		/* 根据当前用户id添加消息提示租赁交易成功 */
		String messageRentOut = "恭喜您!"+rentOutEntity.getUsercarportEntity().getUserCarportAddress()+
				rentOutEntity.getUsercarportEntity().getUserCarportAddressNo()+"车位出租成功";
		messageService.insertMessage(messageRentOut, userId);
		
		/* 通知其他预约租赁该车位的用户该车位已被租出,交易失败 */
		/* 查询出所有预约失败的租赁信息 */
		List<RentInEntity> list = rentInService.getRentInEntitiesByRentOutId(rentOutId, rentInId);
		
		/* 循环失败租赁信息集合，得到预约失败用户id，并发送消息，提示失败 */
		String message = rentOutEntity.getUsercarportEntity().getUserCarportAddress()+
				rentOutEntity.getUsercarportEntity().getUserCarportAddressNo()+"车位已租出，预约失败";
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getUserEntity().getUserId();
			messageService.insertMessage(message, id);
		}
			
		return "userJsp/hxm/rentTask";
	}	
}



















