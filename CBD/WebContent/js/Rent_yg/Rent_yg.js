/**
 * 租赁，出租记录相关的js, 姚刚
 */
$(function() {// 绑定加载事件
	laydate.render({
		elem : '#rentOutStartTime'
	});
	laydate.render({
		elem : '#rentOutEndTime'
	});
	$("#addRentOutBtn").click(function() {
		var regex = /^[0-9]{1,}$/;
		if (regex.test($("#rentOutPrice").val())) {
			var form = new FormData(document.getElementById("addRentOutForm"));
			$.ajax({
				url : "/CBD/rentOutController_yg/addRentOut",
				type : "post",
				data : form,
				processData : false,
				contentType : false,
				success : function(data) {
					if (data.result == true) {
						alert("已成功发布车位招租信息，即将跳转到首页");
						location.href = "/CBD/rentIn_yg/turnToRentOutListPage";
					} else {
						alert(data.reason);
					}
				}
			});
		} else {
			alert("你输入的出租价格有误，请输入正确的数字");
		}
	});
	// action="rentOutController_yg/addRentOut" method="post"
	// id="addRentOutForm"
});
