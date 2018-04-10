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
<title>系统日志</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js//messages_zh.js"></script>
<!-- 导入页面的css -->
<link rel="stylesheet" href="/CBD/css/Log_yg/LogPage.css">

<!-- 导入页面的js -->
<script src="/CBD/js/Log_yg/log.js"></script>

<!-- 导入日期的格式 -->
<link  rel="stylesheet" href="/CBD/css/laydate.css">
<script src="/CBD/js/laydate.js"></script>



</head>
<body>
	<!--头部-->
	<%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
		<div class="scd_r">
			<div class="r_name">
				<span>系统日志</span>
			</div>
			<div class="r_ctn clearfix">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>登录用户名</th>
								<th>时间</th>
								<th>登录IP地址</th>
								<th>操作类型</th>
								<th>日志类型</th>
								<th>操作内容</th>
							</tr>
						</thead>
						<tbody id="logList">
						</tbody>
					</table>
					<div><p class="condition">
					日志类型： <select id="logType">
						<option>前台</option>
						<option>后台</option>
					</select> 操作类型： <select id="logOperationType">
						<option>登录</option>
						<option>注销</option>
						<option>数据库操作</option>
					</select></p>
					<p class="condition"> 请选择开始日期（年月日）：<input type="text"  id="startDate"></p>
					<p class="condition"> 请选择结束日期（年月日）：<input type="text" id="endDate"></p>
					</div>
					<div id="selectDiv">
						<a id="selectButton" class="btn btn-default">查询</a>
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
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>