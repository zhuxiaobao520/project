
<!-- 申请购买详情  黄先明-->
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
<title>申请购买信息</title>

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
<link rel="stylesheet" href="/CBD/css/hxm/buyInfo.css"> 


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
				<span>申请购买信息</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>申请购买信息</h1>
				
				<div class="ct">
				<div id="saleInInfo">
				<div id="buyerInfo">
					<p>待售车位信息：${saleTaskBean.userCarportAddress }${saleTaskBean.userCarportAddressNo }</p>
					<p>用户名：${saleTaskBean.userEntity.userName }</p>
					<p>真实姓名：${saleTaskBean.userEntity.userRealName }</p>
					<p>身份证号：${saleTaskBean.userEntity.userIdCard }</p>
					<p>职业：${saleTaskBean.userEntity.userProfession } </p>
					<p>电话：${saleTaskBean.userEntity.userPhone }</p>
					<p>信誉度：
						<c:if test="${saleUserBean.userReputation==0}"></c:if>
						<c:if test="${saleTaskBean.userEntity.userReputation>=0&&saleTaskBean.userEntity.userReputation<1}">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleTaskBean.userEntity.userReputation>=1&&saleTaskBean.userEntity.userReputation<2}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleTaskBean.userEntity.userReputation>=2&&saleTaskBean.userEntity.userReputation<3}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleTaskBean.userEntity.userReputation>=3&&saleTaskBean.userEntity.userReputation<4}">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
						<c:if test="${saleTaskBean.userEntity.userReputation>=4 }">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
							<img alt="" src="image/star.png">
						</c:if>
					</p>
					<p>留言：${saleTaskBean.buyInfoMassage} </p>
				</div>	
				<div id="btnDiv">
					   	<a href="agreeSell?buyInfoUserId=${saleTaskBean.userEntity.userId }&buyInfoId=${saleTaskBean.buyInfoId}&saleCarportId=${saleTaskBean.saleCarportId }&buyInfoSaleId=${saleTaskBean.buyInfoSaleId } "><input class="btn btn-info button" type="button" id="agree" value="申请网上签约"></a>
		    			<a href="disagreeSell?buyInfoUserId=${saleTaskBean.userEntity.userId }&buyInfoId=${saleTaskBean.buyInfoId}&saleCarportId=${saleTaskBean.saleCarportId }&buyInfoSaleId=${saleTaskBean.buyInfoSaleId } "><input class="btn btn-info button"  type="button" id="disagree" value="不同意"></a>
		    			<a href="dealSellTask"><input class="btn btn-info button"  type="button" id="disagree" value="返回"></a>
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


