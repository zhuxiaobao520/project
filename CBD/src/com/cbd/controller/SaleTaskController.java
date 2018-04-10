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
import com.cbd.bean.SaleTaskBean;
import com.cbd.bean.UserBean;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.entity.SaleEntity;
import com.cbd.service.IBuyInfoService;
import com.cbd.service.IMessageService;
import com.cbd.service.ISaleService;
import com.cbd.service.ISaleTaskService;
import com.cbd.service.IUsercarportService;

/**
 * 
 * <p>Title:SaleTaskController</p>
 * <p>Description:待办出售任务页面控制器</p>
 * @author 龙成
 * @date2018年2月2日上午10:41:32
 */
@Controller
@SessionAttributes("allSaleTaskBean")
public class SaleTaskController {
	@Autowired
	private ISaleTaskService saleTaskService;	
	
	@Autowired
	private IBuyInfoService buyInfoService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private ISaleService saleService;
	
	@Autowired
	private IUsercarportService usercarportService;
	
	/**
	 * 
	 * <p>Title:gotoSaleTaskPage</p>
	 * <p>Description:返回待办出售任务首页</p>
	 * @author 龙成
	 * @date2018年2月2日下午3:10:01
	 */
	@RequestMapping("dealSellTask")
	private String gotoSaleTaskPage(){
		return "userJsp/hxm/buyAndSellTask";
	}
	
	
	/**
	 * 
	 * <p>Title:getSaleTaskPage</p>
	 * <p>Description:展示待办出售任务页面控制器</p>
	 * @author 龙成
	 * @date2018年2月2日下午3:10:36
	 */
	@RequestMapping("sellTask")
	@ResponseBody
	public Pager getSaleTaskPage(
			@RequestParam(value="curPage") int curPage,
			HttpSession httpSession,
			ModelMap modelMap
			){
		/*** 获取登录用户的id*/
		UserBean user = (UserBean) httpSession.getAttribute("userLogin");
		int id = user.getUserId();
		Pager pager = saleTaskService.getSaleTaskPager(curPage, id);	
		/** 将pager中包含的租赁任务信息集合放入到session中，用于根据购买者id显示购买的信息 */
		modelMap.addAttribute("allSaleTaskBean", pager.getDatas());
		return pager;
	}
	
	
	
	/**
	 * 
	 * <p>Title:showSaleTaskInfo</p>
	 * <p>Description:查看详细待办出售信息</p>
	 * @author 龙成
	 * @date2018年2月2日下午3:11:12
	 */
	@RequestMapping("saleTaskInfo")
	public String showSaleTaskInfo(
			@RequestParam(value="buyInfoUserId") int buyInfoUserId,
			ModelMap modelMap,
			HttpSession session
			){
		/* 从session中获取到所有的待办出售任务集合 */
		List<SaleTaskBean> saleTaskBeans = (List<SaleTaskBean>) session.getAttribute("allSaleTaskBean");
		/* 循环找到与传进来的购买者id相同的出售任务 */
		SaleTaskBean saleTaskBean =null;
		for (int i = 0; i < saleTaskBeans.size(); i++) {
			if(saleTaskBeans.get(i).getUserEntity().getUserId() == buyInfoUserId){
				saleTaskBean = saleTaskBeans.get(i);
				break;
			}			
		}
		/* 将得到的待办出售任务Bean放入到modelMap中，将数据传入到返回的详细出售信息页面中 */
		modelMap.addAttribute("saleTaskBean", saleTaskBean);		
		return "userJsp/hxm/buyInfo";
	}
	
	/**
	 * 
	 * <p>Title:disagreeSell</p>
	 * <p>Description:不同意预约购买</p>
	 * @author 龙成
	 * @date2018年2月5日下午1:46:17
	 */
	@RequestMapping("disagreeSell")
	public String disagreeSell(
				@RequestParam(value="buyInfoUserId") int buyInfoUserId,
				@RequestParam(value="buyInfoId") int buyInfoId,
				@RequestParam(value="saleCarportId") int saleCarportId,
				@RequestParam(value="buyInfoSaleId") int buyInfoSaleId
			){
		
		/* 根据buyInfoId将购买信息状态该成交易失败*/
		buyInfoService.updateByIdBuyInfo(buyInfoId, "交易失败");
		/* 根据buyInfoSaleId查询出该车位的出售信息 */
		SaleEntity saleEntity = saleService.getByIdPageSale(buyInfoSaleId);
		/* 拼接提示信息，通过buyInfoUserId添加到消息表中 */
		String message="出售者未同意出售"+saleEntity.getSaleCarport().getUserCarportAddress()+
				saleEntity.getSaleCarport().getUserCarportAddressNo()+"车位,预约购买车位失败";
		messageService.insertMessage(message, buyInfoUserId);
		
		return "userJsp/hxm/buyAndSellTask";
	}
	
	/**
	 * 
	 * <p>Title:agreeSell</p>
	 * <p>Description:同意预约购买，申请网上签约</p>
	 * @author 龙成
	 * @date2018年2月5日下午1:45:58
	 */
	@RequestMapping("agreeSell")
	public String agreeSell(
			@RequestParam(value="buyInfoUserId") int buyInfoUserId,
			@RequestParam(value="buyInfoId") int buyInfoId,
			@RequestParam(value="saleCarportId") int saleCarportId,
			@RequestParam(value="buyInfoSaleId") int buyInfoSaleId,
			HttpSession session
			){
		/* 根据buyInfoId将购买状态改为申请签约 */
		buyInfoService.updateByIdBuyInfo(buyInfoId, "申请签约");
		
		/* 根据saleCarportId将个人车位的状态改为申请签约 */
		usercarportService.updateUserCarportStatusByUserCarportId(saleCarportId, "申请签约");
		
		/* 根据buyInfoSaleId和buyInfoId将其他预约购买该车位的购买状态改为交易失败 */
		buyInfoService.updateOtherUserbuyInfoStatus(buyInfoSaleId, buyInfoId, "交易失败");
		
		/* 根据buyInfoSaleId查询出该车位的出售信息 */
		SaleEntity saleEntity = saleService.getByIdPageSale(buyInfoSaleId);
		
		/* 从session中获取当前用户id,根据当前登录用户id，将已申请签约消息添加到消息表中 */		
		UserBean user = (UserBean) session.getAttribute("userLogin");
		int userId = user.getUserId();
		String message = "您的"+saleEntity.getSaleCarport().getUserCarportAddress()+
				saleEntity.getSaleCarport().getUserCarportAddressNo()+"车位申请网上签约成功，等待审核";
		messageService.insertMessage(message, userId);
		
		/* 根据buyInfoSaleId和buyInfoId查询出所有预约失败的集合，得到预约失败用户的id，并循环添加预约失败消息 */
		
		String messageFall = saleEntity.getSaleCarport().getUserCarportAddress()+
				saleEntity.getSaleCarport().getUserCarportAddressNo()+"车位出售者已与其他人申请网上签约，预约购买失败";
		List<BuyInfoEntity> list = buyInfoService.getBuyInfoEntitysBySaleIdInfoId(buyInfoSaleId, buyInfoId);
		if(list.size()>0){
			/* 循环得到预约失败用户id */
			for (int i = 0; i < list.size(); i++) {
				int id=list.get(i).getBuyInfoUser().getUserId();
				messageService.insertMessage(messageFall, id);
			}
		}	
		return "userJsp/hxm/buyAndSellTask";
	}
	
}















