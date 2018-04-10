<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags"  prefix="shiro" %>	
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<script type="text/javascript" src="js/js_z.js"></script>
<script type="text/javascript" src="js/action.js"></script>
<script type="text/javascript" src="js/unslider.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/thems.css">
<link rel="stylesheet" type="text/css" href="css/action.css">
<!--头部-->
<div class="header">
	<div class="head clearfix">
		<div class="logo">
			<img src="/CBD/Assets/images/logo3.png" alt="CDB" />
		</div>
		<div class="head_r">
			<div class="widght">
				<iframe allowtransparency="true" frameborder="0" width="360" height="64" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=&ltf=009944&htf=cc0000&q=0&e=1&a=1&c=54511&w=410&h=64&align=center"></iframe>
			</div>
			<div class="h_rt">
				<span>咨询电话：<b>400-066-8939</b></span>在线人数：${lineCount } <span><span>${adminLogining.adminAccount},欢迎您
			</div>
			<ul class="nav clearfix">
				<li><a href="jumpHome">首页</a></li>
				<shiro:hasPermission name="userAdmin">
					<li><a href="jumpUserAdmin">用户管理</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="agreementAdmin">
					<li><a href="jumpAgreementAdmin">合约管理</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="complaintAdmin">
					<li><a href="jumpComplainAdmin">投诉管理</a></li>
				</shiro:hasPermission>
				<li><a href="jumpExit">注销</a></li>
			</ul>
		</div>
	</div>
</div>
<!--头部-->
<!--幻灯片-->
<div class="banner_img" id="b04">
	<ul>
		<li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600"height="260"></li>
		<li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600"height="260"></li>
		<li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600"height="260"></li>
		<li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600"height="260"></li>
		<li><img src="/CBD/Assets/upload/banner_a.jpg" alt="" width="1600"height="260"></li>
	</ul>
</div>
<!--幻灯片-->
