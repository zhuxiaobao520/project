<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/CBD/css/homePage.css">
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<script src="/CBD/js/zhangping/single.js"></script>
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
				<span>添加单个车位</span>
			</div>
		  <div class="r_ctn clearfix">
          <form  class="cmxform" id="single"  action="carportAddSingle" method="post">
        	<ul class="rent clearfix">
            	<li class="clearfix">
                	<span class="title">车位所在地址</span>
                    <div class="li_r">
                    	<input name="cbdCarportAddress" type="text" >
                    </div>
                </li>
                <li class="clearfix">
                	<span class="title">车位编号</span>
                    <div class="li_r">
                    	<input id="carportAddressNo" name="cbdCarportAddressNo" type="text" ><span id="message">${message }</span>
                    </div>
                </li>
                <li class="clearfix">
                	<span class="title">&nbsp;</span>
                    <div class="li_r">
                    	<input name="" type="submit"  value="添加" >
                        <input name="back" type="reset" value="返回" onclick="javascript:history.back(-1);">
                    </div>
                </li>
            </ul>
            </form>
        </div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>