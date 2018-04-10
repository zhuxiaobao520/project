var totalPage=1;
var curPage = 1;
var totalPage3=1;
var curPage3 = 1;
$(function(){//绑定load加载事件
	
	//初始化待租页面数据（显示第一页）
	$.getJSON("getAllDaiShenUser",{"curPage":1},getStudentInfo);
	//初始化待处理页面数据（显示第一页）
	$.getJSON("getAllDaiChuLiUser",{"curPage":1},getStudentInfo3); 
	
	//下拉框点击事件
	$("#selectSta").change(function(){
		var selectSta = $("#selectSta").val();
		if (selectSta == "div1") {
			$("#div1").css("display","block");
			$("#div2").css("display","none");
		}else if (selectSta == "div2") {
			$("#div2").css("display","block");
			$("#div1").css("display","none");
		}
	});
	
	//待审
	//首页点击事件处理
	$("#pageFirstNo").click(function(){
		$.getJSON("getAllDaiShenUser",{curPage:1},getStudentInfo);
		curPage=1;
	});
	//上一页点击事件处理
	$("#pagePreNo").click(function(){
		if (curPage>1) {
			curPage--;
			$.getJSON("getAllDaiShenUser",{curPage:curPage},getStudentInfo);
		}
	});
	//下一页点击事件处理
	$("#pageNextNo").click(function(){
		if (curPage<totalPage) {
			curPage++;
			$.getJSON("getAllDaiShenUser",{curPage:curPage},getStudentInfo);
		}
	});
	//尾页点击事件处理
	$("#pageLastNo").click(function(){
		curPage = totalPage;
		$.getJSON("getAllDaiShenUser",{curPage:totalPage},getStudentInfo);
	});
	
	//跳转点击事件处理
	$("#pageTiaoNo").click(function(){
		var pageTotal = $("#pageTotal").val();
		if(pageTotal <= totalPage && pageTotal > 0){
			curPage=pageTotal;
			$.getJSON("getAllDaiShenUser",{curPage:pageTotal},getStudentInfo);
		}else{
			$("#pageTotal").val(curPage);
			alert("你输入的页数不存在");
		}
	});
	
	//待处理
		//首页点击事件处理
	$("#pageFirstNo3").click(function(){
		$.getJSON("getAllDaiChuLiUser",{curPage:1},getStudentInfo3);
		curPage3=1;
	});
	//上一页点击事件处理
	$("#pagePreNo3").click(function(){
		if (curPage3>1) {
			curPage3--;
			$.getJSON("getAllDaiChuLiUser",{curPage:curPage3},getStudentInfo3);
		}
	});
	//下一页点击事件处理
	$("#pageNextNo3").click(function(){
		if (curPage3<totalPage3) {
			curPage3++;
			$.getJSON("getAllDaiChuLiUser",{curPage:curPage3},getStudentInfo3);
		}
	});
	//尾页点击事件处理
	$("#pageLastNo3").click(function(){
		curPage3 = totalPage3;
		$.getJSON("getAllDaiChuLiUser",{curPage:totalPage3},getStudentInfo3);
	});
	
	//跳转点击事件处理
	$("#pageTiaoNo3").click(function(){
		var pageTotal3 = $("#pageTotal3").val();
		if(pageTotal3 <= totalPage3 && pageTotal3 > 0){
			curPage3=pageTotal3;
			$.getJSON("getAllDaiChuLiUser",{curPage:pageTotal3},getStudentInfo3);
		}else{
			$("#pageTotal3").val(curPage3);
			alert("你输入的页数不存在");
		}
	});
	
	//定义AJAX分页数据回调函数
});
function getStudentInfo(pager){
	//清空表格数据
	$("#tbody").html("");
	//填充表格数据
	var list = pager.datas;
	totalPage = pager.totalPageNum;
	$.each(list,function(index,userCarport){
		var $studentInfo = $("<tr>"+
				"<td>"+userCarport.user.userRealName+ "</td>"+
				"<td>"+userCarport.userCarportAddress+ "</td>"+
				"<td><a href='daishencheweixiangqing?id="+userCarport.userCarportId+"'><input class='th_but' type='button' value='查看详情'></a></td>"+
				"</tr>"
							);
		$("#tbody").append($studentInfo);
	});
/* 	alert(stu); */
	$("#pageTotal").val(curPage);
	$("#sp1").html("/" + totalPage);
}

 function getStudentInfo3(pager){
	//清空表格数据
	$("#tbody3").html("");
	//填充表格数据
	var list = pager.datas;
	totalPage3 = pager.totalPageNum;
	$.each(list,function(index,BuyDetailBean){
		var $studentInfo = $("<tr>"+
				"<td>"+BuyDetailBean.saleUserName+ "</td>"+
				"<td>"+BuyDetailBean.buyUserName+ "</td>"+
				"<td>"+BuyDetailBean.userCarportAddress+ "</td>"+
				"<td><a href='daichulicheweixiangqing?id="+BuyDetailBean.buyInfoId+"'><input class='th_but' type='button' value='通知双方签约'></a></td>"+
				"</tr>"
							);
		$("#tbody3").append($studentInfo);
	});
	$("#pageTotal3").val(curPage3);
	$("#sp3").html("/" + totalPage3);
} 