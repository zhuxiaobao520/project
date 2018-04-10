package com.cbd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cbd.bean.ComplainBean;
import com.cbd.bean.ComplainInsertBean;
import com.cbd.bean.Pager;
import com.cbd.entity.ComplainEntity;

/**
 * 
 * <p>Title:ComplainDao</p>
 * <p>Description: 投诉信息Dao层接口</p>
 * @author 朱小宝
 * @date2018年2月1日下午2:49:31
 */
public interface IComplainDao {

	/**
	 * 
	 * <p>Title:getComplainsList</p>
	 * <p>Description: 得到所有的空闲、暂缓处理的投诉记录</p>
	 * @author 朱小宝
	 * @return List<ComplainEntity>
	 */
	public List<ComplainEntity> getComplainsList();
	
	/**
	 * 
	 * <p>Title:getComplainByPage</p>
	 * <p>Description:根据页数得到相应的数据 </p>
	 * @author 朱小宝
	 * @return Pager
	 */
	public Pager getComplainByPage(int curPage);
	
	/**
	 * 
	 * <p>Title:getComplainById</p>
	 * <p>Description: 根据Id查询被选中的投诉记录信息</p>
	 * @author 朱小宝
	 * @return ComplainBean
	 */
	public ComplainBean getComplainById(int id);
	
	/**
	 * 
	 * <p>Title:updateComplainStatus</p>
	 * <p>Description:修改投诉状态 </p>
	 * @author 朱小宝
	 * @return int
	 */
	public int updateComplainStatus(int id,String complainStatus);
	
	/**
	 * 新增投诉记录
	 * @author yg
	 * @date 2018年2月2日
	 * @param complainInsertBean 包含投诉记录
	 * @return
	 */
	public int addComplainInsertBean(ComplainInsertBean complainInsertBean);
	
	
	/**
	 * 判断事件是否被用户投诉
	 * @author yg
	 * @date 2018年2月2日
	 * @param complainUserId 投诉人Id
	 * @param complainEventId 事件id 
	 * @param complainEventType 事件类型:招租，租赁，出售，购买
	 * @return
	 */
	public int getComplainNumByComplainUserIdAndEventId(int complainUserId,int complainEventId,String complainEventType);
}
