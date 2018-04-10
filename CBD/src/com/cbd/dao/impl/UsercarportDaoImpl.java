package com.cbd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.AllSaleInfoBean;
import com.cbd.bean.Pager;
import com.cbd.bean.SaleBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.dao.IUsercarportDao;
import com.cbd.entity.UsercarportEntity;
import com.cbd.mapper.IMessageMapper;
import com.cbd.mapper.UsercarportMapper;
import com.cbd.validator.Log;
/**
 * 个人车位信息dao层实现类
 * @author 唐小雄
 *
 */
@Component
public class UsercarportDaoImpl implements IUsercarportDao {

	@Autowired
	private UsercarportMapper usercarportMapper;
	@Autowired
	private IMessageMapper iMessageMapper;
	@Override
	public UsercarportEntity getByIdUsercarport(int id) {
		// TODO Auto-generated method stub
		UsercarportEntity usercarportEntity = usercarportMapper.getByIdUsercarport(id);
		return usercarportEntity;
	}
	
	/**
	 * 根据id修改车位审核状态
	 * @param id
	 * @return null
	 * @user 唐小雄
	 */
	@Override
	@Log(operationType="数据库操作",operationName="根据id修改车位审核状态")
	public void updateByIdUsercarport(String userCarportAuditingStatus, int id) {
		// TODO Auto-generated method stub
		usercarportMapper.updateByIdUsercarport(userCarportAuditingStatus, id);
	}

	/**
	 * 
	 * <p>Title:getUsercarportsByUserId</p>
	 * <p>Description:根据用户id查询所有车位空闲的车位</p>
	 * @author 杨明健
	 * @date2018年1月31日上午10:29:21
	 */
	@Override
	public List<UsercarportEntity> getUserCarportsByUserId(int id) {
		// TODO Auto-generated method stub
		List<UsercarportEntity> usercarportEntities = usercarportMapper.getUserCarportsByUserId(id);
		return usercarportEntities;
	}

	/**
	 * 
	 * <p>Title:addSaleBySaleBean</p>
	 * <p>Description:根据出售信息的车位id更改车位表的车位状态和根据出售信息添加车位的出售信息表</p>
	 * @author 杨明健
	 * @date2018年1月31日下午1:45:46
	 */
	@Override
	@Log(operationType="数据库操作",operationName="根据出售信息的车位id更改车位表的车位状态和根据出售信息添加车位的出售信息表")
	public int addSaleBySaleBean(SaleBean saleBean) {
		// TODO Auto-generated method stub
		int i = usercarportMapper.updateUserCarportStatusByUserCarportId(saleBean.getSaleCarportId(), "待售");
		int j =  usercarportMapper.addSaleBySaleBean(saleBean);
		i = i + j;
		return i;
	}

	/**
	 * 
	 * <p>Title:addUsercarportByUsercarportBean</p>
	 * <p>Description:先根据个人车位的车位产权证编号查询，再添加新车位</p>
	 * @author 杨明健
	 * @date2018年1月31日下午3:31:54
	 */
	@Override
	@Log(operationType="数据库操作",operationName="先根据个人车位的车位产权证编号查询，再添加新车位")
	public int addUsercarportByUsercarportBean(UsercarportBean usercarportBean) {
		// TODO Auto-generated method stub
		int i = 0;
		UsercarportEntity usercarportEntity = usercarportMapper.getUsercarportByUserCarportPropertityRight(usercarportBean);
		if(usercarportEntity==null){
			i = usercarportMapper.addUsercarportByUsercarportBean(usercarportBean);
		}
		return i;
	}


	/**
	 * 
	 * <p>Title:getAllUsercarport</p>
	 * <p>Description:分页查询所有出售车位的信息</p>
	 * @author 杨明健
	 * @date2018年2月1日上午11:13:21
	 */
	@Override
	public Pager getPageUsercarport(int curPage, String endTime,int userId) {
		// TODO Auto-generated method stub
		List<AllSaleInfoBean> list = usercarportMapper.getAllUsercarport(userId);
		Pager pager = new Pager(3, list.size(), curPage);
		List<AllSaleInfoBean>  allSaleInfoBeans = usercarportMapper.getPageUsercarport(pager.getStartIndex(), 3, endTime,userId);
		pager.setDatas(allSaleInfoBeans);
		return pager;
	}


	@Override
	@Log(operationType="数据库操作",operationName="根据车位id更改车位表的车位状态")
	public int updateUserCarportStatusByUserCarportId(int userCarportId, String userCarportStatus) {
		// TODO Auto-generated method stub
		return usercarportMapper.updateUserCarportStatusByUserCarportId(userCarportId, userCarportStatus);
	}

	/**
	 * 
	 * <p>Title:addReserveBuy</p>
	 * <p>Description:添加预定车位购买信息</p>
	 * @author 杨明健
	 * @date2018年2月1日下午5:23:39
	 */
	@Override
	@Log(operationType="数据库操作",operationName="添加预定车位购买信息")
	public int addReserveBuy(ReserveBuyBean reserveBuyBean) {
		// TODO Auto-generated method stub
		int i = usercarportMapper.addReserveBuy(reserveBuyBean);
		String yuanyin = "有预约买车位的消息:"+reserveBuyBean.getBuyInfoMassage();
		iMessageMapper.insertMessage(yuanyin, reserveBuyBean.getMessageUserId());
		return i;
	}

	@Override
	public void deleteUserCarportById(int userCarportId) {
		// TODO Auto-generated method stub
		usercarportMapper.deleteUserCarportById(userCarportId);
	}

	@Override
	public int getUserOutCarPortById(int userId) {
		// TODO Auto-generated method stub
		return usercarportMapper.getUserOutCarPortById(userId);
	}

	@Override
	public List<UsercarportBean> getUserOutCarPortByParam(int userId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return usercarportMapper.getUserOutCarPortByParam(userId,startIndex,pageSize);
	}

	@Override
	public int getUserNullCarPortById(int userId) {
		// TODO Auto-generated method stub
		return usercarportMapper.getUserNullCarPortById(userId);
	}

	@Override
	public List<UsercarportBean> getUserNullCarPortByParam(int userId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return usercarportMapper.getUserNullCarPortByParam(userId, startIndex, pageSize);
	}


}
