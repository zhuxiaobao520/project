<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/longcheng/userLeftList.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/longcheng/userLeftList.css">
<!--幻灯片-->
<div class="scd_l">
	<div class="name">
		个人用户
	</div>
	<ul class="s_nav clearfix">
		<li><a href="showUserHome">个人首页</a></li>
		<li><a href="showUserInfo">个人资料</a></li>
		<li><a href="userInfo">修改资料</a></li>
		<li><a href="userChangePwd">修改密码</a></li>
		<!-- <li><a href="userChangePwd">查看投诉</a></li> -->
		<li><a href="/CBD/rentRecord_yg/turnToRentRecord">出租/租赁记录</a></li>
		<li><a href="dealRentTask">待办租赁任务</a></li>
		<li><a href="userBuyRecord">买卖记录</a></li>
		<li><a href="dealSellTask">待办买卖任务</a></li>
		<li><a href="userMessage">消息提醒</a><span id="messageNum"></span></li>
	</ul>
</div>
