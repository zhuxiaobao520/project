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
<title>添加出租记录</title>
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

<!-- 导入日期的格式 -->
<link  rel="stylesheet" href="/CBD/css/laydate.css">
<script src="/CBD/js/laydate.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>

<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/Rent_yg/RentOutPage_yg.css">
<link rel="stylesheet" href="/CBD/css/zxb/user_buy_outInfo.css">
<!-- 导入本页的js -->
<script src="/CBD/js/Rent_yg/Rent_yg.js"></script>

</head>

<!--个人出租车位界面（姚刚）  -->

<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>添加出租记录</span>
			</div>
			<div class="r_ctn clearfix">
				<a class="btn btn-default button" id="addNewCar" href="addNewUserCarport">添加新车位</a>
				<form id="addRentOutForm">
				<p class="form_P">
					<label>选择已有车位</label> <select id="rentOutCarportId" name="rentOutCarportId">
						<c:forEach items="${usercarportEntities }" var="temp">
							<option value="${temp.userCarportId }">${temp.userCarportAddress }${temp.userCarportAddressNo }号
							</option>
						</c:forEach>
					</select> 
				</p>
					<p class="form_P"><label>出租价格</label> <input id="rentOutPrice" type="text" name="rentOutPrice"></p>
					<p class="form_P"><label>出租开始时间</label> <input type="text" id="rentOutStartTime" name="rentOutStartTime"></p>
					<p class="form_P"><label>出租结束时间</label> <input type="text" id="rentOutEndTime" name="rentOutEndTime"></p>
					<p class="form_P"><a class="btn btn-default button" id="addRentOutBtn">出租</a> 
					<a class="btn btn-default button">返回</a></p>
				</form>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


