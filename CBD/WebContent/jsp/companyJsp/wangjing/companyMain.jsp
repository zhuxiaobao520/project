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
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>CBD停车管理平台系统</title>

<base href="<%=basePath%>">
<title>企业主页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

<link rel="stylesheet" type="text/css" href="css/hxm/superAdmin.css">
<!-- <link rel="stylesheet" href="css/wangjing/updateCompanyInfo.css"> -->

<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/CBD/js/wangjing/companyCarport.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">

</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/companyJsp/wangjing/companyHead.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/companyJsp/wangjing/companyLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>车位信息</span>
			</div>
			<div class="r_ctn clearfix">
		<div id="updateCompanyInfo">
			<h1>车位信息</h1>
			<select id="selectButton">
				<option>查看已租车位</option>
				<option>查看平台待租车位</option>
			</select>		
			
				<table class="table table-bordered">
					<!--  表头 -->
					<thead id="thead">

					</thead>

					<!-- 表内容 -->
					<tbody id="tbody">

					</tbody>
				</table>
			
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