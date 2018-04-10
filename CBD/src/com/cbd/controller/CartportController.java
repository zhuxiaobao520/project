package com.cbd.controller;


import java.util.List;

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

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.bean.Pager;
import com.cbd.entity.CartportEntity;
import com.cbd.service.ICarportService;
import com.cbd.util.Constant;

/**
 * 车位管理页面控制器
 * @author 刘芯宇
 *
 */
@Controller
public class CartportController {
   @Autowired
	private ICarportService CarportService;
   

   /**
    * 车位管理页面分页（已合并迷糊查询）
    * @param curPage
    * @return
    */
/*	@RequestMapping("cartportPage")
	@ResponseBody
    public  Pager getCarport(@RequestParam("curPage") int curPage){	
	  Pager pager= CarportService.handleInfo(curPage, Constant.PAGE_SIZE);	
    	return pager;
    }	*/
   /**
    * 车位管理主页面
    * @author 刘芯宇
    * @Date 2018年2月7日
    * @return
    */
   @RequestMapping("getIntoCarport")
   public String getIntoCarport(){
	   return "/managerJsp/zhangping/carportManager";
   }
	/**
	 * 
	 * 模糊查询+分页功能一起
	 * @return
	 */
    @RequestMapping("carportSearch")
	@ResponseBody
	public Pager getSearch(CarportInfoBean carportInfoBean){
        carportInfoBean.setSize(Constant.PAGE_SIZE);
        carportInfoBean.setStartIndex((carportInfoBean.getCurPage()-1)*Constant.PAGE_SIZE); 
	     Pager pager=CarportService.searchInfo(carportInfoBean);
		 return pager;
	}
	/**
	 * 车位管理添加单个车位
	 * @return
	 */
	@RequestMapping("cartportSingle")
	public String getSingle(){
		return "/managerJsp/zhangping/single";	
	}
	@RequestMapping("carportAddSingle")
	public String addSingle(CarportBean carportBean,ModelMap map){		
	   boolean flag=false;
	   flag= CarportService.addSingle(carportBean);	
       if(flag){
    	   map.addAttribute("message", "车位已存在");
    	   return "/managerJsp/zhangping/single";
       }else{
    	   return "/managerJsp/zhangping/carportManager";
       }
	}
		
	/**
	 * 车位管理批量添加车位
	 * @return
	 */
	@RequestMapping("carportBatch")
	public String getBatch(){
		return "/managerJsp/zhangping/batch";
	}
	@RequestMapping("carportAddBatch")
	public String addBatch( CarportBean carportBean,ModelMap map){			
		
		CarportService.addRentCarport(carportBean);	
		return "/managerJsp/zhangping/carportManager";		    	
	}
	/**
	 * 获取平台空闲车位
	 * @author 刘芯宇
	 * @Date 2018年2月7日
	 * @return
	 */
	@RequestMapping("addCarport")
	@ResponseBody
	public List<CartportEntity> findNullCarport(){
		List<CartportEntity> list=CarportService.findNullCarport();
		return list;
	}	
}
