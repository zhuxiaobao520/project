/**
 * 租赁车位相关的js,
 * 姚刚
 */
$(function() {// 绑定加载事件
	// action="rentInController_yg/addRentIn" method="post"
	$("#addRentInBtn").click(function(){
		//添加租赁记录，并返回租赁结果
		$.getJSON("rentInController_yg/addRentIn", {
			"rentOutId" : $("#rentOutId").val(),
			"rentInMessage" : $("#rentInMessage").val()
		}, showAddResult);
	});
	
});
function showAddResult(resultMap){
	var result=resultMap.result;
	if(result==true){
		alert("添加成功，即将显示所有可租车位");
		//跳转到显示可租车位页面
		location.href="/CBD/rentIn_yg/turnToRentOutListPage";
	}else{
		alert(resultMap.failedReson);
	}
}
