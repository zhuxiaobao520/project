<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--管理员查看用户信息列表  -->
<%
	//获取跟路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--添加管理员 ——黄先明 -->
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通管理员信息</title>

<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<script type="text/javascript" src="/CBD/js/action.js"></script>
<script type="text/javascript" src="/CBD/js/unslider.min.js"></script>
<script type="text/javascript" src="/CBD/js/hxm/addAdmin.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/action.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/hxm/adminInfo.css">


</head>
<body>
		<!--头部-->
		<div class="header">
		    <div class="head clearfix">
		        <div class="logo"><a href=""><img src="/CBD/Assets/images/logo3.png" alt="CDB"/></a></div>
		        <div class="head_r">
		        	<div class="h_rt">
		            	<span>咨询电话：<b>400-066-8939</b></span>
		                <span><a href="">${adminLogining.adminRealName}</a>|<a href="jumpExit">注销</a></span>
		            </div>
		            <ul class="nav clearfix">
		                <li><a href="jumpHome">首页</a></li>
		                <li><a href="jumpContact">联系我们</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
		<!--头部-->
		<!--幻灯片-->
		<div class="banner_img" id="b04">
		    <ul>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		    </ul>
		</div>
		<!--幻灯片-->
		<div class="space_hx">&nbsp;</div>
		<div class="scd clearfix">
			<div class="scd_l">
		    	<div class="name">管理员<em>/ABOUT</em></div>
		        <ul class="s_nav clearfix">
		        	<li class="now"><a href="goToAdminInfoList">员工信息管理</a></li>		        	
		            <li ><a href="goToAddAdmin">新增员工</a></li>
		            <li><a href="goToUpdateSuperPwd">修改密码</a></li>

		        </ul>
		    </div>	
		    <div class="scd_r">
			<div class="r_name">
				<span>管理员信息</span>
			</div>

			<div class="r_ctn clearfix">
		    
		    <div id="addAdmin" >
		    <h1>管理员信息详情</h1>
		   	<div id="managerInfo">
				<p>账号：<label id="adminAccount">${CheckedAdmin.adminAccount }</label></p>
		   		
		   		<p>工号：<label >${CheckedAdmin.adminNo }</label></p>
		   		<p>真实姓名：<label >${CheckedAdmin.adminRealName }</label></p>
		   		<p>电话号码：<label >${CheckedAdmin.adminPhone }</label></p>
		   		<p>权限： 
		   		
					<c:if test="${CheckedAdmin.admiUserManagerPower==1 }">
					<label >用户管理权限&nbsp;</label>
					</c:if >
					<c:if  test="${CheckedAdmin.adminCarPortManagerPower==1 }">
					<label >车位管理权限&nbsp;</label>
					</c:if >
					<c:if  test="${CheckedAdmin.adminAgreementManagerPower==1 }">
					<label >合约管理权限&nbsp;</label>
					</c:if >
					<c:if  test="${CheckedAdmin.adminCompaintManagerPower==1 }">
					<label >投诉管理权限&nbsp;</label>
					</c:if >
					
		
		   		
		   		</p>
		   		<!--返回超级管理员查看普通管理员列表  -->	
		   		<p><a href="goToAdminInfoList"><input class="btn btn-info button" id="return"  type="button"  value="返回"></a> </p>
				</div>
		    </div>	
		 
		</div>
		</div>
		</div>

	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>  	  
</body>
</html>