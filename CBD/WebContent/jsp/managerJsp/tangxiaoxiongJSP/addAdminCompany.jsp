<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>企业用户</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript" src="/CBD/js/tangXiaoXiong/addAdminCompany.js"></script>
</head>
<body>
<!--头部-->
<%-- 	<jsp:include page="adminHeader.jsp" /> --%>
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>添加企业用户</span></div> 
        <div class="r_ctn clearfix" >
                 <div class="save">
                      <form action="AddTheEnterprise" id="AddTheEnterprise" method="post">
               		<ul class="s_a s_b clearfix">
	                	<li class="clearfix">
	                    	<span class="tit">企业登录名：</span>
	                        <div class="li_r">
	                        	<input id="companyAccount" name="companyAccount" type="text" value="${companyBean.companyAccount}">
	                        	<span id="sp_jg2">${companyAccount}</span>
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">企业登录密码：</span>
	                        <div class="li_r">
	                        	<input id="companyPassword" name="companyPassword" type="password" value="${companyBean.companyPassword}">
	                        	<span id="companyPasswordSpan"> ${companyPassword}</span>
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">企 业 名 称：</span>
	                        <div class="li_r">
	                        	<input  id="companyName" name="companyName" type="text" value="${companyBean.companyName}">
	                        	<span id="sp_jg">${company}${companyName}</span>
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">企业楼层位置：</span>
	                        <div class="li_r">
	                        	<input id="companyAddress" name="companyAddress" type="text" value="${companyBean.companyAddress}">
	                        	<span id="companyAddressSpan">${company}${companyAddress}</span>
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">企业联系人：</span>
	                        <div class="li_r">
	                        	<input id="companyLinkMan" name="companyLinkMan" type="text" value="${companyBean.companyLinkMan}">
	                        	<span id="companyLinkManSpan">${company}${companyLinkMan}</span>
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                    	<span class="tit">企业联系电话：</span>
	                        <div class="li_r">
	                        	<input id="companyPhone" name="companyPhone" type="text" value="${companyBean.companyPhone}">
	                        	<span id="companyPhoneSpan" >${companyPhone}</span> 
	                        </div>
	                    </li>
	                    <li class="clearfix">
	                        <div class="li_r btn">
	                        	<input class="style" name="" type="submit" value="添加">
	                            <a href="returnadminCompany"><input class="style" name="" type="button" value="返回"></a>
	                        </div>
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