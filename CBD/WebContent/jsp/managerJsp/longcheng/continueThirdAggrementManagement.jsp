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
<link rel="stylesheet" href="/CBD/css/longcheng/continueThirdAggrementManagement.css">
<script src="/CBD/js/longcheng/continueThirdAggrementManagement.js"></script>

<!-- 导入日期的格式 -->
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
		<div id="continueThirdAggrementInfo">
			<h1>合同续约</h1>
			<form action="submitContinueThirdAggrement" id="continueThirdAggrementForm" class="form-inline" method="post" enctype="multipart/form-data">
				<div id="formleft">
					<input type="hidden" value="${nowThirdAgreement.thirdAggrementId }" name="thirdAggrementId">
					<div class="form-group">
				    	<label>原合同编号：${nowThirdAgreement.thirdAggrementNewNo }</label>
				  	</div><br>
					<div class="form-group">
			   			<label>新续合同编号：</label>
			    		<input type="text" class="form-control" name="thirdAggrementNewNo"  placeholder="">
			  		</div><br>
			  		<div class="form-group">
				    	<label>合同单位：${nowThirdAgreement.thirdAggrementCompany}</label>
				  	</div><br>
					<div class="form-group">
				    	<label>对方联系人：${nowThirdAgreement.thirdAggrementLinkMan}</label>
			  		</div><br>
			  		<div class="form-group">
			    		<label>对方联系电话：${nowThirdAgreement.thirdAggrementLinkManPhone}</label>
			  		</div>
				</div>
				<div id="formright">
					<div class="form-group">
			    		<label>合同生效日期：</label>
			    		<input id="thirdAggrementStartTime" type="text" class="form-control" name="thirdAggrementStartTime"  placeholder="">
			 		</div><br>
			  		<div class="form-group">
			    		<label>合同截止日期：</label>
			    		<input id="thirdAggrementEndTime" type="text" class="form-control" name="thirdAggrementEndTime"  placeholder="">
			  		</div><br>	${timeError}
			  		<div class="form-group">
			    		<label>成交价格：${nowThirdAgreement.thirdAggrementPrice}</label>
			  		</div><br>
			  		<div class="form-group">
			    		<label for="exampleInputFile">上传新合同复印件:</label>
			    		<input type="file" id="exampleInputFile" name="thirdAggrementImageUrl">
			    		${message }
			  		</div>
				</div>
			  <div id="btnDiv">
				  <button type="submit" class="btn btn-info button">续约</button>
				  <a href="thirdAggrementManagement"><button type="button" class="btn btn-info button">取消</button></a>
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