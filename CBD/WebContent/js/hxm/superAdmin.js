//黄先明
	var adminCheckedId=0;
	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		//初始化页面数据（显示第一页）
		$.getJSON("adminPage",{curPage:1},getAdminInfo)

		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			$.getJSON("adminPage",{curPage:1},getAdminInfo)
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				$.getJSON("adminPage",{curPage:curPage},getAdminInfo)
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				$.getJSON("adminPage",{curPage:curPage},getAdminInfo)
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			$.getJSON("adminPage",{curPage:totalPage},getAdminInfo)
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				$.getJSON("adminPage",{curPage:curPage},getAdminInfo)
			}
			
		})
		//点击表格获取id
		$("#adminData").on("click",".data",function(){
			$(this).css("background-color","rgba(0,0,240,0.4)");
			$(this).siblings(".data").css("background-color","white");
			adminCheckedId=$(this).attr("value");
		});
	
		//查询管理员详细信息
		$("#lookAdmin").click(function(){
			if(adminCheckedId==0){
				alert("请选择要操作的数据！")
			}else{
				location.href="getCheckedAdmin?adminId="+adminCheckedId;
			}
		});
		
		//修改管理员信息
		$("#updateAdmin").click(function(){
			if(adminCheckedId==0){
				alert("请选择要操作的数据！")
			}else{
				location.href="updateCheckedAdmin?adminId="+adminCheckedId;
			}
		});
		
		//删除管理员信息
		$("#deleteAdmin").click(function(){
			if(adminCheckedId==0){
				alert("请选择要操作的数据！")
			}else{
				$.getJSON("deleteAdminInfo",{curPage:curPage,adminId:adminCheckedId},getAdminInfo)
			}
		});
		
	});
	//定义接收Ajax分页数据回调函数
	function getAdminInfo(adminList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		totalPage=adminList.totalPageNum;
		curPage=adminList.currentPage;
		adminCheckedId=0;
		//
		$.each(adminList.datas,function(index,admin){
			var $adminInfo=$("<tr class='data' value="+admin.adminId+">"+
								"<td>"+admin.adminAccount+"</td>"+
								"<td>"+admin.adminRealName+"</td>"+
								"<td>"+admin.adminNo+"</td>"+
								"</tr>"
								)
			$("#adminData").append($adminInfo)
		});
		
		//填充总页数
		$("#totalPage").html(totalPage)
		if(totalPage<=0){
			totalPage=1;
			$("#totalPage").html(totalPage);
		}
		//填充当前页
		$("#inputPage").val(curPage)
		
	}