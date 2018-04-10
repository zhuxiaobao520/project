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
<title>普通管理员</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<!-- 导入页面的js -->
<script src="/CBD/js/RentRecord_yg/RentRecord.js"></script>
</head>
<body>
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>招租租凭纪录</span>
			</div>
			<div class="r_ctn clearfix">
				<div class="save">
					<div class="li_r">
						<select id="selectButton">
							<option>招租记录</option>
							<option>租赁记录</option>
						</select>
					</div>
				</div>
				<br>
				<table class="table table-bordered">
					<!--  表头 -->
					<thead id="thead">

					</thead>
					<!-- 表内容 -->
					<tbody id="tbody">

					</tbody>
				</table>
			</div>
			<hr>
			<div style="text-align: center;">
				<a class="btn btn-success button" id="complainBtn">投诉</a><br>
				<hr>
			</div>
			<div id="btnDiv">
			<a id="firstPage" class="btn btn-info button">首页</a>
			<a id="prePage"	class="btn btn-info button">上一页</a> 
			<input id="currentPage">/<span id="totalPageNum"></span>
			<a id="turnToPage" class="btn btn-info button">跳转</a>
			<a id="nextPage" class="btn btn-info button">下一页</a>
			<a id="lastPage" class="btn btn-info button">尾页</a>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


