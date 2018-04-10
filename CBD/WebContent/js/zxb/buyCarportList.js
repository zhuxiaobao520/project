	var totalPage;
	var curPage=1;
	var inputPage=1;
	var endTime = null;
	$(function(){//绑定加载时间
		$("#lookInfoByTime").click(function(){
			endTime = $("#endTime").val();
			$.getJSON("buyCarportPage",{curPage:1,endTime:endTime},getAdminInfo)
		});
		//初始化页面数据（显示第一页）
		$.getJSON("buyCarportPage",{curPage:1,endTime:endTime},getAdminInfo)

		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			$.getJSON("buyCarportPage",{curPage:1,endTime:endTime},getAdminInfo)
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				$.getJSON("buyCarportPage",{curPage:curPage,endTime:endTime},getAdminInfo)
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				$.getJSON("buyCarportPage",{curPage:curPage,endTime:endTime},getAdminInfo)
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			$.getJSON("buyCarportPage",{curPage:totalPage,endTime:endTime},getAdminInfo)
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				$.getJSON("buyCarportPage",{curPage:curPage,endTime:endTime},getAdminInfo)
			}
			
		})
		
		//选择时间
		laydate.render({ 
	  		elem: '.endTime'
	  		,type:'datetime'
		});
		
	});
	//定义接收Ajax分页数据回调函数
	function getAdminInfo(AllSaleInfoList){
		//清空表格数据
		$(".tmp").remove();
		//获取总页数
		totalPage=AllSaleInfoList.totalPageNum;
		
		adminCheckedId=0;
		//
		$.each(AllSaleInfoList.datas,function(index,saleInfo){
			var $carportInfoList=$("<div class='tmp'>"+
					"<img class='carportImg' style='height: 175px;' alt='' src='image/car.jpg'>"+
					"<label>车位地址:</label><span class='carportAddress'>"+saleInfo.userCarportAddress+saleInfo.userCarportAddressNo+"</span><br>"+
					"<label>出租价格:</label><span class='salePrice'>"+saleInfo.salePrice+"</span><br>"+
					"<label>发布时间:</label><span class='saleTime'>"+saleInfo.salePublishTime+"</span><br>"+
					"<a class='lookRealInfo' href='userCaportMinuteInfo?saleId="+saleInfo.saleId+"&userCarportUserId="+saleInfo.userCarportUserId+
					"&info="+saleInfo.userCarportAddress+saleInfo.userCarportAddressNo+"'>查看详细信息</a></div>")
			$("#carportInfoList").append($carportInfoList)
		});
		
		//填充总页数
		$("#totalPage").html(totalPage)
		//填充当前页
		$("#inputPage").val(curPage)
		
	}