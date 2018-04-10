/* 外部合约js 龙成 */

	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		
		//初始化页面数据（显示第一页）
		$.getJSON("thirdAggrementPage",{curPage:1},getThirdAggrementInfo)
		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			$.getJSON("thirdAggrementPage",{curPage:1},getThirdAggrementInfo)
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				$.getJSON("thirdAggrementPage",{curPage:curPage},getThirdAggrementInfo)
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				$.getJSON("thirdAggrementPage",{curPage:curPage},getThirdAggrementInfo)
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			$.getJSON("thirdAggrementPage",{curPage:totalPage},getThirdAggrementInfo)
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				$.getJSON("thirdAggrementPage",{curPage:curPage},getThirdAggrementInfo)
			}		
		})
		//给每行添加事件，用于获取每行的id,并添加到隐藏域中
		$("#thirdAggrementData").on("click",".data",function(){
			//将隐藏域中的id修改为当前点击行的id
			$("#thirdAggrementIdHidden").val($(this).attr("thirdAggrementId"));
			$(this).css("backgroundColor","#EBEBEB");
			$(this).siblings().css("backgroundColor","white");
		})
		
		//给续约按钮添加事件
		$("#continue").click(function(){
			//点击时获取隐藏域中的id
			var id = $("#thirdAggrementIdHidden").val();
			//判断是否点击了行
			if(id==-1){//未选中
				alert("请选择行！")
			}else{
				//修改a标签中的herf
				$("#a_continue").attr("href","continueThirdAggrement?thirdAggrementId="+id);
				//将隐藏域中的值修改为默认值
				$("#thirdAggrementIdHidden").val("-1");
			}				
		})	
		
		//给解约添加点击事件
		$("#termination").click(function(){
			//点击时获取隐藏域中的id
			var id = $("#thirdAggrementIdHidden").val();
			//判断是否点击了行
			if(id==-1){//未选中
				alert("请选择行！")
			}else{
				$.getJSON("terminationThirdAggrementPage",{curPage:curPage,thirdAggrementId:id},getThirdAggrementInfo)
			}				
		})				
	});
	//定义接收Ajax分页数据回调函数
	function getThirdAggrementInfo(thirdAggrementList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		totalPage=thirdAggrementList.totalPageNum;
		//
		$.each(thirdAggrementList.datas,function(index,thirdAggrement){
			var $thirdAggrementInfo=$("<tr thirdAggrementId='"+thirdAggrement.thirdAggrementId+"' class='data'>"+
								"<td>"+thirdAggrement.thirdAggrementNewNo+"</td>"+
								"<td>"+thirdAggrement.thirdAggrementOldNo+"</td>"+
								"<td>"+thirdAggrement.thirdAggrementCompany+"</td>"+
								"<td>"+thirdAggrement.thirdAggrementLinkMan+"</td>"+
								"<td>"+thirdAggrement.thirdAggrementLinkManPhone+"</td>"+	
								"<td>"+thirdAggrement.thirdAggrementCompanyAddress+"</td>"+
								"<td>"+thirdAggrement.thirdAgreementBeginTime+"</td>"+
								"<td>"+thirdAggrement.thirdAgreementOverTime+"</td>"+
								"<td>"+thirdAggrement.thirdAgreementStatus+"</td>"+
								"</tr>"
								)
								
			$("#thirdAggrementData").append($thirdAggrementInfo)
		});
		
		//填充总页数
		$("#totalPage").text(totalPage)
		//填充当前页
		$("#inputPage").val(curPage)
	}