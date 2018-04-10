package com.cbd.entity;

/**
 * 消息推送实体类
 * @author 唐小雄
 *
 */
public class MessageEntity {

	private int messageId;			//id
	private UserEntity user;		//user
	private boolean messageIsRead;	//是否已读
	private String messageContent;	//消息详细
	
	public MessageEntity() {
		super();
	}

	public MessageEntity(int messageId, UserEntity user, boolean messageIsRead, String messageContent) {
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
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
