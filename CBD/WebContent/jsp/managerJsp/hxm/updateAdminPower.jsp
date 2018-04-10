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
<!--修改管理员权限 ——黄先明 -->
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通管理员信息</title>

<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<script type="text/javascript" src="/CBD/js/action.js"></script>
<script type="text/javascript" src="/CBD/js/unslider.min.js"></script>
<script type="text/javascript" src="/CBD/js/hxm/addAdmin.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/action.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/hxm/updatePower.css">

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
		                <span><a href="">${adminLogining.adminRealName}</a></span>
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
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
		        <li><img src="Assets/upload/banner_a.jpg" alt="" width="1600" height="260" ></li>
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
		            <li><a href="goToUpdateSuperPwd">修改密码</a></li>

		        </ul>
		    </div>	
		    
		    <div class="scd_r">
			<div class="r_name">
				<span>修改管理权限</span>
			</div>
			<div class="r_ctn clearfix">
		     <h1>修改管理员信息详情</h1>
		    <div id="updatePower" >
		   
		   
				<p>账号：<label id="adminAccount">${CheckedAdmin.adminAccount }</label></p>
		   		
		   		<p>工号：<label >${CheckedAdmin.adminNo }</label></p>
		   		<p>真实姓名：<label >${CheckedAdmin.adminRealName }</label></p>
		   		<p>电话号码：<label >${CheckedAdmin.adminPhone }</label></p>
		   		<form action="updateAdminPower" method="post"> 
		   				<input type="hidden"  name="adminId" value="${CheckedAdmin.adminId }">
				   		<p>权限： 
				   		
							<c:if test="${CheckedAdmin.admiUserManagerPower==1 }">
								<input type="checkbox" name="admiUserManagerPower" value="1" checked="checked">用户管理 
							</c:if>
							<c:if test="${CheckedAdmin.admiUserManagerPower==0 }">
								<input type="checkbox" name="admiUserManagerPower" value="1" >用户管理 
							</c:if>
							
							<c:if test="${CheckedAdmin.adminCarPortManagerPower==1 }">
								<input name="adminCarPortManagerPower" type="checkbox" value="1" checked="checked">车位管理  
							</c:if>
							<c:if test="${CheckedAdmin.adminCarPortManagerPower==0 }">
								<input name="adminCarPortManagerPower" type="checkbox" value="1" >车位管理  
							</c:if>
							
							<c:if test="${CheckedAdmin.adminAgreementManagerPower==1 }">
								<input name="adminAgreementManagerPower" type="checkbox" value="1" checked="checked">合约管理 
							</c:if>
							<c:if test="${CheckedAdmin.adminAgreementManagerPower==0 }">
								<input name="adminAgreementManagerPower" type="checkbox" value="1" >合约管理 
							</c:if>
							
							<c:if test="${CheckedAdmin.adminCompaintManagerPower==1 }">   			
				   		 		<input name="adminCompaintManagerPower" type="checkbox" value="1" checked="checked">投诉管理 
							</c:if>
							<c:if test="${CheckedAdmin.adminCompaintManagerPower==0 }">   			
				   		 		<input name="adminCompaintManagerPower" type="checkbox" value="1" >投诉管理 
							</c:if>
				   		</p>
				   		<!--修改成功返回查看普通管理员列表  -->	
				   		<p><input class="btn btn-info button" type="submit"  value="修改">
				   		<a href="goToAdminInfoList"><input class="btn btn-info button" id="return"  type="button"  value="返回"></a> </p>
				</form>	
		    </div>	
		 
		</div>
		</div>
		</div>

	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>    
</body>
</html>