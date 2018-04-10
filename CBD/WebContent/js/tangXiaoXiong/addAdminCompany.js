//唐小雄
$(function(){
	$("#companyPassword").blur(function(){
		$("#companyPasswordSpan").html("");
		})
		
		$("#companyPhone").blur(function(){
		$("#companyPhoneSpan").html("");
		})
		
		$("#companyAccount").blur(function(){
			$("#sp_jg2").html("");
		})
		
		$("#companyName").blur(function(){
			$("#sp_jg").html("");
		})
		$("#companyAddress").blur(function(){
			$("#companyAddressSpan").html("");
		})
		$("#companyLinkMan").blur(function(){
			$("#companyLinkManSpan").html("");
		})
})

$.validator.setDefaults({
    submitHandler: function() {
    	$("#AddTheEnterprise").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#AddTheEnterprise").validate({
	    rules: {
	    	companyAccount: {
		    	required: true,
		    	 minlength: 1,
		    	 maxlength:10},
	
		    companyPassword: {
		    	 required: true,
		    	 minlength: 6,
	 	        maxlength: 16
	        },
	        
	        companyName: {
	        	required: true
	 	  },
	        
	 	 companyAddress:{
	 		required: true},
	 	  
	 	 companyLinkMan:{
	    	required: true},
	    	
	    companyPhone:{
 	    	required: true,
 	    	minlength: 11,
	    	maxlength: 11}
  },
	    messages: {
	    	companyAccount: {
		    	required: "请输入企业登录名",
		    		 minlength: "请输入1~10位字符的企业登录名",
		    		 maxlength: "请输入1~10位字符的企业登录名"},
		
	    	companyPassword: {
				 required: "请输入企业登录密码",
				 minlength: "密码为6到16个字母、数字或下划线",
				 maxlength: "密码为6到16个字母、数字或下划线"},
    
			companyName: {
	        	required: "请输入企业名称"},
	        	
	        companyAddress: {
        		required: "请输入企业楼层位置"},
        		
        	companyLinkMan: {
    			required: "请输入企业联系人"},
    			
    		companyPhone: {
				required: "请输入企业联系电话",
				 minlength: "请输入11位有效电话",
				 maxlength: "请输入11位有效电话"}
	    }
	});
});