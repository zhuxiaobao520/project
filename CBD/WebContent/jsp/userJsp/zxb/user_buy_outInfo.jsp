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
<title>CBD停车管理平台系统</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/zxb/user_buy_outInfo.css">
</head>

<!--个人出售车位界面（朱小宝）  -->

<body>
	<!--头部-->
	<%-- 	<%@ include file="adminHeader.jsp" %> --%>
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
		<div class="r_name">
				<span>出售信息录入</span>
			</div>
			<div class="r_ctn clearfix">
				<a id="addNewCar" href="addNewUserCarport">添加新车位</a>
				<div id="hasRentInfo">
				<div>
					<h1>${Message }</h1>
				</div>
				<form action="addSale">
					选择已有车位
					<select name="saleCarportId">
						<c:forEach items="${usercarportEntities }" var="temp">
							<option value="${temp.userCarportId }">${temp.userCarportAddress }${temp.userCarportAddressNo }号
							</option>
						</c:forEach>
					</select><br><br>
					<span id="salePrice" >出售价格</span>
					<input type="text" name="sellPrice"><span>${salePrice }</span><br><br>
					<input class="btn btn-default"  type="submit" value="提交">
					<a href="addReturn"><input class="btn btn-default"  type="button" value="返回"></a>
				</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


