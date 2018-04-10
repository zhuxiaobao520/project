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
<title>企业详情</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
</head>
<body>
	<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

	<div class="scd clearfix">
		<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
      <div class="r_name"><span>企业详情</span></div> 
        <div class="r_ctn clearfix" >
        	<div class="save">
                       
                <ul class="s_a s_b clearfix">
                	<li class="clearfix" >
                    	<span class="tit">企业名称：</span>
                    	${companyEntity.companyName}
                    </li>
                    <li class="clearfix">
                    	<span class="tit">楼层位置：</span>
                         ${companyEntity.companyAddress}
                    </li>
                    <li class="clearfix">
                    	<span class="tit">联系人：</span>
                         ${companyEntity.companyLinkMan}
                    </li>
                 
                    <li class="clearfix">
                    	<span class="tit">联系人电话：</span>
                        ${companyEntity.companyPhone}
                    </li> 
                    <li class="clearfix">
                        <div class="li_r btn" >
                        	<a href="returnadminCompany"><input class="style" name="" type="button" value="返回"></a>
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