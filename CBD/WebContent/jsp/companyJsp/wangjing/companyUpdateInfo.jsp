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

<base href="<%=basePath%>">
<title>企业信息修改</title>
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
<script type="text/javascript" src="/CBD/js/wangjing/companyUpdateInfo.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/wangjing/updateCompanyInfo.css">
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/companyJsp/wangjing/companyHead.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix">
		<jsp:include page="/jsp/companyJsp/wangjing/companyLeftList.jsp" />
		<div class="scd_r">
			<div class="r_name">
				<span>修改企业信息</span>
			</div>
			<div class="r_ctn clearfix">
		<div id="updateCompanyInfo">
			<h1>修改企业信息</h1>
			<form action="submitUpdateCompanyInfo" id="updateCompanyInfoForm" class="form-inline">
				<div id="formleft">
					<input type="hidden" name="companyId" value="${nowCompanyBean.companyId}">
					<div class="form-group">
			    		<label>用户名：</label>
			    		<input type="text" class="form-control" name="companyAccount"  placeholder="" value="${nowCompanyBean.companyAccount}">
			    		<label id="message">${messageFaile}</label>
			  		</div>
			  		<div class="form-group">
			    		<label>企业名称：<span name="companyName">${nowCompanyBean.companyName}</span></label>
			  		</div>
			  		<div class="form-group">
			    		<label>企业联系人：</label>
			    		<input type="text" class="form-control" name="companyLinkMan"  placeholder="" value="${nowCompanyBean.companyLinkMan}">
			    		<label id="message">${messageFaileLink}</label>
			  		</div>
				</div>
				<div id="formright">
					<div class="form-group">
					    <label>企业地址：<span name="companyAddress">${nowCompanyBean.companyAddress}</span></label>
			  		</div>
			  		<div class="form-group">
					    <label>联系人电话：</label>
					    <input type="text" class="form-control" name="companyPhone"  placeholder="" value="${nowCompanyBean.companyPhone}"><br>
			  		</div>
			  		<div class="form-group">
			  			<label id="message">&nbsp;&nbsp;&nbsp;${message}</label>
			  		</div>
			  		
				</div>
			   <div id="buttonDiv">
				  <button type="submit" class="btn btn-default">修改</button>
				  <button type="button" class="btn btn-default"  onclick="javascript:window.location.href='returnCompanyMain'">返回</button>
			   </div>
			</form>	
		</div>
	</div>
	</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>