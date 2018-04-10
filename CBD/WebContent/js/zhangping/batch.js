//张平
$.validator.setDefaults({
    submitHandler: function() {
    	$("#batch").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#batch").validate({
	    rules: {
	    	cbdCarportAddress: {
	    	required: true},
	
	        cbdCarportAddressNo: {
	        required: true},
	        
	        cbdCarporStartNo: {
	        required: true, 
	        digits: true},
	        
	      cbdCarporSum:{
	    	  required: true,
	    	  digits: true
	    	  }
	    },
	    messages: {
	    	cbdCarportAddress: {
		    	required: "车位所在地址不能为空 "},
		
		        cbdCarportAddressNo: {
		        required: "车位区域编号不能为空 "},
		        
		      cbdCarporStartNo: {
		        required: "车位起始号不能为空",
		        digits: '车位开始数必须是数字'},
		        
		      cbdCarporSum:{
		    	  	required: "车位总数不能为空 ",
		    	    digits: '车位总数必须是数字',
		      }
	    }
	});
  

  
  
});