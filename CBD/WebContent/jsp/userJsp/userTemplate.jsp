<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<title>CBD停车管理平台系统</title>

<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/js_z.js"></script>
<script type="text/javascript" src="js/action.js"></script>
<script type="text/javascript" src="js/unslider.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/thems.css">
<link rel="stylesheet" type="text/css" href="css/action.css">
</head>
<body>
		<!--头部-->
		<div class="header">
		    <div class="head clearfix">
		        <div class="logo"><a href=""><img src="Assets/images/logo3.png" alt="CDB"/></a></div>
		        <div class="head_r">
		        	<div class="h_rt">
		            	<span>咨询电话：<b>400-066-8939</b></span>
		                <span><a href="">用户名</a>|<a href="">注销</a></span>
		            </div>
		            <ul class="nav clearfix">
		                <li><a href="index.html">首页</a></li>
		                <li><a href="user_rentOut.jsp">我要出租</a></li>
		                <li><a href="user_rentIn.jsp">我要求租</a></li>
		                <li><a href="user_buyOut.jsp">我要出售</a></li>
		                <li><a href="user_buyIn.jsp">我要购买</a></li>
		                <li><a href="contact.html">联系我们</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
		<!--头部-->
		<!--幻灯片-->
		<div class="banner_img" id="b04">
		    <ul>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		    </ul>
		</div>
		<!--幻灯片-->
		<div class="space_hx">&nbsp;</div>
		<div class="scd clearfix">
			<div class="scd_l">
		    	<div class="name">个人用户<em>/ABOUT</em></div>
		        <ul class="s_nav clearfix">
		        	<li class="now"><a href="user_info.jsp">个人资料</a></li>
		            <li><a href="user_changePwd.jsp">修改密码</a></li>
		            <li><a href="user_rentRecord.jsp">租赁记录</a></li>
		            <li><a href="user_buyRecord.jsp">买卖记录</a></li>
		            <li><a href="user_arrangement.jsp">账单管理</a></li>
		            <li><a href="user_message.jsp">消息提醒</a></li>
		        </ul>
		    </div>
		</div>
	
	
	
	
	<!-- 引入bottom.jsp -->
	<%@ include file="../bottom.jsp" %>	 
</body>
</html>