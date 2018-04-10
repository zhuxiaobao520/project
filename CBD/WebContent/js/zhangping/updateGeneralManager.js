//张平
$(function(){
		$("#oldPassword").blur(function(){
			$("#oldPasswordSpan").html("");
		})
		$("#newPassword").blur(function(){
			$("#newPasswordSpan").html("");
		})
		$("#chongfuPassword").blur(function(){
			$("#chongfuPasswordSpan").html("");
		})
})
$.validator.setDefaults({
    submitHandler: function() {
    	$("#updateGeneralManager").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#updateGeneralManager").validate({
	    rules: {
	    	newPhone: {
	    		  required: true,
	              minlength:11,
	              maxlength:11,
	              isphoneNum:true},
	
	    	 oldPassword: {
	    	 required: true,
	 	      minlength: 6
	        },
	        
	        newPassword: {
	        	required: true,
	 	        minlength: 6,
	 	        maxlength:16
	 	  },
	        
	 	 chongfuPassword:{
	 		required:true ,
 	        minlength:6,
 	       equalTo: "#newPassword"}
	    },
	    messages: {
	    	newPhone: {
	    		 required: "",
	              minlength: "请输入正确的11位电话号码",
	              maxlength:  "请输入正确的11位电话号码",
	              isphoneNum: "请输入正确的11位电话号码"},
		
		    		 oldPassword: {
		    			 required: "请输入旧密码",
				       	minlength: "密码长度不少于6位，且密码是非空格"
				       	},
		        
				        newPassword: {
				        	required: "请输入新密码",
					       	minlength: "密码为6到16个字母、数字或下划线",
					       	maxlength: "密码为6到16个字母、数字或下划线"},
		        
		        chongfuPassword:{
		        	required: "请重复输入密码",
			       	minlength: "密码长度不少于6位，且密码是非空格",
			       	equalTo: "两次密码输入不一致"
		      }
	    }
	});
  

  //自定义手机号验证
  jQuery.validator.addMethod("isphoneNum", function(value, element) {
      var length = value.length;
      var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
      return this.optional(element) || (length == 11 && mobile.test(value));
  }, "请正确填写您的手机号码");
    
});