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
<title>修改个人信息</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js//messages_zh.js"></script>
<script src="/CBD/js/zhangping/updateGeneralManager.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
</head>
<body>
<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>修改个人密码</span></div> 
        <div class="r_ctn clearfix" >
            <div class="save">
               <form id="updateGeneralManager" action="updateGeneralManager" method="post">
               		<ul class="s_a s_b clearfix">
	                    <li class="clearfix">
	                    	<span class="tit">原密码：</span>
	                        <div class="li_r">
	                        	<input name="oldPassword" type="password" id="oldPassword" value="${checkAdminBean.oldPassword}">
	                        	<span id="oldPasswordSpan"  style="color: red;">${GeneralManager}</span>${oldPassword}
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">现密码：</span>
	                        <div class="li_r">
	                        	<input id="newPassword" name="newPassword" type="password" value="${checkAdminBean.oldPassword}">
	                        	<span style="color: red;" id="newPasswordSpan">${newPassword}</span> 
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">重复密码：</span>
	                        <div class="li_r">
	                        	<input id="chongfuPassword" name="chongfuPassword" type="password" value="${checkAdminBean.oldPassword}">
	                        	<span style="color: red;" id="chongfuPasswordSpan">${chongfuPassword}</span> 
	                        	
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">&nbsp;</span>
	                        <div class="li_r btn">
	                        	<input class="style" name="" type="submit" value="修改">
	                            <a href="PersonalInformationReturn" ><input class="style" name="" type="button" value="返回"></a>
	                        </div>
	                        <input type="hidden" name="adminId" value="${adminLogining.adminId}" />
	                    </li>
               		 </ul>
               </form>
            </div>                    
        </div>
      </div>
   </div>
   
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>