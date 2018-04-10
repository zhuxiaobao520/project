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
 <script type="text/javascript" src="/CBD/js/liuxinyu/rentsContract.js"></script> 
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript">
</script>
</head>
<body>
<!--头部-->
<%-- 	<jsp:include page="adminHeader.jsp" /> --%>
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/adminLeftList.jsp"  %>
     <div class="scd_r" >
          <div class="r_name"><span>普通管理员</span></div> 
        <div class="r_ctn clearfix" >
                    <div class="save">                   
                       <div class="title">
                	       <span>租户合约信息表</span>
                       </div>                              
                 <table class="table  table-bordered table-hover" id="AgreementInfo"
				border="1" cellspacing="0">
				 <tr>
					<th>合同编号</th>
					<th>合同状态</th>									
					<th>生效日期</th>
					<th>截止日期</th>
					<th>成交价格</th>					
				 </tr>				 
		    	</table>		
				<input  class="style" id="firstPage" type="button" value="首页">
				<input  class="style" id="prePage" type="button" value="上一页">
				<input id ="query" type="text" value="" style="width: 30px;"><span id="total"></span>
				<input  class="style" id="jump" type="button" value="跳转">
				<input  class="style" id="nextPage" type="button" value="下一页">
				<input  class="style" id ="lastPage" type="button" value="尾页">

                     <ul class="rent clearfix">
                        <li class="clearfix">                  
                        <div class="li_r btn" style="width: 500px">
                        	<input id="addAgreement" type="submit" value="添加">   
                        	<input id="extensionAgreement" type="submit" value="续约"> 
                        	<input id="disAgreement" type="submit" value="解约">  
                        	<input id="agreementHidden" type="hidden" value="-1">                          
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