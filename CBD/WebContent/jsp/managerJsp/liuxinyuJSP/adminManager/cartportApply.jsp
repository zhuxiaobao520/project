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
<meta name="viewport">
<title>CBD停车管理平台系统</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript" src="/CBD/js/tangXiaoXiong/cartportApply.js"></script>
</head>
<body>
	<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->
    <div class="scd clearfix">
        <%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
       <div class="r_name"><span>不通过，通知用户</span></div>  
        <div class="r_ctn clearfix" >
        	<div class="save">
                       
                <ul class="s_a s_b clearfix">
                	<li class="clearfix" >
                    	<span class="tit">用户名：</span>
                         <h2>${usercarportEntity.user.userName}</h2>
                    </li>
                    <li class="clearfix">
                    	<span class="tit">用户真实姓名：</span>
                         <h2>${usercarportEntity.user.userRealName}</h2>
                    </li>
             
          
                     <li class="clearfix">
                    	<span class="tit">车位地址：</span>
                        <h2>${usercarportEntity.userCarportAddress}</h2>
                     </li> 
                     <li class="clearfix">
                    	<span class="tit">车位编号：</span>
                        <h2>${usercarportEntity.userCarportAddressNo}</h2>
                    </li>

                     <li class="clearfix">
                    	<span class="tit">不通过原因：</span>
                         <textarea id="yuanyin" rows="5" cols="25"></textarea>
                    </li>             
                    <li class="clearfix">
                        <div class="li_r btn" >
                        	<input id="hid" type="hidden" value="${usercarportEntity.userCarportId}">
                        	<input id="userid" type="hidden" value="${usercarportEntity.user.userId}">
                        	<input id="fasongtongzhi" type="button" value="发送通知" class="style">
                        	<a href="jumpUserAdmin"><input class="style" name="" type="button" value="返回"></a>
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