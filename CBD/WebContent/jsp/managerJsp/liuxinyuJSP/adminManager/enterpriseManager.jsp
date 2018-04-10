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
   <div class="scd_r">
        <div class="r_ctn clearfix">
        
                         <h1 >企业用户主页</h1> 
                           <table  border="1" cellspacing="0" style="width: 100%;text-align: center;margin: 0 auto;" >
                          <thead><tr><td>企业登录名</td><td>企业登录密码</td><td>企业名称</td><td >企业楼层位置</td><td >企业联系人</td><td >操作</td></tr></thead>
                          <tbody><tr><td>xoxo</td><td>1111</td><td>lovo</td><td>17</td><td>ooo</td><td >
                          <input name="" type="button" value="查看" style="background-color:rgb(0,141,227);">
                          <input name="" type="button" value="删除" style="background-color:rgb(0,141,227);">
                          </td></tr></tbody>
                        </table> 
        
        
        
        
        	  <fieldset id="searchCon">
                <legend>查询虫害信息</legend>
	                                 害虫名：<inp ut type="text"><br><br>  
                                               寄主：<input type="text" ><br><br> 	
	              <input type="button"  value="查询">	
               </fieldset>
               
               <input type="button" value="新增企业">
        </div>
    </div>
 </div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file=/jsp/bottom.jsp" %>	
</body>
</html>