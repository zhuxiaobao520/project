/* 添加外部合约页面js */

$(function(){// 时间格式
	laydate.render({ 
  		elem: '#thirdAggrementStartTime'
	});
	laydate.render({ 
  		elem: '#thirdAggrementEndTime'
	});
})

$.validator.setDefaults({// 校验完成提交表单
    submitHandler: function() {
    	$("#addThirdAggrementForm").submit();
    }
});

$().ready(function() {	
	// 在键盘按下并释放及提交后验证提交表单
	  $("#addThirdAggrementForm").validate({
		    rules: {
		    	thirdAggrementNewNo: {//合同编号不能为空
		    	required: true,
		         },
		
		        thirdAggrementCompany: {//对方单位不能为空
		        required: true
		      },
		      thirdAggrementLinkMan: {//对方联系人不能为空
		        required: true
		      },
		      thirdAggrementCompanyAddress: {//对方单位地址不能为空
		        required: true
		      },
		      thirdAggrementLinkManPhone:{//对方联系人电话
		    	  required: true,
	              minlength:11,
	              maxlength:11,
	              isphoneNum:true
		      },
		      thirdAggrementStartTime:{//合同开始时间
		    	  required: true
		      },
		      thirdAggrementImageUrl:{//复印件
		    	  required: true
		      },
		      thirdAggrementEndTime:{//合同截止时间
		    	  required: true
		      },
		      cbdCarportAddress:{//车位地址
		    	  required: true
		      },
		      cbdCarportAreaAddress:{//车位区域地址
		    	  required: true
		      },
		      cbdCarportAddressNoBegin:{//车位起始编号
		    	  digits: true
		      },
		      cbdCarportTotalNum:{//车位总数
		    	  digits: true
		      }
		    },
		    
		    messages: {
		    	thirdAggrementNewNo: {//合同编号不能为空
			    	required:"合同编号不能为空",
			         },
			
			      thirdAggrementCompany: {//对方单位不能为空
			        required: "对方单位不能为空"
			      },
			      thirdAggrementLinkMan: {//对方联系人不能为空
			        required: "对方联系人不能为空"
			      },
			      thirdAggrementCompanyAddress: {//对方单位地址不能为空
			        required: "对方单位地址不能为空"
			      },
			      thirdAggrementLinkManPhone:{//对方联系人电话
			    	  required: "请输入电话号码",
		              minlength: "请输入正确的11位电话号码",
		              maxlength:  "请输入正确的11位电话号码",
		              isphoneNum: "请输入正确的11位电话号码"
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
			      cbdCarportAddress:{//车位地址
			    	  required: "车位地址不能为空"
			      },
			      cbdCarportAreaAddress:{//车位区域地址
			    	  required: "车位区域地址不能为空"
			      },
			      cbdCarportAddressNoBegin:{//车位起始编号
			    	  digits: "请填写整数起始编号"
			      },
			      cbdCarportTotalNum:{//车位总数
			    	  digits: "请填写整数车位总数"
			      }
		    }
		});
	  
	  // 自定义手机号验证
	  jQuery.validator.addMethod("isphoneNum", function(value, element) {
	      var length = value.length;
	      var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
	      return this.optional(element) || (length == 11 && mobile.test(value));
	  }, "请正确填写手机号码");
	  
	  
	});












