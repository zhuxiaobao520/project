/*
 * 查看待租列表相关的js
 */
var currentPage = 1;
var totalPage = 1;
var rentOutId = 0;
$(function() {// 绑定加载事件
	// ajax请求初始化页面数据（第一页）currentPage, 4, logOperationType, logType,
	getRentOutPager();
	// 为首页添加监听事件
	$("#firstPage").click(function() {
		currentPage = 1;
		getRentOutPager();
	});
	// 为上一页添加监听事件
	$("#prePage").click(function() {
		if (currentPage > 1) {
			currentPage--;
			getRentOutPager();
		} else {
			alert("已经是第一页了");
		}
	});
	// 为下一页添加监听事件
	$("#nextPage").click(function() {
		if (currentPage < totalPage) {
			currentPage++;
			getRentOutPager();
		} else {
			alert("已经是最后一页了");
		}
	});
	// 尾页点击事件处理
	$("#lastPage").click(function() {
		currentPage = totalPage;
		getRentOutPager();
	});
	//跳转按钮添加监听事件
	$("#turnToPage").click(function() {
		var regex=/^[0-9]{1,}$/;
		if(regex.test($("#currentPage").val())){
			currentPage = $("#currentPage").val();
			getRentOutPager();
		}else{
			alert("请输入正确的页数");
		}
	});
	// 给每条记录添加点击事件
	$("#rentOutList").on("click", ".carportContent", function() {
		rentOutId = $(this).attr("value");
		$(".carportContent").removeClass("selectedTr");
		$(this).addClass("selectedTr");
	});
	//查看车位详情事件
	$("#getRentOutInfoBtn").click(function() {
		if(rentOutId!=0){
			//当有选中行时进行页面跳转
			//location.href="/CBD/rentOutController_yg/turnToRentOutInfoPage?rentOutId="+rentOutId;
			var url="/CBD/rentOutController_yg/turnToRentOutInfoPage";
			var params={"rentOutId":rentOutId};
			postcall(url, params);
		}else{
			alert("你他丫的都没选交易记录，就想查看车位详情？");
		}
		
	});
});
function getRentOutPager() {
	$.getJSON("rentIn_yg/getRentOutPager", {
		"currentPage" : currentPage
	}, getRentOutList);
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
		var $carportInfoList=$("<div class='carportContent' value='"+ rentOutInfoBean.rentOutId + "'>"+
				"<img class='carportImg' style='height: 175px;' alt='' src='image/car.jpg'>"+
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
