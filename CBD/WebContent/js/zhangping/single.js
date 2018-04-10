//张平
$.validator.setDefaults({
    submitHandler: function() {
    	$("#single").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#single").validate({
	    rules: {
	    	cbdCarportAddress: {
	    	required: true},
	
	    	cbdCarportAddressNo: {
	        required: true},
	    },
	    messages: {
	    	cbdCarportAddress: {
		    	required: "车位所在地址不能为空 "},
		
		        cbdCarportAddressNo: {
		        required: "车位区域编号不能为空 "},		        
	    }
	});   
});