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
<title>普通管理员</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/homePage.css">
<script src="/CBD/js/zhangping/phone.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
</head>
<body>
	<!--头部-->
<%-- 	<%@ include file="adminHeader.jsp" %> --%>
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/managerJsp/adminLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>管理员个人信息</span><a class="a_xiugai" href="ModifyPersonalInformation">修改个人密码</a>
			</div>
			<div class="r_ctn clearfix">
				<h1>管理员个人信息</h1>
				
				<div class="ct">
					<p><label  style="width: 100px;">用户名：</label>${adminLogining.adminAccount} </p> 
					<p><label  style="width: 100px;">真实姓名：</label>${adminLogining.adminRealName}</p>
					<p><label  style="width: 100px;">工号：</label>${adminLogining.adminNo}</p>
					<form action="updateAdminPhone" method="post">
					<p><label  style="width: 100px;">电话：</label><input  type="text" style="height: 30px; margin: 0px;" name="newPhone"  id="newPhone" value="${adminLogining.adminPhone}" />
					<span id="newPhoneSpan">${AdminPhone}</span>
						<input type="submit" value="确认" class="btn btn-info button">
					 </p>
					
					</form>
					<p><label  style="width: 100px;">权限：</label>
					<!-- 用户管理 -->
					<c:if test="${adminLogining.admiUserManagerPower ==1}">
							<label class="adminLogining" style="width: 80px;">用户管理</label>
					</c:if>
				
					<!-- 车位管理-->
					<c:if test="${adminLogining.adminCarPortManagerPower==1}">
							<label class="adminLogining"  style="width: 80px;">车位管理</label>
					</c:if>
					
					<!-- 合约管理 -->
					<c:if test="${adminLogining.adminAgreementManagerPower==1}">
							<label class="adminLogining"  style="width: 80px;">合约管理</label>
					</c:if>
					
					<!-- 投诉管理 -->
					<c:if test="${adminLogining.adminCompaintManagerPower==1}">
							<label class="adminLogining"  style="width: 80px;">投诉管理</label>
					</c:if>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>