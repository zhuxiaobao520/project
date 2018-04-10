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
<title>CBD停车管理平台系统</title>
<!-- 普通管理员界面 -->
<base href="<%=basePath%>">
<title>普通管理员</title> 
<script src="/CBD/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript" src="/CBD/js/tangXiaoXiong/adminManager.js"></script>
</head>
<body>
<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>个人用户</span>
          	<select id="selectSta">
          		<option value="div1">车位审核</option>
          		<option value="div2">合同派发</option>
          	</select>
          </div> 
        <div class="r_ctn clearfix" >

                   <div class="save">
                    <div id="div1" style="display: block;">
                       <div class="title">
                	       <span>待审车位信息表</span>
                       </div>                              
                        <div class="table"><table  border="1" cellspacing="0" style="width: 100%;text-align: center;margin: 0 auto;" >
                          <thead><tr><td>用户信息</td><td>车位信息</td><td>操作</td></tr></thead>
                          <tbody id="tbody" class="tbody"></tbody>
                        </table></div><br>
							<input class = "style" id="pageFirstNo" type="button" value="首页">
							<input class = "style" id="pagePreNo" type="button" value="上一页">
							<input id ="pageTotal" type="text" value="" style="width: 30px;"><span id = "sp1"></span>
							<input class = "style" id="pageTiaoNo" type="button" value="跳转">
							<input class = "style" id="pageNextNo" type="button" value="下一页">
							<input class = "style" id ="pageLastNo" type="button" value="尾页">
					</div>
					 <div id="div2" style="display: none;">
                        <div class="title">
                	       <span>待处理签约交易</span>
                       </div> 
                           <div class="table"><table  border="1" cellspacing="0" style="width: 100%;text-align: center;margin: 0 auto;" >
                          <thead><tr><td>卖家</td><td>买家</td><td>车位</td><td >操作</td></tr></thead>
                          <tbody id="tbody3" class="tbody"></tbody>
                        </table> </div><br>
							<input class = "style" id="pageFirstNo3" type="button" value="首页">
							<input class = "style" id="pagePreNo3" type="button" value="上一页">
							<input id ="pageTotal3" type="text" value="" style="width: 30px;"><span id = "sp3"></span>
							<input class = "style" id="pageTiaoNo3" type="button" value="跳转">
							<input class = "style" id="pageNextNo3" type="button" value="下一页">
							<input class = "style" id ="pageLastNo3" type="button" value="尾页">
						</div>
                    </div>                    
            </div>
        </div>
    </div>
   
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>