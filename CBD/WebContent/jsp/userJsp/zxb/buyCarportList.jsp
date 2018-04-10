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
<link rel="stylesheet" href="/CBD/css/zxb/buyCarportList.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/hxm/superAdmin.css">
<link  rel="stylesheet" href="/CBD/css/laydate.css">
<link rel="stylesheet" href="/CBD/css/Rent_yg/rentOutListPage_yg.css">
<script src="/CBD/js/zxb/buyCarportList.js" type="text/javascript"></script>
<script src="/CBD/js/laydate.js"></script>
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
		<div>
			<h2>${message }</h2>
		</div>
		<div class="r_name">
				<span>在售车位</span>
			</div>
			<div class="r_ctn clearfix">
				<span>发布时间：</span><input type="text" class="endTime" id="endTime">
				<input type="button" value="查询" id="lookInfoByTime" class="btn btn-default" >
				<div id="carportInfoList">
					
				</div>
				
				<div id="pageBtn">
					<input class="btn btn-default" type="button" id="fisrtPage" value="首页">
				    <input class="btn btn-default" type="button" id="prePage" value="上一页">
				    <input class="btn btn-default" type="text" id="inputPage" >/<span id="totalPage"></span>
				    <input class="btn btn-default" type="button" id="jump" value="跳转">
				    <input class="btn btn-default" type="button" id="nextPage" value="下一页">
				    <input class="btn btn-default" type="button" id="lastPage" value="尾页">
			    </div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


