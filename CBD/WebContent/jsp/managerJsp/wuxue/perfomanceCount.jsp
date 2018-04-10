<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<base href="<%=basePath%>">
<title>性能统计</title>
<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css" />
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/action.css">

<script src="/CBD/js/jquery.js"></script>
<script type="text/javascript" src="/CBD/js/wuxue/performanceCount.js"></script>
<script type="text/javascript" src="/CBD/js/echarts.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<script type="text/javascript" src="/CBD/js/action.js"></script>
<script type="text/javascript" src="/CBD/js/unslider.min.js"></script>
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/managerJsp/adminLeftList.jsp" />
		<div class="scd_r">
			<h2>性能统计</h2>
			<p></p>
			统计间隔时间：<select id="time">
				<option>1</option>
				<option>3</option>
				<option>5</option>
				<option selected="selected">10</option>
				<option>30</option>
			</select>&nbsp;&nbsp;秒
			<div id="container" style="height: 75%; width: 100%"></div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>