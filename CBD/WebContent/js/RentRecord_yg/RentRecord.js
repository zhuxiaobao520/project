/**
 * 租赁，出租记录相关的js,
 * 姚刚
 */
var currentPage = 1;
var totalPage = 1;
var rentInId = 0;
$(function() {// 绑定加载事件
	getRentRecordPager();
	$("#firstPage").click(function() {
		currentPage = 1;
		getRentRecordPager();
	});
	// 为上一页添加监听事件
	$("#prePage").click(function() {
		if (currentPage > 1) {
			currentPage--;
			getRentRecordPager();
		} else {
			alert("已经是第一页了");
		}
	});
	// 为下一页添加监听事件
	$("#nextPage").click(function() {
		if (currentPage < totalPage) {
			currentPage++;
			getRentRecordPager();
		} else {
			alert("已经是最后一页了");
		}
	});
	// 尾页点击事件处理
	$("#lastPage").click(function() {
		currentPage = totalPage;
		getRentRecordPager();
	});
	// 查询按钮添加事件selectButton
	$("#selectButton").change(function() {
		currentPage = 1;
		getRentRecordPager();
	});
	//跳转按钮添加监听事件
	$("#turnToPage").click(function() {
		var regex=/^[0-9]{1,}$/;
		if(regex.test($("#currentPage").val())){
			currentPage = $("#currentPage").val();
			getRentRecordPager();
		}else{
			alert("请输入正确的页数");
		}
	});
	// 给每条记录添加点击事件
	$("#tbody").on("click", ".contentTr", function() {
		rentInId = $(this).attr("rentInId");
		$(".contentTr").removeClass("selectedTr");
		$(this).addClass("selectedTr");
	});
	//投诉按钮的点击事件
	$("#complainBtn").click(function() {
		if(rentInId!=0){
			if($("#selectButton").val() == "招租记录"){
				//当有选中行时进行页面跳转
				var url="/CBD/rentOutController_yg/turnToComplainRentOutPage";
				var params={"rentInId":rentInId};
				postcall( url, params);
			}else if($("#selectButton").val() == "租赁记录"){
				//当有选中行时进行页面跳转
				var url="/CBD/rentInController_yg/turnToComplainRentInPage";
				var params={"rentInId":rentInId};
				postcall( url, params);
			}
		}else{
			alert("你他丫的都没选交易记录，就想投诉？");
		}
	});
});
function getRentRecordPager() {
	$.getJSON("rentRecord_yg/getRentRencord", {
		"currentPage" : currentPage,
		"recordType" : $("#selectButton").val()
	}, getRentRecordList);

}

// ajax的回调函数
function getRentRecordList(pager) {
	// 填充表格数据
	// 修改表头数据
	$("#thead").html("");
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	if ($("#selectButton").val() == "租赁记录") {
		var $thead = $("<tr><th>租赁车位信息</th><th>租赁开始时间</th>"
				+ "<th>租赁结束事件</th><th>招租人用户名</th><th>租赁价格</th></tr>")
		$("#thead").append($thead);
		$("#tbody").html("");
		$.each(pager.datas, function(i, rentRecord) {
			var $rentRecord = $("<tr class='contentTr' rentInId='"
					+ rentRecord.rentInId + "'>" + "<td >"
					+ rentRecord.userCarportAddress
					+ rentRecord.userCarportAddressNo + "</td>" + "<td>"
					+ rentRecord.rentOutStartDate + "</td>" + "<td>"
					+ rentRecord.rentOutEndDate + "</td>" + "<td>"
					+ rentRecord.rentOutUserName + "</td><th>"
					+ rentRecord.rentOutPrice + "</th></tr>")
			$("#tbody").append($rentRecord);
		});
	} else if ($("#selectButton").val() == "招租记录") {
		var $thead = "<tr><th>招租车位信息</th><th>租赁开始时间</th>"
				+ "<th>租赁结束事件</th><th>租赁人用户名</th><th>出租价格</th></tr>";
		$("#tbody").html("");
		$.each(pager.datas, function(i, rentRecord) {
			var $rentRecord = $("<tr class='contentTr' rentInUserId='"+rentRecord.rentInUserId+"'  rentInId='"
					+ rentRecord.rentInId + "'>" + "<td >"
					+ rentRecord.userCarportAddress
					+ rentRecord.userCarportAddressNo + "</td><td>"
					+ rentRecord.rentOutStartDate + "</td><td>"
					+ rentRecord.rentOutEndDate + "</td><td>"
					+ rentRecord.rentInUserName + "</td><th>"
					+ rentRecord.rentOutPrice + "</th></tr>")
			$("#tbody").append($rentRecord);
		});
		$("#thead").html($thead);

	}
	$("#currentPage").val(pager.currentPage);
	$("#totalPageNum").html(pager.totalPageNum);
}
function postcall( url, params, target){  
    var tempform = document.createElement("form");  
    tempform.action = url;  
    tempform.method = "post";  
    tempform.style.display="none"  
    if(target) {  
        tempform.target = target;  
    }  
  
    for (var x in params) {  
        var opt = document.createElement("input");  
        opt.name = x;  
        opt.value = params[x];  
        tempform.appendChild(opt);  
    }  
    var opt = document.createElement("input");  
    opt.type = "submit";  
    tempform.appendChild(opt);  
    document.body.appendChild(tempform);  
    tempform.submit();  
    document.body.removeChild(tempform);  
}  
