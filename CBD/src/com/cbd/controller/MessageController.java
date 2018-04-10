package com.cbd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbd.bean.Pager;
import com.cbd.bean.UserBean;
import com.cbd.service.IMessageService;

/**
 * 
 * <p>Title:MessageController</p>
 * <p>Description:消息提醒页面控制器</p>
 * @author 龙成
 * @date2018年1月31日上午10:25:49
 */
@Controller
public class MessageController {	
	@Autowired
	private IMessageService messageService;
	
	/**
	 * 
	 * <p>Title:gotoMessagePage</p>
	 * <p>Description:跳转到个人消息页面控制器</p>
	 * @author 龙成
	 * @date2018年1月31日上午11:36:31
	 */
	@RequestMapping("userMessage")
	public String gotoMessagePage(){
		return "userJsp/hxm/userMessage";
	}
	
	
	
	/**
	 * 
	 * <p>Title:getMessagePage</p>
	 * <p>Description:获取分页数据页面控制器</p>
	 * @author 龙成
	 * @date2018年1月31日上午11:34:38
	 */
	@RequestMapping("messagePage")
	@ResponseBody
	public Pager getMessagePage(
			@RequestParam(value="curPage") int curPage,
			@RequestParam(value="msgIsRead") String isRead,
			HttpSession httpSession
			){
		boolean messageIsRead = false;
		if("已读消息".equals(isRead)){
			messageIsRead = true;
		}
		/*** 获取登录用户的id*/
		UserBean user = (UserBean) httpSession.getAttribute("userLogin");
		int id = user.getUserId();
		
		Pager pager = messageService.getMessagePage(curPage, messageIsRead,id);
		return pager;
	}
	
	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:个人消息标记已读页面控制器</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:39:36
	 */
	@RequestMapping("markRead")
	@ResponseBody
	public Pager markMessageRead(
			@RequestParam(value="curPage") int curPage,
			@RequestParam(value="msgIsRead") String isRead,
			HttpSession httpSession,
			@RequestParam(value="messageId") int messageId
			){
		messageService.markMessageRead(messageId);
		Pager pager=getMessagePage(curPage, isRead, httpSession);
		if(curPage>pager.getTotalPageNum()&&pager.getTotalPageNum()!=0){
			curPage=curPage-1;
			pager = getMessagePage(curPage, isRead, httpSession);
		}
		if(pager.getTotalPageNum()<=1){
			curPage = 1;
			pager = getMessagePage(curPage, isRead, httpSession);
		}
		return pager;
	}
	
	
	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:个人消息删除页面控制器</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:39:36
	 */
	@RequestMapping("deleteMessage")
	@ResponseBody
	public Pager deleteMessage(
			@RequestParam(value="curPage") int curPage,
			@RequestParam(value="msgIsRead") String isRead,
			HttpSession httpSession,
			@RequestParam(value="messageId") int messageId
			){	
		messageService.deleteMessage(messageId);
		Pager pager=getMessagePage(curPage, isRead, httpSession);
		if(curPage>pager.getTotalPageNum()&&pager.getTotalPageNum()!=0){
			curPage=curPage-1;
			pager = getMessagePage(curPage, isRead, httpSession);
		}
		if(pager.getTotalPageNum()<=1){
			curPage = 1;
			pager = getMessagePage(curPage, isRead, httpSession);
		}
		return pager;
	}
	
	/**
	 * 
	 * <p>Title:getMsgNum</p>
	 * <p>Description:实时查询未读消息数量</p>
	 * @author 龙成
	 * @date2018年2月5日上午10:35:01
	 */
	@RequestMapping("getMsgNum")
	@ResponseBody
	public int getMsgNum(HttpSession httpSession){
		/* 获取登录用户的id*/
		UserBean user = (UserBean) httpSession.getAttribute("userLogin");
		if(user==null){
			return 0;
		}
		int id = user.getUserId();
		/* 获取未读消息数量 */
		Pager pager = messageService.getMessagePage(1, false,id);	
		return pager.getTotalRecorNum();
	}
}











