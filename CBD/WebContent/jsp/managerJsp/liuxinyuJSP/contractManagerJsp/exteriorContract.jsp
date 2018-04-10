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
 <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!--   可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<script type="text/javascript" src="/CBD/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>	
    <div class="scd clearfix">
          	<jsp:include page="/jsp/managerJsp/agreementManagerLeft.jsp" />
     <div class="scd_r">
        <div class="r_ctn clearfix">
        	<div class="save">
                <ul class="s_a s_b clearfix">                	
                    <h1>外部合约</h1>                  
                           <table  border="1" cellspacing="0" style="width: 100%;text-align: center;margin: 0 auto;" >
                         <thead><tr><td>合同编号</td><td>合同单位</td><td>对方联系人</td><td>对方联系电话</td><td>车位地址</td><td>合同生效日期</td><td>合同截止日期</td><td>操作</td></tr></thead>
                            <tbody><tr><td>停1111</td><td>xoxoox</td><td>xo</td><td>66666</td><td>xoxoox</td><td>2012-2-2</td><td>2017-7-7</td>
                             <td ><input name="" type="button" value="续约" style="background-color:rgb(0,141,227);"><input name="" type="button" value="解约" style="background-color:rgb(0,141,227);"></td></tr></tbody>
                               </table><br>
                                    
                    <li class="clearfix">
                    	<span class="tit">&nbsp;</span>
                        <div class="li_r btn">
                        	<input name="" type="submit" value="新增">
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