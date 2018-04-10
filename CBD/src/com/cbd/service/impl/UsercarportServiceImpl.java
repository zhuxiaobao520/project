package com.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbd.bean.Pager;
import com.cbd.bean.SaleBean;
import com.cbd.bean.UsercarportBean;
import com.cbd.bean.ReserveBuyBean;
import com.cbd.dao.IUsercarportDao;
import com.cbd.entity.UsercarportEntity;
import com.cbd.service.IUsercarportService;
/**
 * 个人车位信息dao层实现类
 * @author 唐小雄
 *
 */
@Component
public class UsercarportServiceImpl implements IUsercarportService {

	@Autowired
	private IUsercarportDao usercarportDao;
	@Override
	public UsercarportEntity getByIdUsercarport(int id) {
		// TODO Auto-generated method stub
		UsercarportEntity usercarportEntity = usercarportDao.getByIdUsercarport(id);
		return usercarportEntity;
	}

	/**
	 * 根据id修改车位审核状态
	 * @param id
	 * @return null
	 * @user 唐小雄
	 */
	public void updateByIdUsercarport(String userCarportAuditingStatus,int id){
		usercarportDao.updateByIdUsercarport(userCarportAuditingStatus, id);
	}

	/**
	 * 
	 * <p>Title:getUsercarportsByUserId</p>
	 * <p>Description:根据用户id查询所有车位空闲的车位</p>
	 * @author 杨明健
	 * @date2018年1月31日上午10:43:44
	 */
	@Override
	public List<UsercarportEntity> getUserCarportsByUserId(int id) {
		// TODO Auto-generated method stub
		List<UsercarportEntity> usercarportEntities = usercarportDao.getUserCarportsByUserId(id);
		return usercarportEntities;
	}

	/**
	 * 
	 * <p>Title:addSaleBySaleBean</p>
	 * <p>Description:根据返回的int的值来判断是否修改和增加成功</p>
	 * @author 杨明健
	 * @date2018年1月31日下午1:52:30
	 */
	@Override
	public boolean addSaleBySaleBean(SaleBean saleBean) {
		// TODO Auto-generated method stub
		int i = usercarportDao.addSaleBySaleBean(saleBean);
		if(i==2){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Title:addUsercarportByUsercarportBean</p>
	 * <p>Description:根据返回的int的值来判断是否增加成功</p>
	 * @author 杨明健
	 * @date2018年1月31日下午3:36:29
	 */
	@Override
	public boolean addUsercarportByUsercarportBean(UsercarportBean usercarportBean) {
		// TODO Auto-generated method stub
		int i = usercarportDao.addUsercarportByUsercarportBean(usercarportBean);
		if(i==1){
			return true;
		}
		return false;
	}

	@Override
	public Pager getPageUsercarport(int curPage, String endTime,int userId) {
		// TODO Auto-generated method stub
		Pager pager = usercarportDao.getPageUsercarport(curPage, endTime,userId);
		return pager;
	}

	@Override
	public int updateUserCarportStatusByUserCarportId(int userCarportId, String userCarportStatus) {
		// TODO Auto-generated method stub
		if(userCarportStatus.equals("未通过")){
			usercarportDao.deleteUserCarportById(userCarportId);
		}
		return usercarportDao.updateUserCarportStatusByUserCarportId(userCarportId, userCarportStatus);
	}

	@Override
	public boolean addReserveBuy(ReserveBuyBean reserveBuyBean) {
		// TODO Auto-generated method stub
		int i = usercarportDao.addReserveBuy(reserveBuyBean);
		if(i==1){
			return true;
		}
		return false;
	}

	@Override
	public Pager getUserOutCarportsByUserId(int userId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		int totalSize=usercarportDao.getUserOutCarPortById(userId);
		Pager pager =new Pager(pageSize, totalSize, currentPage);
		pager.setDatas(usercarportDao.getUserOutCarPortByParam(userId, pager.getStartIndex(), pageSize));
		return pager;
	}

	@Override
	public Pager getUserNullCarportByUserId(int userId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		int totalSize=usercarportDao.getUserNullCarPortById(userId);
		Pager pager =new Pager(pageSize, totalSize, currentPage);
		pager.setDatas(usercarportDao.getUserNullCarPortByParam(userId, pager.getStartIndex(), pageSize));
		return pager;
	}
}
