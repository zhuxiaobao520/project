package com.cbd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.AgreementTaskBean;
import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.service.IAgreementService;

/**
 * 
 * <p>Title:AgreementTaskController</p>
 * <p>Description:合同待办页面控制器</p>
 * @author 杨明健
 * @date2018年2月2日下午2:16:54
 */
@Controller
public class AgreementTaskController {
	@Autowired
	private IAgreementService iAgreementService;
	
	/**
	 * 
	 * <p>Title:agreementTask</p>
	 * <p>Description:显示自己合同的ajax</p>
	 * @author 杨明健
	 * @date2018年2月2日下午4:03:02
	 */
	@RequestMapping("agreementTask")
	@ResponseBody
	public Pager agreementTask(@RequestParam("curPage") int curPage,@RequestParam("agreementType") String agreementType,HttpSession session){
		Pager pager = null;
		UserBean userBean =  (UserBean)session.getAttribute("userLogin");
		if(agreementType.equals("待签购买合同")){
			pager = iAgreementService.getBuyAgreementTaskPage(curPage, userBean.getUserId());
		}else{
			pager = iAgreementService.getSaleAgreementTaskPage(curPage, userBean.getUserId());
		}
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:buyAgreementTaskInfo</p>
	 * <p>Description:跳转到购买的合同详情界面</p>
	 * @author 杨明健
	 * @date2018年2月4日下午10:10:32
	 */
	@RequestMapping("buyAgreementTaskInfo")
	public String buyAgreementTaskInfo(@RequestParam("agreementId") int agreementId,@RequestParam("userId") int userId,ModelMap modelMap){
		AgreementTaskBean buyAgreementTaskBean = iAgreementService.getBuyAgreementTask(agreementId, userId);
		modelMap.addAttribute("buyAgreementTaskBean", buyAgreementTaskBean);
		return "userJsp/hxm/userBuyAgreement";
	}
	
	/**
	 * 
	 * <p>Title:saleAgreementTaskInfo</p>
	 * <p>Description:跳转到出售的合同详情界面</p>
	 * @author 杨明健
	 * @date2018年2月4日下午10:11:07
	 */
	@RequestMapping("saleAgreementTaskInfo")
	public String saleAgreementTaskInfo(@RequestParam("agreementId") int agreementId,@RequestParam("userId") int userId,ModelMap modelMap){
		AgreementTaskBean saleAgreementTaskBean = iAgreementService.getSaleAgreementTask(agreementId, userId);
		modelMap.addAttribute("saleAgreementTaskBean", saleAgreementTaskBean);
		return "userJsp/hxm/userSellAgreement";
	}
	
	/**
	 * 
	 * <p>Title:affirmAgreementTask</p>
	 * <p>Description:确认买方合同</p>
	 * @author 杨明健
	 * @date2018年2月4日下午10:15:04
	 */
	@RequestMapping("affirmBuyAgreementTask")
	public String affirmBuyAgreementTask(@RequestParam("agreementId") int agreementId){
		if(iAgreementService.updateBuyAgreementTask(agreementId)){
			return "userJsp/hxm/buyAndSellTask";
		}
		return "userJsp/hxm/userBuyAgreement";
	}
	
	/**
	 * 
	 * <p>Title:affirmSaleAgreementTask</p>
	 * <p>Description:确认卖方合同</p>
	 * @author 杨明健
	 * @date2018年2月5日上午12:13:15
	 */
	@RequestMapping("affirmSaleAgreementTask")
	public String affirmSaleAgreementTask(@RequestParam("agreementId") int agreementId){
		if(iAgreementService.updateSaleAgreementTask(agreementId)){
			return "userJsp/hxm/buyAndSellTask";
		}
		return "userJsp/hxm/userSellAgreement";
	}
}
