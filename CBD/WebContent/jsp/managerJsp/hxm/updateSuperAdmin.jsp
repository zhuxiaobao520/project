<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--管理员查看用户信息列表  -->
<%
	//获取跟路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--添加管理员 ——黄先明 -->
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
<link rel="stylesheet" type="text/css" href="/CBD/css/hxm/updateSuperAdmin.css">

</head>
<body>
		<!--头部-->
		<div class="header">
		    <div class="head clearfix">
		        <div class="logo">
		        	<img src="/CBD/Assets/images/logo3.png" alt="CDB"/>
		        </div>
		        <div class="head_r">
			        <div class="widght">
						<iframe allowtransparency="true" frameborder="0" width="360" height="64" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=&ltf=009944&htf=cc0000&q=0&e=1&a=1&c=54511&w=410&h=64&align=center"></iframe>
					</div>
		        	<div class="h_rt">
		            	<span>咨询电话：<b>400-066-8939</b></span>在线人数：${lineCount }
		                <span>${adminLogining.adminRealName}</span>
		            </div>
		            <ul class="nav clearfix">
		                <li><a href="jumpHome">首页</a></li>
		                <li><a href="jumpExit">注销</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
		<!--头部-->
		<!--幻灯片-->
		<div class="banner_img" id="b04">
		    <ul>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		    </ul>
		</div>
		<!--幻灯片-->
		<div class="space_hx">&nbsp;</div>
		<div class="scd clearfix">
			<div class="scd_l">
		    	<div class="name">管理员<em>/ABOUT</em></div>
		        <ul class="s_nav clearfix">
		        	<li ><a href="goToAdminInfoList">员工信息管理</a></li>		        	
		            <li ><a href="goToAddAdmin">新增员工</a></li>
		            <li class="now"><a href="goToUpdateSuperPwd">修改密码</a></li>

		        </ul>
		    </div>
		    
		    <div class="scd_r">
			<div class="r_name">
				<span>员工信息管理</span>
			</div>
			<div class="r_ctn clearfix">	
		    
		    <div id="updateSuperAdmin" >
		    <h1>修改密码</h1>
		    <form id="updateSuperAdminForm" action="updateSuperAdmin" method="post">
				<p>原密码：<input type="password" class="form-control" name="oldPassword"   placeholder="原密码">${superAdminPwdError }</p>
		   		<p>新密码：<input type="password" class="form-control" id="newPassword" name="newPassword"   placeholder="新密码">${pwdError }</p>
		   		<p>重复密码：<input type="password" class="form-control" id="repeatPassword" name="repeatPassword"  placeholder="重复密码"></p>	
		   		<div id="btnDiv"><input class="btn btn-info button" type="submit" id="updateSuperAdminBtn" value="修改"> 
		   		<a href="goToAdminInfoList"><input class="btn btn-info button" type="button" id="return" value="返回"></a></div>
		   </form>
		    </div>	
		 
		</div>
		</div>
		</div>

	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>  
</body>
</html>