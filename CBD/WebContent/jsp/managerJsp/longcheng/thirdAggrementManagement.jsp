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
<title>外部合约管理</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<script src="/CBD/js/longcheng/thirdAggrementManagement.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/longcheng/thirdAggrementManagement.css">
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix" style="width: 1100px;">
		<jsp:include page="/jsp/managerJsp/adminLeftList.jsp" />
		<div class="scd_r" style="width: 850px;">
		<div class="r_name">
			<span>外部合约管理</span>
		</div>
		<div class="r_ctn clearfix">
		<div id="thirdAggrementInfo" >
			<h1>外部合约列表</h1>
			<table class="table  table-bordered table-hover" id="thirdAggrementData"
				border="1" cellspacing="0">
				<tr>
					<th>合同编号</th>
					<th>原合同编号</th>
					<th>合同单位</th>
					<th>对方联系人</th>
					<th>对方联系电话</th>
					<th>车位所属单位详细地址</th>
					<th>合同生效日期</th>
					<th>合同截止日期</th>
					<th>合同状态</th>
				</tr>
			</table>
		</div>
		<div id="btnDiv">
				<input type="button" id="fisrtPage" class="btn btn-info button" value="首页"> 
				<input type="button" id="prePage" class="btn btn-info button" value="上一页"> 
				<input type="text" id="inputPage" value="1">/<span id="totalPage"></span>
				<input type="button" id="jump" class="btn btn-info button" value="跳转"> 
				<input type="button" id="nextPage" class="btn btn-info button" value="下一页">
				<input type="button" id="lastPage" class="btn btn-info button" value="尾页">
		</div>
		<div id="operationDiv">
			<a href="addThirdAggrement"><input class="operation btn btn-info button" type="button" id="add" value="新增"></a>
			<a id="a_continue" href="javascript:void(0);"><input class="operation btn btn-info button" type="button" id="continue" value="续约"></a>
			<input class="operation btn btn-info button" type="button" id="termination" value="解约">
			<input id="thirdAggrementIdHidden" type="hidden" value="-1">	
		</div>
		</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>