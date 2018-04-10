var totalPage=1;
var curPage = 1;
$(function(){//绑定load加载事件
	//初始化待租页面数据（显示第一页）
	$.getJSON("getAllCompany",{curPage:1,companyName:"",companyAddress:"",companyLinkMan:"",companyPhone:""},getStudentInfo);
	
	//待租
	//首页点击事件处理
	$("#pageFirstNo").click(function(){
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		$.getJSON("getAllCompany",{curPage:1,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
		curPage=1;
	});
	//上一页点击事件处理
	$("#pagePreNo").click(function(){
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		if (curPage>1) {
			curPage--;
			$.getJSON("getAllCompany",{curPage:curPage,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
		}
	});
	//下一页点击事件处理
	$("#pageNextNo").click(function(){
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		if (curPage<totalPage) {
			curPage++;
			$.getJSON("getAllCompany",{curPage:curPage,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
		}
	});
	//尾页点击事件处理
	$("#pageLastNo").click(function(){
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		curPage = totalPage;
		$.getJSON("getAllCompany",{curPage:totalPage,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
	});
	
	//模糊查询点击事件处理
	$("#qiyemohuchaxuntxx").click(function(){
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		$.getJSON("getAllCompany",{curPage:1,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
		curPage = 1;
	});
	
	//跳转点击事件处理
	$("#pageTiaoNo").click(function(){
		var pageTotal = $("#pageTotal").val();
		var companyName = $("#companyName").val();
		var companyAddress = $("#companyAddress").val();
		var companyLinkMan = $("#companyLinkMan").val();
		var companyPhone = $("#companyPhone").val();
		if(pageTotal <= totalPage && pageTotal > 0){
			curPage=pageTotal;
			$.getJSON("getAllCompany",{curPage:pageTotal,companyName:companyName,companyAddress:companyAddress,companyLinkMan:companyLinkMan,companyPhone:companyPhone},getStudentInfo);
		}else{
			$("#pageTotal").val(curPage);
			alert("你输入的页数不存在");
		}
	});
});
//定义AJAX分页数据回调函数
function getStudentInfo(pager){
	//清空表格数据
	$("#tbody").html("");
	//填充表格数据
	var list = pager.datas;
	totalPage = pager.totalPageNum;
	$.each(list,function(index,company){
		var $studentInfo = $("<tr>"+
				"<td>"+company.companyAccount+ "</td>"+
				"<td>"+company.companyName+ "</td>"+
				"<td>"+company.companyAddress+ "</td>"+
				"<td>"+company.companyLinkMan+ "</td>"+
				"<td>"+company.companyPhone+ "</td>"+
				"<td><a href='companyxiangqing?id="+company.companyId+"'><input class='th_but' type='button' value='查看'></a> "+
				"&nbsp;<a href='removebyidcompany?id="+company.companyId+"'><input class='th_but' type='button' value='删除'></a></td>"+
				"</tr>"
							);
		$("#tbody").append($studentInfo);
	});
/* 	alert(stu); */
	$("#pageTotal").val(curPage);
	$("#sp1").html("/" + totalPage);
}