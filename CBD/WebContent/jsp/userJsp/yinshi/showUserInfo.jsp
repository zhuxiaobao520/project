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
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<script type="text/javascript" src="/CBD/js/yangmingjian/user_info.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<%@ include file="/jsp/userJsp/userLeftList.jsp" %>
		<div class="scd_r">
			<div class="r_name">
				<span>用户个人信息</span>
			</div>
			<div class="r_ctn clearfix">
				<div class="ct">
					<form action="update" id="updateForm" method="post">
						<input type="hidden" name="userId" value="${userBean.userId}">
						<p><label>用户名:</label>${userBean.userName }</p>
						<p><label>真实姓名:</label>${userBean.userRealName }</p>
						<p><label>家庭地址:</label>${userBean.userAddress }</p>
						<p><label>电话号码:</label>${userBean.userPhone }</p>
						<p><label>身份证号码:</label>${userBean.userIdCard }</p>
						<p><label>职业描述:</label>${userBean.userProfession }</p>
						<p><label>邮箱地址:</label>${userBean.userEmail }</p>
						<p><label>个人信誉度:</label>
							<c:choose>
								<c:when test="${userBean.userReputation==0}" />
								<c:when test="${userBean.userReputation>=0&&userBean.userReputation<1}">
									<img alt="" src="image/star.png">
								</c:when>
								<c:when test="${userBean.userReputation>=0&&userBean.userReputation<2}">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
								</c:when>
								<c:when test="${userBean.userReputation>=0&&userBean.userReputation<3}">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
								</c:when>
								<c:when test="${userBean.userReputation>=0&&userBean.userReputation<4}">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
								</c:when>
								<c:otherwise>
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
									<img alt="" src="image/star.png">
								</c:otherwise>							
							</c:choose>
						</p>
						<br>
						<p><a href="showUserHome"><input style="margin-left: 300px;" type="button" value="返回" class="btn btn-info button"></a></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


