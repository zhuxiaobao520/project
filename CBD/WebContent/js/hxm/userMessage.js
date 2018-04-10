//黄先明
	var totalPage;
	var curPage=1;
	var inputPage=1;
	$(function(){//绑定加载时间
		//初始化页面数据（显示第一页）
		$.getJSON("messagePage",{curPage:curPage,msgIsRead:"未读消息"},getMessageInfo)

		//首页点击事件处理
		$("#fisrtPage").click(function(){
			curPage=1;
			$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
		})
		
		//上一页点击事件处理
		$("#prePage").click(function(){
			if(curPage>1){
				curPage=curPage-1;
				$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
			}
		
		})
		//下一页点击事件处理
		$("#nextPage").click(function(){
			if(curPage<totalPage){
				curPage=curPage+1;
				$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
			}
				
			
		})
		//尾页点击事件处理
		$("#lastPage").click(function(){
			curPage=totalPage;
			$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
		})
		//跳页点击事件
		$("#jump").click(function(){
			inputPage=parseInt($("#inputPage").val());
			if(inputPage>0 && inputPage<totalPage+1){
				curPage=inputPage;
				$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
			}
			
		})
		
		//下拉框改变事件
		$("#messageIsRead").change(function(){
			curPage=1;
			$.getJSON("messagePage",{curPage:curPage,msgIsRead:$("#messageIsRead").val()},getMessageInfo)
		})
		
		
		//给标记未读按钮添加预点击事件
		$("#msgData").on("click",".markBtn",function(){
			//获取按钮中包含的消息id
			var messageId = $(this).attr("messageId");
			$.getJSON("markRead",{curPage:curPage,msgIsRead:$("#messageIsRead").val(),messageId:messageId},getMessageInfo)
			
		})
		
		//给删除消息按钮预添加预点击事件
		$("#msgData").on("click",".deleteBtn",function(){
			//获取按钮中包含的消息id
			var messageId = $(this).attr("messageId");
			$.getJSON("deleteMessage",{curPage:curPage,msgIsRead:$("#messageIsRead").val(),messageId:messageId},getMessageInfo)
		})
		
	});
	//定义接收Ajax分页数据回调函数
	function getMessageInfo(messageList){
		//清空表格数据
		$(".data").remove();
		//获取总页数
		totalPage=messageList.totalPageNum;
		//当前页
		curPage=messageList.currentPage;
		//根据所选消息是否已读填充表格数据
		if($("#messageIsRead").val()=="未读消息"){
			$.each(messageList.datas,function(index,message){
				var $messageInfo=$("<tr class='data' >"+
									"<td>"+message.messageContent+"</td>"+
									"<td><input class='markBtn' messageId='"+message.messageId+"'  type='button' value='标记已读'>"
									+"<input class='deleteBtn' messageId='"+message.messageId+"' type='button' value='删除'>"
									+"</td>"+
									"</tr>"
									)
				$("#msgData").append($messageInfo)
			});
			
		}else{
			$.each(messageList.datas,function(index,message){
				var $messageInfo=$("<tr class='data' >"+
									"<td>"+message.messageContent+"</td>"+
									"<td><input class='deleteBtn' messageId='"+message.messageId+"' type='button' value='删除'>"+"</td>"+
									
									"</tr>"
									)
				$("#msgData").append($messageInfo)
			});
		}
	
		//填充总页数
		$("#totalPage").html(totalPage)
		if(totalPage<=0){
			totalPage=1
			$("#totalPage").html(totalPage)
		}
		//填充当前页
		$("#inputPage").val(curPage)
		
	}