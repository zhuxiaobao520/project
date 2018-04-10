package com.cbd.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbd.bean.CompanyBean;
import com.cbd.bean.Pager;
import com.cbd.entity.CompanyEntity;
import com.cbd.service.ICompanyService;
import com.cbd.util.Constant;
import com.cbd.util.UseMD5;

/**
 * 企业页面看控制器
 * @author 张平
 *
 */
@Controller
@SessionAttributes("companyLogin")
public class CompanyController {

	
	@Autowired
	private ICompanyService companyService;	
	/**
	 * 
	 * 
	 * <p>Title:returnCompanyMain</p>
	 * <p>Description:点击查看主页跳转企业主页面 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("checkInfo")
	public String returnCompanyMain(){
		return "companyJsp/wangjing/companyMain";
	}
	
	
	
	
	/**
	 * 
	 * 
	 * <p>Title:handleInfoRentCarports</p>
	 * <p>Description:返回企业车位信息 </p>
	 * @author 王菁
	 * @return Pager
	 */
	@RequestMapping("getCompanyCarport")
	@ResponseBody
	public Pager handleInfoRentCarports(@RequestParam("curPage") int currentPage,
			@RequestParam("companyCarport") String select,ModelMap modelMap){
		
		//获取登录企业用户
		CompanyBean cBean = (CompanyBean) modelMap.get("companyLogin");
		
		int cbdCarportRenterCompanyId = cBean.getCompanyId();
		Pager pager = null;
		if (select.equals("查看已租车位")) {
			pager = companyService.findAllCompanyRentCarport(currentPage, cbdCarportRenterCompanyId);
		} else if(select.equals("查看平台待租车位")) {
			pager = companyService.findAllCompanyCanRentCarpor(currentPage, cbdCarportRenterCompanyId);
		}
		return pager;
		
	}
	

	
	
	/**
	 * 
	 * 
	 * <p>Title:getCompanyInfo</p>
	 * <p>Description:点击修改资料跳转修改企业信息页面 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("changeInfo")
	public String getCompanyInfo(CompanyBean companyBean,ModelMap modelMap){
		
		CompanyBean cBean = (CompanyBean) modelMap.get("companyLogin");
		CompanyBean cBean2 = companyService.getCompanyById(cBean.getCompanyId());
		modelMap.addAttribute("nowCompanyBean", cBean2);
		return "companyJsp/wangjing/companyUpdateInfo";
		
	}
	
	/**
	 * 
	 * 
	 * <p>Title:updateCompanyInfo</p>
	 * <p>Description:修改企业信息 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("submitUpdateCompanyInfo")
	public String updateCompanyInfo(CompanyBean companyBean,ModelMap modelMap){
		
		CompanyBean cBean = (CompanyBean) modelMap.get("companyLogin");
		CompanyBean cBean2 = companyService.getCompanyById(cBean.getCompanyId());
		companyBean.setCompanyName(cBean2.getCompanyName());
		companyBean.setCompanyAddress(cBean2.getCompanyAddress());
		companyBean.setCompanyId(cBean2.getCompanyId());

		System.out.println(companyBean);
		if (!(companyBean.getCompanyAccount()).matches("[0-9a-zA-z]{5,25}")) {
			modelMap.addAttribute("messageFaile", "用户名只能为5-25个字母或数字");
			modelMap.addAttribute("nowCompanyBean", companyBean);
			return "companyJsp/wangjing/companyUpdateInfo";
		}else if (!(companyBean.getCompanyLinkMan()).matches("^[\\u4e00-\\u9fa5]*$")) {
			modelMap.addAttribute("messageFaileLink", "联系人姓名只能为2-10个汉字！");
			modelMap.addAttribute("nowCompanyBean", companyBean);
			return "companyJsp/wangjing/companyUpdateInfo";
		}
		
		
		if (!companyBean.getCompanyAccount().equals(cBean2.getCompanyAccount())) {
			CompanyBean findBean = companyService.getCompanyByName(companyBean.getCompanyAccount());
			if (findBean!=null) {
				modelMap.addAttribute("messageFaile", "用户名已存在！");
				modelMap.addAttribute("nowCompanyBean", companyBean);
				return "companyJsp/wangjing/companyUpdateInfo";
			}
		}

		//判断更新是否成功
		boolean update = companyService.updateCompanyInfo(companyBean);
			if (update) {
				return "companyJsp/wangjing/companyMain";
			} else {
				modelMap.addAttribute("nowCompanyBean", companyBean);
				return "companyJsp/wangjing/companyUpdateInfo";
			}
		
	}
	
	/**
	 * 
	 * 
	 * <p>Title:gotoUpdatePwdPage</p>
	 * <p>Description:点击修改密码跳转企业用户修改密码界面 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("changePwd")
	public String gotoUpdatePwdPage(){
		return "companyJsp/wangjing/companyUpdatePwd";
	}
	
	/**
	 * 
	 * 
	 * <p>Title:updateCompanyPwd</p>
	 * <p>Description:修改企业用户密码 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("submitUpdateCompanyPwd")
	public String updateCompanyPwd(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,ModelMap modelMap,HttpSession session){
		
		if (!newPassword.trim().matches("[0-9a-zA-z,.'*`]{6,16}")) {
			modelMap.addAttribute("failMessage2", "密码只能为6-16个字母、数字或下划线");
			return "companyJsp/wangjing/companyUpdatePwd";
		}
		
		
		boolean flag;
		CompanyBean cBean = (CompanyBean) modelMap.get("companyLogin");
		String oldPwd=UseMD5.md5MakePassword(oldPassword);
		String newPwd=UseMD5.md5MakePassword(newPassword);
		if (!oldPwd.equals(cBean.getCompanyPassword())) {
			modelMap.addAttribute("failMessage1", "原密码输入错误！");
			return "companyJsp/wangjing/companyUpdatePwd";
		} else if(newPwd.equals(cBean.getCompanyPassword())) {
			modelMap.addAttribute("failMessage2", "新密码不能与原密码相同！");
			return "companyJsp/wangjing/companyUpdatePwd";
		}else{
			flag=companyService.updateCompanyPwd(cBean.getCompanyId(),newPwd);
			if (flag) {
				session.removeAttribute("companyLogin");
				return "login";
			}
			
		} 
		return "companyJsp/wangjing/companyUpdatePwd";
	}
	
	/**
	 * 
	 * 
	 * <p>Title:returnCompanyMainPage</p>
	 * <p>Description:返回按钮返回企业主页面 </p>
	 * @author 王菁
	 * @return String
	 */
	@RequestMapping("returnCompanyMain")
	public String returnCompanyMainPage(){
		return "companyJsp/wangjing/companyMain";
	}
	
	
	

	
	/**
	 *  添加企业用户
	 * @author zhangping
	 * @date 2018年2月6日
	 * @param companyBean
	 * @param bindingResult
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="AddTheEnterprise",method=RequestMethod.POST)
	public String AddTheEnterprise(@Valid CompanyBean companyBean,BindingResult bindingResult,ModelMap modelMap){
		//判断数据校验结果
		if(bindingResult.hasErrors()){
			//打印校验错误信息
			List<FieldError>fieldErrors=bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				modelMap.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "managerJsp/tangxiaoxiongJSP/addAdminCompany";
		}
			
		//判断Service返回来的数据是否为真
		companyBean.setCompanyPassword(UseMD5.md5MakePassword(companyBean.getCompanyPassword()));
					int num = companyService.AddTheEnterprise(companyBean,companyBean.getCompanyAccount());
					if (num == 1) {
						modelMap.addAttribute("companyAccount","你输入的企业登录名已经存在");
						return "managerJsp/tangxiaoxiongJSP/addAdminCompany";
					}else if(num == 2){
						modelMap.addAttribute("company","你输入的企业名称已经存在");
						return "managerJsp/tangxiaoxiongJSP/addAdminCompany";
					}else if (num == 3) {
						return "managerJsp/tangxiaoxiongJSP/adminCompany";
					}
					return "managerJsp/tangxiaoxiongJSP/addAdminCompany";
	}

	/**
	 * 添加企业用户返回界面
	 * @author zhangping
	 * @date 2018年2月6日
	 * @return
	 */
	@RequestMapping(value="returnadminCompany")
	public String returnAdminCompany(){
		return "managerJsp/tangxiaoxiongJSP/adminCompany";
	}
	/**
	 * 
	 * @author zhangping
	 * @date 2018年2月6日
	 * 跳转到添加企业用户界面
	 * @return
	 */
	
	@RequestMapping(value="adminCompanyDetails")
	public String adminCompanyDetails(){
		return "managerJsp/tangxiaoxiongJSP/addAdminCompany";
	}
	
	/**
	 * 根据条件查询所有企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @return
	 */
	@RequestMapping("getAllCompany")
	@ResponseBody
	public Pager getAllCompany(@RequestParam(value="curPage") int curPage,
			@RequestParam(value="companyName") String companyName,
			@RequestParam(value="companyAddress") String companyAddress,
			@RequestParam(value="companyLinkMan") String companyLinkMan,
			@RequestParam(value="companyPhone") String companyPhone,
			ModelMap map) {
		Pager pager = companyService.getAllPageCompany(companyName, companyAddress, 
				companyLinkMan, companyPhone, curPage, Constant.PAGE_SIZE);
		return pager;
	}
	
	/**
	 * 根据id查询企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("companyxiangqing")
	public String getByIdCompany(@RequestParam(value="id") int id,ModelMap map) {
		CompanyEntity companyEntity = companyService.getByIdCompany(id);
		map.addAttribute("companyEntity", companyEntity);
		return "managerJsp/tangxiaoxiongJSP/adminCompanyDetails";
	}
	
	/**
	 * 根据ids删除企业用户
	 * @author 唐小雄
	 * @date 2018年2月1日
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("removebyidcompany")
	public String removeByIdCompany(@RequestParam(value="id") int id,ModelMap map) {
		companyService.removeByIdCompany(id);
		return "managerJsp/tangxiaoxiongJSP/adminCompany";
	}
	/**
	 * 获取所有的企业信息
	 * @author 刘芯宇
	 * @Date 2018年2月2日
	 * @return
	 */
	@RequestMapping("selectCompany")
	@ResponseBody
	public List<CompanyEntity> findAllCompany(){
		List<CompanyEntity> list=companyService.findAllCompany();
		return list;
	}
}
