package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cbd.dao.IMessageDao;
import com.cbd.entity.MessageEntity;
import com.cbd.mapper.IMessageMapper;
import com.cbd.validator.Log;
/**
 * 消息推送Dao层实现类
 * @author 唐小雄
 *
 */
@Component
@Transactional
public class MessageDaoImpl implements IMessageDao {

	@Autowired
	private IMessageMapper messageMapper;
	
	/**
	 * 添加消息推送
	 * 唐小雄
	 */
	@Override
	@Log(operationType="数据库操作",operationName="添加消息）")
	public void addMessage(String yuanyin,int id) {
		// TODO Auto-generated method stub
		messageMapper.insertMessage(yuanyin, id);
	}

	/**
	 * 
	 * <p>Title:getAllMessagesByIsRead</p>
	 * <p>Description:查询已读或者未读全部消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:38:27
	 */
	@Override
	public List<MessageEntity> getAllMessagesByIsRead(boolean messageIsRead,int id) {
		// TODO Auto-generated method stub
		return messageMapper.getAllMessagesByIsRead(messageIsRead,id);
	}
	
	
	/**
	 * 
	 * <p>Title:getMessages</p>
	 * <p>Description:按页查询已读或者未读消息</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:38:56
	 */
	@Override
	public List<MessageEntity> getMessages(int starPage, int pageSize, boolean messageIsRead,int id) {
		// TODO Auto-generated method stub
		return messageMapper.getMessages(starPage, pageSize, messageIsRead,id);
	}

	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:根据消息id修改消息是否已读状态</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:46:59
	 */
	@Override
	@Log(operationType="数据库操作",operationName="根据消息id修改消息是否已读状态")
	public int updateMessageRead(int messageId) {
		return messageMapper.markMessageRead(messageId);
	}

	@Override
	@Log(operationType="数据库操作",operationName="根据消息id删除消息记录")
	public int deleteMessage(int messageId) {
		return messageMapper.deleteMessage(messageId);
	}

}
