var curPage=1;//当前页面
var totalPage=1; //总页数
$(function(){					
	//绑定load加载事件

	//初始化页面数据（显示第一页）
	$.getJSON("rentContract",{curPage:1},getContractInfo);									
	//首页点击处理
	$("#firstPage").click(function(){		
		curPage=1;
		$.getJSON("rentContract",{curPage:curPage},getContractInfo);
	});
	
	//上一页点击处理
	$("#prePage").click(function(){
		if(curPage>1){
			curPage=curPage-1;
			$.getJSON("rentContract",{curPage:curPage},getContractInfo);
		}
	});
	
	//下一页点击处理
	$("#nextPage").click(function(){	
		if(curPage<totalPage){
			curPage=curPage+1;
			$.getJSON("rentContract",{curPage:curPage},getContractInfo);
		}
	});
	
	//尾页处理
	$("#lastPage").click(function(){
		curPage=totalPage;
		$.getJSON("rentContract",{curPage:curPage},getContractInfo);
	});
//跳转处理
$("#jump").click(function(){
	var curPage=$("#query").val();
	var data={curPage:curPage};	
	if(curPage >0 && curPage<=totalPage){
		curPage=curPage;
		$.getJSON("rentContract",data,getContractInfo);
	}
}); 

//给每行添加事件，用于获取每行的id,并添加到隐藏域中
$("#AgreementInfo").on("click",".data",function(){
	//将隐藏域中的id修改为当前点击行的id
	$("#agreementHidden").val($(this).attr("value"));
	$(this).css("backgroundColor","#EBEBEB");
	$(this).siblings().css("backgroundColor","white");
})
//续约添加点击事件
$("#extensionAgreement").click(function(){
	var id=$("#agreementHidden").val();
	//判断是否点击了行
	if(id==-1){//未选中
		alert("请选择行！")
	}else{
	window.location.href="rentContractExtension?id="+id; 
	}		
})
	//给解约添加点击事件
		$("#disAgreement").click(function(){
			//点击时获取隐藏域中的id
			var id=$("#agreementHidden").val();
			//判断是否点击了行
			if(id==-1){//未选中
				alert("请选择行！")
			}else{
				$.getJSON("breakRentContract",{curPage:curPage,id:id},getContractInfo)
			/*	window.location.href="breakRentContract?id="+id; */
			}				
		})		
//合同添加事件
 $("#addAgreement").click(function(){
	  window.location.href="addAgreement"; 
 })
});


//接收ajax响应分页数据回调函数
function getContractInfo(rentContract){		
	//清空表格
	$(".data").html("");					
	//获取总页数
     curPage=rentContract.currentPage;
     totalPage=rentContract.totalPageNum;
	  var List =rentContract.datas;
	//填充表格
      $.each(List,function(index,contract){
    	  if(contract.renterAgreementStatus=="1"){
    		  contract.renterAgreementStatus="生效"
    	  }else{
    		  contract.renterAgreementStatus="失效"
    	  }
    	  $content=("<tr value='"+contract.renterAgreementId+"' class='data'><td>"+contract.renterAgreementNewNo+"</td>" +
    	  		    "<td>"+contract.renterAgreementStatus+"</td>" +
    	  		   "<td>"+contract.renterAgreementStartTime+"</td>" +
    	  			"<td>"+contract.renterAgreementEndTime+"</td>" +
    	  			"<td>"+contract.renterAgreementPrice+"</td></tr>")
    	           $("#AgreementInfo").append($content)
          })
	
	$("#query").val(curPage);//当前页数	
	$("#total").html("/"+totalPage);//总页数
}
