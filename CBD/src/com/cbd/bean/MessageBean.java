package com.cbd.bean;

/**
 * 消息推送Bean
 * @author 唐小雄
 *
 */
public class MessageBean {

	private int messageId;			//id
	private UserBean user;		//user
	private boolean messageIsRead;	//是否已读
	private String messageContent;	//消息详细
	
	public MessageBean() {
		super();
	}

	public MessageBean(int messageId, UserBean user, boolean messageIsRead, String messageContent) {
		super();
		this.messageId = messageId;
		this.user = user;
		this.messageIsRead = messageIsRead;
		this.messageContent = messageContent;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public boolean getMessageIsRead() {
		return messageIsRead;
	}

	public void setMessageIsRead(boolean messageIsRead) {
		this.messageIsRead = messageIsRead;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Override
	public String toString() {
		return "MessageEntity [messageId=" + messageId + ", user=" + user + ", messageIsRead=" + messageIsRead
				+ ", messageContent=" + messageContent + "]";
	}
}
