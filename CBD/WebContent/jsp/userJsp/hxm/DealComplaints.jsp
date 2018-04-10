<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	//获取跟路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>CBD停车管理平台系统</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<title>买卖投诉</title> 

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<script src="/CBD/js/jquery.js"></script>
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/hxm/DealComplaints.css">
<script src="js/hxm/DealComplaints.js"></script>

</head>
<body>
<!--头部-->
  <%@include file="/jsp/userJsp/userHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
    <%@include file="/jsp/userJsp/userLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>买卖投诉</span></div> 
        <div class="r_ctn clearfix" >
                 <div class="save">
   					<div id="complainEvent">
	                  <p><span class="tit">购买用户：${saleRecordBean.buyInfoUser.userName }</span></p>
	                  <p><span class="tit">出售用户：${saleRecordBean.sellUser.userName }</span></p>
	                  <p><span class="tit">车位信息：
	                   ${saleRecordBean.userCarportAddress }${saleRecordBean.userCarportAddressNo }</span> 
	                 	 </p>                   
	                   <p><span class="tit">交易时间：${saleRecordBean.dealTime }</span></p> 
	                   <p><span class="tit">投诉理由：</span></p>   
	                </div>    	
	            <form id="complainForm" action="dealComplaints" method="post">
	                    <ul class="s_a s_b clearfix" >
	                    <li class="clearfix">
	                        <div class="li_r btn">
	                        	<textarea name="complainMessage" rows="4" cols="30"></textarea><br>
	                        	<input  type="hidden" id="complainType" name="complainType" value="${complainType }" >
	                        	<input type="hidden" id="buyUserId" name="buyUserId" value="${saleRecordBean.buyInfoUser.userId  }" >
	                        	<input type="hidden" id="sellUserId" name="sellUserId" value="${saleRecordBean.sellUser.userId  }" >
	                        	<input type="hidden" id="complainEventId" name="complainEventId" value="${saleRecordBean.buyInfoId  }" >
	                        	
	                    
	                        </div>
	                    </li>
               		 </ul>
               			<div id="btnDiv">  <input class="btn btn-info button"  id="complain" type="button" value="投诉">
	                       <a href="userBuyRecord"><input class="btn btn-info button"  name="" type="button" value="返回"></a>
               			</div> 
               </form>
                </div>                    
        </div>
    </div>
    </div>
   
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>