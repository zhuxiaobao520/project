package com.cbd.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.ComplainBean;
import com.cbd.bean.Pager;
import com.cbd.entity.BuyInfoEntity;
import com.cbd.entity.RentInEntity;
import com.cbd.entity.RentOutEntity;
import com.cbd.entity.SaleEntity;
import com.cbd.service.IComplainService;
import com.cbd.validator.Log;

/**
 * 投诉管理
 * <p>Title:ComplaintController</p>
 * <p>Description:</p>
 * @author 杨明健
 * @date2018年1月30日下午4:43:32
 */
@Controller
public class ComplaintController {
	
	@Autowired
	private IComplainService complainService;
	/**
	 * 进入投诉管理界面
	 * <p>Title:complaint</p>
	 * <p>Description:</p>
	 * @author 杨明健
	 * @date2018年1月30日下午4:44:28
	 */
	@RequestMapping("adminComplaint")
	public String complaint(){
		return "managerJsp/yangmingjian/adminComplaint";
	}
	
	/**
	 * 
	 * <p>Title:complaintInfo</p>
	 * <p>Description: 根据页面显示每页数据</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@RequestMapping("complaintPage")
	@ResponseBody
	public Pager complaintInfo(@RequestParam("curPage")int curPage){
		Pager pager=complainService.getComplainByPage(curPage);
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:getComplainInfo</p>
	 * <p>Description: 选中相应的投诉记录，根据id查看详细信息</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@RequestMapping("getComplainInfoById")
	public String getComplainInfo(@RequestParam("complaintId")int complaintId,ModelMap modelMap){
		
		HashMap<String, Object>map=complainService.getComplainInfoById(complaintId);
		ComplainBean complainBean=(ComplainBean) map.get("complainInfo");
		if(complainBean.getComplainEventType().equals("招租") || complainBean.getComplainEventType().equals("租赁")){
			RentInEntity rentInEntity=(RentInEntity) map.get("eventObject");
			RentOutEntity rentOutEntity=rentInEntity.getRentOutEntity();
			modelMap.addAttribute("eventObject", rentOutEntity);
		}else{
			BuyInfoEntity buyInfoEntity=(BuyInfoEntity) map.get("eventObject");
			SaleEntity saleEntity=buyInfoEntity.getBuyInfoSale();
			modelMap.addAttribute("eventObject", saleEntity);
		}
		
		modelMap.addAttribute("complainInfo", map.get("complainInfo"));
		return "managerJsp/yangmingjian/complaintInfo";
	}
	
	/**
	 * 
	 * <p>Title:solveComplain</p>
	 * <p>Description:处理投诉信息 </p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("solveComplain")
	public String solveComplain(@RequestParam("complaintCheckedId")int complainId,
			@RequestParam("clickType")String complainStatus){
		Boolean flag=complainService.updateComplainStatus(complainId, complainStatus);
		if(flag){
			return "managerJsp/yangmingjian/adminComplaint";
		}
		return null;
	}
}
