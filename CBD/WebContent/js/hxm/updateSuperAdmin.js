//黄先明
$.validator.setDefaults({
    submitHandler: function() {
    	$("#updateSuperAdminForm").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#updateSuperAdminForm").validate({
	    rules: {
	    	oldPassword: {
	    	required: true,
	        minlength: 5},
	
	        newPassword: {
	        required: true,
	        minlength: 5
	      },
	      repeatPassword: {
	        required: true,
	        minlength: 5,
	        equalTo: "#newPassword"
	      }
	    },
	    messages: {
	    	oldPassword: {
		    	required: "请输入原密码",
		        minlength: "密码至少5个字符"},
		
		        newPassword: {
		        required: "请输入新密码",
		        minlength: "密码至少5个字符"
		      },
		      repeatPassword: {
		        required: "请重复密码",
		        minlength: "密码至少5个字符",
		        equalTo: "两次密码输入不一致"
		      }
	    }
	});
  

  
  
});