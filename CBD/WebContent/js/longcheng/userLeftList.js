/*
 * 个人未读消息数量，定时刷新
 */
setInterval(function(){
	$.getJSON("getMsgNum",getMsgNum);
},1000);


function getMsgNum(msgNum){
	
	if(msgNum != 0){
		$("#messageNum").addClass("glyphicon")
		$("#messageNum").addClass("glyphicon-volume-down") 
		$("#messageNum").html(msgNum)
	}else{
		$("#messageNum").html("")
		$("#messageNum").removeClass("glyphicon glyphicon-volume-down")
	}
	
}