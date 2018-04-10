$.validator.setDefaults({
    submitHandler: function() {
    	$("#updateForm").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
$("#updateForm").validate({
	rules: {
		userAddress: {
			required: true,
		},	
		userPhone: {
			required: true,
            minlength:11,
            maxlength:11,
            isphoneNum:true
	    },
	    userProfession: {
	        required: true,
	    },	    
	},
	messages: {
		userAddress: {
		    required: "请输入地址",
		},
		userPhone: {
			required: "请输入电话号码",
            minlength: "请输入正确的11位电话号码",
            maxlength:  "请输入正确的11位电话号码",
            isphoneNum: "请输入正确的11位电话号码"
		},
		userProfession: {
		        required: "请输入工作",
		},
	}
});
  
  //自定义手机号验证
  jQuery.validator.addMethod("isphoneNum", function(value, element) {
      var length = value.length;
      var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
      return this.optional(element) || (length == 11 && mobile.test(value));
  }, "请正确填写您的手机号码");
  
  
});
