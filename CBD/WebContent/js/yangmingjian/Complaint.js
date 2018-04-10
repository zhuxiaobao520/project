//朱小宝

	var complaintCheckedId=0;
	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		//初始化页面数据（显示第一页）
		getComplaintPager()

		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			getComplaintPager()
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				getComplaintPager()
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				getComplaintPager()
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			getComplaintPager()
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				getComplaintPager()
			}
			
		})
		//点击表格获取id
		$("#complaint").on("click",".data",function(){
			$(this).css("background-color","rgba(0,0,240,0.4)");
			$(this).siblings(".data").css("background-color","white");
			complaintCheckedId=$(this).attr("value");
		});
	
		//投诉处理
		$("#disposeComplaint").click(function(){
			if(complaintCheckedId==0){
				alert("请选择要操作的数据！")
			}else{
				location.href="getComplainInfoById?complaintId="+complaintCheckedId;
			}
		});

	});
	
	//Ajax函数
	function getComplaintPager() {
		$.getJSON("complaintPage", {
			"curPage" : curPage,
		}, getComplaintInfo);

	}
	//定义接收Ajax分页数据回调函数
	function getComplaintInfo(complaintList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		totalPage=complaintList.totalPageNum;
		
		complaintCheckedId=0;
		//
		$.each(complaintList.datas,function(index,complaint){
			var $complaintInfo=$("<tr class='data' value="+complaint.complainId+">"+
								"<td>"+complaint.complainUser.userName+"</td>"+
								"<td>"+complaint.complainedUser.userName+"</td>"+
								"<td>"+complaint.complainTime+"</td>"+
								"<td>"+complaint.complainStatus+"</td>"+
								"</tr>"
								)
			$("#complaint").append($complaintInfo)
		});
		
		//填充总页数
		$("#totalPage").html(totalPage)
		//填充当前页
		$("#inputPage").val(curPage)
		
	}