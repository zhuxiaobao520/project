
$.validator.setDefaults({
    submitHandler: function() {
    	$("#addAgreement").submit();
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#addAgreement").validate({
	    rules: {
	    	renterAgreementOldNo: {
	    	required: true},
	    	
	    	renterAgreementNewNo: {
		    	required: true},
	
	    	renterAgreementStartTime: {
	    		required: true,dateISO: true},
	        
	        renterAgreementEndTime: {
	        	required: true,dateISO: true},
		    
		    renterAgreementPrice: {
		    	required: true,digits: true},
		    	
		      datas: {
				required: true},
				
			    file: {
			  required: true},	
	    },
	    messages: {
	    	renterAgreementOldNo: {
		    	required: "合同编号不能为空 "},
		    	
		    	renterAgreementNewNo: {
			    	required: "合同编号不能为空 "},
		       
		    	renterAgreementStartTime: {
		    	required:"请选择开始有效日期" },
		       
		        renterAgreementEndTime: {
		        required:"请选择截止有效日期"},
			        
			     renterAgreementPrice: {
			     required: "只能输入数字"},
			     
			     datas: {
				 required: "请选择车位"},
				 
				 file: {
					 required: "请选择文件"},
	    }
	});

});