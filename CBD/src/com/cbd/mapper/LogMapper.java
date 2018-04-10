package com.cbd.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cbd.bean.LogBean;
/**
 * 日志映射
 * @author 姚刚
 *
 */

public interface LogMapper extends SqlMapper {
	/**
	 * 分页查询日志
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param startIndex
	 * @param pageSize
	 * @param logOperationType 操作类型：登录注销，数据库操作
	 * @param logType 日志类型 :前台，后台
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Select("<script>" + "select * from t_log <where>"
	+ "<if test=\"param3 !=null \">"
	+"and logOperationType like concat('%',#{param3},'%') </if>"
	+ "<if test=\"param4 !=null \">"
	+"and logType like concat('%',#{param4},'%') </if>"
	+ "<if test=\"param5 !=null \">"
	+"and logTime >=#{param5} </if>"
	+ "<if test=\"param6 !=null \">"
	+"and logTime &lt;=#{param6} </if>"
	+ "</where>"
	+ "<if test=\"param1 >=0 and param2>=0\">" 
	  +" limit #{param1},#{param2} "
	 +"</if>"
	+"</script>"
			)
	@Results(value={
			@Result(column="logId",property="logId",id=true),
			@Result(column="logAccount",property="logAccount"),
			@Result(column="userCarportAddress",property="userCarportAddress"),
			@Result(column="userCarportAddressNo",property="userCarportAddressNo"),
			@Result(column="rentOutStartTime",property="rentOutStartTime"),
			@Result(column="rentOutStartTime",property="rentOutStartTime")
	})
	
	/**
	 * 模糊查询日志记录数
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param logOperationType 操作类型：登录注销，数据库操作
	 * @param logType 日志类型 :前台，后台
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<LogBean>getLogBeans(int startIndex,int pageSize,String logOperationType,String logType,Date startTime,Date endTime);
	@Select("<script>" + "select count(*) from t_log <where>"
			+ "<if test=\"param1 !=null \">"
			+"and logOperationType like concat('%',#{param1},'%') </if>"
			+ "<if test=\"param2 !=null \">"
			+"and logType like concat('%',#{param2},'%') </if>"
			+ "<if test=\"param3 !=null \">"
			+"and logTime >=#{param3} </if>"
			+ "<if test=\"param4 !=null \">"
			+"and logTime &lt;=#{param4} </if>"
			+ "</where>"
			+"</script>"
					)
	public int getLogBeansNum(String logOperationType,String logType,Date startTime,Date endTime);

	/**
	 * 插入日志
	 * @author 姚刚
	 * @date 2018年2月2日
	 * @param logBean
	 */
	@Insert("Insert into t_log values(null,#{logAccount},#{logTime},#{logIp},#{logOperationType}"
			+ ",#{logType},#{logOperationContent})")
	public void addLogBeans(LogBean logBean);
	
}
