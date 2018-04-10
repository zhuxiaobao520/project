<!--个人用户消息提醒页面  黄先明  -->
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
<title>个人用户消息提醒</title>
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
<link rel="stylesheet" href="/CBD/css/hxm/userMessage.css">
<script src="/CBD/js/hxm/userMessage.js"></script>


</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>个人消息提醒</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>消息记录</h1>
				<div class="ct">
					<select id="messageIsRead">
						<option>未读消息</option>
						<option>已读消息</option>
					</select><br><br>
					<table class="table  table-bordered table-hover" border=1 id="msgData">
						<tr>
							<th>消息内容</th>
							<th>操作</th>	
						</tr>
					</table>
					<div id="pageDiv">
					    <input class="btn btn-info button" type="button" id="fisrtPage" value="首页">
		    			<input class="btn btn-info button"  type="button" id="prePage" value="上一页">
		    			<input  type="text"  id="inputPage" >/<span id="totalPage"></span>
		    			<input class="btn btn-info button" type="button" id="jump" value="跳转">
		   				<input class="btn btn-info button" type="button" id="nextPage" value="下一页">
		    			<input class="btn btn-info button" type="button" id="lastPage" value="尾页">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


