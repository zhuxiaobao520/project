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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>登录</title>
<base href="<%=basePath%>">
<link href="css/longcheng/login.css" rel="stylesheet" type="text/css" />
<link href="css/longcheng/drag.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/thems.css" >
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/drag.js" type="text/javascript"></script>
<script src="js/longcheng/login.js" type="text/javascript"></script>
</head>

<body>
<!--头部-->
<div class="header">
    <div class="head clearfix">
        <div class="logo"><img src="/CBD/Assets/images/logo3.png" alt="CBD"/></div> 
        <div class="head_r">
	        <div  style="float: left; margin-top: 20px;">
				<iframe allowtransparency="true" frameborder="0" width="360" height="64" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=&ltf=009944&htf=cc0000&q=0&e=1&a=1&c=54511&w=410&h=64&align=center"></iframe>
			</div>
        	<div class="h_rt">
            	<span>电话咨询：<b>400-066-8939</b></span>
            </div>
            <ul class="nav clearfix">
                <li><a href="jumpHome">首页</a></li>
                <li><a href="jumpRegister">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="login_box">
      <div class="login">
          <div class="login_logo"><a href="#"><img src="image/longcheng/login_logo.png" /></a></div>
          <div class="login_name">
              <span id="userLogin" class="logintype">个人登录</span> <span>|</span> <span id="companyLogin" class="logintype">企业登录</span> <span>|</span> <span id="adminLogin" class="logintype">管理员登录</span>
          </div>
          <form id="loginForm" action="userlogin" method="post">
              <input id="account" name="userName" type="text" value="${userName}"  placeholder="请输入用户名"><br><br>
			  <input name="userPassword" type="password" id="password" placeholder="请输入密码"><br>
              <div id="drag">
              </div><br>
              <input id="loginBtn" value="登录" style="width:100%;" type="button"><br>
              <input id="loginTypeHidden" type="hidden" value="-1">
          </form>
      </div>
      <div class="copyright">CBD有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
<script type="text/javascript">
$('#drag').drag();
</script>
</body>
</html>