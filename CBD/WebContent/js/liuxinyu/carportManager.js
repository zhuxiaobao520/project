var curPage=1;//当前页面
var totalPage=1; //总页数
$(function(){					
	//绑定load加载事件
	var site=$.trim($("#site").val());
	var number=$.trim($("#number").val());
	var status=$.trim($("#rent").val());
	//初始化页面数据（显示第一页）
	$.getJSON("carportSearch",{"site":site,"number":number,"curPage":1,"status":status},getCarportInfo);									
	//首页点击处理
	$("#firstPage").click(function(){	
		var site=$.trim($("#site").val());
		var number=$.trim($("#number").val());
		var status=$.trim($("#rent").val());
		curPage=1;
		$.getJSON("carportSearch",{"site":site,"number":number,"curPage":1,"status":status},getCarportInfo);
	});
	
	//上一页点击处理
	$("#prePage").click(function(){
		var site=$.trim($("#site").val());
		var number=$.trim($("#number").val());
		var status=$.trim($("#rent").val());
		if(curPage>1){
			curPage=curPage-1;
			$.getJSON("carportSearch",{"site":site,"number":number,"curPage":curPage,"status":status},getCarportInfo);
		}
	});
	
	//下一页点击处理
	$("#nextPage").click(function(){
		var site=$.trim($("#site").val());
		var number=$.trim($("#number").val());
		var status=$.trim($("#rent").val());
		if(curPage<totalPage){
			curPage=curPage+1;
			$.getJSON("carportSearch",{"site":site,"number":number,"curPage":curPage,"status":status},getCarportInfo);
		}
	});
	
	//尾页处理
	$("#lastPage").click(function(){
		var site=$.trim($("#site").val());
		var number=$.trim($("#number").val());
		var status=$.trim($("#rent").val());
		curPage=totalPage;
		$.getJSON("carportSearch",{"site":site,"number":number,"curPage":curPage,"status":status},getCarportInfo);
	});
//跳转处理
$("#jump").click(function(){
	var dang=$("#query").val();
	var site=$.trim($("#site").val());
	var number=$.trim($("#number").val());
	var status=$.trim($("#rent").val());
	var data={"site":site,"number":number,"curPage":dang,"status":status};	
	if(dang >0 && dang<=totalPage){
		curPage=dang;
		$.getJSON("carportSearch",data,getCarportInfo);
	}
});
//模糊查询
$("#search").click(function(){
	var site=$.trim($("#site").val());
	var number=$.trim($("#number").val());
	var status=$.trim($("#rent").val());
	var data={"site":site,"number":number,"curPage":1,"status":status};			
	$.getJSON("carportSearch",data,getCarportInfo);
}) 
});


//接收ajax响应分页数据回调函数
function getCarportInfo(carportList){					
	//清空表格
	$("#carportInfo").html("");					
	//获取总页数
     curPage=carportList.currentPage;
     totalPage=carportList.totalPageNum;
	  var List =carportList.datas;
	  if(List!=""){
	//填充表格
      $.each(List,function(index,carport){
    	  $content=("<div>"
    			   +"<img style='width: 130px;height: 100px; border: 1px solid black;' src='/CBD/image/car.jpg' >"
    			   +"<div style='left: 150px; top:-80px; position: relative;' class='title'>"
    			   +"<li class='clearfix'>"
    			   +"<span >"+carport.cbdCarportAddress+"</span><br>"
    			   +" <span>车位编号：</span>"+carport.cbdCarportAddressNo+"</li></div></div><hr style='top: -30px; position: relative;'>")
    	           $("#carportInfo").append($content)
      })
	  }else{
		  $("#carportInfo").append("<div><h1>无任何车辆信息</h1></div>")
	  }
	$("#query").val(curPage);//当前页数
	
	$("#total").html("/"+totalPage);//总页数
}
