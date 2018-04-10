/**
 * 租赁车位相关的js,
 * 姚刚
 */
$(function() {// 绑定加载事件
	$("#rentOutComplainBtn").click(function(){
		 var form = new FormData(document.getElementById("rentOutComplainForm"));
      $.ajax({
          url:"/CBD/rentOutController_yg/rentOutRecordComplain",
          type:"post",
          data:form,
          processData:false,
          contentType:false,
          success:function(data){
              if(data.result==true){
            	  alert("投诉已受理，即将跳转到交易记录界面");
            	  location.href="/CBD/rentRecord_yg/turnToRentRecord";
              }else{
            	  alert(data.resultMessage);
              }
          }
      });        
	});
	
});
