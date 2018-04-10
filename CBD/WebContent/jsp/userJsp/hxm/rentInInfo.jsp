<!--招租人查看预定信息页面   黄先明-->
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
<title>租赁者信息</title>
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
<link rel="stylesheet" href="/CBD/css/hxm/rentInInfo.css"> 


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
				<span>租赁者信息</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>租赁者信息</h1>
				
				<div class="ct">
				<div id="rentInInfo">
					
					
					<p>待租车位信息：${rentTaskBean.userCarportAddress }${rentTaskBean.userCarportAddressNo }</p>
					<p>租赁开始时间：${rentTaskBean.rentOutStartTime }</p>
					<p>租赁结束时间：${rentTaskBean.rentOutEndTime }</p>
					<p>用户名：${rentTaskBean.userEntity.userName }</p>
					<p>职业：${rentTaskBean.userEntity.userProfession }</p>
					<p>电话：${rentTaskBean.userEntity.userPhone}</p>
					<p>信誉度：
					<c:if test="${saleUserBean.userReputation==0}"></c:if>
						<c:if test="${rentTaskBean.userEntity.userReputation>=0&&rentTaskBean.userEntity.userReputation<1}">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${rentTaskBean.userEntity.userReputation>=1&&rentTaskBean.userEntity.userReputation<2}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${rentTaskBean.userEntity.userReputation>=2&&rentTaskBean.userEntity.userReputation<3}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${rentTaskBean.userEntity.userReputation>=3&&rentTaskBean.userEntity.userReputation<4}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${rentTaskBean.userEntity.userReputation>=4 }">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
					</p>
					<p>留言：${rentTaskBean.rentInMessage} </p>
					<div id="btnDiv">
					   	<a href="agreeRent?rentInUserId=${rentTaskBean.userEntity.userId }&userCarportId=${rentTaskBean.userCarportId }&rentInId=${rentTaskBean.rentInId }&rentOutId=${rentTaskBean.rentOutId } "><input class="btn btn-info button" type="button" id="agree" value="同意"></a>
		    			<a href="disagreeRent?rentInUserId=${rentTaskBean.userEntity.userId }&userCarportId=${rentTaskBean.userCarportId }&rentInId=${rentTaskBean.rentInId }&rentOutId=${rentTaskBean.rentOutId } "><input class="btn btn-info button"  type="button" id="disagree" value="不同意"></a>
		    			<a href="dealRentTask"><input class="btn btn-info button"  type="button" id="disagree" value="返回"></a>
					</div>
				</div>	
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


