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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>CBD停车管理平台系统</title>

<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<script type="text/javascript" src="/CBD/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">
</head>
<body>
<%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->	
    <div class="scd clearfix">
      <%@include file="/jsp/managerJsp/agreementManagerLeft.jsp" %>
      
     <div class="scd_r">
        <div class="r_name"><span>外部合约续约</span></div> 
        <div class="r_ctn clearfix">  
              
                <form action="">
              <ul class="rent clearfix">
                	<li class="clearfix">
                    	<span class="title">原合同编号：</span>
                          <h2>xoxoxox</h2>
                    </li>
                   
                    <li class="clearfix">
                    	<span class="title">新合同编号：</span>
                        <div class="li_r">
                        	<input name="" type="text">
                        </div>
                    </li>
                    
                    <li class="clearfix">
                    	<span class="title">合同单位：</span>
                          <h2>xxxxx</h2>
                    </li>
                    <li class="clearfix">
                    	<span class="title">对方联系人：</span>
                        <div class="li_r">
                        	<input name="" type="text"> 
                        </div>
                    </li>
                    <li class="clearfix">
                    	<span class="title">对方联系电话：</span>
                        <div class="li_r">
                        	<input name="" type="text">                        
                        </div>
                    </li>
                 
                    <li class="clearfix">
                    	<span class="title">合同生效期：</span>
                        <div class="li_r">
                        	<input name="" type="date">                          
                        </div>
                    </li>  
                    
                    <li class="clearfix">
                    	<span class="title">合同截止期：</span>
                        <div class="li_r">
                        	<input name="" type="date">                          
                        </div>
                    </li>  
              
                     <li class="clearfix">
                    	<span class="title">对方联系电话：</span>
                        <div class="li_r">
                        	<input name="" type="text">                          
                        </div>
                    </li> 
                    <li class="clearfix">
                    	<span class="title">成交价格：</span>
                        <div class="li_r">
                        	<input name="" type="text">                          
                        </div>
                    </li>
                    
                     <li class="clearfix">
                	<span class="title">新合同复印件：</span>
                    <div class="li_r">
                    	<input name="" type="file">
                        <input name="" type="submit" id="sc" value="上传">
                    </div>                          
                    <li class="clearfix">
                    	<span class="title">&nbsp;</span>
                        <div class="li_r btn">
                        	<input name="" type="submit" value="添加">
                            <input name="" type="reset" value="取消">
                        </div>
                    </li>
                </ul>
                </form>
            </div>
        </div>
 
  </div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>