<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//获取跟路径
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<script src="/CBD/js/jquery.js"></script>
</head>
<body>
<!--头部-->
<%-- 	<jsp:include page="adminHeader.jsp" /> --%>
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/tangxiaoxiongJSP/Pilot/companyLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>测试</span></div> 
        <div class="r_ctn clearfix" >               
            </div>
        </div>
    </div>
   
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>