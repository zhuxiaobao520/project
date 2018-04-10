<!-- 代办买卖任务  黄先明-->
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
<title>待办买卖任务</title>

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
<script src="/CBD/js/hxm/buyAndSellTask.js"></script>
<link rel="stylesheet" href="/CBD/css/hxm/buyAndSellTask.css">


</head>
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
				<span>待办买卖任务</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>待办买卖任务</h1>
				<div class="ct">
					
					<table class="table  table-bordered table-hover" border=1 id="sellTask">
						<tr>
							<th>车位信息</th><th>预约购买人</th>
							<th>出租价格（单位/元）</th><th>操作</th>	
						</tr> 
					</table>
					<div id="pageDiv">
					    <input class="btn btn-info button" type="button" id="sellFisrtPage" value="首页">
		    			<input class="btn btn-info button"  type="button" id="sellPrePage" value="上一页">
		    			<input  type="text" id="sellInputPage" >/<span id="sellTotalPage"></span>
		    			<input class="btn btn-info button" type="button" id="sellJump" value="跳转">
		   				<input class="btn btn-info button" type="button" id="sellNextPage" value="下一页">
		    			<input class="btn btn-info button" type="button" id="sellLastPage" value="尾页">
					</div>	
						<h1>待签合约任务</h1>
						<!--代签合约表  -->
					<select id="agreementType">
						<option>待签购买合同</option>
						<option>待签出售合同</option>
					</select>
					<br><br>
					<table class="table  table-bordered table-hover" border=1 id="agreementTask">
						<tr>
							<th>车位信息</th><th>出售人</th><th>购买人</th>
							<th>出售价格（单位/元）</th><th>操作</th>	
						</tr> 
					</table>
					<div id="pageDiv">
					    <input class="btn btn-info button" type="button" id="agreementFisrtPage" value="首页">
		    			<input class="btn btn-info button"  type="button" id="agreementPrePage" value="上一页">
		    			<input  type="text" id="agreementInputPage" >/<span id="agreementTotalPage"></span>
		    			<input class="btn btn-info button" type="button" id="agreementJump" value="跳转">
		   				<input class="btn btn-info button" type="button" id="agreementNextPage" value="下一页">
		    			<input class="btn btn-info button" type="button" id="agreementLastPage" value="尾页">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


