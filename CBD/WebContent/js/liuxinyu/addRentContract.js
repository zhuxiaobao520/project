/*
 * 添加租户
 */ 
$(function(){	
	 $.getJSON("addCarport",getCarport);
	 $.getJSON("selectCompany",getCompany);
 }) 
 //空车位信息
 function  getCarport(nullCarport){	
	$.each(nullCarport,function(index,carport){
		$content=("<option>"+carport.cbdCarportAddress+"-"+carport.cbdCarportAddressNo+"</option>")
		$("#vacantCaport").append($content)	
	})	
 }
 //所有企业信息
 function  getCompany(companyList){	
		$.each(companyList,function(index,company){
			$content=("<option value='"+company.companyId+"'>"+company.companyAccount+"</option>")
			$("#campanyName").append($content)	
		})	
	 }
 