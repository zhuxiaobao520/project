package com.cbd.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cbd.bean.SaleBean;
import com.cbd.bean.UserBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IUsercarportService;

/**
 * 
 * <p>
 * Title:SellController
 * </p>
 * <p>
 * Description:出售车位页面控制器
 * </p>
 * 
 * @author 杨明健
 * @date2018年1月31日上午9:34:05
 */
@Controller
public class SaleController {
	@Autowired
	private IUsercarportService iUsercarportService;

	/**
	 * 
	 * <p>
	 * Title:saleInfo
	 * </p>
	 * <p>
	 * Description:进入出售信息界面
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日上午10:54:02
	 */
	@RequestMapping("jumpSaleCarport")
	public String saleInfo(ModelMap modelMap,HttpSession session) {
		UserBean userBean = (UserBean)session.getAttribute("userLogin");
		List<UsercarportEntity> usercarportEntities = iUsercarportService.getUserCarportsByUserId(userBean.getUserId());
		session.setAttribute("usercarportEntities", usercarportEntities);
		return "userJsp/zxb/user_buy_outInfo";
	}

	/**
	 * 
	 * <p>
	 * Title:addSale
	 * </p>
	 * <p>
	 * Description:添加出售信息
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午1:57:05
	 */
	@RequestMapping("addSale")
	public String addSale(SaleBean saleBean,ModelMap modelMap) {
		String sellPrice = saleBean.getSellPrice().trim();
		if(sellPrice.matches("([1-9][0-9]*[.]?[0-9]*)|([0][.][0-9]*[1-9])")){
			saleBean.setSalePrice(Double.parseDouble(sellPrice));
		}else{
			modelMap.addAttribute("salePrice", "出售价格不规范,只能输入数字");
			return "userJsp/zxb/user_buy_outInfo";
		}
		Date salePublishTime = new Date(System.currentTimeMillis());
		saleBean.setSalePublishTime(salePublishTime);
		if (iUsercarportService.addSaleBySaleBean(saleBean)) {
			modelMap.addAttribute("message", "添加出售信息成功");
			return "userJsp/userHome";
		}else{
			modelMap.addAttribute("Message", "添加出售信息不成功");
			return "userJsp/zxb/user_buy_outInfo";
		}	
	}

	/**
	 * 
	 * <p>
	 * Title:addNewUserCarport
	 * </p>
	 * <p>
	 * Description:进入添加新出售车位界面
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午2:48:02
	 */
	@RequestMapping("addNewUserCarport")
	public String addNewUserCarport() {
		return "userJsp/zxb/addNewUserCarport";
	}

	/**
	 * 
	 * <p>
	 * Title:addNewCarport
	 * </p>
	 * <p>
	 * Description:添加新车位
	 * </p>
	 * 
	 * @author 杨明健
	 * @date2018年1月31日下午3:15:28
	 */
	@RequestMapping(value="addNewCarport",method=RequestMethod.POST)
	public String addNewCarport(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,HttpSession session) throws IllegalStateException,IOException{
		UsercarportBean usercarportBean = new UsercarportBean();
		usercarportBean.setUserCarportAuditingStatus("待审");
		UserBean userBean = (UserBean)session.getAttribute("userLogin");
		usercarportBean.setUserCarportUserId(userBean.getUserId());
		String userCarportPropertityRight = request.getParameter("userCarportPropertityRight").trim();
		String userCarportAddress = request.getParameter("userCarportAddress").trim();
		String userCarportAddressNo = request.getParameter("userCarportAddressNo").trim();
		if(userCarportPropertityRight!=null&&!userCarportPropertityRight.equals("")&&userCarportPropertityRight.matches("[A-Za-z0-9]+")){
			usercarportBean.setUserCarportPropertityRight(userCarportPropertityRight);
		}else{
			modelMap.addAttribute("userCarportPropertityRight", "车位产权证不规范,只能输入字母或数字");
			return "userJsp/zxb/addNewUserCarport";
		}
		if(userCarportAddress!=null&&!userCarportAddress.equals("")&&userCarportAddress.matches("[\\u4e00-\\u9fa5]*[0-9]+[号]")){
			usercarportBean.setUserCarportAddress(userCarportAddress);
		}else{
			modelMap.addAttribute("userCarportAddress", "车位地址不规范,格式:红瓦寺110号");
			return "userJsp/zxb/addNewUserCarport";
		}
		if(userCarportAddressNo!=null&&!userCarportAddressNo.equals("")&&userCarportAddressNo.matches("[A-Za-z0-9]+")){
			usercarportBean.setUserCarportAddressNo(userCarportAddressNo);
		}else{
			modelMap.addAttribute("userCarportAddressNo", "车位编号不规范,只能输入字母或数字");
			return "userJsp/zxb/addNewUserCarport";
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
						usercarportBean.setUserCarportImageUrl(filename);
						File localFile = new File("F:/"+filename);
						file.transferTo(localFile);
					}else{
						modelMap.addAttribute("message", "请传jpg/gif/bmp/jepg格式");
						return "userJsp/zxb/addNewUserCarport";
					}
				}else{
					modelMap.addAttribute("message", "文件不能为空");
					return "userJsp/zxb/addNewUserCarport";
				}
			}
		}
		if (iUsercarportService.addUsercarportByUsercarportBean(usercarportBean)) {
			modelMap.addAttribute("message", "添加新车位成功");
			return "userJsp/userHome";
		}
		modelMap.addAttribute("message", "添加新车位不成功");
		return "userJsp/zxb/addNewUserCarport";
	}
	
	@RequestMapping("addReturn")
	public String addReturn(){
		return "userJsp/userHome";
	}
}
