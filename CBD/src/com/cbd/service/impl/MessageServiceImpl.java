package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.dao.IMessageDao;
import com.cbd.entity.MessageEntity;
import com.cbd.service.IMessageService;
/**
 * 消息推送逻辑层实现类
 * @author 唐小雄
 *
 */
@Component
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private IMessageDao messageDao;
	
	/**
	 * 添加消息推送
	 * 唐小雄
	 */
	@Override
	public void insertMessage(String yuanyin,int id) {
		// TODO Auto-generated method stub
		messageDao.addMessage(yuanyin, id);
	}

	/**
	 * 	
	 * <p>Title:getMessagePage</p>
	 * <p>Description:根据页面要求，获取消息PagerBean对象</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:46:00
	 */
	@Override
	public Pager getMessagePage(int curPage, boolean messageIsRead,int id) {
		Pager messagePage = new Pager();
		int totalRecorNum  = messageDao.getAllMessagesByIsRead(messageIsRead,id).size();
		int pageSize = messagePage.getPageSize();
		int totalPageNum = totalRecorNum%pageSize==0?totalRecorNum/pageSize:(totalRecorNum/pageSize+1);
		int startIndex = (curPage-1)*pageSize;		
		List<MessageEntity> datas = messageDao.getMessages(startIndex, pageSize, messageIsRead,id);
		
		messagePage.setCurrentPage(curPage);
		messagePage.setDatas(datas);
		messagePage.setStartIndex(startIndex);
		messagePage.setTotalPageNum(totalPageNum);
		messagePage.setTotalRecorNum(totalRecorNum);
		
		return messagePage;
	}

	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:根据消息id修改消息是否已读状态</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:46:59
	 */
	@Override
	public boolean markMessageRead(int messageId) {
		boolean result = false;
		int num = messageDao.updateMessageRead(messageId);
		if(num != 0){
			result = true;
		}
		return result;
	}

	/**
	 * 
	 * <p>Title:deleteMessage</p>
	 * <p>Description:根据消息id删除消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日下午2:32:37
	 */
	@Override
	public boolean deleteMessage(int messageId) {
		boolean result = false;
		int num = messageDao.deleteMessage(messageId);
		if(num != 0){
			result = true;
		}
		return result;
	}

}
