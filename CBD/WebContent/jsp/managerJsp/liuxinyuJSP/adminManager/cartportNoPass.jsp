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
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>CBD停车管理平台系统</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
</head>
<body>
	<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

	<div class="scd clearfix">
		<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
      <div class="r_name"><span>用户、车位详情</span></div> 
        <div class="r_ctn clearfix" >
        	<div class="save">
                       
                <ul class="s_a s_b clearfix">
                	<li class="clearfix" >
                    	<span class="tit">用户名：</span>
                         <h2>${usercarportEntity.user.userName}</h2>
                    </li>
                    <li class="clearfix">
                    	<span class="tit">真实姓名：</span>
                         <h2>${usercarportEntity.user.userRealName}</h2>
                    </li>
                    <li class="clearfix">
                    	<span class="tit">身份证：</span>
                          <h2>${usercarportEntity.user.userIdCard}</h2>
                    </li>
                 
                    <li class="clearfix">
                    	<span class="tit">家庭地址：</span>
                        <h2>${usercarportEntity.user.userAddress}</h2>
                    </li> 
                     <li class="clearfix">
                    	<span class="tit">联系电话：</span>
                        <h2>${usercarportEntity.user.userPhone}</h2>
                    </li> 
                     <li class="clearfix">
                    	<span class="tit">职业描述：</span>
                        <h2>${usercarportEntity.user.userProfession}</h2>
                    </li>
                     <li class="clearfix">
                    	<span class="tit">邮箱地址：</span>
                        <h2>${usercarportEntity.user.userEmail}</h2>
                    </li> 
                     <li class="clearfix">
                    	<span class="tit">车位所在地址：</span>
                        <h2>${usercarportEntity.userCarportAddress}</h2>
                    </li> 
                     <li class="clearfix">
                    	<span class="tit">车位编号：</span>
                        <h2>${usercarportEntity.userCarportAddressNo}</h2>
                    </li>             
                    <li class="clearfix">
                        <div class="li_r btn" >
                        	<a href="updateByIdUsercarport?id=${usercarportEntity.userCarportId}&userid=${usercarportEntity.user.userId}&userCarportAuditingStatus=通过">
                        	<input type="button" value="通过" class="style"></a>
                        	<a href="updateByIdUsercarport?id=${usercarportEntity.userCarportId}&userid=${usercarportEntity.user.userId}&userCarportAuditingStatus=未通过">
                        	<input type="button" value="不通过" class="style"></a>
                        	<a href="jumpUserAdmin"><input class="style" name="" type="button" value="返回"></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
  </div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>