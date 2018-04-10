<!-- 用户购买合同签订页面  黄先明 -->
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
<title>用户购买合同</title>

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
<link rel="stylesheet" href="css/hxm/userBuyAgreement.css">


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
				<span>用户购买合同</span>
			</div>
			<div class="r_ctn clearfix">
				<h1>用户购买合同</h1>
			
				<div class="ct">
				<div id="rentInInfo">
						合同编号:${buyAgreementTaskBean.agreementNo }
					<div>
					车位信息：<br>
						车位所在小区地址:${buyAgreementTaskBean.userCarportAddress }     车位编号:${buyAgreementTaskBean.userCarportAddressNo }<br>
						产权证编号:${buyAgreementTaskBean.userCarportPropertityRight }         车位产权证复印件：<img alt="" src="">
						
					
					</div>
					<div>
					出售车位用户信息：<br>
						真实姓名:${buyAgreementTaskBean.saleUserRealName }     身份证号码:${buyAgreementTaskBean.saleUserIdCard }<br>
						联系号码:${buyAgreementTaskBean.saleUserPhone }
					
					</div>
					<div>
					购买车位用户信息：<br>
						真实姓名:${buyAgreementTaskBean.buyUserRealName }     身份证号码:${buyAgreementTaskBean.buyUserIdCard }<br>
						联系号码:${buyAgreementTaskBean.buyUserPhone }
					
					</div>
					成交价格:${buyAgreementTaskBean.salePrice }
					</div>	
					<br>
					<div id="btnDiv">
					   	<a href="affirmBuyAgreementTask?agreementId=${buyAgreementTaskBean.agreementId }"><input class="btn btn-info button" type="button" id="agree" value="同意"></a>
		    			<a href="dealSellTask"><input class="btn btn-info button"  type="button" id="disagree" value="返回"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>


