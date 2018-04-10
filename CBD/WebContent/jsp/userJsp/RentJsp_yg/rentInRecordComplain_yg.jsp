<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>租赁记录投诉</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/Rent_yg/RentOutPage_yg.css">
<link rel="stylesheet" href="/CBD/css/zxb/user_buy_outInfo.css">
<!-- 导入本页的js -->
<script src="/CBD/js/Rent_yg/rentInComplain_yg.js"></script>
</head>

<!--个人租赁车位界面（姚刚）  -->

<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>租赁交易投诉</span>
			</div>
			<div class="r_ctn clearfix">
			<c:choose>
			
				<c:when test="${rentInComplainBean!=null}">
					<form id="rentInComplainForm">
					<p class="form_P"><label>车位地址</label> <input type="text"  readonly="readonly" placeholder="${rentInComplainBean.userCarportAddress}${rentInComplainBean.userCarportAddressNo}"></p>
					<p class="form_P"><label>租借开始时间</label> <input type="text" readonly="readonly" placeholder="${rentInComplainBean.rentOutStartDate}"></p>
					<p class="form_P"><label>租借结束时间</label> <input type="text" readonly="readonly" placeholder="${rentInComplainBean.rentOutEndDate}"></p>
					<p class="form_P"><label>租借价格</label> <input type="text" readonly="readonly" placeholder="${rentInComplainBean.rentOutPrice}"></p>
					<p class="form_P"><label>出租用户名</label> <input type="text" readonly="readonly" placeholder="${rentInComplainBean.rentOutUserName}"></p>
					<p class="form_P"><label>投诉理由</label><textarea rows="2" cols="25" id="complainMessage" name="complainMessage"></textarea></p>
					<input id="rentInId" type="hidden" name="rentInId" value="${rentInComplainBean.rentInId}">
					<input id="rentOutUserId" type="hidden" name="rentOutUserId" value="${rentInComplainBean.rentOutUserId}">
					<p class="form_P"><a class="btn btn-default button" id="rentInComplainBtn">投诉</a> 
					<a class="btn btn-default button" href="/CBD/rentRecord_yg/turnToRentRecord">返回</a></p>
				</form>
				</c:when>
				<c:otherwise>
					<h5 style="text-align: center;">您当前操作有误</h5>
				</c:otherwise>
			</c:choose>
				
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


