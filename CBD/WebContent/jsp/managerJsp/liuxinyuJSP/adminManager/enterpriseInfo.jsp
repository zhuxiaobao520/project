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

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<script type="text/javascript" src="/CBD/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
</head>
<body>
	<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

 
	<div class="scd clearfix">
	  	<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
        <div class="r_ctn clearfix" >
        	<div class="save">
                       
                <ul class="s_a s_b clearfix">
                	<li class="clearfix" >
                    	<span class="tit">企业名称：</span>
                         <h5>富士康</h5>
                    </li>
                    <li class="clearfix">
                    	<span class="tit">企业楼层位置：</span>
                         <h4>成都</h4>
                    </li>
                    <li class="clearfix">
                    	<span class="tit">企业联系人：</span>
                          <h3>xoxox</h3>
                    </li>
                 
                    <li class="clearfix">
                    	<span class="tit">企业联系电话：</span>
                        <h2>111010010</h2>
                    </li>                 
                    <li class="clearfix">
                    	<span class="tit">&nbsp;</span>
                        <div class="li_r btn" >
                        	<input name="" type="button" value="返回" style="background-color:rgb(0,141,227);">
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
  </div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>