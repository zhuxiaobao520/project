package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.ComplainBean;
import com.cbd.bean.ComplainInsertBean;
import com.cbd.entity.ComplainEntity;

/**
 * 
 * <p>Title:ComplainMapper</p>
 * <p>Description: 投诉信息Mapper接口</p>
 * @author 朱小宝
 * @date2018年2月1日下午2:48:46
 */
public interface ComplainMapper extends SqlMapper{

	/**
	 * <p>Title:getComplainsList</p>
	 * <p>Description: 得到所有的空闲、暂缓处理的投诉记录</p>
	 * @author 朱小宝
	 * @return List<ComplainEntity>
	 */
	@Select("select * from t_complain where complainStatus='未处理' or complainStatus='暂缓处理'")
	@Results({  
	    @Result(id=true,property="complainId",column="complainId"),  
	    @Result(property="complainEventId",column="complainEventId"),  
	    @Result(property="complainEventType",column="complainEventType"),  
	    @Result(property="complainStatus",column="complainStatus"),  
	    @Result(property="complainTime",column="complainTime"),  
	    @Result(property="complainMessage",column="complainMessage"),  
	    @Result(property="complainUser",column="complainUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")),  
	    @Result(property="complainedUser",column="complainedUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")) 
	})  
	public List<ComplainEntity> getComplainsList();
	
	/**
	 * 
	 * <p>Title:getComplainByPage</p>
	 * <p>Description:根据页数得到相应的数据 </p>
	 * @author 朱小宝
	 * @return List<ComplainEntity>
	 */
	@Select("select * from t_complain where complainStatus='未处理' or complainStatus='暂缓处理' limit #{param1},#{param2}")
	@Results({  
	    @Result(id=true,property="complainId",column="complainId"),  
	    @Result(property="complainEventId",column="complainEventId"),  
	    @Result(property="complainEventType",column="complainEventType"),  
	    @Result(property="complainStatus",column="complainStatus"),  
	    @Result(property="complainTime",column="complainTime"),  
	    @Result(property="complainMessage",column="complainMessage"),  
	    @Result(property="complainUser",column="complainUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")),  
	    @Result(property="complainedUser",column="complainedUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")) 
	})  
	public List<ComplainEntity>getComplainByPage(int starPage,int pageSize);
	
	/**
	 * 
	 * <p>Title:getComplainById</p>
	 * <p>Description: 根据Id查询被选中的投诉记录信息</p>
	 * @author 朱小宝
	 * @return ComplainBean
	 */
	@Select("select * from t_complain where complainId=#{id}")
	@Results({  
	    @Result(id=true,property="complainId",column="complainId"),  
	    @Result(property="complainEventId",column="complainEventId"),  
	    @Result(property="complainEventType",column="complainEventType"),  
	    @Result(property="complainStatus",column="complainStatus"),  
	    @Result(property="complainTime",column="complainTime"),  
	    @Result(property="complainMessage",column="complainMessage"),  
	    @Result(property="complainUser",column="complainUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")),  
	    @Result(property="complainedUser",column="complainedUserId",one=@One(select="com.cbd.mapper.UserMapper.getByIdUser")) 
	})  
	public ComplainBean getComplainById(int id);
	
	/**
	 * 
	 * <p>Title:updateComplainStatus</p>
	 * <p>Description:修改投诉状态 </p>
	 * @author 朱小宝
	 * @return int
	 */
	@Update("update t_complain set complainStatus=#{param2} where complainId=#{param1}")
	public int updateComplainStatus(int id,String complainStatus);
	
	/**
	 * 新增投诉记录
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param complainInsertBean 包含投诉记录
	 * @return
	 */
	@Insert("insert into t_complain values(null,#{complainUserId},#{complainedUserId},#{complainEventId},#{complainEventType},#{complainStatus},#{complainMessage},#{complainTime})")
	public int addComplainInsertBean(ComplainInsertBean complainInsertBean);
	
	/**
	 * 判断事件是否被用户投诉
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param complainUserId 投诉人Id
	 * @param complainEventId 事件id 
	 * @param complainEventType 事件类型:招租，租赁，出售，购买
	 * @return
	 */
	@Select("SELECT COUNT(*) from t_complain WHERE complainUserId=#{param1} and complainEventId=#{param2} and complainEventType=#{param3}")
	public int getComplainNumByComplainUserIdAndEventId(int complainUserId,int complainEventId,String complainEventType);
}
