
var totalPage;
var curPage=1;
var inputPage=1;
$(function(){//绑定加载时间
	
	//初始化页面数据（显示第一页）
	getBuyRecordPager() ;

	//首页点击事件处理
	$("#fisrtPage").click(function(){
		curPage=1;
		getBuyRecordPager();
	})
	
	//上一页点击事件处理
	$("#prePage").click(function(){
		if(curPage>1){
			curPage=curPage-1;
			getBuyRecordPager();
		}
	
	})
	//下一页点击事件处理
	$("#nextPage").click(function(){
		if(curPage<totalPage){
			curPage=curPage+1;
			getBuyRecordPager();
		}
		console.log(curPage);	
		
	})
	//尾页点击事件处理
	$("#lastPage").click(function(){
		curPage=totalPage;
		getBuyRecordPager();
	})
	//跳页点击事件
	$("#jump").click(function(){
		inputPage=parseInt($("#inputPage").val());
		if(inputPage>0 && inputPage<totalPage+1){
			curPage=inputPage;
			getBuyRecordPager();
		}
		
	})

	//下拉框改变事件
	$("#selectButton").change(function(){
		curPage=1;
		getBuyRecordPager();
	})
					
});


function getBuyRecordPager() {
	$.getJSON("getCompanyCarport", {
		"curPage" : curPage,
		"companyCarport" : $("#selectButton").val()
	}, getCompanyCarportList);

}

//ajax的回调函数
function getCompanyCarportList(pager) {
	// 填充表格数据
	// 修改表头数据
	$("#thead").html("");
	totalPage = pager.totalPageNum;
	if ($("#selectButton").val() == "查看已租车位") {
		var $thead = $("<tr><th>车位位置</th><th>车位号</th>"
				+ "<th>合同编号</th><th>合同开始时间</th><th>合同结束时间</th></tr>")
		$("#thead").append($thead);
		$("#tbody").html("");
		$.each(pager.datas, function(i, rent) {
			var $buyRecord = $("<tr> <td>"
					+ rent.cbdCarportAddress + "</td ><td>"
					+ rent.cbdCarportAddressNo + "</td>" + "<td>"
					+ rent.renterAgreementNewNo + "</td>" + "<td>"
					+ rent.renterAgreementStartTime + "</td>" + "<td>"
					+ rent.renterAgreementEndTime + "</td></tr>")
			$("#tbody").append($buyRecord);
		});
	} else if ($("#selectButton").val() == "查看平台待租车位") {
		
		var $thead = "<tr><th>车位位置</th><th>车位编号</th>"
				+ "<th>最长可租日期</th></tr>";
		$("#thead").append($thead);
		$("#tbody").html("");
		
		$.each(pager.datas, function(i, buyRecord) {
				
			var $buyRecord = $("<tr> <td>"
					+ buyRecord.cbdCarportAddress +  "</td ><td>"
					+ buyRecord.cbdCarportAddressNo + "</td><td>"
					+ buyRecord.thirdAggrementEndTime + "</td>"
					+"</tr>")
			$("#tbody").append($buyRecord);
		});
		$("#thead").html($thead);
		
	}

	//填充总页数
	$("#totalPage").html(totalPage)
	//填充当前页
	$("#inputPage").val(curPage)
}