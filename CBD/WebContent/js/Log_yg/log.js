/*
 * 日志相关的js
 * 
 */
var currentPage = 1;
var totalPage = 1;
$(function() {// 绑定加载事件
	laydate.render({ 
  		elem: '#startDate'
	});
	laydate.render({ 
  		elem: '#endDate'
	});
	
	getLogPager();
	// 为首页添加监听事件
	$("#firstPage").click(function() {
		currentPage = 1;
		getLogPager();
	});
	// 为上一页添加监听事件
	$("#prePage").click(function() {
		if (currentPage > 1) {
			currentPage--;
			getLogPager();
		} else {
			alert("已经是第一页了");
		}
	});
	// 为下一页添加监听事件
	$("#nextPage").click(function() {
		if (currentPage < totalPage) {
			currentPage++;
			getLogPager();
		} else {
			alert("已经是最后一页了");
		}
	});
	// 尾页点击事件处理
	$("#lastPage").click(function() {
		currentPage = totalPage;
		getLogPager();
	});
	//跳转按钮添加监听事件
	$("#turnToPage").click(function() {
		var regex=/^[0-9]{1,}$/;
		if(regex.test($("#currentPage").val())){
			currentPage = $("#currentPage").val();
			getLogPager();
		}else{
			alert("请输入正确的页数");
		}
	});
	//日志类型切换事件logType
	$("#logType").change(function() {
		currentPage = 1;
		getLogPager();
	});
	//操作类型切换事件logType
	$("#logOperationType").change(function() {
		currentPage = 1;
		getLogPager();
	});
	//查询按钮添加事件selectButton
	$("#selectButton").click(function() {
		currentPage = 1;
		getLogPager();
	});
	
});
function getLogPager() {
	$.getJSON("Log_yg/getLogPager", {
		"currentPage" : currentPage,
		"logType" : $("#logType").val(),
		"logOperationType" : $("#logOperationType").val(),
		"startDate" : $("#startDate").val(),
		"endDate" : $("#endDate").val()
	}, getLogList);
}


// ajax的回调函数
function getLogList(pager) {
	// 填充表格数据
	// 清空表格数据
	$("#logList").html("");
	// 获取总页数
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	$.each(pager.datas, function(i, log) {
		var $logInfo = $("<tr value='" + log.logId + "'>" + "<td >"
				+ log.logAccount + "</td>" + "<td>" + log.logTime + "</td>"
				+ "<td>" + log.logIp + "</td>" + "<td>" + log.logOperationType
				+ "</td>" + "<td>" + log.logType + "</td>" + "<td>"
				+ log.logOperationContent + "</td></tr>")
		$("#logList").append($logInfo);
	});
	$("#currentPage").val(pager.currentPage);
	$("#totalPageNum").html(pager.totalPageNum);
}
