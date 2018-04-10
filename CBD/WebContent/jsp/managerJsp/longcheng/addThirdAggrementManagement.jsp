<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>CBD停车管理平台系统</title>

<base href="<%=basePath%>">
<title>添加外部合约</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/CBD/bootstrap/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/CBD/js/jquery.js"></script>
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/CBD/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CBD/css/homePage.css">
<link rel="stylesheet" href="/CBD/css/longcheng/addThirdAggrementManagement.css">
<script src="/CBD/js/longcheng/addThirdAggrementManagement.js"></script>
<link  rel="stylesheet" href="/CBD/css/laydate.css">
<script src="/CBD/js/laydate.js"></script>

</head>
<body>
	<!--头部-->
	<jsp:include page="/jsp/managerJsp/adminHeader.jsp" />
	<!--幻灯片-->
	<div class="space_hx">&nbsp;</div>
	<div class="scd clearfix" style="width: 1100px;">
		<jsp:include page="/jsp/managerJsp/adminLeftList.jsp" />
		<div class="scd_r" style="width: 850px;">
		<div class="r_name">
			<span>外部合约管理</span>
		</div>
		<div class="r_ctn clearfix">
		<div id="addthirdAggrementInfo">
			<h1>添加外部合约</h1>
			<form action="submitAddThirdAggrement" id="addThirdAggrementForm" class="form-inline" method="post" enctype="multipart/form-data">
				<div id="formleft">
					<div class="form-group">
			    		<label>合&nbsp;同&nbsp;编&nbsp;号：</label>
			    		<input type="text" class="form-control" name="thirdAggrementNewNo"  placeholder="">
			  		</div>
			  		<div class="form-group">
			    		<label>合&nbsp;同&nbsp;单&nbsp;位：</label>
			    		<input type="text" class="form-control" name="thirdAggrementCompany"  placeholder="">
			  		</div>
			  		<div class="form-group">
			    		<label>对方联系人&nbsp;：</label>
			    		<input type="text" class="form-control" name="thirdAggrementLinkMan"  placeholder="">
			  		</div>
			  		<div class="form-group">
					    <label>对&nbsp;方&nbsp;电&nbsp;话：</label>
					    <input type="text" class="form-control" name="thirdAggrementLinkManPhone"  placeholder="">
					</div>
			  		<div class="form-group">
					    <label>车位所属单位地址：</label>
					    <input type="text" class="form-control" name="thirdAggrementCompanyAddress"  placeholder="">
			  		</div>	
			  		<div class="form-group">
					    <label for="exampleInputFile">上传合同复印件:</label>
					    <input type="file" id="exampleInputFile" name="thirdAggrementImageUrl">
			  		</div>
				</div>
				<div id="formright">
					<div class="form-group">
					    <label >合同生效日期：</label>
					    <input id="thirdAggrementStartTime" type="text" class="form-control" name="thirdAggrementStartTime"  placeholder="">
			  		</div>
			  		<div class="form-group">
					    <label >合同截止日期：</label>
					    <input id="thirdAggrementEndTime" type="text" class="form-control" name="thirdAggrementEndTime"  placeholder="">
			  		</div><br>
			  		${timeError}
			  		<div class="form-group">
					    <label>成&nbsp;交&nbsp;价&nbsp;格：</label>
					    <input type="text" class="form-control" name="thirdAggrementPrice"  placeholder="">
			  		</div>		  
					<div class="form-group">
					    <label>车&nbsp;位&nbsp;地&nbsp;址：</label>
					    <input type="text" class="form-control" name="cbdCarportAddress"  placeholder="">
					</div>
					<div class="form-group">
					    <label>车位区域编号：</label>
					    <input type="text" class="form-control" name="cbdCarportAreaAddress"  placeholder="">
					</div>
			  		<div class="form-group">
			    		<label>车位起始编号：</label>
			    		<input type="text" class="form-control" name="cbdCarportAddressNoBegin"  placeholder="">
			  		</div>
			  		<div class="form-group">
			    		<label>车&nbsp;位&nbsp;总&nbsp;数：</label>
			    		<input type="text" class="form-control" name="cbdCarportTotalNum"  placeholder="">
			  		</div>
				</div>
			   <div id="btnDiv">
				  <button id="addThirdAggrementManagementBtn" type="submit" class="btn btn-info button">添加</button>
				  <a href="thirdAggrementManagement"><button id="back" type="button" class="btn btn-info button">返回</button></a>  
			   </div>
			</form>
			</div>
		</div>
		</div>
	</div>
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>