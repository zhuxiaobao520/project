package com.cbd.dao;

import java.util.List;

import com.cbd.entity.MessageEntity;

/**
 * 消息推送Dao层
 * @author 唐小雄
 *
 */
public interface IMessageDao {

	/**
	 * 添加消息推送
	 * 唐小雄
	 */
	public void addMessage(String yuanyin,int id);
	
	/**
	 * 
	 * <p>Title:getAllMessagesByIsRead</p>
	 * <p>Description:查询已读或者未读全部消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:38:27
	 */
	public List<MessageEntity> getAllMessagesByIsRead(boolean messageIsRead,int id);
	
	
	/**
	 * 
	 * <p>Title:getMessages</p>
	 * <p>Description:按页查询已读或者未读消息</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:38:56
	 */
	public List<MessageEntity> getMessages(int starPage,int pageSize,boolean messageIsRead,int id);
	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:根据消息id修改消息是否已读状态</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:46:59
	 */
	public int updateMessageRead(int messageId);
	
	/**
	 * 
	 * <p>Title:deleteMessage</p>
	 * <p>Description:根据消息id删除消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日下午2:32:37
	 */
	public int deleteMessage(int messageId);
	
}
