package com.cbd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbd.bean.CarportBean;
import com.cbd.bean.CarportInfoBean;
import com.cbd.entity.CartportEntity;
/**
 * 车位管理mapper
 * @author 刘芯宇
 * @Date 2018年2月7日
 */
public interface CartportMapper extends SqlMapper {
     
	  @Select("select * from t_cbdcartport where cbdCarportAddressNo=#{cbdCarportAddressNo}")
	 public CarportBean findCarport(CarportBean carportBean);
	/**
	  * 单个添加车位
	  * @author 刘芯宇
	  * @Date 2018年2月7日
	  * @param carportBean
	  */
	  @Insert("insert into t_cbdcartport(cbdCarportAddress,cbdCarportAddressNo) values(#{cbdCarportAddress },#{cbdCarportAddressNo })")
	  public void insertSingle(CarportBean carportBean);
	  /**
	   * 车位管理模糊查询
	   * @author 刘芯宇
	   * @Date 2018年2月5日
	   * @param carportInfoBean
	   * @return
	   */
  @Select("<script>"
	           +"select count(*) from t_cbdcartport"
			   +"<where>"
	           +"<if test=\"site !=null\">"
			   +"and cbdCarportAddress like concat('%',#{site},'%')"
	           +"</if>"
			   +"<if test=\"number !=null\">"
			   +" and  cbdCarportAddressNo like concat('%',#{number},'%')"
			   +"</if>"			 
			   +"</where>"
			   +"</script>")
	  public int searchAll(CarportInfoBean carportInfoBean);
	  /**
	   * 车位管理模糊分页
	   * @author 刘芯宇
	   * @Date 2018年2月5日
	   * @param carportInfoBean
	   * @return
	   */
	  @Select("<script>"
	           +"select * from t_cbdcartport"
			   +"<where>"
	           +"<if test=\"site !=null\">"
			   +"and  cbdCarportAddress like concat('%',#{site},'%') "
	           +"</if>"
			   +"<if test=\"number !=null\">"
			   +" and cbdCarportAddressNo like concat('%',#{number},'%')"
			   +"</if>"	 
				+"</where>"
				+"limit #{startIndex},#{size}"
				+"</script>")
	  public List<CartportEntity> searchPage(CarportInfoBean carportInfoBean);
	  /**
	   * 查询所有的空闲车位
	   * @author 刘芯宇
	   * @Date 2018年2月5日
	   * @return
	   */
	  @Select("select * from t_cbdcartport where cbdCarportStutas=0")
	  public List<CartportEntity> findNullCarport();
	  
	  /**
	   * 批量添加租户车位
	   * @author 刘芯宇
	   * @Date 2018年2月6日
	   * @param carportBeans
	   */
	  @Insert("<script>"+
	            "insert into t_cbdcartport(cbdCarportAddress, cbdCarportAddressNo, cbdCarportRenterAgreementId) "
	            + "values "
	            + "<foreach collection =\"list\" item=\"carport\" index= \"index\" separator =\",\"> "
	            + "(#{carport.cbdCarportAddress},#{carport.cbdCarportAddressNo},#{carport.cbdCarportRenterAgreementId}) "
	            + "</foreach > "
	            + "</script>")
	  public void addRentAgreement(@Param("list") List<CarportBean>carportBeans);
	  
	  /**
      * 车位绑定相应企业id
      * @author 刘芯宇
      * @Date 2018年2月5日
      * @param cbdCarportAddress
      * @param cbdCarportAddressNo
      * @param CompanyId
      */
	  @Update("update t_cbdcartport set cbdCarportRenterCompanyId=#{param3},cbdCarportStutas=1,cbdCarportRenterAgreementId=#{param4} where cbdCarportAddress=#{param1} and cbdCarportAddressNo=#{param2}")
      public void  updateCompanyId(String cbdCarportAddress,String cbdCarportAddressNo,int CompanyId,int AgreementId);
	  
		/**
		 * 
		 * <p>Title:addManyCarport</p>
		 * <p>Description: 批量添加第三方合约签订的车位</p>
		 * @author 朱小宝
		 * @return Boolean
		 */
	  @Insert("<script>"+
	            "insert into t_cbdcartport(cbdCarportAddress, cbdCarportAddressNo, cbdCarportThirdAggremenId) "
	            + "values "
	            + "<foreach collection =\"list\" item=\"carport\" index= \"index\" separator =\",\"> "
	            + "(#{carport.cbdCarportAddress},#{carport.cbdCarportAddressNo},#{carport.cbdCarportThirdAggremenId}) "
	            + "</foreach > "
	            + "</script>")
	  public void addManyCarport(@Param("list") List<CarportBean>carportBeans);
	  
	  /**
	   * 
	   * <p>Title:deleteManyCarport</p>
	   * <p>Description:批量删除已解约的车位 </p>
	   * @author 朱小宝
	   * @return void
	   */
	 @ Delete("delete from t_cbdcartport where cbdCarportThirdAggremenId=#{id}" )
	  public void deleteManyCarport(int id);
	 
	 /**
	  * 
	  * <p>Title:updateManyCarport</p>
	  * <p>Description: 删除企业，更新车位状态以及Id</p>
	  * @author 朱小宝
	  * @return void
	  */
	 @Update("update t_cbdcartport set cbdCarportStutas=0 ,cbdCarportRenterAgreementId=null,"
	 		+ "cbdCarportRenterCompanyId=null where cbdCarportRenterCompanyId=#{id}")
	 public void updateManyCarport(int id);
}
