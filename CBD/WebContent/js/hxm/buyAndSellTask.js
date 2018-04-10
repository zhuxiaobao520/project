
//待办买卖任务页面JS--黄先明

//	sellTask表格页面参数
	var sellTotalPage;
	var sellCurPage=1;
	var sellInputPage=1;
	
//agreementTask表格页面数据
	var agreementTotalPage;
	var agreementCurPage=1;
	var agreementInputPage=1;
	$(function(){//绑定加载时间
	
		//初始化sellTask表格页面数据（显示第一页）
		$.getJSON("sellTask",{curPage:sellCurPage},getSellTask);
		$.getJSON("agreementTask",{curPage:1,agreementType:$("#agreementType").val()},getAgreementTask);
		//sellTask表格页面事件处理
		//首页点击事件处理
		$("#sellFisrtPage").click(function(){
			sellCurPage=1;
			$.getJSON("sellTask",{curPage:sellCurPage},getSellTask)
		});
		
		//上一页点击事件处理
		$("#sellPrePage").click(function(){
			if(sellCurPage>1){
				sellCurPage=sellCurPage-1;
				$.getJSON("sellTask",{curPage:sellCurPage},getSellTask)
			}
		
		})
		//下一页点击事件处理
		$("#sellNextPage").click(function(){
			if(sellCurPage<sellTotalPage){
				sellCurPage=sellCurPage+1;
				$.getJSON("sellTask",{curPage:sellCurPage},getSellTask)
			}
				
			
		})
		//尾页点击事件处理
		$("#sellLastPage").click(function(){
			sellCurPage=sellTotalPage;
			$.getJSON("sellTask",{curPage:sellCurPage},getSellTask)
		})
		//跳页点击事件
		$("#sellJump").click(function(){
			sellInputPage=$("#sellInputPage").val();
			if(sellInputPage>0 && sellInputPage<sellTotalPage+1){
				sellCurPage=sellInputPage;
				$.getJSON("sellTask",{curPage:sellCurPage},getSellTask)
			}
			
		})
		
		
		
		//agreementTask表格页面事件处理
		//首页点击事件处理
		$("#agreementFisrtPage").click(function(){
			agreementCurPage=1;
			$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
		})
		
		//上一页点击事件处理
		$("#agreementPrePage").click(function(){
			if(agreementCurPage>1){
				agreementCurPage=agreementCurPage-1;
				$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
			}
		
		})
		//下一页点击事件处理
		$("#agreementNextPage").click(function(){
			if(agreementCurPage<agreementTotalPage){
				agreementCurPage=agreementCurPage+1;
				$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
			}
				
			
		})
		//尾页点击事件处理
		$("#agreementLastPage").click(function(){
			agreementCurPage=agreementTotalPage;
			$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
		})
		//跳页点击事件
		$("#agreementJump").click(function(){
			agreementInputPage=$("#agreementInputPage").val();
			if(agreementInputPage>0 && agreementInputPage<agreementTotalPage+1){
				agreementCurPage=agreementInputPage;
				$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
			}
			
		})
		
		
		//下拉框改变事件
		$("#agreementType").change(function(){
			agreementCurPage=1;
			$.getJSON("agreementTask",{curPage:agreementCurPage,agreementType:$("#agreementType").val()},getAgreementTask)
		})
		
		
	});
	
	
	
	//定义接收处理预约购买任务Ajax分页数据回调函数
	function getSellTask(sellTaskList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		sellTotalPage=sellTaskList.totalPageNum;
		//根据所选消息是否已读填充表格数据
		
			$.each(sellTaskList.datas,function(index,sellTask){
			var $sellTask=$("<tr class='data' >"+
									"<td>"+sellTask.userCarportAddress+sellTask.userCarportAddressNo+"</td>"+
									"<td>"+sellTask.userEntity.userName+"</td>"+
									"<td>"+sellTask.salePrice+"</td>"+
									"<td><a href='saleTaskInfo?buyInfoUserId="+sellTask.userEntity.userId+"'>查看详情</a>"
									+"</td>"+
									"</tr>"
									)
				$("#sellTask").append($sellTask)
			});
		
		
		//填充总页数
		$("#sellTotalPage").html(sellTotalPage)
		if(sellTotalPage<=0){
			sellTotalPage=1
			$("#sellTotalPage").html(sellTotalPage)
		}
		//填充当前页
		$("#sellInputPage").val(sellTotalPage)
		
	}
	
	
	//定义接收处理预约购买任务Ajax分页数据回调函数
	function getAgreementTask(agreementTaskList){
		//清空表格数据
		$(".data1").remove();
		//获取总页数
		agreementTotalPage=agreementTaskList.totalPageNum;
		//根据所选消息是否已读填充表格数据
		if($("#agreementType").val()=="待签购买合同"){
			$.each(agreementTaskList.datas,function(index,agreementTask){
				var $agreementTask=$("<tr class='data1' >"+
									"<td>"+agreementTask.userCarportAddress+agreementTask.userCarportAddressNo+"</td>"+
									"<td>"+agreementTask.saleUserName+"</td>"+
									"<td>"+agreementTask.buyUserName+"</td>"+
									"<td>"+agreementTask.salePrice+"</td>"+
									"<td><a href='buyAgreementTaskInfo?agreementId="+agreementTask.agreementId+"&userId="+agreementTask.buyId+"'>查看详情</a>"
									+"</td>"+
									"</tr>"
									)
				$("#agreementTask").append($agreementTask)
			});
		}else{
			$.each(agreementTaskList.datas,function(index,agreementTask){
				var $agreementTask=$("<tr class='data1' >"+
						"<td>"+agreementTask.userCarportAddress+agreementTask.userCarportAddressNo+"</td>"+
						"<td>"+agreementTask.saleUserName+"</td>"+
						"<td>"+agreementTask.buyUserName+"</td>"+
						"<td>"+agreementTask.salePrice+"</td>"+
						"<td><a href='saleAgreementTaskInfo?agreementId="+agreementTask.agreementId+"&userId="+agreementTask.saleId+"'>查看详情</a>"
						+"</td>"+
						"</tr>"
						)
					$("#agreementTask").append($agreementTask)
				});
		}
	
		//填充总页数
		$("#agreementTotalPage").html(agreementTotalPage)
		if(agreementTotalPage<=0){
			agreementTotalPage=1
			$("#agreementTotalPage").html(agreementTotalPage)
		}
		//填充当前页
		$("#agreementInputPage").val(agreementCurPage)
		
	}