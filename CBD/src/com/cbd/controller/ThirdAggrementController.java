package com.cbd.controller;



import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cbd.bean.CarportBean;
import com.cbd.bean.Pager;
import com.cbd.bean.ThirdAgreementBean;
import com.cbd.entity.ThirdAgreementEntity;
import com.cbd.service.ICarportService;
import com.cbd.service.IThirdAgreementService;
import com.cbd.util.DateUtil;

/**
 * 
 * <p>Title:ThirdAggrementController</p>
 * <p>Description:外部合约管理页面控制器</p>
 * @author 龙成
 * @date2018年1月29日下午4:03:09
 */

@Controller
public class ThirdAggrementController {


	@Autowired
	private IThirdAgreementService thirdAgreementService;
	
	@Autowired
	private ICarportService carportService;
	
	/**
	 * 
	 * <p>Title:gotoThirdAggrementManagement</p>
	 * <p>Description:跳转到合约管理页面</p>
	 * @author 龙成
	 * @date2018年1月29日下午4:07:47
	 */
	@RequestMapping("thirdAggrementManagement")
	public String gotoThirdAggrementManagement(){
		return "managerJsp/longcheng/thirdAggrementManagement";
	}
	
	
	/**
	 * 
	 * <p>Title:gotoAddThirdAggrementManagement</p>
	 * <p>Description:跳转到添加外部合约页面</p>
	 * @author 龙成
	 * @date2018年1月30日上午11:09:19
	 */
	@RequestMapping("addThirdAggrement")
	public String gotoAddThirdAggrementManagement(){
		
		return "managerJsp/longcheng/addThirdAggrementManagement";
	}
	

	/**
	 * 
	 * 
	 * <p>Title:handleInfo</p>
	 * <p>Description: 第三方合约分页数据</p>
	 * @author 王菁
	 * @return Pager
	 */
	@RequestMapping("thirdAggrementPage")
	@ResponseBody
	public Pager handleInfo(@RequestParam("curPage") int currentPage){
		
		Pager pager = thirdAgreementService.handleInfo(currentPage);
		return pager;
	}


	/**
	 * 
	 * 
	 * <p>Title:addThirdAgreement</p>
	 * <p>Description:添加合约 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("submitAddThirdAggrement")
	public String addThirdAgreement(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap)throws IllegalStateException,IOException{
		ThirdAgreementBean thirdAgreementBean=new ThirdAgreementBean();
		thirdAgreementBean.setThirdAggrementCompany(request.getParameter("thirdAggrementCompany"));
		thirdAgreementBean.setThirdAggrementCompanyAddress(request.getParameter("thirdAggrementCompanyAddress"));
		thirdAgreementBean.setThirdAggrementEndTime(DateUtil.strToDate(request.getParameter("thirdAggrementEndTime"), "yyyy-MM-dd"));
		thirdAgreementBean.setThirdAggrementLinkMan(request.getParameter("thirdAggrementLinkMan"));
		thirdAgreementBean.setThirdAggrementLinkManPhone(request.getParameter("thirdAggrementLinkManPhone"));
		thirdAgreementBean.setThirdAggrementNewNo(request.getParameter("thirdAggrementNewNo"));
		thirdAgreementBean.setThirdAggrementPrice(Double.parseDouble(request.getParameter("thirdAggrementPrice")));
		thirdAgreementBean.setThirdAggrementStartTime(DateUtil.strToDate(request.getParameter("thirdAggrementStartTime"), "yyyy-MM-dd"));
		thirdAgreementBean.setThirdAggrementStatus(1);
		
		//判断生效日期跟截止日期
		if(thirdAgreementBean.getThirdAggrementStartTime().getTime()>thirdAgreementBean.getThirdAggrementEndTime().getTime()){
			modelMap.addAttribute("timeError", "日期不符合（生效日期大于截止日期）");
			return "managerJsp/longcheng/addThirdAggrementManagement";
		}
		
		// 创建通用多文件解析器实例
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
				// 判断是否有文件上传
				if (multipartResolver.isMultipart(request)) {
					// 获取上传文件名
					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
					Iterator<String> iterator = multiRequest.getFileNames();
					// 遍历上传的文件名
					while (iterator.hasNext()) {
						// 获取上传的文件
						MultipartFile file = multiRequest.getFile(iterator.next());
						if (file != null && !file.isEmpty()) {
							// 获取原始文件名		
							String filename = file.getOriginalFilename();
				
							String lastName = (filename.split("[.]"))[1];
						
							if(lastName.equals("jpg")||lastName.equals("gif")||lastName.equals("bmp")||lastName.equals("jepg")){
								thirdAgreementBean.setThirdAggrementImageUrl(filename);
								File localFile = new File("F:/"+filename);
								file.transferTo(localFile);
							}else{
						
								modelMap.addAttribute("message", "请传jpg/gif/bmp/jepg格式");
								return "managerJsp/longcheng/addThirdAggrementManagement";
							}
						}
					}
				}
		
		boolean flag = thirdAgreementService.addThirdAgreement(thirdAgreementBean); 
		if (flag) {
			int thirdAgreementId=thirdAgreementService.getThirdAgreementIdByNewNo(thirdAgreementBean.getThirdAggrementNewNo());
			CarportBean carportBean=new CarportBean();
			carportBean.setCbdCarportAddress(request.getParameter("cbdCarportAddress"));
			carportBean.setCbdCarporStartNo(request.getParameter("cbdCarportAddressNoBegin"));
			carportBean.setCbdCarporSum(Integer.parseInt(request.getParameter("cbdCarportTotalNum")));
			carportBean.setCbdCarportAddressNo(request.getParameter("cbdCarportAreaAddress"));
			carportBean.setCbdCarportThirdAggremenId(thirdAgreementId);
			carportService.addManyCarport(carportBean);
			return "managerJsp/longcheng/thirdAggrementManagement";
		} else {
			modelMap.addAttribute("Message", "添加合约失败！请核对信息！");
			return "managerJsp/longcheng/addThirdAggrementManagement";
		}
		
	}


	/**
	 * 
	 * 
	 * <p>Title:cancleAgreement</p>
	 * <p>Description:第三方合约解约 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@RequestMapping("terminationThirdAggrementPage")
	@ResponseBody
	public Pager cancleAgreement(@RequestParam("curPage") int currentPage,
			@RequestParam("thirdAggrementId") int thirdAggrementId){
		carportService.deleteManyCarport(thirdAggrementId);
		
		boolean flag = thirdAgreementService.deleteAgreement(thirdAggrementId);;
		Pager pager=new Pager();
			if (flag) {
				pager = thirdAgreementService.handleInfo(currentPage);
			
		}else {
			pager = thirdAgreementService.handleInfo(currentPage);
		}
		return pager;	
}	
	
	
	/**
	 * 
	 * 
	 * <p>Title:continueAgreement</p>
	 * <p>Description:根据Id查询续约的合约信息 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("continueThirdAggrement")
	public String continueAgreement(@RequestParam("thirdAggrementId") int thirdAggrementId,ModelMap modelMap){
		
		ThirdAgreementBean thirdAgreementBean = 
				thirdAgreementService.selectThirdAgreementById(thirdAggrementId);
		thirdAgreementBean.setThirdAggrementId(thirdAggrementId);
		modelMap.addAttribute("nowThirdAgreement", thirdAgreementBean);
		return "managerJsp/longcheng/continueThirdAggrementManagement";
	}
	
	/**
	 * 
	 * 
	 * <p>Title:updateAgreement</p>
	 * <p>Description:第三方合约续约 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("submitContinueThirdAggrement")
	public String updateAgreement(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap)throws IllegalStateException,IOException{
		
		ThirdAgreementBean thirdAgreementBean=new ThirdAgreementBean();
		thirdAgreementBean.setThirdAggrementId(Integer.parseInt(request.getParameter("thirdAggrementId")));
		thirdAgreementBean.setThirdAggrementEndTime(DateUtil.strToDate(request.getParameter("thirdAggrementEndTime"), "yyyy-MM-dd"));
		thirdAgreementBean.setThirdAggrementNewNo(request.getParameter("thirdAggrementNewNo"));
		thirdAgreementBean.setThirdAggrementStartTime(DateUtil.strToDate(request.getParameter("thirdAggrementStartTime"), "yyyy-MM-dd"));
		thirdAgreementBean.setThirdAggrementImageUrl(request.getParameter("thirdAggrementImageUrl"));
		
		//判断生效日期跟截止日期
				if(thirdAgreementBean.getThirdAggrementStartTime().getTime()>thirdAgreementBean.getThirdAggrementEndTime().getTime()){
					modelMap.addAttribute("timeError", "日期不符合（生效日期大于截止日期）");
					return "managerJsp/longcheng/addThirdAggrementManagement";
				}
		
		// 创建通用多文件解析器实例
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
				// 判断是否有文件上传
				if (multipartResolver.isMultipart(request)) {
					// 获取上传文件名
					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
					Iterator<String> iterator = multiRequest.getFileNames();
					// 遍历上传的文件名
					while (iterator.hasNext()) {
						// 获取上传的文件
						MultipartFile file = multiRequest.getFile(iterator.next());
						if (file != null && !file.isEmpty()) {
							// 获取原始文件名		
							String filename = file.getOriginalFilename();
							
							String lastName = (filename.split("[.]"))[1];
						
							if(lastName.equals("jpg")||lastName.equals("gif")||lastName.equals("bmp")||lastName.equals("jepg")){
								thirdAgreementBean.setThirdAggrementImageUrl(filename);
								File localFile = new File("F:/"+filename);
								file.transferTo(localFile);
							}else{
								modelMap.addAttribute("message", "请传jpg/gif/bmp/jepg格式");
								return "managerJsp/longcheng/continueThirdAggrementManagement";
							}
						}
					}
				}
		
				Boolean flag=thirdAgreementService.updateAgreement(thirdAgreementBean);
				if(flag){
					return "managerJsp/longcheng/thirdAggrementManagement";
				}
				return "managerJsp/longcheng/continueThirdAggrementManagement";
		
	}
	
}
