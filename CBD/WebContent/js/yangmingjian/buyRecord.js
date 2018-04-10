/**
 * 购买，除出售记录相关的js,
 * 杨明建
 */
	var buyRecordId=0;
	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		//初始化页面数据（显示第一页）
		$.getJSON("buyAndSaleRecordList", {
			"curPage" : curPage,
			"buyRecordType" : "出售记录"
		}, getBuyRecordList);
	/*	getBuyRecordPager();*/

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
		//点击表格获取id
		$("#tbody").on("click",".contentTr",function(){
			$(this).css("background-color","rgba(0,0,240,0.4)");
			$(this).siblings(".contentTr").css("background-color","white");
			buyRecordId=$(this).attr("value");
			
		});

		//投诉按钮的点击事件
		$("#complainBtn").click(function() {
			if(buyRecordId!=0){
				
				//当有选中行时进行页面跳转,根据下拉框的值确定是购买方还是出售方，购买信息id buyRecordId
				location.href="goToSaleComplainPage?buyInfoId="+buyRecordId+"&complainType="+$("#selectButton").val();
			}else{
				alert("请选择你要投诉的记录！" );
			}
			
		});
		
		//下拉框改变事件
		$("#selectButton").change(function(){
			curPage=1;
			getBuyRecordPager();
		})
		
	});
function getBuyRecordPager() {
	$.getJSON("buyAndSaleRecordList", {
		"curPage" : curPage,
		"buyRecordType" : $("#selectButton").val()
	}, getBuyRecordList);

}

// ajax的回调函数
function getBuyRecordList(pager) {
	// 填充表格数据
	// 修改表头数据
	$("#thead").html("");
	totalPage = pager.totalPageNum;
	if ($("#selectButton").val() == "出售记录") {
		var $thead = $("<tr><th>出售车位信息</th><th>出售用户名</th>"
				+ "<th>出售价格</th><th>购买用户名</th><th>交易时间</th></tr>")
		$("#thead").append($thead);
		$("#tbody").html("");
		$.each(pager.datas, function(i, buyRecord) {
			var $buyRecord = $("<tr class='contentTr' value='"
					+ buyRecord.buyInfoId + "'>" + "<td >"
					+ buyRecord.userCarportAddress
					+ buyRecord.userCarportAddressNo + "</td>" + "<td>"
					+ buyRecord.sellUser.userName + "</td>" + "<td>"
					+ buyRecord.dealPrice + "</td>" + "<td>"
					+ buyRecord.buyInfoUser.userName + "</td><th>"
					+ buyRecord.dealTime + "</th></tr>")
			$("#tbody").append($buyRecord);
		});
	} else if ($("#selectButton").val() == "购买记录") {
		
		var $thead = "<tr><th>购买车位信息</th><th>购买用户名</th>"
				+ "<th>购买价格</th><th>出售用户名</th><th>交易时间</th></tr>";
		$("#thead").append($thead);
		$("#tbody").html("");
		
		$.each(pager.datas, function(i, buyRecord) {
				
			var $buyRecord = $("<tr class='contentTr' value='"
					+ buyRecord.buyInfoId + "'>" + "<td >"
					+ buyRecord.userCarportAddress
					+ buyRecord.userCarportAddressNo + "</td><td>"
					+ buyRecord.buyInfoUser.userName + "</td><td>"
					+ buyRecord.dealPrice + "</td><td>"
					+ buyRecord.sellUser.userName + "</td><th>"
					+ buyRecord.dealTime + "</th></tr>")
			$("#tbody").append($buyRecord);
		});
		$("#thead").html($thead);
		
	}

	//填充总页数
	$("#totalPage").html(totalPage)
	if(totalPage<=0){
		totalPage=1;
		$("#totalPage").html(totalPage);
	}
	//填充当前页
	$("#inputPage").val(curPage)
}
