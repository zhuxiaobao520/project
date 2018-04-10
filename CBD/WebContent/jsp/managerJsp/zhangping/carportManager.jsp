<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>CBD停车管理平台系统</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<script src="/CBD/js/jquery.js"></script>
<script type="text/javascript" src="/CBD/js/liuxinyu/carportManager.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
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
				<span>普通管理员</span>
				<a href="carportBatch" style="float: right;margin-right: 50px;" >批量车位添加</a>
				<a href="cartportSingle" style="float: right;margin-right: 10px;" >个人车位添加</a>
			</div>
			
			<div class="r_ctn clearfix">
				<div class="save">
             <div class="title">
                	<span>查看车位信息</span>
              </div>
                </div>
                <br>
                <div id="carportInfo"></div>			 
				<input  class="style" id="firstPage" type="button" value="首页">
				<input  class="style" id="prePage" type="button" value="上一页">
				<input id ="query" type="text" value="" style="width: 30px;"><span id="total"></span>
				<input  class="style" id="jump" type="button" value="跳转">
				<input  class="style" id="nextPage" type="button" value="下一页">
				<input  class="style" id ="lastPage" type="button" value="尾页">
			<br><br>
			
			<div class="mofu"><br>
			<!-- 	  <li class="clearfix">
                	<span style="left: 12px;position: relative;" class="title" >是否出租</span>
                    <div style="left: 80px;top:-25px; position: relative;" class="li_r">
                    	<select  id="rent">
                        	<option value="unlimited" >不限</option>
                            <option value="rent">以租</option>
                            <option value="notRent">未租</option>
                        </select>
                    </div>
                </li>  -->
					<a class="a_tit">车位地址：<input type="text" id="site"></a><br>
					<a class="a_tit">车位编号：<input type="text" id="number"></a><br>
					<a class="a_tit"><input type="button" id="search" value="查询" class="style"></a><br><br>
				
			</div>

			
			</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>