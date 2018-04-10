package com.cbd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbd.bean.AdminBean;
import com.cbd.bean.AgreementBean;
import com.cbd.bean.AgreementInfoBean;
import com.cbd.bean.AgreementInsertBean;
import com.cbd.bean.BuyDetailBean;
import com.cbd.bean.Pager;
import com.cbd.entity.AdminEntity;
import com.cbd.entity.AgreementEntity;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IAdminService;
import com.cbd.service.IAgreementService;
import com.cbd.service.IBuyInfoService;
import com.cbd.service.IMessageService;
import com.cbd.service.IUsercarportService;
import com.cbd.util.Constant;
import com.cbd.util.UseMD5;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;


/**
 * 
 * <p>Title:AdminController</p>
 * <p>Description:管理员页面控制器 </p>
 * @author 朱小宝
 * @date2018年1月29日下午1:56:07
 */
@Controller
@SessionAttributes("adminLogining")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUsercarportService usercarportService;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private IBuyInfoService buyInfoService;
	@Autowired
	private IAgreementService agreementService;
	
	private UsercarportEntity usercarportEntity;
	
	private static Logger logger=Logger.getLogger(AdminController.class);
	
	
	/**
	 * 
	 * <p>Title:getAdmins</p>
	 * <p>Description: 根据页数返回数据（包含总页数，每页记录等）</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@RequestMapping("adminPage")
	@ResponseBody
	public Pager getAdmins(@RequestParam("curPage")int curPage){
		
		Pager pager=adminService.getAdminsByPage(curPage);
		logger.debug(pager.getDatas());
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:goToAdminInfoList</p>
	 * <p>Description: 跳转到员工信息界面</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("goToAdminInfoList")
	public String goToAdminInfoList(){
		return "managerJsp/hxm/superAdmin";
	}
	
	/**
	 * 
	 * <p>Title:goToUPdatePwdPage</p>
	 * <p>Description:跳转到修改密码界面 </p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("goToUpdateSuperPwd")
	public String goToUPdatePwdPage(){
		
		return "managerJsp/hxm/updateSuperAdmin";
	}
	
	/**
	 * 
	 * <p>Title:updateSuperAdminPassword</p>
	 * <p>Description:修改超级管理员密码 </p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("updateSuperAdmin")
	public String updateSuperAdminPassword(@RequestParam("oldPassword")String oldPassword,
			@RequestParam("newPassword")String newPassword,ModelMap modelMap){
		AdminBean adminBean=(AdminBean) modelMap.get("adminLogining");
		String oldPwd=UseMD5.md5MakePassword(oldPassword);
		String regex="\\S{6,16}";
		
		if(oldPwd.equals(adminBean.getAdminPassword())){
			if(!newPassword.matches(regex)){
				modelMap.addAttribute("pwdError", "密码为6-16位非空字串");
				return "managerJsp/hxm/updateSuperAdmin";
			}
			Boolean flag=adminService.updateSuperAdminPassword(UseMD5.md5MakePassword(newPassword));
			if(flag){
				return "login";
			}
		}
		modelMap.addAttribute("superAdminPwdError", "原密码错误");
		return "managerJsp/hxm/updateSuperAdmin";
	}
	
	/**
	 * 
	 * <p>Title:goToAddAdminPage</p>
	 * <p>Description:跳转到添加员工界面 </p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("goToAddAdmin")
	public String goToAddAdminPage(){
		return "managerJsp/hxm/addAdmin";
	}

	/**
	 * 
	 * <p>Title:addAdminByParam</p>
	 * <p>Description: 添加员工</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("addAdmin")
	public String addAdminByParam(@Valid AdminBean adminBean,BindingResult bindingResult,
			ModelMap modelMap){
		logger.debug(adminBean);
		//判断数据校验结果
		if(bindingResult.hasErrors()){
			//打印校验错误信息
			List<FieldError>fieldErrors=bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				modelMap.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "managerJsp/hxm/addAdmin";
		}
		if(adminBean.getAdminAgreementManagerPower()==0 && adminBean.getAdminCarPortManagerPower()==0
				 && adminBean.getAdminCompaintManagerPower()==0 && adminBean.getAdmiUserManagerPower()==0 ){
			modelMap.addAttribute("agreementErrorInfo", "至少选择一个权限");
			return "managerJsp/hxm/addAdmin";
		}
		adminBean.setAdminPassword(UseMD5.md5MakePassword(adminBean.getAdminPassword()));
		Boolean flag=adminService.addAdminByParam(adminBean);
		if(flag){
			return "managerJsp/hxm/superAdmin";
		}
		return "managerJsp/hxm/addAdmin";
	}

	/**
	 * <p>Title:getAdminInfoById</p>
	 * <p>Description:根据选中表格的Id查询管理员信息 </p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("getCheckedAdmin")
	public String getAdminInfoById(@RequestParam("adminId")int adminId,ModelMap modelMap){
		
		AdminEntity adminEntity=adminService.getAdminInfoById(adminId);
		modelMap.addAttribute("CheckedAdmin", adminEntity);
		return "managerJsp/hxm/adminInfo";
	}
	
	/**
	 * 
	 * <p>Title:updateAdminInfoById</p>
	 * <p>Description: 根据选中表格的Id获取修改管理员信息</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("updateCheckedAdmin")
	public String updateAdminInfoById(@RequestParam("adminId")int adminId,ModelMap modelMap){
		
		AdminEntity adminEntity=adminService.getAdminInfoById(adminId);
		modelMap.addAttribute("CheckedAdmin", adminEntity);
		return "managerJsp/hxm/updateAdminPower";
	}
	
	/**
	 * 
	 * <p>Title:updateAdminPower</p>
	 * <p>Description: 修改管理员权限</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("updateAdminPower")
	public String updateAdminPower(AdminBean adminBean){
		
		Boolean flag=adminService.updateAdminPower(adminBean);
		if(flag){
			return "managerJsp/hxm/superAdmin";
		}
		return "managerJsp/hxm/updateAdminPower";
	}
	
	/**
	 * 
	 * <p>Title:deleteAdminInfo</p>
	 * <p>Description: 删除管理员信息</p>
	 * @author 朱小宝
	 * @return Pager
	 */
	@RequestMapping("deleteAdminInfo")
	@ResponseBody
	public Pager deleteAdminInfo(@RequestParam("adminId")int adminId,
			@RequestParam("curPage")int curPage){
		Boolean flag=adminService.deleteAdminInfo(adminId);
		
	
		if(flag){
			Pager pager=adminService.getAdminsByPage(curPage);
			/**
			 * 判断是否删除最后一页仅有的一个记录
			 */
			if(curPage>pager.getTotalPageNum()&&pager.getTotalPageNum()!=0){
				curPage=curPage-1;
				pager=adminService.getAdminsByPage(curPage);
			}
			if(pager.getTotalPageNum()<=1){
				curPage = 1;
				pager=adminService.getAdminsByPage(curPage);
			}
			logger.debug(pager.getDatas());
			return pager;
		}
		return null;
	}
	
	/**
	 * 查询所有待审车位
	 * @return 唐小雄
	 */
	@RequestMapping("getAllDaiShenUser")
	@ResponseBody
	public Pager getAllDaiShenUser(@RequestParam(value="curPage") int page){
		Pager pager = adminService.getAllDaiZuUser(page, 3);
		return pager;
	}
	/**
	 * 查询所有待处理车位
	 * @return List<Object>
	 * 唐小雄
	 */
	@RequestMapping("getAllDaiChuLiUser")
	@ResponseBody
	public Pager getAllDaiChuLiUser(@RequestParam(value="curPage") int page){
		Pager pager = agreementService.getAllApplyForAgreementBuyInfoPager(page, Constant.PAGE_SIZE);
		return pager;
	}
	
	/**
	 * 待审车位详情
	 * ：唐小雄
	 */
	@RequestMapping("daishencheweixiangqing")
	public String getByIdDaiShenUsercarport(@RequestParam(value="id") int id,ModelMap map){
		UsercarportEntity usercarportEntity = usercarportService.getByIdUsercarport(id);
		map.addAttribute("usercarportEntity", usercarportEntity);
		this.usercarportEntity = usercarportEntity;
		return "managerJsp/liuxinyuJSP/adminManager/cartportNoPass";
	}
	
	/**
	 * 
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @param id
	 * @param map
	 * @return 待处理车位详情
	 */
	@RequestMapping("daichulicheweixiangqing")
	public String getByIdDaiChuLiUsercarport(@RequestParam(value="id") int id,ModelMap map){
		BuyDetailBean buyDetailBean = agreementService.getApplyForAgreementBuyDetailBean(id);
		map.addAttribute("buyDetailBean", buyDetailBean);
		return "managerJsp/liuxinyuJSP/adminManager/signContract";
	}
	
	/**
	 * 根据id修改车位审核状态
	 * ：唐小雄 
	 */
	@RequestMapping("updateByIdUsercarport")
	public String updateByIdDaiZuUsercarport(@RequestParam(value="id") int id,
			@RequestParam(value="userid") int userid,
			@RequestParam(value="userCarportAuditingStatus") String userCarportAuditingStatus,
			ModelMap map){
		if (userCarportAuditingStatus.equals("未通过")) {
			map.addAttribute("usercarportEntity", this.usercarportEntity);
			return "managerJsp/liuxinyuJSP/adminManager/cartportApply";
		}
		String stasus = "出售";
		UsercarportEntity usercarportEntity = usercarportService.getByIdUsercarport(id);
		if (usercarportEntity.getUserCarportAuditingStatus().equals("待租")) {
			stasus = "出租";
		}
		messageService.insertMessage("你申请" + stasus + "的车位“" + 
				usercarportEntity.getUserCarportAddress() + "-" + 
				usercarportEntity.getUserCarportAddressNo() +
				"”已经通过审核。",userid);
		usercarportService.updateByIdUsercarport(userCarportAuditingStatus, id);
		return "managerJsp/liuxinyuJSP/adminManager/adminManager";
	}
	
	/**
	 * 根据id修改车位审核状态（未通过）
	 * ：唐小雄 
	 */
	@RequestMapping("insertMessage")
	public String insertMessage(@RequestParam(value="id") int id,
			@RequestParam(value="yuanyin") String yuanyin,
			@RequestParam(value="userid") int userid,
			ModelMap map){
			String stasus = "出售";
			UsercarportEntity usercarportEntity = usercarportService.getByIdUsercarport(id);
			if (usercarportEntity.getUserCarportAuditingStatus().equals("待租")) {
				stasus = "出租";
			}
			messageService.insertMessage("你申请" + stasus + "的车位“" + 
					usercarportEntity.getUserCarportAddress() + "-" + 
					usercarportEntity.getUserCarportAddressNo() +
					"”未通过审核，"+ "原因是：" + yuanyin + "。",userid);
			usercarportService.updateByIdUsercarport("未通过", id);
			return "managerJsp/liuxinyuJSP/adminManager/adminManager";
	}


	/**
	 * 通知双方消息推送，告诉他们合约通过,并根据id修改购买信息审核状态为‘交易成功’
	 * @author 唐小雄
	 * @date 2018年1月31日
	 * @return 
	 */
	@RequestMapping("tongzhishuangfang")
	public String bothAdvised(@RequestParam(value="agreementCarportId") int agreementCarportId,
			@RequestParam(value="agreementBuyInfoId") int agreementBuyInfoId,
			@RequestParam(value="agreementNo") String agreementNo) {
		AgreementInsertBean agreementInsertBean = new AgreementInsertBean();
		agreementInsertBean.setAgreementBuyInfoId(agreementBuyInfoId);
		agreementInsertBean.setAgreementNo(agreementNo);
		agreementInsertBean.setAgreementCarportId(agreementCarportId);
		agreementInsertBean.setAgreementTime(new Date());
		agreementService.addAgreement(agreementInsertBean);
		return "managerJsp/liuxinyuJSP/adminManager/adminManager";
	}
	
	
	/**
	 * 跳转到普通管理员修改信息的界面
	 * @author yinshi
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping("updateAdminPersonalInfo")
	public String goToAdminPersonalInfo(){
		return "managerJsp/tangxiaoxiongJSP/updateAdminManager";
	}

	
	/**
	 * 跳转到用户管理员主页面
	 * @author yinshi
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping("jumpUserAdmin")
	public String goToAdminManager(){
		return "managerJsp/liuxinyuJSP/adminManager/adminManager";
	}
	/**
	 * 跳转到车位管理员主界面
	 * @author yinshi
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping("jumpCarAdmin")
	public String goToCarportHome(){
		return "managerJsp/zhangping/carportManager";
	}
	
	/**
	 * 跳转到合约管理主界面
	 * @author yinshi
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping("jumpAgreementAdmin")
	public String goToRentHome(){
		return "managerJsp/liuxinyuJSP/contractManagerJsp/rentsContract";
	}
	
	
	/**
	 * 跳转到投诉管理员的主界面
	 * @author yinshi
	 * @date 2018年2月2日
	 * @return
	 */
	@RequestMapping("jumpComplainAdmin")
	public String goToConplain(){
		return "managerJsp/yangmingjian/adminComplaint";
	}
	
	/**
	 * 跳转到用户车位详情界面
	 * @author 唐小雄
	 * @date 2018年2月5日
	 * @return
	 */
	@RequestMapping("jumpcartportNoPass")
	public String goToCartportNoPass(){
		return "managerJsp/liuxinyuJSP/adminManager/cartportNoPass";
	}
	/**
	 * 
	 * @author 姚刚
	 * @date 2018年2月7日
	 * @return
	 */
	@RequestMapping("jumpCompanyAdmin")
	public String goToCompanyHome(){
		return "managerJsp/tangxiaoxiongJSP/adminCompany";
	}
	/**
	 * 
	 * <p>Title:judgeAdminNo</p>
	 * <p>Description: 判断工号是否存在</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("juageAdminNo")
	@ResponseBody
	public List<String> judgeAdminNo(@RequestParam("adminNo")String adminNo){
		logger.debug(adminNo);
		AdminEntity adminEntity=adminService.getAdminByAdminNo(adminNo);
		if(adminEntity!=null){
			List<String> list=new ArrayList<>();
			list.add("工号已存在");
			return list;
		}
		List<String>list =new ArrayList<>();
		list.add("");
		return list;
	}
	
	/**
	 * 
	 * <p>Title:judgeAdminAccount</p>
	 * <p>Description: 判断用户名是否存在</p>
	 * @author 朱小宝
	 * @return String
	 */
	@RequestMapping("juageAdminAccount")
	@ResponseBody
	public List<String> judgeAdminAccount(@RequestParam("adminAccount")String adminAccount){
		logger.debug(adminAccount);
		AdminBean adminBean=adminService.getAdminByAdminName(adminAccount);
		if(adminBean!=null){
			List<String> list=new ArrayList<>();
			list.add("用户名已存在");
			return list;
		}
		List<String>list =new ArrayList<>();
		list.add("");
		return list;
	}
}
