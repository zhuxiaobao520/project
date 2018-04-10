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
<link rel="stylesheet" type="text/css" href="/CBD/css/tangXiaoXiong/adminManager.css">
<script type="text/javascript" src="/CBD/js/tangXiaoXiong/adminCompany.js"></script>
</head>
<body>
<!--头部-->
  <%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->

   <div class="scd clearfix">
          	<%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
     <div class="scd_r" >
          <div class="r_name"><span>企业用户主页</span></div> 
        <div class="r_ctn clearfix" >

                      <div class="save">
                       <div class="title">
                	       <span>企业用户信息表</span><a class="a_xiugai" href="adminCompanyDetails">新增企业</a>
                       </div>                              
                        <div class="table"><table border="1" cellspacing="0" style="width: 100%;text-align: center;margin: 0 auto;" >
                          <thead><tr><td>企业登录名</td><td>企业名称</td>
                          <td>企业楼层位置</td><td>企业联系人</td><td>企业联系电话</td><td>操作</td></tr></thead>
                          <tbody id="tbody" class="tbody"></tbody>
                        </table></div><br>
							<input class = "style" id="pageFirstNo" type="button" value="首页">
							<input class = "style" id="pagePreNo" type="button" value="上一页">
							<input id ="pageTotal" type="text" value="" style="width: 30px;"><span id = "sp1"></span>
							<input class = "style" id="pageTiaoNo" type="button" value="跳转">
							<input class = "style" id="pageNextNo" type="button" value="下一页">
							<input class = "style" id ="pageLastNo" type="button" value="尾页"><br><br>
							<div class="mofu"><br>
								<a class="a_tit">企业名称：<input type="text" id="companyName"></a><br>
								<a class="a_tit">楼层位置：<input type="text" id="companyAddress"></a><br>
								<a class="a_tit">联   系  人：<input type="text" id="companyLinkMan"></a><br>
								<a class="a_tit">联系人电话：<input type="text" id="companyPhone"></a><br>
								<a class="a_tit"><input type="button" id="qiyemohuchaxuntxx" value="查询" class="style"></a><br><br>
							</div>
                    </div>                    
            </div>
        </div>
    </div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>