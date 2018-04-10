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
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>CBD停车管理平台系统</title>
<link rel="stylesheet" type="text/css" href="/CBD/css/reset.css"/>
<script type="text/javascript" src="/CBD/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/CBD/js/js_z.js"></script>
<link rel="stylesheet" type="text/css" href="/CBD/css/thems.css">

<script src="/CBD/js/laydate.js"></script>
<link  rel="stylesheet" href="/CBD/css/laydate.css">
<script src="/CBD/js/jquery.validate.min.js"></script>
<script src="/CBD/js/messages_zh.js"></script>
<!-- 企业车位查询js -->
<script src="/CBD/js/liuxinyu/addRentContract.js"></script>
<script src="/CBD/js/liuxinyu/rentContractExtension.js"></script>
 <script src="/CBD/js/liuxinyu/addNewRentContract.js"></script> 
</head>
<body>
<%@include file="/jsp/managerJsp/adminHeader.jsp" %>
	<!--幻灯片-->	
    <div class="scd clearfix">
      <%@include file="/jsp/managerJsp/adminLeftList.jsp" %>
      
     <div class="scd_r">
        <div class="r_name"><span>新增租户合约</span></div> 
        <div class="r_ctn clearfix">  
                <form action="addNewAgreement" method="post" id="addAgreement">
              <ul class="rent clearfix">
                	 <li class="clearfix">
                         <span class="title">企业名称：</span>
                    	 <select id="campanyName" name="renterAgreementCompanyId" >
                    	 <option value="" disabled="disabled">企业信息</option>
                    	 </select>                  	 
                    </li> 
               
                    <li class="clearfix">
                    	<span class="title">合同编号：</span>
                        <div class="li_r">
                        	<input name="renterAgreementNewNo" type="text" >
                        </div>
                    </li>
                    
                    <li class="clearfix">
                    	<span class="title">合同生效日期：</span>
                        <div class="li_r">
                        	<input name="renterAgreementStartTime" type="text" id="starTime" >                  
                        </div>
                    </li>
                    <li class="clearfix">
                    	<span class="title">合同截止日期：</span>
                        <div class="li_r">
                        	<input name="renterAgreementEndTime" type="text" id="endTime" > 
                        </div>
                    </li>
                    <li class="clearfix">
                    	<span class="title">成交价格：</span>
                        <div class="li_r">
                        	<input name="renterAgreementPrice" type="text" >                        
                        </div>
                    </li>
                    <li class="clearfix">                    	
                        <div class="li_r">
                        	<input name="renterAgreementStatus" type="hidden" value="1">                        
                        </div>
                    </li>
                     <li class="clearfix">
                         <span class="title">添加车位：</span>
                    	 <select id="vacantCaport" name="datas" multiple="multiple" >
                    	 <option value="" disabled="disabled">请选择车位</option>
                    	 </select><span>${carportMessage }</span>                  	 
                    </li>         
                    <li class="clearfix">
                    	<span class="title">&nbsp;</span>
                        <div class="li_r btn">
                        	<input name="" type="submit" value="添加">
                            <input name="" type="reset" value="取消" onclick="javascript:history.back(-1);">
                        </div>
                    </li>
                </ul>
                </form>
            </div>
        </div>
 
  </div>
	
	<!-- 引入bottom.jsp -->
	<%@ include file="/jsp/bottom.jsp" %>	
</body>
</html>