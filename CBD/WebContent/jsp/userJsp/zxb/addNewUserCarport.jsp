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

<!--个人添加新出售车位界面（朱小宝）  -->

<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
		<div class="r_name">
				<span>添加新车位信息录入</span>
			</div>
			<div class="r_ctn clearfix">
				<div id="hasRentInfo">
					<form action="addNewCarport" method="post" enctype="multipart/form-data">
						<input type="hidden" name="userCarportUserId" value="${userLogin.userId }">
						车位产权证：
						<input type="text" name="userCarportPropertityRight"><span>${userCarportPropertityRight }</span><br><br>
						车&nbsp;位&nbsp;地&nbsp;址：
						<input type="text" name="userCarportAddress"><span>${userCarportAddress }</span><br><br>
						车&nbsp;位&nbsp;编&nbsp;号：
						<input type="text" name="userCarportAddressNo"><span>${userCarportAddressNo }</span><br><br>
						产权证复印件上传：
						<input type="file" name="userCarportImageUrl"><span>${message }</span><br><br>
						<input class="btn btn-default"  type="submit" value="申请添加">
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


