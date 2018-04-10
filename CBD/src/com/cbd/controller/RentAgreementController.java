package com.cbd.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.MultipartFile;


import com.cbd.bean.Pager;
import com.cbd.entity.CompanyEntity;
import com.cbd.entity.RenterAgreementEntity;
import com.cbd.service.ICarportService;
import com.cbd.service.ICompanyService;
import com.cbd.service.IRentAgreementService;

/**
 * 租户合约页面控制器
 * @author 刘芯宇
 * @Date 2018年2月1日
 */
@Controller
public class RentAgreementController {
	@Autowired
	private IRentAgreementService rentService;
	@Autowired
	private ICompanyService companyService;
	 @Autowired
	private ICarportService CarportService;
	 /**
	  * 跳转租户合约主页面
	  * @author 刘芯宇
	  * @Date 2018年2月7日
	  * @return
	  */
	 @RequestMapping("getIntoRent")
	 public String getIntoRentAggrement(){
		 return "/managerJsp/liuxinyuJSP/contractManagerJsp/rentsContract";
	 }
	/**
	 * 页面分页
	 * @author 刘芯宇
	 * @Date 2018年2月1日
	 * @param curPage
	 * @return
	 */
    @RequestMapping("rentContract")
    @ResponseBody
	public Pager getRentContract(@RequestParam("curPage") int curPage){
		Pager pager=rentService.getAgreementPage(curPage);
    	return pager;
	}
    /**
     * 根据id获取合同信息
     * @author 刘芯宇
     * @Date 2018年2月5日
     * @param id
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("rentContractExtension")
    public String  getExteriorContract(@RequestParam("id") int id,HttpSession session,ModelMap map){
    	RenterAgreementEntity rentEntity=rentService.findAgreementById(id);
    	 CompanyEntity companyEntity=companyService.getByIdCompany(rentEntity.getRenterAgreementCompanyId());     
    	 map.addAttribute("rentEntity", rentEntity);
    	 map.addAttribute("companyEntity", companyEntity);
    	return "/managerJsp/liuxinyuJSP/contractManagerJsp/rentContractExtension";
    }
    /**
     * 合同续约处理数据
     * @author 刘芯宇
     * @Date 2018年2月5日
     */
    @RequestMapping(value="addNewRentContract",method=RequestMethod.POST)
    public String addNewRentContract(@RequestParam("file") MultipartFile file,
    		                         RenterAgreementEntity rentEntity,
    		                         ModelMap modelMap)throws IllegalStateException,IOException{    	           	
    	rentEntity.setRenterAgreementStatus(1); 
    	CompanyEntity companyEntity=companyService.getByIdCompany(rentEntity.getRenterAgreementCompanyId());
    	if (file != null && !file.isEmpty()) {
			// 获取原始文件名		
			String filename = file.getOriginalFilename();

			String lastName = (filename.split("[.]"))[1];
		
			if(lastName.equals("jpg")||lastName.equals("gif")||lastName.equals("bmp")||lastName.equals("jepg")){
				rentEntity.setRenterAgreementUrl(System.currentTimeMillis()+file.getOriginalFilename());
				String path="F://"+File.separator+System.currentTimeMillis()+file.getOriginalFilename(); 
				File localfile= new File(path);
		    	file.transferTo(localfile);
			}else{	
				modelMap.addAttribute("rentEntity",rentEntity);
				modelMap.addAttribute("companyEntity", companyEntity);
				modelMap.addAttribute("message", "请传jpg/gif/bmp/jepg格式");
				return "/managerJsp/liuxinyuJSP/contractManagerJsp/rentContractExtension";
			}
    	}
    	  rentService.updateOldAgreement(rentEntity);    
          return  "/managerJsp/liuxinyuJSP/contractManagerJsp/rentsContract";        
    } 
  
  /**
   *  根据id修改解约合同状态   
   * @author 刘芯宇
   * @Date 2018年2月5日
   */
    @RequestMapping("breakRentContract")
    @ResponseBody
     public Pager  breakContract(@RequestParam("id") int id,
    		                      @RequestParam("curPage") int curPage){
    	RenterAgreementEntity rentEntity=rentService.findAgreementById(id);
    	Pager pager=new Pager();
    	if(rentEntity.getRenterAgreementStatus()==0){
    		pager=rentService.getAgreementPage(curPage);
    	}else{     
         rentService.updateAgreemrntById(id);
         pager=rentService.getAgreementPage(curPage);
    	}
    	 return  pager;
     }
    /**
     * 跳转到增加合同界面
     * @author 刘芯宇
     * @Date 2018年2月5日
     * @return
     */
    @RequestMapping("addAgreement")
    public String addAgreement(){
    	return "/managerJsp/liuxinyuJSP/contractManagerJsp/addRentContract";
    }
    /**
     * 添加新租户合同
     * @author 刘芯宇
     * @Date 2018年2月5日
     */
    @RequestMapping("addNewAgreement")
    public String addNewAgreement(RenterAgreementEntity rentEntity,ModelMap map){ 
    	 int renterAgreementId= rentService.updateOldAgreement(rentEntity);
    	if(rentEntity.getDatas()!=null){
    	for (Object  data : rentEntity.getDatas()) {
		  String address=data.toString();
		  String [] ds=address.split("-");
		    for(int i=0;i<ds.length;i++){	
		    	CarportService.updateCompanyId(ds[0], ds[1],rentEntity.getRenterAgreementCompanyId(),renterAgreementId);		    	
		    }
		  }
    	}else{
    	  map.addAttribute("carportMessage","无空闲车位");
    	  return  "/managerJsp/liuxinyuJSP/contractManagerJsp/addRentContract";
    	}
       return  "/managerJsp/liuxinyuJSP/contractManagerJsp/rentsContract";
    }
}
