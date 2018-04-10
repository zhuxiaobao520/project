<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	//获取根路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>个人用户注册</title>
<link href="css/longcheng/register.css" rel="stylesheet" type="text/css" />
<link href="css/longcheng/drag.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_zh.js"></script>
<script src="js/drag.js" type="text/javascript"></script>
<script type="text/javascript" src="js/yinshi/registerCheck.js"></script>
</head>
<body>
<div class="register_box">
      <div class="register">
          <div class="register_name">
              <span class="registertype">个人用户注册</span>
          </div>
          <form id="signupForm" action="register" method="post">
              <p>
              	<input id="userName" class="registerLeft" name="userName" type="text" value="${userBean.userName }"  placeholder="请在这里输入用户名" /><label>${userName}</label>
			  	<input id="userPassword" class="registerRight" name="userPassword" type="password"  placeholder="请在这里输入密码" /><label>${userPassword}</label>
              </p>
              <p>
	              <input id="userRealName" class="registerLeft" name="userRealName" type="text" value="${userBean.userRealName }" placeholder="请在这里输入真实姓名" /><label>${userRealName}</label>
    	          <input id="userAddress" class="registerRight" name="userAddress" type="text" value="${userBean.userAddress }" placeholder="请在这里输入家庭地址" /><label>${userAddress}</label>
              </p>
              <p>
	              <input id="userPhone"  class="registerLeft" class="registerLeft"name="userPhone" value="${userBean.userPhone }" type="text" placeholder="请在这里输入电话号码" /><label>${userPhone}</label>
    	          <input id="userIdCard" class="registerRight" name="userIdCard" type="text"  value="${userBean.userIdCard }" placeholder="请在这里输入身份证号码" /><label>${userIdCard}</label>
              </p>
              <p>
              	<input id="userProfession"class="registerLeft" name="userProfession" type="text"  value="${userBean.userProfession }" placeholder="请对您的职业进行描述" /><label>${userProfession}</label>
              	<input id="userEmail" class="registerRight" name="userEmail" type="text" value="${userBean.userEmail }"  placeholder="请在这里输入你的邮箱" /><label>${userEmail}</label>
              </p> 
              <div style="margin-left: 200px;" id="drag">
              </div><br>
              <input style="margin-left: 180px;" id="registerBtn" value="注册"  type="button">
              <a href="jumpHome"><input style="margin-left: 50px;" id="returnBtn" value="返回首页"  type="button"></a>
          </form>
      </div>
      <div class="copyright">CBD有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
<script type="text/javascript">
$('#drag').drag();
</script>
</body>
</html>