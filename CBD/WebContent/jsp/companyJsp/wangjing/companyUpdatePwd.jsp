<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<title>CBD停车管理平台系统</title>

<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<script type="text/javascript" src="/CBD/js/action.js"></script>
<script type="text/javascript" src="/CBD/js/unslider.min.js"></script>
<script type="text/javascript" src="/CBD/js/hxm/updateSuperAdmin.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/action.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/wangjing/updateCompanyPwd.css">
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
		    
		    <div id="updatePwd" >
		    <h1>修改密码</h1>
		    <form id="updateSuperAdminForm" action="submitUpdateCompanyPwd" method="post">
				<label>原&nbsp;&nbsp;密&nbsp;&nbsp;码：</label>
				<input type="password"  name="oldPassword"   placeholder="原密码"><br>${failMessage1}<br>
		   		<label>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</label>
		   		<input type="password"  id="newPassword" name="newPassword"   placeholder="新密码"><br>${failMessage2}<br>
		   		<label>重复密码：</label>
		   		<input type="password"  id="repeatPassword" name="repeatPassword"  placeholder="重复密码"><br><br>
		   		<input class="btn btn-default" type="submit"  value="修改"> 
		   		<input class="btn btn-default" type="button"  value="返回" onclick="javascript:window.location.href='returnCompanyMain'">
		    </form>
		    </div>	
		 
		</div>
	</div>
	</div>

	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>  
</body>
</html>