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
<title>出租车位详情</title>
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
<link rel="stylesheet" href="/CBD/css/Rent_yg/RentOutPage_yg.css">
<link rel="stylesheet" href="/CBD/css/zxb/user_buy_outInfo.css">
<!-- 导入本页的js -->
<script src="/CBD/js/Rent_yg/showRentOutInfoPage.js"></script>
</head>

<!--个人租赁车位界面（姚刚）  -->

<body>
	<!--头部-->
	<jsp:include page="/jsp/userJsp/userHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/userJsp/userLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>出租车位详情</span>
			</div>
			<div class="r_ctn clearfix">
			<c:choose>
				<c:when test="${useableRentOutInfoBean!=null}">
					<form >
					<p class="form_P"><label>车位地址</label> <input type="text"  readonly="readonly" placeholder="${useableRentOutInfoBean.userCarportAddress}${useableRentOutInfoBean.userCarportAddressNo}"></p>
					<p class="form_P"><label>租借开始时间</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.rentOutStartDate}"></p>
					<p class="form_P"><label>租借结束时间</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.rentOutEndDate}"></p>
					<p class="form_P"><label>租借价格</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.rentOutPrice}"></p>
					<p class="form_P"><label>出租人用户名</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.userName}"></p>
					<p class="form_P"><label>出租人职业</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.userProfession}"></p>
					<p class="form_P"><label>出租人电话</label> <input type="text" readonly="readonly" placeholder="${useableRentOutInfoBean.userPhone}"></p>
					<p class="form_P"><label>出租人信誉度</label>
						<c:if test="${useableRentOutInfoBean.userReputation==0}"></c:if>
						<c:if test="${useableRentOutInfoBean.userReputation>=0&&useableRentOutInfoBean.userReputation<1}">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${useableRentOutInfoBean.userReputation>=1&&useableRentOutInfoBean.userReputation<2}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${useableRentOutInfoBean.userReputation>=2&&useableRentOutInfoBean.userReputation<3}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${useableRentOutInfoBean.userReputation>=3&&useableRentOutInfoBean.userReputation<4}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${useableRentOutInfoBean.userReputation>=4 }">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if></p>
					<p class="form_P"><label>留言</label><textarea rows="2" cols="20" id="rentInMessage" name="rentInMessage"></textarea></p>
					<input id="rentOutId" type="hidden" name="rentOutId" value="${useableRentOutInfoBean.rentOutId}">
					<p class="form_P"><a class="btn btn-default button" id="addRentInBtn">租车</a> 
					<a class="btn btn-default button" href="/CBD/rentIn_yg/turnToRentOutListPage">返回</a></p>
				</form>
				</c:when>
				<c:otherwise>
					<h5 style="text-align: center;">您当前操作有误</h5>
				</c:otherwise>
			
			</c:choose>
				
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


