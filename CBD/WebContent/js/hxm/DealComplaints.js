$(function(){
	$("#complain").click(function(){
		$.getJSON("isComplained",
				{complainEventId:$("#complainEventId").val(),
				 complainType:$("#complainType").val(),
				 buyUserId:$("#buyUserId").val(),
				 sellUserId:$("#sellUserId").val()
				
				},
				isComplain)
	})
})


	//Ajax处理是否投诉成功
	function isComplain(data){
		if(data[0]=="投诉成功"){
			$("#complainForm").submit();
		}else{
			alert("您已经投诉过，请勿重复投诉")
		}	
		
	}
