package com.cbd.service;

import java.util.List;

import com.cbd.bean.Pager;
import com.cbd.entity.MessageEntity;

/**
 * 消息推送逻辑层
 * @author 唐小雄
 *
 */
public interface IMessageService {

	/**
	 * 添加消息推送
	 * 唐小雄
	 */
	public void insertMessage(String yuanyin,int id);
	
	/**
	 * 	
	 * <p>Title:getMessagePage</p>
	 * <p>Description:根据页面要求，获取消息PagerBean对象</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:46:00
	 */
	public Pager getMessagePage(int curPage,boolean messageIsRead,int id);
	
	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:根据消息id修改消息是否已读状态</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:49:15
	 */
	public boolean markMessageRead(int messageId);
	
	/**
	 * 
	 * <p>Title:deleteMessage</p>
	 * <p>Description:根据消息id删除消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日下午2:35:06
	 */
	public boolean deleteMessage(int messageId);
	
}
