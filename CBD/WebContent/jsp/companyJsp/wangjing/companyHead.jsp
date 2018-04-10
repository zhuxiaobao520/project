<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<script type="text/javascript" src="/CBD/js/action.js"></script>
<script type="text/javascript" src="/CBD/js/unslider.min.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
<link rel="stylesheet" type="text/css" href="/CBD/css/action.css">
		<!--头部-->
		<div class="header">
		    <div class="head clearfix">
		        <div class="logo"><img src="/CBD/Assets/images/logo3.png" alt="CDB"/></div>
		        <div class="head_r">
			        <div class="widght">
						<iframe allowtransparency="true" frameborder="0" width="360" height="64" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=&ltf=009944&htf=cc0000&q=0&e=1&a=1&c=54511&w=410&h=64&align=center"></iframe>
					</div>
		        	<div class="h_rt">
		            	<span>咨询电话：<b>400-066-8939</b></span>
		            	在线人数：${lineCount }
		                <span>${companyLogin.companyAccount },欢迎您&nbsp;</span>
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
