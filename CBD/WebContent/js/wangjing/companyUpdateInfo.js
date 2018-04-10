
	
$.validator.setDefaults({
	    submitHandler: function() {
	    	 
	    	$("#updateCompanyInfoForm").submit();
	    }
	});
$().ready(function() {

	// 在键盘按下并释放及提交后验证提交表单
	  $("#updateCompanyInfoForm").validate({
		  
		
		    rules: {
		    	companyAccount: {
		    	  required: true,
		          minlength: 4,
		          maxlength:25

		          },
		        companyLinkMan: {
		          required: true,
		          minlength: 2,
		          maxlength:10
		        },
		        companyPhone:{
		          required: true,
	              minlength:11,
	              maxlength:11,
	              isphoneNum:true
		        }
		    },
		    messages: {
		    	companyAccount: {
			    	required: "请输入用户名",
			        minlength: "用户名不能少于4个字符",
			        maxlength:"用户名不能超过25个字符"
			    	},
			
			    companyLinkMan: {
			        required: "请输入联系人姓名",
			        minlength: "联系人姓名不能少于2个汉字",
			        maxlength:  "联系人姓名不能超过10个汉字"
			     	},
			    companyPhone:{
			    	required: "请输入电话号码",
		            minlength: "请输入正确的11位电话号码",
		            maxlength:  "请输入正确的11位电话号码",
		            isphoneNum: "请输入正确的11位电话号码"
				    }
		    }
		});
	  
	  //自定义手机号验证
	  jQuery.validator.addMethod("isphoneNum", function(value, element) {
	      var length = value.length;
	      var mobile = /^1[3|4|5|7|8]{1}[0-9]{9}$/;
	      return this.optional(element) || (length == 11 && mobile.test(value));
	  }, "请正确填写您的手机号码");
	  
	  
	  
});
	





