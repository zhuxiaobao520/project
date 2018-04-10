/* 续约外部合约页面js */

$(function(){
	laydate.render({ 
  		elem: '#thirdAggrementStartTime'
	});
	laydate.render({ 
  		elem: '#thirdAggrementEndTime'
	});
})

$.validator.setDefaults({// 校验完成提交表单
    submitHandler: function() {
    	$("#continueThirdAggrementForm").submit();
    }
});

$().ready(function() {	
	// 在键盘按下并释放及提交后验证提交表单
	  $("#continueThirdAggrementForm").validate({
		    rules: {
		    	thirdAggrementNewNo: {//新合同编号不能为空
		    	required: true,
		         },
		      thirdAggrementStartTime:{//合同开始时间
		    	  required: true
		      },
		      thirdAggrementImageUrl:{//复印件
		    	  required: true
		      },
		      thirdAggrementEndTime:{//合同截止时间
		    	  required: true
		      }
		    },
		    
		    messages: {
		    	thirdAggrementNewNo: {//新合同编号不能为空
			    	required:"新合同编号不能为空",
			         },
			      thirdAggrementStartTime:{//合同开始时间
			    	  required: "请选择合同开始时间"
			      },
			      thirdAggrementImageUrl:{//复印件
			    	  required: "请上传合同复印件"
			      },
			      thirdAggrementEndTime:{//合同截止时间
			    	  required: "请选择合同截止时间"
			      },
		    }
		});  
	});