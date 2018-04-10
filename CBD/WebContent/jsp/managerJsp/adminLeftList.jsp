<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags"  prefix="shiro" %>
<!--幻灯片-->
<div class="scd_l">
	<div class="name">
		管理员<em>/ABOUT</em>
	</div>
	<ul class="s_nav clearfix">
		<li><a href="updatePersonalInformation">个人资料</a></li>
		<li><a href="updateAdminPersonalInfo">修改个人密码</a></li>
		<li><a href="Log_yg/turnToLogPage">查看日志</a></li>
		<shiro:hasPermission name="userAdmin">
    		<li><a href="jumpUserAdmin">个人用户管理</a></li>
			<li><a href="jumpCompanyAdmin">企业用户管理</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="carportAdmin">
			<li><a href="jumpCarAdmin">平台车位</a></li>
			<li><a href="cartportSingle">单个车位添加</a></li>
			<li><a href="carportBatch">批量车位添加</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="agreementAdmin">
			<li><a href="thirdAggrementManagement">外部合约管理</a></li>
			<li><a href="getIntoRent">租户合约管理</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="complaintAdmin">
			<li><a href="adminComplaint">投诉请求管理</a></li>
		</shiro:hasPermission>
		<li><a href="jumpPerformance">性能统计</a></li>
	</ul>
</div>