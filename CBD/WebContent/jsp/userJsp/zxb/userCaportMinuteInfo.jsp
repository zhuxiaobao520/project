<!--个人出售车位界面（朱小宝）  -->
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
<link rel="stylesheet" href="/CBD/css/zxb/user_buy_outInfo.css">
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
				<span>车位信息</span>
			</div>
			<div class="r_ctn clearfix">
				<div id="hasRentInfo">
					<form action="reserveBuy" method="post">
						<p>出售车位信息:${info }</p>
						<p>用户名:${saleUserBean.userName }</p>
						<p>真实名:${saleUserBean.userRealName }</p>
						<p>身份证号:${saleUserBean.userIdCard }</p>
						<p>职业:${saleUserBean.userProfession }</p>
						<p>信誉度:
						<c:if test="${saleUserBean.userReputation==0}"></c:if>
						<c:if test="${saleUserBean.userReputation>=0&&saleUserBean.userReputation<1}">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleUserBean.userReputation>=1&&saleUserBean.userReputation<2}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleUserBean.userReputation>=2&&saleUserBean.userReputation<3}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleUserBean.userReputation>=3&&saleUserBean.userReputation<4}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleUserBean.userReputation>=4 }">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						</p>
						<p>
							<span>留言:</span><br>
							<textarea name="buyInfoMassage" rows="4" cols="25"></textarea>
						</p>
						<input type="hidden" name="messageUserId" value="${saleUserBean.userId }"><!-- 卖家id -->
						<input type="hidden" name="buyInfoSaleId" value="${saleId }"><!-- 出售信息id -->
						<input type="hidden" name="buyInfoUserId" value="${userLogin.userId }"><!-- 传递购买人id -->
							<br>
							<br> <input class="btn btn-default" type="submit" value="预定">
							<a href="returnBuyCarportList"><input class="btn btn-default" type="button" value="返回"></a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


