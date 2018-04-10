/*
 * 查看待租列表相关的js
 */
var currentPage = 1;
var totalPage = 1;
var rentOutId = 0;
var saleId=0;
var userCarportUserId=0;
var info="";
$(function() {// 绑定加载事件
	// ajax请求初始化页面数据（第一页）currentPage, 4, logOperationType, logType,
	showUserMyselfCarPort();
	// 为首页添加监听事件
	$("#firstPage").click(function() {
		currentPage = 1;
		showUserMyselfCarPort();
	});
	// 为上一页添加监听事件
	$("#prePage").click(function() {
		if (currentPage > 1) {
			currentPage--;
			showUserMyselfCarPort();
		} else {
			alert("已经是第一页了");
		}
	});
	// 为下一页添加监听事件
	$("#nextPage").click(function() {
		if (currentPage < totalPage) {
			currentPage++;
			showUserMyselfCarPort();
		} else {
			alert("已经是最后一页了");
		}
	});
	// 尾页点击事件处理
	$("#lastPage").click(function() {
		currentPage = totalPage;
		showUserMyselfCarPort();
	});
	//跳转按钮添加监听事件
	$("#turnToPage").click(function() {
		var regex=/^[0-9]{1,}$/;
		if(regex.test($("#currentPage").val())){
			currentPage = $("#currentPage").val();
			showUserMyselfCarPort();
		}else{
			alert("请输入正确的页数");
		}
	});
	//给下拉框添加切换时间//@RequestParam("saleId") int saleId,
	 //  @RequestParam("userCarportUserId")
	$("#selectType").change(function(){
		currentPage=1;
		showUserMyselfCarPort();
	});
	// 给每条出租记录添加点击事件
	$("#rentOutList").on("click", ".carportContent", function() {
		rentOutId = $(this).attr("value");
		$(".carportContent").removeClass("selectedTr");
		$(this).addClass("selectedTr");
	});
	// 给每条出售记录添加点击事件
	$("#rentOutList").on("click", ".saleCarportContent", function() {
		saleId = $(this).attr("value");
		userCarportUserId=$(this).attr("userCarportUserId");
		info=$(this).attr("info");		
		$(".saleCarportContent").removeClass("selectedTr");
		$(this).addClass("selectedTr");
	});
	//查看车位详情事件
	$("#getRentOutInfoBtn").click(function() {
		if($("#selectType").val()=="待售信息"){
			if(saleId!=0){
				//当有选中行时进行页面跳转 saleId=0;
				var url="/CBD/userCaportMinuteInfo";
				var params={"saleId":saleId,"userCarportUserId":userCarportUserId,"info":info};
				postcall( url, params);
			}else{
				alert("你他丫的都没选出售记录，就想查看车位详情？");
			}
		}else{
			if(rentOutId!=0){
				//当有选中行时进行页面跳转
				var url="/CBD/rentOutController_yg/turnToRentOutInfoPage";
				var params={"rentOutId":rentOutId};
				postcall( url, params);
			}else{
				alert("你他丫的都没选出租记录，就想查看车位详情？");
			}
		}
	});
});
function getRentOutPager() {
	var url="rentIn_yg/getRentOutPager";
	var data={"currentPage" : currentPage};
	var functionName=getRentOutList;
	if($("#selectType").val()=="待售信息"){
		url="/CBD/buyCarportPage";
		data={"curPage":currentPage,
				"endTime":null
		};
		functionName=getSaleOutList;
	}
	$.getJSON(url, data, functionName);
}

// ajax的回调函数
function getRentOutList(pager) {
	// 清空表格数据
	$("#rentOutList").html("");
	$("#carportInfoList").html("");
	// 获取总页数
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	$.each(pager.datas, function(i, rentOutInfoBean) {	
		var $carportInfoList=$("<div style='height: 170px;margin-top:20px;' class='carportContent' value='"+ rentOutInfoBean.rentOutId + "'>"+
				"<img class='carportImg' style='height: 150px;' alt='' src='image/car.jpg'>"+
				"<label>车位地址:</label><span class='carportAddress'>"+rentOutInfoBean.userCarportAddress+ rentOutInfoBean.userCarportAddressNo+"</span><br>"+
				"<label>出租用户:</label><span class='salePrice'>"+rentOutInfoBean.userName+"</span><br>"+
				"<label>出租价格:</label><span class='salePrice'>"+rentOutInfoBean.rentOutPrice+"</span><br>"+
				"<label>出租开始时间:</label><span class='saleTime'>"+rentOutInfoBean.rentOutStartDate+"</span><br>"+
				"<label>出租结束时间:</label><span class='saleTime'>"+rentOutInfoBean.rentOutEndDate+"</span></div>")
	$("#rentOutList").append($carportInfoList)
	});
	$("#currentPage").val(pager.currentPage);
	$("#totalPageNum").html(pager.totalPageNum);
}

function getSaleOutList(pager) {
	// 清空表格数据
	console.log(pager)
	$("#rentOutList").html("");
	$("#carportInfoList").html("");
	// 获取总页数
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	$.each(pager.datas, function(i, allSaleInfoBean) {	
		var $carportInfoList=$("<div style='height: 130px;' class='saleCarportContent' " +
				" userCarportUserId='"+allSaleInfoBean.userCarportUserId+"' " +
				" info='"+allSaleInfoBean.userCarportAddress+ allSaleInfoBean.userCarportAddressNo+"' value='"+ allSaleInfoBean.saleId + "'>"+
				"<img class='carportImg' style='height: 120px;' alt='' src='image/car.jpg'>"+
				"<label>车位地址:</label><span class='carportAddress'>"+allSaleInfoBean.userCarportAddress+ allSaleInfoBean.userCarportAddressNo+"</span><br>"+
				"<label>出售价格:</label><span class='salePrice'>"+allSaleInfoBean.salePrice+"</span><br>"+
				"<label>出售信息发布时间:</label><span class='saleTime'>"+allSaleInfoBean.salePublishTime+"</span><br></div>")
	$("#rentOutList").append($carportInfoList)
	});
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

/**尹诗添加的*****/
function showUserMyselfCarPort() {
	var url="showUserMyselfCarPort";
	var data={"currentPage" : currentPage,
			  "choiceSelete":$("#selectType").val()	
			 };	
	var functionName=sendOutInfo;
	if($("#selectType").val()=="空闲车位信息"){
		functionName=withToMe;
	}
	$.getJSON(url, data, functionName);
}


function sendOutInfo(pager) {
	// 清空表格数据
	$("#rentOutList").html("");
	$("#carportInfoList").html("");
	// 获取总页数
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	$.each(pager.datas, function(i, usercarportBean) {	
		var $carportInfoList=$("<div style='height: 170px;margin-top:20px;' class='carportContent' value='"+ usercarportBean.userCarportId + "'>"+
				"<img class='carportImg' style='height: 150px;' alt='' src='image/car.jpg'>"+
				"<label>车位地址:</label><span class='carportAddress'>"+usercarportBean.userCarportAddress + usercarportBean.userCarportAddressNo+"</span><br>"+
				"<label>车位状态:</label><span class='salePrice'>"+usercarportBean.userCarportStatus+"</span></div>")
	$("#rentOutList").append($carportInfoList)
	});
	$("#currentPage").val(pager.currentPage);
	$("#totalPageNum").html(pager.totalPageNum);
}



function withToMe(pager) {
	// 清空表格数据
	$("#rentOutList").html("");
	$("#carportInfoList").html("");
	// 获取总页数
	currentPage = pager.currentPage;
	totalPage = pager.totalPageNum;
	$.each(pager.datas, function(i, usercarportBean) {	
		var $carportInfoList=$("<div style='height: 170px;margin-top:20px;' class='carportContent' value='"+ usercarportBean.userCarportId + "'>"+
				"<img class='carportImg' style='height: 150px;' alt='' src='image/car.jpg'>"+
				"<label>车位地址:</label><span class='carportAddress'>"+usercarportBean.userCarportAddress + usercarportBean.userCarportAddressNo+"</span><br>"+
				"<label>车位状态:</label><span class='salePrice'>"+usercarportBean.userCarportAuditingStatus+"</span></div>")
	$("#rentOutList").append($carportInfoList)
	});
	$("#currentPage").val(pager.currentPage);
	$("#totalPageNum").html(pager.totalPageNum);
}

