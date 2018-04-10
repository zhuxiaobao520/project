package com.cbd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.service.IBuyInfoService;
import com.cbd.service.IUserService;
import com.cbd.service.IUsercarportService;

/**
 * 
 * <p>Title:buyCarportController</p>
 * <p>Description:购买车位页面控制器</p>
 * @author 杨明健
 * @date2018年1月31日下午5:07:17
 */
@Controller
public class BuyCarportController {
	@Autowired
	private IUsercarportService iUsercarportService;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IBuyInfoService iBuyInfoService;
	/**
	 * 
	 * <p>Title:buyCarport</p>
	 * <p>Description:进入购买车位页面</p>
	 * @author 杨明健
	 * @date2018年1月31日下午5:18:14
	 */
	@RequestMapping("jumpBuyCarport")
	public String buyCarport(){
		return "userJsp/zxb/buyCarportList";
	}
	
	/**
	 * 
	 * <p>Title:getBuyCarportList</p>
	 * <p>Description:分页显示出售车位信息ajax</p>
	 * @author 杨明健
	 * @date2018年2月1日下午4:07:38
	 */
	@RequestMapping("buyCarportPage")
	@ResponseBody
	public Pager getBuyCarportList(@RequestParam("curPage") int curPage,@RequestParam("endTime") String endTime,HttpSession session){
		UserBean userBean = (UserBean)session.getAttribute("userLogin");
		Pager pager = iUsercarportService.getPageUsercarport(curPage, endTime,userBean.getUserId());
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:userCaportMinuteInfo</p>
	 * <p>Description:显示出售的详细信息</p>
	 * @author 杨明健
	 * @date2018年2月1日下午4:08:49
	 */
	@RequestMapping("userCaportMinuteInfo")
	public String userCaportMinuteInfo(@RequestParam("saleId") int saleId,
									   @RequestParam("userCarportUserId") int userCarportUserId,
									   @RequestParam("info") String info,
									   ModelMap modelMap){
		UserBean saleUserBean = iUserService.selectUserById(userCarportUserId);
		modelMap.addAttribute("saleId", saleId);
		modelMap.addAttribute("saleUserBean", saleUserBean);
		modelMap.addAttribute("info", info);
		return "userJsp/zxb/userCaportMinuteInfo";
	}
	
	/**
	 * 
	 * <p>Title:reserveBuy</p>
	 * <p>Description:提交预定买车信息</p>
	 * @author 杨明健
	 * @date2018年2月1日下午5:17:27
	 */
	@RequestMapping("reserveBuy")
	public String reserveBuy(ReserveBuyBean reserveBuyBean,ModelMap modelMap){
		if(iBuyInfoService.getBuyInfoEntityByReserveBuyBean(reserveBuyBean)){
			modelMap.addAttribute("message", reserveBuyBean.getBuyInfoSaleId()+"号信息已预约过");
			return "userJsp/zxb/buyCarportList";
		}
		reserveBuyBean.setBuyInfoStatus("待交易");
		if(iUsercarportService.addReserveBuy(reserveBuyBean)){
			return "userJsp/zxb/buyCarportList";
		}
		return "userJsp/zxb/userCaportMinuteInfo";
	}
	
	@RequestMapping("returnBuyCarportList")
	public String returnBuyCarportList(){
		return "userJsp/zxb/buyCarportList";
	}
}
