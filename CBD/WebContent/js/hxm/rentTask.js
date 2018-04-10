//代租赁任务页面JS--黄先明
	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		//初始化页面数据（显示第一页）
		$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				$.getJSON("bookedRentInfo",{curPage:curPage},bookedRentInfo)
			}
			
		})
	
		
	});
	//定义接收Ajax分页数据回调函数
	function bookedRentInfo(bookedRentInfoList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		totalPage=bookedRentInfoList.totalPageNum;
		
		//填充预定租赁信息
		$.each(bookedRentInfoList.datas,function(index,bookedRentInfo){
				var $bookedRentInfo=$("<tr class='data' >"+
									"<td>"+bookedRentInfo.userCarportAddress+bookedRentInfo.userCarportAddressNo+"</td>"+
									"<td>"+bookedRentInfo.rentOutStartTime+"</td>"+
									"<td>"+bookedRentInfo.rentOutEndTime+"</td>"+
									"<td>"+bookedRentInfo.rentOutPrice+"</td>"+
									"<td>"+bookedRentInfo.userEntity.userName+"</td>"+
									"<td><a href='lookRentInfo?rentInUserId="+bookedRentInfo.userEntity.userId+"'>查看信息</a>"+"</td>"
					
									)
				$("#rentInfo").append($bookedRentInfo)
			});
		
	
		//填充总页数
		$("#totalPage").html(totalPage)
		if(totalPage<=0){
			totalPage=1
			$("#totalPage").html(totalPage)
		}
		//填充当前页
		$("#inputPage").val(curPage)
		
	}