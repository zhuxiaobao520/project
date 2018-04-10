//黄先明
$.validator.setDefaults({
    submitHandler: function() {
    	$("#addAdminForm").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#addAdminForm").validate({
	    rules: {
	    adminAccount: {
	    	required: true,
	        minlength: 5},
	
	      adminPassword: {
	        required: true,
	        minlength: 5
	      },
	      adminNo: {
	        required: true,
	        minlength: 5
	      },
	      adminRealName: {
	        required: true
	      },
	      adminPhone:{
	    	  required: true,
              minlength:11,
              maxlength:11,
              isphoneNum:true
	      }
	    },
	    messages: {
	    	adminAccount: {
		    	required: "请输入用户名",
		        minlength: "用户名不能少于5个字符"},
		
		      adminPassword: {
		        required: "请输入密码",
		        minlength: "密码不能少于5个字符"
		      },
		      adminNo: {
		        required: "请输入工号",
		        minlength: "工号不能少于5个字符"
		      },
		      adminRealName: {
		        required: "请输入真实姓名"
		      },
		      adminPhone:{
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
      var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
      return this.optional(element) || (length == 11 && mobile.test(value));
  }, "请正确填写您的手机号码");
  //输入工号失焦事件
  $("#newAdminNo").blur(function(){
		$.getJSON("juageAdminNo",{adminNo:$("#newAdminNo").val()},getErrorInfo)
  })
   //输入用户名失焦事件
   $("#newAdminAccount").blur(function(){
		$.getJSON("juageAdminAccount",{adminAccount:$("#newAdminAccount").val()},getAccountErrorInfo)
  })
});
function getErrorInfo(errorInfo){
	var info=errorInfo[0];
	$("#errorInfo").html(info);
}
function getAccountErrorInfo(errorInfo){
	var info=errorInfo[0];
	$("#addAdminError").html(info);
}




//$(function(){
//	$("#return").click(function(){
//		alert("11111");
//		$.getJSON("adminInfoPage");
//	});
//	
//	
//});