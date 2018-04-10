<!--朱小宝  -->
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
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/zxb/complain.css">
<script type="text/javascript" src="/CBD/js/zxb/complainInfo.js"></script>
<link rel="stylesheet" type="text/css" href="css/zxb/btnCssStyle.css">
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/managerJsp/adminLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>投诉信息</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>处理投诉</h1>
				<div class="complainInfo">
					<p>
						<label class="complainTitle">事件信息</label>
					</p>
					<table class="table  table-bordered table-hover" border="1" cellspacing="0">
						<thead>
							<tr>
								<th>车位小区地址</th>
								<th>车位编号</th>
								<c:if test="${complainInfo.complainEventType=='租赁' or complainInfo.complainEventType=='招租'  }">
									<th>租赁开始时间</th>
									<th>租赁结束时间</th>
								</c:if>
								<c:if test="${complainInfo.complainEventType=='购买' or complainInfo.complainEventType=='出售'  }">
									<th>交易时间</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:if test="${complainInfo.complainEventType=='租赁' or complainInfo.complainEventType=='招租'  }">
									<th>${eventObject.usercarportEntity.userCarportAddress }</th>
									<th>${eventObject.usercarportEntity.userCarportAddressNo }</th>
									<th>${eventObject.rentOutStartTime }</th>
									<th>${eventObject.rentOutEndTime }</th>
								</c:if>
								<c:if test="${complainInfo.complainEventType=='购买' or complainInfo.complainEventType=='出售'  }">
									<th>${eventObject.saleCarport.userCarportAddress }</th>
									<th>${eventObject.saleCarport.userCarportAddressNo }</th>
									<th>${eventObject.salePublishTime }</th>
									<th></th>
								</c:if>
							</tr>
						</tbody>
					</table>
					
				<div class="complainInfo">
					<p>
						<label class="complainTitle">投诉人信息</label>
					</p>
					<table class="table  table-bordered table-hover" border="1" cellspacing="0">
						<thead>
							<tr>
								<th>用户名</th>
								<th>真实姓名</th>
								<th>身份证号码</th>
								<th>职业</th>
								<th>联系电话</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>${complainInfo.complainUser.userName }</th>
								<th>${complainInfo.complainUser.userRealName}</th>
								<th>${complainInfo.complainUser.userIdCard}</th>
								<th>${complainInfo.complainUser.userProfession }</th>
								<th>${complainInfo.complainUser.userPhone}</th>
							</tr>
							<tr><td>投诉理由</td><td colspan="4">${complainInfo.complainMessage}</td></tr>
						</tbody>
					</table>
					
				<div class="complainInfo">
					<p>
						<label class="complainTitle">被投诉人信息</label>
					</p>
					<table class="table  table-bordered table-hover" border="1" cellspacing="0">
						<thead>
							<tr>
								<th>用户名</th>
								<th>真实姓名</th>
								<th>身份证号码</th>
								<th>职业</th>
								<th>联系电话</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>${complainInfo.complainedUser.userName }</th>
								<th>${complainInfo.complainedUser.userRealName}</th>
								<th>${complainInfo.complainedUser.userIdCard}</th>
								<th>${complainInfo.complainedUser.userProfession }</th>
								<th>${complainInfo.complainedUser.userPhone}</th>
							</tr>
						</tbody>
					</table>
				</div>
				</div>
				</div>
				<input type="hidden" value="${complainInfo.complainId }" id="checkedComplainId">
				<input  class="btn btn-info button" type="button" id="complainAccept" value="投诉生效">
				<input  class="btn btn-info button" type="button" id="complainDeny" value="投诉无效">
				<input  class="btn btn-info button" type="button" id="complainPostpone" value="暂缓处理">
				<a href="adminComplaint"><input class="btn btn-info button"type="button"  value="返回"></a>
				
			</div>
		</div>
	</div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>