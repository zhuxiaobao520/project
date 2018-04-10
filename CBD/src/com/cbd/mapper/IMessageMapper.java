package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.entity.MessageEntity;

/**
 * 消息推送mapper层
 * @author 唐小雄
 *
 */
public interface IMessageMapper extends SqlMapper{

	/**
	 * 添加消息推送
	 * 唐小雄
	 */
	@Insert("insert into t_message values(null,#{param2},0,#{param1})")
	public void insertMessage(String yuanyin,int id);
	
	
	/**
	 * 
	 * <p>Title:getMessages</p>
	 * <p>Description:按页查询当前用户未读或者已读消息</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:31:19
	 */
	@Select("select * from t_message where messageIsRead=#{param3} and messageUserId=#{param4} order by messageId DESC limit #{param1},#{param2} ")
	public List<MessageEntity> getMessages(int starPage,int pageSize,boolean messageIsRead,int id);
	
	
	/**
	 * 
	 * <p>Title:getAllMessagesByIsRead</p>
	 * <p>Description:查询当前用户所有已读或者未读消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日上午10:37:13
	 */
	@Select("select * from t_message where messageIsRead=#{param1} and messageUserId=#{param2}")
	public List<MessageEntity> getAllMessagesByIsRead(boolean messageIsRead,int id);
	
	
	/**
	 * 
	 * <p>Title:markMessageRead</p>
	 * <p>Description:根据消息id修改消息是否已读状态</p>
	 * @author 龙成
	 * @date2018年1月31日下午1:43:34
	 */
	@Update("update t_message set messageIsRead=1 where messageId=#{messageId}")
	public int markMessageRead(int messageId);
	
	
	/**
	 * 
	 * <p>Title:deleteMessage</p>
	 * <p>Description:根据消息id删除消息记录</p>
	 * @author 龙成
	 * @date2018年1月31日下午2:30:34
	 */
	@Delete("delete from t_message where messageId=#{messageId}")
	public int deleteMessage(int messageId);
	
}
