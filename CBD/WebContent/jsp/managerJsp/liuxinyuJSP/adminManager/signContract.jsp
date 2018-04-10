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
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript" src="/CBD/js/tangXiaoXiong/signContract.js"></script>
</head>
<body>
	<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

    <div class="scd clearfix">
    <%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
        <div class="r_ctn clearfix" >
        	<div class="save">
                 <div class="r_name"><span>双方签约合同</span></div> 
                <ul class="s_a clearfix">
                	<li class="clearfix" >
                    	<span class="tit">合同编号：</span>
                         <div class="li_r">
	                     	<input id="agreementNo" type="text">
	                     </div>
                    </li>
                    <li class="duan clearfix">
                    	<span class="tit">卖方用户信息：</span>
                         <h2>${buyDetailBean.saleUserName}</h2>
                    </li>

                     <li class="clearfix">
                    	<span class="tit">车位信息：</span>
                        <h2>${buyDetailBean.userCarportAddress}</h2>
                     </li> 
                     <li class="duan clearfix">
                    	<span class="tit">买方用户信息：</span>
                        <h2>${buyDetailBean.buyUserName}</h2>
                    </li>
                      <li class="clearfix">
                    	<span class="tit">成交价格：</span>
                        <h2>${buyDetailBean.salePrice} 元</h2>
                    <li class="clearfix" style="margin-left: 100px">
                        <span class="tit">&nbsp;</span>
                        <div class="li_r btn" >
                        	<input id="agreementCarportId" type="hidden" value="${buyDetailBean.userCarportId}">
                        	<input id="agreementBuyInfoId" type="hidden" value="${buyDetailBean.buyInfoId}">
                        	<input id="tongzhishuangfang" type="button" value="通知双方" class="style">
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