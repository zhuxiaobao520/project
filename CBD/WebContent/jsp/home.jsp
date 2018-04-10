<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<%
	//获取跟路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CBD停车管理平台系统</title>
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="css/reset.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/js_z.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<link rel="stylesheet" type="text/css" href="css/thems.css" >
<script language="javascript">
$(function(){
	$('#owl-demo').owlCarousel({
		items: 1,
		navigation: true,
		navigationText: ["上一个","下一个"],
		autoPlay: true,
		stopOnHover: true
	}).hover(function(){
		$('.owl-buttons').show();
	}, function(){
		$('.owl-buttons').hide();
	});
});
</script>
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
                <li><a href="jumpLogin">登录</a></li>
                <li><a href="jumpRegister">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<!--头部-->
<!--幻灯片-->
<div id="banner" class="banner"> 
    <div id="owl-demo" class="owl-carousel"> 
        <a class="item" target="_blank" href="" style="background-image:url(/CBD/Assets/upload/banner1.jpg)">
            <img src="/CBD/Assets/upload/banner1.jpg" alt="">
        </a>
        <a class="item" target="_blank" href="" style="background-image:url(/CBD/Assets/upload/banner1.jpg)">
            <img src="/CBD/Assets/upload/banner2.jpg" alt="">
        </a>
        <a class="item" target="_blank" href="" style="background-image:url(/CBD/Assets/upload/banner1.jpg)">
            <img src="/CBD/Assets/upload/banner3.jpg" alt="">
        </a>
    </div>
</div>
<!--幻灯片-->
<div class="hui_bg">
	<div class="i_m">
    	<div class="i_name">
        	<a href="">
            	<img src="/CBD/Assets/images/icon1.png" alt=""/>
                <span>关于我们</span>
            </a>
            <p>织的一个又一个美丽故事渐渐成真而带来的欣喜</p>
        </div>
        <dl class="i_ma clearfix">
        	<dt><a href=""><img src="/CBD/Assets/upload/pic1.jpg" alt=""/></a></dt>
            <dd>
            	<p>CBD房地产各大开发商每年在房地产的开发和完善方面投入数十亿来满足新的市场商务需求，而这些投入也为企业创造了很壮观的经济效益。而且在这些方面的投入还会继续加大，在以后的发展中，这已经成为一个不可否认的趋势。可以说，互联网新技术推动了人类文明的巨大进步，而且发展将会更加迅速。</p>
                <p>CBD停车管理平台系统是为CBD房地产开发商用于维护和管理CBD停车业务而设计，其目的是为了通过互联网技术缩减此项业务的运营和管理成本，提升企业经济效益。另一方面，也为业务用户提供快捷、方便的操作平台。</p>
            </dd>
        </dl>
    </div>
</div>
<div class="space_hx">&nbsp;</div>
<div class="i_m">
    <div class="i_name">
        <a href="">
            <img src="/CBD/Assets/images/icon2.png" alt=""/>
            <span>个人最新车位信息</span>
        </a>
        <p>千姿百态.风格各异的楼盘是一组奇丽的诗篇,那么海洋之心便是其中</p>
    </div>
    <ul class="i_mb clearfix">
        <c:forEach items="${carportList }" var="temp">
        	<li class="clearfix">
        	<img src="/CBD/Assets/upload/pic2.jpg" alt=""/>
	            <div class="des">
	            	<i>&nbsp;</i>
	                <div class="name">${temp.userCarportAddress}</div>
	                <div class="dz">${temp.userCarportAddressNo }</div>
	                <div class="fx">
	                	<p>开始时间：${temp.rentOutStartTime }</p>
	                	<p>结束时间：${temp.rentOutEndTime }</p>
	                    <p>出租价格：${temp.rentOutPrice}</p>
	                </div>
	            </div>
       		</li>
        </c:forEach>
    </ul>
</div>
<div class="space_hx">&nbsp;</div>
<div class="i_m">
    <div class="i_name">
        <a href="">
            <img src="/CBD/Assets/images/icon4.png" alt=""/>
            <span>平台最新车位信息</span>
        </a>
        <p>有故事的房子,花心思的家</p>
    </div>
    <div class="i_md clearfix">
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
        <dl class="clearfix">
            <dt><a href=""><img src="/CBD/Assets/upload/pic3.jpg"></a><i>&nbsp;</i></dt>
            <dd>
                <div class="title"><a href="">润创兴时代</a></div>
                <div class="des">
                    提供给管理员对全网络目的地和派件代理商之间对应关系的新增、修改/删除......<a href="">{查看详情}</a>
                </div>
                <div class="fx">
                	<span>二房一厅</span>
                    <span>3500.00/月</span>
                </div>
            </dd>
        </dl>
    </div>
</div>
<div class="space_hx">&nbsp;</div>

<%@ include file="/jsp/bottom.jsp" %>

</body>
</html>