package com.cbd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;
import com.cbd.bean.SaleRecordBean;
import com.cbd.bean.UserBean;
import com.cbd.service.IComplainService;
import com.cbd.service.ISaleService;

/**
 * 
 * @Title:BuyRecordController
 * @Description:买卖记录及相关
 * @author 黄先明
 * @dated 2018年2月2日
 */
@Controller
public class BuyRecordController {
	
	
	@Autowired
	private ISaleService ISaleService;
	@Autowired
	private IComplainService iComplainService;
	private static Logger logger=Logger.getLogger(BuyRecordController.class);
	/**
	 * 
	 * @Title:buyRecord
	 * @Description:进入买卖记录页面
	 * @author 黄先明
	 * @return String
	 *
	 */
	@RequestMapping("userBuyRecord")
	public String buyRecord(){
		return "userJsp/yangmingjian/buyInAndOutRecord";
	}
	

	/**
	 * 
	 * @Title:buyRecordInfo
	 * @Description:购买出售记录表数据获取
	 * @author 黄先明
	 * @param curPage
	 * @param buyRecordType
	 * @return Pager
	 *
	 */
	@RequestMapping("buyAndSaleRecordList")
	@ResponseBody
	public Pager buyRecordInfo(@RequestParam("curPage") int curPage,@RequestParam("buyRecordType") String buyRecordType,
			HttpServletRequest request){
		/**
		 * 获取当前登录用户
		 */
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean) session.getAttribute("userLogin");
		
		Pager pager=null;
		/**
		 * 根据记录传出当前用户id查询用户的买卖记录数据
		 */
		if(buyRecordType.equals("出售记录")){
			 pager=ISaleService.getSaleRecordPager(userBean.getUserId(), curPage, 5);
			 logger.debug(ISaleService.getSaleRecordPager(userBean.getUserId(), curPage, 5));
		}else {
			pager=ISaleService.getBuyRecordPager(userBean.getUserId(), curPage, 5);
			logger.debug(ISaleService.getSaleRecordPager(userBean.getUserId(), curPage, 5));	
		}
		
		return pager;
	}
	
	/**
	 * 
	 * @Title:goToSaleComlainPage
	 * @Description:跳转到买卖投诉页面
	 * @author 黄先明
	 * @return String
	 *
	 */
	@RequestMapping("goToSaleComplainPage")
	public String goToSaleComlainPage(@RequestParam("complainType") String complainType ,
			@RequestParam("buyInfoId") int buyInfoId ,HttpServletRequest request, ModelMap modelMap){
		
		HttpSession session=request.getSession();
		/**
		 * 获取当前用户
		 */
		UserBean userBean=(UserBean) session.getAttribute("userLogin");
		/**
		 * 封装页面数据
		 */
		SaleRecordBean saleRecordBean=ISaleService.getSaleRecordByBuyInfoId(buyInfoId);
		modelMap.addAttribute("saleRecordBean", saleRecordBean);
		/**
		 * 传入投诉类型
		 */
		modelMap.addAttribute("complainType", complainType);
		
		
		
		return "userJsp/hxm/DealComplaints";
	}
	
	
	/**
	 * 
	 * @Title:eventIsComplained
	 * @Description:判断用户对该事件是否进行投诉
	 * @author 黄先明
	 * @param complainType
	 * @param buyUserId
	 * @param sellUserId
	 * @param complainEventId
	 * @return String
	 *
	 */
	@RequestMapping("isComplained")
	@ResponseBody
	public List<String> eventIsComplained(@RequestParam("complainType") String complainType,
			@RequestParam("buyUserId") int buyUserId,@RequestParam("sellUserId") int sellUserId,
			@RequestParam("complainEventId") int complainEventId) {
		/**
		 * 判断投诉类型，投诉双方关系
		 */
		List<String> list=new ArrayList<>();
		
		if(complainType.equals("出售记录")){
			if(iComplainService.eventIsComplained(sellUserId, complainEventId, "出售")){
				
				list.add("投诉成功");
				return list;
			}else {
				list.add("投诉失败");
				return list;
			}
			
		}else {
			if(iComplainService.eventIsComplained(buyUserId, complainEventId, "购买")){
				list.add("投诉成功");
				return list;
			}else {
				list.add("投诉失败");
				return list;
			}
		}
		
	}
	/**
	 * 
	 * @Title:addSaleRecordComplain
	 * @Description:添加买卖投诉
	 * @author 黄先明
	 * @return
	 *
	 */
	@RequestMapping("dealComplaints")
	public String addSaleRecordComplain(@RequestParam("complainType") String complainType,
			@RequestParam("buyUserId") int buyUserId,@RequestParam("sellUserId") int sellUserId,
			@RequestParam("complainEventId") int complainEventId,@RequestParam("complainMessage") String complainMessage ){
		/**
		 * 判断投诉类型，投诉双方关系
		 */
		ComplainInsertBean complainInsertBean=new ComplainInsertBean();
		if(complainType.equals("出售记录")){
			complainInsertBean.setComplainUserId(sellUserId);
			complainInsertBean.setComplainedUserId(buyUserId);
			complainInsertBean.setComplainEventId(complainEventId);
			complainInsertBean.setComplainEventType("出售");
			complainInsertBean.setComplainStatus("未处理");
			complainInsertBean.setComplainMessage(complainMessage);
			complainInsertBean.setComplainTime(new Date());
			iComplainService.addComplainInsertBean(complainInsertBean);
			logger.debug(complainInsertBean);
			
		}else {
			complainInsertBean.setComplainUserId(buyUserId);
			complainInsertBean.setComplainedUserId(sellUserId);
			complainInsertBean.setComplainEventId(complainEventId);
			complainInsertBean.setComplainEventType("购买");
			complainInsertBean.setComplainStatus("未处理");
			complainInsertBean.setComplainMessage(complainMessage);
			complainInsertBean.setComplainTime(new Date());
			iComplainService.addComplainInsertBean(complainInsertBean);
			logger.debug(complainInsertBean);
		}
		
		return "userJsp/yangmingjian/buyInAndOutRecord";
	}
	
}
